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
import java.util.function.UnaryOperator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author brand
 */
public class ChoferesController implements Initializable {

      TravelManDataBase DataBase= new TravelManDataBase();
  HashMap<Integer,ArrayList<String>>myUnidades_Choferes=null;
  HashMap<Integer,ArrayList<String>>myMap;
  HashMap<Integer,ArrayList<String>>myMap_Information;
  int PosicionDeChofer=0;
    int x;
    
    
    @FXML
    private Button Button_ChoferSave_U;
    @FXML
    private Button Button_ChoferEdite_U;
    @FXML
    private TableView<Choferes> TableviewChofer;
    @FXML
    private TableColumn Tablecolumn1;
    @FXML
    private TableColumn Tablecolumn2;
    @FXML
    private TableColumn Tablecolumn3;
    @FXML
    private TextField TextFieldNameC;
    @FXML
    private TextField TextFieldCelularC;
    @FXML
    private TextField TextFieldCorreoC;
    @FXML
    private CheckBox DispobibleCH;
    @FXML
    private TableColumn Tablecolumn4;
    @FXML
    private TableColumn Tablecolumn5;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Table2();
         TextFieldCelularC.setTextFormatter(new TextFormatter(TextSettup(9)));
    }    
    
    
    
    
    
    
    
    
    
    public void Table2(){
   
    ObservableList<Choferes>Infotable=FXCollections.observableArrayList();
   
    Tablecolumn1.setCellValueFactory(new PropertyValueFactory<Choferes,String>("Nombre"));
    Tablecolumn2.setCellValueFactory(new PropertyValueFactory<Choferes,String>("Celular"));
    Tablecolumn3.setCellValueFactory(new PropertyValueFactory<Choferes,String>("Correo"));
    Tablecolumn4.setCellValueFactory(new PropertyValueFactory<Choferes,String>("ID"));
    Tablecolumn5.setCellValueFactory(new PropertyValueFactory<Choferes,String>("Disponible"));
    Tablecolumn1.setText("Nombre");
    Tablecolumn2.setText("Celular");
    Tablecolumn3.setText("Correo");
    
  
    myMap=  DataBase.SearchAllChoferes();
    int size=myMap.size();
        
        
            for(int i=1;i<=size;i++){
                
                if(i>1){
                    
                    Infotable.add(new Choferes(myMap.get(i).get(0),myMap.get(i).get(1),myMap.get(i).get(2),Integer.parseInt(myMap.get(i).get(4)),Integer.parseInt(myMap.get(i).get(3))));
                }
            }
            TableviewChofer.getColumns().clear();
            TableviewChofer.setItems(Infotable);
            TableviewChofer.getColumns().addAll(Tablecolumn1,Tablecolumn2,Tablecolumn3);
        
        
    }
    
    
    
    
     public UnaryOperator<TextFormatter.Change>  TextSettup(int len){
  
   UnaryOperator<TextFormatter.Change> rejectChange = c -> {
    // check if the change might effect the validating predicate
    if (c.isContentChange()) {
        // check if change is valid
        if (c.getControlNewText().length() > len) {
            // invalid change
            // sugar: show a context menu with error message
            final ContextMenu menu = new ContextMenu();
            menu.getItems().add(new MenuItem("Este campo solo toma\n"+len+" caracteres."));
            menu.show(c.getControl(), Side.BOTTOM, 0, 0);
            // return null to reject the change
            return null;
        }
    }
    // valid change: accept the change by returning it
    return c;
};
        return rejectChange;
}
    
    
    
    @FXML
 public void ClickrowTable(){
    ;
 Choferes obj=TableviewChofer.getSelectionModel().getSelectedItem();
        
 PosicionDeChofer=(Integer)obj.getID();
        /*System.out.println("dato "+(String)obj);*/

  x = TableviewChofer.getSelectionModel().getSelectedIndex();
        System.out.println("selected row "+x);
 
  TextFieldNameC.setText(obj.getNombre());
  TextFieldCelularC.setText(obj.getCelular());
  TextFieldCorreoC.setText(obj.getCorreo());
        
 int y=obj.getDISP();
 if(y==0){
     DispobibleCH.setSelected(false);
 } else{
     DispobibleCH.setSelected(true);
 }
        
 }
    
    
    @FXML
    public void SaveChofferbutton(){
    int x=DataBase.InsertChoferes(TextFieldNameC.getText(),TextFieldCelularC.getText(),TextFieldCorreoC.getText(),DispobibleCH.isSelected());
    if(x==0){
        Message("El chofer ya se encuentra registrado!");
        x=0;
    }
    Table2();
    clear();
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
    @FXML
    public void EditedChoferbutton(){
        
    DataBase.Update_Choferes(PosicionDeChofer,TextFieldNameC.getText(),TextFieldCelularC.getText(),TextFieldCorreoC.getText(),DispobibleCH.isSelected());
    PosicionDeChofer=0;
       
    Table2();
    clear();
    }
    
    public void clear(){
    TextFieldNameC.setText("");
    TextFieldCelularC.setText("");
    TextFieldCorreoC.setText("");
    }
    
     public class Choferes{
    
    private  String Nombre ;
         private String Celular ;
         private  String Correo ;
         private  int ID ;
         private int Disponible;
    
     public Choferes(String Nombre,String Celular,String Correo,int ID,int Disponible) {
            this.Nombre = Nombre;
            this.Celular  = Celular;
            this.Correo = Correo;
           this.ID=ID;
            this.Disponible=Disponible;
        }
     
        public String getNombre() {
            return this.Nombre;
        }
 
        public void setNombre(String Nombre) {
             this.Nombre=Nombre;
        }
     
      public String getCelular() {
            return this.Celular;
        }
 
        public void setCelular(String Celular) {
             this.Celular=Celular;
        }
    
        public String getCorreo() {
            return this.Correo;
        }
 
        public void setCorreo(int ID) {
             this.Correo=Correo;
        }
         public int getID() {
            return this.ID;
        }
 
        public void setID(int ID) {
             this.ID=ID;
        }
        public void setDISP(int DISP){
            this.Disponible=DISP;
        }
        public int getDISP() {
            return this.Disponible;
        }
        
    }
    
    
}
