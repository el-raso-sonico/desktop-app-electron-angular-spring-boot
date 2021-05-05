package com.elrasosonico.gdc.api;

import com.elrasosonico.gdc.api.models.Ficha;
import com.elrasosonico.gdc.editordocs.GeneradorDocumentos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


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
        return ficha.toString();
    }


}