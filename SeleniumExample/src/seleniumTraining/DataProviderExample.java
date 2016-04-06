package seleniumTraining;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@Test(dataProvider="registerData")
	public void testRegister(String name,String City,int age,boolean isMarried)
	{
		//System.out.println("NAME"+"------"+"CITY"+"-----------"+"AGE"+"-----"+"ISMARRIED");
		System.out.println(name+"--------"+City+"-------------"+age+"--------"+isMarried);
	}
	
	@DataProvider
	public Object[][] registerData()
	
	{
		//rows - No.of times test needs to be executed
		//Columns - No.of parameters that need to be passed
		Object [][]data = new Object[3][4];
		data[0][0] = "Name1";
		data[0][1] = "City1";
		data[0][2] = 29;
		data[0][3] = true;
		
		data[1][0] = "Name2";
		data[1][1] = "City2";
		data[1][2] = 18;
		data[1][3] = false;
		
		data[2][0] = "Name3";
		data[2][1] = "City3";
		data[2][2] = 63;
		data[2][3] = true;
		
		return data;
		
	}

}
