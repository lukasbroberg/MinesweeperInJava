import org.example.entities.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BombTest {

    private Board board;

    @BeforeEach
    public void setup(){
        board = new Board(8,8,0);
    }

    @Test
    public void TestCreatingBombs(){

    }
}
