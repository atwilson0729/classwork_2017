/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab_Searching_Sorting;

/**
 *
 * @author clatulip
 */
public class ConcertTicket implements Comparable<ConcertTicket> {
    private String name;
    private int price;

    public ConcertTicket(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public ConcertTicket() {
        name = "";
        price = 0;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ConcertTicket{" + "name=" + name + ", price=" + price + '}';
    }

    @Override
    public int compareTo(ConcertTicket o) {
        if (this.getPrice() > o.getPrice())
        {
            return 1;
        }
        else if (this.getPrice() < o.getPrice()){
            return -1;
        }
        return 0;
    }
    

}
