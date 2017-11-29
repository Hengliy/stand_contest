package contest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

import javazoom.jl.player.Player;
import jxl.Sheet;




public class Choice extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	private Mybutton choice_button[];
	public Choice() {
		setForeground(Color.WHITE);
		setBackground(Color.white);
		choice_button=new Mybutton[30];
		
		for(int i=0;i<choice_button.length;i++)//为每一个按钮添加问题
		{
			choice_button[i]=new Mybutton(String.valueOf(i+1),50);
			//choice_button[i].setFont(new Font("黑体",Font.PLAIN,30));
			choice_button[i].addActionListener(this);
		}
		
		GridLayout layout=new GridLayout(6,5);
		
		layout.setHgap(20);
		layout.setVgap(20);
		
		setLayout(layout);
		
		setVisible(true);
		
		for(int i=0;i<choice_button.length;i++)
		{
			add(choice_button[i]);
		}
		
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		JButton temp=(JButton)ev.getSource();//强制类型转换
		
		int i=Integer.parseInt(temp.getText());
		
		System.out.println("jump to "+i);
		
		MainFrame.panel_choice_pro.appendproblem(MainFrame.choice_cheet,i);
		
		MainFrame.card.show(MainFrame.panel_main, "panel_choice_pro");
		
		choice_button[i-1].setEnabled(false);

	}
	
	public void paintComponent(Graphics g)
	{
		ImageIcon icon2=new ImageIcon("image/background.jpg");
		super.paintComponent(g);
		g.drawImage(icon2.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	

}
