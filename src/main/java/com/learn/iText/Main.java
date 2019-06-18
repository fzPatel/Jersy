/*

package com.learn.iText;
import cljpdf.text.BadElementException;
import cljpdf.text.Document;
import cljpdf.text.Image;
import cljpdf.text.pdf.PdfWriter;
import org.yogthos.JsonPDF;
import cljpdf.text.pdf.PdfPageEventHelper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws Exception {
        String jsonDoc1 = "[{}, [\"paragraph\", \"hello world\"]]";
        String jsonDoc2 = "[{\"pages\":true,\"orientation\":\"landscape\"}, [\"paragraph\", \"hello world\"]]";

        JsonPDF.writeToFile(jsonDoc1, "out.pdf", null);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        JsonPDF.writeToStream(new ByteArrayInputStream(jsonDoc1.getBytes()),
                new FileOutputStream("outstream.pdf"), null);

        System.out.println(new File(".").getAbsolutePath());
        JsonPDF.writeToFile(jsonDoc1, "out.pdf", new HeaderFooter("resources/mandelbrot.jpg"));
    }

    static class HeaderFooter extends PdfPageEventHelper {
        private Image img;
        public HeaderFooter(String imagePath)
                throws BadElementException, MalformedURLException, IOException {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(imagePath);
            this.img = Image.getInstance(file.getPath());
            this.img.scaleToFit(100, 100);
            this.img.setAbsolutePosition(25,700);
        }

        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            try {
                writer.getDirectContent().addImage(this.img);
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
}

*/