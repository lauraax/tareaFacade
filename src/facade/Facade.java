
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import subsystem.LectorArchivo;
import subsystem.EscritorArchivo;
import subsystem.FileEncryptor;

public class Facade {
    private LectorArchivo fileReader;
    private EscritorArchivo fileWriter;
    private FileEncryptor fileEncryptor;

    // Instancia estática de la fachada, inicializada de manera perezosa (Lazy Initialization)
    private static Facade instance;

    // Constructor privado para evitar instanciación externa
    private Facade() {
        fileReader = new LectorArchivo();
        fileWriter = new EscritorArchivo();
        fileEncryptor = new FileEncryptor();
    }

    // Método público para obtener la instancia única de la fachada
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public void escribir(String fileName, String content) {
        String encryptedContent = fileEncryptor.encrypt(content);
        fileWriter.write(fileName, encryptedContent);
    }

    public String leer(String fileName) {
        String encryptedContent = fileReader.read(fileName);
        return fileEncryptor.decrypt(encryptedContent);
    }
}

