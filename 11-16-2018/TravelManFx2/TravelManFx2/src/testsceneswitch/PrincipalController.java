/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;



import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * FXML Controller class
 *
 * @author j_cas
 */
public class PrincipalController implements Initializable {
    TravelManDataBase DataBase= new TravelManDataBase();//Loads methods of the database class
    Config_ajustes LoadSettings=new Config_ajustes();//loags config settings to read user settings store on the host computer
    String[]data=null;
    int ChoferSelected=0;
    int UnidadSelected=0;
    int SelectedEmpresaName=0;
    int SelectedEncargado=0;
    int SelectEnContacto=0;
    int CaseSelected=0;
    HashMap<Integer,ArrayList<String>>myMap;
    HashMap<Integer,ArrayList<String>>myMap_Encargado;
     HashMap<Integer,ArrayList<String>>myMap_contacto;
    HashMap<Integer,ArrayList<String>>Unidades;
     HashMap<Integer,ArrayList<String>>choferes;
     HashMap<Integer,ArrayList<String>>empresas;
     HashMap<Integer,ArrayList<String>>Caseempresas;
    boolean Buscar=false;
    boolean Update_Estate=false;
    int Caso;
    int numerodecaso=0;
   
    public ComboBox<String> UnidadComboBOX;
    @FXML
    private DatePicker Fecha_Salida;
    @FXML
    private ComboBox<String> Hora_Salida;
    @FXML
    private ComboBox<String> Minuto_Salida;
    @FXML
    private ComboBox<String> Tipo_Moneda;
    @FXML
    private ComboBox<String> Metodo_Pago;
    @FXML
    private ComboBox<String> AMPM_Salida;
    @FXML
    private ComboBox<String> AMPM_Regreso;
    @FXML
    private ComboBox<String> Minuto_Regreso;
    @FXML
    private ComboBox<String> Hora_Regreso;
    @FXML
    private ComboBox<String> Estado_Box;
    @FXML
    private Button Button_Role;
    @FXML
    private Button Button_UnidadChofe;
    @FXML
    private Button Button_Reportes;
    @FXML
    private TextField Case_Number;
    @FXML
    private Button Pending;
    @FXML
    private Button Cancelar;
    @FXML
    private Button B_Busqueda;
    @FXML
    private Button Save_Case;
    @FXML
    private TextField Tel_Contacto;
    @FXML
    private TextField Email_Contacto;
    @FXML

    private TextField Tel_Encargado;
    @FXML
    private TextField Pax;
    @FXML
    private RadioButton Aire_Si;
    @FXML
    private RadioButton Aire_No;
    @FXML
    private ComboBox<String> Unidad_Selector;
    @FXML
    private TextField Cobrar_Conductor;
    @FXML
    private TextField Regreso_conductor;
    @FXML
    private TextField Notas_Conductor;
    @FXML
    private Tooltip Cobrar_tip;
    @FXML
    private Tooltip Regreso_tip;
    @FXML
    private Tooltip Notas_tip;
    @FXML
    private TextField Lugar_Destino;
    @FXML
    private TextField Lugar_Salida;
    @FXML
    private TextField Precio;
    @FXML
    private RadioButton Adelantos_si;
    @FXML
    private RadioButton Adelantos_no;
    @FXML
    private TextField monto_total;
    @FXML
    private Tooltip Salida_tip;
    @FXML
    private Tooltip Destino_tip;
    @FXML
    private DatePicker Fecha_Regreso;
    private RadioButton Recorrido_si;
    private RadioButton Recorrido_no;
    @FXML
    private TextField Recorrido_text;
    @FXML
    private Tooltip Recorrido_tip;
    @FXML
    private DatePicker Case_estate_date;
    @FXML
    private WebView Webview_Comments;
    private WebEngine Engine;
    @FXML
    private TextArea Comentarios;
    @FXML
    private ToggleGroup Aire_Group;
    @FXML
    private ToggleGroup Adelantos_Group;
    @FXML
    private Button Admin_Users_Button;
    private TableColumn Column_Nombre;
    @FXML
    private Button Buscar_Unidad;
    @FXML
    private TextField Monto_Adelantado;
    @FXML
    private DatePicker Fecha_Maxima;
    @FXML
    private ComboBox<String> ComboChoferes;
    @FXML
    private ComboBox<String> search_Case;
    @FXML
    private DatePicker dateScase;
    @FXML
    private DatePicker dateEcase;
    @FXML
    private Tooltip tooltipdateS;
    @FXML
    private Tooltip tooltipdateE;
    @FXML
    private CheckBox checkbano;
    @FXML
    private TextField TipoTransporteTExtfield;
    @FXML
    private ComboBox<String> Estado_Box1;
    @FXML
    private ComboBox<String> Name_EmpresaCombo;
    @FXML
    private ComboBox<String> Nombre_ContactoCombo;
    @FXML
    private ComboBox<String> Nombre_encargadoCombo;
    @FXML
   
    private Button ButtonAdd_Contacto;
    @FXML
    private Button ButtonAdd_Encargado;
    @FXML
 
    private Button Update_Contacto;
    @FXML
    private Button Update_Encargado;
    @FXML
    private Button ButtonAdd_Empresa;
    @FXML
    private Button Update_Empresa1;
    
   
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComponentStart();
        
        TextLimit();
       //starcombo
            Name_EmpresaCombo.getSelectionModel().selectedIndexProperty().addListener( (Observable, oldValue, newValue) -> 
             
                    SearchContactafterEmpresa((Integer)newValue+1)
         );
            
            
            
            
           Nombre_ContactoCombo.getSelectionModel().selectedIndexProperty().addListener( (Observable, oldValue, newValue) -> 
                
              
                    SearchContactafterencargado((Integer)newValue+1)
         );  
           
          Nombre_encargadoCombo.getSelectionModel().selectedIndexProperty().addListener( (Observable, oldValue, newValue) -> 
                
              
                    showencargado((Integer)newValue+1)
         );  
           
    
            ComboChoferes.getSelectionModel().selectedIndexProperty().addListener( (Observable, oldValue, newValue) -> 
                
                SETIDCHofer((Integer)newValue+1)
                );
        
        search_Case.getSelectionModel().selectedIndexProperty().addListener( (Observable, oldValue, newValue) -> 
                
                SETIDcase((Integer)newValue+1)
                );
      
