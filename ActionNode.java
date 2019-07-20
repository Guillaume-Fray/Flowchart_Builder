/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u08009cwk;

/**
 *
 * @author guillaumefray
 */
public interface ActionNode {
    public void setNext(NodeSup nextNode);
    public NodeSup getNext(boolean choice);
}
