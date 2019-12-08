package org.custom;

import org.graphics.Graphics;
import org.util.Vector2;
import org.world.PhysicsObject;

public class Planet extends PhysicsObject {

    private final double G = 6.67408 * Math.exp(-11);

    public float radius;
    public float amplitude; // How harsh the landscape is
    public Vector2[] points = new Vector2[36];

    public Planet(Vector2 position, float radius, float amplitude, float rotation){
        super(position,rotation);
        this.radius = radius;
        this.amplitude = amplitude;

        for (int i = 0; i < points.length; i++){
            float height = (float) Math.random() * amplitude + radius;
            points[i] = getVectorFromAngle((360/points.length)*i).mult(height);
        }

        System.out.println("NewPlanet");
    }

    public float getMass(){
        return (float) (4 * Math.PI * Math.pow(radius,2));
    }

    //calculates strength and direction of gravity pull based off of a given position
    public Vector2 getGravity(PhysicsObject obj){
        float dist = (float) this.getPosition().distance(obj.getPosition());
        float strength = (float) ((G * getMass() * obj.getMass()) / (dist * dist));
        Vector2 direction = Vector2.sub(this.getPosition(),obj.getPosition());
        return direction.normalize().mult(strength);
    }

    public void update(){
        this.setRotation(this.getRotation() + 1/radius);
        //System.out.println("Gravity: "+getGravity(Camera.focus));
    }

    public void render(){
        Graphics.setColor(0.2f,0.2f,0.2f,1);
        Graphics.setRotation(this.getRotation());
        Graphics.drawPolygon(this.getPosition(), points);
    }

}