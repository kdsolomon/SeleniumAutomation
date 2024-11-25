package com.learn.section14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	

    @org.testng.annotations.Test
	public void regular() {
	ArrayList<String> names=new ArrayList<String>();
	names.add("Mom");
	names.add("Dad");
	names.add("akka");
	names.add("me");
	int count=0;
	
	for(int i=0;i<names.size();i++) {
		String actual =names.get(i);
		if(actual.startsWith("M")) {
			count++;
		}
		else {
			System.out.println("Data not found");
		}
	}
}
    
    @org.testng.annotations.Test
	public void streamFilter() {
	ArrayList<String> names=new ArrayList<String>();
	names.add("Mom");
	names.add("Dad");
	names.add("akka");
	names.add("me");
	
	ArrayList<String> names1=new ArrayList<String>();
	names1.add("Ma");
	names1.add("Daddy");
	names1.add("pandi");
	names1.add("mee");
	
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
	Stream<String> newStream= Stream.concat(names.stream(), names1.stream());
	newStream.forEach(s->System.out.println(s));
	//newStream.sorted().forEach(s->System.out.println(s));
	boolean bo=newStream.anyMatch(s->s.equalsIgnoreCase("Daddy"));
	System.out.println(bo);
	org.testng.Assert.assertTrue(bo);
	
	
	
	
}
    @org.testng.annotations.Test
    public void streamMap() {
   	//Stream.of("Mom","Dad","akka","me").filter(s->s.endsWith("m")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
   	
   	List<String>names=Arrays.asList("mom","dad","akka","me");
   	System.out.println("sorted data is ");
   //	names.stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
   	names.stream().sorted().forEach(s->System.out.println(s));
    }
    @org.testng.annotations.Test
    public void list() {
    	List<Integer> it= Arrays.asList(3,2,3,4,5,4,3,45);
    	//print unique numbers and sort the array
    	System.out.println("Sorted data is ");
    	it.stream().distinct().forEach(s->System.out.println(s));
    	List<Integer> itit=it.stream().distinct().sorted().collect(Collectors.toList());
    	System.out.println(itit.get(3));
    	
    }
	
}
