import javax.swing.JFrame;

public class SafeConverterDriver
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Temperature Converter");
		SafeConverter demo = new SafeConverter();

		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}
