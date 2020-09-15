class cubies{
  PVector pos;
  float len;
  cubies(float x, float y, float z, float len_){
    pos = new PVector(x,y,z);
    len = len_;
  }
  
  void show(){
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
