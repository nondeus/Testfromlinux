/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.hssf.util.AreaReference;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
/**
 * FXML Controller class
 *
 * @author j_cas
 */
public class ReportsController implements Initializable {
     TravelManDataBase DataBase=new TravelManDataBase();
    @FXML
    private DatePicker Desde;
    @FXML
    private DatePicker Hasta;
    @FXML
    private ToggleGroup Report_Groupr;
    @FXML
    private Button CreateReport;
    @FXML
    private RadioButton Unidades;
    @FXML
    private RadioButton Pendiente;
    @FXML
    private RadioButton Porcliente;
    @FXML
    private RadioButton Mensual;
    @FXML
    private AnchorPane MainWIndows;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Unidades.setUserData("1");
        Pendiente.setUserData("2");
        Porcliente.setUserData("3");
        Mensual.setUserData("4");
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
    public void GenerateReports(){
        if(Desde.getValue()!=null&&Hasta.getValue()!=null){
            if(Desde.getValue().isBefore(Hasta.getValue())||Desde.getValue().isEqual(Hasta.getValue())){
            
            String option=Report_Groupr.getSelectedToggle().getUserData().toString();
            switch (option){
                case "1":
                       CreateUnidades(FileSaveDialog());
                    break;
                case "2":
                       PendientesXCobrar(FileSaveDialog());
                    break;
                case "3":
                    ConsumoXCliente(FileSaveDialog());
                    break;
                case "4":
                    Consumo_Mensual(FileSaveDialog());
                    break;
            }
            
            }else{
                Message("El rango de la segunda fecha debe ser igual o mayor a la primera!");  
            }
        }else{
            Message("Seleccione un rango de fechas!");            
        }
        
      
    }
    public void CreateUnidades(String Location){
        if(Location!=null){
         HashMap<Integer,ArrayList<String>>Data=DataBase.Search_UnitUsageRange(ConvertLocalDatetoDate(Desde.getValue()),ConvertLocalDatetoDate(Hasta.getValue()));
        System.out.println("tamano "+Data.size());
        String date,NewDateFormat;
        Date date1=null;
        FileOutputStream outputStream = null;
        try {
            
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Uso de unidades");
            
           
            Font font = workbook.createFont();
            font.setColor(HSSFColor.WHITE.index); 
            font.setFontName("Calibri");
            font.setFontHeightInPoints((short)11);
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            XSSFCellStyle HeaderStyle=workbook.createCellStyle();
            HeaderStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(102,153,255)));
            HeaderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            HeaderStyle.setFont(font);

            
            
             int rownum=0;
             Row row = sheet.createRow(rownum++);
             Cell cell = row.createCell(0);
             cell.setCellValue("Fecha de viaje");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(1);
             cell.setCellValue("Unidad");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(2);
             cell.setCellValue("# Pasajeros?");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(3);
             cell.setCellValue("Propietario de la unidad");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(4);
             cell.setCellValue("Nombre del Proveedor");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(5);
             cell.setCellValue("Destino");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(6);
             cell.setCellValue("Costo del viaje");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(7);
             cell.setCellValue("A/C?");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(8);
             cell.setCellValue("Chofer");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(9);
             cell.setCellValue("Periodo");
             cell.setCellStyle(HeaderStyle);
            
             int Size=Data.size();
             
           for(int z=1;z<=Size;z++){
               date=Data.get(z).get(0).substring(0, 10);
                try { 
                    date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
                  
                } catch (ParseException ex) {
                    Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                row = sheet.createRow(rownum++);
              
                cell = row.createCell(0);
                cell.setCellValue( new SimpleDateFormat("dd/MM/yyyy").format(date1));
                cell = row.createCell(1);
                cell.setCellValue(Data.get(z).get(1));
                cell = row.createCell(2);
                cell.setCellValue(Data.get(z).get(2));
                cell = row.createCell(3);
                cell.setCellValue(Data.get(z).get(3));
                cell = row.createCell(4);
               
                cell.setCellValue(Data.get(z).get(4));
                cell = row.createCell(5);
                cell.setCellValue(Data.get(z).get(5));
                cell = row.createCell(6);
                cell.setCellValue(Integer.valueOf(Data.get(z).get(6)));
                cell.setCellType(CellType.NUMERIC);
                cell = row.createCell(7);
                cell.setCellValue(Data.get(z).get(7));
                cell = row.createCell(8);
                cell.setCellValue(Data.get(z).get(8));
                cell = row.createCell(9);
                cell.setCellValue( new SimpleDateFormat("MMMM yyyy").format(date1));
                  if(rownum==3){
                      cell = row.createCell(11);
                      cell.setCellValue("Monto Generado por unidad");
                      cell.setCellStyle(HeaderStyle);
                      cell = row.createCell(14);
                      cell.setCellValue("Cantidad de viajes por proveedor");
                      cell.setCellStyle(HeaderStyle);
                      cell = row.createCell(17);
                      cell.setCellValue("Costo generado por proveedor");
                      cell.setCellStyle(HeaderStyle);
                }
             }
     
            
            
            AreaReference a=new AreaReference("A1:J"+(rownum));
            CellReference b=new CellReference("L5");
            XSSFPivotTable pivotTable = sheet.createPivotTable(a,b);
          
            pivotTable.addRowLabel(1);
            pivotTable.addRowLabel(0);
            pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 6); 
          
            
            CellReference c=new CellReference("O8");
            XSSFPivotTable pivotTable2 = sheet.createPivotTable(a,c);
            pivotTable2.addReportFilter(9);
            pivotTable2.addRowLabel(3);
            pivotTable2.addColumnLabel(DataConsolidateFunction.COUNT, 4);
            pivotTable2.addRowLabel(4);
            pivotTable2.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(4).setDataField(true);
              
              
            
            CellReference d=new CellReference("R8");
            XSSFPivotTable pivotTable3 = sheet.createPivotTable(a,d);
            pivotTable3.addReportFilter(9);
            pivotTable3.addRowLabel(3);
            pivotTable3.addRowLabel(4);
            pivotTable3.addColumnLabel(DataConsolidateFunction.SUM, 6); 
          /* pivotTable2.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(6).setDataField(true);*/
            
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(11);
            sheet.autoSizeColumn(12);
            sheet.autoSizeColumn(13);
            sheet.autoSizeColumn(14);
            sheet.autoSizeColumn(15);
            sheet.autoSizeColumn(16);
            sheet.autoSizeColumn(17);
            sheet.autoSizeColumn(18);
            sheet.autoSizeColumn(19);
            outputStream = new FileOutputStream(Location);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();
             Message("Se ha creado el documento correctamente en:\n!"+Location);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }else{
            Message("Seleccione un nombre y ubicación!");
        }
    }


 public void PendientesXCobrar(String Location){
     if(Location!=null){
         try {
             
             HashMap<Integer,ArrayList<String>>Data=DataBase.Search_PendientesXCobrar(ConvertLocalDatetoDate(Desde.getValue()),ConvertLocalDatetoDate(Hasta.getValue()));
             System.out.println("tamano "+Data.size());
             String Metodo="";
             String date,NewDateFormat;
             Date date1=null;
             FileOutputStream outputStream = null;
             XSSFWorkbook workbook = new XSSFWorkbook();
             XSSFSheet sheet = workbook.createSheet("Pendientes por cobrar");
             Font font = workbook.createFont();
             font.setColor(HSSFColor.WHITE.index);
             font.setFontName("Calibri");
             font.setFontHeightInPoints((short)11);
             font.setBoldweight(Font.BOLDWEIGHT_BOLD);
             
             XSSFCellStyle HeaderStyle=workbook.createCellStyle();
             HeaderStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(102,153,255)));
             HeaderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
             HeaderStyle.setFont(font);
             
              CellStyle ColonesStyle=workbook.createCellStyle();
            DataFormat df = workbook.createDataFormat();
            ColonesStyle.setDataFormat(df.getFormat("[$₡-140A] # ##0,00;[RED]-[$₡-140A] # ##0,00"));
            
            
            CellStyle DollarStyle=workbook.createCellStyle();
            DataFormat cf = workbook.createDataFormat();
            DollarStyle.setDataFormat(df.getFormat("[$$-409]# ##0,00;[RED]-[$$-409]# ##0,00"));
            
             int rownum=0;
             Row row = sheet.createRow(rownum++);
             Cell cell = row.createCell(0);
             cell.setCellValue("Fecha del Servicio");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(1);
             cell.setCellValue("Numero de caso");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(2);
             cell.setCellValue("Cliente");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(3);
             cell.setCellValue("Destino");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(4);
             cell.setCellValue("# Pasajeros");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(5);
             cell.setCellValue("Encargado");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(6);
             cell.setCellValue("Forma de pago");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(7);
             cell.setCellValue("Monto Total");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(8);
             cell.setCellValue("Monto por Cobrar");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(9);
             cell.setCellValue("Lugar de facturacion");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(10);
             cell.setCellValue("Lugar de cobro");
             cell.setCellStyle(HeaderStyle);
              cell = row.createCell(11);
             cell.setCellValue("Fecha para cobrar");
             cell.setCellStyle(HeaderStyle);
              cell = row.createCell(12);
             cell.setCellValue("Fecha maxima para cobrar");
             cell.setCellStyle(HeaderStyle);
            
             int Size=Data.size();
             for(int z=1;z<=Size;z++){
              
               date1= new SimpleDateFormat("yyyy-MM-dd").parse(Data.get(z).get(0).substring(0, 10));
                row = sheet.createRow(rownum++);  
                cell = row.createCell(0);
                cell.setCellValue( new SimpleDateFormat("dd/MM/yyyy").format(date1));
                cell = row.createCell(1);
                cell.setCellValue(Data.get(z).get(1));
                cell = row.createCell(2);
                cell.setCellValue(Data.get(z).get(2));
                cell = row.createCell(3);
                cell.setCellValue(Data.get(z).get(3));
                cell = row.createCell(4);
                cell.setCellValue(Data.get(z).get(4));
                cell = row.createCell(5);
                cell.setCellValue(Data.get(z).get(5));
                cell = row.createCell(6);
                
                switch(Data.get(z).get(6)){
                    case "0":
                        Metodo="Efectivo";
                            break;
                    case "1":
                         Metodo="Transferencia. B";
                            break;
                    case "2":
                         Metodo="Cheque";
                            break;
                }
                
                cell.setCellValue(Metodo);
                cell = row.createCell(7);
                cell.setCellValue(Integer.valueOf(Data.get(z).get(7)));
                 cell.setCellType(CellType.NUMERIC);
                if(Integer.valueOf(Data.get(z).get(11))==0){
                    cell.setCellStyle(ColonesStyle);
                }
                else{
                      cell.setCellStyle(DollarStyle);
                
                }
                
                cell = row.createCell(8);
                cell.setCellValue(Integer.valueOf(Data.get(z).get(8)));
                cell.setCellType(CellType.NUMERIC);
                 if(Integer.valueOf(Data.get(z).get(11))==0){
                    cell.setCellStyle(ColonesStyle);
                }
                else{
                      cell.setCellStyle(DollarStyle);
                
                }
                 
                cell = row.createCell(11);
                cell.setCellValue(Data.get(z).get(9));
                cell = row.createCell(12);
                cell.setCellValue(Data.get(z).get(10));
             }
             
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(11);
            sheet.autoSizeColumn(12);
            
             outputStream = new FileOutputStream(Location);
             workbook.write(outputStream);
             outputStream.close();
              Message("Se ha creado el documento correctamente en:\n!"+Location);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ParseException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }

     }
 }    
