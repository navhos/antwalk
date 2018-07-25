import java.util.Random;

public class ant{
  //instance variables: current position and number of steps
  private int[] pos = new int[3];
  private double t = 0;

  //constructor setting ant in the initial position of the origin
  public ant() {
    int[] init = {0,0,0};
    this.setPos(init);
  }

  public int[] getPos() {
    return this.pos;
  }

  public double getTime() {
    return this.t;
  }

  public void setPos(int[] pos) {
    //check that a 3 dimensional point is entered
    if (pos.length > 3) {
      throw new java.lang.IllegalArgumentException("Please enter a 3-dimensional point");
    }

    this.pos = pos;
  }

  //test method to print current position
  public void printPos() {
    System.out.printf("[%d,%d,%d]\n", this.pos[0], this.pos[1], this.pos[2]);
  }

  //print current time
  public void printTime() {
    System.out.printf("time:%f\n", t);
  }

  public void move() {
    //uniformly randomly select the axis over which the ant should move
    Random rand = new Random();
    int axis = rand.nextInt(3);

    //move ant along the selected axis
    if(this.pos[axis] == 0) {
      this.pos[axis] = 1;
    }
    else {
      this.pos[axis] = 0;
    }

    //increase time
    this.t++;
  }

  public static void main(String[] args) {
    //set ant in initial point in the origin
    ant test = new ant();
    test.printPos();

    //move the ant and check position and time
    int n = 0;
    while(n < 10) {
      test.move();
      test.printTime();
      test.printPos();
      n++;
    }
  }
}
