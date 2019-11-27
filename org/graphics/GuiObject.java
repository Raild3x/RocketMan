package org.graphics;

public class GuiObject {

    //public Color3 BackgroundColor; 
    //public Color3 BorderColor3;
    //public BorderMode BorderMode;
    //public SizeConstraint SizeConstraint;

    // BOOL VALUES
    public boolean Active;
    public boolean ClipsDescendants; 
    public boolean Selectable; 
    public boolean Visible;

    //VECTOR VALUES
    public Vector2 AnchorPoint;


    public int BorderSizePixel;
    public int LayOutOrder;
    public int ZIndex;

    public GuiObject NextSelectionDown; 
    public GuiObject NextSelectionLeft; 
    public GuiObject NextSelectionRight; 
    public GuiObject NextSelectionUp; 

    public UDim2 Position; 
    public UDim2 Size;

    public float Rotation;
    public float Transparency;
    public float BackGroundTransparency; 

    public GuiObject SelectionImageObject;
    
  

    //INHERITANCE: GuiBase2d, Instance


}