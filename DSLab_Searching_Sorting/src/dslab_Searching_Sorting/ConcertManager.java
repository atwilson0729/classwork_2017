/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab_Searching_Sorting;

import java.util.Arrays;
import DataStructures.Searching;

/**
 *
 * @author clatulip
 */
public class ConcertManager {

    private ConcertTicket[] concertTickets;
    private int numConcerts;
    
    public ConcertManager()  {
        readConcerts();
    }

    // private helper method to increase array capacity if needed
    private void expandCapacity() {
        Arrays.copyOf(concertTickets, concertTickets.length*2);
    }

    // private helper method to initialize data
    private void readConcerts()  {
        String[] concerts = new String[10];
        concerts[0] = "Jason Aldean,18";
        concerts[1] = "Panic at the Disco,40";
        concerts[2] = "Phish,20";
        concerts[3] = "Carrie Underwood,35";
        concerts[4] = "Bonnie Raitt,18";
        concerts[5] = "Needtobreathe,50";
        concerts[6] = "Dolly Parton,80";
        concerts[7] = "Trans-Siberian Orchestra,75";
        concerts[8] = "Twenty One Pilots,45";
        

        String str;
        concertTickets = new ConcertTicket[9];
        numConcerts = 0;
        for (int i = 0; i < 9; i++) {
            String[] tokens = concerts[i].split(",");
            if (tokens.length != 2) {
                System.out.println("more or less than two tokens. Tokens.length is:" + tokens.length);
                return;
            }
            ConcertTicket c = new ConcertTicket();
            c.setName(tokens[0]);
            
            c.setPrice(Integer.parseInt(tokens[1]));
            if (numConcerts == concerts.length) {
                expandCapacity();
            }
            concertTickets[numConcerts] = c;
            numConcerts++;
        }
        

    }

    // private helper method that Sorts concert array
    private void sortConcerts() {
        // call the built-in Arrays sort function
        Arrays.sort(concertTickets);
    }

    /**
     * Prints out info about the first ticket found that matches price specified
     * @param price int
     */
    public void findTicketByPrice_Linear(int price) {
        ConcertTicket target = new ConcertTicket();
        target.setPrice(price);
        
        ConcertTicket resultTicket = Searching.linearSearch2(concertTickets, target);
        if (resultTicket != null) {
            System.out.println("Linear Search. Found concert with $" + price + " tickets:");
            System.out.println("\t" + resultTicket.toString());
        } else {
            System.out.println("Linear Search. Didn't find concert with $" + price + " tickets");
        }    
    }
    
    /**
     * Prints out information about all tickets found matching specified price
     * @param price int
     */
    public void findAllTicketsByPrice_Linear(int price) {
        
        ConcertTicket target = new ConcertTicket();
        target.setPrice(price);
        int[] results = null;
        
        // TODO: after the linearSearch3 is implemented, uncomment line below
        //results = Searching.linearSearch3(concertTickets, target);
        if (results == null) {
            System.out.println("Linear Search. Didn't find any concerts with $" + price + " tickets");
            return;
        }
        if (results.length != 0) {
            System.out.println("Linear Search. Found the following concerts with $" + price + " tickets:");
            for (int i = 0; i < results.length; i++) {
                System.out.println("\t" + concertTickets[results[i]].toString());
            }
        } else {
            System.out.println("Linear Search. Didn't find concert with $" + price + " tickets");
        }    
    }

    /**
     * Prints out whether or not a ticket with
     * specified price exists.
     * @param price int
     */
    public void existsTicketWithPrice_Linear(int price) {
        ConcertTicket target = new ConcertTicket();
        target.setPrice(price);
        
        if (Searching.linearSearch(concertTickets, target)) {
            System.out.println("Linear Search. Concert with $" + price + " tickets exists.");
        } else {
            System.out.println("Linear Search. Didn't find concert with $" + price + " tickets");
        }
    }
}
