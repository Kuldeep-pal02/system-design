package com.lucene.handson;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

import java.nio.file.Paths;

public class LuceneFieldSearchExample {

    public static void main(String[] args) {
        try {
            // 1. Create an Analyzer
            Analyzer analyzer = new StandardAnalyzer();

            // 2. Create the index in memory
            Directory index = FSDirectory.open(Paths.get( "lucene-index"));

            // 3. Set up IndexWriter configuration
            IndexWriterConfig config = new IndexWriterConfig(analyzer);

            // 4. Create an IndexWriter
            IndexWriter writer = new IndexWriter(index, config);
            // 6. Query the index for a specific field (e.g., searching "title" field)
            String queryStr = "1727345331791GpTZt"; // The search query
            Query query = new QueryParser("description", analyzer).parse(queryStr);

            // 7. Search the index
            DirectoryReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs results = searcher.search(query, 10);

            // 8. Display the results
            System.out.println("Found " + results.totalHits.value + " hit(s).");

            for (ScoreDoc hit : results.scoreDocs) {
                int docId = hit.doc;
                Document d = searcher.doc(docId);
                System.out.println("Id: " + d.get("id") + ", name: " + d.get("name") + ", email: " + d.get("email"));
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
