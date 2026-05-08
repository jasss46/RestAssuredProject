package APITesting;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {


    public static void main(String[] args) {

        ArrayList<String> myList= new ArrayList<String>();

        myList.add("Mohali");
        myList.add("Chandigarh");
        myList.add("Pathankot");
        myList.add("Jaipur");
        myList.add("Jammu");
        System.out.println(myList);

        for(int i=0; i<myList.size();i++){
            System.out.println(myList.get(i));

        }

        System.out.println(myList.size());

        System.out.println(myList.get(3));
        myList.remove(3);
        System.out.println(myList);


    }
}
