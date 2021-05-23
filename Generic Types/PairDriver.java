public class PairDriver {
    /**
     * Create several stadium pairs then print the name of the stadium with the largest capacity.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {

        Pair<String, Integer>[] stadiums = new Pair[3];
        stadiums[0] = new Pair<String, Integer>("Bridgeforth Stadium", 25000);
        stadiums[1] = new Pair<String, Integer>("Michigan Stadium", 109901);
        stadiums[2] = new Pair<String, Integer>("Lane Stadium", 66233);

        //System.out.println(stadiums[0]);
        System.out.println(largestStadium(stadiums));
    }

    /**
     * Returns the name of the stadium with the largest capacity.
     *
     * @param stadiums An array of ObjectPairs where each pair contains a stadium name followed by an
     *        integer capacity
     * @return The name of the stadium with the largest capacity
     */
    public static String largestStadium(Pair<String, Integer>[] stadiums) {
       Integer biggest = stadiums[0].getSecond();
       int index = 0;
        for (int i = 1; i < stadiums.length; i++) {
            if (stadiums[i].getSecond()>biggest) {
                biggest = stadiums[i].getSecond();
                index = i;
            }
        }
        return stadiums[index].getFirst();
    }
}
