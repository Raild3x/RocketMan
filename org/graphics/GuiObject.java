package org.graphics;

import  org.util.UDim2;
import  org.util.Vector2;

abstract class GuiObject {

    //public Color3 BackgroundColor; 
    //public Color3 BorderColor3;
    //public BorderMode BorderMode;
    //public SizeConstraint SizeConstraint;

    // BOOL VALUES
    private boolean Active;
    private boolean ClipsDescendants; 
    private boolean Selectable; 
    private boolean Visible;

    // VECTOR VALUES
    private Vector2 AnchorPoint;

    // INT VALUES
    private int BorderSizePixel;
    private int LayOutOrder;
    private int ZIndex;

    // GUI OBJECT VALUES
    private GuiObject NextSelectionDown; 
    private GuiObject NextSelectionLeft; 
    private GuiObject NextSelectionRight; 
    private GuiObject NextSelectionUp; 
    private GuiObject SelectionImageObject; 

    // UDIM2 VALUES
    private UDim2 Position;
    private UDim2 Size;

    // FLOAT VALUES
    private float Rotation;
    private float Transparency;
    private float BackGroundTransparency; 

    public UDim2 getPosition() {
        return this.Position;
    }

    public void setPosition(UDim2 Position) {
        this.Position = Position;
    }

    public UDim2 getSize() {
        return this.Size;
    }

    public void setSize(UDim2 Size) {
        this.Size = Size;
    }



    public void TweenPosition(UDim2 endPosition, int easingDirection, int easingStyle, float time, boolean override){

    }

    public void TweenSize(UDim2 endSize, int easingDirection, int easingStyle, float time, boolean override){

    }

    public void TweenSizeAndPosition( UDim2 endSize , UDim2 endPosition , int easingDirection , int easingStyle , float time , boolean override){

    }

    public GuiObject(){
        this.Position = new UDim2();
        //etc...
    }
    
  

    //INHERITANCE: GuiBase2d, Instance


}