package com.learn.section14;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Test {
	

//    @org.testng.annotations.Test
//	public void regular() {
//	ArrayList<String> names=new ArrayList<String>();
//	names.add("Mom");
//	names.add("Dad");
//	names.add("akka");
//	names.add("me");
//	int count=0;
//	
//	for(int i=0;i<names.size();i++) {
//		String actual =names.get(i);
//		if(actual.startsWith("M")) {
//			count++;
//		}
//		else {
//			System.out.println("Data not found");
//		}
//	}
//}
    
    @org.testng.annotations.Test
	public void streamFilter() {
	ArrayList<String> names=new ArrayList<String>();
	names.add("Mom");
	names.add("Dad");
	names.add("akka");
	names.add("me");
	long c=names.stream().filter(s->s.startsWith("D")).count();
	System.out.println("The count is "+c);
	long d=Stream.of("Mom","Dad","akka","me").filter(s->
	{
	s.startsWith("D");	
	return false;
	}).count();
//	System.out.println(d);
//	names.stream().filter(s->s.length()>2).forEach(s->System.out.println(s));
	names.stream().filter(s->s.length()>2).limit(2).forEach(s->System.out.println(s));
	
}
	
}
