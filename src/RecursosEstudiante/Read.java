/*
EJERCICIO DE APLICACIÓN
Crear el CRUD para almacenar registros en la siguiente tabla.

ESTUDIANTE
**************************************
Campos Tipo de Datos Otros
*************************************
id_estudiante int - Llave primaria, autoincrementable desde 1001
carnet_estudiante varchar(6) - Ejemplo MP1234
nom_estudiante varchar(30)
ape_estudiante varchar(30)
edad_estudiante Int(3)

*/
package RecursosEstudiante;

import java.sql.*;

public class Read {
    public Read()throws SQLException{
        System.out.println("\n<< CONSULTA DE REGISTRO >>");
        mostrarResultados();
    }
    private void mostrarResultados()throws SQLException{
        try{
            ConexionCRUD utilirias = new ConexionCRUD();
            String tabla = "tb_estudiante";
            String camposTabla = "*";
            
            String condicionBusqueda="";
            
            //metodo que realiza la busqueda
            utilirias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        }catch(SQLException ex){
            System.out.println("Ha ocurrido un eror: " + ex.getMessage());
        } finally{
            MenuPrincipal.desplegarMenu();
        }
    }
}
