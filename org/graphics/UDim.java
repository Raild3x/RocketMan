package org.graphics;

public class UDim {

    public float Scale;
    public int Offset;

    // UDim constructor
    public UDim(float Scale, int Offset) {
        this.Scale = Scale;
        this.Offset = Offset; 
    }

    // ADDITION
    public static UDim add(UDim a, UDim b){
        return new UDim(a.Scale+b.Scale, a.Offset+b.Offset); 
    }

    // SUBTRACTION
    public static UDim sub(UDim a, UDim b){
        return new UDim(a.Scale-b.Scale, a.Offset-b.Offset); 
    }

     // linear interpolation of single numbers
     private static float lerp(float x, float y, float alpha) {
        return x*(1-alpha) + y*alpha;
    }
    
    // Linear interpolation of UDims
    public UDim lerp(UDim other, float alpha) {
        float retX = lerp(this.Scale, other.Scale,  alpha);
        float retY = lerp(this.Offset, other.Offset, alpha);
        return new UDim(retX, (int) retY);
    }
}