import java.awt.Toolkit;
import java.util.ArrayList;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
class Tweets extends JFrame
{
	JTextArea t1[];
	JPanel p;
	JScrollPane sp;
	JPanel pane1;
	int len=500;
	public Tweets(String topic,ArrayList<String> arr)
	{
		getContentPane().setBackground(Color.WHITE);
		setTitle(topic);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setResizable(false);
		String ar[][]=new String[arr.size()][2];
		Font f=new Font("Arial Black",1,14);
		for(int x=0;x<arr.size();x++)
		{
			int i=arr.get(x).indexOf(",");			
			ar[x][0]=arr.get(x).substring(0,i);
			ar[x][1]=arr.get(x).substring(i+1);
		}
		String br[]= {"username","tweet"};
		JTable jt=new JTable(ar,br);
		jt.setFont(f);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(200);
		jt.getColumnModel().getColumn(1).setPreferredWidth(2000);
		jt.setEnabled(false);
		sp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVisible(true);
		add(sp);
	}
}