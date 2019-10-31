import com.pretkejgames.fmanager.core.DAOS.LeagueDAO;
import com.pretkejgames.fmanager.core.model.Club;
import com.pretkejgames.fmanager.core.model.League;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class LeagueDAOTest {
    @Test
    public void leagueLoadTest() throws IOException {
        LeagueDAO league = new LeagueDAO();
        List<Club> clubs = league.loadClubs();
        League league1 = new League(clubs);
        System.out.println(league1.getSchedule());
    }
}
