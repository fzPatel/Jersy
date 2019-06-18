package com.learn.iText;

import java.util.ArrayList;
import java.util.Arrays;

public class PdfData
{	
	private ArrayList<String> clidocid[] ;
	
	
	public ArrayList<String>[] getClidocid() {
		return clidocid;
	}

	public void setClidocid(ArrayList<String>[] clidocid) {
		this.clidocid = clidocid;
	}




	@Override
	public String toString() {
		return "PdfData [clidocid=" + Arrays.toString(clidocid) + "]";
	}
	
	
}
