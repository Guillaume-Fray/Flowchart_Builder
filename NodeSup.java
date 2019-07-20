/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u08009cwk;

/**
 * Class whose objects represent nodes in a flow chart
 * @author 17008776
 */
public class NodeSup{
    private String title;
    private double displayX;
    private double displayY;
    
    public NodeSup(String title, double displayX, double displayY){
        this.title = title;
        this.displayX = displayX;
        this.displayY = displayY;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public double getDisplayX() {
        return displayX;
    }

    public double getDisplayY() {
        return displayY;
    }

    /**
     * Return a node that follows this one in the flow chart. If this node is an
     * ActionNode the method returns its 'next node', and the choice parameter is
     * ignored. If this node is a DecisionNode, then the method returns either
     * the next node on the "Yes" branch of the decision (if choice is true) or
     * on the "No" branch (if choice is false).
     *
     * @param choice If this node is a DecisionNode then the choice parameter
     * specifies whether the "Yes" branch or the "No" branch is to be returned.
     * It is ignored if the current node is an ActionNode.
     * @return the next node along the specified branch.
     */
    public NodeSup getNext(boolean choice) {
       return null;
    }

}