package testsceneswitch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Josimar
 */
public class TravelManDataBase {
//Main2 main = new Main2();

    /**
     * @param args the command line arguments
     */
    
    String Cont="jdbc:mysql://localhost:3306/travelman";
    String DataBaseConnection="jdbc:mysql://";
  Config_ajustes SaveSettings=new Config_ajustes();
 
    public String TestConnection(String DBName,String DBIP,String DBPort,String DBUser,String DBPass){
         String Error="Se establecio la conexion!";
         boolean a=false;
        try {
             
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
              DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=DBIP+":"+DBPort+"/"+DBName;
            System.out.println("data base "+DataBaseConnection);
            Connection Con=DriverManager.getConnection(DataBaseConnection,DBUser,DBPass);
             if(Con.isValid(5)==true){
                 System.out.println("datos correctos");
                 SaveSettings.setPropertiesValues("DBName",DBName);
                 SaveSettings.setPropertiesValues("DBIP",DBIP);
                 SaveSettings.setPropertiesValues("DBPort",DBPort);
                 SaveSettings.setPropertiesValues("DBUser",DBUser);
                 SaveSettings.setPropertiesValues("DBPass",DBPass);
                 
                 SaveSettings.storeproperties();
             }else{System.out.println("error de connection");}
        } catch (InstantiationException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           // Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
           Error=" Error numero "+ ex.getErrorCode()+":";
           
           int Er=ex.getErrorCode() ;
            switch(Er){
                case 1045:
                        Error+="\n Contraseña o usuario incorrectos.";
                    break;
                case 0:
                         Error+="\n Dirección ip o puertos incorrectos.";
                    break;
                case 1049:
                        Error+="\n Nombre de la base de datos incorrecta.";
                    break;
                default:
                      Error+="\n. "+ex.getMessage();
                    break;
                 
            }
            //System.out.println("Codigo de error "+ex.getErrorCode()+ex.getMessage());
            
        }
        return Error;
}
    /*public void showlogininter(){
        Login logininter = new Login();
    logininter.setEnabled(true);
    logininter.setVisible(true);
    }*/
    
     public Object[] TestConnection_1(){
         String Error="Se establecio la conexion!";
         Object[]A=new Object[2];
         A[0]=false;
         boolean a=false;
        try {
             
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
             SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
             if(Con.isValid(5)==true){
               
                 A[0]=true;
             }else{System.out.println("error de connection");}
        } catch (InstantiationException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           // Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
           A[1]="Error numero "+ ex.getErrorCode()+":\n"+ex.getMessage();
            System.out.println("revisar "+"Error numero "+ ex.getErrorCode()+":\n"+ex.getMessage());
           
            //System.out.println("Codigo de error "+ex.getErrorCode()+ex.getMessage());
            
        }
        return A;
}
 public int InsertUnidad(String Unidad,String Marca,String Tipo,String Aire_a,String Estado,int Pasajeros,String Nombre_Proveedor,String bano){
     int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
         SaveSettings.LoadProperties();
           DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                    
                      CallableStatement stmt=Con.prepareCall("{CALL Insertar_Unidad(?,?,?,?,?,?,?,?)}");
                        stmt.setString(1,Unidad);
                        stmt.setString(2,Marca);
                        stmt.setString(3,Tipo);
                        stmt.setString(4,Aire_a);
                        stmt.setString(5,Estado);
                        stmt.setInt(6,Pasajeros);
                        stmt.setString(7,Nombre_Proveedor);
                        stmt.setString(8, bano);
                        count=stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
    return count;       
 }
     
