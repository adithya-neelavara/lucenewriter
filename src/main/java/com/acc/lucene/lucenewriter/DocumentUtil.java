package com.acc.lucene.lucenewriter;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

public class DocumentUtil {

	
	public static Document createDocument(Integer id, String  field1) 
	    {
	        Document document = new Document();
	        document.add(new StringField("id", id.toString() , Field.Store.YES));
	        document.add(new TextField("field1", field1 , Field.Store.YES));
	        document.add(new TextField("field2", field1 , Field.Store.YES));
	        document.add(new TextField("field3", field1 , Field.Store.YES));
	        document.add(new TextField("field4", field1 , Field.Store.YES));
	        document.add(new TextField("field5", field1 , Field.Store.YES));
	        document.add(new TextField("field6", field1 , Field.Store.YES));
	        document.add(new TextField("field7", field1 , Field.Store.YES));
	        document.add(new TextField("field8", field1 , Field.Store.YES));
	        document.add(new TextField("field9", field1 , Field.Store.YES));
	        document.add(new TextField("field10", field1 , Field.Store.YES));
	        document.add(new TextField("field11", field1 , Field.Store.YES));
	        document.add(new TextField("field12", field1 , Field.Store.YES));
	        document.add(new TextField("field13", field1 , Field.Store.YES));
	        document.add(new TextField("field14", field1 , Field.Store.YES));
	        document.add(new TextField("field15", field1 , Field.Store.YES));
	        document.add(new TextField("field16", field1 , Field.Store.YES));
	        document.add(new TextField("field17", field1 , Field.Store.YES));
	        document.add(new TextField("field18", field1 , Field.Store.YES));
	        document.add(new TextField("field19", field1 , Field.Store.YES));
	        document.add(new TextField("field20", field1 , Field.Store.YES));
	      
	        
	        return document;
	    }
	 
	  public static IndexWriter createWriter(String index_path) throws IOException 
	    {
	        FSDirectory dir = FSDirectory.open(Paths.get(index_path));
	        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
	        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
	        IndexWriter writer = new IndexWriter(dir, config);
	        return writer;
}
}
