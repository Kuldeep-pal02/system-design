package com.lucene.handson;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

public class LuceneIndexInspector {

    public static void main(String[] args) throws IOException {
        IndexReader indexReader = DirectoryReader.open(FSDirectory.open(Paths.get( "lucene-index")));

        int maxDocs = indexReader.maxDoc();
        System.out.println( "=========" + maxDocs);

        Random random = new Random();

        // Generate a random number between 0 (inclusive) and 9,010,200 (inclusive)
        int randomNumber = random.nextInt(maxDocs);
        int i = randomNumber;
        System.out.println( "=========" + i);
//        for( int i =0;i< indexReader.maxDoc();i++){
            Document document = indexReader.document( i );
            System.out.println( "DocumentId : "+ i);
            document.getFields().forEach( indexableField -> {
                System.out.println( indexableField.name() + " : "+ document.get( indexableField.name() ) );

            });
            System.out.println( "=========");
//        }

        indexReader.close();
    }
}