public void ConsumoXCliente(String Location){
     if(Location!=null){
         String Metodo="";
         HashMap<Integer,ArrayList<String>>Data=DataBase.Search_ConsumoXCliente(ConvertLocalDatetoDate(Desde.getValue()),ConvertLocalDatetoDate(Hasta.getValue()));
         FileOutputStream outputStream = null;
             XSSFWorkbook workbook = new XSSFWorkbook();
             XSSFSheet sheet = workbook.createSheet("Consumo por cliente");
             
             Font font = workbook.createFont();
             font.setColor(HSSFColor.WHITE.index);
             font.setFontName("Calibri");
             font.setFontHeightInPoints((short)11);
             font.setBoldweight(Font.BOLDWEIGHT_BOLD);
             
             XSSFCellStyle HeaderStyle=workbook.createCellStyle();
             HeaderStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(102,153,255)));
             HeaderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
             HeaderStyle.setFont(font);
             
             CellStyle ColonesStyle=workbook.createCellStyle();
            DataFormat df = workbook.createDataFormat();
            ColonesStyle.setDataFormat(df.getFormat("[$₡-140A] # ##0,00;[RED]-[$₡-140A] # ##0,00"));
            
            
            CellStyle DollarStyle=workbook.createCellStyle();
            DataFormat cf = workbook.createDataFormat();
            DollarStyle.setDataFormat(df.getFormat("[$$-409]# ##0,00;[RED]-[$$-409]# ##0,00"));
             
             int rownum=0;
             Row row = sheet.createRow(rownum++);
             Cell cell = row.createCell(0);
             cell.setCellValue("Cliente");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(1);
             cell.setCellValue("Destino");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(2);
             cell.setCellValue("Unidad");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(3);
             cell.setCellValue("# Pasajeros");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(4);
             cell.setCellValue("Encargado");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(5);
             cell.setCellValue("Forma de pago");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(6);
             cell.setCellValue("Monto Total");
             cell.setCellStyle(HeaderStyle);
             
             
             int Size=Data.size();
             for(int z=1;z<=Size;z++){
                 row = sheet.createRow(rownum++);  
                cell = row.createCell(0);
                cell.setCellValue(Data.get(z).get(0));
                cell = row.createCell(1);
                cell.setCellValue(Data.get(z).get(1));
                cell = row.createCell(2);
                cell.setCellValue(Data.get(z).get(2));
                cell = row.createCell(3);
                cell.setCellValue(Data.get(z).get(3));
                cell = row.createCell(4);
                cell.setCellValue(Data.get(z).get(4));
                
                 switch(Data.get(z).get(5)){
                    case "0":
                        Metodo="Efectivo";
                            break;
                    case "1":
                         Metodo="Transferencia. B";
                            break;
                    case "2":
                         Metodo="Cheque";
                            break;
                }
                
                cell = row.createCell(5);
                cell.setCellValue(Metodo);
                
                cell = row.createCell(6);
                
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(Integer.valueOf(Data.get(z).get(6)));
                
                 if(Integer.valueOf(Data.get(z).get(7))==0){
                    cell.setCellStyle(ColonesStyle);
                }
                else{
                      cell.setCellStyle(DollarStyle);
                
                }
                 
             }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
         try {
             outputStream = new FileOutputStream(Location);
             workbook.write(outputStream);
            outputStream.close();
             Message("Se ha creado el documento correctamente en:\n!"+Location);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
     }
}  


