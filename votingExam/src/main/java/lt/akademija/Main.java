package lt.akademija;


import lt.vtvpmc.java.voting.Vote;
import org.apache.log4j.Logger;

public class Main {

    static final Logger logger = Logger.getLogger(VoteRegistryImpl.class);

    public static void main(String[] args) {

        VoteRegistryImpl voteRegistry = new VoteRegistryImpl();
        Vote vote = new Vote("1", "as");
        Vote vote1 = new Vote("2", "as");
        Vote vote2 = new Vote("3", "as");
        Vote vote3 = new Vote("4", "asa");
        Vote vote4 = new Vote("5", "asa");
        voteRegistry.registerVote(vote);
        voteRegistry.registerVote(vote1);
        voteRegistry.registerVote(vote2);
        voteRegistry.registerVote(vote3);
        voteRegistry.registerVote(vote4);
        voteRegistry.registerVote(vote4);
        System.out.println(voteRegistry.getNumberOfVotesCast());

        voteRegistry.getAWinner();
    }
}
