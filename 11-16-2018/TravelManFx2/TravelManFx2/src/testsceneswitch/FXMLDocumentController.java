    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author j_cas
 */
public class FXMLDocumentController implements Initializable {
    TravelManDataBase DasaBase=new TravelManDataBase();
    Config_ajustes Save_User=new Config_ajustes();
    Object[]b;
    @FXML
    private Label label;
     @FXML
    private  TextField User;
     @FXML
    private  TextField Pass;
    @FXML
    private Button Login_Start;
    @FXML
  
    private void handleButtonAction(ActionEvent event) {
        if(User.getText().isEmpty()||Pass.getText().isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setHeaderText(null);
            alert.setContentText("El usuario o contrasena estan vacios!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));   
            stage.getIcons().add(icon);
            alert.showAndWait();
        }else{ 
            Object[]A;
            Stage Connections_Stage;
            Parent Principal_Parent;
            File f = new File(System.getProperty("user.home")+"\\TravelMan"+"\\config.properties");
            System.out.println(System.getProperty("user.home")+"\\TravelMan"+"\\config.properties");
            if(f.exists()==true){
                A= DasaBase.TestConnection_1();
                
                    if((boolean)A[0]==false){    //if it fails           
                        try {
                            Connections_Stage=new Stage();
                            Principal_Parent=FXMLLoader.load(getClass().getResource("Connections_Settings.fxml"));
                            Connections_Stage.setScene(new Scene(Principal_Parent));
                            Connections_Stage.initModality(Modality.APPLICATION_MODAL);
                            Connections_Stage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
                            Connections_Stage.setTitle("Configuracion de conexión");
                            Connections_Stage.setResizable(false);
                            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Connection.png"));
                            Connections_Stage.getIcons().add(icon);
                            Connections_Stage.showAndWait();
                        }catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        
                        /*Aqui pasa todo lo importante de logueo para poder agrega el enter.*/
                        System.out.println("entered this shit");
                        DasaBase.Check_Users();
                        
                        b= DasaBase.Checkusers(User.getText(),Pass.getText());
                        if(Boolean.TRUE.equals(b[0])){
                                if(Boolean.TRUE.equals(b[6])){
                                    try{
                                        Save_User.LoadProperties();
                                        Save_User.setPropertiesValues("UserID", b[1].toString());
                                        Save_User.storeproperties();
                                        Principal_Parent=FXMLLoader.load(getClass().getResource("Principal.fxml"));
                                        Scene Principal_Pagescene=new Scene(Principal_Parent);
                                        Stage App_Stage=(Stage)((Node) event.getSource()).getScene().getWindow();
                                        App_Stage.hide();
                                        App_Stage.setScene(Principal_Pagescene);
                                        App_Stage.setTitle("Agendar");
                                        App_Stage.setResizable(false);
                                        App_Stage.sizeToScene(); 
                                        App_Stage.getIcons().clear();
                                        Image Test = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Travel.png"));
                                        App_Stage.getIcons().add(Test); 
                                        App_Stage.show();
                                        App_Stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                                        public void handle(WindowEvent we) {
                                            try {
                                                Parent HomePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                                                Scene scene = new Scene(HomePage);
                                                Stage stage=new Stage();
                                                stage.setScene(scene);
                                                stage.setTitle("Inicio de sesión");
                                                Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/login.png"));
                                                stage.getIcons().add(icon);
                                                stage.show();
                                                App_Stage.close();
                                            }catch (IOException ex) {
                                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        });  
                                    }catch (IOException ex) {
                                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }else{
                                    Alert alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Alerta!");
                                    alert.setHeaderText(null);
                                    alert.setContentText("La cuenta de ususario se encuentra inactiva.\nContacte a su superior inmediato!");
                                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                                    Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
                                    stage.getIcons().add(icon);
                                    alert.showAndWait();
                                }
                        }else{
                            System.out.println("fallo");
                            label.setText("Credenciales incorrectos!");
                           Message("Usuario o contrasena incorrectos");
                        }
                    }
            }else{
                try {
                    Connections_Stage=new Stage();
                    Principal_Parent=FXMLLoader.load(getClass().getResource("Connections_Settings.fxml"));
                    Connections_Stage.setScene(new Scene(Principal_Parent));
                    Connections_Stage.initModality(Modality.APPLICATION_MODAL);
                    Connections_Stage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
                    Connections_Stage.setTitle("Configuracion de conexión");
                    Connections_Stage.setResizable(false);
                    Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Connection.png"));
                    Connections_Stage.getIcons().add(icon);
                    Connections_Stage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        } 
    }
    @FXML
    private void handleKeyPress(KeyEvent e) {
       
        if(e.getCode().equals(KeyCode.ENTER)){
             if(User.getText().isEmpty()||Pass.getText().isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setHeaderText(null);
            alert.setContentText("El usuario o contrasena estan vacios!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));   
            stage.getIcons().add(icon);
            alert.showAndWait();
        }else{ 
            Object[]A;
            Stage Connections_Stage;
            Parent Principal_Parent;
            File f = new File(System.getProperty("user.home")+"\\TravelMan"+"\\config.properties");
            if(f.exists()==true){
                A= DasaBase.TestConnection_1();
                
                    if((boolean)A[0]==false){    //if it fails           
                        try {
                            Connections_Stage=new Stage();
                            Principal_Parent=FXMLLoader.load(getClass().getResource("Connections_Settings.fxml"));
                            Connections_Stage.setScene(new Scene(Principal_Parent));
                            Connections_Stage.initModality(Modality.APPLICATION_MODAL);
                            Connections_Stage.initOwner((Stage)((Node) e.getSource()).getScene().getWindow());
                            Connections_Stage.setTitle("Configuracion de conexión");
                            Connections_Stage.setResizable(false);
                            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Connection.png"));
                            Connections_Stage.getIcons().add(icon);
                            Connections_Stage.showAndWait();
                        }catch (IOException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        
                        /*Aqui pasa todo lo importante de logueo para poder agrega el enter.*/
                        System.out.println("entered this shit");
                        DasaBase.Check_Users();
                        
                        b= DasaBase.Checkusers(User.getText(),Pass.getText());
                        if(Boolean.TRUE.equals(b[0])){
                                if(Boolean.TRUE.equals(b[6])){
                                    try{
                                        Save_User.LoadProperties();
                                        Save_User.setPropertiesValues("UserID", b[1].toString());
                                        Save_User.storeproperties();
                                        Principal_Parent=FXMLLoader.load(getClass().getResource("Principal.fxml"));
                                        Scene Principal_Pagescene=new Scene(Principal_Parent);
                                        Stage App_Stage=(Stage)((Node) e.getSource()).getScene().getWindow();
                                        App_Stage.hide();
                                        App_Stage.setScene(Principal_Pagescene);
                                        App_Stage.setTitle("Agendar");
                                        App_Stage.setResizable(false);
                                        App_Stage.sizeToScene(); 
                                        App_Stage.getIcons().clear();
                                        Image Test = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Travel.png"));
                                        App_Stage.getIcons().add(Test); 
                                        App_Stage.show();
                                        App_Stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                                        public void handle(WindowEvent we) {
                                            try {
                                                Parent HomePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                                                Scene scene = new Scene(HomePage);
                                                Stage stage=new Stage();
                                                stage.setScene(scene);
                                                stage.setTitle("Inicio de sesión");
                                                Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/login.png"));
                                                stage.getIcons().add(icon);
                                                stage.show();
                                                App_Stage.close();
                                            }catch (IOException ex) {
                                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        });  
                                    }catch (IOException ex) {
                                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }else{
                                    Alert alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Alerta!");
                                    alert.setHeaderText(null);
                                    alert.setContentText("La cuenta de ususario se encuentra inactiva.\nContacte a su superior inmediato!");
                                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                                    Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
                                    stage.getIcons().add(icon);
                                    alert.showAndWait();
                                }
                        }else{
                            label.setText("Credenciales incorrectos!");
                            
                             Message("Usuario o contrasena incorrectos");
                        }
                    }
            }else{
                try {
                    Connections_Stage=new Stage();
                    Principal_Parent=FXMLLoader.load(getClass().getResource("Connections_Settings.fxml"));
                    Connections_Stage.setScene(new Scene(Principal_Parent));
                    Connections_Stage.initModality(Modality.APPLICATION_MODAL);
                    Connections_Stage.initOwner((Stage)((Node) e.getSource()).getScene().getWindow());
                    Connections_Stage.setTitle("Configuracion de conexión");
                    Connections_Stage.setResizable(false);
                    Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Connection.png"));
                    Connections_Stage.getIcons().add(icon);
                    Connections_Stage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        }
    }
    
    
public void Message(String x){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setHeaderText(null);
            alert.setContentText(x);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
            stage.getIcons().add(icon);
            alert.showAndWait();
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
  }    
 
