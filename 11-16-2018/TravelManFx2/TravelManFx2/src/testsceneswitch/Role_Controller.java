/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author brand
 */
public class Role_Controller implements Initializable {
    TravelManDataBase DataBase= new TravelManDataBase();
     
    private Boolean ExcelbP=false;
     String[][] roleychoferes;
    HashMap<Integer,ArrayList<String>>FiltroRole=new HashMap<Integer,ArrayList<String>>();
    HashMap<Integer,ArrayList<String>>FiltroRole2=new HashMap<Integer,ArrayList<String>>();
    
    @FXML
    private DatePicker DesdeDate;
    
    @FXML
    private DatePicker HastaDate;
    
    private WebView WebviewExcel;
    private WebEngine engine;
    
    @FXML
    private AnchorPane Rolewindow;
    @FXML
    private Button Buttonshow;
    @FXML
    private Button ExcelButton;
   
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws ParseException {
    
    if(DesdeDate.getValue()==null||HastaDate.getValue()==null){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alerta!");
            alert.setHeaderText(null);
            alert.setContentText("Porfavor ingrese las fechas para la busqueda!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
            stage.getIcons().add(icon);
            alert.showAndWait();
             ExcelbP=false;
    }else{
         FiltroRole.clear();
         FiltroRole2.clear();
         LocalDate localDate = DesdeDate.getValue();
        LocalDate localDate2 = HastaDate.getValue();
Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
Date date = Date.from(instant);
Date date2 = Date.from(instant2);
         FiltroRole=DataBase.SearchRole_Database(date,date2);
         FiltroRole2=DataBase.SearchRoleSheetOnly(date, date2);
         
         
         
          /*  SimpleDateFormat Original = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat Converted = new SimpleDateFormat("dd/MM/yy hh:mma");
        if(Boolean.TRUE.equals(radiobchofer.isSelected())){
        String HTMLChoffer="<table >" +
"<tr class=\"trs\">" +
"<th>Chofer</th>" +
"<th>Unidad</th>" +
"<th>Destino</th>" +
"<th>Salida</th>" +
"<th>Encargado</th>" +
"<th>Telefono</th>" +
"<th>Fecha y hora</th>" +
"<th>Cobrar</th>" +
"<th>Precio</th>" +
"<th >Pax</th>" +
"<th >Notas</th>" +
"</tr>\n" ;
        
        FiltroRole.clear();
        engine.loadContent("");
        //FiltroRole=DataBase.SearchRole_Database(DesdeDate.getValue(),DesdeDate.getValue());
        LocalDate localDate = DesdeDate.getValue();
        LocalDate localDate2 = HastaDate.getValue();
Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
Date date = Date.from(instant);
Date date2 = Date.from(instant2);
FiltroRole=DataBase.SearchRole_Database(date,date2);
HashMap<Integer,ArrayList<String>>myMap=DataBase.SearchRole_Database(date,date2);
roleychoferes=new String[myMap.size()][12];
 for(int i=1;i<=FiltroRole.size();i++){
 roleychoferes[i-1][0]=myMap.get(i).get(0);
            roleychoferes[i-1][1]=myMap.get(i).get(1);
            roleychoferes[i-1][2]=myMap.get(i).get(2);
            roleychoferes[i-1][3]=myMap.get(i).get(3);
            roleychoferes[i-1][4]=myMap.get(i).get(4);
            roleychoferes[i-1][5]=myMap.get(i).get(5);
            roleychoferes[i-1][6]=myMap.get(i).get(7);
            roleychoferes[i-1][7]=myMap.get(i).get(8);
            roleychoferes[i-1][8]=myMap.get(i).get(9);
            roleychoferes[i-1][9]=myMap.get(i).get(10);
            roleychoferes[i-1][10]=myMap.get(i).get(11);
            
 if((i%2)==0){
 HTMLChoffer+="<tr bgcolor=\"#f2f2f2\">"
                + "<td>"+myMap.get(i).get(0)+"</td>"
                + "<td>"+myMap.get(i).get(1)+"</td>"
                + "<td>"+myMap.get(i).get(2)+"</td>"
                + "<td>"+myMap.get(i).get(3)+"</td>"
                + "<td>"+myMap.get(i).get(4)+"</td>"
                + "<td>"+myMap.get(i).get(5)+"</td>"
                + "<td>"+Converted.format(Original.parse(myMap.get(i).get(7).substring(0,(myMap.get(i).get(7).length()-2))))+"</td>"
         
                + "<td>"+myMap.get(i).get(8)+"</td>"
                + "<td>"+myMap.get(i).get(9)+"</td>"
                + "<td>"+myMap.get(i).get(10)+"</td>"
                + "<td>"+myMap.get(i).get(11)+"</td>"
                + "</tr>";          
 }else{
             HTMLChoffer+="<tr>"
                + "<td>"+myMap.get(i).get(0)+"</td>"
                + "<td>"+myMap.get(i).get(1)+"</td>"
                + "<td>"+myMap.get(i).get(2)+"</td>"
                + "<td>"+myMap.get(i).get(3)+"</td>"
                + "<td>"+myMap.get(i).get(4)+"</td>"
                 + "<td>"+myMap.get(i).get(5)+"</td>"
                 + "<td>"+Converted.format(Original.parse(myMap.get(i).get(7).substring(0,(myMap.get(i).get(7).length()-2))))+"</td>"
                 + "<td>"+myMap.get(i).get(8)+"</td>"
               + "<td>"+myMap.get(i).get(9)+"</td>"
                 + "<td>"+myMap.get(i).get(10)+"</td>"
                 + "<td>"+myMap.get(i).get(11)+"</td>"
                + "</tr>";   
          }  
 
 }

HTMLChoffer+="</table >";

   engine.setUserStyleSheetLocation(getClass().getResource("StylesFx.css").toString());
        engine.loadContent(HTMLChoffer);
        
     
        
        
    }else if(Boolean.TRUE.equals(radiobrol.isSelected())){
LocalDate localDate = DesdeDate.getValue();
LocalDate localDate2 = HastaDate.getValue();
Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
Date date = Date.from(instant);
Date date2 = Date.from(instant2);
FiltroRole.clear();
engine.loadContent("");
        FiltroRole=DataBase.SearchRoleSheetOnly(date, date2);
           HashMap<Integer,ArrayList<String>>myMap= DataBase.SearchRoleSheetOnly(date, date2);
           roleychoferes=new String[myMap.size()][11];
            
            String HTML="<table align=\"left\" >\n" +
"			<tr class=\"trs\">\n" +
"				<th ></th>\n" +
"				<th >Lugar de destino</th>\n" +
"				<th >Precio</th>\n" +
"				<th >Salida</th>\n" +
"				<th >Pax</th>\n" +
"				<th >Horario</th>\n" +
"				<th >Cliente</th>\n" +
"				<th >Telefono</th>\n" +
"				<th >Unidad</th>\n" +
"			</tr>\n" ;
           
            
            for(int i=1;i<=FiltroRole.size();i++){
              
         roleychoferes[i-1][0]=myMap.get(i).get(0);
         roleychoferes[i-1][1]=myMap.get(i).get(1);
         roleychoferes[i-1][2]=myMap.get(i).get(2);
         roleychoferes[i-1][3]=myMap.get(i).get(3);
         roleychoferes[i-1][4]=myMap.get(i).get(4)+" - "+myMap.get(i).get(5);
               
             
               String reformattedStr="";
               String Reformated="";
               try {
                   
                 reformattedStr =Converted.format(Original.parse(myMap.get(i).get(4).substring(0,(myMap.get(i).get(4).length()-2))));
                 Reformated=Converted.format(Original.parse(myMap.get(i).get(5).substring(0,(myMap.get(i).get(5).length()-2))));
                  
               } catch (ParseException ex) {
                  
               }
               
         roleychoferes[i-1][5]=myMap.get(i).get(6);
         roleychoferes[i-1][6]=myMap.get(i).get(7);
         roleychoferes[i-1][7]=myMap.get(i).get(8);
         roleychoferes[i-1][8]=myMap.get(i).get(9);
      
                if((i%2)==0){
                    HTML+="<tr bgcolor=\"#f2f2f2\">\n"
                + "<td>"+i+"</td>"
                + "<td>"+myMap.get(i).get(0)+"</td>"
                + "<td>"+myMap.get(i).get(1)+"</td>"
                + "<td>"+myMap.get(i).get(2)+"</td>"
                + "<td>"+myMap.get(i).get(3)+"</td>"
                 + "<td>"+reformattedStr+" - "+Reformated+"</td>"
                 + "<td>"+myMap.get(i).get(6)+"</td>"
                 + "<td>"+myMap.get(i).get(7)+"</td>"
                 + "<td>"+myMap.get(i).get(8)+"</td>"
               
                + "</tr>";
                }else{
                    HTML+="<tr>\n"
                + "<td>"+i+"</td>"
                + "<td>"+myMap.get(i).get(0)+"</td>"
                + "<td>"+myMap.get(i).get(1)+"</td>"
                + "<td>"+myMap.get(i).get(2)+"</td>"
                + "<td>"+myMap.get(i).get(3)+"</td>"
                + "<td>"+reformattedStr+" - "+Reformated+"</td>"
                 + "<td>"+myMap.get(i).get(6)+"</td>"
                 + "<td>"+myMap.get(i).get(7)+"</td>"
                 + "<td>"+myMap.get(i).get(8)+"</td>"
               
                + "</tr>"; 
                }
           }
           
           HTML+="</table>";
            
           
             engine.setUserStyleSheetLocation(getClass().getResource("StylesFx.css").toString());
        engine.loadContent(HTML);
            
    }
        
        */
    }
    
    
    }
    @FXML
    public void Excelbutton(ActionEvent event){
      if(FiltroRole.isEmpty()==false){
          String Path  =FileChooser();
       Rolexchofer_Excel Excel=new Rolexchofer_Excel();
         //   String Path=Excel.SelectingFileName();
            
            if(!Path.equals("")){
                    Excel.CreateRolexChofer(FiltroRole);
                    Excel.CreateHojaDeRole(FiltroRole2);
                    Excel.SaveExcelFile(Path);
            }
        }else{
           Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setHeaderText(null);
            alert.setContentText("Porfavor ingrese las fechas para la busqueda!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
            stage.getIcons().add(icon);
            alert.showAndWait();
        }
      
      /*
      engine.setUserStyleSheetLocation(getClass().getResource("StylesFx.css").toString());
      engine.load(getClass().getResource("Exceltable.html").toExternalForm());*/
    }
    
    public String FileChooser(){
       
        String Address="";
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Documento de excel (*.xlsx)", "*.xlsx");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showSaveDialog((Stage) Rolewindow.getScene().getWindow());
    if(file!=null){
        Address=file.toString();
    }
    return Address;
       
     
    }
    
   /* public void UnidadyChoferWin(ActionEvent event){
    Parent Principal_Parent;
     Stage Connections_Stage;
        try {
            Principal_Parent=FXMLLoader.load(getClass().getResource("UnidadyChofer.fxml"));
            Scene Principal_Pagescene=new Scene(Principal_Parent);
                                        Stage App_Stage=(Stage)((Node) event.getSource()).getScene().getWindow();
                                        App_Stage.hide();
                                        App_Stage.setScene(Principal_Pagescene);
                                        App_Stage.setTitle("Unidad&Chofer");
                                        App_Stage.setResizable(false);
                                        App_Stage.sizeToScene(); 
                                        App_Stage.getIcons().clear();
                                        Image Test = new Image(getClass().getResourceAsStream("/brandonspart/Icons/Travel.png"));
                                        App_Stage.getIcons().add(Test); 
                                        App_Stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Role_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
                                        
    
    }
   */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       /* engine = WebviewExcel.getEngine();*/
    }
    
}
