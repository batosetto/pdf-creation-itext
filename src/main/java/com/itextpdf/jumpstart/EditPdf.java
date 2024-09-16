package com.itextpdf.jumpstart;

/*The PdfDocument class is used to represent a PDF document.*/
import com.itextpdf.kernel.pdf.PdfDocument;

import com.itextpdf.kernel.pdf.PdfReader;


/*The PdfWriter class writes the content to the PDF file.*/
import com.itextpdf.kernel.pdf.PdfWriter;

/*The Document class is a higher-level object for handling the layout and content of the document.*/
import com.itextpdf.layout.Document;

/*This class allows you to add paragraphs of text to your PDF document.*/
import com.itextpdf.layout.element.Paragraph;

import java.io.File; // it represents file and directory pathnames.
import java.io.FileOutputStream; //to create a file output stream to write data to a file.
import java.io.IOException; //to handle input/output exceptions


public class EditPdf {

    public static final String SRC = "results/chapter01/hello_world.pdf";
    public static final String DEST = "results/chapter01/hello_world_v2.pdf";

    public static void main(String[] args) throws IOException{
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        editPdf(SRC, DEST);
    }

    public static void editPdf(String src, String dest) throws IOException{
        PdfReader reader = new PdfReader(src);
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdfDoc = new PdfDocument(reader, writer);
        Document document = new Document(pdfDoc);
        document.add(new Paragraph("\nThis is an edit version of the Hello World. PDF!"));
        document.add(new Paragraph("I am having so much fun learning how to create and edit PDFs with iText library!"));
        document.close();
        System.out.println("PDF edited and saved to: " + dest );
    }
}
