import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
 
import io.indico.api.text.Emotion;

public class PieChart extends JFrame
{
   List<Map<Emotion,Double>> l;
   String topic;
   public PieChart(String topic,List<Map<Emotion,Double>> l)
   {
	   setLayout(null);
	   setTitle(topic);
	   setSize(500,500);
	   setLocationRelativeTo(null);  
	   getContentPane().setBackground(Color.WHITE);
	   this.l=l;
	   this.topic=topic;
	   JPanel p=create();
	   p.setBounds(500, 500, 500, 500);
	   p.setVisible(true);
	   setContentPane(p);
   }
   
   private PieDataset createDataset() 
   {
	   double d[]=new double[5];
	   for(int x=0;x<l.size();x++)
	   {
           	Map<Emotion,Double> m=l.get(x);
           	Iterator<Emotion> iterator = m.keySet().iterator();
           	int y=-1;
			double big=-1.0;
			int i=0;	
   			while (iterator.hasNext()) 
   			{
   				Emotion key = iterator.next();
   				double a=(Double)(m.get(key));
   				if(a>big)
   				{
   					big=a;
   					y=i;
   				}
   				i++;
   			}
   			d[y]++;
	   }
	   DefaultPieDataset dataset = new DefaultPieDataset();
	   dataset.setValue("Sadness",d[0]);  
	   dataset.setValue( "Fear",d[1]);   
	   dataset.setValue( "Anger",d[2]);    
	   dataset.setValue( "Surprise",d[3]);
       dataset.setValue("Joy",d[4]);
       return dataset;         
   }
   
   private JFreeChart createChart( PieDataset dataset ) 
   {
      JFreeChart chart = ChartFactory.createPieChart(topic,dataset,true,true,false);
      return chart;
   }
   
   public  JPanel create()
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
}
