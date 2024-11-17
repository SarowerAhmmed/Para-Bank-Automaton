package com.util;

public class HandleExamleTableData {

	public int getActualRow(String value) {

		// String user ="Row2_Col1";
		String row = value.split("_")[0];
		String actualRowNumber = row.replace("Row", "");
		int rowNo = Integer.parseInt(actualRowNumber);
		System.out.println("Row ="+rowNo);
		return rowNo;

	}

	public int getActualCol(String value) {

		String col = value.split("_")[1];
		String actualColumnNumber = col.replace("Col", "");
		int colNo = Integer.parseInt(actualColumnNumber);
		System.out.println("Col "+colNo);
		return colNo;

	}
	
	public static void main(String[] args) {
		String value="Row3_Col1";
		HandleExamleTableData obj = new HandleExamleTableData();
		obj.getActualRow(value);
		obj.getActualCol(value);
	}

}
