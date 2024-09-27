package com.lucene.handson;

import com.lucene.handson.model.User;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class LuceneDemoDriver {

    public static void main(String[] args) throws IOException {

        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();

        Directory index = FSDirectory.open(Paths.get("lucene-index"));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig( standardAnalyzer );

        IndexWriter indexWriter = new IndexWriter( index, indexWriterConfig) ;
        int batch = 1000;
        for( int i=0;i< batch ;i++ ){
            batch( indexWriter);
        }
        indexWriter.close();
    }

    private static void batch( IndexWriter indexWriter) throws IOException {
        int numberOfUsers = 1000;
        List<User> userList = User.getNRandomUser( numberOfUsers );

        for( int i=0; i<numberOfUsers;i++){
            System.out.println( i );
            indexWriter.addDocument( toDocument( userList.get( 0) ));
        }
    }

    public static Document toDocument( User user ){
        Document document = new Document();
        document.add( new StringField( "id", user.getId(), Field.Store.YES));
        document.add( new TextField( "name", user.getName(), Field.Store.YES));
        document.add( new TextField( "email", user.getEmail(), Field.Store.YES));
        document.add( new TextField( "description", user.getDescription(), Field.Store.YES));

        return  document;
    }
}
