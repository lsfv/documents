package com.linson;

public class Fruit extends goods
{
	public String Color;
	
	public Fruit(int _id,String _name,float _price,String _color)
	{
		super(_id, _name, _price,com.linson.enum_goods_type.fruit);
		Color=_color;
	}
	
	@Override
	public String MySpecialInfo()
	{
		String retString=MyBaseInfo();
		
		retString=retString+" .Color:"+Color+".";
		return retString;
	}
}