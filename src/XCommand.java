import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class XCommand 
{
	XData data = null; 

	ActionColor aColor = new ActionColor();
	ActionWidth aWidth = new ActionWidth();
	ActionSaveJson gsSave = new ActionSaveJson();
	ActionLoadJson gsLoad = new ActionLoadJson();
	ActionSaveXml xmlSave = new ActionSaveXml();
	ActionLoadXml xmlLoad = new ActionLoadXml();
	ActionClear aClear = new ActionClear();


	class ActionColor implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String act = e.getActionCommand();
			switch (act)
			{
			case "red" : data.col = Color.red; break;
			case "green" : data.col = Color.green; break;
			case "blue" : data.col = Color.blue; break;
			default : data.col = JColorChooser.showDialog(null, "Chose color", Color.black);
			}
		}
	}
	class ActionWidth implements ActionListener
	{ 

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String str = e.getActionCommand();
			int a = Integer.parseInt(str);
			switch (a)
			{
			case 2 : data.width = 2; break;
			case 5 : data.width = 5; break;
			case 10 : data.width = 10; break;
			default : data.width = 1;

			}
		}
	}
	class ActionSaveJson implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Сохранить файл");                
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = fileopen.getSelectedFile();
					FileWriter writer;
					writer = new FileWriter(file);
					Gson gson = new Gson();
					writer.write(gson.toJson(data.ar));
					writer.flush();
					writer.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
	class ActionLoadJson implements ActionListener
	{

		@SuppressWarnings("resource")
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser fileopen = new JFileChooser();
			int ret = fileopen.showDialog(null, "Открыть файл");                
			if (ret == JFileChooser.APPROVE_OPTION) {
				File file = fileopen.getSelectedFile();
				try 
				{
					BufferedReader read = new BufferedReader(new FileReader(file));
					String tmp = read.readLine();
					Type type = new TypeToken<ArrayList<XLine>>(){}.getType();
					data.ar = new Gson().fromJson(tmp, type);
				}

				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				data.pd.setBackground(Color.white);
				data.pd.repaint();
			}
		}
	}
	class ActionSaveXml implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileopen = new JFileChooser();
			int ret = fileopen.showDialog(null, "Сохранить файл");                
			if (ret == JFileChooser.APPROVE_OPTION) {
				File file = fileopen.getSelectedFile();
				String str =file.getName(); 
				ArrayList<XLine> line = data.ar;
				XMLEncoder encoder = null;
				try {
					encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(str)));
					encoder.writeObject(line);
					encoder.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	class ActionLoadXml implements ActionListener{

		@SuppressWarnings({ "unchecked" })
		@Override
		public void actionPerformed(ActionEvent e)
		{

			JFileChooser fileopen = new JFileChooser();
			int ret = fileopen.showDialog(null, "Открыть файл");                
			if (ret == JFileChooser.APPROVE_OPTION) {
				File file = fileopen.getSelectedFile();
				String str =file.getName();	
				FileInputStream fis;
				try {
					fis = new FileInputStream(str);			
					XMLDecoder xmlDecoder = new XMLDecoder(fis);
					data.ar = (ArrayList<XLine>) xmlDecoder.readObject();
					xmlDecoder.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				data.pd.setBackground(Color.white);
				data.pd.repaint();
			}
		}
	}
	class ActionClear implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{

			data.ar.clear();
			data.pd.setBackground(Color.white);
			data.pd.repaint();

		}

	}

}
