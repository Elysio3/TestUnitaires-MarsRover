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
                    break;
                case "L": // rotate left (!rotate)
                    switch (facingDirection) {
                        case 'N':
                            rotate('W');
                            break;
                        case 'E':
                            rotate('N');
                            break;
                        case 'S':
                            rotate('E');
                            break;
                        case 'W':
                            rotate('S');
                            break;
                    }
                    break;
                case "R": // rotate right (rotate)
                    switch (facingDirection) {
                        case 'N':
                            rotate('E');
                            break;
                        case 'E':
                            rotate('S');
                            break;
                        case 'S':
                            rotate('W');
                            break;
                        case 'W':
                            rotate('N');
                            break;
                    }
                    break;
            }
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
