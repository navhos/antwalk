import java.util.Arrays;
import java.lang.Math;

public class walk {
  //instance variables
  //number of runs of the walk
  private int n;
  //array storing runtimes
  private double[] runTime;
  //mean
  private double mean;
  //stdDev
  private double stddev;

  //constructor
  public walk(int n) {
    this.n = n;
  }

  public void sim() {
    runTime = new double[n];

    int[] end = {1,1,1};
    for(int i=0; i<n; i++) {
      //create new ant for each run
      ant a = new ant();

      //move ant until ant is in final position = end = [1,1,1]
      while(Arrays.equals(a.getPos(), end) == false) {
        a.move();
      }
      //store runtime
      this.runTime[i] = a.getTime();
      //calculate mean
      this.calcMean();
      this.calcStdDev();
    }
  }

  public void calcMean() {
    int sum = 0;
    for (int i=0; i<n; i++) {
      sum += runTime[i];
    }
    this.mean = sum/(double)(n);
  }

  public double getMean() {
    return this.mean;
  }

  public void printMean() {
    System.out.printf("mean: %f\n", this.mean);
  }

  public void calcStdDev() {
    int sum = 0;
    for (int i=0; i<n; i++) {
      sum += Math.pow((runTime[i]-this.mean),2);
    }
    this.stddev = Math.sqrt(sum/(double)(n-1));
  }

  public double getStdDev() {
    return this.stddev;
  }

  public void printStdDev() {
    System.out.printf("stdDev: %f\n", this.stddev);
  }

  public void printRunTime() {
    System.out.printf(Arrays.toString(this.runTime) + "\n");
  }

  public static void main(String[] args) {
    walk test = new walk(500);
    test.sim();
    test.printMean();
    test.printStdDev();
    //test.printRunTime();
  }
}
