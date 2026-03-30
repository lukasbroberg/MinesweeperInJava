import org.example.Controller.GameController;
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

    @Test
    public void testFirstClickBomb(){
        GameController gameController = new GameController();
        gameController.board=board;
        board.createBomb(0,0);
        board.createBomb(3,2);
        board.createBomb(2,0);
        board.createBomb(2,0);
        board.createBomb(2,0);
        board.createBomb(2,0);
        board.createBomb(2,0);

        System.out.println("Before first reveal");
        board.print();

        System.out.println("After first reveal");
        gameController.revealField(board.getField(1,1));

        board.print();

    }
}
