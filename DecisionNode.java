/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u08009cwk;

/**
 *
 * @author 17008776
 */
public interface DecisionNode {
    public void setNext(NodeSup nextNode, boolean choice);
    public NodeSup getNext(boolean choice);
}
