/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.text.DefaultCaret;

/**
 * FXML Controller class
 *
 * @author brand
 */
public class UnidadyChoferController implements Initializable {
  TravelManDataBase DataBase= new TravelManDataBase();
  HashMap<Integer,ArrayList<String>>myUnidades_Choferes=null;
  HashMap<Integer,ArrayList<String>>myMap;
  HashMap<Integer,ArrayList<String>>myMap_Information;
  int SelectedEmpresaName=0;
  
    @FXML
    private RadioButton RUnidadychoeresUC;
    @FXML
    private ToggleGroup UnidadChoferes;
    @FXML
    private RadioButton RChoferesUC;
    @FXML
    private RadioButton RUnidadesUC;
    @FXML
    private Pane Pane_subscene;
    @FXML
    private TableView TableView_Uni_Cho;
     
    @FXML
    private TableColumn Column_Info;
     @FXML
    private TableColumn Column_Info1;
     @FXML
    private TableColumn Column_Info11;
     @FXML
    private TableColumn Column_Info111;
     @FXML
    private TableColumn Column_Info1111;
    @FXML
    private TableColumn Column_Info11111;
    @FXML
    private Pane  newLoadedPane1;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         LoadPane1();
       
         
         
    }


    @FXML
    public void LoadPane1(){
        try {
           
            
            Pane_subscene.getChildren().clear();
            newLoadedPane1 = FXMLLoader.load(getClass().getResource("Unidades.fxml"));
            Pane_subscene.getChildren().add(newLoadedPane1);
            
        } catch (IOException ex) {
            Logger.getLogger(UnidadyChoferController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      
        
    }    
    
     @FXML
    public void LoadPane2(){
      
        try {
            Pane  newLoadedPane2;
            Pane_subscene.getChildren().clear();
            newLoadedPane2 = FXMLLoader.load(getClass().getResource("Choferes.fxml"));
            Pane_subscene.getChildren().add(newLoadedPane2);
            
        } catch (IOException ex) {
            Logger.getLogger(UnidadyChoferController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
     @FXML
    public void LoadPane3(){
       
        try {
            Pane  newLoadedPane2;
           Pane_subscene.getChildren().clear();
            newLoadedPane2 = FXMLLoader.load(getClass().getResource("UNi_CHO.fxml"));
            Pane_subscene.getChildren().add(newLoadedPane2);
        } catch (IOException ex) {
            Logger.getLogger(UnidadyChoferController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
}
