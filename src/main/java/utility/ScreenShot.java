package utility;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	public static void takeSnap(WebDriver driver,String name) throws IOException {
		String date = ScreenShot.date();
		TakesScreenshot sc = ((TakesScreenshot)driver);
		
		File source = sc.getScreenshotAs(OutputType.FILE);
		
		File destination = new File ("C:\\Users\\dhakn\\eclipse-workspace\\KiteZerodha\\ScreenShot\\"+name+""+date+".jpg");
		FileHandler.copy(source, destination);
	}
	
	public static String date() {
		
		DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		
		LocalDateTime current = LocalDateTime.now();
		
		String d = dtf.format(current);
		
		return d;
	}

}
