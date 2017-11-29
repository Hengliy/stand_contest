/*
 * Project:一站到底竞赛软件
 * Author:hengliy of stiea
 * Date: 2017-11-22
 * 
 */


package contest;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class MainFrame extends JFrame {
	
    public static JPanel panel_main = null; // 主要的JPanel，该JPanel的布局管理将被设置成CardLayout
    private JPanel p = null; // 放按钮的JPanel
    public static CardLayout card = null; // CardLayout布局管理器
    private Mybutton button_1 = null; // 上一步
    private Mybutton button_2 = null; // 下一步
    private Mybutton button_4 = null;//退出
    private Mybutton button_race = null, button_normal = null, button_choice = null; // 三个可直接翻转到JPanel组件的按钮
    
    public static Choice panel_choice = null; // 要切换的三个JPanel
    public static Race panel_race = null;
    public static Must panel_normal = null;
    public static Choice_pro panel_choice_pro = null;
    public static Welcome panel_welcome = null;
    
	public static Workbook excel;//
	
	public static Sheet choice_cheet;//选择题页表
	public static Sheet race_sheet;
	public static Sheet must_sheet;
	
	
	public static Thread1 thread_time;
	
    public void getexcel(String path)
    {
    	thread_time=new Thread1();
    	try{
	        excel = Workbook.getWorkbook(new File(path));
	        
	        must_sheet=excel.getSheet(0);//必答
	        choice_cheet=excel.getSheet(1);//选答
	        race_sheet=excel.getSheet(2);//抢答
	        
		}catch(Exception e){
			System.out.println(e);
		}
    }
    public MainFrame() {
    	getContentPane().setBackground(Color.WHITE);
        
    	setBackground(Color.WHITE);
        getexcel("题库.xls");
        
        setTitle("<一站到底> 知识竞赛");

//        try {
//            // 将LookAndFeel设置成Windows样式
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        	//String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName(); UIManager.setLookAndFeel(lookAndFeel);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
       
        card = new CardLayout(5, 5);
        panel_main = new JPanel(card); // JPanel的布局管理将被设置成CardLayout
        p = new JPanel(); // 构造放按钮的JPanel
        p.setBackground(Color.WHITE);
        button_1 = new Mybutton("< \u4E0A\u4E00\u73AF\u8282",13);
        button_2 = new Mybutton("\u4E0B\u4E00\u73AF\u8282 >",13);
        button_4 = new Mybutton("退出",13);
        button_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
        button_normal = new Mybutton("必答环节",13);
        button_normal.setMargin(new Insets(2,2,2,2));

        
        button_1.setBackground(new Color(255, 255, 255));
        
      
        button_choice = new Mybutton("选答环节",13);
        button_choice.setMargin(new Insets(2,2,2,2));
    
        button_choice.addActionListener(new ActionListener() { // 直接翻转到panel_choice
            public void actionPerformed(ActionEvent e) {
            	thread_time.stop();
                card.show(panel_main, "panel_choice");
            }
        });
        button_race = new Mybutton("抢答环节",13);
        button_race.setMargin(new Insets(2,2,2,2));
 
        button_race.addActionListener(new ActionListener() { // 直接翻转到panel_race
            public void actionPerformed(ActionEvent e) {
            	thread_time.stop();
                card.show(panel_main, "panel_race");
            }
        });
       
        
        panel_welcome =new Welcome();
        panel_race = new Race();
        panel_normal = new Must();
        panel_choice = new Choice();
        panel_choice_pro=new Choice_pro();
       
        panel_welcome.setBackground(Color.PINK);
        panel_race.setBackground(Color.yellow);
        panel_normal.setBackground(Color.cyan);
        panel_choice.setBackground(Color.black);
        panel_choice_pro.setBackground(Color.orange);
        
        panel_main.add(panel_welcome,"panel_welcome");
        panel_main.add(panel_race, "panel_race");
        panel_main.add(panel_normal, "panel_normal");
        panel_main.add(panel_choice, "panel_choice");
        panel_main.add(panel_choice_pro,"panel_choice_pro");
       
        button_1.addActionListener(new ActionListener(){ // 上一步的按钮动作
            public void actionPerformed(ActionEvent e) {
            	thread_time.stop();
                card.previous(panel_main);
            }
        });
        button_2.addActionListener(new ActionListener(){ // 下一步的按钮动作
            public void actionPerformed(ActionEvent e) {
            	thread_time.stop();
                card.next(panel_main);
            }
        });
        button_normal.addActionListener(new ActionListener() { // 直接翻转到panel_normal
            public void actionPerformed(ActionEvent e) {
            	thread_time.stop();
                card.show(panel_main, "panel_normal");
            }
        });

        this.getContentPane().add(panel_main,BorderLayout.CENTER);
        this.getContentPane().add(p, BorderLayout.SOUTH);
        Mybutton button = new Mybutton("主菜单",13);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 thread_time.stop();
        		 card.show(panel_main, "panel_welcome");
        	}
        });
        button.setMargin(new Insets(2, 2, 2, 2));
      
        p.add(button);
        p.add(button_1);
       
        
        p.add(button_normal);
        p.add(button_choice);
        p.add(button_race);
        
        p.add(button_2);
        
        p.add(button_4);//退出
        
        
        //this.setUndecorated(true);
        this.setSize(800,600);
        
        this.setResizable(true);//可以改变大小
        this.setVisible(true);
    }
   
    public static void main(String[] args) {
        Frame f=new MainFrame();
		f.setVisible(true);
		f.dispose();
		f.setUndecorated(true);
		f.getGraphicsConfiguration().getDevice().setFullScreenWindow(f);
    }
}
