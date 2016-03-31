import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.*;

public class VotingBooth
{
  private JPanel panel;
  private JButton button;
  private JTextField lastname;
  private JTextField firstname;
  private ButtonGroup candidates;
  private JRadioButton candidate1;
  private JRadioButton candidate2;
  private JRadioButton candidate3;
  private JRadioButton candidate4;
  private JLabel label;
  private String vote;

  public VotingBooth()
  {
    panel = new JPanel(new GridLayout(0,1));
    button = new JButton("Vote");
    lastname= new JTextField("Lastname", 4);
    firstname = new JTextField("Firstname", 4);
    candidates = new ButtonGroup();
    candidate1 = new JRadioButton("Frank Underwood");
    candidate2 = new JRadioButton("Jackie Sharp");
    candidate3 = new JRadioButton("Garrett Walker");
    candidate4 = new JRadioButton("Catherine Durant");
    label = new JLabel("Enter your name and Select your candidate");

    candidates.add(candidate1);
    candidates.add(candidate2);
    candidates.add(candidate3);
    candidates.add(candidate4);

    button.addActionListener(buttonListener());
    candidate1.addActionListener(frank());
    candidate2.addActionListener(jackie());
    candidate3.addActionListener(garrett());
    candidate4.addActionListener(catherine());

    panel.add(label);
    panel.add(lastname);
    panel.add(firstname);
    panel.add(candidate1);
    panel.add(candidate2);
    panel.add(candidate3);
    panel.add(candidate4);
    panel.add(button);

  }

  public Component getContent()
  {
    return (panel);
  }
  private ActionListener frank()
  {
    ActionListener action = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        vote = "Frank Underwood";
      }
    };
    return action;
  }

  private ActionListener jackie()
  {
    ActionListener action = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        vote = "Jackie Sharp";
      }
    };
    return action;
  }

  private ActionListener garrett()
  {
    ActionListener action = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        vote = "Garrett Walker";
      }

    };
    return action;
  }

  private ActionListener catherine()
  {
    ActionListener action = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        vote = "Catherine Durant";
      }

    };
    return action;
  }

  private ActionListener buttonListener()
  {
    ActionListener action = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String l_name = lastname.getText();
        String f_name = firstname.getText();
        String name =  l_name + "_" + f_name + "_ballot.txt";
        boolean voted = true;


        try
        {
          BufferedReader reader = new BufferedReader(new FileReader(name));
          reader.close();
        }
        catch (IOException x)
        {
          voted = false;
        }


        if(voted == false)
        {
          try
          {
            BufferedWriter output = new BufferedWriter(new FileWriter(name));
            output.write(vote);
            output.close();
          }
          catch (IOException x)
          {
            System.out.println("File unable to be created");
          }
          label.setText("Ballot successfully cast!");
          System.out.println(" View ballot at" + name);

        }
        else
        {
          label.setText("You have already voted. You cannot vote twice");
          System.out.println(" Unable to cast ballot");
        }

      }
    };
    return action;
  }

}
