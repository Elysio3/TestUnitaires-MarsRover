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
    public void shouldMove() {
        // TODO Rover should change position
        marsRover.move(1);
        assertThat(marsRover.getPosition()).isEqualTo("X : 0, Y : 1, Facing : N");
    }

    @Test
    public void shouldRotate() {
        // TODO Rover should change facingDirection
        marsRover.rotate('E');
        assertThat(marsRover.getFacingDirection()).isEqualTo('E');
    }
}