            Unidad_Selector.getSelectionModel().selectedIndexProperty().addListener((Observable, oldValue, newValue) ->
            SETIDUnidadSElected((Integer)newValue+1)
       );
        
                dateScase.valueProperty().addListener((ov, oldValue, newValue) -> {
                    tooltipdatesearchcase();
});
       dateEcase.valueProperty().addListener((ov, oldValue, newValue) -> {
                    tooltipdatesearchcase2();
});
       
     Adelantos_si.selectedProperty().addListener(new ChangeListener<Boolean>(){
          @Override
    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
        if (isNowSelected) { 
            Monto_Adelantado.setEditable(true);
        }else{
            Monto_Adelantado.clear();
            Monto_Adelantado.setEditable(false);
        }}
     });
    } 
  
    @FXML
    public void tooltipdatesearchcase(){
        System.out.println("llamado el tooltip");
    /*
         LocalDate localDate = dateScase.getValue();
            LocalDate localDate2 = dateEcase.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            Date date2 = Date.from(instant2);
        */
    /* private Tooltip tooltipdateS;
       private Tooltip tooltipdateE;
    
    date.toString()*/
      LocalDate localDate = dateScase.getValue();
      Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
      Date date = Date.from(instant);
       SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
    tooltipdateS.setText(formatDate.format(date));
    
    
    
    
    
    }
            public void tooltipdatesearchcase2(){
        System.out.println("llamado el tooltip");
    /*
         LocalDate localDate = dateScase.getValue();
            LocalDate localDate2 = dateEcase.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            Date date2 = Date.from(instant2);
        */
    /* private Tooltip tooltipdateS;
       private Tooltip tooltipdateE;
    
    date.toString()*/
      LocalDate localDate = dateEcase.getValue();
      Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
      Date date = Date.from(instant);
       SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
    tooltipdateE.setText(formatDate.format(date));
    
    
    
    
    
    }
   public void SETIDCHofer(int x){
       if(choferes!=null&&x>0){
           
               ChoferSelected=Integer.parseInt(choferes.get(x).get(0));
          
       }
   }
   
    public void SETIDcase(int x){
        
  
  
       if(empresas!=null&&x>0){
            if(dateScase.getValue()==null){
              search_casefilterNODATE(x);
            }else{
                if(dateScase.getValue()!=null&&dateEcase.getValue()!=null){
                    if((dateEcase.getValue().isAfter(dateScase.getValue()))||(dateEcase.getValue().isEqual(dateEcase.getValue()))){
                        CaseSelected=Integer.parseInt(empresas.get(x).get(0));
                        search_casefilter(Integer.parseInt(empresas.get(x).get(0)));
                    }else{
                         Message("Rango de fechas incorrecto!");
                    }  
                }else{
                    Message("Seleccione un rango valido!");
           }  
          }
           
       }else{
           Message("Porfavor seleccione una empresa!");
       }
   }
    
    
    
    
   @FXML
   public void Prueba(){
       System.out.println("salida");
   }
   
   public void SETIDUnidadSElected(int x){
      
      if(Unidades!=null&&x>0){
              UnidadSelected=Integer.parseInt(Unidades.get(x).get(1));
              System.out.println("Unidad seleccionada"+Unidades.get(x).get(0));
              System.out.println("unidad PK"+UnidadSelected);
       }
   }
   
    @FXML
   public void ClearSearchEmpresaXEstado(){
       search_Case.getItems().clear();
   }
    public void ComponentStart(){
      
        Unidad_Selector.getItems().addAll("Sin asignar");
        Unidad_Selector.getSelectionModel().selectFirst();
        Estado_Box.getItems().addAll("Cerrado","P. de facturación","P. de pago","En trámite","Por avisar","Confirmado");
        Estado_Box1.getItems().addAll("Cerrado","P. de facturación","P. de pago","En trámite","Por avisar","Confirmado");
        Estado_Box1.getSelectionModel().selectFirst();
        AMPM_Salida.getItems().addAll("AM","PM");
        AMPM_Salida.getSelectionModel().selectFirst();
         AMPM_Regreso.getItems().addAll("AM","PM");
        AMPM_Regreso.getSelectionModel().selectFirst();
        Metodo_Pago.getItems().addAll("Efectivo","Transferencia. B","Cheque");
        Metodo_Pago.getSelectionModel().selectFirst();
        Tipo_Moneda.getItems().addAll("₡","$");
        Tipo_Moneda.getSelectionModel().selectFirst();
      
        Hora_Salida.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
        Hora_Salida.getSelectionModel().selectFirst();
        Hora_Regreso.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
        Hora_Regreso.getSelectionModel().selectFirst();
        Minuto_Salida.getItems().addAll("00","15","30","45");
        Minuto_Salida.getSelectionModel().selectFirst();
        Minuto_Regreso.getItems().addAll("00","15","30","45");
        Minuto_Regreso.getSelectionModel().selectFirst();
        Aire_Si.setUserData("Si");
        Aire_No.setUserData("No");
        Adelantos_si.setUserData("Si");
        Adelantos_no.setUserData("No");
        Adelantos_no.setSelected(true);
        Monto_Adelantado.setEditable(false);
       
    }

   
    @FXML
    public void FindCaseParameters1(){
        choferes=null;
        Unidades=null;
        
        try {
            
            BuscarCaso(Case_Number.getText());
           
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void FindCaseFromPendientes(String Case){
        choferes=null;
        Unidades=null;
        try {
            BuscarCaso(Case);
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void search_casefilter(int empresa){
        
       HashMap<Integer,ArrayList<Object>>myData=null;
  
   
            LocalDate localDate = dateScase.getValue();
            LocalDate localDate2 = dateEcase.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Instant instant2 = Instant.from(localDate2.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            Date date2 = Date.from(instant2);
            myData=DataBase.Busquedadecaso(date,date2,empresa,Estado_Box1.getSelectionModel().getSelectedItem());
            Engine=Webview_Comments.getEngine();
            Engine.setOnAlert((WebEvent<String> event) -> {
            System.out.println("ALERT!!!! " + event.getData());
            FindCaseFromPendientes(event.getData());
            });
            Engine.setJavaScriptEnabled(true);//habilita ejecucion de javascript en el cuadro de texto del wbview
            
            
            Engine.loadContent("");
            String Comentarios="";
            Comentarios+="<!doctype html><html>"
                +"<script>function Prueba(x){"
                + "alert(x.id);}</script>"
                + "<body>";
            
            
            
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, 2);
            java.util.Date PendingDate;
              SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            for(int i=1;i<=myData.size();i++){
            System.out.println("NombreID "+myData.get(i).get(0));
            PendingDate=(Date)myData.get(i).get(3);
                if(PendingDate.before(c.getTime())){
                    System.out.println("esta en regla");
                    Comentarios+="<div onmouseup=\"Prueba(this)\" id=\""+(String)myData.get(i).get(0)+"\" class=\"CommentRojo\"><b>Nº de caso:&nbsp</b>00"+(String)myData.get(i).get(0)+"</a>&nbsp<b>Nombre:&nbsp</b>"+(String)myData.get(i).get(1)+"<br><b>Recorrido:&nbsp</b>"+myData.get(i).get(2)+"<br><b>Creado:&nbsp</b>"+formatDate.format((Date)myData.get(i).get(4))+"</div>";

                }else{
                   Comentarios+="<div onmouseup=\"Prueba(this)\" id=\""+(String)myData.get(i).get(0)+"\" class=\"Comment\"><b>Nº de caso:&nbsp</b>00"+(String)myData.get(i).get(0)+"</a>&nbsp<b>Nombre:&nbsp</b>"+(String)myData.get(i).get(1)+"<br><b>Recorrido:&nbsp</b>"+myData.get(i).get(2)+"<br><b>Creado:&nbsp</b>"+formatDate.format((Date)myData.get(i).get(4))+"</div>";
                }
            
            }
            
            Comentarios+="</body></html>";
            Engine.setUserStyleSheetLocation(getClass().getResource("Webviewstyle.css").toString());
            Engine.loadContent(Comentarios);
            
       
        System.out.println(" x   "+empresa);
    }
    public void search_casefilterNODATE(int empresa){
        
       HashMap<Integer,ArrayList<Object>>myData=null;
  
   
            
            
            myData=DataBase.Busquedadecaso2(empresa,Estado_Box1.getSelectionModel().getSelectedItem());
            Engine=Webview_Comments.getEngine();
            Engine.setOnAlert((WebEvent<String> event) -> {
            System.out.println("ALERT!!!! " + event.getData());
            FindCaseFromPendientes(event.getData());
            });
            Engine.setJavaScriptEnabled(true);//habilita ejecucion de javascript en el cuadro de texto del wbview
            
            
            Engine.loadContent("");
            String Comentarios="";
            Comentarios+="<!doctype html><html>"
                +"<script>function Prueba(x){"
                + "alert(x.id);}</script>"
                + "<body>";
            
            
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, 2);
            java.util.Date PendingDate;
              SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            for(int i=1;i<=myData.size();i++){
            System.out.println("NombreID "+myData.get(i).get(0));
            PendingDate=(Date)myData.get(i).get(3);
                if(PendingDate.before(c.getTime())){
                    System.out.println("esta en regla");
                    Comentarios+="<div onmouseup=\"Prueba(this)\" id=\""+(String)myData.get(i).get(0)+"\" class=\"CommentRojo\"><b>Nº de caso:&nbsp</b>00"+(String)myData.get(i).get(0)+"</a>&nbsp<b>Nombre:&nbsp</b>"+(String)myData.get(i).get(1)+"<br><b>Recorrido:&nbsp</b>"+myData.get(i).get(2)+"<br><b>Creado:&nbsp</b>"+formatDate.format((Date)myData.get(i).get(4))+"</div>";

                }else{
                   Comentarios+="<div onmouseup=\"Prueba(this)\" id=\""+(String)myData.get(i).get(0)+"\" class=\"Comment\"><b>Nº de caso:&nbsp</b>00"+(String)myData.get(i).get(0)+"</a>&nbsp<b>Nombre:&nbsp</b>"+(String)myData.get(i).get(1)+"<br><b>Recorrido:&nbsp</b>"+myData.get(i).get(2)+"<br><b>Creado:&nbsp</b>"+formatDate.format((Date)myData.get(i).get(4))+"</div>";
                }
            
            }
            
            Comentarios+="</body></html>";
            Engine.setUserStyleSheetLocation(getClass().getResource("Webviewstyle.css").toString());
            Engine.loadContent(Comentarios);
            
       
        System.out.println(" x   "+empresa);
    }
    
    public void BuscarCaso(String Case) throws ParseException{
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat formatDateP = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat onlyTime = new SimpleDateFormat("hh:mm a");
        Date timeSalida=null;
        
        if(Case.isEmpty()==false){
            try{
                data=DataBase.SearchRole_Case(Integer.parseInt(Case));
            }catch(NumberFormatException e){
                
            }
                if(data[0]!=null){
                    String Toilet;
                   Toilet= data[31];
       if(Toilet.equals("Si")){
          checkbano.setSelected(true);
       }else{
           checkbano.setSelected(false);
       }
       
       
     /*  SelectedEmpresaName=Integer.parseInt(data[32]);
                    System.out.println("selected empresa "+SelectedEmpresaName);*/
       
      SelectEnContacto =Integer.valueOf(data[30]);
       SelectedEncargado =Integer.parseInt(data[19]);
                    System.out.println("prueba valor de encargado"+SelectEnContacto);
       TipoTransporteTExtfield.setText(data[14]);
                    Update_Estate=true;
                    Caso=Integer.parseInt(Case);
                    numerodecaso=Integer.parseInt(Case);
                   
                    
                    Name_EmpresaCombo.getEditor().setText(data[15]);
                    
                    Nombre_ContactoCombo.getEditor().setText(data[4]);
                    
                    Tel_Contacto.setText(data[16]);
                   UnidadSelected=Integer.valueOf(data[18]);
                   ChoferSelected=Integer.valueOf(data[29]);
                
                    Email_Contacto.setText(data[17]);
                 
                    Nombre_encargadoCombo.getEditor().setText(data[26]);
                    
                   
                   Tel_Encargado.setText(data[28]);
                    
                 
                    Pax.setText(data[10]);
                    if(data[13].equals("Si")){
                        Aire_Si.setSelected(true);
                    }else{
                        Aire_No.setSelected(true);
                    }
                   
                        Unidad_Selector.getItems().clear();
                    Unidad_Selector.getItems().add(data[1]);
                    Unidad_Selector.getSelectionModel().selectFirst();
                    
                    
                 
                    ComboChoferes.getItems().clear();
                    ComboChoferes.getItems().add(data[0]);
                    ComboChoferes.getSelectionModel().selectFirst();
                    Cobrar_Conductor.setText(data[11]);
                    Cobrar_tip.setText(data[11]);
                     Regreso_conductor.setText(data[12]);
                     Regreso_tip.setText(data[12]);
                    Notas_Conductor.setText(data[8]);
                    Notas_tip.setText(data[8]);
                    Lugar_Salida.setText(data[3]);
                    Salida_tip.setText(data[3]);
                   
                    
                    
                    Lugar_Destino.setText(data[2]);
                    Destino_tip.setText(data[2]);
                    Precio.setText(data[9]);
                    
                    
                    int PreCio=Integer.parseInt(data[9]);
                    int aDelanto=Integer.parseInt(data[24].substring(0,data[24].length()-2));
                    int total=PreCio-aDelanto;
                    monto_total.setText(String.valueOf(total));
                    Metodo_Pago.getSelectionModel().select(Integer.parseInt(data[21]));
                    Tipo_Moneda.getSelectionModel().select(Integer.parseInt(data[20]));
                    
                    Date Salida = new SimpleDateFormat("yyyy-MM-dd").parse(data[6]);
                    LocalDate Sallida_Locale = Salida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    Fecha_Salida.setValue(Sallida_Locale);
                    
                    Date Destino = new SimpleDateFormat("yyyy-MM-dd").parse(data[7]);
                    LocalDate Regreso_Locale = Salida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    Fecha_Regreso.setValue(Regreso_Locale);
                    
                 
                    timeSalida=formatDate.parse(data[6].substring(0,data[6].length()-2));
                    String HInicial="";
                    HInicial=onlyTime.format(timeSalida);
                    Hora_Salida.getSelectionModel().select(HInicial.substring(0,2));
                    Minuto_Salida.getSelectionModel().select(HInicial.substring(3,5));
                    AMPM_Salida.getSelectionModel().select(HInicial.substring(6,8));
                    
                    Date timeRegreso=null;
                    String HFinal="";
                    timeRegreso=formatDate.parse(data[7].substring(0,data[7].length()-2));
                    HFinal=onlyTime.format(timeRegreso);
                    Hora_Regreso.getSelectionModel().select(HFinal.substring(0,2));
                    Minuto_Regreso.getSelectionModel().select(HFinal.substring(3,5));
                    AMPM_Regreso.getSelectionModel().select(HFinal.substring(6,8));
                    
                  
                     Recorrido_text.setText(data[25]);
                       Recorrido_tip.setText(data[25]);
                  Estado_Box.getSelectionModel().select(data[22]);
                    
                    Date timeCaseEstate,FechaMaxi=null;
                    
                    timeCaseEstate=formatDateP.parse(data[23]);
                    
                   
                       FechaMaxi =formatDateP.parse(data[27]);
                    LocalDate timeCaseEstate_Locale = timeCaseEstate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                     LocalDate timeCaseEstate_LocaleMax = FechaMaxi.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    Case_estate_date.setValue(timeCaseEstate_Locale);
                   Fecha_Maxima.setValue(timeCaseEstate_LocaleMax);
                   
                    
                   Engine=Webview_Comments.getEngine();
                   

                    Engine.setUserStyleSheetLocation(getClass().getResource("Webviewstyle.css").toString());
                    String Comentarios="";
                      
                    HashMap<Integer,String[]>myMap=DataBase.SearchComentarios_Case(Integer.parseInt(Case));
                  
                    Comentarios+="<!doctype html><html><body>";
                      
                       
                    for(int x=1;x<=myMap.size();x++){
                        String a[]=myMap.get(x);
                        Date Fase_1= new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(a[0].substring(0,a[0].length()-5));
                        SimpleDateFormat formatDate1 = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
                        Comentarios+="<div  class=\"Comments1\"><b>Fecha:&nbsp</b> "+formatDate1.format(Fase_1)+"<br/><b>Usuario:&nbsp</b> "+a[1]+"<br/><b>Comentario:&nbsp</b>"+a[2]+"</div>";
                    }
                    Comentarios+="</body></html>";
                    
                    Engine.loadContent(Comentarios);
                  
                }
        }else{
            
            
        }
        
    }
   
   
    @FXML
    public void ClearEverything(){
        
        Fecha_Maxima.setValue(null);
        numerodecaso=0;
        SelectedEmpresaName=0;
        SelectEnContacto=0;
        SelectedEncargado=0;
        UnidadSelected=0;
        ChoferSelected=0;
        Tel_Contacto.clear();
        Email_Contacto.clear();
        Tel_Encargado.clear();
        Monto_Adelantado.clear();
        Pax.clear();
        Cobrar_Conductor.clear();
        Regreso_conductor.clear();
        Name_EmpresaCombo.getItems().clear();
        Nombre_ContactoCombo.getItems().clear();
        Tel_Contacto.clear();

Email_Contacto.clear();

Nombre_encargadoCombo.getItems().clear();

Tel_Encargado.clear();
  SelectedEmpresaName=0;
    SelectedEncargado=0;
    SelectEnContacto=0;
        Notas_Conductor.clear();
        Lugar_Salida.clear();
        Lugar_Destino.clear();
        Precio.clear();
        Recorrido_text.clear();
        Comentarios.clear();
        Tipo_Moneda.getSelectionModel().selectFirst();
        Metodo_Pago.getSelectionModel().selectFirst();
        Hora_Salida.getSelectionModel().selectFirst();
        Minuto_Salida.getSelectionModel().selectFirst();
        AMPM_Salida.getSelectionModel().selectFirst();
        Hora_Regreso.getSelectionModel().selectFirst();
        Minuto_Regreso.getSelectionModel().selectFirst();
        AMPM_Regreso.getSelectionModel().selectFirst();
        Estado_Box.getSelectionModel().selectFirst();   
        Estado_Box.getSelectionModel().selectFirst();
        Fecha_Salida.setValue(null);
        Fecha_Regreso.setValue(null);
        dateScase.setValue(null);
        dateEcase.setValue(null);
        Case_estate_date.setValue(null);
        Case_Number.clear();
        Engine=Webview_Comments.getEngine();
        Engine.loadContent("");
        monto_total.clear();
        search_Case.getItems().clear();
        ComboChoferes.getItems().clear();
        Unidad_Selector.getItems().clear();
        Unidad_Selector.getItems().addAll("Sin asignar");
        Unidad_Selector.getSelectionModel().selectFirst();
        Update_Estate=false;
        TipoTransporteTExtfield.setText("");

    }
    @FXML
    public void Search_Pendientes(){
        
      /*   Webview_Comments.setOnMousePressed(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                        System.out.println("Mouse pressed");
                            System.out.println("probando ");
                        Engine.getDocument().getAttributes();
                        }
                     });*/
        ClearEverything();    
        System.out.println("intentando pendientes");
  
        Engine=Webview_Comments.getEngine();
        Engine.setOnAlert((WebEvent<String> event) -> {
        System.out.println("ALERT!!!! " + event.getData());
        FindCaseFromPendientes(event.getData());
    });
        Engine.setJavaScriptEnabled(true);
        Engine.loadContent("");
        HashMap<Integer,Object[]>myMap_Pendientes;
        String Comentarios="";
        LoadSettings.LoadProperties();
        
        myMap_Pendientes=DataBase.SearchPendientes_Case();
        Comentarios+="<!doctype html><html>"
                +"<script>function Prueba(x){"
                + "alert(x.id);}</script>"
                + "<body>";
        Object []Data=new Object[3];
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 2);
         java.util.Date PendingDate;
        for(int i=1;i<=myMap_Pendientes.size();i++){
             Data=myMap_Pendientes.get(i);
             PendingDate = (java.util.Date) Data[0];
           
             if(PendingDate.before(c.getTime())){
                  Comentarios+="<div onmouseup=\"Prueba(this)\" id=\""+Data[2]+"\" class=\"CommentRojo\"><b>Nº de caso:&nbsp</b>00"+Data[2]+"</a>&nbsp<b>Estado:&nbsp</b>"+Data[1]+"<br><b>Fecha:&nbsp</b>"+Data[0]+"<br><b>Empresa:&nbsp</b>"+Data[3]+"</div>";
             }else{
                  Comentarios+="<div onmouseup=\"Prueba(this)\" id=\""+Data[2]+"\" class=\"Comment\"><b>Nº de caso:&nbsp</b>00"+Data[2]+"</a>&nbsp<b>Estado:&nbsp</b>"+Data[1]+"<br><b>Fecha:&nbsp</b>"+Data[0]+"<br><b>Empresa:&nbsp</b>"+Data[3]+"</div>";
             }
             
        }
        Comentarios+="</body></html>";
        Engine.setUserStyleSheetLocation(getClass().getResource("Webviewstyle.css").toString());
        Engine.loadContent(Comentarios);
    }
   
    
    
    
    public void HTMLsearchcases(){
    
      ClearEverything();    
        System.out.println("intentando pendientes");
  
        Engine=Webview_Comments.getEngine();
        Engine.setOnAlert((WebEvent<String> event) -> {
        System.out.println("ALERT!!!! " + event.getData());
        FindCaseFromPendientes(event.getData());
    });
        Engine.setJavaScriptEnabled(true);
        Engine.loadContent("");
        HashMap<Integer,Object[]>myMap_Pendientes;
        String Comentarios="";
        LoadSettings.LoadProperties();
        
        myMap_Pendientes=DataBase.SearchPendientes_Case();
        Comentarios+="<!doctype html><html>"
                +"<script>function Prueba(x){"
                + "alert(x.id);}</script>"
                + "<body>";
        Object []Data=new Object[3];
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 2);
         java.util.Date PendingDate;
        for(int i=1;i<=myMap_Pendientes.size();i++){
             Data=myMap_Pendientes.get(i);
             PendingDate = (java.util.Date) Data[0];
           
             if(PendingDate.before(c.getTime())){
                  Comentarios+="<div onmouseup=\"Prueba(this)\" id=\""+Data[2]+"\" class=\"CommentRojo\"><b>Nº de caso:&nbsp</b>00"+Data[2]+"</a>&nbsp<b>Estado:&nbsp</b>"+Data[1]+"<br><b>Fecha:&nbsp</b>"+Data[0]+"<br><b>Empresa:&nbsp</b>"+Data[3]+"</div>";
             }else{
                  Comentarios+="<div onmouseup=\"Prueba(this)\" id=\""+Data[2]+"\" class=\"Comment\"><b>Nº de caso:&nbsp</b>00"+Data[2]+"</a>&nbsp<b>Estado:&nbsp</b>"+Data[1]+"<br><b>Fecha:&nbsp</b>"+Data[0]+"<br><b>Empresa:&nbsp</b>"+Data[3]+"</div>";
             }
             
        }
        Comentarios+="</body></html>";
        Engine.setUserStyleSheetLocation(getClass().getResource("Webviewstyle.css").toString());
        Engine.loadContent(Comentarios);
    }
    
    @FXML
    public void Open_User_Admin(ActionEvent event){
      
    LoadSettings.LoadProperties();
       
    int Access=DataBase.Read_User_Settings_Admin(Integer.valueOf(LoadSettings.GetPropertie("UserID")));
        System.out.println("Access"+Access);
    if(Access==1){
        try {
            Stage Connections_Stage;
            Connections_Stage=new Stage();
            Parent Principal_Parent;
            Principal_Parent=FXMLLoader.load(getClass().getResource("Users_Administration.fxml"));
            Connections_Stage.setScene(new Scene(Principal_Parent));
            Connections_Stage.initModality(Modality.APPLICATION_MODAL);
            Connections_Stage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
            Connections_Stage.setTitle("Usuarios");
            Connections_Stage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/login.png"));
            Connections_Stage.getIcons().add(icon);
            Connections_Stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else{
          Access_Error();  
    }
}
    
public void Access_Error(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setHeaderText(null);
            alert.setContentText("El usuario no tiene suficientes privilegios de acceso!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
            stage.getIcons().add(icon);
            alert.showAndWait();
}
@FXML
public void Open_Role(ActionEvent event){
    System.out.println("entro a esto");
        LoadSettings.LoadProperties();
        int Result=DataBase.Check_Permissions(Integer.valueOf(LoadSettings.GetPropertie("UserID")),"Role");
        System.out.println(" resultado "+Result);
        if(Result==1){
            try {
            Stage Connections_Stage;
            Connections_Stage=new Stage();
            Parent Principal_Parent;
            Principal_Parent=FXMLLoader.load(getClass().getResource("Role.fxml"));
            Connections_Stage.setScene(new Scene(Principal_Parent));
            Connections_Stage.initModality(Modality.APPLICATION_MODAL);
            Connections_Stage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
            Connections_Stage.setTitle("Role");
            Connections_Stage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/new-role-icon.png"));
            Connections_Stage.getIcons().add(icon);
            Connections_Stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            Access_Error();  
        }
       
}
@FXML
public void Open_UniChofer(ActionEvent event){
     LoadSettings.LoadProperties();
       
      
        int Result=DataBase.Check_Permissions(Integer.valueOf(LoadSettings.GetPropertie("UserID")),"Unidad_Choferes");
          if(Result==1){
           try {
             Stage Connections_Stage;
             Connections_Stage=new Stage();
             Parent Principal_Parent;
             Principal_Parent=FXMLLoader.load(getClass().getResource("UnidadyChofer.fxml"));
             Connections_Stage.setScene(new Scene(Principal_Parent));
             Connections_Stage.initModality(Modality.APPLICATION_MODAL);
             Connections_Stage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
             Connections_Stage.setTitle("Unidades y choferes");
             Connections_Stage.setResizable(false);
             Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Travel.png"));
             Connections_Stage.getIcons().add(icon);
             Connections_Stage.showAndWait();
         } catch (IOException ex) {
             Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
         }
          }else{
              Access_Error();  
         }
        
}


    @FXML
    public void Open_Reports(ActionEvent event){
    LoadSettings.LoadProperties();
       
        
        int Result=DataBase.Check_Permissions(Integer.valueOf(LoadSettings.GetPropertie("UserID")),"Cliente");
         if(Result==1){
              try {
            Stage Connections_Stage;
            Connections_Stage=new Stage();
            Parent Principal_Parent;
            Principal_Parent=FXMLLoader.load(getClass().getResource("Reports.fxml"));
            Connections_Stage.setScene(new Scene(Principal_Parent));
            Connections_Stage.initModality(Modality.APPLICATION_MODAL);
            Connections_Stage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
            Connections_Stage.setTitle("Reports");
            Connections_Stage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/new-role-icon.png"));
            Connections_Stage.getIcons().add(icon);
            Connections_Stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         }else{
              Access_Error();  
         }
        
           



}



public void ClearSelectedEmpresaEncargado(){
    

    Tel_Contacto.clear();
    Email_Contacto.clear();
     SelectedEmpresaName=0;
     SelectedEncargado=0;
     
     Tel_Encargado.clear();
  
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

public void ADDNewEmpresa_Encargado(){
}
 
 @FXML
 private void Empresakeypress(KeyEvent e) {
     if(e.getCode().equals(KeyCode.ENTER)){
        
              Nombre_ContactoCombo.getEditor().setText("");
     Nombre_encargadoCombo.getItems().clear();
     Nombre_encargadoCombo.getEditor().setText("");
     Tel_Contacto.setText("");
     Email_Contacto.setText("");
     Tel_Encargado.setText("");
         showempresascom();
         
     }
 }
 
 
 
 
 
 
 public void showempresascom(){
Name_EmpresaCombo.getItems().clear();
Nombre_ContactoCombo.getItems().clear();
Nombre_encargadoCombo.getItems().clear();
Tel_Encargado.clear();
SelectEnContacto=0;
Email_Contacto.clear();
Tel_Contacto.clear();
SelectedEncargado=0;
  myMap=DataBase.search_EmpresaRole(Name_EmpresaCombo.getEditor().getText());
     int size=myMap.size();
  
   for(int i=1;i<=size;i++){
       
        Name_EmpresaCombo.getItems().add(myMap.get(i).get(1));
        
        }
   Name_EmpresaCombo.show();
 }
 
 public void SearchContactafterEmpresa (int x ){
       System.out.println("entered here empresasas");
    int SelectedEncargado=0;
    int SelectEnContacto=0;
     Nombre_ContactoCombo.getItems().clear();
     Nombre_ContactoCombo.getEditor().setText("");
     Nombre_encargadoCombo.getItems().clear();
     Nombre_encargadoCombo.getEditor().setText("");
     Tel_Contacto.setText("");
     Email_Contacto.setText("");
     Tel_Encargado.setText("");
   
         SelectedEmpresaName=Integer.parseInt(myMap.get(x).get(0));
     myMap_Encargado=DataBase.search_Encargado(SelectedEmpresaName);
      myMap_contacto=DataBase.search_Contacto_Encargado(SelectedEmpresaName);
    for(int i=1;i<=myMap_Encargado.size();i++){
        System.out.println("name del encargado: "+myMap_Encargado.get(i).get(1));
        
        Nombre_ContactoCombo.getItems().add(myMap_Encargado.get(i).get(0));
    }
    for(int i=1;i<=myMap_contacto.size();i++){
        
        
        Nombre_encargadoCombo.getItems().add(myMap_contacto.get(i).get(0));
    }
    
     
    
 }
 
 //encargado 3 parte
 
 public void showencargado(int y){
    
   
    Tel_Encargado.setText(myMap_contacto.get(y).get(1));
     System.out.println("numero de encargado "+myMap_contacto.get(y).get(2));
    SelectEnContacto=Integer.parseInt(myMap_contacto.get(y).get(2));
 }
 
 
 
 public void SearchContactafterencargado (int x ){   
     Email_Contacto.setText(myMap_Encargado.get(x).get(1));
     Tel_Contacto.setText(myMap_Encargado.get(x).get(2));
     SelectedEncargado=Integer.parseInt(myMap_Encargado.get(x).get(4));
 
 }
 
 
 
 
 /*le puse editible al texfield*/
 @FXML
 private void handleKeyPress(KeyEvent e) {
     if(e.getCode().equals(KeyCode.ENTER)){
         showchoferes();
     }
 }
 
 @FXML
  private void handleKeyPressempressas(KeyEvent e) {
     if(e.getCode().equals(KeyCode.ENTER)){
         showEmpresas();
         search_Case.show();
     }
 }
 
   public void showEmpresas(){
search_Case.getItems().clear();
 empresas=DataBase.Filterempresas(search_Case.getEditor().getText());
   
   int Size=empresas.size();
   for(int i=1;i<=Size;i++){
       
        search_Case.getItems().add(empresas.get(i).get(1));
        
        }
 }
  
 public void showchoferes(){
ComboChoferes.getItems().clear();
 choferes=DataBase.GetChoferesfilters(ComboChoferes.getEditor().getText());
   
   int Size=choferes.size();
   for(int i=1;i<=Size;i++){
       
        ComboChoferes.getItems().add(choferes.get(i).get(1));
        
        }
   ComboChoferes.show();
 }
 


   
   @FXML
                   
   public void Update_Empresa(){
   
   DataBase.Update_Empresa_Principal(SelectedEmpresaName, Name_EmpresaCombo.getEditor().getText());
    Message("El Empresa ha sido actualizado correctamente!");
   }
   
   @FXML
   public void Update_Contacto(){
       
    DataBase.Update_Contact_Only(SelectedEncargado, Nombre_ContactoCombo.getEditor().getText(), Tel_Contacto.getText(), Email_Contacto.getText());
    Message("El contacto ha sido actualizado correctamente!");
   }
   
   @FXML
   public void Update_Encargado(){
   
    DataBase.UPdate_Encargado_Contacto(SelectEnContacto, Nombre_encargadoCombo.getEditor().getText(), Tel_Encargado.getText());
     Message("El encargado ha sido actualizado correctamente!");
   }
    @FXML
    public void BuscarUnidades(){
        
         String Toilet;
       if(checkbano.isSelected()==true){
           Toilet="Si";
       }else{
           Toilet="No";
       }
        System.out.println(" toite"+Toilet);
        Unidades=DataBase.SearchFilterUnidad(Aire_Group.getSelectedToggle().getUserData().toString(), Integer.parseInt(Pax.getText()),Toilet);
        if(Unidades.isEmpty()==true){
            /*Unidad_Selector.getItems().clear();
            Unidad_Selector.getItems().add("Sin asignar");*/
            Message("No se encontraron unidades!");
        }else{
           Buscar=true;
            
            Unidad_Selector.getItems().clear();
       
            for(int i=1;i<=Unidades.size();i++){
                Unidad_Selector.getItems().add(Unidades.get(i).get(0));
                System.out.println("Unidades"+Unidades.get(i).get(0));
            }
         Unidad_Selector.getSelectionModel().selectFirst();
        }
       
    }
@FXML
    public void SelectTipoBu(){
    //   System.out.println(""+Unidad_Selector.getSelectionModel().getSelectedIndex()+"  "+Unidades.size());
    try{
        
         if((Unidad_Selector.getSelectionModel().getSelectedIndex()+1)>0&&Unidades.isEmpty()==false){
        TipoTransporteTExtfield.setText(Unidades.get(Unidad_Selector.getSelectionModel().getSelectedIndex()+1).get(2));
        
      }
    }catch(Exception e){
        System.out.println("error ocurrio");
    }
      
        
        
        
    }

    @FXML
    private void AddContacto(ActionEvent event) {
         int y=DataBase.insert_Encargado_Only(SelectedEmpresaName,  Nombre_ContactoCombo.getEditor().getText(), Tel_Contacto.getText(), Email_Contacto.getText());
                    if(y==0){
                        Message("Ocurrio un error al guardar la informacióm de contacto!");
                    }else if(y==1){
                        Message("El contacto: \nNombre: "+Nombre_ContactoCombo.getEditor().getText()+"\nTel: "+Tel_Contacto.getText()+"\nEmail: "+Email_Contacto.getText()+"\nHa sido registrado correctamente!");
                    }
    }

    @FXML
    private void AddEncargado(ActionEvent event) {
        
         if( Nombre_encargadoCombo.getEditor().getText().isEmpty()==false&&Tel_Encargado.getText().isEmpty()==false){
           int z=DataBase.insert_Enc_Contacto(SelectedEmpresaName,Nombre_encargadoCombo.getEditor().getText(),Tel_Encargado.getText());
            if(z==1){
                Message("El encargado: \nNombre: "+Nombre_encargadoCombo.getEditor().getText()+"\nTel: "+Tel_Encargado.getText()+"\nHa sido registrado correctamente!");
            }
       }else{
           Message("Asegurese de llenar la información de encargado!");
       }
        
    }

    @FXML
    private void AddEmpresa_Encargado1(ActionEvent event) {
        
         int x=DataBase.insert_Empresa_Principal(Name_EmpresaCombo.getEditor().getText());
               if(x==0){
                   Message("El nombre "+Name_EmpresaCombo.getEditor().getText()+" ya se encuentra registrado!");
               }else if(x==1){
                   Message(Name_EmpresaCombo.getEditor().getText()+" ha sido registrado!");
               }
    }

  /*  public void NombreConductor(){
        System.out.println("probando "+Unidad_Selector.getSelectionModel().getSelectedItem());
        try{
            if(Buscar==true&&Unidad_Selector.getSelectionModel().getSelectedItem().equals("Sin asignar")==false){
               
                        
                NumeroDeBUS=Integer.valueOf(Unidades.get(Unidad_Selector.getSelectionModel().getSelectedIndex()+1).get(2));   
            
            
        } 
        }
        catch(NullPointerException e){
        }
       
    }*/
 public  class Cliente {
         private  String Nombre;
 
      public Cliente(String fName) {
            this.Nombre = fName;
           
        }
 
        public String getNombre() {
            return Nombre;
        }
 
        public void setNombre(String fName) {
            Nombre=fName;
        }
}    

 
 
 
    @FXML
 public void Save_Update_Case(){
    boolean CheckStatus=Estado_Box.getSelectionModel().isEmpty();
    LoadSettings.LoadProperties();
    int ID_Usuario=DataBase.Read_User_Settings_Admin(Integer.valueOf(LoadSettings.GetPropertie("UserID")));
    String date,datemax="";
    
    /*if(Nombre_Encargado.getText().isEmpty()!=true&&Tel_Encargado.getText().isEmpty()!=true){
        
    }*/
    
    //&&SelectEnContacto>0
        System.out.println("prueba de valoares 2"+SelectedEncargado+"       +         "+SelectedEmpresaName);
     if(SelectedEncargado>0&&SelectedEmpresaName>0&&ChoferSelected>0&&UnidadSelected>0&&Case_estate_date.getValue()!=null
        &&Tel_Contacto.getText().isEmpty()!=true&&Email_Contacto.getText().isEmpty()!=true
        &&Pax.getText().isEmpty()!=true&&Cobrar_Conductor.getText().isEmpty()!=true&&Regreso_conductor.getText().isEmpty()!=true&&Regreso_conductor.getText().isEmpty()!=true&&Lugar_Salida.getText().isEmpty()!=true  
        &&Lugar_Destino.getText().isEmpty()!=true&&Precio.getText().isEmpty()!=true&&Fecha_Salida.getValue()!=null&&Fecha_Regreso.getValue()!=null&&Fecha_Maxima.getValue()!=null&&CheckStatus==false){
         
        LocalDate localDate = Case_estate_date.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));     
        Date Fecha = Date.from(instant);
         System.out.println("Fecha del pendient" +Fecha);
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         date = sdf.format(Fecha);
         LocalDate localDateMax = Fecha_Maxima.getValue();
         Instant instantMax = Instant.from(localDateMax.atStartOfDay(ZoneId.systemDefault()));  
         Date FechaM=Date.from(instantMax);
         datemax=sdf.format(FechaM);
           if(Update_Estate==false){
                numerodecaso=DataBase.Insert_ROle(Lugar_Destino.getText(), Lugar_Salida.getText(), Precio.getText(), Pax.getText().trim(),SelectedEncargado,
                 
                 formatDateTake1(Fecha_Salida.getValue(),Hora_Salida.getSelectionModel().getSelectedItem(),Minuto_Salida.getSelectionModel().getSelectedItem(),
                AMPM_Salida.getSelectionModel().getSelectedItem()),
                 formatDateTake1(Fecha_Regreso.getValue(),Hora_Regreso.getSelectionModel().getSelectedItem(),
                Minuto_Regreso.getSelectionModel().getSelectedItem(),AMPM_Regreso.getSelectionModel().getSelectedItem()),
                 
                UnidadSelected,Notas_Conductor.getText(),Cobrar_Conductor.getText(),Regreso_conductor.getText(),
                (String)Estado_Box.getSelectionModel().getSelectedItem(),date,
                Tipo_Moneda.getSelectionModel().getSelectedIndex(),Metodo_Pago.getSelectionModel().getSelectedIndex(),
                Double.parseDouble(ZeroValidation(Monto_Adelantado.getText())),SelectEnContacto,
               datemax,ChoferSelected,Comentarios.getText(),ID_Usuario,Recorrido_text.getText());//,Comentarios.getText(),ID_Usuario,
                if(numerodecaso==0){
                    System.out.println("fallo guardar casos");
                }
                Message_NewCase();
            } else{
                DataBase.Update_ROle(Lugar_Destino.getText(), Lugar_Salida.getText(), Precio.getText(), Pax.getText(),SelectedEncargado ,
                UnidadSelected, formatDateTake1(Fecha_Salida.getValue(),Hora_Salida.getSelectionModel().getSelectedItem(),Minuto_Salida.getSelectionModel().getSelectedItem(),
                AMPM_Salida.getSelectionModel().getSelectedItem()),formatDateTake1(Fecha_Regreso.getValue(),Hora_Regreso.getSelectionModel().getSelectedItem(),Minuto_Regreso.getSelectionModel().getSelectedItem(),
                AMPM_Regreso.getSelectionModel().getSelectedItem()),Notas_Conductor.getText(),Cobrar_Conductor.getText(),Regreso_conductor.getText(),(String)Estado_Box.getSelectionModel().getSelectedItem(),date,ID_Usuario,Caso,Comentarios.getText(),Tipo_Moneda.getSelectionModel().getSelectedIndex(),
                Metodo_Pago.getSelectionModel().getSelectedIndex(),Double.parseDouble(ZeroValidation(Monto_Adelantado.getText())),Recorrido_text.getText(),
                datemax,ChoferSelected,SelectEnContacto);
                Update_Estate=false;
                FindCaseFromPendientes(String.valueOf(numerodecaso));
                Message_UpdatedCase();
            }
     }else{
         
     Message("Porfavor complete todos los campos!");       
         
     }
 }
 
 
public void Message_UpdatedCase(){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alerta");
            alert.setHeaderText(null);
            alert.setContentText("Continuar con el mismo caso?");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
            stage.getIcons().add(icon);
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
               Comentarios.clear();
            } else {
                ClearEverything();
                 
            }    
} 
 
public void Message_NewCase(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerta");
            alert.setHeaderText(null);
           
            alert.setContentText("El nº de caso es 00"+numerodecaso+" ");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/Error.png"));
            stage.getIcons().add(icon);
           

            Optional<ButtonType> result = alert.showAndWait();
            ClearEverything();
           /* if (result.get() == ButtonType.OK){
                // ... user chose OK
                FindCaseFromPendientes(String.valueOf(numerodecaso));
            } else {
                ClearEverything();
                 
            }    */
}
 
 public String ZeroValidation(String A){
    String value="";
    if(A.isEmpty()==true){
        value="0";
    }else{
        value=A;
    }
    return value;
}
 
     public Date formatDateTake1(LocalDate a,String x,String y,String z){
         LocalDate localDate = a;
      
Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
Date Fecha = Date.from(instant);
   
    int hour=0;
    if(z.equals("PM")){
        hour=Integer.parseInt(x)+12;
    }else{
        hour=Integer.parseInt(x);
    }
  
    Date date=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
        SimpleDateFormat sfnl = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
        String d=simpleDateFormat.format(Fecha);
       String fecha=d+" "+hour+":"+y+" "+z;
         
    try {
       date=sfnl.parse(fecha);
        System.out.println("Revisar esta fecha para ver que se esta mandando "+date);
    } catch (ParseException ex) {
        Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  
       return date;

}
     
public UnaryOperator<Change>  TextSettup(int len){
  
   UnaryOperator<Change> rejectChange = c -> {
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
 
 
 
 public void TextLimit(){
     /*Name_Empresa.setTextFormatter(new TextFormatter(TextSettup(255)));*/
    /* Nombre_Contacto.setTextFormatter(new TextFormatter(TextSettup(255)));*/
     Email_Contacto.setTextFormatter(new TextFormatter(TextSettup(255)));
     Tel_Contacto.setTextFormatter(new TextFormatter(TextSettup(15)));
    /* Nombre_Encargado.setTextFormatter(new TextFormatter(TextSettup(255)));*/
     Tel_Encargado.setTextFormatter(new TextFormatter(TextSettup(15)));
 }
}

   
