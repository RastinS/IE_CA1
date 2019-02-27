package Handlers;

import Databases.BidDB;
import Models.Bid;
import Models.Project;
import Models.Skill;
import Models.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BidHandler {
    private static BidDB bidDB;

    public static void init() { bidDB = BidDB.getInstance(); }

    public static void addNewBid(String data) throws JSONException {
        JSONObject newBidData = new JSONObject(data);
        User user = UserHandler.findUser(newBidData.getString("biddingUser"));
        Project project = ProjectHandler.findProject(newBidData.getString("projectTitle"));

        if(isUserValidForProject(user, project)) {
            Bid newBid = new Bid();
            newBid.setUser(user);
            newBid.setProject(project);
            newBid.setBidAmount(newBidData.getInt("bidAmount"));
            newBid.computeValue();
            bidDB.addBid(newBid);
        }
    }

    public static void auction(String data) throws JSONException {
        JSONObject auctionData = new JSONObject(data);
        ArrayList<Bid> projectBids = bidDB.getProjectBids(ProjectHandler.findProject(auctionData.getString("projectTitle")));
        Bid bestBid = findBestBid(projectBids);
        System.out.println(bestBid.getUser().getUserName());
    }

    private static Bid findBestBid(ArrayList<Bid> bids) {
        Bid bestBid = bids.get(0);
        for(int i = 1; i < bids.size(); i++) {
            if(bids.get(i).getValue() > bestBid.getValue())
                bestBid = bids.get(i);
        }
        return bestBid;
    }

    private static boolean isUserValidForProject(User user, Project project) {
        for(Skill skill : project.getSkillsSet()) {
            if(user.getSkillPoints(skill) < skill.getPoints())
                return false;
        }
        return true;
    }
}
