/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.utils.Calculator;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.unipiaget.ailson.sistemavenda.models.Sale;
import com.unipiaget.ailson.sistemavenda.models.SaleProductsDetails;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author programmer
 */
@Service
@Transactional
public class ReportService {

    @Autowired
    private SaleService ss;

    @Autowired
    private CompanyConfigService ccs;

    public byte[] generateDeliveryOrderReport(int saleId) {

        Sale s = ss.findById(saleId);
        //check if the sale exist
        if (s != null) {
            Document document = new Document(PageSize.A4, 60, 60, 45, 30);
            try {

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                PdfWriter.getInstance(document, stream);
                document.open();

                document.addTitle("Ordem de Entrega");

                //body
                Font font = new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD);

                Paragraph topTitulo;
                topTitulo = new Paragraph("Ordem de Entrega", font);

                new Paragraph();
                topTitulo.setAlignment(1);
                topTitulo.setSpacingAfter(30F);
                document.add(topTitulo);
                new Paragraph();

                font = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);

                //emmiter date
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                String ed = "Data/Hora de Emissão: " + f.format(s.getSaleDate());
                Paragraph emiterDate = new Paragraph(ed, font);
                emiterDate.setAlignment(emiterDate.ALIGN_JUSTIFIED);
                document.add(emiterDate);

                //client info
                String ci = "Cliente: " + s.getClient().getName();
                Paragraph clientInfo = new Paragraph(ci, font);
                clientInfo.setSpacingAfter(30F);
                clientInfo.setAlignment(emiterDate.ALIGN_JUSTIFIED);
                document.add(clientInfo);

                //product list
                PdfPTable table = new PdfPTable(5); // 3 columns.

                PdfPCell cell1 = new PdfPCell(new Paragraph("Codigo"));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Nome Produto"));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Preco unit."));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Qty"));
                PdfPCell cell5 = new PdfPCell(new Paragraph("Total"));

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);

                for (SaleProductsDetails p : s.getSaleProductsDetails()) {
                    PdfPCell c = new PdfPCell(new Paragraph(String.valueOf(p.getProduct().getCode())));
                    table.addCell(c);
                    PdfPCell n = new PdfPCell(new Paragraph(String.valueOf(p.getProduct().getName())));
                    table.addCell(n);
                    PdfPCell pu = new PdfPCell(new Paragraph(String.valueOf(p.getProduct().getUnitSalePrice())));
                    table.addCell(pu);
                    PdfPCell qt = new PdfPCell(new Paragraph(String.valueOf(p.getQty())));
                    table.addCell(qt);
                    PdfPCell tt = new PdfPCell(new Paragraph(String.valueOf(Calculator.calculate(p.getProduct().getUnitSalePrice(), p.getQty()))));
                    table.addCell(tt);
                }
                document.add(table);

                //sign
                Paragraph line = new Paragraph("______________________________________");
                line.setSpacingBefore(140F);
                line.setAlignment(emiterDate.ALIGN_CENTER);
                document.add(line);

                Paragraph sign = new Paragraph("Assinatura", font);
                sign.setSpacingBefore(5F);
                sign.setAlignment(emiterDate.ALIGN_CENTER);
                document.add(sign);

                //current date
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy ");

                String dt = "Data: " + sdf.format(new Date());
                Paragraph d = new Paragraph(dt);
                d.setSpacingBefore(70F);
                d.setAlignment(d.ALIGN_JUSTIFIED);

                document.add(d);

                document.close();
                return stream.toByteArray();

            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
