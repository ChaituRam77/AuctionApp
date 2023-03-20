package com.rachait.biddingApp.Auction;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
@Component
public class AuctionService {

    public String createAuctitonPlayer(Auction auction) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("baseprice3").document(auction.getName()).set(auction);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public AuctionPlayer getAuctitonPlayer(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("baseprice3").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        AuctionPlayer auction;
        if (document.exists()){
            auction = document.toObject(AuctionPlayer.class);
            return auction;
        }
        return null;
    }

    public AuctionPlayer getRandomPlayer(String basePrice, String category) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionRef = dbFirestore.collection("baseprice"+basePrice+"_"+category);

        // Retrieve the documents in the collection
        ApiFuture<QuerySnapshot> querySnapshot = collectionRef.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        // Generate a random number to select a random document
        Random random = new Random();
        int randomIndex = random.nextInt(documents.size());
        // Get the random document
        DocumentSnapshot randomDocument = documents.get(randomIndex);
        AuctionPlayer auction;
        if (randomDocument.exists()){
            auction = randomDocument.toObject(AuctionPlayer.class);
            return auction;
        }
        return null;
    }

    public String updateAuctitonPlayer(Auction auction) {
        return "";
    }

    public String deleteAuctitonPlayer(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("baseprice3").document(documentId).delete();
        return "Successfully deleted!";
    }
}
