package Utilitypkg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilonly {
	public static String getCellValue(String excel,String sheet,int row,int col)
	{
		try
		{
			FileInputStream file=new FileInputStream(excel);
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFCell cell=wb.getSheet(sheet).getRow(row).getCell(col);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else
			{
				return cell.getRawValue();
			}
		}
		catch(Exception e)
		{
			return "";
		}
	}
	public static int getRowCount(String excel,String sheet) throws IOException
	{
		try
		{
			FileInputStream filefi=new FileInputStream(excel);
			XSSFWorkbook wb1=new XSSFWorkbook(filefi);
		
		return wb1.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			return 0;
		}
	}

}

