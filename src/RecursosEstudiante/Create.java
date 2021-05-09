package RecursosEstudiante;

import java.sql.SQLException;
import java.util.Scanner;

public class Create {
   Create() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Estudiante person = new Estudiante();
        System.out.println("<< CREAR REGISTRO >>");
        
        System.out.println("Nombres: ");
        person.setNomEstudiante(sc.next());

        System.out.println("Apellidos: ");
        person.setApeEstudiante(sc.next());

        System.out.println("Carnet: ");
        person.setCarnetEstudiante(sc.next());
        
        System.out.println("Edad: ");
        person.setEdadEstudiante(sc.nextInt());

        
        String tabla = "tb_estudiante";
        String camposTabla = "nom_estudiante, ape_estudiante, carnet_estudiante, edad_estudiante";
        String valoresCampos = " ' " + person.getNomEstudiante() + " ' , ' " + person.getApeEstudiante() + " ' , ' " + person.getCarnetEstudiante() +  " ' , ' "  + person.getEdadEstudiante() + " ' ";

        ConexionCRUD utilerias = new ConexionCRUD();
        utilerias.guardarRegistros(tabla, camposTabla, valoresCampos);
        
        MenuPrincipal.desplegarMenu();
    }
}

