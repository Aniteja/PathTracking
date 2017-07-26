import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.BevelBorder;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/

public class RoboFrame extends javax.swing.JFrame implements ActionListener
{

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JButton stopButton;
	private JButton backButton;
	private JLabel jLabel3;
	private JProgressBar jProgressBar1;
	private JLabel jLabel2;
	private JLabel jLabel1;

	
	private JPanel jPanel1;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JButton rightButton;
	private JButton leftButton;
	private JButton forwardButton;

	PortConnection pc=new PortConnection();
	static int x=5;
	static int y=5;
	
	static int x1=0,y1=0;
	static String flagvalue="";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RoboFrame inst = new RoboFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setResizable(false);
				
							}
		});
	}
	
	public RoboFrame() {
		super();
		initGUI();
		
	}
	
	private void initGUI() {
		try {
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(0,0,0));
			this.setTitle("PATH TRACKING OF ROBOT");
			this.setFont(new java.awt.Font("Times New Roman",1,12));

			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBackground(Color.white);
						jPanel1.setBounds(23, 5, 759, 518);
			}
			
						
		{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(944, 275, 113, 27);
				jTextField1.setText(" ");
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(942, 409, 113, 28);
				jTextField2.setText(" ");
			}
						
			{
				stopButton = new JButton();
				getContentPane().add(stopButton);
				stopButton.setBounds(203, 625, 109, 26);
				stopButton.setText("STOP");
				stopButton.addActionListener(this);
				
			}
			{
				forwardButton = new JButton();
				getContentPane().add(forwardButton);
				forwardButton.setBounds(203, 570, 102, 24);
				forwardButton.setText("FORWARD");
				forwardButton.addActionListener(this);
				
			}
			{
				leftButton = new JButton();
				getContentPane().add(leftButton);
				leftButton.setBounds(67, 627, 98, 25);
				leftButton.setText("LEFT");
				leftButton.addActionListener(this);
				
			}
			{
				rightButton = new JButton();
				getContentPane().add(rightButton);
				rightButton.setBounds(350, 625, 109, 28);
				rightButton.setText("RIGHT");
				rightButton.addActionListener(this);
					
			}
			{
				backButton = new JButton();
				getContentPane().add(backButton);
				backButton.setBounds(203, 689, 102, 25);
				backButton.setText("BACK");
				backButton.addActionListener(this);
				
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("DIRECTION");
				jLabel1.setBounds(944, 250, 84, 14);
				jLabel1.setBackground(new java.awt.Color(255,255,255));
				jLabel1.setForeground(new java.awt.Color(255,128,64));
				jLabel1.setFont(new java.awt.Font("Times New Roman",1,14));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("SPEED");
				jLabel2.setBackground(new java.awt.Color(255,255,255));
				jLabel2.setFont(new java.awt.Font("Times New Roman",1,14));
				jLabel2.setForeground(new java.awt.Color(255,128,64));
				jLabel2.setBounds(942, 387, 93, 16);
			}
			{
				jProgressBar1 = new JProgressBar();
				getContentPane().add(jProgressBar1);
				jProgressBar1.setBounds(572, 634, 146, 19);
				
				jProgressBar1.setForeground(Color.RED);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("OBSTACLE");
				jLabel3.setBackground(new java.awt.Color(255,255,255));
				jLabel3.setFont(new java.awt.Font("Times New Roman",1,14));
				jLabel3.setForeground(new java.awt.Color(255,128,64));
				jLabel3.setBounds(572, 612, 93, 16);
			}

			pack();
			this.setSize(1202, 900);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	
	Timer t=new Timer();
	t.schedule(
	new TimerTask() {
		
		
		public void run() {
			// TODO Auto-generated method stub
			int i=0;
			File f=new File("D:/robo/def/src/data.txt");
			try {
				
				FileInputStream fis=new FileInputStream(f);
				flagvalue="";
		
				while((i=fis.read())!=-1)
				{
					//System.out.println((char)i);
					flagvalue+=(char)i;
				}
				System.out.println("flag value is::"+flagvalue);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(flagvalue.equals("r"))
			{
				jProgressBar1.setIndeterminate(false);
				Graphics graphics=jPanel1.getGraphics();
				graphics.setColor(Color.red);
				if(x<720){
				x1=x+10;
				y1=y;
				graphics.drawLine(x,y, x1, y1);
				 x=x1;
			     y=y1;}
				else{
				System.out.println("Boundary reached");
				jTextField1.setText("Stopped");
				jTextField2.setText("0 m/s");
				}				
				}
			else if(flagvalue.equals("l"))
			{
				jProgressBar1.setIndeterminate(false);
				Graphics graphics=jPanel1.getGraphics();
				graphics.setColor(Color.blue);
				System.out.println();
				if(x>20){
					
				x1=x-10;
				y1=y;
				graphics.drawLine(x,y, x1, y1);
				 x=x1;
			     y=y1;}
			     else{
						System.out.println("Boundary reached");
						jTextField1.setText("Stopped");
						jTextField2.setText("0 m/s");
						}
				}
			else if(flagvalue.equals("f"))
			{
				jProgressBar1.setIndeterminate(false);
				Graphics graphics=jPanel1.getGraphics();
				graphics.setColor(Color.black);
				System.out.println();
				if(y<=460){
				x1=x;
				y1=y+10;
				graphics.drawLine(x,y, x1, y1);
				 x=x1;
			     y=y1;
			     		}
				else{
					System.out.println("Boundary reached");
					jTextField1.setText("Stopped");
					jTextField2.setText("0 m/s");
					}
				}
			else if(flagvalue.equals("b"))
			{
				jProgressBar1.setIndeterminate(false);
				Graphics graphics=jPanel1.getGraphics();
				graphics.setColor(Color.orange);
				System.out.println();
				if(y>10)
				{	
					x1=x;
				y1=y-10;
				graphics.drawLine(x,y, x1, y1);
				 x=x1;
			     y=y1;}
			     else{
						System.out.println("Boundary reached");
						jTextField1.setText("Stopped");
						jTextField2.setText("0 m/s");
						}
				}
			else if(flagvalue.equals("s"))
			{
				jProgressBar1.setIndeterminate(false);
				Graphics graphics=jPanel1.getGraphics();
				graphics.setColor(Color.blue);
				graphics.fillOval(x-4,y-5, 10, 10);
				 x=x1;
			     y=y1;
				jTextField1.setText("Stop");
				jTextField2.setText("0 m/s");
				
				}
			else if(flagvalue.equals("o"))
			{
				jProgressBar1.setIndeterminate(true);
				jProgressBar1.setMaximum(100);
				}
			
			else
			{
				jProgressBar1.setIndeterminate(false);
			    float rpm = Float.parseFloat(flagvalue);
				float speed = (float)(4*rpm*0.10472);
				String str = String.valueOf(speed);
				jTextField2.setText(str);

			
			}
		}
	},2000,2000);
}
	
	public void actionPerformed(ActionEvent e)
	{
		String value="F";		
		if(e.getSource()==forwardButton)
		{		
			
			x1=x;
			y1=y+10;
			jTextField1.setText("Forward");
			System.out.println("forward");
			pc.openConnection(value);
			pc.closeConnection();
	
			
		}
		else if(e.getSource()==rightButton)
		{
			x1=x+10;
			y1=y;
			
		}
		else if(e.getSource()==leftButton)
		{
			x1=x-10;
			y1=y;
			
		}
		else if(e.getSource()==backButton)
		{
			x1=x;
			y1=y-10;
		
		}
		
		if(e.getSource()==stopButton)
		{
			jTextField1.setText("Stopped");
			//jTextField2.setText("0m/s");
			//Graphics graphics=jPanel1.getGraphics();
	//		graphics.setColor(Color.red);
			
	    //    graphics.fillOval(45, 85, 15, 15);
			System.out.println("stop");
			pc.openConnection("S");
			pc.closeConnection();
		}
		/*if(e.getSource()==forwardButton)
		{
					}*/
		if(e.getSource()==backButton)
		{
			jTextField1.setText("Back");
			//jTextField2.setText("20m/s");
			/*Graphics graphics=jPanel1.getGraphics();
			graphics.setColor(Color.green);
			graphics.drawLine(x,y, x1, y1);
			 x=x1;
		     y=y1;*/
			System.out.println("back");
			pc.openConnection("B");
			pc.closeConnection();
		}
	
		if(e.getSource()==leftButton)
		{
			jTextField1.setText("Left");
			//jTextField2.setText("10m/s");
			/*Graphics graphics=jPanel1.getGraphics();
			graphics.setColor(Color.black);
			graphics.drawLine(x,y, x1, y1);
			 x=x1;
		     y=y1;*/
			System.out.println("left");
			pc.openConnection("L");
			pc.closeConnection();
		}
		if(e.getSource()==rightButton)
		{
			/*Graphics graphics=jPanel1.getGraphics();
			graphics.setColor(Color.red);
			graphics.drawLine(x,y, x1, y1);
			 x=x1;
		     y=y1;*/
			jTextField1.setText("Right");
			//jTextField2.setText("20m/s");
			System.out.println("right");
			pc.openConnection("R");
			pc.closeConnection();
		}


	}
}
