import java.io.*;
import java.util.ArrayList;

public class DogObtainer {
    public static void main(String[] args) {
        //serialize a dog.
        Dog d;
        try {
            File otherDog = new File("H:\\CSAB Library\\Quarter 1\\Serializable Project\\dog.txt");
            FileInputStream in = new FileInputStream(otherDog);
            ObjectInputStream obj = new ObjectInputStream(in);
            d = (Dog)obj.readObject();
            System.out.println("New Dog:"+d);
            obj.close();
        } catch (Exception e) {

        }
        //serialize an arrayList of dogs.
        ArrayList<Dog> otherPack;
        try {
            File otherDogList = new File("H:\\CSAB Library\\Quarter 1\\Serializable Project\\dogList.txt");
            FileInputStream inList = new FileInputStream(otherDogList);
            ObjectInputStream objList = new ObjectInputStream(inList);
            otherPack = (ArrayList)objList.readObject();
            System.out.println("New List:"+otherPack);
            objList.close();
        } catch (Exception e) {

        }
    }
}
