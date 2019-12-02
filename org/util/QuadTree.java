package org.util;

import org.graphics.Graphics;
import org.graphics.Renderer;
import org.util.Vector2;

import java.util.ArrayList;

public class QuadTree {

    /*public class Point {
        public float x,y;
        public Point(float x, float y){
            this.x = x;
            this.y = y;
        }
    }*/
    
    

    private QuadTree northwest, northeast, southwest, southeast;
    private Rectangle boundary;
    private int capacity;
    private int pointCount;
    private Vector2[] points;
    private boolean divided = false;

    public QuadTree(Rectangle boundary, int capacity){
        this.boundary = boundary;
        this.capacity = capacity;
        this.points = new Vector2[this.capacity];
        this.pointCount = 0;
    }

    public QuadTree(float x, float y, float w, float h, int capacity){
        this.boundary = new Rectangle(x,y,w,h);
        this.capacity = capacity;
        this.points = new Vector2[this.capacity];
        this.pointCount = 0;
    }

    public String toString(){
        String s = "QuadTree: "+super.toString()+"\n\tBoundary: "+this.boundary.toString()
        +"\n\tCapacity: "+this.capacity+"\n\tDivided: "+this.divided+"\n\tPoints:\n";
        for (int i = 0; i < this.pointCount; i++){
            s+="\t\tX: "+this.points[i].getX()+"\tY: "+this.points[i].getY()+"\n";
        }
        return s;
    }

    private void subdivide(){
        float x = this.boundary.x;
        float y = this.boundary.y;
        float h = this.boundary.h/2;
        float w = this.boundary.w/2;

        Rectangle nw = new Rectangle(x+w, y-h, w, h);
        this.northwest = new QuadTree(nw, this.capacity);
        Rectangle ne = new Rectangle(x-w, y-h, w, h);
        this.northeast = new QuadTree(ne, this.capacity);
        Rectangle sw = new Rectangle(x-w, y+h, w, h);
        this.southwest = new QuadTree(sw, this.capacity);
        Rectangle se = new Rectangle(x+w, y+h, w, h);
        this.southeast = new QuadTree(se, this.capacity);
        this.divided = true;

        for (int i = 0; i < this.pointCount; i++){
            this.insert(points[i]);
        }
        this.points = null;
    }

    public void insert(Vector2 p) {
        if (!this.boundary.contains(p))
            return;
        
        if (this.pointCount < this.capacity){
            this.points[pointCount] = p;
            pointCount++;
        } else {
            if (!this.divided){
               this.subdivide(); 
            }
            this.northwest.insert(p);
            this.northeast.insert(p);
            this.southwest.insert(p);
            this.southeast.insert(p);
        }
    }

    public ArrayList<Vector2> queryBox(Rectangle other){
        ArrayList<Vector2> found = new ArrayList<Vector2>();
        this.queryBox(other, found);
        return found;
    }


    public void queryBox(Rectangle other, ArrayList<Vector2> found){
        if (!this.boundary.intersects(other)){
            //empty array
            return;
        } else if (!this.divided) {
            for (int i = 0; i < this.pointCount; i++){
                Vector2 p = this.points[i];
                if (other.contains(p))
                    found.add(p);
            }
        } else {
            this.northwest.queryBox(other, found);
            this.northeast.queryBox(other, found);
            this.southwest.queryBox(other, found);
            this.southeast.queryBox(other, found);
        }
    }

    public void render(){
        Rectangle b = this.boundary;
        Graphics.setColor(0.5f, 0.5f, 0.5f, 0);
        Graphics.setBorderColor(1, 1, 1, 1);
        Graphics.fillRectWithBorders(b.x, b.y, b.w*2, b.h*2);
        
        if (this.divided){
            this.northwest.render();
            this.northeast.render();
            this.southwest.render();
            this.southeast.render();
        }

        Graphics.setColor(1,0,0,1);
        Graphics.setPointSize(2);
        if (this.points != null){
            for (int i = 0; i < this.pointCount; i++){
                Vector2 p = this.points[i];
                Graphics.drawPoint(p.getX(), p.getY());
            }
        }
    }
}
