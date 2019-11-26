package org.graphics;


public class UDim2 {

    public UDim x, y; 

    public UDim2(float xScale, int xOffset, float yScale, int yOffset){
       this.x = new UDim(xScale, xOffset); 
    }
}