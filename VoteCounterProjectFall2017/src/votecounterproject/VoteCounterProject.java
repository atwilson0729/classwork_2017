/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votecounterproject;

/**
 *
 * @author clatulip
 */
public class VoteCounterProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //String filename = "votes1.txt";
        String filename = "votes2.txt";
        //String filename = "votes3.txt";
        //String filename = "votes4.txt";
        //String filename = "votes5.txt";
        ArrayListVoteCounter vc = new ArrayListVoteCounter(filename);
    }
    
}



