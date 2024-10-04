package Testpkg;

import org.testng.annotations.Test;
import Basepkg.Baseclass;
import Pagepkg.Pageclass;
import Utilitypkg.Utilonly;

public class Testclass extends Baseclass
{
	@Test
	public void Test1() throws Exception
	{
		Pageclass ob=new Pageclass(driver);
		String excel="C:\\Users\\marc\\OneDrive\\Desktop\\Onlydata\\testdataonly.xlsx";
		String sheet="Sheet1";
		int rowCount=Utilonly.getRowCount(excel,sheet);
		for(int i=1;i<=rowCount;i++)
		{
			String Name=Utilonly.getCellValue(excel,sheet,i,0);
			System.out.println("Username---"+Name);
			
			String Email=Utilonly.getCellValue(excel,sheet,i,1);
			System.out.println("Email---"+Email);
			
			String Mob=Utilonly.getCellValue(excel,sheet,i,2);
			System.out.println("Mob no:---"+Mob);
			
			String Pswd=Utilonly.getCellValue(excel,sheet,i,3);
			System.out.println("Password---"+Pswd);
			
			String DOB=Utilonly.getCellValue(excel,sheet,i,4);
			System.out.println("DOB---"+DOB);
			
			ob.setvalues(Name,Email,Mob,Pswd,DOB);
		}
		driver.navigate().back();
		ob.search();
		ob.cart();
		ob.screenshot();
		ob.home();
		driver.quit();
	}
}
