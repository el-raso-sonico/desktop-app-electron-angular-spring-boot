package com.elrasosonico.gdc.editordocs;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GeneradorDocumentos {

    public static void generarDocumento(String contenido, String archivo){
        String documentos = null;
        try {
            Process p =  Runtime.getRuntime().exec("reg query \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders\" /v personal");
            p.waitFor();

            InputStream in = p.getInputStream();
            byte[] b = new byte[in.available()];
            in.read(b);
            in.close();

            documentos = new String(b);
            documentos = documentos.split("\\s\\s+")[4];

        } catch(Throwable t) {
            t.printStackTrace();
        }
        
        try {
            File file = new File(documentos+"\\"+archivo);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            Files.write(Paths.get(documentos+"\\"+archivo), contenido.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Abre la carpeta especificada con el Explorador de archivos de Windows
    public static void abrirDirectorio(String ruta) throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("explorer.exe "+ruta);
    }

}
