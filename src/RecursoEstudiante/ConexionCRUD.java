package RecursoEstudiante;

import java.sql.*;

public class ConexionCRUD {
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/  AQUI VA EL NOMBRE DE LA BASE DE DATOS";
    private final String usuario = "root";
    private final String clave = "";
    //libreria de mysql
    private final String driverConector = "com.mysql.jdbc.Driver";
    private static Connection conexion;
    
    public ConexionCRUD(){
        try{
            Class.forName(driverConector); //levantar el driver
            //establecer conexion
            conexion= DriverManager.getConnection(servidor, usuario, clave);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conecion fallida! : " + e.getMessage());
        }
    }
    public Connection  getConnection(){
        return conexion;
    }
    //metodo guardar
    public static void guardarRegistros(String tabla, String campoTabla, String valoresCampos) {
        //cargar conexion
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            String sqlQueryStmt = "INSERT INTO " + tabla  + "(" + campoTabla + ") VALUES (" + valoresCampos + ");";
            Statement stmt;
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
            System.out.println("Registro guardado correctamente!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
        
    //metodo eliminar y actualizar
    public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion){
        //cargar la conexion
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            Statement stmt;
            String sqlQueryStmt;
            //verificar que vaorescamposnuevos venga vacia y asi seleccionar si es borrar o actualizar registro
            if(valoresCamposNuevos.isEmpty()){
                sqlQueryStmt = "DELETE FROM " + tabla + " WHERE " + condicion + ";";
            }else{
                sqlQueryStmt = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";
            }
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
        }catch(SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
    
     //metodo para consultas
    public static void desplegarRegistros(String tablaBuscar, String camposBuscar, String condicionBuscar) throws SQLException {
        //cargar la conexion
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            Statement stmt;
            String sqlQueryStmt;
            if(condicionBuscar.equals("")){
                sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + ";";
            }else{
                sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar; 
            }
            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);
            try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
                if(miResultSet.next()){ 
                    ResultSetMetaData metaData =  miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount();
                    System.out.println("<< REGISTROS ALMACENADOS >>");
                    System.out.println();
                    for(int i =1; i<= numColumnas; i++){
                        System.out.printf("%-20s\t" , metaData.getColumnName(i));
                    }
                    System.out.println();
                    do{
                        for(int i=1; i<=numColumnas; i++){
                            System.out.printf("%-20s\t" , miResultSet.getObject(i));
                        }
                        System.out.println();
                    }while(miResultSet.next());
                    System.out.println();
                }else{
                    System.out.println("No se han encontrado registros");
                }
                miResultSet.close();
            }finally{
                stmt.close();
                cone.close();
            }
        }catch(SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
}
