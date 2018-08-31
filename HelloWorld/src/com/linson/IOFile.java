package com.linson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public abstract class IOFile 
{
	public static void Write2File(String filePath,String content,boolean isappend)
	{
		try 
		{
			File f = new File(filePath);
			FileOutputStream fop = new FileOutputStream(f);
			OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
			writer.append(content);
			writer.close();
			fop.close();
        } 
		catch (IOException e) 
		{  
            //e.printStackTrace();  
        }
	}
	
	public static String readFromStringFile(String filePath)
	{
		String retString=null;
		try
		{
			File f = new File(filePath);
			FileInputStream finoutStream=new FileInputStream(f);
			InputStreamReader reader=new InputStreamReader(finoutStream, "UTF-8");
			
			StringBuffer sb = new StringBuffer();
	        while (reader.ready()) 
	        {
	            sb.append((char) reader.read());
	        }
	        retString=sb.toString();
	        
	        reader.close();
	        finoutStream.close();
		}
		catch(IOException e)
		{
			retString=null;
		}
		
		return retString;
	}
}