 public int Update_Unidad(int pk,String Unidad,String Marca,String Tipo,String Aire_a,String Estado,int Pasajeros,String NombreProveedor,String bano){
     int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Update_Unidad(?,?,?,?,?,?,?,?,?)}");
                        stmt.setInt(1,pk);
                        stmt.setString(2,Unidad);
                        stmt.setString(3,Marca);
                        stmt.setString(4,Tipo);
                        stmt.setString(5,Aire_a);
                        stmt.setString(6,Estado);
                        stmt.setInt(7,Pasajeros);
                        stmt.setString(8,NombreProveedor);
                       stmt.setString(9,bano);
        count=stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
    return count;       
 }
 
 public void Check_Users(){
  System.out.println("hola");
     
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver

            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            
            ResultSet rs=null;
            
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            Statement Count=Con.createStatement();
            rs=Count.executeQuery("select count(*) from users");
            rs.next();
            
            rs.getInt(1);
            if(rs.getInt(1)==0){
                Count.executeUpdate("call Create_DefaultUser");
            }
            
           
            Con.close();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
     
 }
 
  public int Read_User_Settings_Admin(int idUser){//Checks wheather a user could access admin users.
     int Result=0;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver

            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            
            ResultSet rs=null;
            
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            Statement Count=Con.createStatement();
            rs=Count.executeQuery("select Administrar_Usuarios from users where Id_Usuario="+idUser);
            rs.next();
            
            Result=rs.getInt(1);
            
            Con.close();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
          return Result;
 }
 
 
 public int InsertChoferes(String Nombre,String NumeroTelefonico,String Email,boolean Disponible){
     //Nombre,NumeroTelefonico,Email,Tipodelicencia
     int count=0;
     try {
             
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
     
          //Creates connection with necessary parameters
             SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                     Statement Count=Con.createStatement();
                     rs=Count.executeQuery("select count(*) from choferes");
                     rs.next();
                     System.out.println("int del count "+rs.getInt(1));
                     if(rs.getInt(1)==0){
                         Count.executeUpdate("insert into Choferes (Nombre,NumeroTelefonico,Email,Disponible) values ('No asignado','0000000','no@informacion.com','0');");
                          CallableStatement stmt=Con.prepareCall("{CALL Insert_choferes(?,?,?,?)}");
                        stmt.setString(1,Nombre);
                        stmt.setString(2,NumeroTelefonico);
                        stmt.setString(3,Email);
                      stmt.setBoolean(4,Disponible);
                                stmt.executeUpdate();
                     }else{
                          CallableStatement stmt=Con.prepareCall("{CALL Insert_choferes(?,?,?,?)}");
                        stmt.setString(1,Nombre);
                        stmt.setString(2,NumeroTelefonico);
                        stmt.setString(3,Email);
                        stmt.setBoolean(4,Disponible);
                               count= stmt.executeUpdate();
                     }
                     
                        
                       

         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
    return count;       
 }
  public void Update_Choferes(int CHID,String Nombre,String NumeroTelefonico,String Email,boolean Disponible){
     //Nombre,NumeroTelefonico,Email,Tipodelicencia
     int count=0;
      System.out.println("int of updated choferes "+ CHID);
     try {
             
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
     
          //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                Con.createStatement();
                    
                 CallableStatement stmt=Con.prepareCall("CALL Update_choferes(?,?,?,?,?)");
                        stmt.setInt(1,CHID);
                        stmt.setString(2,Nombre);
                        stmt.setString(3,NumeroTelefonico);
                        stmt.setString(4,Email);
                        stmt.setBoolean(5,Disponible);
                        stmt.executeUpdate();
                       
                        

         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
           
 }
 
 public void insert_Empresa(String nombre, String tipo,String Numero_Telefonico ){
     System.out.println("nombre "+nombre+","+tipo+","+Numero_Telefonico);
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             
              Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Insert_Empresa(?,?,?)}");
                        stmt.setString(1,nombre);
                        stmt.setString(2,tipo);
                        stmt.setString(3,Numero_Telefonico);
                         
        stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
           
 }
 
 
  public int insert_Empresa_Principal(String Nombre_Empresa){
   
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
              Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Insert_Empresa_Contacto(?)}");
                        stmt.setString(1,Nombre_Empresa);
                       
                         
        count=stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
        return count;   
 }
  
  
   public void Update_Empresa_Principal(int Id_EMP,String Nombre_Emp){
   
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
              Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Update_Empresa_Only(?,?)}");
                        stmt.setInt(1,Id_EMP);
                        stmt.setString(2,Nombre_Emp);
                       
                         
        stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
           
 }
   
   
   
  public void Update_Contact_Only(int ID_Contact,String Nombre_Contacto,String Numero_Telefonico_Contacto,String Email){
   
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
              Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                     CallableStatement stmt=Con.prepareCall("{CALL Update_Contacto_Only(?,?,?,?)}");
                     stmt.setInt(1,ID_Contact);
                     stmt.setString(2,Nombre_Contacto);
                     stmt.setString(3,Numero_Telefonico_Contacto);
                     stmt.setString(4,Email);
                         
        count=stmt.executeUpdate();
        
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
         
 }
  
