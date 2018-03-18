package lt.akademija;

import lt.vtvpmc.java.voting.Vote;
import lt.vtvpmc.java.voting.VoteRegistry;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Registers votes
 *
 * @author Andrej Orševskij
 * @version 1.0
 */

public class VoteRegistryImpl implements VoteRegistry {

    /**
     *
     * Logger 
     * votes - hold list of registered votes
     */
    private static final Logger logger = Logger.getLogger(VoteRegistryImpl.class);

    private boolean stopVoting;
    private ArrayList<Vote> votes;

    /**
     * Constructor of VoteRegistryImpl
     * Constructs a new VoteRegistryImpl with empty list
     */
    VoteRegistryImpl() {
        this.stopVoting = false;
        this.votes = new ArrayList<>();
    }

    /**
     * Registers votes
     *
     * @param vote vote to register
     * @return Returns true if vote is registered and false if not
     */
    @Override
    public boolean registerVote(Vote vote) {
        boolean nonUnique = votes.contains(vote);
        if (!nonUnique && !this.stopVoting) {
            logger.info("Vote registered " + vote + " .");
            votes.add(vote);
            return true;
        } else if (vote.getVoteCastFor() == null || vote.getVoteCastFor().equals("")) {
            throw new IllegalStateException();
        } else {
            return false;
        }
    }

    /**
     * Determinate the winner
     * @return Returns the winner or throws IllegalStateException if could not.
     */
    @Override
    public String getAWinner() {

        String[] candidates = votes.stream().map(Vote::getVoteCastFor).distinct().toArray(String[]::new);
        long votesCast = votes.stream().map(Vote::getVoteCastFor).count();

        if (candidates.length == 0 || votesCast == 0) {
            throw new IllegalStateException();
        }
        long win = 0;
        String name = null;
        for (String vote : candidates) {
            long votesForACandidate = votes.stream().filter(vote1 -> vote1.getVoteCastFor().equals(vote)).count();
            if (votesForACandidate > win) {
                win = votesForACandidate;
                name = vote;
            } else if (votesForACandidate == win) {
                throw new IllegalStateException();
            }
        }
        return name;
    }

    /**
     * Gets number of registered votes
     * @return Number of registered votes
     */
    @Override
    public int getNumberOfVotesCast() {
        return (int) votes.stream().map(Vote::getVoteCastFor).count();
    }

    /**
     * Stops voting process
     */
    @Override
    public void stopVotingProcess() {
        this.stopVoting = true;
    }
}
