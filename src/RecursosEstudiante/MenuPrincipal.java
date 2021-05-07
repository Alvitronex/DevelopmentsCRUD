
package RecursosEstudiante;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal 

{


    public static void main(String[] args) throws SQLException {
     desplegarMenu();
    }
    public static void desplegarMenu() throws SQLException{
        Scanner opcionSeleccionada = new Scanner (System.in);
        String opcionMenu;
        
        System.out.println("********************************************");
        System.out.println("|              Menú Principal              |");
        System.out.println("|******************************************|");
        System.out.println("|                 Opciones                 |");
        System.out.println("|             1. Crear Registro            |");
        System.out.println("|             2. Consultar Registro        |");
        System.out.println("|             3. Actualizar Registro       |");
        System.out.println("|             4. Eliminar Resgistro        |");
        System.out.println("|             5. Salir                     |");
        System.out.println("********************************************");
        System.out.print("Seleccionar Opcion: ");
        opcionMenu = opcionSeleccionada.next();
        //aue 
        switch (opcionMenu){
            case "1":
                // Crear Resgistro
                break;
            case "2":
                //Leer = Nuevo Leer
                break;
            case"3":
                //Actualizar= Actualizar Nuevo
                break;
            case "4":
                // Eliminar = Eliminar Nuevo
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Seleccion Invalida");
        }
    }
 
    
}
