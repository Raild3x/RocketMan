package org.util;

import org.graphics.Graphics;
import org.graphics.Vector2;

public class Rectangle {
    public final float x,y,w,h;
    public Rectangle(float x, float y, float w, float h){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }

    public boolean contains(Vector2 p){
        return (p.getX() >= this.x-this.w) && 
        (p.getX() <= this.x+this.w) && 
        (p.getY() >= this.y-this.h) && 
        (p.getY() <= this.y+this.h);
    }

    public boolean intersects(Rectangle other){
        return !(
        other.x - other.w > this.x + this.w || 
        other.x + other.w < this.x - this.w || 
        other.y - other.h > this.y + this.h ||
        other.y + other.h < this.y - this.h);
    }

    public void draw(){
        Graphics.fillRectWithBorders(this.x, this.y, this.w*2, this.h*2);
    }
}