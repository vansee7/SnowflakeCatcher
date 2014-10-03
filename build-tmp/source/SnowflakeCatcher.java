import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] storm;

public void setup()
{
  size(400,400);
  background(0);
  storm = new SnowFlake[300];
  for(int i = 0; i < storm.length; i++) 
  {
    storm[i] = new SnowFlake();
  }
}
public void draw()
{
  for(int i = 0; i < storm.length; i++)
  {
  storm[i].erase();
  storm[i].lookDown();
  storm[i].move();
  storm[i].wrap();
  storm[i].show();
  }  
}

class SnowFlake {
  int x,y;
  boolean isMoving;
  SnowFlake()
  {
    x = (int)(Math.random()*400);
    y = (int)(Math.random()*400);
    isMoving = true;
  }
  
  public void erase()
  {
    fill(0);
    ellipse(x,y,7,7);  
  }
  
  public void move()
  {
    if(isMoving==true)
      y++;    
  }
 
  public void wrap()
  {
     if(y>400)
      {
        y=0; 
        x=(int)(Math.random()*400);
      }
  }
  
  public void lookDown()
  {
     if(y>0 && y<400 && get(x,y+6)==color(255))
        isMoving=false;
     else if(y>0 && y<400 && get(x, y+6)==color(132,112,255))
       isMoving=false;
     else 
       isMoving=true;
  }
  
  public void show() 
  {
    fill(255);
    ellipse(x,y,5,5);
  }
}
   
public void mouseDragged()
{
  noStroke();
  if(mouseButton==LEFT)
  {
    fill(132,112,255);
    ellipse(mouseX,mouseY,20,20);
  }
  if(mouseButton==RIGHT)
  {
    fill(0);  
    ellipse(mouseX,mouseY,20,20);
  }
}
  
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
