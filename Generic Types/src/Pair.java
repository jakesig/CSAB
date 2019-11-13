public class Pair<T,S> {

    private final T first;
    private final S second;

    /**
     * Create an ObjectTuple with the provided objects.
     *
     * @param first The first object.
     * @param second The second object.
     */
    public Pair(T t, S s) {
        this.first = t;
        this.second = s;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "<" + first.toString() + ", " + second.toString() + ">";
    }

}
