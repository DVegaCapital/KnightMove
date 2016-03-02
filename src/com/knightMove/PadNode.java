package com.knightMove;

/**
 * Data structure to store two number node
 *
 * @author Xiaodong Cao.
 */

public class PadNode {

    private final int x;
    private final int y;

    public PadNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PadNode)) return false;
        PadNode key = (PadNode) o;
        return x == key.x && y == key.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
