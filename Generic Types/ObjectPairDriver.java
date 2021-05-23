public class ObjectPairDriver {

    /**
     * Create several stadium pairs then print the name of the stadium with the largest capacity.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {

        ObjectPair[] stadiums = new ObjectPair[3];
        stadiums[0] = new ObjectPair("Bridgeforth Stadium", 25000);
        stadiums[1] = new ObjectPair("Michigan Stadium", 109901);
        stadiums[2] = new ObjectPair("Lane Stadium", "66,233");

        System.out.println(stadiums[0]);
        System.out.println(largestStadium(stadiums));
    }

    /**
     * Returns the name of the stadium with the largest capacity.
     *
     * @param stadiums An array of ObjectPairs where each pair contains a stadium name followed by an
     *        integer capacity
     * @return The name of the stadium with the largest capacity
     */
    public static String largestStadium(ObjectPair[] stadiums) {
        ObjectPair biggest = stadiums[0];
        String integer = Integer.toString((Integer)stadiums[0].getSecond());
        String integerNew = ""+0;
        for (int i = 1; i < stadiums.length; i++) {
            integerNew = Integer.toString((Integer)stadiums[i].getSecond());
            if (Integer.parseInt(integer)<Integer.parseInt(integerNew))
                biggest = stadiums[i];
        }
        return (String)biggest.getFirst();
    }

}
