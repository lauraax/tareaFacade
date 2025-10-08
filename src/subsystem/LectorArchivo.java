/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsystem;

/**
 *
 * @author Estudiantes
 */
import java.io.*;

public class LectorArchivo {
    public String leer(String archivoPath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivoPath));
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            reader.close();
            return contenido.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
    
