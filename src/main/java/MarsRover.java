public class MarsRover {

    private int posX;
    private int posY;
    private char facingDirection;

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

    public void move(String commandInput) {
        String[] listOfCommands = commandInput.split("");

        // for each command
        for (String command : listOfCommands) {
            switch (command) {
                case "M": // move
                    moving();
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

    private void moving() {
        switch (facingDirection) {
            case 'N':
                posY++;
                break;
            case 'E':
                posX++;
                break;
            case 'S':
                posY--;
                break;
            case 'W':
                posX--;
                break;
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


}
