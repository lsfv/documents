//1.number    2.enum     3.format float

package com.linson;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import java.util.TreeSet;


enum enum_op 
{  
	add,minus,time,divide
}

public class HelloWord implements IShowBase
{
	public static void main(String[] args) 
	{
		Study_io();
	}
	
	public static void Study_io()
	{
		//write ; 1.no file. 2.rewaite or append. 3. code.
		String tempstrString="好的阿.你哈噢阿"+System.lineSeparator()+"abc";
		IOFile.Write2File("test2.txt", tempstrString, false);
		
		IOFile.Write2File("ee.txt", "", false);
		
		
		//read 1.file is null. 2.empty file . 3 code .4 line
		String retstr="";
		retstr= IOFile.readFromStringFile("test2.txt");
		System.out.println(retstr);
	}
	
	public static void Study_class_callback()
	{
		Book book_cshart=new Book(0, "c#2", 3.1f, "linson", new Date());
		System.out.println(book_cshart.MyBaseInfo_Custom());

		HelloWord theclass=new HelloWord();
		book_cshart.showBaseHandler=(IShowBase) theclass;
		
		System.out.println(book_cshart.MyBaseInfo_Custom());
	}
	
	public String showbase(goods gsinfo)
	{
		DecimalFormat dt=new DecimalFormat();
		dt.applyLocalizedPattern("0.00000000");
		String priceformat=dt.format(gsinfo.price);
		return "ID:"+gsinfo.id+". price:"+priceformat+ "(i can define it ,but dont modify goods.java)"; 
	}
	

	//主要掌握主要的集合.和如何遍历他们.基本数组, 可变集合,不重复集合,字典类型    java 是list  set  map.
	public static void Study_Array()
	{
		String[] books={"c#","c++","c","java","oc"};
		for(int i=0;i<books.length;i++)
		{
			System.out.println(books[i]);
		}
		
		//list arraylist .linkedlist
		List<String> booksList=new LinkedList<String>(); //new ArrayList<String>();
		booksList.add("c#");
		booksList.add("c#234");
		booksList.add("c");
		for(int i=0;i<booksList.size();i++)
		{
			System.out.println(booksList.get(i));
		}
		System.out.println("array remove ..............");
		booksList.remove(1);
		for(int i=0;i<booksList.size();i++)
		{
			System.out.println(booksList.get(i));
		}
		
		
		//set treeset hashset.
		Set<String> bookset=new TreeSet<String>();
		bookset.add("c#");
		bookset.add("java");
		bookset.add("c");
		
		
		System.out.println("set ..............");
		//猜测看出,迭代项,第一项是指向第一个元素之前的.而不是c++默认的 beginit;
		Iterator<String> it=bookset.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		//恩,熟视无睹,之前看到可枚举,可碟带类型,也没有太在意.一般都是for循环. 其实可碟带的话,就说明,系统可以基于iterator提供一个for each的语法糖给你.
		//而利用普通的for.还 必须先获得某个key的组合,在怎么转换过来 .其实直接用for each吧.用迭代还不如for each .
		System.out.println("set222 ..............");
		for (String mystr : bookset) 
		{
			System.out.println(mystr);
		}

		//map 
		System.out.println("map ..............");
		java.util.Map<Integer, String> mymap = new HashMap<Integer, String>(); 
	
		mymap.put(1, "c++");
		mymap.put(2, "c");
		mymap.put(3, "java");
		
		//不推荐使用.毕竟查来查去.才得到结果.
		for(Integer mykey: mymap.keySet())
		{
			System.out.println(mykey);
			System.out.println(mymap.get(mykey));
		}
		
		System.out.println("map loop..............");
		//碟带起,效率高.
		for(Entry<Integer, String> it2 :mymap.entrySet())
		{
			System.out.println(it2.getKey()+":"+it2.getValue());
		}
		
	}
	
	
	public static void Study_class()
	{
		//goods基类是否应该是一个虚类.其实并不是固定的.看场景,如果把goods基类看作现实物品的基类,那么就应该是虚类.因为不存在一个概念的物品.
		//但如果把goods 看作是某物品的基本信息类,那么可以是普通类.代表一个物品的基础信息.
		//下面就是作为基类创建.
		List<goods> mygoods=new ArrayList<goods>();
		goods book_cshart=new goods(0, "c#", 3.1f, enum_goods_type.book);
		goods book_javaGoods=new goods(1, "java", 4.5f, enum_goods_type.book);
		goods fruit_apple=new goods(3,"apple",1f,enum_goods_type.fruit);
		goods fruit_banana=new goods(4,"banana",0.9f,enum_goods_type.fruit);
		
		mygoods.add(book_cshart);
		mygoods.add(book_javaGoods);
		mygoods.add(fruit_apple);
		mygoods.add(fruit_banana);
		
		for(int i=0;i<mygoods.size();i++)
		{
			System.out.println("base:"+mygoods.get(i).MyBaseInfo());
			System.out.println("special"+mygoods.get(i).MySpecialInfo());
		}
		
		
		//派生类创建
		book_cshart=new Book(0, "c#2", 3.1f, "linson", new Date());
		book_javaGoods=new Book(10, "java2", 4.5f, "linson", new Date());
		fruit_apple=new Fruit(3, "apple2", 1f, "red");
		fruit_banana=new Fruit(4,"banana2",0.9f,"yellow");
		
		List<goods> mygoods2=new ArrayList<goods>();
		mygoods2.add(book_cshart);
		mygoods2.add(book_javaGoods);
		mygoods2.add(fruit_apple);
		mygoods2.add(fruit_banana);
		
		
		for(int i=0;i<mygoods.size();i++)
		{
			System.out.println("base:"+mygoods2.get(i).MyBaseInfo());
			System.out.println("special"+mygoods2.get(i).MySpecialInfo());
		}
	}
	
	
	
