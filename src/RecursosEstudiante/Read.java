package RecursosEstudiante;

import java.sql.*;

public class Read {
    public Read()throws SQLException{
        System.out.println("\n<< CONSULTA DE REGISTRO >>");
        mostrarResultados();
    }
    private void mostrarResultados()throws SQLException{
        try{
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "tb_estudiante";
            String camposTabla = "*";
            String condicionBusqueda="";
            //metodo que realiza la busqueda
            utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        }catch(SQLException ex){
            System.out.println("Ha ocurrido un eror: " + ex.getMessage());
        } finally{
            MenuPrincipal.desplegarMenu();
        }
    }
}
