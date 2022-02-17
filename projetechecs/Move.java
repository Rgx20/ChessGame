public class Move {
    private final Coordinates origin;
    private final Coordinates destination;

    public Move(int ox, int oy, int dx, int dy) {
        origin = new Coordinates(ox, oy);
        destination = new Coordinates(dx, dy);
    }

    public Move(Coordinates from, Coordinates to) {
        origin = from;
        destination = to;
    }

    public Coordinates getOrigin() {
        return origin;
    }

    public Coordinates getDestination() {
        return destination;
    }
}
