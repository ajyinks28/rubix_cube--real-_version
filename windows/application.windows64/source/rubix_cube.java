import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class rubix_cube extends PApplet {


PeasyCam cam;

final int UPP = 0;
final int DWN = 1;
final int RTH = 2;
final int LFT = 3;
final int FRT = 4;
final int BCK = 5;

int[] colors = {
  0xffFFFFFF, 0xffFFFF00,
  0xffFF0000, 0xffFFA500,
  0xff00FF00, 0xff0000FF
};

int dim = 3;
cubies[][][] cube = new cubies[dim][dim][dim];
public void setup(){
  
  cam = new PeasyCam(this, 400);
  for(int i = 0; i < dim; i++){
    for(int j = 0; j < dim; j++){
      for(int k = 0; k < dim; k++){
        float len = 50;
        float offset = (dim - 1)* len  * 0.5f;
        float x =len * i - offset ;
        float y =len * j - offset;
        float z =len * k - offset;
        
        cube[i][j][k] = new cubies(x, y, z, len);
      }
    }
  }
}
  
  
public void draw(){
  background(51);
   for(int i = 0; i < dim; i++){
    for(int j = 0; j < dim; j++){
      for(int k = 0; k < dim; k++){
        cube[i][j][k].show();
      }
    }
  }
}
  
class cubies{
  PVector pos;
  float len;
  cubies(float x, float y, float z, float len_){
    pos = new PVector(x,y,z);
    len = len_;
  }
  
  public void show(){
    fill(255);
    stroke(0);
    strokeWeight(8);
    pushMatrix();
    translate(pos.x, pos.y, pos.z);
    beginShape(QUADS);
    float r = len/ 2 ;
    
    //for z
    fill(colors[UPP]);
    vertex(-r, -r, -r);
    vertex(r, -r, -r);
    vertex(r, r, -r);
    vertex(-r, r, -r);
    
    fill(colors[DWN]);
    vertex(-r, -r, r);
    vertex(r, -r, r);
    vertex(r, r, r);
    vertex(-r, r,r);
    
       //for y
    fill(colors[FRT]);
    vertex(-r, -r, -r);
    vertex(r, -r, -r);
    vertex(r, -r, r);
    vertex(-r, -r, r);
    
    fill(colors[BCK]);
    vertex(-r, r, -r);
    vertex(r, r, -r);
    vertex(r, r, r);
    vertex(-r, r,r);
    
     //for x
    fill(colors[LFT]); 
    vertex(-r, -r, -r);
    vertex(-r, r, -r);
    vertex(-r, r, r);
    vertex(-r, -r,r);
    
    fill(colors[RTH]);
    vertex(r, -r, -r);
    vertex(r, r, -r);
    vertex(r, r, r);
    vertex(r, -r,r);
    
    endShape();
    
    //box(len);
    
    popMatrix();
  }
}
  public void settings() {  size(600, 600, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "rubix_cube" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
