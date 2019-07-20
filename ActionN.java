/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u08009cwk;


/**
 * Class whose objects represent action nodes in flow charts
 * @author 17008776
 */
public class ActionN  extends NodeSup  {
    NodeSup nextNode;
    
    public ActionN(String title, double displayX, double displayY){
        super(title,displayX,displayY);
    }
    
    public void setNext(NodeSup nextNode) {
        this.nextNode = nextNode;
    }  
    @Override
    public NodeSup getNext(boolean choice){
        return nextNode;
    }
}
