import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainMenu extends JMenuBar 
{
	XCommand cmd = null;
	
	public MainMenu(XCommand cmd) 
	{
		JMenu mnuColor  = new JMenu(PainterMain.messages.getString("color"));
		
		JMenuItem mnuColorColor = new JMenuItem(PainterMain.messages.getString("choosecol"));
		JMenuItem mnuColorRed   = new JMenuItem(PainterMain.messages.getString("red"));
		JMenuItem mnuColorGreen = new JMenuItem(PainterMain.messages.getString("green"));
		JMenuItem mnuColorBlue  = new JMenuItem(PainterMain.messages.getString("blue"));
		
		mnuColor.add(mnuColorColor);
		mnuColor.addSeparator();
		mnuColor.add(mnuColorRed);
		mnuColor.add(mnuColorGreen);
		mnuColor.add(mnuColorBlue);
		
		mnuColorColor.addActionListener(cmd.aColor);
		mnuColorRed.addActionListener(cmd.aColor);
		mnuColorGreen.addActionListener(cmd.aColor);
		mnuColorBlue.addActionListener(cmd.aColor);
		
		mnuColorRed.setActionCommand("red");
		mnuColorGreen.setActionCommand("green");
		mnuColorBlue.setActionCommand("blue");
		
		JMenu mnuWidth = new JMenu(PainterMain.messages.getString("width"));
		JMenuItem mnuThick = new JMenuItem(PainterMain.messages.getString("high"));
		JMenuItem mnuMidle = new JMenuItem(PainterMain.messages.getString("middle"));
		JMenuItem mnuThin = new JMenuItem(PainterMain.messages.getString("thin"));
		
		mnuWidth.add(mnuThick);
		mnuWidth.add(mnuMidle);
		mnuWidth.add(mnuThin);
		
		mnuThick.addActionListener(cmd.aWidth);
		mnuMidle.addActionListener(cmd.aWidth);
		mnuThin.addActionListener(cmd.aWidth);
		
		JMenu mnuSaveLoad  = new JMenu(PainterMain.messages.getString("saveAndLoad"));
		JMenuItem mnuSaveJson = new JMenuItem(PainterMain.messages.getString("saveToJson"));
		JMenuItem mnuLoadJson = new JMenuItem(PainterMain.messages.getString("loadFromJson"));
		JMenuItem mnuSaveXml = new JMenuItem(PainterMain.messages.getString("saveToXML"));
		JMenuItem mnuLoadXml = new JMenuItem(PainterMain.messages.getString("loadFromXML"));
		JMenuItem mnuClear = new JMenuItem(PainterMain.messages.getString("clear"));

		mnuSaveLoad.add(mnuSaveJson);
		mnuSaveLoad.add(mnuLoadJson);
		mnuSaveLoad.add(mnuSaveXml);
		mnuSaveLoad.add(mnuLoadXml);
		mnuSaveLoad.add(mnuClear);
		mnuSaveJson.addActionListener(cmd.gsSave);
		mnuLoadJson.addActionListener(cmd.gsLoad);
		mnuSaveXml.addActionListener(cmd.xmlSave);
		mnuLoadXml.addActionListener(cmd.xmlLoad);
		mnuClear.addActionListener(cmd.aClear);
		
		this.add(mnuColor);
		this.add(mnuWidth);
		this.add(mnuSaveLoad);
	}
}
