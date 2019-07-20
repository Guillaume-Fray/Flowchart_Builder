/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u08009cwk;

import java.util.ArrayList;

/**
 *
 * @author guillaumefray
 */
public class TestHarness { 
    public static void main(String[] args){
        double x;
        double y;
        String title;
        ArrayList<NodeSup> nodes = new ArrayList<>();
        
        ActionN actN1 = new ActionN("actN1",10,10);
        DecisionN deciN1 = new DecisionN("deciN1",10,20);
        ActionN actN2Yes = new ActionN("actN2Yes",30,20);
        ActionN actN2No = new ActionN("actN2No",10,30);
        nodes.add(actN1);
        nodes.add(deciN1);
        nodes.add(actN2Yes);
        nodes.add(actN2No);        
        actN1.setNext(deciN1);
        deciN1.setNext(actN2No, false);
        deciN1.setNext(actN2Yes, true);
         
        for (NodeSup node : nodes){
            x = node.getDisplayX();
            y = node.getDisplayY();
            title = node.getTitle();
            System.out.println("The title is: "+ title + "\n The x coordinate is: " + x + "\n The  y coordinate is: " + y );
           
            node.setTitle("Sponge Bob");
            title = node.getTitle(); // The modification I’ve made.
            System.out.println(" The new title of this node is: "+ title+"\n");
        }        
    }    
}
