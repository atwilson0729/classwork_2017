/**
 * SortingLab.java
 * @author Latulipe/Perez Quinones
 */

package dslab_Searching_Sorting;

public class SearchingSortingLab {

	public static void main(String args[])   {
            ConcertManager cm = new ConcertManager();
            
            // test finding tickets with linear search
            cm.findTicketByPrice_Linear(15);
            cm.findTicketByPrice_Linear(75);
            
            // test seeing if tickets exist with linear search
            cm.existsTicketWithPrice_Linear(40);
            cm.existsTicketWithPrice_Linear(13);
            
            // TODO (last): test getting all tickets that match target with linear search
            //cm.findAllTicketsByPrice_Linear(18);
            //cm.findAllTicketsByPrice_Linear(345);
            
	}
}
