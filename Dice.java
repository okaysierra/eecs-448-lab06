import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;

public class Dice
{
  private JPanel panel;
  private JButton button;
  private JTextField text;
  private JLabel label;
  private JLabel label2;

  public Dice()
  {
    panel = new JPanel(new GridLayout(3,3));
    button = new JButton("Roll");
    text = new JTextField(1);
    label = new JLabel("Enter a number of sides and hit roll");
    label2 = new JLabel("\n");

    button.addActionListener(buttonListener());

    panel.add(text);
    panel.add(button);
    panel.add(label);
    panel.add(label2);
  }

  public Component getContent()
  {
    return(panel);
  }

  private ActionListener buttonListener()
  {

    ActionListener action = new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {
        String input = text.getText();
        int sides = Integer.parseInt(input);

        Random rand = new Random();

        int value = rand.nextInt(sides)+1;

        String newtext = "   You rolled a " + String.format("%d", value);
        label2.setText(newtext);
        System.out.println(newtext);
      }
    };
    return (action);
  }

}
