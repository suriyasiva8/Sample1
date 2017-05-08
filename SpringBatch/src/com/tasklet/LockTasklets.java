package com.tasklet;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;




public class LockTasklets implements ItemReader<String>{

	
String message="Message from reader";
int count=0;

@Override
public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	// TODO Auto-generated method stub
	if(count<=0)
	{
	count++;
	return message;
	
	}
	else
	return null;
}

	
	
   

}
