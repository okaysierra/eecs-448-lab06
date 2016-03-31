import javax.swing.JFrame;

public class VotingBoothDriver
{
  private static void createAndDisplayGUI()
  {
    JFrame frame = new JFrame("Voting Booth");
    VotingBooth demo = new VotingBooth();

    frame.getContentPane().add(demo.getContent());
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args)
  {
    createAndDisplayGUI();
  }
}
