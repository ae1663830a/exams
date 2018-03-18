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
        PostStamp exists = postStampArrayList.stream().filter(postStamp1 -> postStamp1.getName().equals(postStamp.getName())).findAny().orElse(null);
        if (postStamp == null) {
            throw new IllegalArgumentException();
        } else if (postStamp.getName() == null || postStamp.getName().equals("")) {
            throw new IllegalArgumentException();
        } else if (exists == null) {
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
            return postStampArrayList.stream().mapToDouble(PostStamp::getMarketPrice).average().getAsDouble();
        }
        return 0.0;
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        return postStampArrayList.size();
    }
}
