package org.graphics;

public class Frame extends GuiObject{
    public Frame(UDim2 pos){
        this.Position = pos; 
    }

    // SETTERS
    public void SetPosition(UDim2 pos){
        this.Position = pos; 
    }

    public void SetSize(UDim2 size){
        this.Size = size;
    }

    //GETTERS

    public UDim2 GetPosition(){
        return this.Position;
    }

    public UDim2 GetSize(){
        return this.Size; 
    }

}