public void UPdate_Encargado_Contacto(int ID,String Name,String Phone){
        try {
            int count=0;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            System.out.println("connection data"+DataBaseConnection);
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            ResultSet rs=null;
            CallableStatement stmt=Con.prepareCall("{CALL Update_Contacto_Encargado(?,?,?)}");
            stmt.setInt(1,ID);
            stmt.setString(2,Name);
            stmt.setString(3,Phone);
            count=stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  public void Update_Empresa(String nombre, String tipo,String Numero_Telefonico,int Empresa ){
    
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
              Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Update_Empresa(?,?,?,?)}");
                        stmt.setInt(1,Empresa);
                        stmt.setString(2,nombre);
                        stmt.setString(3,tipo);
                        stmt.setString(4,Numero_Telefonico);
                         
        stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
           
 }
 
  public void insert_Encargado(int ID_empresa ,String nombre, String Email,String Numero_Telefonico,String Numero_Telefonico2){
     System.out.println("nombre "+nombre+","+Email+","+Numero_Telefonico);
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Insertar_Encargado(?,?,?,?,?)}");
                      stmt.setInt(1, ID_empresa);
                        stmt.setString(2,nombre);
                        stmt.setString(3,Email);
                        stmt.setString(4,Numero_Telefonico);
                         stmt.setString(5,Numero_Telefonico2);
                   
                         
        stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     
     
     
     
           
 }
  
  
  
   public int insert_Encargado_Only(int ID_empresa ,String nombre, String Email,String Numero_Telefonico){
    
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Insert_Only_Encargado(?,?,?,?)}");
                      stmt.setInt(1, ID_empresa);
                        stmt.setString(2,nombre);
                        stmt.setString(3,Email);
                        stmt.setString(4,Numero_Telefonico);
                     
                   
                         
        count=stmt.executeUpdate();
        
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
     return count;
    }
    public int insert_Enc_Contacto(int ID_empresa ,String nombre,String Numero_Telefonico){
    
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Insert_Encargado_Contacto(?,?,?)}");
                      stmt.setInt(1, ID_empresa);
                        stmt.setString(2,nombre);
                        stmt.setString(3,Numero_Telefonico);
                     
                   
                         
        count=stmt.executeUpdate();
        
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
     return count;
    }
   
  public HashMap<Integer,ArrayList<String>> search_Empresa(String EmpresaN ){
       HashMap<Integer,ArrayList<String>>myMap=new HashMap<Integer, ArrayList<String>>();
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Get_Empresa(?)}");
                      stmt.setString(1,EmpresaN);
                       
                         
        rs=stmt.executeQuery();
       count=0;
       
       
          while(rs.next()){
                //System.out.println("hola"+rs.getString(2));
              count++;
             // System.out.println("count  "+count);
             myMap.put(count,new ArrayList<String>());
             myMap.get(count).add(rs.getString(1));
             myMap.get(count).add(rs.getString(2));
             myMap.get(count).add(rs.getString(3));
             myMap.get(count).add(rs.getString(4));
         }
        
       
                
        System.out.println("resultado "+myMap.size());
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
          return myMap; 
 }
 
    
  public HashMap<Integer,ArrayList<String>> search_EmpresaRole(String EmpresaN ){
      /*webwork*/
      HashMap<Integer,ArrayList<String>>myMap=new HashMap<Integer, ArrayList<String>>();
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
             SaveSettings.LoadProperties();
               DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Get_Empresa(?)}");
                      stmt.setString(1,EmpresaN);
                       rs=stmt.executeQuery();
       count=0;
       while(rs.next()){
                //System.out.println("hola"+rs.getString(2));
              count++;
             // System.out.println("count  "+count);
             myMap.put(count,new ArrayList<String>());
             myMap.get(count).add(rs.getString(1));
             myMap.get(count).add(rs.getString(2));
            
         }
        System.out.println("resultado "+myMap.size());
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
          return myMap; 
 }
  public HashMap<Integer,ArrayList<String>> ClienteRole(String EmpresaN ){
      
      
       HashMap<Integer,ArrayList<String>>myMap=new HashMap<Integer, ArrayList<String>>();
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL GetEmpleado(?)}");
                      stmt.setString(1,EmpresaN);
                       
                         
        rs=stmt.executeQuery();
       count=0;
       
       
          while(rs.next()){
                //System.out.println("hola"+rs.getString(2));
              count++;
             // System.out.println("count  "+count);
           
             myMap.put(count,new ArrayList<String>());
             myMap.get(count).add(rs.getString(1));
             myMap.get(count).add(rs.getString(2));
             myMap.get(count).add(rs.getString(3));
             myMap.get(count).add(rs.getString(4));
             myMap.get(count).add(rs.getString(5));
             myMap.get(count).add(rs.getString(6));
                  
            
         }
        
       
                
        System.out.println("resultado "+myMap.size());
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
          return myMap; 
 }
  
  
    public HashMap<Integer,ArrayList<String>> search_Encargado(int Encargado ){
       HashMap<Integer,ArrayList<String>>myMap=new HashMap<Integer, ArrayList<String>>();
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
          DataBaseConnection="jdbc:mysql://";
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
           System.out.println("db connection encargado"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Get_Encargado(?)}");
                      stmt.setInt(1,Encargado);
                       
                         
        rs=stmt.executeQuery();
       count=0;
       
       
          while(rs.next()){
                //System.out.println("hola"+rs.getString(2));
              count++;
             // System.out.println("count  "+count);
             myMap.put(count,new ArrayList<String>());
             myMap.get(count).add(rs.getString(3));
             myMap.get(count).add(rs.getString(4));
             myMap.get(count).add(rs.getString(5));
             myMap.get(count).add(rs.getString(6));
             myMap.get(count).add(rs.getString(1));
         }
        
       
                
        System.out.println("resultado "+myMap.size());
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
          return myMap; 
 }
  
    
    
    
    public HashMap<Integer,ArrayList<String>> search_Contacto_Encargado(int Encargado ){
        HashMap<Integer,ArrayList<String>>myMap=new HashMap<Integer, ArrayList<String>>();
        int count=0;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
            DataBaseConnection="jdbc:mysql://";
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            System.out.println("db connection encargado"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            ResultSet rs=null;
            CallableStatement stmt=Con.prepareCall("{CALL Get_Encargado_Contacto(?)}");
            stmt.setInt(1,Encargado);             
            rs=stmt.executeQuery();
            count=0;
            while(rs.next()){
                //System.out.println("hola"+rs.getString(2));
                count++;
             // System.out.println("count  "+count);
                myMap.put(count,new ArrayList<String>());
                myMap.get(count).add(rs.getString(4));
                myMap.get(count).add(rs.getString(5));
                myMap.get(count).add(rs.getString(1));
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap; 
    }
  
    
  
  public void Update_Encargado(int id,String nombre, String Email,String Numero_Telefonico,String Numero_Telefonico2){
   
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
             SaveSettings.LoadProperties();
               DataBaseConnection="jdbc:mysql://";
             
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL Update_Encargado(?,?,?,?,?)}");
                            stmt.setInt(1,id);
                        stmt.setString(2,nombre);
                        stmt.setString(3,Email);
                       stmt.setString(4,Numero_Telefonico);
                       stmt.setString(5,Numero_Telefonico2);
                   
                         
        stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
       
 }
  
  
  
   
public HashMap<Integer,ArrayList<String>> SearchAllUnidad(){
       String  Unidades[][]=null;
       HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
              Statement Result=Con.createStatement();
              rs=Result.executeQuery("Select * From unidad");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                   
                    myMap.put(count,new ArrayList<String>());
                   
                   myMap.get(count).add(rs.getString(2));
                    myMap.get(count).add(rs.getString(3));
                     myMap.get(count).add(rs.getString(4));
                      myMap.get(count).add(rs.getString(5));
                       myMap.get(count).add(rs.getString(6));
                        myMap.get(count).add(rs.getString(7));
                         myMap.get(count).add(rs.getString(1));
                           myMap.get(count).add(rs.getString(9));
                            myMap.get(count).add(rs.getString(10));
                          
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}  
  
  
  public HashMap<Integer,ArrayList<String>> SearchAllChoferes(){
       String  Unidades[][]=null;
       HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
             SaveSettings.LoadProperties();
               DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
              Statement Result=Con.createStatement();
              rs=Result.executeQuery("Select * From choferes");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
           
                    myMap.put(count,new ArrayList<String>());
                    myMap.get(count).add(rs.getString(2));
                    myMap.get(count).add(rs.getString(3));
                   
                    myMap.get(count).add(rs.getString(4));
                    myMap.get(count).add(rs.getString(6));
                    myMap.get(count).add(rs.getString(1));
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}  
  public HashMap<Integer,ArrayList<String>>  SearchAll_UNIChofer(){
      // String  Unidades[][]=null;
       HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
                CallableStatement stmt=Con.prepareCall("{CALL Select_Unidades}");
              rs=  stmt.executeQuery();
             // rs=stmt.executeQuery("Select * From Unidad_Choferes");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  
                    myMap.put(count,new ArrayList<String>());
                       myMap.get(count).add(rs.getString(1));
                       System.out.println("unidad "+rs.getString(1));
                   myMap.get(count).add(rs.getString(2));
                 
                     myMap.get(count).add(rs.getString(3));
                       myMap.get(count).add(rs.getString(4));
                   /* myMap.get(count).add(rs.getString(3));
                     myMap.get(count).add(rs.getString(4));*/  
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
  }
   public   HashMap<Integer,ArrayList<String>>GetChoferes(){
      // String  Unidades[][]=null;
    
    HashMap<Integer,ArrayList<String>>NombreChoferes =new HashMap<Integer, ArrayList<String>>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
             SaveSettings.LoadProperties();
               DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
                CallableStatement stmt=Con.prepareCall("{CALL Select_allchoferes}");
              rs=  stmt.executeQuery();
             // rs=stmt.executeQuery("Select * From Unidad_Choferes");
             
               int count=0;
               while(rs.next()){
                      count++;
                
                 NombreChoferes.put(count, new ArrayList<String>());
                 NombreChoferes.get(count).add(rs.getString(1));
                 NombreChoferes.get(count).add(rs.getString(2));
                NombreChoferes.get(count).add(rs.getString(3));
                   
               }
               
               
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NombreChoferes;
  } 
   
   
   public   HashMap<Integer,ArrayList<String>>GetChoferesfilters(String Filter){
    HashMap<Integer,ArrayList<String>>NombreChoferes =new HashMap<Integer, ArrayList<String>>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
             SaveSettings.LoadProperties();
               DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            // System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
                CallableStatement  Result=Con.prepareCall("{CALL Filterchoferes(?)}");
                 Result.setString(1,Filter);
              rs=  Result.executeQuery();
               int count=0;
               while(rs.next()){
                      count++;
                 NombreChoferes.put(count, new ArrayList<String>());
                 NombreChoferes.get(count).add(rs.getString(1));
                 NombreChoferes.get(count).add(rs.getString(2));
                NombreChoferes.get(count).add(rs.getString(3));
                   
               }
               
               
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NombreChoferes;
  } 
   
  
 public void insert_CH12(Integer Unidad,Integer CH1, Integer CH2){
     System.out.println(""+Unidad+" "+CH1+" "+CH2);
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL InsertChofers_Unidad(?,?,?)}");
                       stmt.setInt(1,Unidad);
                        stmt.setInt(2,CH1);
                        stmt.setInt(3,CH2);
                         
        stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
           
 }  
 
 
 public HashMap<Integer,ArrayList<String>> SearchFilterUnidad(String Aire_a,int pasajeros,String Toilet ){
       
        HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call Filter_Unidad(?,?,?)");
              Result.setString(1,Aire_a);
              Result.setInt(2,pasajeros);
              Result.setString(3,Toilet);
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(String.valueOf(rs.getInt(2)));
                  myMap.get(count).add(rs.getString(3));
                
                   
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}  
  
  public int Insert_ROle(String Lugar_Destino,String Lugar_Salida, String Precio, String Cantidad_Pasajeros,
          int ID_Encargado,Date Inicial,Date Destino,int Unidad_ID,String notas,String Cobra,String Regreso,
          String Estado,String Fecha_tramite,int Moneda,int Mpago,double Monto_Adelanto,int ContactID,String FechaMax,
          int ChoferID,String Comentario_User,int Usuario_ID,String Recorrido){
    //Lugar_Destino, Lugar_Salida, Precio, Cantidad_Pasajeros, id_Cliente, Unidad_Chofer_id
      int count=0;
       ResultSet rs=null;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                    
                    
                      CallableStatement stmt=Con.prepareCall("{CALL Insert_Role(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                      stmt.setString(1, Lugar_Destino);
                      stmt.setString(2, Lugar_Salida);
                      stmt.setString(3, Precio);
                      stmt.setString(4, Cantidad_Pasajeros);
                      stmt.setInt(5, ID_Encargado);
                      stmt.setTimestamp(6, new Timestamp(Inicial.getTime()));
                      stmt.setTimestamp(7, new Timestamp(Destino.getTime()));
                      stmt.setInt(8, Unidad_ID);
                      stmt.setString(9, notas);
                      stmt.setString(10, Cobra);
                      stmt.setString(11, Regreso);
                      stmt.setString(12, Estado);
                      stmt.setString(13,Fecha_tramite);
                      stmt.setInt(14, Moneda);
                      stmt.setInt(15,Mpago);
                      stmt.setDouble(16, Monto_Adelanto);
                      stmt.setInt(17, ContactID);
                      stmt.setString(18, FechaMax);
                      stmt.setInt(19, ChoferID);
                      stmt.setString(20,Comentario_User);
                      stmt.setInt(21, Usuario_ID);
                      stmt.setString(22, Recorrido);
                      System.out.println("valor del user id"+Recorrido);
                      stmt.executeUpdate();
       
                    Statement caso= Con.createStatement();
                    rs=caso.executeQuery("Select Role_id from role order by Role_id desc limit 1");
                    rs.next();
                   count= rs.getInt(1);
                    
                    
        // System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         System.out.println("Error ");
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
     
 
     
     
     return count;      
 }
  
  
  
  public void Update_ROle(String Lugar_Destino,String Lugar_Salida, String Precio, String Cantidad_Pasajeros,int ID_Encargado,int ID_UNICHofer,Date Inicial,
          Date Destino,String notas,String Cobra,String Regreso,String Estado,String Fecha_tramite,int User_ID,int Case_Role,String Comentario_User,int Money,
          int Payment,double Monto,String Recorrido,String FechaMax,int chofer,int contactENCID){
    //Lugar_Destino, Lugar_Salida, Precio, Cantidad_Pasajeros, id_Cliente, Unidad_Chofer_id
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            ;
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                    
                      CallableStatement stmt=Con.prepareCall("CALL Update_Role(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                      stmt.setString(1, Lugar_Destino);
                      stmt.setString(2, Lugar_Salida);
                      stmt.setString(3, Precio);
                      stmt.setString(4, Cantidad_Pasajeros);
                      stmt.setInt(5, ID_Encargado);
                      stmt.setInt(6,ID_UNICHofer);
                     
                      stmt.setTimestamp(7, new Timestamp(Inicial.getTime()));
                      stmt.setTimestamp(8, new Timestamp(Destino.getTime()));
                      stmt.setString(9, notas);
                      stmt.setString(10, Cobra);
                      stmt.setString(11, Regreso);
                      stmt.setString(12, Estado);
                      stmt.setString(13, Fecha_tramite);
                      stmt.setInt(14,User_ID);
                      stmt.setInt(15, Case_Role);
                      stmt.setString(16, Comentario_User);
                      stmt.setInt(17, Money);
                      stmt.setInt(18,Payment);
                      stmt.setDouble(19, Monto);
                      stmt.setString(20,Recorrido);
                      stmt.setString(21,FechaMax); 
                      stmt.setInt(22, chofer);
                      stmt.setInt(23, contactENCID);
                      //,String Nombreencargado,String telefonoencargado,String Correoencargado
       count= stmt.executeUpdate();
         System.out.println("resultado "+count);
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
           
   }
           
  
  
  
  
  
   public HashMap<Integer,ArrayList<String>> SearchRole_Database(Date Inicial,Date Final ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             System.out.println("dates formate "+ Inicial+"  "+Final);
              CallableStatement  Result=Con.prepareCall("Call Search_RoleDateRange(?,?)");
              Result.setTimestamp(1,new Timestamp(Inicial.getTime()));
              Result.setTimestamp(2,new Timestamp(Final.getTime()));
               
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(3));
                  myMap.get(count).add(rs.getString(4));
                  myMap.get(count).add(rs.getString(5));
                  myMap.get(count).add(rs.getString(6));
                  myMap.get(count).add(rs.getString(7));
                  myMap.get(count).add(rs.getString(8));
                  myMap.get(count).add(rs.getString(9));
                  myMap.get(count).add(rs.getString(10));
                  myMap.get(count).add(rs.getString(11));
                  myMap.get(count).add(rs.getString(12));//Cobrar
                  myMap.get(count).add(rs.getString(13));//Regrese needed for excel file on this order
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}  
   
   
 public HashMap<Integer,ArrayList<String>> Search_UnitUsageRange(Date Inicial,Date Final ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call Unit_Usage_DateRange(?,?)");
              Result.setTimestamp(1,new Timestamp(Inicial.getTime()));
              Result.setTimestamp(2,new Timestamp(Final.getTime()));
               
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(3));
                  myMap.get(count).add(rs.getString(4));
                  myMap.get(count).add(rs.getString(5));
                  myMap.get(count).add(rs.getString(6));
                  myMap.get(count).add(rs.getString(7));
                  myMap.get(count).add(rs.getString(8));
                  myMap.get(count).add(rs.getString(9));
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}     
 
 
   
 public HashMap<Integer,ArrayList<String>> Search_PendientesXCobrar(Date Inicial,Date Final ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call Pendientes_Cobrar(?,?)");
              Result.setTimestamp(1,new Timestamp(Inicial.getTime()));
              Result.setTimestamp(2,new Timestamp(Final.getTime()));
               
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(3));
                  myMap.get(count).add(rs.getString(4));
                  myMap.get(count).add(rs.getString(5));
                  myMap.get(count).add(rs.getString(6));
                  myMap.get(count).add(rs.getString(7));
                  myMap.get(count).add(rs.getString(8));
                  myMap.get(count).add(rs.getString(9));  
                  myMap.get(count).add(rs.getString(10));
                  myMap.get(count).add(rs.getString(11));
                  myMap.get(count).add(rs.getString(12));
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}     


 public HashMap<Integer,ArrayList<String>> Search_ConsumoXCliente(Date Inicial,Date Final ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call ConsumoXCliente(?,?)");
              Result.setTimestamp(1,new Timestamp(Inicial.getTime()));
              Result.setTimestamp(2,new Timestamp(Final.getTime()));
               
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(3));
                  myMap.get(count).add(rs.getString(4));
                  myMap.get(count).add(rs.getString(5));
                  myMap.get(count).add(rs.getString(6));
                  myMap.get(count).add(rs.getString(7));
                   myMap.get(count).add(rs.getString(8));
                 
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}    
 public HashMap<Integer,ArrayList<String>> Search_Consumo_Mensual(Date Inicial,Date Final ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call Consumo_Mensual(?,?)");
              Result.setTimestamp(1,new Timestamp(Inicial.getTime()));
              Result.setTimestamp(2,new Timestamp(Final.getTime()));
               
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(3));
                
                 
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}    
  public HashMap<Integer,ArrayList<String>> SearchRoleSheetOnly(Date Inicial,Date Final ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call Search_RoleDateRange(?,?)");
              Result.setTimestamp(1,new Timestamp(Inicial.getTime()));
              Result.setTimestamp(2,new Timestamp(Final.getTime()));
               
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(3));
                  myMap.get(count).add(rs.getString(10));
                  myMap.get(count).add(rs.getString(4));
                  myMap.get(count).add(rs.getString(11));
                  myMap.get(count).add(rs.getString(7));
                  myMap.get(count).add(rs.getString(8));
                  myMap.get(count).add(rs.getString(5));
                  myMap.get(count).add(rs.getString(6));
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(rs.getString(13));
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
}  

  
  public HashMap<Integer,ArrayList<String>> GetRevReport(Date Inicial,Date Final ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Integer,ArrayList<String>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call RevenueReport(?,?)");
              Result.setTimestamp(1,new Timestamp(Inicial.getTime()));
              Result.setTimestamp(2,new Timestamp(Final.getTime()));
               
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<String>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(3));
                  myMap.get(count).add(rs.getString(4));
                  myMap.get(count).add(rs.getString(5));
                  myMap.get(count).add(rs.getString(6));
                  myMap.get(count).add(rs.getString(7));
                  myMap.get(count).add(rs.getString(8));
                  
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;
} 
  
  
  
  
  
 public Object[] Checkusers(String user,String pass){
      // String  Unidades[][]=null;
      Object username[]=new Object[7];
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
           SaveSettings.LoadProperties();
             DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
                CallableStatement stmt=Con.prepareCall("{CALL checkuserpass(?,?)}");
                stmt.setString(1,user);
                stmt.setString(2,pass);
               rs=stmt.executeQuery();
               rs.next();
              username[0]=rs.getBoolean(1);
              username[1]=rs.getInt(2);
              username[2]=rs.getBoolean(3);
              username[3]=rs.getBoolean(4);
              username[4]=rs.getBoolean(5);
              username[5]=rs.getBoolean(6);
              username[6]=rs.getBoolean(7);
             // username[1]=rs.getString(1);
               if((boolean)username[0]==true){
                    stmt=Con.prepareCall("{CALL User_Position(?)}");
                  stmt.setString(1, user);
                   rs=stmt.executeQuery();
                   rs.next();
                    username[1]=rs.getInt(1);
                  // System.out.println("user id "+rs.getString(1));       
               }
               Con.close();
               System.out.println("username is good "+username);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return username;
  }
  
  public boolean CreateUser(String Nombre,String Usuario, String Password,String Correo,boolean Administrar_Usuarios,boolean Role,boolean Unidad_Choferes){
       Connection Con=null;
       
       boolean Resultado=false;
        try {
            boolean createResult=false;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            int rs;
            CallableStatement stmt=Con.prepareCall("{CALL Create_User(?,?,?,?,?,?,?)}");
                 stmt.setString(1,Nombre);
                 stmt.setString(2,Usuario);
                 stmt.setString(3,Password);
                 stmt.setString(4,Correo);
                 stmt.setBoolean(5, Administrar_Usuarios);
           
                 stmt.setBoolean(6, Role);
                 stmt.setBoolean(7, Unidad_Choferes);
                 rs=stmt.executeUpdate();
                 Con.close();
                 if(rs==1){
                     Resultado=true;
                 }
                 System.out.println("rs"+rs);
                /* if(rs==1){
                     Resultado=true;
                 }*/
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Resultado;
}
  public boolean CreateUser_JavaFX(String Nombre,String Usuario, String Password,String Correo,boolean Administrar_Usuarios,boolean Role,boolean Unidad_Choferes,boolean Reportes,boolean ActiveAccount){
       Connection Con=null;
       
       boolean Resultado=false;
        try {
            boolean createResult=false;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            int rs;
            CallableStatement stmt=Con.prepareCall("{CALL Create_User_JavaFx(?,?,?,?,?,?,?,?,?)}");
                 stmt.setString(1,Nombre);
                 stmt.setString(2,Usuario);
                 stmt.setString(3,Password);
                 stmt.setString(4,Correo);
                 stmt.setBoolean(5,Administrar_Usuarios);
                 stmt.setBoolean(6, Role);
                 stmt.setBoolean(7, Unidad_Choferes);
                 stmt.setBoolean(8, Reportes);
                 stmt.setBoolean(9, ActiveAccount);
                 rs=stmt.executeUpdate();
                 Con.close();
                 if(rs==1){
                     Resultado=true;
                 }
                 System.out.println("rs"+rs);
                /* if(rs==1){
                     Resultado=true;
                 }*/
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Resultado;
}
  
  
  public HashMap<Integer,ArrayList<String>> search_users(String username ){
      
      
       HashMap<Integer,ArrayList<String>>myMap=new HashMap<Integer, ArrayList<String>>();
      int count=0;
     try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
          //Creates connection with necessary parameters
             SaveSettings.LoadProperties();
               DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
                     ResultSet rs=null;
                      CallableStatement stmt=Con.prepareCall("{CALL buscaruser(?)}");
                      stmt.setString(1,username);
                       
                         
        rs=stmt.executeQuery();
       count=0;
       
       
          while(rs.next()){
                //System.out.println("hola"+rs.getString(2));
              count++;
             // System.out.println("count  "+count);
             myMap.put(count,new ArrayList<String>());
             myMap.get(count).add(rs.getString(1));
             myMap.get(count).add(rs.getString(2));
             myMap.get(count).add(rs.getString(3));
             myMap.get(count).add(rs.getString(4));
             myMap.get(count).add(rs.getString(5));
             myMap.get(count).add(String.valueOf(rs.getBoolean(6)));
             myMap.get(count).add(String.valueOf(rs.getBoolean(7)));
             myMap.get(count).add(String.valueOf(rs.getBoolean(8)));
             myMap.get(count).add(String.valueOf(rs.getBoolean(9)));
             myMap.get(count).add(String.valueOf(rs.getBoolean(10)));
            // myMap.get(count).add(rs.getString(2));
            
         }
        
       
                
        System.out.println("resultado "+myMap.size());
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }
          return myMap; 
 }
  
public HashMap<Integer,ArrayList<Object>> Busquedadecaso(Date Start,Date End,int empresa,String Filtro){
    /*HashMap<Integer,Object[]>myMap=new HashMap<Integer, Object[]>();*/
HashMap<Integer,ArrayList<Object>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call search_datescase(?,?,?,?)");
              Result.setTimestamp(1,new Timestamp(Start.getTime()));
              Result.setTimestamp(2,new Timestamp(End.getTime()));
               Result.setInt(3, empresa);
               Result.setString(4,Filtro);
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<Object>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(3));
                  myMap.get(count).add(rs.getDate(4));
                  myMap.get(count).add(rs.getDate(5));
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;

}

