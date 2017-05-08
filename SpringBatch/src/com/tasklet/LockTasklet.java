package com.tasklet;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class LockTasklet implements Tasklet {

	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		 String url = "jdbc:db2://172.24.2.99:60000/HPDDA";
		    String user="db2inst1";
		    String password= "Admin@321";
		    Connection con;
		    Statement stmt;
		    try 
		    {                                                                        
		      Class.forName("com.ibm.db2.jcc.DB2Driver");                             
		      System.out.println("**** Loaded the JDBC driver");
		      con = DriverManager.getConnection (url, user, password);                 
		      con.setAutoCommit(false);
		      System.out.println("**** Created a JDBC connection to the data source");
		      stmt = con.createStatement();                                           
		      stmt.execute("LOCK TABLE pda.paucv1 IN EXCLUSIVE MODE");
		      Thread.sleep(60000);
		     // stmt.close();
		      con.commit();
		      System.out.println ( "**** Transaction committed" );
		    //  con.close();  
		      con.setAutoCommit(false);

		 
		    }
		    
		    catch (ClassNotFoundException e)
		    {
		      System.err.println("Could not load JDBC driver");
		      System.out.println("Exception: " + e);
		      e.printStackTrace();
		    }

		    catch(SQLException ex)                                                      
		    {
		      System.err.println("SQLException information");
		      while(ex!=null) {
		        System.err.println ("Error msg: " + ex.getMessage());
		        System.err.println ("SQLSTATE: " + ex.getSQLState());
		        System.err.println ("Error code: " + ex.getErrorCode());
		        ex.printStackTrace();
		        ex = ex.getNextException(); 
		      }
		    }
		return RepeatStatus.FINISHED;

	}

	

}