package RecursosEstudiante;
import java.sql.SQLException;
import java.util.Scanner;
public class Delete {//clase para eliminar registros
    Delete() throws  SQLException{
        Scanner leer = new Scanner(System.in);
        ConexionCRUD utilerias = new ConexionCRUD();
        
        System.out.println("\n<< ELIMINAR REGISTROS >>");
        System.out.println("\nIngresa el id del registro: ");
        String idContactoEliminar = leer.next();
        //ingreso de datos para actualizar
        String tabla="tb_estudiante";
        String campos = "*";
        String condicion = "id_estudiante = " + idContactoEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
       
        System.out.println("Precionar  <<Y>>  para comfirmar: ");
        String confirmarBorrar = leer.next();
        
        if("Y".equals(confirmarBorrar)){
            String valoresCamposNuevos = "";
            utilerias.actualizarEliminarRegistro(tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro borrado satisfactoriamente");
        }
        MenuPrincipal.desplegarMenu();
    }
}
