// This program is copyright VUW.
// You are granted permission to use it to construct your answer for your WGC 13DT assignment.
// You may not distribute it in any other way without permission.


import ecs100.*;
import java.awt.Color;

/** A Lamp object represents a table lamp on the graphics pane. A lamp consists of a colored bulb and a stem.
 *   It remembers its current position, its color and whether it is on or off.
 *   Its initial position and its color are set when it is constructed.
 *   The diameter of a bulb should be 80.
 *   The height of the stem should be 80.
 *   The width of the stem should be 20.
 *   It has three methods:
 *     draw(),        which draws the lamp at its current position.
 *     onBulb(x,y),   which reports whether the point(x,y) is on the bulb.
 *     onStem(x,y),   which reports whether the point(x,y) is on the stem.
 *     turnOff(),     which turns the light off.
 *     changeColor(), which turns the light on if it is off; changes its color to a random bright colour if it is already on. 
 */

public class Lamp{

    public static final double SIZE = 80.0;     // diameter of the bulb and height of the stem
    public static final double WIDTH = SIZE/4;  // width of the stem is SIZE/4
    public static final double HWIDTH = WIDTH/2; 
    public static final double LSTEM = SIZE/2;  // start coordanite x of light stem
    
    //fields
    private double lampX = 0;   // set preset value for lamp location of x      
    private double lampY = 0;   // set preset value for lamp location of y

    private Color Lcolour = Color.yellow; // create variable Lcolour and set to black
    private Color Scolour = new Color(88, 88, 88); // set the stem colour 
    
    /** Constructor: passed the initial position.
     * Initialises the fields
     */
    public Lamp(double x, double y){
        // setter method to set lampX and lampY to starting positions
        this.lampX = x;
        this.lampY = y;
    }

    /**
     * draws the lamp at its current position:
     * - the bulb of the right colour.
     * - the stem darkGray
     * The height of the stem is the same as the diameter of the bulb
     * The width of the stem is a quater of its height
     */
    public void draw(){
        // draw the lamp light circle
        UI.setColor(this.Lcolour);  // set outside and fill colour
        UI.fillOval(this.lampX, this.lampY, SIZE, SIZE);
        
        
        UI.setColor(this.Scolour); // reset colour for the stem
        // draw the lamp stem rectangle
        UI.fillRect(this.lampX+LSTEM-HWIDTH, this.lampY+SIZE, WIDTH, SIZE);

    }   

    /** 
     * Reports whether the point (x,y) is on the bulb.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onBulb(double x, double y){
        if (x>= this.lampX && x<= this.lampX+SIZE && 
        y>=this.lampY && y<= this.lampY+SIZE){
            return true;
        }
            
        else{
        return false;}   
    }  

    /**
     * Reports whether the point (x,y) is on the stem.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onStem(double x, double y){
        if (x>= this.lampX+LSTEM-HWIDTH && x<= this.lampX+LSTEM+HWIDTH && 
        y>=this.lampY+SIZE && y<= this.lampY+SIZE+SIZE){
            return true;
        }
            
        else{
        return false;}
    }   

    /**
     * Turns the light off.
     * Does not redraw
     */
    public void turnOff(){
        this.Lcolour = Color.black; // change colour to black when clicked
    }   

    /** changeColor method (no parameters):
     * Turns the light on (if it is off)
     * Changes its color to a random bright colour (if it is already on).
     * Does not redraw
     */
    public void changeColor(){
        this.Lcolour = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f); //generate random colour
    }   
}
