/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votecounterproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author clatulip
 */
public class ArrayVoteCounter {
    private String filename;
    private String[] votes;
    private String[] spoiledVotes;
    private Candidate[] candidates;
    private int voteIndex;
    private int spoiledVoteIndex;

    
    
    ArrayVoteCounter(String filename) {
        this.filename = filename;
        votes = new String[100];
        spoiledVotes = new String[100];
        candidates = new Candidate[4];
        voteIndex = 0;
        spoiledVoteIndex = 0;
        
        setupCandidates();
        
        scanfile(this.filename);
        
        countVotes();
        
        reportResults();
        
    }
    
    private void setupCandidates() {
        candidates[0] = new Candidate("Hilary", "Clinton", "Democrats");
        candidates[1] = new Candidate("Donald", "Trump", "Republicans");
        candidates[2] = new Candidate("Gary", "Johnson", "Libertarians");
        candidates[3] = new Candidate("Jill", "Stein", "Greens");
    }

    private void scanfile(String filename) {
        URL url = getClass().getResource(filename);
        File file = new File(url.getPath());
        
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String s = sc.next();
                recordVote(s);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (NoSuchElementException e) {
            System.out.println("No such element exception");
        } 
    }

    private void recordVote(String s) {
        if (voteIndex == votes.length) {
            votes = expandCapacity(votes);
        }
        votes[voteIndex] = s;
        voteIndex++;
    }

    private void countVotes() {
        for (String s : votes) {
            if (s != null) {
                switch (s) {
                    case "Clinton" : 
                        candidates[0].addVote();
                        break;
                    case "Trump" :
                        candidates[1].addVote();
                        break;
                    case "Johnson" :
                        candidates[2].addVote();
                        break;
                    case "Stein" :
                        candidates[3].addVote();
                        break;
                    default:
                        if (spoiledVoteIndex == spoiledVotes.length) {
                            spoiledVotes = expandCapacity(spoiledVotes);
                        }
                        spoiledVotes[spoiledVoteIndex] = s;
                        spoiledVoteIndex++;
                        
                }
            }
        }
    }

    private void reportResults() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(1);
        int validVotes = voteIndex - spoiledVoteIndex;
        System.out.println(validVotes + " valid votes were cast.");
        for (int i =0; i < 4; i++) {
            System.out.println(candidates[i].getFirstName() + " " + candidates[i].getLastName() + " of the " + candidates[i].getParty() + ": " + candidates[i].getNumVotes() + " votes, " + df.format(candidates[i].getNumVotes()/(float)validVotes*100) + "%.");
        }
        System.out.println("There were " + spoiledVoteIndex + " spoiled votes.");
    }


    
    private String[] expandCapacity(String[] myArray) {

        String[] newArray = Arrays.copyOf(myArray, myArray.length*2);
        return newArray;
        
    }
    
}
