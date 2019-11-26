package org.graphics;

public class UDim {

    public float Scale;
    public int Offset;

    public UDim(float Scale, int Offset) {
        this.Scale = Scale;
        this.Offset = Offset; 
    }

    public static UDim add(UDim a, UDim b){
        return new UDim(a.Scale+b.Scale, a.Offset+b.Offset); 
    }

    public static UDim sub(UDim a, UDim b){
        return new UDim(a.Scale-b.Scale, a.Offset-b.Offset); 
    }
}