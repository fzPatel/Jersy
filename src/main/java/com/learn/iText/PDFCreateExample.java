package com.learn.iText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFCreateExample {
	public static void main(String args[]) {
		try {
			// Create Document instance.
			Document document = new Document();

			// Create OutputStream instance.
			OutputStream outputStream = new FileOutputStream(new File("E:\\iText\\TestFile9.pdf"));

			// Create PDFWriter instance.
			PdfWriter.getInstance(document, outputStream);

			// Open the document.
			document.open();

			
			PdfPTable table = createFirstTable();

			table.setWidthPercentage(50);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.setHorizontalAlignment(Element.ALIGN_RIGHT);
			document.add(table);

			document.close();
			outputStream.close();

			System.out.println("Pdf created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static PdfPTable createFirstTable() {
		// a table with three columns
	
		
		
		float [] pointColumnWidths = {150F, 150F, 150F};   
		PdfPTable table = new PdfPTable(pointColumnWidths);    
	      
	      // Adding cells to the table       
		table.addCell(new PdfPCell(new Phrase("Name")));

		table.addCell(new PdfPCell(new Phrase("Raju")));
		table.addCell(new PdfPCell(new Phrase("Id")));
		table.addCell(new PdfPCell(new Phrase("1001")));
		table.addCell(new PdfPCell(new Phrase("Designation")));
		table.addCell(new PdfPCell(new Phrase("Programmer")));
	      // Adding Table to document        
		
		
		
		return table;
	}
}