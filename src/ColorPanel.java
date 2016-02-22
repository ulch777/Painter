import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ColorPanel extends JPanel 
{
	public ColorPanel(XCommand cmd)
	{
		setLayout(null);
		setBackground(Color.yellow);
		JButton btn = new JButton(PainterMain.messages.getString("color"));
		JButton btnR = new JButton(PainterMain.messages.getString("red"));
		JButton btnG = new JButton(PainterMain.messages.getString("green"));
		JButton btnB = new JButton(PainterMain.messages.getString("blue"));
		btn.setBounds(20, 10, 70, 30);
		btnR.setBounds(20, 40, 70, 30);
		btnG.setBounds(20, 70, 70, 30);
		btnB.setBounds(20, 100, 70, 30);
		add(btn);
		add(btnR);
		add(btnG);
		add(btnB);
		btnR.addActionListener(cmd.aColor);
		btnG.addActionListener(cmd.aColor);
		btnB.addActionListener(cmd.aColor);
		btnR.setActionCommand("red");
		btnG.setActionCommand("green");
		btnB.setActionCommand("blue");
		btn.addActionListener(cmd.aColor);
		
	}
}
