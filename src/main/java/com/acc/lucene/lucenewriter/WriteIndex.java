package com.acc.lucene.lucenewriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;

public class WriteIndex implements Callable<String> {
	
	
	private int count;
	
	private String path;
	
	private IndexWriter indexWriter;
	
	private String name;
	
	private AtomicSequenceGenerator sequnce = new AtomicSequenceGenerator();
	
	public WriteIndex(int count,String path,int i) throws IOException {
		this.count=count;
		this.path=path;
		this.name="[WriteIndex-Thread-"+i+"]  :";
		this.indexWriter= DocumentUtil.createWriter(path);
	}

	@Override
	public String call() throws Exception {
		long startTime =  System.currentTimeMillis();
		System.out.println(name+"Writing Documents to Index");
		 List<Document> documents = new ArrayList<>();
	        Document document1 =null;
	        for(int i=0;i<count;i++){
	        	  document1 = DocumentUtil.createDocument(sequnce.getNext(),  UUID.randomUUID().toString());
	              documents.add(document1);
	        }
	        indexWriter.addDocuments(documents);
	        indexWriter.commit();
	        indexWriter.close();
	        long endTime  = System.currentTimeMillis() - startTime;
	        System.out.println(name+"Total Time Elapsed:"+endTime);
	        System.out.println(name+"Completed Writing Documents to Index");
	        return "COmpleted";
	}

}
