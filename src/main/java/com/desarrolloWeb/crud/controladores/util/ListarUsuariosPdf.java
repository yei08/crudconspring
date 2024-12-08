package com.desarrolloWeb.crud.controladores.util;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.desarrolloWeb.crud.modelo.Usuario;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("index")
public class ListarUsuariosPdf extends AbstractPdfView {

    
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) {
                @SuppressWarnings("unchecked")
        List<Usuario> listaUsuarios = (List<Usuario>) model.get("usuarios");

        // throw new UnsupportedOperationException("Unimplemented method'buildPdfDocument'");

         PdfPTable tablaUsuarios = new PdfPTable(8);
        // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        listaUsuarios.forEach(Usuario -> {
            tablaUsuarios.addCell(Usuario.getId().toString());
            tablaUsuarios.addCell(Usuario.getPassword());
            tablaUsuarios.addCell(Usuario.getNombre());
            tablaUsuarios.addCell(Usuario.getApellidos());
            tablaUsuarios.addCell(Usuario.getRol());
            tablaUsuarios.addCell(Usuario.getEmail());
            tablaUsuarios.addCell(Usuario.getTelefono());
            tablaUsuarios.addCell(Usuario.getEstado());
           // tablaUsuarios.addCell(dateFormat.format(usuario.getFechaRegistro())); // Format the date
        });
        document.add(tablaUsuarios);
    }
}
