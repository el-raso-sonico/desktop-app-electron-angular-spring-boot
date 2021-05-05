package com.elrasosonico.gdc.editordocs;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GeneradorDocumentos {

    public static void generarDocumento(String contenido, String archivo){


        try {
            File file = new File("./"+archivo);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            Files.write(Paths.get("./"+archivo), contenido.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
