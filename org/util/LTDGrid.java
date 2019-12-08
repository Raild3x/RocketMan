package org.util;

// Loose Tight Double Grid
public class LTDGrid{

    public class LooseNode{
        //Points to the next loose cell node in the tight cell.
        int next;
        // Stores an index to the loose cell
        int cellIndex;
        public LooseNode(){
            
        }
    }

    public class LooseCell{
        // Stores the index to the first element using an indexed SLL.
        int head;

        // Stores the extents of the grid cell relative to the upper-left corner
        // of the grid which expands and shrinks with the elements inserted and removed.
        float l,r,t,b; //left right top bottom

        public LooseCell(){
            
        }
    }

    public class TightCell{
        // Stores the index to the first loose cell node in the tight cell using an indexed SLL
        int head;
        
        public TightCell(){
            
        }
    }

    private int size = 10;
    private TightCell[][] grid = new TightCell[size][size];

    public LTDGrid(){

    }
}