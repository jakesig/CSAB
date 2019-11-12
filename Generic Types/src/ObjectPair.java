public class ObjectPair {

    private final Object first;
    private final Object second;

    /**
     * Create an ObjectTuple with the provided objects.
     *
     * @param first The first object.
     * @param second The second object.
     */
    public ObjectPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "<" + first.toString() + ", " + second.toString() + ">";
    }

}

