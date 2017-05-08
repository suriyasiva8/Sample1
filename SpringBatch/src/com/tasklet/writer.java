package com.tasklet;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class writer implements ItemWriter<String> {

	
	@Override
	public void write(List<? extends String> message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Writer"+message);
		System.out.println("writer");
	}

}
