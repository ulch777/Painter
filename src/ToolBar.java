import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class ToolBar extends JFrame 
{
	XData data = null;
	XCommand cmd = null;
	public ToolBar(XCommand cmd)
	{

		super("ToolBar");
		//		setLayout(null);

		JToolBar tb = new JToolBar();
		//		setBounds(200, 150, 200, 200);
		JButton btn = new JButton(PainterMain.messages.getString("color"));
		JButton btnR = new JButton(PainterMain.messages.getString("red"));
		JButton btnG = new JButton(PainterMain.messages.getString("green"));
		JButton btnB = new JButton(PainterMain.messages.getString("blue"));

		JButton b0 = new JButton("2");
		JButton b1 = new JButton("5"); 
		JButton b2 = new JButton("10" ); 

		b0.addActionListener(cmd.aWidth);
		b1.addActionListener(cmd.aWidth);
		b2.addActionListener(cmd.aWidth);
		b0.setActionCommand("2");
		b1.setActionCommand("5");
		b2.setActionCommand("10");
		
		tb.add(btn);
		tb.add(btnR);
		tb.add(btnG);
		tb.add(btnB);

		tb.add(b0);
		tb.add(b1);
		tb.add(b2);

		btnR.addActionListener(cmd.aColor);
		btnG.addActionListener(cmd.aColor);
		btnB.addActionListener(cmd.aColor);
		btnR.setActionCommand("red");
		btnG.setActionCommand("green");
		btnB.setActionCommand("blue");
		btn.addActionListener(cmd.aColor);
		JPanel pane = new JPanel();

		BorderLayout bord = new BorderLayout();

		pane.setLayout(bord);

		pane.add("North", tb);

		setContentPane(pane);

	}

}
