package org.graphics;


public class UDim2 {

    public UDim x, y; 

    // Constructor using xScale, xOffset etc. 
    public UDim2(float xScale, int xOffset, float yScale, int yOffset){
       this.x = new UDim(xScale, xOffset); 
       this.y = new UDim(yScale, yOffset); 
    }

    // Constructor using UDim's
    public UDim2(UDim x, UDim y){
        this.x = x;
        this.y = y; 
    }

    // ADDITION
    public static UDim2 add(UDim2 a, UDim2 b){
        return new UDim2(UDim.add(a.x, b.x), UDim.add(a.y, b.y)); 
    }

    // SUBTRACTION
    public static UDim2 sub(UDim2 a, UDim2 b){
        return new UDim2(UDim.sub(a.x, b.x), UDim.sub(a.y, b.y)); 
    }
    
    // Linear interpolation of UDim2s
    public UDim2 lerp(UDim2 other, float alpha) {
        UDim retX = x.lerp(other.x,alpha);
        UDim retY = y.lerp(other.y,alpha);
        return new UDim2(retX, retY);
    }

    public String toString(){
        return "X: Scale: "+x.Scale+" Offset: "+y.Offset+" Y: Scale: "+y.Scale+" Offset: "+y.Offset;
    }
    
}