// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 4
 * Name: Ella Wipatene
 * Username: wipateella
 * ID: 300558005
 */

import ecs100.*;
import java.awt.Color; 

/** PatternsDrawer
Draws six different repetitive patterns. */

public class PatternsDrawer{

    public static final double PATTERN_LEFT = 50.0;   // Left side of the pattern
    public static final double PATTERN_TOP = 50.0;    // Top of the pattern
    public static final double PATTERN_SIZE = 300.0;  // The size of the pattern on the window

    /** 
     * Draws a star pattern consisting of a circle containing black rays (separated by white regions)
     * Asks the user for the number of rays.
     */
    public void drawStar(){
        UI.clearGraphics();
        double num = UI.askInt("How many rays:");
        /*# YOUR CODE HERE */
        double arcAngle = 360 / num; 
        UI.drawOval(PATTERN_LEFT, PATTERN_TOP, PATTERN_SIZE, PATTERN_SIZE); 
        for (int i = 0; i < num; i++){
            if ( i % 2 == 0){
                UI.setColor(Color.black); 
                UI.fillArc(PATTERN_LEFT, PATTERN_TOP, PATTERN_SIZE, PATTERN_SIZE, i * arcAngle, arcAngle); 
            } else{
                UI.setColor(Color.white); 
                UI.fillArc(PATTERN_LEFT, PATTERN_TOP, PATTERN_SIZE, PATTERN_SIZE, i * arcAngle, arcAngle); 
            
            }
        }
    }

    /** Draw a checkered board with alternating black and white squares
     *    Asks the user for the number of squares on each side
     *
     * CORE
     */
    public void drawDraughtsBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double squareSize = PATTERN_SIZE / num; 
        boolean whiteFirst = true; 
        
