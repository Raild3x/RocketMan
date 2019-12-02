package org.util;

import org.graphics.Graphics;
import org.util.Vector2;

public class Circle {
    private Vector2 position;
    private float radius;

    public Circle(float x, float y, float r){
        this.position = new Vector2(x,y);
        this.radius = r;
    }

    public boolean intersects(Circle other){
        float dist = (float) other.position.distance(this.position);
        return (dist < this.radius + other.radius);
    }

    public void move(){
        this.position = this.position.add(new Vector2(Math.random(),Math.random()));
    }

    public void draw(){
        Graphics.drawCircle(this.position.getX(), this.position.getY(), this.radius, 36);
    }
}