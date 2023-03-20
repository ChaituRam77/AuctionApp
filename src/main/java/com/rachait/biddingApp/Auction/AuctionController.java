package com.rachait.biddingApp.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ExecutionException;

@RestController
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping("/create")
    public String createAuctionPlayer(@RequestBody Auction auction) throws InterruptedException, ExecutionException {
        return auctionService.createAuctitonPlayer(auction);
    }

    @GetMapping("/get")
    public AuctionPlayer getAuctionPlayer(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return auctionService.getAuctitonPlayer(documentId);
    }

    @GetMapping("/getRandomPlayer")
    public AuctionPlayer getRandomAuctionPlayer(@RequestParam String basePrice,@RequestParam String category) throws InterruptedException, ExecutionException{
        return auctionService.getRandomPlayer(basePrice,category);
    }

    @PutMapping("/update")
    public String updateAuctionPlayer(@RequestBody Auction auction) throws InterruptedException, ExecutionException{
        return auctionService.updateAuctitonPlayer(auction);
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
