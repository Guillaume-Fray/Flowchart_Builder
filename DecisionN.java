/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u08009cwk;

/**
 * Class whose objects represent decision nodes in flow
 * charts
 * @author 17008776
 */
public class DecisionN extends NodeSup {
    NodeSup nextNodeYes;
    NodeSup nextNodeNo;

    
    public DecisionN(String title, double displayX, double displayY){
        super(title,displayX,displayY);
    }
    
    /**
     * Set one of the nodes that follows this one in the flow chart. That is to
     * say the node to which we advance when this node when an answer to the
     * decision is recorded
     *
     * @param nextNode node to which we advance
     * @param choice true if we are setting the node that we advance to, when
     * "Yes" is the answer to the decision, and false if it is the node we
     * advance to, when the answer is "No".
     */
    
    public void setNext(NodeSup nextNode, boolean choice) {
        if (choice){
            this.nextNodeYes = nextNode;
        }
        else {
            this.nextNodeNo = nextNode;
        }
        
    }
    @Override
    public NodeSup getNext(boolean choice) {
       if (choice){
            return nextNodeYes;
       }
       else{
           return nextNodeNo;
       }
    }
}
