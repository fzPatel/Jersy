package com.chillyfacts.com;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;


public class Create_PDF_FROM_DB {
 
    public static void main(String[] args) {
    	String FILE_NAME = "E:\\java_pdf\\chillyfacts_DB.pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();
            
            Paragraph p = new Paragraph();
            p.add("Text 1");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            
            Paragraph p2 = new Paragraph();
            p2.add("Text 2"); //no alignment
            document.add(p2);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);
            
            document.add(new Paragraph("This is my paragraph 3", f));
            
            document.add(Image.getInstance("E:\\java_pdf\\chillyfacts.png"));
            
            
            DBConnection obj_DBConnection=new DBConnection();
            Connection connection=obj_DBConnection.getConnection();
            String query="select * from date_time";            
            Statement stmt = null;
            stmt = connection.createStatement();            
            ResultSet rs=stmt.executeQuery(query);
            Paragraph p3=null;
            while(rs.next()){
            	p3 = new Paragraph();
            	p3.add(rs.getString("date_time")); 
            	document.add(p3);
            }
            
            
            document.close();
            
            System.out.println("Done");
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}