package org.world;

import org.graphics.Graphics;
import org.graphics.Vector2;

public class Planet extends PhysicsObject {

    public float radius;
    public float amplitude; // How harsh the landscape is
    public Vector2[] points = new Vector2[36];

    public Planet(Vector2 position, float radius, float amplitude, float rotation){
        this.position = position;
        this.radius = radius;
        this.amplitude = amplitude;
        this.rotation = rotation;

        for (int i = 0; i < points.length; i++){
            float height = (float) Math.random() * amplitude + radius;
            points[i] = getVectorFromAngle((360/points.length)*i).mult(height);
        }
    }

    public void update(){
        rotation += 1/radius;

    }

    public void render(){
        Graphics.setColor(0.2f,0.2f,0.2f,1);
        Graphics.setRotation(rotation);
        Graphics.drawPolygon(position, points);
    }

}