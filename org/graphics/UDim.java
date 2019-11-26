package org.graphics;

public class UDim {

    public float Scale;
    public int Offset;

    public UDim(float Scale, int Offset) {
        this.Scale = Scale;
        this.Offset = Offset; 
    }

    public UDim add(UDim a, UDim b){
        return new UDim(a.Scale+b.Scale, a.Offset+b.Offset); 
    }

    public UDim sub(UDim a, UDim b){
        return new UDim(a.Scale-b.Scale, a.Offset-b.Offset); 
    }
}