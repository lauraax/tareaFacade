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

public class EscritorArchivo {
        public void escribir(String archivoPath, String contenido) {
        try {
            BufferedWriter writer = new BufferedWriter(new EscritorArchivo(archivoPath));
            writer.write(contenido);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
