package com.rachait.biddingApp.Auction;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.CollectionReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utils {
    public static Map<String, Object> getAllDocsInCollection(Firestore db, String collectionName) throws Exception {
        Map<String, Object> docsInCollection = null;
        CollectionReference collectionRef = db.collection(collectionName);
        // Create a query to get all documents in the collection
        Query query = collectionRef;
        // Retrieve the documents in the query
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        for (QueryDocumentSnapshot document : querySnapshot.get().getDocuments()) {
            docsInCollection.put(document.getId(),document.getData());
            System.out.println(document.getId() + " => " + document.getData());
        }
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
        // Generate a random number to select a random document
        Random random = new Random();
        int randomIndex = random.nextInt(documents.size());
        // Get the random document
        DocumentSnapshot randomDocument = documents.get(randomIndex);
        // Print the ID and data of the random document
        System.out.println("Random document ID: " + randomDocument.getId());
        System.out.println("Random document data: " + randomDocument.getData());
        // Close the connection
        db.close();
        return docsInCollection;
    }


    public static long getDocCountInCollection(Firestore db, String collectionName) throws Exception {
        CollectionReference collectionRef = db.collection(collectionName);
        // Create a query to get all documents in the collection
        Query query = collectionRef;
        // Retrieve the documents in the query
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        long documentCount = querySnapshot.get().size();
        System.out.println("Count of docs in collection : " + documentCount);
        // Close the connection
        db.close();
        return documentCount;
    }

    public static Map<String, Object> getRandomDocInCollection(Firestore db, String collectionName) throws Exception {

        Map<String, Object> randomDoc = new HashMap<>();
        // Get a reference to the collection
        CollectionReference collectionRef = db.collection(collectionName);

        // Retrieve the documents in the collection
        ApiFuture<QuerySnapshot> querySnapshot = collectionRef.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        // Generate a random number to select a random document
        Random random = new Random();
        int randomIndex = random.nextInt(documents.size());

        // Get the random document
        DocumentSnapshot randomDocument = documents.get(randomIndex);

        // Print the ID and data of the random document
        System.out.println("Random document ID: " + randomDocument.getId());
        System.out.println("Random document data: " + randomDocument.getData());
        randomDoc.put(randomDocument.getId().toString(),randomDocument.getData());
        // Close the connection
        db.close();

        return randomDoc;
    }
}
