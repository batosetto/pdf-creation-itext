package com.itextpdf.jumpstart;

/*The PdfDocument class is used to represent a PDF document.*/
import com.itextpdf.kernel.pdf.PdfDocument;


/*The PdfWriter class writes the content to the PDF file.*/
import com.itextpdf.kernel.pdf.PdfWriter;

/*The Document class is a higher-level object for handling the layout and content of the document.*/
import com.itextpdf.layout.Document;

/*This class allows you to add paragraphs of text to your PDF document.*/
import com.itextpdf.layout.element.Paragraph;

import java.io.File; // it represents file and directory pathnames.
import java.io.FileOutputStream; //to create a file output stream to write data to a file.
import java.io.IOException; //to handle input/output exceptions
public class HelloWorld {

    public static final String DEST = "results/chapter01/hello_world.pdf";

    public static void main(String[] args) throws IOException{
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new HelloWorld().createPdf(DEST);

    }

    public void createPdf(String destination) throws IOException{
        //Initializing pdf writer
        FileOutputStream fos = new FileOutputStream(DEST);
        PdfWriter writer = new PdfWriter(fos);

        //Initializing pdf document
        PdfDocument pdf = new PdfDocument(writer);

        //Initializing document
        Document document = new Document(pdf);

        //Adding paragraph to the content
        document.add(new Paragraph("Hello World!"));
        document.close();

    }



}
