package com.rachait.biddingApp.Auction;
import com.rachait.biddingApp.pojo.AssignToOwnerPojo;
import com.rachait.biddingApp.pojo.Auction;
import com.rachait.biddingApp.pojo.AuctionPlayer;
import com.rachait.biddingApp.pojo.OwnersPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping("/createAuctionPlayer")
    public String createAuctionPlayer(@RequestParam String basePrice,@RequestParam String category,
                                      @RequestBody AuctionPlayer auctionPlayer)
            throws InterruptedException, ExecutionException {
        return auctionService.addAuctionPlayer(basePrice,category,auctionPlayer);
    }

    @GetMapping("/get")
    public AuctionPlayer getAuctionPlayer(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return auctionService.getAuctionPlayer(documentId);
    }

    @GetMapping("/getRandomPlayer")
    public AuctionPlayer getRandomAuctionPlayer(@RequestParam String basePrice,@RequestParam String category) throws Exception {
        return auctionService.getRandomPlayer(basePrice,category);
    }

    @GetMapping("/getOwnersTeam")
    public Map<String, OwnersPojo> getOwnersTeam() throws Exception {
        return auctionService.getOwersTeam();
    }

    @PutMapping("/update")
    public String updateAuctionPlayer(@RequestBody Auction auction) throws InterruptedException, ExecutionException{
        return auctionService.updateAuctionPlayer(auction);
    }

    @PutMapping("/assignPlayerToOwner")
    public String assignPlayerToOwner(@RequestBody AssignToOwnerPojo assignToOwnerPojo) throws Exception {
        return auctionService.assignToOwner(assignToOwnerPojo);
    }

    @PutMapping("/delete")
    public String deleteAuctionPlayer(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return auctionService.deleteAuctitonPlayer(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Endpoint is working");
    }
}
