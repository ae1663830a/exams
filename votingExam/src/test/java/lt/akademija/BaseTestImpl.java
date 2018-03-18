package lt.akademija;

import lt.vtvpmc.java.voting.AbstractVotingTest;
import lt.vtvpmc.java.voting.VoteRegistry;

/**
 * class BaseTestImpl - tests VoteRegistry methods.
 *
 * @author Andrej Orševskij
 * @version 1.0
 */
public class BaseTestImpl extends AbstractVotingTest {

    /**
     * Creates new VoteRegistry
     * @return Return VoteRegistry
     */
    @Override
    protected VoteRegistry getVoteRegistry() {
        return new VoteRegistryImpl();
    }
}
