import java.lang.reflect.Array;
import java.util.ArrayList;

public class Note {
    private final int xcoord;
    private final int ycoord;
    private final int width;
    private final int height;
    private final String colour;
    private final String message;
    private ArrayList<int[]> pins = new ArrayList<>();

    public Note(int xcoord, int ycoord, int width, int height,
            String colour, String message) {
            this.xcoord = xcoord;
            this.ycoord = ycoord;
            this.width = width;
            this.height = height;
            this.colour = colour;
            this.message = message;
    }

    // Getter Methods
    public int getxCoord() {
        return this.xcoord;
    }
    public int getyCoord() {
        return this.ycoord;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public String getColour() {
        return this.colour;
    }
    public String getMessage() {
        return this.message;
    }
    public Boolean isPinned() {
        return (!this.pins.isEmpty());
    }

    // Setter Methods
    public void pinNote(int x, int y) {
        this.pins.add(new int[] {x, y});
    }
    public void unpinNote(int x, int y) {
        pins.removeIf(pin -> x == pin[0] && y == pin[1]);
    }

    //Functional Methods
    /**
     * @param x - x coordinate of input
     * @param y - y coordinate of input
     * @return - returns tre if the x coordinate and y coordinate are within the
     * area of the note
     */
    public Boolean withinNote(int x, int y) {
        if (x >= getxCoord() && x <= getxCoord() + getWidth()) {
            return y >= getyCoord() && y <= getyCoord() + getHeight();
        }
        return false;
    }

    /**
     *
     * @param inputColour - The colour this card is being checked for
     * @return - returns true if inputColour matches colour, returns false otherwise
     */
    public Boolean colourMatches(String inputColour) {
        return inputColour.equals(getColour());
    }

    /**
     *
     * @param inputReference - The reference this card is being checked for
     * @return - returns true if the input reference matches card refersTo, return false otherwise
     */
    public Boolean referenceMatches(String inputReference) {
        return this.getMessage().contains(inputReference);
    }

    public String getCoordsAsString() {
        return "[" + this.getxCoord() + "," + this.getyCoord() + "] ";
    }
}
