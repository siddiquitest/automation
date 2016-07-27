package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	File scr;
	public ExcelDataConfig (String path)
	{
		try {
			scr = new File ("D:\\Users\\sarsiddi\\Documents\\eclipse\\TestDataVueling.xlsx");
			
			FileInputStream fis = new FileInputStream(scr);
					
			wb = new XSSFWorkbook(fis);
			
			
		} 
		 catch (Exception e) {
			 System.out.println(e.getMessage());
			
		}
	} 

	
	public String data (String SheetNumber, int row, int colum)
	{
		sheet1 = wb.getSheet(SheetNumber);
		String data = this.sheet1.getRow(row).getCell(colum).getStringCellValue();
		
		return data;
	}
	
	public String dataByIndex (int SheetNumber, int row, int colum)
	{
		sheet1 = wb.getSheetAt(SheetNumber);
		String data = this.sheet1.getRow(row).getCell(colum).getStringCellValue();
		
		return data;
	}
	
	public int getLastCountColumnSheet(String hoja)
	{
		int lastcount;
		sheet1=wb.getSheet(hoja);
		lastcount=this.sheet1.getLastRowNum();
		
		return lastcount;
	}
	
	public int getLastCountColumnIndex(int index)
	{
		
		sheet1=wb.getSheetAt(index);
		return this.sheet1.getLastRowNum();
				
	}
	
	public void writeCell(String info, int row, int column)
	{
		this.sheet1.getRow(row).createCell(column).setCellValue(info);
		
	/*	FileOutputStream fout = new FileOutputStream(this.src);
		
		wb.write(fout);*/
	}
	
	
	public void printResultSheet(String hoja, int col)
	{
		for (int i = 0; i < this.getLastCountColumnSheet(hoja); i++) {
			
			System.out.println("testing data in fila"+i+"is..:"+this.data(hoja,i,col));
			
		}
	} 
	

	public List<String> columnToList(String hoja, int col)
	{
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < this.getLastCountColumnSheet(hoja); i++) {
			String value = (String)this.data(hoja,i,col);
		 list.add(value);	
			//System.out.println("testing data in colum"+i+"is..:"+this.data(hoja,i,col));
			
		}
		return list;
		
	} 
	
	public List<List<String>> columnToListNxN(String hoja)
	{
		List<List<String>> listMatrix = new ArrayList<List<String>>();
		for (int i = 0; i < 50; i++) {
		 List<String> list = new ArrayList<String>();
				
			for (int j = 0; j < this.getLastCountColumnSheet(hoja)+1; j++) {
			String value = (String)this.data(hoja,j,i);
			list.add(value);	
	//	System.out.println("testing data in ["+i+"]["+j+"] ==>"+this.data(hoja,j,i));
			}
		 listMatrix.add(list);	
		}
		return listMatrix;
		
	}
	
	
	public void printResultIndex(int index)
	{
		for (int i = 0; i < this.getLastCountColumnIndex(index); i++) {
			System.out.println("testing data in colum"+i+"is..:"+this.dataByIndex(index,i,0));
			
		}
	}
	
}
