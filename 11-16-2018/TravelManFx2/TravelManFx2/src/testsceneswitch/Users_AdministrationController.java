/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author j_cas
 */
public class Users_AdministrationController implements Initializable {
    TravelManDataBase DataBase= new TravelManDataBase();//Loads methods of the database class
    HashMap<Integer,ArrayList<String>>BuscarUsuarios=null;
    int UserID=0;
    @FXML
    private TextField TextF_UserName;
    @FXML
    private Button Search_Users;
    @FXML
    private Button Update_User;
    @FXML
    private Button Clear_User;
    @FXML
    private TableView<Person> User_Table;
    @FXML
    private TableColumn  FirstColumn;
    @FXML
    private TableColumn  SecondColumn;
    @FXML
    private TextField Name_Text;
    @FXML
    private TextField User_Text;
    @FXML
    private TextField Email_Text;
    @FXML
    private CheckBox Admin__Access;
    @FXML
    private CheckBox Role_Access;
    @FXML
    private CheckBox Unidad_Access;
    @FXML
    private CheckBox Report_Access;
    @FXML
    private PasswordField User_Pass;
    @FXML
    private PasswordField Pass_Confirm;
    @FXML
    private CheckBox Active_Account;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
   

    
    
    
    @FXML
    public void BuscarUsuarios(){
         ObservableList<Person>persona=FXCollections.observableArrayList();
        FirstColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("Nombre"));
    
        SecondColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("Nombre_Usuario"));
     
        BuscarUsuarios=DataBase.search_users(TextF_UserName.getText());
        int Size=BuscarUsuarios.size();
        System.out.println("Size "+Size);
        
        for(int i=1;i<=BuscarUsuarios.size();i++){
            persona.add(new Person(BuscarUsuarios.get(i).get(1),BuscarUsuarios.get(i).get(2)));
        }
           User_Table.setItems(persona);
           User_Table.getColumns().clear();
           User_Table.getColumns().addAll(FirstColumn, SecondColumn);
    }

   
    @FXML
    public void HandleTableSelection(){
      
        User_Table.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                try{
                LoadUserData(User_Table.getSelectionModel().getSelectedIndex());
                }catch(NullPointerException e){
             System.out.print("NullPointerException caught");
        }
            }
        });
      
    }
    public void LoadUserData(int User){
         Admin__Access.setSelected(false);
          Role_Access.setSelected(false);
          Unidad_Access.setSelected(false);
          Report_Access.setSelected(false);
          UserID=Integer.parseInt(BuscarUsuarios.get(User+1).get(0));
        Name_Text.setText(BuscarUsuarios.get(User+1).get(1));
        User_Text.setText(BuscarUsuarios.get(User+1).get(2));
        Email_Text.setText(BuscarUsuarios.get(User+1).get(4));
        System.out.println("data "+BuscarUsuarios.get(User+1).get(5).getClass());
        if(BuscarUsuarios.get(User+1).get(5).equals("true")){
             Admin__Access.setSelected(true);
        }
        if(BuscarUsuarios.get(User+1).get(7).equals("true")){
            Role_Access.setSelected(true);
        }
       if( BuscarUsuarios.get(User+1).get(8).equals("true")){
           Unidad_Access.setSelected(true);
        }
        if( BuscarUsuarios.get(User+1).get(9).equals("true")){
           Active_Account.setSelected(true);
        }
       if( BuscarUsuarios.get(User+1).get(6).equals("true")){
           Report_Access.setSelected(true);
       }
       
    }
    
    
    @FXML
    public void ClearUserSelection(){
          Admin__Access.setSelected(false);
          Role_Access.setSelected(false);
          Unidad_Access.setSelected(false);
          Report_Access.setSelected(false);
          Name_Text.clear();
          User_Text.clear();
          Email_Text.clear();
          User_Pass.clear();
          Pass_Confirm.clear();
          UserID=0;
          TextF_UserName.clear();
          Active_Account.setSelected(false);
          
    }
    
    @FXML
    public void Save_Update_Users(){
        Boolean a=null;
        if(Name_Text.getText().isEmpty()==false&&Email_Text.getText().isEmpty()==false&&User_Pass.getText().isEmpty()==false&&Pass_Confirm.getText().isEmpty()==false){
             String patternString = ".*\\d.*";
             
             Pattern pattern = Pattern.compile(patternString); 
             if(pattern.matcher(User_Pass.getText()).matches()==true&&User_Pass.getText().matches("[a-zA-Z0-9]+")==true&&User_Pass.getText().length()>=8&&User_Pass.getText().equals(Pass_Confirm.getText())==true){
                if(UserID==0){
                    a=DataBase.CreateUser_JavaFX(Name_Text.getText(), User_Text.getText(), User_Pass.getText(),Email_Text.getText(),Admin__Access.isSelected(),Role_Access.isSelected(),Unidad_Access.isSelected(),Report_Access.isSelected(),Active_Account.isSelected());
                    if(a==true){
                        ShowMessage("Se ha creado el usuario exitosamente!");
                        ClearUserSelection();
                    }else{
                        ShowMessage("Ya existe el nombre de usuario!");
                    }
                }else if(UserID>0){
                    a=DataBase.Update_Users(UserID,Name_Text.getText(), User_Text.getText(), User_Pass.getText(),Email_Text.getText(),Admin__Access.isSelected(),Role_Access.isSelected(),Unidad_Access.isSelected(),Report_Access.isSelected(),Active_Account.isSelected());
                    if(a==true){
                        ShowMessage("Se ha actualizado al información!!");
                        ClearUserSelection();
                    }
             }
                
            }else{
                ShowMessage("La contraseña debe contener:\n1. Al menos un numéro\n2. Al menos una letra\n3. Un minimo de 8 carácteres\n4. La clave de coincidir con la confirmación");
            }
        }else if(Name_Text.getText().isEmpty()==false&&Email_Text.getText().isEmpty()==false&&User_Pass.getText().isEmpty()==true&&Pass_Confirm.getText().isEmpty()==true&&UserID>0){
            a=DataBase.Update_UsersNoPass(UserID,Name_Text.getText(), User_Text.getText(),Email_Text.getText(),Admin__Access.isSelected(),Role_Access.isSelected(),Unidad_Access.isSelected(),Report_Access.isSelected(),Active_Account.isSelected());
            if(a==true){
                        ShowMessage("Se ha actualizado al información!!");
                        ClearUserSelection();
                    }
        }
        else{
            ShowMessage("Un error!");
        }
    }
    
    public void ShowMessage(String x){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alerta!");
                alert.setHeaderText(null);
                alert.setContentText(x);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
                stage.getIcons().add(icon);
                alert.showAndWait();
    }
 public  class Person {
 
         private  String Nombre;
        private String Nombre_Usuario;
 
      public Person(String fName, String lName) {
            this.Nombre = fName;
            this.Nombre_Usuario = lName;
        }
 
        public String getNombre() {
            return Nombre;
        }
 
        public void setNombre(String fName) {
            Nombre=fName;
        }
 
        public String getNombre_Usuario() {
            return Nombre_Usuario;
        }
 
        public void setNombre_Usuario(String fName) {
            Nombre_Usuario=fName;
        }
}
}
