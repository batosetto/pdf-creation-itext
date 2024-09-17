package com.itextpdf.jumpstart;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.List;

import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;

public class Lists {

    public static final String DEST = "results/chapter01/lists.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        creatList(DEST);
    }

    public static void creatList(String dest) throws IOException{
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        //Creating a PdfFont
        PdfFont font = PdfFontFactory.createFont(FontConstants.COURIER_OBLIQUE);
        //Adding a Paragraph
        document.add(new Paragraph("iText is: ").setFont(font));

        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);

        list.add(new ListItem("Never gonna give up"))
                .add(new ListItem("Never gonna let you down"))
                .add(new ListItem("Never gonna run around and desert you"))
                .add(new ListItem("Never gonna make you cry"))
                .add(new ListItem("Never gonna say goodbye"))
                .add(new ListItem("Never gonna tell a lie and hurt you"));

        document.add(list);
        document.close();
    }
}
