package lt.akademija;

import lt.vtvpmc.java.voting.Vote;
import lt.vtvpmc.java.voting.VoteRegistry;

import java.util.*;

public class VoteRegistryImpl implements VoteRegistry {

    private boolean stopVoting;
    private ArrayList<Vote> votes;

    VoteRegistryImpl() {
        this.stopVoting = false;
        this.votes = new ArrayList<>();
    }

    @Override
    public boolean registerVote(Vote vote) {
        boolean nonUnique = votes.contains(vote);
        if (!nonUnique && !this.stopVoting) {
            votes.add(vote);
            return true;
        } else if (vote.getVoteCastFor() == null || vote.getVoteCastFor().equals("")) {
            throw new IllegalStateException();
        } else {
            return false;
        }
    }

    @Override
    public String getAWinner() {
        String[] candidates = votes.stream().map(Vote::getVoteCastFor).distinct().toArray(String[]::new);
        long votesCast = votes.stream().map(Vote::getVoteCastFor).count();
        if (candidates.length == 0 || votesCast == 0) {
            throw new IllegalStateException();
        }
        long win = 0;
        String winner = null;
        for (String vote : candidates) {
            long votesForACandidate = votes.stream().filter(vote1 -> vote1.getVoteCastFor().equals(vote)).count();
            if (votesForACandidate > win) {
                win = votesForACandidate;
                winner = vote;
            } else if (votesForACandidate == win) {
                throw new IllegalStateException();
            }
        }
        return winner;
    }

    @Override
    public int getNumberOfVotesCast() {
        return (int) votes.stream().map(Vote::getVoteCastFor).count();
    }

    @Override
    public void stopVotingProcess() {
        this.stopVoting = true;
    }
}
