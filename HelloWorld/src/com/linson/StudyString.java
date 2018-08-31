package com.linson;

public abstract class StudyString 
{
	public static String JoinString(String[] data,char splitChar)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<data.length;i++)
		{
			String tempString=data[i].replace(splitChar, ' ');
			if(i!=0)
			{
				sb.append(splitChar);
			}
			
			sb.append(tempString);
		}
		return sb.toString();
	}
	
	public static  String[] SplitString(String mystr,char splitChar) 
	{
		String strsplit="\\"+splitChar+"";//java need \\ to present a special .eg:|
		return mystr.split(strsplit);
	}
	
	public static boolean IsContain(String mystr, String substr) 
	{
		return mystr.contains(substr);
	}
}