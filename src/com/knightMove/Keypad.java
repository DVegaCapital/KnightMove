package com.knightMove;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * keypad class to store every node information
 *
 * @author Xiaodong Cao.
 */
public class Keypad {

    public Map<PadNode,List<PadNode>> KeyPadMoveMap = new HashMap<PadNode, List<PadNode>>();
    public List<PadNode> keyPadNodeList = new LinkedList<PadNode>();

    public Keypad() {
        createKeyPad();
    }

    private void createKeyPad() {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(validLocation(i,j)){
                    this.KeyPadMoveMap.put(new PadNode(i,j), findNextPossibleMove(i,j));
                    this.keyPadNodeList.add(new PadNode(i,j));
                }
            }

        }
    }

    static boolean isVowel(PadNode padNode) {
        if (((padNode.getX() == 0) && (padNode.getY() == 0))
                || ((padNode.getX() == 4) && (padNode.getY() == 0))
                || ((padNode.getX() == 3) && (padNode.getY() == 1))
                || ((padNode.getX() == 4) && (padNode.getY() == 2))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validLocation(int x, int y) {
        // Check if x value is out of range.
        if ((x < 0) || (x > 4))
            return false;

        // Check if y value is out of range.
        if ((y < 0) || (y > 3))
            return false;

        // Check if node in bottom left corner
        if ((x == 0) && (y == 3))
            return false;

        // Check if node in bottom right corner
        if ((x == 4) && (y == 3))
            return false;

        return true;
    }

    private List findNextPossibleMove(int x, int y) {

        //initialize the next possible move

        List<PadNode> nextPossibleMoveNodeList = new LinkedList<PadNode>();

        if (validLocation(x + 2, y + 1)) { // 1
            nextPossibleMoveNodeList.add(new PadNode(x + 2, y + 1));
        }

        if (validLocation(x + 2, y - 1)) { // 2
            nextPossibleMoveNodeList.add(new PadNode(x + 2, y - 1));
        }

        if (validLocation(x - 2, y + 1)) { // 3
            nextPossibleMoveNodeList.add(new PadNode(x - 2, y + 1));
        }

        if (validLocation(x - 2, y - 1)) {  // 4
            nextPossibleMoveNodeList.add(new PadNode(x + 2, y + 1));
        }

        if (validLocation(x + 1, y + 2)) {  // 5
            nextPossibleMoveNodeList.add(new PadNode(x + 1, y + 2));
        }

        if (validLocation(x + 1, y - 2)) {  // 6
            nextPossibleMoveNodeList.add(new PadNode(x + 1, y - 2));
        }

        if (validLocation(x - 1, y + 2)) {  // 7
            nextPossibleMoveNodeList.add(new PadNode(x - 1, y + 2));
        }

        if (validLocation(x - 1, y - 2)) {  // 8
            nextPossibleMoveNodeList.add(new PadNode(x - 1, y - 2));
        }

        return nextPossibleMoveNodeList;
    }
}
