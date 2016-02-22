import javax.swing.JFrame;


public class PaintFrame extends JFrame 
{
	public PaintFrame() 
	{
		setTitle("Paiter App");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 450);
		
		//add( new PainterPanel() );
		//add( new PainterPanelVector() );
		//add( new CalcPanel() );
		//add( new ValeraCalc() );
		//add( new TablePane() );
		XData data = new XData();
		XCommand cmd = new XCommand();
		cmd.data = data;
		MainMenu mnu  = new MainMenu(cmd);
		add(new DrawPanel(cmd));
		
		
		setJMenuBar(mnu);
		setVisible(true);
		
		ToolBar tb = new ToolBar(cmd); 
		tb.pack();
//		tb.addWindowListener(new WindowAdapter() {
//
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		tb.setVisible(true);
	}
}
