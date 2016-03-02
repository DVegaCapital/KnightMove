package com.knightMove;

import java.util.LinkedList;
import java.util.List;

/**
 * New next possible move
 *
 * @author Xiaodong Cao
 */

public class KnightSolution {

    Keypad keyPad;

    public KnightSolution(){
        this.keyPad = new Keypad();
        System.out.println(keyPad.keyPadNodeList);
        System.out.println(keyPad.KeyPadMoveMap);

    }

    public int nthSequenceFromNode(PadNode padNode, int n) {

        // nth move process
        List<PadNode> zeroVowelPadNodeList = new LinkedList<PadNode>();
        List<PadNode> oneVowelPadNodeList = new LinkedList<PadNode>();
        List<PadNode> twoVowelPadNodeList = new LinkedList<PadNode>();

/*        Map<int, List<PadNode>> nodeListMap = null;*/

        if (Keypad.isVowel(padNode)) {
            oneVowelPadNodeList.add(padNode);
        } else {
            zeroVowelPadNodeList.add(padNode);
        }

        System.out.println("");
        System.out.print("this is for node X axis : " + padNode.getX() + " Y axis : " + padNode.getY());

        for (int i = 1; i < n; i++) {

            List<PadNode> tmpZeroVowelPadNodeList = new LinkedList<PadNode>(zeroVowelPadNodeList);
            List<PadNode> tmpOneVowelPadNodeList = new LinkedList<PadNode>(oneVowelPadNodeList);
            List<PadNode> tmpTwoVowelPadNodeList = new LinkedList<PadNode>(twoVowelPadNodeList);

            //zero vowel node list
            zeroVowelPadNodeList.clear();
            oneVowelPadNodeList.clear();
            twoVowelPadNodeList.clear();

/*            travalNextPadNodeList(tmpZeroVowelPadNodeList);
            travalNextPadNodeList(tmpOneVowelPadNodeList);
            travalNextPadNodeList(tmpTwoVowelPadNodeList);*/

            if (tmpZeroVowelPadNodeList.size() > 0) {
                for (PadNode padNode1 : tmpZeroVowelPadNodeList) {
                    List<PadNode> nextMoveNodeList = keyPad.KeyPadMoveMap.get(padNode1);

                    // iterate every node list
                    if (nextMoveNodeList != null && nextMoveNodeList.size() > 0) {
                        for (PadNode nextPadNode1 : nextMoveNodeList) {
                            // test whether is vowel or not
                            if (Keypad.isVowel(nextPadNode1)) {
                                oneVowelPadNodeList.add(nextPadNode1);
                            } else {
                                zeroVowelPadNodeList.add(nextPadNode1);
                            }
                        }
                    }
                }
            }

            //on vowel node list
            if (tmpOneVowelPadNodeList.size() > 0) {
                for (PadNode padNode2 : tmpOneVowelPadNodeList) {
                    List<PadNode> nextMoveNodeList = keyPad.KeyPadMoveMap.get(padNode2);

                    // iterate every node list
                    if (nextMoveNodeList != null && nextMoveNodeList.size() > 0)
                        for (PadNode nextPadNode2 : nextMoveNodeList) {
                            if (Keypad.isVowel(nextPadNode2)) {
                                twoVowelPadNodeList.add(nextPadNode2);
                            } else {
                                oneVowelPadNodeList.add(nextPadNode2);
                            }
                        }
                }
            }

            //two vowel node list
            if (tmpTwoVowelPadNodeList.size() > 0) {
                for (PadNode padNode3 : tmpTwoVowelPadNodeList) {
                    List<PadNode> nextMoveNodeList = keyPad.KeyPadMoveMap.get(padNode3);

                    // iterate every node list
                    if (nextMoveNodeList != null && nextMoveNodeList.size() > 0) {
                        for (PadNode nextPadNode3 : nextMoveNodeList) {
                            if (Keypad.isVowel(nextPadNode3)) {
                                continue;
                            } else {
                                twoVowelPadNodeList.add(nextPadNode3);
                            }
                        }
                    }
                }
            }

            System.out.println(" This is the " + i + " time test");
            System.out.println("Zero vowel list length: " + zeroVowelPadNodeList.size() + " || one vowel list length: " + oneVowelPadNodeList.size() + " || two vowel list length: " + twoVowelPadNodeList.size());


        }

        return twoVowelPadNodeList.size();
    }


/*
    public void travalNextPadNodeList(List<PadNode> tmpNodeList){
        if(tmpNodeList.size() > 0) {
            for (PadNode padNode1 : tmpNodeList) {
                List<PadNode> nextMoveNodeList = keyPad.KeyPadMoveMap.get(padNode1);

                // iterate every node list
                for (PadNode nextPadNode1 : nextMoveNodeList) {
                    // test whether is vowel or not
                    if (Keypad.isVowel(nextPadNode1)) {
                        zeroVowelPadNodeList.add(nextPadNode1);
                    } else {
                        oneVowelPadNodeList.add(nextPadNode1);
                    }
                }
            }
        }
    }*/

    public int getNthSeqTotalNumber(int n) {
        int totalPathNum = 0;

        for (PadNode padNode : keyPad.keyPadNodeList) {
            totalPathNum += nthSequenceFromNode(padNode, n);
        }

        return totalPathNum;
    }

    public static void main(String[] argv) {

        KnightSolution knightMoveResult = new KnightSolution();

        System.out.println("10 steps result: " + knightMoveResult.getNthSeqTotalNumber(10));
        //System.out.println("16 step result: " + knightMoveResult.getNthSeqTotalNumber(16));
        //System.out.println("32 step result: " + knightMoveResult.getNthSeqTotalNumber(32));
    }
}