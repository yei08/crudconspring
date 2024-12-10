package com.desarrolloWeb.crud.controladores.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.desarrolloWeb.crud.modelo.Producto;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("productos")
public class ListarProductoPdf extends AbstractPdfView {
    
       
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) {
                @SuppressWarnings("unchecked")
              
                List<Producto> listaProductos = (List<Producto>) model.get("Productos");
        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-30, -30, 40, 15);
        document.open();
        // throw new UnsupportedOperationException("Unimplemented method'buildPdfDocument'");
        PdfPTable tablaTitulo = new PdfPTable(1);
        PdfPCell celda = null;

        celda = new PdfPCell(new Phrase("Listado de Productos"));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(40, 90, 138));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(18);

         PdfPTable tablaProductos = new PdfPTable(5);
         tablaProductos.setWidths(new float[] { 1f, 3f, 2.7f, 2.1f, 1f });
         tablaTitulo.addCell(celda);

         celda = new PdfPCell(new Phrase("ID"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaProductos.addCell(celda);

         celda = new PdfPCell(new Phrase("Nombre"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaProductos.addCell(celda);

         celda = new PdfPCell(new Phrase("Precio"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaProductos.addCell(celda);

         celda = new PdfPCell(new Phrase("Cantidad"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaProductos.addCell(celda);

         celda = new PdfPCell(new Phrase("Usuario_ID"));
         celda.setBackgroundColor(Color.LIGHT_GRAY);
         celda.setHorizontalAlignment(Element.ALIGN_CENTER);
         celda.setVerticalAlignment(Element.ALIGN_CENTER);
         celda.setPadding(5);
         tablaProductos.addCell(celda);

         
        
         for(Producto producto : listaProductos) {
            celda= new PdfPCell(new Phrase(producto.getId().toString()));
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda= new PdfPCell(new Phrase(producto.getNombre())); 
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda= new PdfPCell(new Phrase(producto.getPrecio().toString()));  
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda= new PdfPCell(new Phrase(producto.getCantidad().toString())); 
            celda.setPadding(5);
            tablaProductos.addCell(celda);

            celda= new PdfPCell(new Phrase(producto.getUsuario_id().toString())); 
            celda.setPadding(5);
            tablaProductos.addCell(celda);

           
            
         }
            document.add(tablaTitulo);
            document.add(tablaProductos);

         }
}
