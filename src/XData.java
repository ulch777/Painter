import java.awt.Color;
import java.util.ArrayList;

public class XData 
{
	Color col = Color.black;
	int width = 3;
	PainterPanelData pd = null;
	public ArrayList<XLine> ar = new ArrayList<XLine>();
	PopUpMenu pm = null;

	public void addd(int x1, int y1, int x2, int y2, Color col, int width)
	{
		ar.add(new XLine(x1, y1, x2, y2, col, width));
	}
}