public void Consumo_Mensual(String Location){
     String Metodo="";
         HashMap<Integer,ArrayList<String>>Data=DataBase.Search_Consumo_Mensual(ConvertLocalDatetoDate(Desde.getValue()),ConvertLocalDatetoDate(Hasta.getValue()));
           FileOutputStream outputStream = null;
             XSSFWorkbook workbook = new XSSFWorkbook();
             XSSFSheet sheet = workbook.createSheet("Consumo mensual");
             
             Font font = workbook.createFont();
             font.setColor(HSSFColor.WHITE.index);
             font.setFontName("Calibri");
             font.setFontHeightInPoints((short)11);
             font.setBoldweight(Font.BOLDWEIGHT_BOLD);
             
             XSSFCellStyle HeaderStyle=workbook.createCellStyle();
             HeaderStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(102,153,255)));
             HeaderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
             HeaderStyle.setFont(font);
             
            CellStyle ColonesStyle=workbook.createCellStyle();
            DataFormat df = workbook.createDataFormat();
            ColonesStyle.setDataFormat(df.getFormat("[$₡-140A] # ##0,00;[RED]-[$₡-140A] # ##0,00"));
            
            
            CellStyle DollarStyle=workbook.createCellStyle();
            DataFormat cf = workbook.createDataFormat();
            DollarStyle.setDataFormat(df.getFormat("[$$-409]# ##0,00;[RED]-[$$-409]# ##0,00"));
             
             int rownum=0;
             Row row = sheet.createRow(rownum++);
             Cell cell = row.createCell(0);
             cell.setCellValue("Unidad");
             cell.setCellStyle(HeaderStyle);
             cell = row.createCell(1);
             cell.setCellValue("Costo Total");
             cell.setCellStyle(HeaderStyle);
             
             int Size=Data.size();
             for(int z=1;z<=Size;z++){
                 row = sheet.createRow(rownum++);  
                cell = row.createCell(0);
                cell.setCellValue(Data.get(z).get(0));
                cell = row.createCell(1);
                cell.setCellValue(Integer.valueOf(Data.get(z).get(1)));
                cell.setCellType(CellType.NUMERIC);
                if(Integer.valueOf(Data.get(z).get(2))==0){
                    cell.setCellStyle(ColonesStyle);
                }
                else{
                      cell.setCellStyle(DollarStyle);
                
                }
             }
             sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            
            
         try {
             outputStream = new FileOutputStream(Location);
             workbook.write(outputStream);
            outputStream.close();
             Message("Se ha creado el documento correctamente en:\n!"+Location);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
             
}
public Date ConvertLocalDatetoDate(LocalDate date){
    Instant instant = Instant.from(date.atStartOfDay(ZoneId.systemDefault()));     
    Date Fecha = Date.from(instant);
    return Fecha;
}


public String FileSaveDialog(){
    String Address="";
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Documento de excel (*.xlsx)", "*.xlsx");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showSaveDialog((Stage) MainWIndows.getScene().getWindow());
    if(file!=null){
        Address=file.toString();
    }
    return Address;
}
}
