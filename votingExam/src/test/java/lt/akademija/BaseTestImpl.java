package lt.akademija;

import lt.vtvpmc.java.voting.AbstractVotingTest;
import lt.vtvpmc.java.voting.VoteRegistry;

public class BaseTestImpl extends AbstractVotingTest {

    @Override
    protected VoteRegistry getVoteRegistry() {
        return new VoteRegistryImpl();
    }
}
