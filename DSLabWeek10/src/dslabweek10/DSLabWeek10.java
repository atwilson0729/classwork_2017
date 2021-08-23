/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslabweek10;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author clatulip
 */
public class DSLabWeek10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // create the tree using the concert listing csv file
        ConcertTree concertTree = new ConcertTree("concert.csv");
        
        // what does the tree look like, printed out
        // using a level-order traversal?
        System.out.println(concertTree.toString());
        
        
        // what happens if we remove the root?
        /**
        ConcertTicket t = concertTree.removeConcert(18.5);
        if (t == null) {
            System.out.println("Uh-oh! No concert ticket removed");
        } else {
            System.out.println("found t:" + t);
        }
        System.out.println(concertTree.toString());
        **/

        // what happens if we now add the Jason Aldean concert back in?
        // where does it go in the tree?
        //concertTree.addConcert(t);
        //System.out.println(concertTree.toString());
        
        // Part 2.2: how balanced can you get the tree?
        
        

    }
    
}
