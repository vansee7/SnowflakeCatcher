SnowFlake [] storm;

void setup()
{
  size(400,400);
  background(0);
  storm = new SnowFlake[300];
  for(int i = 0; i < storm.length; i++) 
  {
    storm[i] = new SnowFlake();
  }
}
void draw()
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
  
  void erase()
  {
    fill(0);
    ellipse(x,y,7,7);  
  }
  
  void move()
  {
    if(isMoving==true)
      y++;    
  }
 
  void wrap()
  {
     if(y>400)
      {
        y=0; 
        x=(int)(Math.random()*400);
      }
  }
  
  void lookDown()
  {
     if(y>0 && y<400 && get(x,y+6)==color(255))
        isMoving=false;
     else if(y>0 && y<400 && get(x, y+6)==color(132,112,255))
       isMoving=false;
     else 
       isMoving=true;
  }
  
  void show() 
  {
    fill(255);
    ellipse(x,y,5,5);
  }
}
   
void mouseDragged()
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
  