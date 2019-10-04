import java.io.*;

public class DogObtainer {
    public static void main(String[] args) {
        Dog d;
        try {
            File otherDog = new File("H:\\CSAB Library\\Quarter 1\\Serializable Project\\dog.txt");
            FileInputStream in = new FileInputStream(otherDog);
            ObjectInputStream obj = new ObjectInputStream(in);;
            d = (Dog)obj.readObject();
            System.out.println(d);
            obj.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
