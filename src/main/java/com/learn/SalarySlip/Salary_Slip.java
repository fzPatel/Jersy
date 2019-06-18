package com.learn.SalarySlip;

public class Salary_Slip {
	private SalaryData SalaryData;

	public SalaryData getSalaryData() {
		return SalaryData;
	}

	public void setSalaryData(SalaryData SalaryData) {
		this.SalaryData = SalaryData;
	}

	@Override
	public String toString() {
		return "ClassPojo [SalaryData = " + SalaryData + "]";
	}

}
