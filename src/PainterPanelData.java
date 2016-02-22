import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


public class PainterPanelData extends JPanel implements MouseInputListener
{
	XData data = null;
	int x;
	int y;


	public PainterPanelData(XCommand cmd) 
	{

		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseListener(new PopClickListener());
		PopUpMenu pm = new PopUpMenu(cmd);
		add(pm);
	

	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		Graphics2D gg = (Graphics2D) getGraphics();
		gg.setColor(data.col);
		gg.setStroke(new BasicStroke(data.width));
		gg.drawLine(x, y, e.getX(), e.getY());
		data.addd(x, y, e.getX(), e.getY(), data.col,data.width);
		x = e.getX();
		y = e.getY();
//		System.out.println(x+" "+ y+"");
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}

	class PopClickListener extends MouseAdapter {
		public void mousePressed(MouseEvent e){
			if (e.isPopupTrigger())
				doPop(e);
		}

		public void mouseReleased(MouseEvent e){
			if (e.isPopupTrigger())
				doPop(e);
		}

		private void doPop(MouseEvent e){
			PopUpMenu.popup.show(e.getComponent(), e.getX(), e.getY());

		}
	}
	@Override
	public void paint(Graphics g)
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setColor(Color.white);
		gg.fillRect(0, 0, getWidth(), getHeight());
		for (XLine line : data.ar) 
		{
			BasicStroke bs = new BasicStroke(line.width);
			gg.setColor(line.col);
			gg.setStroke(bs);
			gg.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
	}
	
}
