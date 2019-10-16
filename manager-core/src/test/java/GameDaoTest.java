import com.pretkejgames.fmanager.core.DAOS.GameDao;
import com.pretkejgames.fmanager.core.model.Club;
import com.pretkejgames.fmanager.core.model.Game;
import com.pretkejgames.fmanager.core.model.Male;
import com.pretkejgames.fmanager.core.model.Manager;
import org.junit.Test;

public class GameDaoTest {
    @Test
    public void saveGameTest () {
        Game game = new Game(new Manager("Irex", "Pretekst", Male.MALE), new Club("Ac Pretekst"));
        GameDao.saveGame("testPretkej.txt",game);
    }
}
