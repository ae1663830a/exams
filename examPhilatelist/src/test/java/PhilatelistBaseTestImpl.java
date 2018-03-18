import lt.akademija.PhilatelistImpl;
import philatelist.Philatelist;
import philatelist.PhilatelistBaseTest;

public class PhilatelistBaseTestImpl extends PhilatelistBaseTest {
    @Override
    protected Philatelist getPhilatelist() {
        return new PhilatelistImpl();
    }
}
