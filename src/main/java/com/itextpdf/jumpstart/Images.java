package com.itextpdf.jumpstart;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;
import java.io.File;

public class Images {

    public static final String DEST = "results/chapter01/images.pdf";
    public static final String JOCA =  "src/main/resources/img/joca.jpeg";
    public static final String ZECA =  "src/main/resources/img/zeca.jpeg";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        createFileWithImage(DEST);
    }

    public static void createFileWithImage(String dest) throws IOException {
        // Veriy if images exist
//        File jocaFile = new File(JOCA);
//        File zecaFile = new File(ZECA);
//
//        if (!jocaFile.exists()) {
//            System.out.println("Imagem 'joca.jpeg' não encontrada: " + jocaFile.getAbsolutePath());
//        }
//        if (!zecaFile.exists()) {
//            System.out.println("Imagem 'zeca.jpeg' não encontrada: " + zecaFile.getAbsolutePath());
//        }


        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);


        Image joca = new Image(ImageDataFactory.create(JOCA));
        Image zeca = new Image(ImageDataFactory.create(ZECA));

        joca.setWidth(150);
        joca.setHeight(150);
        zeca.setWidth(150);
        zeca.setHeight(150);


        document.add(new Paragraph("My oldest boy is Joca "));
        document.add(joca);
        document.add(new Paragraph("and my craziest and youngest boy is Zeca "));
        document.add(zeca);


        document.close();
    }
}
