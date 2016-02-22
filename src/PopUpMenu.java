import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PopUpMenu extends JPanel
{

	static JPopupMenu popup;

	public PopUpMenu(XCommand cmd){
		popup = new JPopupMenu();

		JMenuItem ItemColor = new JMenuItem(PainterMain.messages.getString("color"));
		JMenuItem ItemRed = new JMenuItem(PainterMain.messages.getString("red"));
		JMenuItem ItemGreen = new JMenuItem(PainterMain.messages.getString("green"));
		JMenuItem ItemBlue = new JMenuItem(PainterMain.messages.getString("blue"));
		JMenuItem ItemThick = new JMenuItem(PainterMain.messages.getString("high"));
		JMenuItem ItemMidle = new JMenuItem(PainterMain.messages.getString("middle"));
		JMenuItem ItemThin = new JMenuItem(PainterMain.messages.getString("thin"));



		popup.add(ItemColor);
		popup.addSeparator();
		popup.add(ItemRed);
		popup.add(ItemGreen);
		popup.add(ItemBlue);
		popup.addSeparator();
		popup.add(ItemThick);
		popup.add(ItemMidle);
		popup.add(ItemThin);

		ItemRed.setActionCommand("red");
		ItemGreen.setActionCommand("green");
		ItemBlue.setActionCommand("blue");
		ItemThick.setActionCommand("10");
		ItemMidle.setActionCommand("5");
		ItemThin.setActionCommand("2");
		
		ItemColor.addActionListener(cmd.aColor);
		ItemRed.addActionListener(cmd.aColor);
		ItemGreen.addActionListener(cmd.aColor);
		ItemBlue.addActionListener(cmd.aColor);
		ItemThick.addActionListener(cmd.aWidth);
		ItemMidle.addActionListener(cmd.aWidth);
		ItemThin.addActionListener(cmd.aWidth);

	}

}

