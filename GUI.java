import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.indico.Indico;
import io.indico.api.text.Emotion;
 
public class GUI extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	String topic;
	JLabel l;
	JTextField t;
	JButton b1,b2;
	public GUI()
	{
		setLayout(null);
		setTitle("Tweet Study");
		getContentPane().setBackground(Color.WHITE);
		setSize(500,500);
		setLocationRelativeTo(null);  
		setResizable(false);
		topic="";
		
		l=new JLabel("Enter keyword here");
		l.setBounds(50,50,300,100);
		l.setVisible(true);
		
		t=new JTextField(20);
		t.setBounds(50,120,300,20);
		t.setVisible(true);
		
		b1=new JButton("Pie Chart");
		b1.setBounds(250,150,100,30);
		b1.addActionListener(this);
		b1.setVisible(true);
		
		b2=new JButton("Tweets");
		b2.setBounds(100,150,100,30);
		b2.addActionListener(this);
		b2.setVisible(true);
		
		add(l);
		add(t);
		add(b1);
		add(b2);
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==b1)
		{
			try
			{
				topic=t.getText();
				if(topic.length()>0)
				{
					ArrayList<String> tweets = TweetManager.getTweets(topic);
					Indico indico = new Indico("XX API Key Here XX");
					List<Map<Emotion,Double>> result = indico.emotion.predict(tweets).getEmotion();
					PieChart ob=new PieChart(topic,result);
					ob.setResizable(false);
					ob.setVisible(true);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			try
			{
				topic=t.getText();
				if(topic.length()>0)
				{
					ArrayList<String> tweets=TweetManager.getTweets(topic);
					Tweets ob=new Tweets(topic,tweets);
					ob.setVisible(true);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public static void main(String args[])
	{
		GUI ob=new GUI();
		ob.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ob.setVisible(true);
	}
}
