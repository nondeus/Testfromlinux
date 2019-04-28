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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author brand
 */
public class UnidadesController implements Initializable {

      TravelManDataBase DataBase= new TravelManDataBase();
  HashMap<Integer,ArrayList<String>>myUnidades_Choferes=null;
  HashMap<Integer,ArrayList<String>>myMap;
  HashMap<Integer,ArrayList<String>>myMap_Information;
    int x;
    int UnidadIDBasedeDatos;
    
    @FXML
    private RadioButton Estado_Funcional_UR;
    @FXML
    private ToggleGroup Estado_UR;
    @FXML
    private RadioButton Estado_Taller_UR;
    @FXML
    private RadioButton Aire_A_UR_Si;
    @FXML
    private ToggleGroup Aire_a_U;
    @FXML
    private RadioButton Aire_A_UR_No;
    @FXML
    public ComboBox<String> ComboUnidad;
    @FXML
    public TextField TextfieldUnidad_U;
    @FXML
    private AnchorPane ANPaneUnidad;
    @FXML
    private Pane MainPaneU;
    @FXML
    private Button ButtonSave_U;
    @FXML
    private Button ButtonEdite_U;
    @FXML
    private TableView<Unidades> TableviewUnidad;
    @FXML
    private TableColumn TableColumn1;
    @FXML
    private TableColumn TableColumn2;
    @FXML
    private TableColumn TableColumn3;
    @FXML
    private TableColumn TableColumn4;
    @FXML
    private TableColumn TableColumn5;
    @FXML
    private TableColumn TableColumn6;
    @FXML
    private TextField TextfieldMarca_U;
    @FXML
    private TextField TextfieldPasajero_U;
    @FXML
    private TextField TextfieldProvedor_U;
    private ComboBox<String> ComboProvedor;
    @FXML
    private Label LabelProvedor;
    @FXML
    private TableColumn TableColumn7;
    @FXML
    private TableColumn TableColumn8;
    @FXML
    private TableColumn TableColumn9;
    @FXML
    private CheckBox Bano;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboUnidad.getItems().addAll("Microbus", "Buseta", "Autobus");
        ComboUnidad.getSelectionModel().selectFirst();
        Table();
        TextfieldUnidad_U.setTextFormatter(new TextFormatter(TextSettup(5)));
        Aire_A_UR_Si.setUserData("Si");
        Aire_A_UR_No.setUserData("No");
        Estado_Taller_UR.setUserData("Taller");
        Estado_Funcional_UR.setUserData("Funcional");
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
   public void SaveUnidadB(){
       String Toilet;
       if(Bano.isSelected()==true){
           Toilet="Si";
       }else{
           Toilet="No";
       }
   x=DataBase.InsertUnidad(TextfieldUnidad_U.getText(),TextfieldMarca_U.getText(),ComboUnidad.getSelectionModel().getSelectedItem(),Aire_a_U.getSelectedToggle().getUserData().toString(),Estado_UR.getSelectedToggle().getUserData().toString(),Integer.parseInt(TextfieldPasajero_U.getText()),TextfieldProvedor_U.getText(),Toilet);
   if(x==0){
       Message("Porfavor verifique los datos!");
   }else if(x==1){
       Message("Unidad ha sido registrada!");
   }
   x=0;
   Table();
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
    public void Table(){
   
    ObservableList<Unidades>Infotable=FXCollections.observableArrayList();
   
    TableColumn1.setCellValueFactory(new PropertyValueFactory<Unidades,String>("Unidad"));
    TableColumn2.setCellValueFactory(new PropertyValueFactory<Unidades,String>("Marca"));
    TableColumn3.setCellValueFactory(new PropertyValueFactory<Unidades,String>("Tipo"));
    TableColumn4.setCellValueFactory(new PropertyValueFactory<Unidades,String>("Aireacondicionado"));
    TableColumn5.setCellValueFactory(new PropertyValueFactory<Unidades,String>("Estado"));
    TableColumn6.setCellValueFactory(new PropertyValueFactory<Unidades,String>("Pasajeros"));
    TableColumn7.setCellValueFactory(new PropertyValueFactory<Unidades,String>("UnidadID"));
    TableColumn8.setCellValueFactory(new PropertyValueFactory<Unidades,String>("NombreProveedor"));
    TableColumn1.setText("Unidad");
    TableColumn2.setText("Marca");
    TableColumn3.setText("Tipo");
    TableColumn4.setText("Aireacondicionado");
    TableColumn5.setText("Estado");
    TableColumn6.setText("Pasajeros");
    myMap=  DataBase.SearchAllUnidad();
    int size=myMap.size();
    
        for(int i=1;i<=size;i++){
      Infotable.add(new Unidades(myMap.get(i).get(0),myMap.get(i).get(1),myMap.get(i).get(2),myMap.get(i).get(3),
      myMap.get(i).get(4),myMap.get(i).get(5),Integer.parseInt(myMap.get(i).get(6)),myMap.get(i).get(7),myMap.get(i).get(8))); 
         }
            TableviewUnidad.setItems(Infotable);
            TableviewUnidad.getColumns().clear();
            TableviewUnidad.getColumns().addAll(TableColumn1,TableColumn2,TableColumn3,TableColumn4,TableColumn5,TableColumn6,TableColumn7,TableColumn8);
           
    }
    
    @FXML
    public void ClickRowTableUnidades(){
    Unidades obj=TableviewUnidad.getSelectionModel().getSelectedItem();
    /* x = TableviewUnidad.getSelectionModel().getSelectedIndex();*/
     UnidadIDBasedeDatos=obj.getUnidadID();
    TextfieldUnidad_U.setText(obj.getUnidad());
    TextfieldMarca_U.setText(obj.getMarca());
    ComboUnidad.getSelectionModel().select(obj.getTipo());
     if(obj.getAireacondicionado().equals("Si")){
                        Aire_A_UR_Si.setSelected(true);
                    }else{
                        Aire_A_UR_No.setSelected(true);
                    }
     
     if(obj.Estado.equals("Funcional")){
                        Estado_Funcional_UR.setSelected(true);
                    }else{
                        Estado_Taller_UR.setSelected(true);
                    }
    TextfieldPasajero_U.setText(obj.Pasajeros);
       
    TextfieldProvedor_U.setText(obj.GetNombreProveedor());
    if(obj.GetBano().equals("Si")){
        Bano.setSelected(true);
    }else{
        Bano.setSelected(false);
    }
    }
    
    
    @FXML
    public void EditUnidadB(){
        System.out.println("x  "+x);
         String Toilet;
       if(Bano.isSelected()==true){
           Toilet="Si";
       }else{
           Toilet="No";
       }
    int x=DataBase.Update_Unidad(UnidadIDBasedeDatos,TextfieldUnidad_U.getText(),TextfieldMarca_U.getText(),ComboUnidad.getSelectionModel().getSelectedItem(),Aire_a_U.getSelectedToggle().getUserData().toString(),Estado_UR.getSelectedToggle().getUserData().toString(),Integer.parseInt(TextfieldPasajero_U.getText()),TextfieldProvedor_U.getText(),Toilet);
    if(x==1){
       Message("Datos actualizados"); 
    }
    UnidadIDBasedeDatos=0;
    Table();
    clear();
    }
    
    
 
    
    public void clear(){
    
    TextfieldUnidad_U.setText("");
    TextfieldMarca_U.setText("");
    
    Estado_Funcional_UR.setSelected(true);
    Aire_A_UR_Si.setSelected(true);
    
    ComboUnidad.getSelectionModel().selectFirst();
    TextfieldPasajero_U.clear();
    TextfieldProvedor_U.clear();
    }
    
    
    
    
    
    
    
    
    
     public  class Unidades {
         private  String Unidad ;
         private String Marca ;
         private  String Tipo ;
         private String Aireacondicionado;
         private   String Estado;
         private  String Pasajeros ;
         private int UnidadID;
         private String NombreProveedor;
         private String Bano;
      public Unidades(String Unidad,String Marca,String Tipo,String Aireacondicionado,String Estado,String Pasajeros,int UnidadID,String NombreProveedor,String bano) {
            this.Unidad = Unidad;
            this.Marca  = Marca;
            this.Tipo = Tipo;
            this.Aireacondicionado =Aireacondicionado;
            this.Estado = Estado;
            this.Pasajeros  = Pasajeros;
            this.UnidadID=UnidadID;
            this.NombreProveedor=NombreProveedor;
            this.Bano=bano;
        }
      
        public String GetBano(){
            return this.Bano;
        }
        public void SetBano(String bano){
            this.Bano=bano;
        }
        public String getUnidad() {
            return this.Unidad;
        }
 
        public void setUnidad(String Unidad) {
             this.Unidad=Unidad;
        }
        
          public String getMarca() {
            return  this.Marca ;
        }
 
        public void setMarca(String Marca) {
             this.Marca =Marca;
        }
        
        
            public String getTipo() {
            return  this.Tipo ;
        }
 
        public void setTipo(String Tipo) {
             this.Tipo =Tipo;
        }
        
          public String getAireacondicionado(){
          return  this.Aireacondicionado;
           }
        
        public void setAireacondicionado(String Aireacondicionado){
            this.Aireacondicionado=Aireacondicionado;
        }
        
        public String getEstado(){
        return  this.Estado;
        
        }
        public void setEstado(String Estado){
         this.Estado=Estado;
         }
        
        public String getPasajeros(){
        return  this.Pasajeros;
        }
        
        public void setPasajeros(String Pasajeros){
         this.Pasajeros=Pasajeros;
        
        }
        public void setUnidadID(int UNID){
         this.UnidadID=UNID;
        
        }
        public int getUnidadID(){
            return this.UnidadID;
        }
     
        public void SetNombreProveedor(String NombreProveedor){
          this.NombreProveedor=NombreProveedor;
        }
        public String GetNombreProveedor(){
            return this.NombreProveedor;
        }
} 
    
    
    
    
   
}
