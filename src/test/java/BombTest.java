import org.example.entities.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BombTest {

    private Board board;

    @BeforeEach
    public void setup(){
        board = new Board(4,4,0);
    }

    //Visual test in terminal
    @Test
    public void TestCreatingBombs(){
        board.createBomb(0,0);
        board.createBomb(3,2);
        board.createBomb(2,0);
        board.createBomb(2,0);
        board.createBomb(2,0);
        board.createBomb(2,0);
        board.createBomb(2,0);
        board.createBomb(2,0);
        board.createBomb(2,0);

        board.print();
    }
}
