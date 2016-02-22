import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;


public class WidthPanel extends JPanel 
{
	XData data = null;

	public WidthPanel(XCommand cmd) 
	{
		setLayout(null);
		setBackground(Color.green);
		JButton b0 = new JButton("2"); b0.setBounds(20, 10, 50, 20);
		JButton b1 = new JButton("5"); b1.setBounds(20, 30, 50, 20);
		JButton b2 = new JButton("10" ); b2.setBounds(20, 50, 50, 20);
		add(b0);add(b1);add(b2);
		b0.addActionListener(cmd.aWidth);
		b1.addActionListener(cmd.aWidth);
		b2.addActionListener(cmd.aWidth);
		b0.setActionCommand("2");
		b1.setActionCommand("5");
		b2.setActionCommand("10");

//
//		JButton bSave = new JButton("Save");
//		bSave.setBounds(20, 90, 70, 30);
//		add(bSave);

	}
}
