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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Josimar
 */
public class Rolexchofer_Excel {
    String name=null;
     XSSFWorkbook workbook = new XSSFWorkbook();





    public void CreateRolexChofer(HashMap<Integer,ArrayList<String>>myMap){
       int Start=1;
       int End=5;
        
      XSSFSheet sheet = workbook.createSheet("Role para Chofer");
        Date prueba=new Date();
       SimpleDateFormat formateador = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' yyyy",new Locale("es", "ES"));
       
         SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         SimpleDateFormat formatTime= new SimpleDateFormat("hh:mm a");
         String Fecha;
         Date hora=null;
        HashMap<Integer,ArrayList<String>>Data=myMap;  
        
Set<Integer> keyset = Data.keySet();
int rownum=0;

Font font = workbook.createFont();
font.setColor(HSSFColor.WHITE.index); 
font.setFontName("Calibri");
font.setFontHeightInPoints((short)11);
font.setBoldweight(Font.BOLDWEIGHT_BOLD);
XSSFCellStyle CellStyle_BoldstyleGeneric=workbook.createCellStyle();
CellStyle_BoldstyleGeneric.setFillForegroundColor(HSSFColor.BLACK.index);
CellStyle_BoldstyleGeneric.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
CellStyle_BoldstyleGeneric.setFont(font);




Font Fontdos = workbook.createFont();
Fontdos.setColor(HSSFColor.WHITE.index); 
Fontdos.setFontName("Calibri");
Fontdos.setFontHeightInPoints((short)16);
Fontdos.setBoldweight(Font.BOLDWEIGHT_BOLD);
XSSFCellStyle FormatoDos=workbook.createCellStyle();
FormatoDos.setFillForegroundColor(HSSFColor.BLACK.index);
FormatoDos.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
FormatoDos.setFont(Fontdos);



Font Fonttres = workbook.createFont();
Fonttres.setColor(HSSFColor.BLACK.index); 
Fonttres.setFontName("Calibri");
Fonttres.setFontHeightInPoints((short)16);
Fonttres.setBoldweight(Font.BOLDWEIGHT_BOLD);
XSSFCellStyle FormatoTres=workbook.createCellStyle();
FormatoTres.setFont(Fonttres);




Font fontCuatro = workbook.createFont();
fontCuatro.setColor(HSSFColor.WHITE.index); 
fontCuatro.setFontName("Calibri");
fontCuatro.setFontHeightInPoints((short)12);
fontCuatro.setBoldweight(Font.BOLDWEIGHT_BOLD);
XSSFCellStyle FormatoCuatro=workbook.createCellStyle();
FormatoCuatro.setFillForegroundColor(HSSFColor.BLACK.index);
FormatoCuatro.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
FormatoCuatro.setFont(fontCuatro);




Font FontCinco = workbook.createFont();
FontCinco.setColor(HSSFColor.BLACK.index); 
FontCinco.setFontName("Calibri");
FontCinco.setFontHeightInPoints((short)12);
FontCinco.setBoldweight(Font.BOLDWEIGHT_BOLD);
XSSFCellStyle FormatoCinco=workbook.createCellStyle();
FormatoCinco.setFont(FontCinco);



Font FontSeis = workbook.createFont();
FontSeis.setColor(HSSFColor.BLACK.index); 
FontSeis.setFontName("Calibri");
FontSeis.setFontHeightInPoints((short)11);
FontSeis.setBoldweight(Font.BOLDWEIGHT_BOLD);
XSSFCellStyle FormatoSeis=workbook.createCellStyle();
FormatoSeis.setFont(FontSeis);

Font FontSiete = workbook.createFont();
FontSiete.setColor(HSSFColor.BLACK.index); 
FontSiete.setFontName("Calibri");
FontSiete.setFontHeightInPoints((short)11);
XSSFCellStyle FormatoSiete=workbook.createCellStyle();
FormatoSiete.setFont(FontSiete);




      for(int z=1;z<=Data.size();z++){
              sheet.addMergedRegion(new CellRangeAddress(rownum,rownum,0,2));
              sheet.addMergedRegion(new CellRangeAddress(rownum,rownum,3,5));
              sheet.addMergedRegion(new CellRangeAddress(rownum,rownum,6,11));
                 Row row = sheet.createRow(rownum++); 
                 
                 
                 
               
                 
                            ArrayList<String> objArr = Data.get(z);
                            objArr.get(1);
                            Object obj=objArr.get(1)+" "+objArr.get(0);
                            
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(0);
                        
                        
                    cell.setCellValue((String)obj);
                        cell.setCellStyle(FormatoTres);
                   
                    cell=row.createCell(1);
                        cell.setCellValue("");
                       
                    cell=row.createCell(2);
                        cell.setCellValue("");
                       
                    cell=row.createCell(3);
                        cell.setCellValue("ESTAR EN KWT");
                            cell.setCellStyle(FormatoDos);
                    
                    cell=row.createCell(4);
                   
                    cell=row.createCell(5);
                   
                    cell=row.createCell(6);
                   
            try {
                    cell.setCellValue(formateador.format(formatDate.parse(objArr.get(6))));
                        cell.setCellStyle(FormatoTres);
                  
            } catch (ParseException ex) {
                Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
            }
  
                    cell=row.createCell(7);
                    
                    cell=row.createCell(8);
                   
                    cell=row.createCell(9);
                   
                    cell=row.createCell(10);
                  
                    cell=row.createCell(11);
                  
                 
                row=sheet.createRow(rownum++);
                
                    cell = row.createCell(0);
                        cell.setCellValue(z);
                            cell.setCellStyle(FormatoCuatro);
                   
                    cell = row.createCell(1);
                        cell.setCellValue("SALIDA");
                            cell.setCellStyle(CellStyle_BoldstyleGeneric);
                 
                    cell = row.createCell(2);
              
              
                            String date=objArr.get(6);
                            date=date.substring(0,date.length()-2);
                            try {
                                hora=formatDate.parse(date);
                                Fecha=formatDate.format(formatDate.parse(date));
                   
                                } catch (ParseException ex) {
                                Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                    cell.setCellValue((formatTime.format(hora)));
                        cell.setCellStyle(FormatoCinco);
                
                    cell = row.createCell(3);
                        cell.setCellValue(objArr.get(3));
                            cell.setCellStyle(FormatoSiete);
               
                    cell = row.createCell(11);
                 
                    
                row = sheet.createRow(rownum++);
                    cell = row.createCell(0);
                        cell.setCellValue("");
               
                    cell = row.createCell(1);
                        cell.setCellValue("DESTINO");
                            cell.setCellStyle(CellStyle_BoldstyleGeneric);
                 
                    cell = row.createCell(2);
                        cell.setCellValue(objArr.get(2));
                            cell.setCellStyle(FormatoSiete);
                 
                    cell = row.createCell(11);
                 
                 
                row = sheet.createRow(rownum++);
                    cell = row.createCell(0);
                        cell.setCellValue(""); 
                
                    cell = row.createCell(1);
                        cell.setCellValue("ENCARGADO");
                            cell.setCellStyle(CellStyle_BoldstyleGeneric);
                
                    cell = row.createCell(2);
                        cell.setCellValue(objArr.get(4));
                            cell.setCellStyle(FormatoSiete);
               
                    cell = row.createCell(5);
                        cell.setCellValue("TELEFONOS"); 
                            cell.setCellStyle(CellStyle_BoldstyleGeneric);
                            
                    cell = row.createCell(6);
                        cell.setCellValue(objArr.get(5)); 
                            cell.setCellStyle(FormatoSiete);
                
                    cell = row.createCell(8);
                        cell.setCellValue("REGRESO:");
                            cell.setCellStyle(CellStyle_BoldstyleGeneric);
                 
                    cell = row.createCell(9);
                        cell.setCellValue(objArr.get(11));
                            cell.setCellStyle(FormatoSiete);

                        
                    cell = row.createCell(11);
                             
                row = sheet.createRow(rownum++);
                    cell = row.createCell(0);
                        cell.setCellValue(""); 
             
                    cell = row.createCell(1);
                        cell.setCellValue("COBRAR"); 
                            cell.setCellStyle(CellStyle_BoldstyleGeneric);
                 
                    cell = row.createCell(2);
                        cell.setCellValue(objArr.get(12));
                            cell.setCellStyle(FormatoSeis);

                
                    cell = row.createCell(3);
                 
                  
                    cell = row.createCell(4);
                        cell.setCellValue("NOTAS:");
                            cell.setCellStyle(CellStyle_BoldstyleGeneric);
                 
                    cell = row.createCell(5);
                        cell.setCellValue(objArr.get(8));
                            cell.setCellStyle(FormatoSeis);

              
                    cell = row.createCell(6);
                
                    cell = row.createCell(7);
               
                    cell = row.createCell(8);
                
                    cell = row.createCell(9);
               
                    cell = row.createCell(10);
               
                    cell = row.createCell(11);
               
                row = sheet.createRow(rownum++);
                
                
                
                CellRangeAddress TopB = org.apache.poi.ss.util.CellRangeAddress.valueOf("A"+Start+":L"+Start) ;
                CellRangeAddress BottonB = org.apache.poi.ss.util.CellRangeAddress.valueOf("A"+End+":L"+End) ;
                CellRangeAddress LeftB = org.apache.poi.ss.util.CellRangeAddress.valueOf("A"+Start+":A"+(Start+4)) ;
                CellRangeAddress RightB = org.apache.poi.ss.util.CellRangeAddress.valueOf("L"+Start+":L"+(Start+4)) ;
                short borderStyle_Botton =HSSFCellStyle.BORDER_MEDIUM;       
                RegionUtil.setBorderTop(borderStyle_Botton, TopB, sheet, workbook);
                RegionUtil.setBorderBottom(borderStyle_Botton, TopB, sheet, workbook);
                RegionUtil.setBorderBottom(borderStyle_Botton, BottonB, sheet, workbook);
                RegionUtil.setBorderLeft(borderStyle_Botton, LeftB, sheet, workbook);
                RegionUtil.setBorderRight(borderStyle_Botton, RightB, sheet, workbook);
                
                Start+=6;
                End+=6;
    } 
       
sheet.autoSizeColumn(0);
       sheet.autoSizeColumn(1);
       /*sheet.autoSizeColumn(2);*/
       sheet.setColumnWidth(2, 6000);
       sheet.autoSizeColumn(3);
       sheet.autoSizeColumn(4);
       sheet.autoSizeColumn(5);
       sheet.autoSizeColumn(6);
       sheet.autoSizeColumn(7);
       sheet.autoSizeColumn(8);
       sheet.autoSizeColumn(9);
       sheet.autoSizeColumn(10);
       sheet.autoSizeColumn(11);
       sheet.setFitToPage(true);
 /*FileOutputStream out;
        try {
            out = new FileOutputStream(new File(path));
            workbook.write(out);
    out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
}
  
public String SelectingFileName(){
      String filename="";
       File fileToSave=null;
      JFileChooser FL=new JFileChooser();
    FL.setDialogTitle("Guardar como");
   // FL.setSelectedFile(new File(filename));
    FileFilter filter = new FileNameExtensionFilter("Excel Workbook (*.xlsx)", new String[] {".xlsx"});
    FL.setFileFilter(filter);
    FL.setSelectedFile(new File("fileToSave"));
    
    int userSelection = FL.showSaveDialog(null);
      if (userSelection == JFileChooser.APPROVE_OPTION) {
           
           fileToSave = FL.getSelectedFile();
           
          filename=FL.getCurrentDirectory().getAbsolutePath()+"/"+fileToSave.getName()+".xlsx"; 
          System.out.println("path "+filename);
            //filename=fileToSave.getName();
           
            
           
      }else if(userSelection==JFileChooser.CANCEL_OPTION){
          System.out.println("no se hizo nada");
           //filename="NO";
}
        System.out.println("path "+filename); 
    
        return filename;
}

 
 
 
 public void CreateHojaDeRole(HashMap<Integer,ArrayList<String>>myMap){
     XSSFSheet sheet_1 = workbook.createSheet("Hoja de Role");
      HashMap<Integer,ArrayList<String>>Data=myMap;  
      Set<Integer> keyset = Data.keySet();  
      int rownum=0;
      int Start=2;
      
      
      SimpleDateFormat formateador = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' yyyy HH:mm a",new Locale("es", "ES"));
      SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm a",new Locale("es", "ES"));
       SimpleDateFormat fechas = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' yyyy",new Locale("es", "ES"));
        
        
Font font = workbook.createFont();
font.setColor(HSSFColor.WHITE.index); 
font.setFontName("Arial");
font.setFontHeightInPoints((short)9);
font.setBoldweight(Font.BOLDWEIGHT_BOLD);
XSSFCellStyle CellStyle_BoldstyleGeneric=workbook.createCellStyle();
CellStyle_BoldstyleGeneric.setFillForegroundColor(HSSFColor.GREEN.index);
CellStyle_BoldstyleGeneric.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
CellStyle_BoldstyleGeneric.setFont(font);
CellStyle_BoldstyleGeneric.setBorderBottom(HSSFCellStyle.BORDER_THIN);
CellStyle_BoldstyleGeneric.setBorderTop(HSSFCellStyle.BORDER_THIN);
CellStyle_BoldstyleGeneric.setBorderRight(HSSFCellStyle.BORDER_THIN);
CellStyle_BoldstyleGeneric.setBorderLeft(HSSFCellStyle.BORDER_THIN);


Font Font2 = workbook.createFont();
Font2.setColor(HSSFColor.BLACK.index); 
Font2.setFontName("Arial");
Font2.setFontHeightInPoints((short)9);
Font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
XSSFCellStyle Estilo_1=workbook.createCellStyle();
/*Estilo_1.setFillForegroundColor(HSSFColor.WHITE.index);
Estilo_1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);*/
Estilo_1.setFont(Font2);
Estilo_1.setBorderBottom(BorderStyle.NONE);
      




Font Font3 = workbook.createFont();
Font3.setColor(HSSFColor.RED.index); 
Font3.setFontName("Arial");
Font3.setFontHeightInPoints((short)9);
Font3.setBoldweight(Font.BOLDWEIGHT_BOLD);


Font Font4 = workbook.createFont();
Font4.setFontName("Calibri");
Font4.setFontHeightInPoints((short)14);

XSSFCellStyle Estilo_2=workbook.createCellStyle();
Estilo_2.setFillForegroundColor(HSSFColor.WHITE.index);
Estilo_2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
Estilo_2.setFont(Font3);

XSSFCellStyle Estilo_3=workbook.createCellStyle();
Estilo_3.setFillForegroundColor(HSSFColor.WHITE.index);
Estilo_3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
Estilo_3.setFont(Font2);
Estilo_3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      
XSSFCellStyle Estilo_4=workbook.createCellStyle();
Estilo_4.setFillForegroundColor(HSSFColor.WHITE.index);
Estilo_4.setBorderBottom(HSSFCellStyle.BORDER_THIN);
Estilo_4.setBorderLeft(HSSFCellStyle.BORDER_THIN);

XSSFCellStyle Estilo_5=workbook.createCellStyle();
Estilo_5.setFillForegroundColor(HSSFColor.WHITE.index);
Estilo_5.setBorderBottom(HSSFCellStyle.BORDER_THIN);
Estilo_5.setBorderRight(HSSFCellStyle.BORDER_THIN);

XSSFCellStyle Estilo_6=workbook.createCellStyle();
Estilo_6.setFillForegroundColor(HSSFColor.WHITE.index);
Estilo_6.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
Estilo_6.setBorderRight(HSSFCellStyle.BORDER_THIN);
Estilo_6.setFont(Font3);



XSSFCellStyle Estilo_7=workbook.createCellStyle();
/*Estilo_1.setFillForegroundColor(HSSFColor.WHITE.index);
Estilo_1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);*/
Estilo_7.setFont(Font2);
Estilo_7.setBorderRight(HSSFCellStyle.BORDER_THIN);

XSSFCellStyle Estilo_8=workbook.createCellStyle();
Estilo_8.setFillForegroundColor(HSSFColor.WHITE.index);
Estilo_8.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
Estilo_8.setFont(Font4);
Estilo_8.setAlignment(HSSFCellStyle.ALIGN_CENTER);


XSSFCellStyle Estilo_9=workbook.createCellStyle();
Estilo_9.setFont(Font2);
Estilo_9.setBorderBottom(BorderStyle.NONE);
Estilo_9.setWrapText(true);

       for(int z=1;z<=Data.size();z++){
           sheet_1.addMergedRegion(new CellRangeAddress(rownum,rownum,0,8));
        Row row = sheet_1.createRow(rownum++); 
        
            org.apache.poi.ss.usermodel.Cell cell = row.createCell(0);
             ArrayList<String> objArr = Data.get(z);
             
               try {
             // cell.setCellValue((String)objArr.get(4)+"  -  "+(String)objArr.get(5));
             cell.setCellValue(fechas.format(formatDate.parse(objArr.get(4))));
             cell.setCellStyle(Estilo_8);
         } catch (ParseException ex) {
             Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        row=sheet_1.createRow(rownum++);   
            cell = row.createCell(0);
                cell.setCellValue("");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
            cell = row.createCell(1);
                cell.setCellValue("Lugar de destino");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
                    
            cell = row.createCell(2);
                cell.setCellValue("Precio");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
            cell = row.createCell(3);
                cell.setCellValue("Salida");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
            cell = row.createCell(4);
                cell.setCellValue("Pax");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
            cell = row.createCell(5);
                cell.setCellValue("Horario");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
            cell = row.createCell(6);
                cell.setCellValue("Cliente");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
            cell = row.createCell(7);
                cell.setCellValue("Teléfono");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
            cell = row.createCell(8);
                cell.setCellValue("Unidad");
                    cell.setCellStyle(CellStyle_BoldstyleGeneric);
           
           
           
                    
                    
                    
        row = sheet_1.createRow(rownum++); 
           
            
            cell = row.createCell(0);
                cell.setCellValue(z);
                     cell.setCellStyle(CellStyle_BoldstyleGeneric);
                    
            cell = row.createCell(1);
                cell.setCellValue((String)objArr.get(0));
                    cell.setCellStyle(Estilo_9);
            cell = row.createCell(2);
            String TipoMoneda;
                if(objArr.get(10).equals("0")){
                    TipoMoneda="₡"+(String)objArr.get(1);
                }else{
                    TipoMoneda="$"+(String)objArr.get(1);
                }
                cell.setCellValue(TipoMoneda);//Precio
                
                    cell.setCellStyle(Estilo_1);
            cell = row.createCell(3);
                cell.setCellValue((String)objArr.get(2));
                
                    cell.setCellStyle(Estilo_9);
            cell = row.createCell(4);
                cell.setCellValue((String)objArr.get(3));
                    cell.setCellStyle(Estilo_1);
            cell = row.createCell(5);
         try {
             // cell.setCellValue((String)objArr.get(4)+"  -  "+(String)objArr.get(5));
             System.out.println("objeto 4"+objArr.get(4));
             if(objArr.get(4).equals(objArr.get(5))){
                   cell.setCellValue(hora.format(formatDate.parse(objArr.get(4)))+"  -  N/A");
                   System.out.println("entered check dates are equals");
             }else{
                  cell.setCellValue(hora.format(formatDate.parse(objArr.get(4)))+"  -  "+hora.format(formatDate.parse(objArr.get(5))));
             }
            
         } catch (ParseException ex) {
             Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
         }
                    cell.setCellStyle(Estilo_1);
            cell = row.createCell(6);
                cell.setCellValue((String)objArr.get(6));
                    cell.setCellStyle(Estilo_1);
            cell = row.createCell(7);
                cell.setCellValue((String)objArr.get(7));
                    cell.setCellStyle(Estilo_7);
            cell = row.createCell(8);
                cell.setCellValue((String)objArr.get(8)+" "+(String)objArr.get(9));
                    cell.setCellStyle(Estilo_6);
       
                    
                    
                    
                    
                        
        row = sheet_1.createRow(rownum++); 
            cell = row.createCell(0);
                cell.setCellStyle(Estilo_4);
            cell = row.createCell(1);
             
                cell.setCellStyle(Estilo_3);
            cell = row.createCell(2);
                cell.setCellStyle(Estilo_3);
            cell = row.createCell(3);
                cell.setCellStyle(Estilo_3);
            cell = row.createCell(4);
                cell.setCellStyle(Estilo_3);
            cell = row.createCell(5);
                cell.setCellStyle(Estilo_3);  
            cell = row.createCell(6);
                cell.setCellStyle(Estilo_3);
            cell = row.createCell(7);
                cell.setCellStyle(Estilo_5);
            cell = row.createCell(8);
                cell.setCellStyle(Estilo_5);
                
                
                  
             
                
                
          /* CellRangeAddress TopBorder = org.apache.poi.ss.util.CellRangeAddress.valueOf("A"+Start+":I"+Start) ;
           CellRangeAddress BottonBorder = org.apache.poi.ss.util.CellRangeAddress.valueOf("A"+(Start+1)+":I"+(Start+1)); 
           CellRangeAddress RightBorder = org.apache.poi.ss.util.CellRangeAddress.valueOf("I"+Start+":I"+(Start+1)); 
           CellRangeAddress LeftBorder = org.apache.poi.ss.util.CellRangeAddress.valueOf("A"+Start+":A"+(Start+1)); 
           CellRangeAddress LeftBorder_I = org.apache.poi.ss.util.CellRangeAddress.valueOf("I"+Start+":I"+(Start+1));
           
                short borderStyle_Botton =HSSFCellStyle.BORDER_THIN;       
                    RegionUtil.setBorderTop(borderStyle_Botton, TopBorder, sheet_1, workbook);
                    RegionUtil.setBorderBottom(borderStyle_Botton, BottonBorder, sheet_1, workbook);
                    RegionUtil.setBorderRight(borderStyle_Botton, RightBorder, sheet_1, workbook);
                    RegionUtil.setBorderLeft(borderStyle_Botton, LeftBorder, sheet_1, workbook);
                    RegionUtil.setBorderLeft(borderStyle_Botton, LeftBorder_I, sheet_1, workbook);
                    
                    Start+=2;*/
       }
       
       sheet_1.autoSizeColumn(0);
      /* sheet_1.autoSizeColumn(1);*/
       sheet_1.autoSizeColumn(2);
       /*sheet_1.autoSizeColumn(3);*/
       sheet_1.autoSizeColumn(4);
       sheet_1.autoSizeColumn(5);
       sheet_1.autoSizeColumn(6);
       sheet_1.autoSizeColumn(7);
       sheet_1.autoSizeColumn(8);
       sheet_1.setColumnWidth(1, 7000);
       sheet_1.setColumnWidth(3, 7000);
       sheet_1.setFitToPage(true);
       /* FileOutputStream out;
        try {
            out = new FileOutputStream(new File(path));
            workbook.write(out);
    out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    */

       
 }
 
 
    public void SaveExcelFile(String path){
        FileOutputStream out;
        try {
            out = new FileOutputStream(new File(path));
             workbook.write(out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rolexchofer_Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}
