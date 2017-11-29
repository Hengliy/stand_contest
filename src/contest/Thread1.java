package contest;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import javazoom.jl.player.Player;

class Thread1 extends Thread{  //倒计时线程，每秒钟重写textarea
    private String name;
    static int time,flag_time,lock_write;
    public Mylabel textArea;
    public Thread1(Mylabel text,int num) {
       textArea=text;
       time=num;
    }
    
    public Thread1() {
    	textArea=null;
    	time=0;
    }
    
    public void run() {

	   for (int i=time; i>-1; i--) {  
            System.out.println(name + "运行  :  " + i);  
            try {
                Thread1.sleep(1000);
                if(i<=3)
            		textArea.setForeground(Color.red);
                else
                	textArea.setForeground(Color.black);
                	
            	textArea.setText(""+String.valueOf(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag_time=0;
        }
	   
	   if(time==3)//抢答3s结束后还要有10s的回答时间
	   {
		   for (int i=10; i>-1; i--) {  
	            System.out.println(name + "运行  :  " + i);  
	            try {
	                Thread1.sleep(1000);
	                if(i<=3)
	            		textArea.setForeground(Color.red);
	                else
	                	textArea.setForeground(Color.black);
	                	
	            	textArea.setText(""+String.valueOf(i));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            flag_time=0;
	        }
	   }
	   
	   
		try{
			BufferedInputStream buffer=new BufferedInputStream(new FileInputStream("music/6138.mp3"));
			Player player=new Player(buffer);
			player.play();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    
    public void set_time(int num)
    {
    	time=num;
    }
}

class BackgroundTextarea extends JTextArea
{
	private Image image;
	public BackgroundTextarea(String path)
	{
		ImageIcon imageIcon=new ImageIcon(path);
		image=imageIcon.getImage();
		setOpaque(false);
	}
	
	@Override
	public void paint(Graphics g){
		
		g.drawImage(image,0,0,getWidth(),getWidth(), this);
		super.paint(g);
	}
}


class Mybutton extends JButton implements MouseListener {
	
	private Color click=new Color(0,120,120);
	private Color quit=new Color(0,160,160);
	private Color entry=new Color(0,140,140);
	private String name;
	public Mybutton(String s,int size) {
		super(s);
		name=s;
		setForeground(Color.white);
		System.out.print(getHeight());
		setFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, size));
		addMouseListener(this);
		setContentAreaFilled(false);//是否显示圆角矩形的外围区域
	}
	
	public Mybutton(String s) {
		super(s);
		name=s;
		setForeground(Color.white);
		System.out.print(getHeight());
		setFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD,20));
		addMouseListener(this);
		setContentAreaFilled(false);//是否显示圆角矩形的外围区域
	}

	public Mybutton(String s,Icon icon)
	{
		super(s,icon);
		addMouseListener(this);
	}
	
	
	public  void paintComponent(Graphics g)
	{
		if(getModel().isArmed()) g.setColor(click);//点击
		else if(getModel().isRollover()) g.setColor(entry);//悬停
		else g.setColor(quit);//其他情况
		
		//画圆角矩形
		g.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, 33, 33);
//		System.out.println(getWidth());
//		System.out.println(getSize());
//		System.out.println(getHeight());

		super.paintComponent(g);
	}
	
	
//	public boolean contains(int x,int y)
//	{
//		if(shape==null||!(shape.getBounds().equals(getBounds())))
//		{
//			shape=new RoundRectangle2D(0, 0, getWidth(), getHeight(),20,20);
//		}
//		return shape.contains(x,y);
//	}
//	
	
	public void paintBorder(Graphics g)//画边界区域
	{
		g.setColor(click);
		//g.setColor(c);;
		g.drawRoundRect(0, 0, getSize().width-1,getSize().height-1,33,33);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class Mylabel extends JLabel 
{
	
	public Mylabel() {
		// TODO Auto-generated constructor stub
		super("",JLabel.CENTER);
		setBackground(Color.orange);
	}
	public  void paintComponent(Graphics g)
	{
		//g.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, 20, 20);
		//g.drawOval(0, 0, 50,50);
		super.paintComponent(g);
	}

	
	public void paintBorder(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.setStroke(new  java.awt.BasicStroke(4f,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER,2));
		g2d.setColor(Color.BLACK);
		g2d.drawOval(0,0,getWidth(),getHeight());
	}
}


class Mytextarea extends JTextArea 
{
	private float alpha;

	public Mytextarea()
	{
		super();
		setOpaque(false);//这一步必须要设置！！！
		alpha=0.4f;
		//setContentAreaFilled(false);//是否显示圆角矩形的外围区域
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
		
		Graphics2D g2d=(Graphics2D)g.create();
		
		g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
		g2d.setColor(Color.white);
		
		//g2d.fillRect(0, 0, getWidth(),getHeight());
		
		g2d.fillRoundRect(0, 0, getSize().width-1,getSize().height-1,20,20);
		//g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
		
		g2d.dispose();
		
		super.paintComponent(g);
		
	}

	
	public void paintBorder(Graphics g)
	{
//		Graphics2D g2d=(Graphics2D)g;
//		g2d.setStroke(new  java.awt.BasicStroke(4f,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER,2));
//		g2d.setColor(Color.BLACK);
//		g2d.drawOval(0,0,getWidth(),getHeight());
	}
}





























































