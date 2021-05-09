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
     public Read() throws SQLException {
        System.out.println("<< CONSULTA DE REGISTROS >>");
        mostrarResultados();
    }

    private void mostrarResultados() throws SQLException {
        try{
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "tb_estudiante";
            String camposTabla = "*";
            
            String condicionBusqueda = "";
            
            utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        } catch (SQLException e) {
            System.out.println("Ha ocurrido el siguiente error: " + e.getMessage());
        } finally {
            MenuPrincipal.desplegarMenu();
        }
    }
}
