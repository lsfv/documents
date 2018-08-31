package com.linson;

import java.util.Date;

public class Book extends goods
{
	public String writer;
	public Date publicDate;
	
	public Book(int _id,String _name,float _price,String _writer,Date _publicdate)
	{
		super(_id, _name, _price, enum_goods_type.book);
		writer=_writer;
		publicDate=_publicdate;
	}
	
	@Override
	public String MySpecialInfo()
	{
		String retString=MyBaseInfo();
		
		retString=retString+" .Writer:"+writer+".";
		return retString;
	}
	
	
}