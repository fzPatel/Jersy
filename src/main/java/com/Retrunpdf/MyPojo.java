package com.Retrunpdf;

import java.util.ArrayList;

public class MyPojo
{
    private ArrayList<PhysicalSigns> physicalSigns;

	public ArrayList<PhysicalSigns> getPhysicalSigns() {
		return physicalSigns;
	}

	public void setPhysicalSigns(ArrayList<PhysicalSigns> physicalSigns) {
		this.physicalSigns = physicalSigns;
	}

	@Override
	public String toString() {
		return "MyPojo [physicalSigns=" + physicalSigns + "]";
	}
   
    
    
    
}
