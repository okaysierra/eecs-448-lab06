import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;


public class SafeConverter
{
	private JPanel panel;
	private JButton button;
  private JButton clear;
	private JTextField text;
	private JLabel label;
  private JRadioButton fahrenheit;
  private JRadioButton celsius;
  private JRadioButton kelvin;
  int first = 0;
  int second =0;

	public SafeConverter()
	{
		panel = new JPanel();
		button = new JButton("Convert");
    clear = new JButton("Clear");
		text = new JTextField(3);//3 cols, not 20 chars
    fahrenheit = new JRadioButton("Fahrenheit");
    celsius = new JRadioButton("Celcius");
    kelvin = new JRadioButton("Kelvin");
		label = new JLabel("\n\nEnter a temperature and select it's units along with the units to convert to. SELECT CURRENT UNITS FIRST, THEN DESIRED UNITS SECOND.");

		//Load the listener
		button.addActionListener(buttonListener());
    clear.addActionListener(clearListener());
    fahrenheit.addActionListener(Fahrenheit());
    celsius.addActionListener(Celsius());
    kelvin.addActionListener(Kelvin());

		//load the panel
		panel.add(text);
		panel.add(button);
    panel.add(clear);
    panel.add(fahrenheit);
    panel.add(celsius);
    panel.add(kelvin);
		panel.add(label);
	}

	public Component getContent()
	{
		return (panel);
	}

  private ActionListener Fahrenheit()
  {
    ActionListener listener = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(first==0)
        {
          first=1;
        }
        else if(second==0)
        {
          second=1;
        }
      }
    };

    return listener;
  }

  private ActionListener Celsius()
  {
    ActionListener listener = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(first==0)
        {
          first=2;
        }
        else if(second==0)
        {
          second=2;
        }
      }
    };

    return listener;
  }

  private ActionListener Kelvin()
  {
    ActionListener listener = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(first==0)
        {
          first=3;
        }
        else if(second==0)
        {
          second=3;
        }
      }
    };

    return listener;
  }

  private ActionListener clearListener()
  {
    ActionListener listener = new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        first=0;
        second=0;
        text.setText("");
        fahrenheit.setSelected(false);
        celsius.setSelected(false);
        kelvin.setSelected(false);
        label.setText("Enter a temperature and select it's units along with the units to convert to. SELECT CURRENT UNITS FIRST, THEN DESIRED UNITS SECOND.");

      }
    };
    return listener;
  }

	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();

        if(input =="")
        {
          label.setText("Please enter an int value in the input field");
        }

        //i feel that all range of int values should be accepted. Sure, there will be a lot of unphysical input accepted, but the conversion will
        //still work fine. unphysical input != bad input
        else
        {

          double temp1 = Double.parseDouble(input);//convert String to double
          double temp2;
          String newText;

          if(first==1 && second == 2)
          {
            temp2= (temp1-32)*(5.0/9.0); //convert F to C
            newText = "Temp in C: " + String.format("%.2f",temp2);//convert double to String and
                                 //only display 2 places past decimal
          }
          else if(first==1 && second == 3)
          {
            //convert from fahrenheit to kelvin
            temp2= ((temp1-32)*(5.0/9.0))+273.15;
            newText = "Temp in K: " + String.format("%.2f",temp2);
          }
          else if(first==2 && second ==1)
          {
            //convert from celcius to fahrenheit
            temp2=((9.0/5.0)*temp1)+32;
            newText = "Temp in F: " + String.format("%.2f",temp2);
          }
          else if(first==2 && second==3)
          {
            //convert from celcius to kelvin
            temp2 = temp1 + 273.15;
            newText = "Temp in K: " + String.format("%.2f",temp2);
          }
          else if(first==3 && second == 1)
          {
            //convert from kelvin to fahrenheit
            temp2=((temp1-273.15)*(9.0/5.0))+32;
            newText = "Temp in F: " + String.format("%.2f",temp2);
          }
          else if(first==3 && second == 2)
          {
            //convert from kelvin to celcius
            temp2=(temp1-273.15);
            newText = "Temp in C: " + String.format("%.2f",temp2);
          }
          else{

            newText = "Invalid input.";
          }

  				label.setText(newText);
  				System.out.println(newText);
          first=0;
          second=0;
          fahrenheit.setSelected(false);
          celsius.setSelected(false);
          kelvin.setSelected(false);
          label.setText("Enter a temperature and select it's units along with the units to convert to. SELECT CURRENT UNITS FIRST, THEN DESIRED UNITS SECOND.");
  			}
      }
		};

		return listener;
	}
}