public HashMap<Integer,ArrayList<Object>> Busquedadecaso2(int empresa,String Filtro){
    /*HashMap<Integer,Object[]>myMap=new HashMap<Integer, Object[]>();*/
HashMap<Integer,ArrayList<Object>>myMap=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call search_datescaseNODATE(?,?)");
              
               Result.setInt(1, empresa);
               Result.setString(2,Filtro);
              rs= Result.executeQuery();
            //  rs=Result.executeQuery("Call Search_Unidad(?,?)");
               myMap=new HashMap<Integer, ArrayList<Object>>();
               int count=0;
               while(rs.next()){
                   count++;
                  myMap.put(count, new ArrayList());
                  myMap.get(count).add(rs.getString(1));
                  myMap.get(count).add(rs.getString(2));
                  myMap.get(count).add(rs.getString(3));
                  myMap.get(count).add(rs.getDate(4));
                  myMap.get(count).add(rs.getDate(5));
               }
               
             
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myMap;

}
  
  public boolean Update_Users(int pot,String Nombre,String Usuario, String Password,String Correo,boolean Administrar_Usuarios,boolean Role,boolean Unidad_Choferes,boolean Reportes,boolean ActiveAccount){
       boolean Resultado=false;
        try {
            Connection Con=null;
           
            
           
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            int rs;
            CallableStatement stmt=Con.prepareCall("{CALL Update_User_JavaFx(?,?,?,?,?,?,?,?,?,?)}");
            stmt.setInt(1,pot);
            stmt.setString(2,Nombre);
            stmt.setString(3,Usuario);
            stmt.setString(4,Password);
            stmt.setString(5,Correo);
            stmt.setBoolean(6, Administrar_Usuarios);
            stmt.setBoolean(7, Role);
            stmt.setBoolean(8, Unidad_Choferes);
            stmt.setBoolean(9, Reportes);
            stmt.setBoolean(10,ActiveAccount);
            rs=stmt.executeUpdate();
            Con.close();
            if(rs==1){
              
                Resultado=true;
            }      } catch (ClassNotFoundException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
  return Resultado;
    }
  public boolean Update_UsersNoPass(int pot,String Nombre,String Usuario,String Correo,boolean Administrar_Usuarios,boolean Role,boolean Unidad_Choferes,boolean Reportes,boolean ActiveAccount){
       boolean Resultado=false;
        try {
            Connection Con=null;
           
            
           
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            int rs;
            CallableStatement stmt=Con.prepareCall("{CALL Update_UserNoPass_JavaFx(?,?,?,?,?,?,?,?,?)}");
            stmt.setInt(1,pot);
            stmt.setString(2,Nombre);
            stmt.setString(3,Usuario);
            stmt.setString(4,Correo);
            stmt.setBoolean(5, Administrar_Usuarios);    
            stmt.setBoolean(6, Role);
            stmt.setBoolean(7, Unidad_Choferes);
             stmt.setBoolean(8, Reportes);
            stmt.setBoolean(9,ActiveAccount);
            rs=stmt.executeUpdate();
            Con.close();
            if(rs==1){
              
                Resultado=true;
            }      } catch (ClassNotFoundException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
  return Resultado;
    }
  
  public HashMap<Integer,ArrayList<String>> Filterempresas(String Filter){
      HashMap<Integer,ArrayList<String>>NombreEmpresas =new HashMap<Integer, ArrayList<String>>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            //Creates connection with necessary parameters
             SaveSettings.LoadProperties();
               DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            // System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
                CallableStatement  Result=Con.prepareCall("{CALL filterempresas(?)}");
                 Result.setString(1,Filter);
              rs=  Result.executeQuery();
               int count=0;
               while(rs.next()){
                      count++;
                 NombreEmpresas.put(count, new ArrayList<String>());
                 NombreEmpresas.get(count).add(rs.getString(1));
                 NombreEmpresas.get(count).add(rs.getString(2));
               }
               
               
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NombreEmpresas;
  
  }
  
  
   public String[] SearchRole_Case(int caso ){
         
        String[]data=new String[32];
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call Search_case(?)");
             
               Result.setInt(1, caso);
              rs= Result.executeQuery();     
               rs.next();
                  data[0]=rs.getString(1);
                  data[1]=rs.getString(2);
                  data[2]=rs.getString(3);
                  data[3]=rs.getString(4);
                  data[4]=rs.getString(5);
                  data[5]=rs.getString(6);
                  data[6]=rs.getString(7);
                  data[7]=rs.getString(8);
                  data[8]=rs.getString(9);
                  data[9]=rs.getString(10);
                  data[10]=rs.getString(11);
                  data[11]=rs.getString(12);
                  data[12]=rs.getString(13);
                  data[13]=rs.getString(14);
                  data[14]=rs.getString(15);
                  data[15]=rs.getString(16);
                  data[16]=rs.getString(17);
                  data[17]=rs.getString(18);
                  data[18]=rs.getString(19);
                  data[19]=rs.getString(20);
                  data[20]=String.valueOf(rs.getInt(21));
                  data[21]=String.valueOf(rs.getInt(22));
                  data[22]=rs.getString(23);
                  data[23]=String.valueOf(rs.getDate(24));
                  data[24]=String.valueOf(rs.getDouble(25));
                  data[25]=rs.getString(26);
                  data[26]=rs.getString(27);
                  data[27]=rs.getString(29);
                  data[28]=rs.getString(28);
                 data[29]=String.valueOf(rs.getString(30));
                  data[30]=String.valueOf(rs.getInt(31));
                  data[31]=String.valueOf(rs.getString(32));
              /* data[32]=rs.getString(33);*/
               Con.close();
               System.out.println("data lenght"+data.length);
              for(int e=0;e<data.length;e++){
                   System.out.println("Dato "+(e+1)+" "+data[e]);
               }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
          //  Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "No se encuentra un caso designado!");
        }
  return data;     
} 
  
    
   public   HashMap<Integer,String[]> SearchComentarios_Case(int caso ){
        HashMap<Integer,String[]>myMap=new HashMap<Integer, String[]>();
        
        int count=0;
        
       
      
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
              DataBaseConnection="jdbc:mysql://";
             DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
             System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call Search_Comentarios(?)");
             
               Result.setInt(1, caso);
              rs= Result.executeQuery();     
              while(rs.next()){
                  count++;
                  myMap.put(count, new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
                  
               } 
                  
               Con.close();
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
       return myMap;
} 
  
  
  
    public   HashMap<Integer,Object[]> SearchPendientes_Case(){
        HashMap<Integer,Object[]>myMap=new HashMap<Integer, Object[]>();
        int count=0;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            System.out.println("connection data"+DataBaseConnection);
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
              ResultSet rs=null;
             
              CallableStatement  Result=Con.prepareCall("Call Search_Pendientes()");
             
               
              rs= Result.executeQuery();     
              while(rs.next()){
                  count++;
                  myMap.put(count, new Object[]{rs.getDate(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                  
               } 
                  
               Con.close();
               
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
          /* Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);*/
            System.out.println("error al buscar el caso");
        }
       return myMap;
} 
    
    
  public int Check_Permissions(int idUser,String Search){//Checks wheather a user could access admin users.
      System.out.println("Este es el usuario"+idUser);
     int Result=0;
      System.out.println(" iduser"+idUser);
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//loading driver

            //Creates connection with necessary parameters
            SaveSettings.LoadProperties();
            DataBaseConnection="jdbc:mysql://";
            DataBaseConnection+=SaveSettings.GetPropertie("DBIP")+":"+SaveSettings.GetPropertie("DBPort")+"/"+SaveSettings.GetPropertie("DBName");
            
            ResultSet rs=null;
            
            //Creates connection with necessary parameters
            Connection Con=DriverManager.getConnection(DataBaseConnection,SaveSettings.GetPropertie("DBUser"),SaveSettings.GetPropertie("DBPass"));
            Statement Count=Con.createStatement();
            rs=Count.executeQuery("select "+Search+" from users where Id_Usuario="+idUser);
            rs.next();
            
            Result=rs.getInt(1);
            
            Con.close();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TravelManDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
          return Result;
 }

   }
 
