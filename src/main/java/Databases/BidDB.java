package Databases;

import Models.Bid;
import Models.Project;

import java.util.ArrayList;

public class BidDB {
    private ArrayList<Bid> bids = new ArrayList<Bid>();
    private static BidDB instance = null;

    private BidDB() {}

    public static BidDB getInstance() {
        if(instance == null)
            instance = new BidDB();
        return instance;
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public ArrayList<Bid> getProjectBids(Project project) {
        ArrayList<Bid> projectBids = new ArrayList<Bid>();
        for(Bid bid : bids) {
            if(bid.getProject().equals(project))
                projectBids.add(bid);
        }
        return projectBids;
    }
}
