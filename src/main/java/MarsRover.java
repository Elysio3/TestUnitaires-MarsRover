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

    public void move(int distance) {
        switch (facingDirection) {
            case 'N':
                posY += distance;
                break;
            case 'E':
                posX += distance;
                break;
            case 'S':
                posY -= distance;
                break;
            case 'O':
                posX -= distance;
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
