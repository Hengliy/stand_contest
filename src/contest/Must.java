package contest;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.eclipse.jface.text.source.DefaultAnnotationHover;

import jxl.Sheet;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Must extends JPanel {

	private  Mytextarea textArea;
	private  Mylabel textArea_2;
	private  Mytextarea textArea_1;
	private JLabel labela,labelb,labelc,labeld;
	private JLabel label_1;
	private int startflag;
	
	private int pro_count=0;
//	private int choice_problem_count=1;
//	private int qa_problem_count=250;
	
	private int choice_problem_count;
	private int qa_problem_count;
	
	private int pro_type=0;
	private java.util.Random r;
	
	private int choice_begin;
	private int qa_begin; 
	private int choice_end;
	private int qa_end; 
	private int end_flag=0;
	
	
    public Must() {
        
    	choice_begin=Integer.parseInt(MainFrame.must_sheet.getCell(1,0).getContents())-2;
    	choice_end=Integer.parseInt(MainFrame.must_sheet.getCell(2,0).getContents());
        
        qa_begin=Integer.parseInt(MainFrame.must_sheet.getCell(4,0).getContents())-2;
        qa_end=Integer.parseInt(MainFrame.must_sheet.getCell(5,0).getContents());
        
        
        System.out.println("####");
        System.out.println(choice_begin);
        System.out.println(choice_end);
        System.out.println(qa_begin);
        System.out.println(qa_end);
        System.out.println("####");

        
        choice_problem_count=choice_begin;
        qa_problem_count=qa_begin;
        
        
        System.out.print("choic "+choice_problem_count);
        System.out.print("qa "+qa_problem_count);
        
    	r=new java.util.Random();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{73, 149, 132, 150, 70, 0};
		gridBagLayout.rowHeights = new int[]{100, 150, 0, 27, 27, 27, 27, 42, 54, 69, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		textArea = new Mytextarea();
		textArea.setForeground(Color.BLACK);
		textArea.setOpaque(false);//����͸��
		textArea.setFont(new Font("΢���ź�", Font.PLAIN, 38));//��������,��ʽ,��С
		textArea.setLineWrap(true);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		add(textArea, gbc_textArea);
		
		label_1 = new JLabel("\u56DE\u7B54\u5012\u8BA1\u65F6");
		label_1.setFont(new Font("����", Font.BOLD, 20));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.SOUTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		add(label_1, gbc_label_1);
		
		textArea_2 = new Mylabel();
		textArea_2.setFont(new Font("����",Font.PLAIN,75));//��������,��ʽ,��С
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_2.gridx = 3;
		gbc_textArea_2.gridy = 1;
		add(textArea_2, gbc_textArea_2);
		
		labela = new JLabel("A");
		labela.setFont(new Font("΢���ź�", Font.PLAIN, 28));
		GridBagConstraints gbc_labela = new GridBagConstraints();
		gbc_labela.anchor = GridBagConstraints.WEST;
		gbc_labela.insets = new Insets(0, 0, 5, 5);
		gbc_labela.gridx = 1;
		gbc_labela.gridy = 3;
		add(labela, gbc_labela);
		
		labelb = new JLabel("B");
		labelb.setFont(new Font("΢���ź�", Font.PLAIN, 28));
		GridBagConstraints gbc_labelb = new GridBagConstraints();
		gbc_labelb.anchor = GridBagConstraints.BELOW_BASELINE_LEADING;
		gbc_labelb.insets = new Insets(0, 0, 5, 5);
		gbc_labelb.gridx = 1;
		gbc_labelb.gridy = 4;
		add(labelb, gbc_labelb);
		
		labelc = new JLabel("C");
		labelc.setFont(new Font("΢���ź�", Font.PLAIN, 28));
		GridBagConstraints gbc_labelc = new GridBagConstraints();
		gbc_labelc.anchor = GridBagConstraints.WEST;
		gbc_labelc.insets = new Insets(0, 0, 5, 5);
		gbc_labelc.gridx = 1;
		gbc_labelc.gridy = 5;
		add(labelc, gbc_labelc);
		
		Mybutton button_1 = new Mybutton("��ʾ��");
		//		button_1.setFont(new Font("΢���ź�", Font.BOLD, 20));
		//		button_1.setForeground(new Color(255, 255, 255));
				
				//button_1.setForeground(Color.white);
				//button_1.setFont(new Font("����",Font.PLAIN,16));
				button_1.setBackground(new Color(0, 153, 255));
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainFrame.thread_time.stop();
						appendanswer(MainFrame.must_sheet,pro_type);
					}
				});
				GridBagConstraints gbc_button_1 = new GridBagConstraints();
				gbc_button_1.gridheight = 2;
				gbc_button_1.insets = new Insets(0, 0, 5, 5);
				gbc_button_1.fill = GridBagConstraints.BOTH;
				gbc_button_1.gridx = 3;
				gbc_button_1.gridy = 5;
				add(button_1, gbc_button_1);
		
		labeld = new JLabel("D");
		labeld.setFont(new Font("΢���ź�", Font.PLAIN, 28));
		GridBagConstraints gbc_labeld = new GridBagConstraints();
		gbc_labeld.anchor = GridBagConstraints.WEST;
		gbc_labeld.insets = new Insets(0, 0, 5, 5);
		gbc_labeld.gridx = 1;
		gbc_labeld.gridy = 6;
		add(labeld, gbc_labeld);
		
		textArea_1 = new Mytextarea();
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("����", Font.BOLD, 40));//��������,��ʽ,��С
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_1.gridx = 1;
		gbc_textArea_1.gridy = 8;
		add(textArea_1, gbc_textArea_1);
				
		Mybutton btnNewButton = new Mybutton("��һ��");
