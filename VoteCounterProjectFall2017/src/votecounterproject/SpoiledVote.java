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
public class SpoiledVote {
    private String spoilText;
    private int count;

    public SpoiledVote(String spoilText) {
        this.spoilText = spoilText;
        this.count = 1;
    }

    public String getSpoilText() {
        return spoilText;
    }

    public int getCount() {
        return count;
    }
    
    public void increment() {
        this.count++;
    }

    public String toString() {
        //return "SpoiledVote{" + "spoilText=" + spoilText + ", count=" + count + '}';
        return (spoilText);
    }
}
