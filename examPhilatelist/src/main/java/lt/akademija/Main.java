package lt.akademija;

import philatelist.PostStamp;

public class Main {

    public static void main(String[] args) {

        PhilatelistImpl philatelist = new PhilatelistImpl();
        PostStamp postStamp = new PostStamp("My", 12, 15.5);
        PostStamp postStamp1 = new PostStamp("Myd", 12, 12.5);
        PostStamp postStamp2 = new PostStamp("Mydd", 12, 18.5);
        philatelist.addToCollection(postStamp);
        philatelist.addToCollection(postStamp1);
        philatelist.addToCollection(postStamp2);
        System.out.println(philatelist.getAveragePostStampPrice());

    }
}
