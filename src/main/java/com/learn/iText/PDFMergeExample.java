package com.learn.iText;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFMergeExample {
 
    static void mergePdfFiles(List<InputStream> inputPdfList,
            OutputStream outputStream) throws Exception{
 
        //Create document and pdfReader objects.
	Document document = new Document();
        List<PdfReader> readers = 
        		new ArrayList<PdfReader>();
        int totalPages = 0;
 
        //Create pdf Iterator object using inputPdfList.
        Iterator<InputStream> pdfIterator = 
        		inputPdfList.iterator();
 
        // Create reader list for the input pdf files.
        while (pdfIterator.hasNext()) {
                InputStream pdf = pdfIterator.next();
                PdfReader pdfReader = new PdfReader(pdf);
                readers.add(pdfReader);
                totalPages = totalPages + pdfReader.getNumberOfPages();
        }
 
        // Create writer for the outputStream
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
 
        //Open document.
        document.open();
 
        //Contain the pdf data.
        PdfContentByte pageContentByte = writer.getDirectContent();
 
        PdfImportedPage pdfImportedPage;
        int currentPdfReaderPage = 1;
        Iterator<PdfReader> iteratorPDFReader = readers.iterator();
 
        // Iterate and process the reader list.
        while (iteratorPDFReader.hasNext()) {
          PdfReader pdfReader = iteratorPDFReader.next();
          //Create page and add content.
          while (currentPdfReaderPage <= pdfReader.getNumberOfPages()) {
                      document.newPage();
                      pdfImportedPage = writer.getImportedPage(
                    		  pdfReader,currentPdfReaderPage);
                      pageContentByte.addTemplate(pdfImportedPage, 0, 0);
                      currentPdfReaderPage++;
          }
          currentPdfReaderPage = 1;
        }
 
        //Close document and outputStream.
        outputStream.flush();
        document.close();
        outputStream.close();
 
        System.out.println("Pdf files merged successfully.");
       }
 
	public static void main(String args[]){
	  try {
	    //Prepare input pdf file list as list of input stream.
	    List<InputStream> inputPdfList = new ArrayList<InputStream>();
	    inputPdfList.add(new FileInputStream("E:\\iText\\data\\0.pdf"));
	    inputPdfList.add(new FileInputStream("E:\\iText\\data\\1.pdf"));
//	    inputPdfList.add(new FileInputStream("E:\\iText\\TestFile7.pdf"));

	    //Prepare output stream for merged pdf file.
            OutputStream outputStream = 
            		new FileOutputStream("E:\\iText\\data\\FinalMerge1.pdf");
 
     
            for(int i=0;i<=inputPdfList.size();i++) 
            {
                mergePdfFiles(inputPdfList, outputStream);     

            }
            
            
            byte[] input_file = Files.readAllBytes(Paths.get("E:\\iText\\"+"FinalMerge.pdf"));

            byte[] encodedBytes = Base64.getEncoder().encode(input_file);
            String encodedString =  new String(encodedBytes);
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());

            FileOutputStream fos = new FileOutputStream("E:\\iText\\"+"FinalMerge.pdf");
            fos.write(decodedBytes);
            fos.flush();
            fos.close();
	  }           
            //call method to merge pdf files.
	    catch (Exception e) {
		e.printStackTrace();
	  }
	}
}