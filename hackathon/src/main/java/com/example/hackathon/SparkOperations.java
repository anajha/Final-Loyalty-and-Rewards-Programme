package com.example.hackathon;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.*;

public class SparkOperations {
	
	SparkContext sc = new SparkContext(new SparkConf().setAppName("DBConnection").setMaster("local[*]"));
    SparkSession sqlContext = new SparkSession(sc);
    String url = "jdbc:mysql://localhost:3306/db_example";
	Dataset<Row> df = sqlContext
			  .read()
			  .format("jdbc")
			  .option("url", url)
			  .option("driver","com.mysql.jdbc.Driver")
			  .option("user","anajha")
			  .option("password", "ramos")
			  .option("dbtable", "masttran")
			  .load();
	
	Dataset<Row> df1 = sqlContext
			  .read()
			  .format("jdbc")
			  .option("url", url)
			  .option("driver","com.mysql.jdbc.Driver")
			  .option("user","anajha")
			  .option("password", "ramos")
			  .option("dbtable", "masttransfer")
			  .load();
	
	Dataset<Row> df2 = sqlContext
			  .read()
			  .format("jdbc")
			  .option("url", url)
			  .option("driver","com.mysql.jdbc.Driver")
			  .option("user","anajha")
			  .option("password", "ramos")
			  .option("dbtable", "cardlog")
			  .load();
				
	public List<Row> viewrecords(Long merid)
	{
	 
		
	df.createOrReplaceTempView("masttran");
	    
		
	String query="";
	query="Select HOUR(timestmp) as time,count(HOUR(timestmp)) as total from masttran where merchantid="+merid+" group by HOUR(timestmp) order by total desc";
	Dataset<Row> getdetail=sqlContext.sql(query);
	Dataset<Row> getdetails=getdetail.select("time");
	//getdetails.show();
	List<Row> values=getdetails.collectAsList();
	System.out.println(values);
	return values;
	}
	
	public List<Row> viewpanlist(Integer mnth)
	{
	
		
	df.createOrReplaceTempView("masttran");
		
	String query="";
	query="Select sum(wallval),sum(wallpaid),pan,merchantid,MONTH(timestmp) from masttran where MONTH(timestmp)="+mnth+" group by pan,merchantid,MONTH(timestmp) having sum(wallval)>100 and sum(wallpaid)=0";	
	Dataset<Row> getdetails =sqlContext.sql(query);
	//getdetails.show();
	List<Row> values=getdetails.collectAsList();
	System.out.println(values);
	return values;
	}
	
	public List<Row> viewmaxvaluemonth(Long pan)
	{
	
		
	df.createOrReplaceTempView("masttran");
		
	String query="";
	query="Select a.month from(Select MONTH(timestmp) as month,sum(wallval) as total from masttran where pan="+pan+" group by MONTH(timestmp) )a";	
	Dataset<Row> getdetails =sqlContext.sql(query);
	getdetails.show();
	List<Row> values=getdetails.collectAsList();
	System.out.println(values);
	return values;
	}
	
	public List<Row> viewunsuccessfullist(Long pan)
	{
	
		
	df1.createOrReplaceTempView("masttransfer");
		
	String query="";
	query="Select pan2,transamt,timestmp,statreason from masttransfer where pan1="+pan;	
	Dataset<Row> getdetails =sqlContext.sql(query);
	getdetails.show();
	List<Row> values=getdetails.collectAsList();
	System.out.println(values);
	return values;
	}
	
	public List<Row> viewmerchlog(Long merchid)
	{
	
	df.createOrReplaceTempView("masttran");
		
	String query="";
	query="Select pan,tranamt,tranpaid,wallval,timestmp,status,statreason from masttran where merchantid="+merchid;	
	Dataset<Row> getdetails =sqlContext.sql(query);
	getdetails.show();
	List<Row> values=getdetails.collectAsList();
	return values;
	}
	
	public List<Row> viewcardlog(Long pan)
	{
	
		
	df2.createOrReplaceTempView("cardlog");
		
	String query="";
	query="Select timestmp,activity from cardlog where pan="+pan;	
	Dataset<Row> getdetails =sqlContext.sql(query);
	getdetails.show();
	List<Row> values=getdetails.collectAsList();
	return values;
	}
}