	public static void Study_string()
	{
		String[] books={"c#","c++","c","java","oc"};
		String Singlestr=StudyString.JoinString(books, '|');
		System.out.println(Singlestr);
		
		String[] books2=StudyString.SplitString(Singlestr, '|');
		for(int i=0;i<books2.length;i++)
		{
			System.out.println(books2[i]);
		}
		
		System.out.println(StudyString.IsContain(Singlestr, "python"));
	}

	
	public static void number()
	{
		System.out.println("hello world");
		
		HelloWord mMainHelloWord=new HelloWord();
		enum_op[] allOps=enum_op.values();
		
		int a=2,b=3;
		for(int i=0;i<allOps.length;i++)
		{
			System.out.println(mMainHelloWord.NumberCaculate(a, b, allOps[i]));
			System.out.println(mMainHelloWord.NumberCaculate_float(a, b, allOps[i]));
		}
		
		//format float
		DecimalFormat tempDF=new DecimalFormat();
		tempDF.applyPattern("0.00");
		float tempret=mMainHelloWord.NumberCaculate_float(16, 3, enum_op.divide);
		System.out.println(tempDF.format(tempret));
	}
	
	
	public int NumberCaculate(int a,int b,enum_op operate)
	{
		int ret=0;
		
		switch (operate) 
		{
			case add:
				ret=a+b;
				break;
			case minus:
				ret=a-b;
				break;
			case time:
				ret=a*b;
				break;
			case divide:
				ret=a/b;
				break;
			default:
				break;
		}
		return ret;
	}
	
	public float NumberCaculate_float(float a,float b,enum_op operate)
	{
		float ret=0;
		
		switch (operate) 
		{
			case add:
				ret=a+b;
				break;
			case minus:
				ret=a-b;
				break;
			case time:
				ret=a*b;
				break;
			case divide:
				ret=a/b;
				break;
			default:
				break;
		}
		return ret;
	}
}