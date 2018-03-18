package lt.akademija;

import philatelist.Philatelist;
import philatelist.PostStamp;

import java.util.ArrayList;
import java.util.Comparator;

public class PhilatelistImpl implements Philatelist {

    private ArrayList<PostStamp> postStampArrayList;

    public PhilatelistImpl() {
        this.postStampArrayList = new ArrayList<>();
    }

    @Override
    public void addToCollection(PostStamp postStamp) {
        if (postStamp == null) {
            throw new IllegalArgumentException();
        } else if (postStamp.getName() == null || postStamp.getName().equals("")) {
            throw new IllegalArgumentException();
        } else if (!postStampArrayList.contains(postStamp)) {
            postStampArrayList.add(postStamp);
        }
    }

    @Override
    public PostStamp getTheMostExpensivePostStamByMarketValue() {
        return postStampArrayList.stream().max(Comparator.comparing(PostStamp::getMarketPrice)).get();
    }

    @Override
    public double getAveragePostStampPrice() {
        if (postStampArrayList.size() > 0) {
            System.out.println(postStampArrayList.size());
            return postStampArrayList.stream().mapToDouble(PostStamp::getMarketPrice).average().getAsDouble();
        }
        return 0.0;
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        System.out.println(postStampArrayList.size());
        return postStampArrayList.size();
    }
}

