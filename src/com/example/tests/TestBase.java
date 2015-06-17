package com.example.tests; 
 
import java.io.File;
import java.io.FileReader; 
import java.util.Properties; 
import java.util.logging.Logger; 
 


import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeClass; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional; 
import org.testng.annotations.Parameters; 
  


import com.example.fw.ApplicationManager; 
  
  
 public class TestBase { 
	 protected static ApplicationManager app;
		private int checkFrequency;
		private int checkCounter;

		@BeforeTest
		public void setUp() throws Exception {

			String configFile = System.getProperty("configFile",
					"application.properties");
			Properties properties = new Properties();
			properties.load(new FileReader(new File(configFile)));
			app = new ApplicationManager(properties);
			checkCounter = 0;
			checkFrequency = Integer.parseInt(properties.getProperty("check.frequency","0"));

		}// 1.11.00
		
		protected boolean wantToCheck() {
			checkCounter++;
			if (checkCounter > checkFrequency) {
				checkCounter = 0;
				return true;
			}
			else
				return false;
		}
  
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}
 } 




































