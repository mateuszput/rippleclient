package rippleclient;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Node
{
    private Integer port;
    private List<Integer> unl;

    public static void main( String[] args )
    {
        Node node = new Node();
        node.setPorts(args);
    }


    public void setPorts(String[] args){
        port = new Integer(args[0]);
        unl = new ArrayList<Integer>();


        unl.add(Integer.getInteger(args[1]));
        unl.add(Integer.getInteger(args[2]));
        unl.add(Integer.getInteger(args[3]));
        unl.add(Integer.getInteger(args[4]));
    }
}
