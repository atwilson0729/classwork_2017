/*
 * Created on Feb 8, 2005
 * author: manuel a. perez-quinones
 * Modified January 2017 
 * author: celine latulipe
 * 
 * Lottery Simulation class
 * 
 */

package dsassignment1fall2017;


/**
 * Lottery Simulation class. This class simulates a lottery system
 * By adding a bunch of LotteryTicket objects to a LotteryBag and then
 * simulating pulling out random tickets.
 */
/**
 * @author clatulip
 * @date September 2017
 */


public class LotterySimulation {

    private LotteryBag<LotteryTicket> theBag;


    /**
     * Constructor for the LotterySimulation class. 
     */
    public LotterySimulation()  {
        
        theBag = new LotteryBag<LotteryTicket>();
        
        initializeLottery();
        runLottery();
        
    }

    /**
     * Sets up the initial bag with a bunch of randomly
     * generated LotteryTicket objects
     */
    private void initializeLottery() {
        for (int i = 0; i < 20; i++) {
            int value = (int)(Math.random()*1000000);
            int typeIndex = (int)(Math.random()*5);
            String s = null;
            switch (typeIndex) {
                case 0: 
                    s = "Daily";
                    break;
                case 1:
                    s = "Scratch-Off";
                    break;
                case 2:
                    s = "Lotto";
                    break;
                case 3:
                    s = "Lucke-Zone";
                    break;
                case 4:
                    s = "Powerball";
                    break;
            }
            theBag.add(new LotteryTicket(value,s));
        }
        System.out.println(theBag.toString());
    }

    /**
     * Runs the lottery simulation, printing the results 
     * out to the console
     */
    private void runLottery() {
        System.out.println("Let's check tonight's winning lottery numbers!");
        for (int i = 0; i < 3; i++) {
            System.out.println("Let's pull a ticket out of the lottery bag. What do we have?");
            LotteryTicket lt = theBag.remove();
            System.out.println("It's a " + lt.toString() + "\n");
        }
        System.out.println("And now it's time for our famous Pick3!");
        LotteryTicket p3 = theBag.pick3();
        if (p3!= null) {
            System.out.println("It's a " + p3.getName() + " ticket. And it's worth $" + p3.getValue() + "!\n");
            System.out.println("\n");
        } 
        
    }



    /**
     * Main program, just starts the simulation.
     */

    public static void main (String[] args)  {
            LotterySimulation fc = new LotterySimulation();
    }


}
