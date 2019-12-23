package order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class LogFile {
	
	public static void write(String strLog) {
		
		File logFile = new File(OrderExtraction.logFilePath);
		PrintWriter printWriter = null;
		String result = null;
		
		try {
			//Write log	        
	        if(!logFile.exists()) {
	        	logFile.createNewFile();
	        }
	        printWriter = new PrintWriter(new FileWriter(logFile, true));
	        printWriter.println(strLog);
		}catch(Exception e) {
			result = result + e.toString() +"\n";
		}finally {
			printWriter.close();
		}
		
	}

}
