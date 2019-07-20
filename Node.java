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
public interface Node {
    public NodeSup getNext(boolean choice);
    public String getTitle();
    public void setTitle(String title);
    public double getDisplayX();
    public double getDisplayY();
}

