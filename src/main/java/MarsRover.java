import java.util.ArrayList;
import java.util.List;

public class MarsRover {

    private int posX;
    private int posY;
    private char facingDirection;
    private final List<Obstacle> obstacles = new ArrayList<>();

    public MarsRover() {
        this.posX = 0;
        this.posY = 0;
        this.facingDirection = 'N';
    }

    public String getPosition() {

        return "X : " +
                posX +
                ", Y : " +
                posY +
                ", Facing : " +
                facingDirection;
    }

    public void command(String commandInput) {
        String[] listOfCommands = commandInput.split("");

        // for each command
        for (String command : listOfCommands) {
            switch (command) {
                case "M": // move
                    move();
                    break;
                case "L": // rotate left (!rotate)
                    rotate('W', 'N', 'E', 'S');
                    break;
                case "R": // rotate right (rotate)
                    rotate('E', 'S', 'W', 'N');
                    break;
            }
        }
    }

    private void rotate(char fromNorth, char fromEast, char fromSouth, char fromWest) {
        switch (facingDirection) {
            case 'N':
                rotate(fromNorth);
                break;
            case 'E':
                rotate(fromEast);
                break;
            case 'S':
                rotate(fromSouth);
                break;
            case 'W':
                rotate(fromWest);
                break;
        }
    }

    private void move() {

        int nextX = posX;
        int nextY = posY;

        switch (facingDirection) {
            case 'N':
                nextY++;
                break;
            case 'E':
                nextX++;
                break;
            case 'S':
                nextY--;
                break;
            case 'W':
                nextX--;
                break;
        }

        boolean blocked = false;
        for(Obstacle obstacle : obstacles) {
            if (obstacle.getPosX() == nextX && obstacle.getPosY() == nextY) {
                blocked = true;
                break;
            }
        }

        if(!blocked) {
            posX = nextX;
            posY = nextY;
        }
        isAtBorder();
    }

    private void isAtBorder() {
        if(posX == 11) {
            posX = 1;
        }
        if(posX == -1) {
            posX = 10;
        }
        if(posY == 11) {
            posY = 1;
        }
        if(posY == -1) {
            posY = 10;
        }
    }

    public void rotate(char direction) {
        setFacingDirection(direction);
    }

    public char getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(char facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }


}
