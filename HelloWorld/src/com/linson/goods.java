package com.linson;

import java.text.DecimalFormat;

enum enum_goods_type
{
	book,
	fruit;
}


public class goods 
{
	public int id;
	public String name;
	public float price;
	public enum_goods_type gtype;
	public IShowBase showBaseHandler;
	
	public goods(int _id,String _name,float _price,enum_goods_type _type)
	{
		id=_id;
		name=_name;
		price=_price;
		gtype=_type;
	}
	
	public String MyBaseInfo()
	{
		DecimalFormat dt=new DecimalFormat();
		dt.applyLocalizedPattern("0.00");
		String priceformat=dt.format(price);
		return "ID:"+id+". Name:"+name+". price:"+priceformat+". type:"+gtype.name();
	}
	
	public String MyBaseInfo_Custom()
	{
		if(showBaseHandler==null)
		{
			return "custome hander is null";
		}
		else 
		{
			return "custome :"+ showBaseHandler.showbase(this);
		}
	}
	
	public String MySpecialInfo()
	{
		return "";
	}
}