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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author brand
 */
public class UNi_CHOController implements Initializable {

     TravelManDataBase DataBase= new TravelManDataBase();
  HashMap<Integer,ArrayList<String>>myUnidades_Choferes=null;
  HashMap<Integer,ArrayList<String>>myMap;
  HashMap<Integer,ArrayList<String>>myMap_Information;
    HashMap<Integer,ArrayList<String>>NombreChoferes=null;
    
    int x;
    @FXML
    private Button Button_UniChoferSave_U;
    @FXML
    private Button Button_UniChoferEdite_U;
    @FXML
    private TableView<ChoferesyUnidad> TableviewChoyUNI;
    @FXML
    private TableColumn TableviewColumn1;
    @FXML
    private TableColumn TableviewColumn2;
    @FXML
    private TableColumn TableviewColumn3;
    @FXML
    private TableColumn TableviewColumn4;
    @FXML
    private TextField TextFieldUnidadCU;
    @FXML
    private TextField TextFieldmarcaCU;
    @FXML
    private ComboBox<String> ComboChofer1;
    @FXML
    private ComboBox<String> ComboChofer2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        NombreChoferes =DataBase.GetChoferes();
        Table3();
        
        ComboChofer1.getItems().clear();
        ComboChofer2.getItems().clear();
        
        for(int i=1;i<=NombreChoferes.size();i++){
        ComboChofer1.getItems().add(NombreChoferes.get(i).get(1));
        
         ComboChofer2.getItems().add(NombreChoferes.get(i).get(1));
        }
        
        ComboChofer1.getSelectionModel().selectFirst();
        ComboChofer2.getSelectionModel().selectFirst();
       
    }    
    
    
    
    
    
    public void Table3(){
     
     
     
    ObservableList<ChoferesyUnidad>Infotable=FXCollections.observableArrayList();
   
    TableviewColumn1.setCellValueFactory(new PropertyValueFactory<ChoferesyUnidad,String>("Unidad"));
    TableviewColumn2.setCellValueFactory(new PropertyValueFactory<ChoferesyUnidad,String>("Marca"));
    TableviewColumn3.setCellValueFactory(new PropertyValueFactory<ChoferesyUnidad,String>("Chofer1"));
    TableviewColumn4.setCellValueFactory(new PropertyValueFactory<ChoferesyUnidad,String>("Chofer2"));
    
    TableviewColumn1.setText("Unidad");
    TableviewColumn2.setText("Marca");
    TableviewColumn3.setText("Chofer1");
   TableviewColumn4.setText("Chofer2");
  
    myMap=  DataBase.SearchAll_UNIChofer();
    int size=myMap.size();
    
        for(int i=1;i<=size;i++){
      Infotable.add(new ChoferesyUnidad(myMap.get(i).get(0),myMap.get(i).get(1),myMap.get(i).get(2),myMap.get(i).get(3)));
         }
        TableviewChoyUNI.getColumns().clear();
        TableviewChoyUNI.setItems(Infotable);
        TableviewChoyUNI.getColumns().addAll(TableviewColumn1,TableviewColumn2,TableviewColumn3,TableviewColumn4);
            
     
     
     }
    
    
    public void Clickrowtable(){
    
    
        
    x = TableviewChoyUNI.getSelectionModel().getSelectedIndex();
    
   TextFieldUnidadCU.setText(myMap.get(x+1).get(0));
 TextFieldmarcaCU.setText(myMap.get(x+1).get(1));
  ComboChofer1.getSelectionModel().select(myMap.get(x+1).get(2));
   ComboChofer2.getSelectionModel().select(myMap.get(x+1).get(3));
    
     
    }
    
    
    
    
    public void SaveChoyUnibutton(){
   DataBase.insert_CH12(x+1,ComboChofer1.getSelectionModel().getSelectedIndex(),ComboChofer2.getSelectionModel().getSelectedIndex());
   Table3();
   clear();
    }
    
    
    public void clear(){
    TextFieldUnidadCU.setText("");
    TextFieldmarcaCU.setText("");
    ComboChofer1.getSelectionModel().selectFirst();
    ComboChofer2.getSelectionModel().selectFirst();
    }
    
    
    
    public class ChoferesyUnidad{
    
    private  String Unidad ;
         private String Marca ;
         private  String Chofer1 ;
    private  String Chofer2 ;
    
     public ChoferesyUnidad(String Unidad,String Marca,String Chofer1,String Chofer2) {
            this.Unidad = Unidad;
            this.Marca  = Marca;
            this.Chofer1 = Chofer1;
           this.Chofer2 = Chofer2;
            
        }
     
      public String getUnidad() {
            return this.Unidad;
        }
 
        public void setUnidad(String Unidad) {
             this.Unidad=Unidad;
        }
     
      public String getMarca() {
            return this.Marca;
        }
 
        public void setMarca(String Marca) {
             this.Marca=Marca;
        }
    
         public String getChofer1() {
            return this.Chofer1;
        }
 
        public void setChofer1(String Chofer1) {
             this.Chofer1=Chofer1;
        }
        
    public String getChofer2() {
            return this.Chofer2;
        }
 
        public void setChofer2(String Chofer2) {
             this.Chofer2=Chofer2;
        }
    }
    
    
    
    
    
    
    
}
