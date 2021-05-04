package com.elrasosonico.gdc.api;

import com.elrasosonico.gdc.api.models.Ficha;
import com.elrasosonico.gdc.editordocs.GeneradorDocumentos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;


import static com.elrasosonico.gdc.configuraciones.Constantes.*;
@RestController
@RequestMapping(URL_API+"docgen")
@Tag(description = "Genera un documento.txt", name = "Generador de Documentos de Documentos")
public class GeneradorDocumentosController {

    @Operation(summary = "Crea un archivo con el contenido recibido")
    @PostMapping(value = "/")
    public String generarFicha(@RequestBody Ficha ficha) throws IOException{
        //CREA EL ARCHIVO
        GeneradorDocumentos.generarDocumento(ficha.nombre_1+" "+ficha.nombre_2+" "+ficha.apellido_1+" "+ficha.apellido_2 +" "+ ficha.cedula,"Archivo.txt");

        //OBTENIENDO RUTA DE MIS DOCUMENTOS
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

        //ABRE EL DIRECTORIO DEL ARCHIVO
        GeneradorDocumentos.abrirDirectorio(documentos);

        return ficha.toString();
    }


}