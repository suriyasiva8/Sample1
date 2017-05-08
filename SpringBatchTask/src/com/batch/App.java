package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String args[])
	{
		App obj=new App();
		obj.run();
	}
	
	public void run()
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("/com/config/job-config.xml");
		JobLauncher joblauncher=(JobLauncher) context.getBean("jobLauncher");
		Job job=(Job) context.getBean("batchJob");
		try {

			JobExecution execution = joblauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("Done");
	}

}
