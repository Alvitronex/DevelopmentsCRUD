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

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args)
        throws SQLException {
        desplegarMenu();
    }

    public static void desplegarMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String menu;
        
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("|                       OPCIONES                          |");
        System.out.println("|-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
        System.out.println("|                                                         |");
        System.out.println("|                 1. Crear  registros                     |");
        System.out.println("|                 2. Consultar registros                  |");
        System.out.println("|                 3. Actualizar registros                 |");
        System.out.println("|                 4. Eliminar registros                   |");
        System.out.println("|                 5. Salir                                |");
        System.out.println("|                                                         |");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.print("Seleccionar opcion: ");
        menu = sc.next();
        
        
        //Seleccion del menu
        switch (menu) {
            case "1":
                    Create create = new Create();
                break;
            case "2": 
                    Read read = new Read();
                break;
            case "3": 
                    Update update = new Update();
                break;
            case "4": 
                    Delete delete = new Delete();
                break;
            case "5": 
                     System.exit(0);
                break;
            default:
                    System.out.println("Opcion seleccionada invalida");
                 break;
        }
    }
}
