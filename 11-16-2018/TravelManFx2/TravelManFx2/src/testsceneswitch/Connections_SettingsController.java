/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author j_cas
 */
public class Connections_SettingsController implements Initializable {
    TravelManDataBase DataBase=new TravelManDataBase();
    Config_ajustes SaveSettings=new Config_ajustes();
    @FXML
    private Button Save_Conection;
    @FXML
    private TextField IP_Address;
    @FXML
    private TextField N_Puerto;
    @FXML
    private TextField DB_Usuario;
    @FXML
    private PasswordField DB_Pass;
    @FXML
    private TextField DBName;
    @FXML
    private Button Clear_ConnectionSettings;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadPreviousSettings();
    }    
    
    @FXML
    public void Test_Save_Connection(ActionEvent event){
        String Mensaje= DataBase.TestConnection(DBName.getText(),IP_Address.getText(),N_Puerto.getText(),DB_Usuario.getText(),DB_Pass.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultado de conexión");
        alert.setHeaderText(null);
        alert.setContentText(Mensaje);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Connection.png"));
        stage.getIcons().add(icon);
        alert.showAndWait();
}
    
    public void LoadPreviousSettings(){
       
        if(SaveSettings.LoadProperties_2()==true){
            IP_Address.setText(SaveSettings.GetPropertie("DBIP"));
            DBName.setText(SaveSettings.GetPropertie("DBName"));
            N_Puerto.setText(SaveSettings.GetPropertie("DBPort"));
            DB_Usuario.setText(SaveSettings.GetPropertie("DBUser"));
        }
       
        
    }
    @FXML
    public void Clear_SEttings(){
        IP_Address.clear();
        DBName.clear();
        N_Puerto.clear();
        DB_Usuario.clear();
        DB_Pass.clear();
    }
}