//		btnNewButton.setForeground(new Color(255, 255, 255));
//		btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 20));
//		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textArea_1.getText().equals("")||textArea_1.getText().equals("����ʾ��"))
							&&(choice_problem_count!=choice_begin||qa_problem_count!=qa_begin)){	 	
					textArea_1.setText("����ʾ��");
				}
				else{
					
					pro_type=r.nextInt(2);
					
					if(end_flag!=0)
			    	{
			    		pro_type=end_flag-1;
			    	}
					
					appendproblem(MainFrame.must_sheet,pro_type);
					
					MainFrame.thread_time.stop();
					
					MainFrame.thread_time=new Thread1(textArea_2,20);
					
					MainFrame.thread_time.start();
					
					textArea_2.setText("");
					
					textArea_1.setText("");
				}
			}
		});
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);
		
		this.setVisible(false);
	}
    
    public void appendproblem(Sheet sheet,int pro_type)//�Ǿ�̬��Ա���������ڶ���
    {	
    	pro_count++;
    	
        System.out.println("####");
        System.out.println(choice_end);
        System.out.println(choice_problem_count);
        System.out.println(qa_end);
        System.out.println(qa_problem_count);
        System.out.println("####");
    	if((choice_end==choice_problem_count+1)&&(qa_end==qa_problem_count+1))
		{
    		textArea.setText("�ۣ�û����Ŀ��^~^");
		}else{
			if(pro_type==0)//ѡ����
	    	{

	    		choice_problem_count++;//�ӵ���һ��
	    		textArea.setText(String.valueOf(pro_count)+" : "+
	    				sheet.getCell(0,choice_problem_count).getContents());
	    		
	    		labela.setText("A "+sheet.getCell(1,choice_problem_count).getContents());
	    		labelb.setText("B "+sheet.getCell(2,choice_problem_count).getContents());
	    		labelc.setText("C "+sheet.getCell(3,choice_problem_count).getContents());
	    		labeld.setText("D "+sheet.getCell(4,choice_problem_count).getContents());
	    		
	    		
	    		if(choice_end==(choice_problem_count+1))
	    		{
	    			end_flag=2;//ѡ�������
	    		}
	    	}
	    	else if(pro_type==1)//�ʴ���
	    	{    		
	    		qa_problem_count++;
	    		
	    		textArea.setText(String.valueOf(pro_count)+" : "+
	    				sheet.getCell(0,qa_problem_count).getContents());
	        	
	    		labela.setText("");
	        	labelb.setText("");
	        	labelc.setText("");
	        	labeld.setText("");
	    		
	    		if(qa_end==(qa_problem_count+1))
	    		{
	    			end_flag=1;//�ʴ��������
	    		}
	    	}
		}
    }
    
    public void appendanswer(Sheet sheet,int pro_type)
    {
    	if(pro_type==0)
    	{
    		textArea_1.setText(String.valueOf(pro_count)+" ��:"+sheet.getCell(5,choice_problem_count).getContents());
    	}else if(pro_type==1)
    	{
    		textArea_1.setText(String.valueOf(pro_count)+" ��:"+sheet.getCell(1,qa_problem_count).getContents());
    	}
    }
    
	public void paintComponent(Graphics g)
	{
		ImageIcon icon2=new ImageIcon("image/background.png");
		super.paintComponent(g);
		g.drawImage(icon2.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
