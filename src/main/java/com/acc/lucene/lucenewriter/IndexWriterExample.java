package com.acc.lucene.lucenewriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;

/**
 * Hello world!
 *
 */
public class IndexWriterExample 
{
    public static void main( String[] args ) throws IOException
    {
    	IndexWriter writer=null;
    	int threadCount = 0;
    	int iterationCount = 0;
    	String path = null;
    	
    	if(args !=null && args.length >0 && args.length==3){
    		path = args[0]==null?"./index":args[0];
    		threadCount = Integer.parseInt(args[1]);
    		iterationCount =Integer.parseInt(args[2]);
    		
    	}
    	List<WriteIndex> jobs = new ArrayList<>();
    	WriteIndex job = null;
    	for(int i=0;i<threadCount;i++){
    		job = new WriteIndex(iterationCount, path+i,i);
    		jobs.add(job);
    	}
    	ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    	long startTime =  System.currentTimeMillis();
    	
    	try {
			executorService.invokeAll(jobs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	executorService.shutdown();
    	long endTime  = System.currentTimeMillis() - startTime;
    	
    	System.out.println("Main Total Time Elapsed:"+endTime);
    	
    }
    
    
}
