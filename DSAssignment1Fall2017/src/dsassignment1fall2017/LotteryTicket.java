/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment1fall2017;

/**
 *
 * @author clatulip
 */
public class LotteryTicket implements Comparable {
    private int value;
    private String name;

    /**
     * LotteryTicket constructor
     * @param value int: Monetary value of ticket
     * @param name String: ticket type
     */
    public LotteryTicket(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Getter for lotteryTicket value
     * @return value int
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter for lotteryTicket type
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * Prints out the lottery ticket
     * @return ticket as string.
     */
    @Override
    public String toString() {
        return name + " lottery ticket worth $" + value + "!";
    }

    /**
     * compareTo method required to implement Comparable interface
     * @param o the other LotteryTicket object that we are comparing
     * @return 0 if two are equal value, 1 if this is bigger than 
     * passed in ticket, -1 if passed in ticket has bigger value
     */
    @Override
    public int compareTo(Object o) {
        LotteryTicket other = (LotteryTicket)o;
        
        if (this.getValue() == other.getValue()) return 0;
        if (this.getValue() > other.getValue()) {
            return 1;
        } else {
            return -1;
        }
    }
    
    
    
}