        for (int i = 0; i < num; i++){ // drawing every collumn 
            for (int n = 0; n < num; n++){ // drawing every row
                if (n % 2 == 0){ // alternating the starting colour
                    if (whiteFirst == true){
                        UI.setColor(Color.black);
                    } else{
                        UI.setColor(Color.white);
                    }
                }else{
                    if (whiteFirst == true){
                        UI.setColor(Color.white);
                    } else{
                        UI.setColor(Color.black);
                    }
                }
                UI.fillRect(PATTERN_LEFT + (n * squareSize), PATTERN_TOP + (i * squareSize), squareSize, squareSize); 
            }
            if (whiteFirst == true){ //chaging the boolean colour statement
                whiteFirst = false; 
            } else{
                whiteFirst = true; 
            }
        }
    }

    /** TriGrid
     * a triangular grid of squares that makes dark circles appear 
     * in the intersections when you look at it.
     *
     * COMPLETION
     */
    public void drawTriGrid(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double whiteSquare = PATTERN_SIZE / num;
        double blackSquare = whiteSquare * 0.8; 
        double border = whiteSquare - blackSquare; // white border size around the black boxes
        int counter = num; // to reduce the num of rows each time. 
        
        for (int i = 0; i < num; i++){ // drawing every collumn
            for (int n = 0; n < counter; n ++){ // drawing every row, decreases by one each time
                UI.setColor(Color.white); 
                UI.fillRect(PATTERN_LEFT + (n * whiteSquare), PATTERN_TOP + (i * whiteSquare), whiteSquare, whiteSquare); // white squares
                UI.setColor(Color.black); 
                UI.fillRect(PATTERN_LEFT + (n * whiteSquare) + border, PATTERN_TOP + (i * whiteSquare) + border, blackSquare, blackSquare); // black squares 
            }
            counter--; 
        }
    }
    
    public void drawConcentricBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double diameter = PATTERN_SIZE / num; 
        
        for (int i = 0; i < num; i++){ // drawing every collumn
            for (int n = 0; n < num; n++){ //drawing every row
                for (int d = 0; d < diameter/4; d++){ // drawing every concentric circle
                     UI.drawOval(PATTERN_LEFT + (n * diameter) + (d*2), PATTERN_TOP + (i * diameter) + (d*2), diameter - (d*4), diameter - (d*4)); 
                }
            }
        }
    }
    
    public void drawHexagonalBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double square = PATTERN_SIZE / num;
        
        for (int i = 0; i < num; i++){
            if (i % 2 == 0){
                for (int n = 0; n < num; n++){
                    UI.drawLine(n*square, square*0.333 + square*i, square/2 + n*square, square*i); // left diagonal top
                    UI.drawLine(square/2 + n*square, square*i, (n+1)*square, square*0.333 + square*i);  // right diagonal top
                    
                    UI.drawLine(n*square, square*0.333 + square*i, n*square, square*(i+1)); // left vertical line
                    UI.drawLine(n*square + square/2, square*i, n*square + square/2, square*(i+1) - square*0.333); // center vertical line
                    UI.drawLine((n+1)*square, square*0.333 + square*i, (n+1)*square, square*(i+1)); // right vertical line
                    
                    UI.drawLine(n*square, square*(i+1), square/2 + n*square, square*(i+1) - square*0.333); // left diagonal bottom
                    UI.drawLine(square/2 + n*square, square*(i+1)- square*0.333, (n+1)*square,  square*(i+1));  // right diagonal bottom
                }
            }else{
                 for (int n = 0; n < num; n++){
                    UI.drawLine(n*square, square*i, n*square, square*(i+1) - square*0.333); // left vertical line
                    UI.drawLine(n*square + square/2, square*0.333 + square*i, n*square + square/2, square*(i+1)); // center vertical line
                    UI.drawLine((n+1)*square, square*i, (n+1)*square, square*(i+1) - square*0.333); // right vertical line
                    
                    UI.drawLine(n*square, square*i, square/2 + n*square, square*0.333 + square*i);  // left diagonal top
                    UI.drawLine(square/2 + n*square, square*0.333 + square*i, (n+1)*square, square*i); // right diagonal top
                    
                    UI.drawLine(square/2 + n*square, square*(i+1),(n+1)*square, square*(i+1) - square*0.333); // right diagonal bottom
                    UI.drawLine(n*square, square*(i+1)- square*0.333, square/2 + n*square,  square*(i+1));  // left diagonal bottom
                    }
            }
        }
    }

    public void drawSpiralBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        double squareSize = PATTERN_SIZE / num;
        
        int columnLength = num; // the first column will have num squares
        int rowLength = num; // the first row will have num squares 
        double horzValue = (num - 1) * squareSize; 
        double vertValue = 0.0; 
        int xShift = 0; 
        int yShift = 0; 
        
        
        for (int i = 0; i < num; i++){ // drawing every column
            for (int n = 0; n < rowLength; n ++){ // drawing every row, decreases by one each time
                UI.drawRect(PATTERN_LEFT + (n * squareSize) + (xShift * squareSize), PATTERN_TOP + vertValue, squareSize, squareSize); // white squares
            } 
            for (int n = 0; n < columnLength; n ++){ // drawing every collumn, decreases by one each time
                UI.drawRect (PATTERN_LEFT + horzValue, PATTERN_TOP + (n*squareSize) + (yShift * squareSize), squareSize, squareSize); // white squares
            }
            yShift++; 
            
            rowLength = rowLength - 2; 
            columnLength = columnLength - 2; 

            if (i % 2 == 0){ // shifts over bottom and left squares
                vertValue =  ((num - 1) * squareSize) - (i * squareSize); 
                horzValue = (i * squareSize);
                yShift++;
                xShift++;
                if (i>1){
                    xShift++;
                }
            } else{ // shifts over top and right sqaures
                vertValue = ((i+1) * squareSize); 
                horzValue =  ((num - 1) * squareSize) - ((i+1) * squareSize); 
                yShift--;
            }
        }
    }

    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear",UI::clearPanes);
        UI.addButton("Core: star", this::drawStar);
        UI.addButton("Core: draughts", this::drawDraughtsBoard);
        UI.addButton("Completion: TriGrid", this::drawTriGrid);
        UI.addButton("Challenge: Concentric", this::drawConcentricBoard);
        UI.addButton("Challenge: Hexagon", this::drawHexagonalBoard);
        UI.addButton("Challenge Spiral", this::drawSpiralBoard);
        UI.addButton("Quit",UI::quit);
    }   

    public static void main(String[] arguments){
        PatternsDrawer pd = new PatternsDrawer();
        pd.setupGUI();
    }

}

