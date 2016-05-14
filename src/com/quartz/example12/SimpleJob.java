package com.quartz.example12;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b> </b>
 * <p>
 * 功能:
 * </p>
 * 
 * @作者 张涛
 * @创建日期 2013-12-24
 * @项目名称 quartzDemo
 * @JAVA路径 com.quartz.example1.HelloQuartz
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SimpleJob implements Job {

	private static Logger log = LoggerFactory.getLogger(SimpleJob.class);
	private JobKey jobkey=null;
   
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		jobkey = context.getJobDetail().getKey();
		
		String message = context.getJobDetail().getJobDataMap().getString("msg");
		
		log.info("simplejob:"+jobkey+" execute at "+ new Date());
		log.info("simple message is "+ message);
	}
   
}

