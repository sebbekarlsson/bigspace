package nu.sebka.spacegame.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InstanceViewer {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	public static DefaultListModel<Object> model = new DefaultListModel<Object>();
	public static JList<Object> list = new JList<Object>(model);
	public static ArrayList<Object> templist = new ArrayList<Object>();
	JScrollPane scroll = new JScrollPane(list);
	JButton refreshButton = new JButton("Refresh");
	JLabel label = new JLabel("Instances: 0");
	
	public InstanceViewer(){
		frame.setSize(500,800);
		
		scroll.setPreferredSize(new Dimension(480,500));
		
		panel.add(scroll);
		panel.add(label);
		panel.add(refreshButton);
		
		frame.add(panel);
		
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		refreshButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				
			}});
	}
	
	public void refresh(){
		model.clear();
		label.setText("Instances: "+templist.size());
		for(int i = 0; i < templist.size(); i++){
			Object o = templist.get(i);
			String name = o.getClass().getName().replace(o.getClass().getPackage().getName(),"");
			name = name.replace(".", "");
			model.addElement(name);
		}
		
		
		templist.clear();
	}
	
}
