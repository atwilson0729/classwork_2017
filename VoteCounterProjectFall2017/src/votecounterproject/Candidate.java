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
public class Candidate {
    private String firstName;
    private String lastName;
    private String party;
    private int numVotes;

    public Candidate(String firstName, String lastName, String party) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
        numVotes = 0;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public void addVote() {
        this.numVotes++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getParty() {
        return party;
    }
    
    
}
