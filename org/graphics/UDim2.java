package org.graphics;


public class UDim2 {

    public UDim x, y; 

    public UDim2(float xScale, int xOffset, float yScale, int yOffset){
       this.x = new UDim(xScale, xOffset); 
       this.y = new UDim(yScale, yOffset); 
    }

    public UDim2(UDim x, UDim y){
        this.x = x;
        this.y = y; 
    }

    public UDim2 add(UDim2 a, UDim2 b){
        return new UDim2(UDim.add(a.x, b.x), UDim.add(a.y, b.y)); 
    }

    public UDim2 sub(UDim2 a, UDim2 b){
        return new UDim2(UDim.sub(a.x, b.x), UDim.sub(a.y, b.y)); 
    }

    
}