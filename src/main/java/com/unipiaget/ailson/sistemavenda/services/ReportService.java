/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author programmer
 */
@Service
@Transactional
public class ReportService {

    public byte[] generateDeliveryOrderReport() {

        Document document = new Document(PageSize.A4, 60, 60, 45, 30);
        try {

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, stream);
            document.open();

            Font font = new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD);
            Paragraph topTitulo;
            topTitulo = new Paragraph("Ordem de Entrega", font);

            new Paragraph();
            topTitulo.setAlignment(1);
            document.add(topTitulo);
            new Paragraph();

            font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Paragraph body = new Paragraph("Ailson Moreira", font);
            body.setAlignment(body.ALIGN_JUSTIFIED);
            document.add(body);

            document.close();

            return stream.toByteArray();

        } catch (Exception e) {
            return null;

        }
    }

}
