/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u08009cwk;

import java.util.Scanner;

/**
 *
 * @author p0073862
 */
public class ConsoleUI {

    private static FlowChart flowChart = new FlowChart();
    private static boolean running = false;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String option = "M";
        while (!option.startsWith("Q")) {

            if (option.startsWith("M")) {
                showMenu();
            } //Options available in set up mode
            if (!running) {
                if (option.startsWith("R")) {
                    flowChart.start();
                    running = true;
                } else if (option.startsWith("L")) {
                    listNodes();
                } else if (option.startsWith("A")) {
                    addNode(true);
                } else if (option.startsWith("D")) {
                    addNode(false);
                } else if (option.startsWith("C") && flowChart.getNbrNodes() >= 2) {
                    addConnection();
                } else if (option.startsWith("S")) {
                    NodeSup node = getNode("Enter index of start node");
                    flowChart.setStartNode(node);
                }
            } else { //Otions available in run mode
                NodeSup currentNode = flowChart.getCurrentNode();
                if (option.startsWith("C")
                        && currentNode instanceof ActionN) {
                    flowChart.advance(true);
                } else if (option.startsWith("Y")
                        && currentNode instanceof DecisionN) {
                    flowChart.advance(true);
                } else if (option.startsWith("N")
                        && currentNode instanceof DecisionN) {
                    flowChart.advance(false);
                } else if (option.startsWith("S")) {
                    running = false;
                }
            }

            if (running) {
                NodeSup currentNode = flowChart.getCurrentNode();
                if (currentNode != null) {
                    System.out.println("Current Node is " + currentNode.getTitle());
                }
            }
            System.out.print("Enter first character of your choice (type M to see menu)> ");
            option = scanner.nextLine();
        }
    }

    private static void showMenu() {
        if (!running) {
            showSetupMenu();
        } else {
            showRunMenu();
        }
        System.out.println("Q - Quit Program");
    }

    private static void showSetupMenu() {
        System.out.println("Options are");
        System.out.println("L - List Nodes");
        System.out.println("A - Add Action");
        System.out.println("D - Add Decision");
        if (flowChart.getNbrNodes() >= 2) {
            System.out.println("C - Connect two nodes");
            System.out.println("S - Set Start Node");
        }
        System.out.println("R - Run");
    }

    private static void showRunMenu() {
        NodeSup currentNode = flowChart.getCurrentNode();
        System.out.println("Options are");
        System.out.println("S - Stop");
        if (currentNode instanceof ActionN) {
            System.out.println("C- Confirm Action");
        } else if (currentNode instanceof DecisionN) {
            System.out.println("Y - Answer Yes to Decision");
            System.out.println("N - Answer No to Decision");
        }
    }

    private static void addNode(boolean isAction) {
        System.out.print("Title of " + (isAction ? "Action>" : "Decision>"));
        String title = scanner.nextLine();
        System.out.print("X display coordinate (must be in range 0-1)>");
        double displayX = scanner.nextDouble();
        System.out.print("Y display coordinate (must be in range 0-1)>");
        double displayY = scanner.nextDouble();
        //consume line break
        scanner.nextLine();
        NodeSup addedNode;
        if (isAction) {
            addedNode = flowChart.addAction(title, displayX, displayY);
        } else {
            addedNode = flowChart.addDecision(title, displayX, displayY);
        }
        if (flowChart.getNbrNodes() == 1) {
            flowChart.setStartNode(addedNode);
        }
    }

    private static void listNodes() {
        int nbrNodes = flowChart.getNbrNodes();
        for (int i = 0; i < nbrNodes; i++) {
            NodeSup node = flowChart.getNode(i);
            System.out.println(Integer.toString(i) + ":" + node.getTitle());
        }
    }

    private static void addConnection() {
        NodeSup startNode = getNode("Enter index of start node ");
        NodeSup targetNode = getNode("Enter index of target node ");

        //NOTE TO STUDENTS - IT IS GENERALLY BEST TO AVOID USING THE
        //instanceof OPERATOR, UNLESS YOU REALLY HAVE TO!
        if (startNode instanceof DecisionN) {
            System.out.print("Type Y to add a connection when decision is Yes, or N for No>");
            String contype = scanner.nextLine();
            ((DecisionN) startNode).setNext(targetNode, contype.startsWith("Y"));
        } else if (startNode instanceof ActionN) {
            ((ActionN) startNode).setNext(targetNode);
        }

    }
    
    private static NodeSup getNode(String prompt) {
        int nbrNodes = flowChart.getNbrNodes();
        int nodeIdx;
        do {
            System.out.print(prompt + " (range is 0-" + (nbrNodes - 1) + ")");
            nodeIdx = scanner.nextInt();
        } while (nodeIdx < 0 || nodeIdx >= nbrNodes);
        //consume next line character
        scanner.nextLine();
        return flowChart.getNode(nodeIdx);
    }
}
