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
        marsRover.command("M");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 1, Facing : N");

        marsRover.command("MM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 3, Facing : N");

        marsRover.command("MMM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 6, Facing : N");

    }

    @Test
    public void shouldRotateR() {
        // TODO Rover should change facingDirection
        marsRover.command("R");
        assertThat(marsRover.getFacingDirection()).isEqualTo('E');

        marsRover.command("RR");
        assertThat(marsRover.getFacingDirection()).isEqualTo('W');

        marsRover.command("RRR");
        assertThat(marsRover.getFacingDirection()).isEqualTo('S');

    }

    @Test
    public void shouldMoveToBorder() {
        // TODO Rover should change position
        marsRover.command("MMMMMMMMMM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 10, Facing : N");
    }

    @Test
    public void shouldMoveToOtherSide() {
        // TODO Rover should change position
        marsRover.command("MMMMMMMMMM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 10, Facing : N");

        marsRover.command("M");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 1, Facing : N");
    }

    @Test
    public void shouldGetBlockedByObstacle() {
        // TODO Rover should change position

        marsRover.addObstacle(new Obstacle(0, 3)); // 0,2
        marsRover.addObstacle(new Obstacle(3, 2)); // 2,2

        // rover at 0,0,N
        marsRover.command("MM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 2, Facing : N");

        // can't move to 0,2
        marsRover.command("M");
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 2, Facing : N");

        // rover at 0,0,N
        marsRover.command("RMM");
        assertThat(marsRover.getPosition()).isEqualTo("X : 2, Y : 2, Facing : E");

        // can't move to 0,2
        marsRover.command("M");
        assertThat(marsRover.getPosition()).isEqualTo("X : 2, Y : 2, Facing : E");
    }
}
