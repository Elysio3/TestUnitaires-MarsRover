import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    private MarsRover marsRover;

    @BeforeEach
    public void setUpEach() {
        marsRover = new MarsRover();
    }

    @Test
    public void shouldInitRover() {
        // TODO Rover should be initialized to 0, 0, N
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 0, Facing : N");
    }

    @Test
    public void shouldMoveM() {
        // TODO Rover should change position
        marsRover.move("M");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 1, Facing : N");

        marsRover.move("MM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 3, Facing : N");

        marsRover.move("MMM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 6, Facing : N");

    }

    @Test
    public void shouldRotateR() {
        // TODO Rover should change facingDirection
        marsRover.move("R");
        assertThat(marsRover.getFacingDirection()).isEqualTo('E');

        marsRover.move("RR");
        assertThat(marsRover.getFacingDirection()).isEqualTo('W');

        marsRover.move("RRR");
        assertThat(marsRover.getFacingDirection()).isEqualTo('S');

    }

    @Test
    public void shouldMoveToBorder() {
        // TODO Rover should change position
        marsRover.move("MMMMMMMMMM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 10, Facing : N");

        marsRover.move("M");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 10, Facing : N");

    }
}
