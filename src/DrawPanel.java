import javax.swing.JPanel;


public class DrawPanel extends JPanel 
{
	public DrawPanel(XCommand cmd) 
	{
		setLayout(null);
		
		ColorPanel cp = new ColorPanel(cmd);
		WidthPanel wp = new WidthPanel(cmd);
		PainterPanelData pp = new PainterPanelData(cmd);
		pp.data = cmd.data;
		cmd.data.pd = pp;
		cp.setBounds(0, 0, 100, 200);
		wp.setBounds(0, 200, 100, 200);
		pp.setBounds(100, 0, 400, 400);
		
		add(cp);
		add(wp);
		add(pp);
	}
}
