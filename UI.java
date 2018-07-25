import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UI extends Frame implements ActionListener{
  private TextField runs;
  private TextField mean;
  private TextField stddev;

  public static void main(String[] args) {
    new UI();
  }

  public UI() {
    JFrame guiFrame = new JFrame();
    //make sure the program exits when the frame closes
    guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guiFrame.setTitle("Antwalk");
    guiFrame.setSize(580,100);
    //This will center the JFrame in the middle of the screen
    guiFrame.setLocationRelativeTo(null);
    guiFrame.setLayout(new FlowLayout());

    //instructions
    Label inst = new Label("Select the number of runs for which you would like to simulate the antwalk.\n Press Enter.");
    guiFrame.add(inst);
    //label for no of runs
    Label run = new Label("runs:");
    guiFrame.add(run);
    //Text field for number of runs
    runs = new TextField(10);
    guiFrame.add(runs);
    runs.addActionListener(this);
    //Text field for mean
    Label mean_lbl = new Label("mean:");
    guiFrame.add(mean_lbl);
    mean = new TextField(10);
    mean.setEditable(false);
    guiFrame.add(mean);
    //Text field for stdDev
    Label stddev_lbl = new Label("stddev:");
    guiFrame.add(stddev_lbl);
    stddev = new TextField(20);
    stddev.setEditable(false);
    guiFrame.add(stddev);

    guiFrame.setVisible(true);
  }

  @Override
   public void actionPerformed(ActionEvent evt) {
      // Get the String entered into the TextField tfInput, convert to int
      int n = Integer.parseInt(this.runs.getText());
      walk a = new walk(n);
      a.sim();
      double mean = a.getMean();
      double stddev = a.getStdDev();
      this.runs.setText("");  // Clear input TextField
      this.mean.setText(Double.toString(mean)); // Display sum on the output TextField
      this.stddev.setText(Double.toString(stddev));

   }
}
