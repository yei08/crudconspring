package com.desarrolloWeb.crud.controladores.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.desarrolloWeb.crud.modelo.Usuario;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
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
        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-30, -30, 40, 15);
        document.open();
        // throw new UnsupportedOperationException("Unimplemented method'buildPdfDocument'");
        PdfPTable tablaTitulo = new PdfPTable(1);
        PdfPCell celda = null;

        celda = new PdfPCell(new Phrase("Listado de Usuarios"));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(40, 90, 138));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(18);
         PdfPTable tablaUsuarios = new PdfPTable(8);
         tablaUsuarios.setWidths(new float[] { 1f, 2f, 2.3f, 4f, 2.3f, 5f, 2.4f, 1.8f });
         tablaTitulo.addCell(celda);

         celda = new PdfPCell(new Phrase("ID"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaUsuarios.addCell(celda);

         celda = new PdfPCell(new Phrase("Password"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaUsuarios.addCell(celda);

         celda = new PdfPCell(new Phrase("Nombre"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaUsuarios.addCell(celda);

         celda = new PdfPCell(new Phrase("Apellidos"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaUsuarios.addCell(celda);

         celda = new PdfPCell(new Phrase("Rol"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaUsuarios.addCell(celda);

         celda = new PdfPCell(new Phrase("Email"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaUsuarios.addCell(celda);

         celda = new PdfPCell(new Phrase("Telefono"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaUsuarios.addCell(celda);

         celda = new PdfPCell(new Phrase("Estado"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaUsuarios.addCell(celda);

         for(Usuario usuario : listaUsuarios) {
            celda= new PdfPCell(new Phrase(usuario.getId().toString()));
            celda.setPadding(5);
            tablaUsuarios.addCell(celda);

            celda= new PdfPCell(new Phrase(usuario.getPassword())); 
            celda.setPadding(5);
            tablaUsuarios.addCell(celda);

            celda= new PdfPCell(new Phrase(usuario.getNombre())); 
            celda.setPadding(5);
            tablaUsuarios.addCell(celda);

            celda= new PdfPCell(new Phrase(usuario.getApellidos())); 
            celda.setPadding(5);
            tablaUsuarios.addCell(celda);

            celda= new PdfPCell(new Phrase(usuario.getRol())); 
            celda.setPadding(5);
            tablaUsuarios.addCell(celda);

            celda= new PdfPCell(new Phrase(usuario.getEmail())); 
            celda.setPadding(5);
            tablaUsuarios.addCell(celda);

            celda= new PdfPCell(new Phrase(usuario.getTelefono())); 
            celda.setPadding(5);
            tablaUsuarios.addCell(celda);
          
            celda= new PdfPCell(new Phrase(usuario.getEstado())); 
            celda.setPadding(5);
            tablaUsuarios.addCell(celda);
            
            
         }
 

        //  // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // listaUsuarios.forEach(Usuario -> {
        //     tablaUsuarios.addCell(Usuario.getId().toString());
        //     tablaUsuarios.addCell(Usuario.getPassword());
        //     tablaUsuarios.addCell(Usuario.getNombre());
        //     tablaUsuarios.addCell(Usuario.getApellidos());
        //     tablaUsuarios.addCell(Usuario.getRol());
        //     tablaUsuarios.addCell(Usuario.getEmail());
        //     tablaUsuarios.addCell(Usuario.getTelefono());
        //     tablaUsuarios.addCell(Usuario.getEstado());
        // //  //  tablaUsuarios.addCell(dateFormat.format(usuario.getFechaRegistro())); // Format the date
        //  });
       document.add(tablaTitulo);
        document.add(tablaUsuarios);

    }
}
