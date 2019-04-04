/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deal.or.not.deal;

/**
 *
 * @author Darwin W. Diaz Simon
 */


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DOND extends JFrame{
	
	public static void main(String[] args) {
		
		DOND d = new DOND();
		d.setVisible(true);
		d.setSize(1200,700);
		d.setResizable(false);
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setBackground(Color.white);
		
	}
	
	JPanel p = new JPanel(null);
	JPanel pp = new JPanel(new GridLayout(2,6,7,5));
	JPanel ppp = new JPanel(new GridLayout(1,6,7,5));
	JPanel mpp = new JPanel(new GridLayout(13,1,5,5));
	JPanel mppp = new JPanel(new GridLayout(13,1,5,5));
	
        //ImageIcon icono = new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/maletin.jpg");
	JLabel l = new JLabel(new ImageIcon("C:/Users/PC/Documents/NetBeansProjects/Deal or not Deal/maletin2.jpg"));
        
	JButton b[] = new JButton[26];
	JLabel moneyl[]= new JLabel[26];
	JLabel yb = new JLabel("asd");
	JLabel l1 = new JLabel("Tu Maletin");
	JLabel l2 = new JLabel("Elija un maletín de los anteriores.");
		
	public DOND(){
		
		super("Deal or No Deal");
		add(p);
		p.setBackground(Color.white);
		p.add(l); 
                l.setBounds(1000,1000, 10000, 1500);
		p.add(pp);
                p.add(ppp);
                yb.setBounds(260, 0, 100, 800);
                yb.setHorizontalTextPosition(SwingConstants.CENTER);
                yb.setFont(new Font("Arial", Font.BOLD, 30));
		p.add(l2);
                l2.setBounds(250, 580, 500, 20);
                l2.setForeground(Color.RED);
                l2.setHorizontalAlignment( SwingConstants.CENTER );
                l2.setFont(new Font("Arial", Font.BOLD, 20));
		pp.setBounds(226, 160, 700, 280);
                ppp.setBounds(226, 445, 700, 90);
		pp.setBackground(Color.white);
                ppp.setBackground(Color.white);
		
		p.add(mpp);
                p.add(mppp);mpp.setBounds(5, 115, 150, 430);
                mppp.setBounds(1000, 115, 150, 430);
		mpp.setBackground(Color.white);mppp.setBackground(Color.white);
		//p.setBackground(Color.yellow);
               // pp.setBackground(Color.blue);
               // ppp.setBackground(Color.red);
               // mpp.setBackground(Color.pink);
               // mppp.setBackground(Color.green);
                
		firstaction fa = new firstaction();
		
		for(int i=0;i<26;i++){
			b[i]=new JButton(Integer.toString(i+1));
			b[i].setIcon(new ImageIcon("C:/Users/PC/Documents/NetBeansProjects/Deal or not Deal/maletin2.jpg"));
		
                        //b[i].setBackground(Color.gray);
                        b[i].setContentAreaFilled(false);
                        b[i].setBorder(null);
                        b[i].setBounds(2000, 200, 200, 200);
			b[i].setHorizontalTextPosition(SwingConstants.CENTER);
			b[i].setBorderPainted(false);
                        b[i].getSize(new Dimension(1000, 1000));
			b[i].setFont(new Font("Arial", Font.BOLD, 30));
			b[i].addActionListener(fa);
			if(i<=19){pp.add(b[i]);}
			else{ppp.add(b[i]);}
			
			moneyl[i]=new JLabel(Double.toString(shuffledmoney[i]),new ImageIcon("C:/Users/PC/Documents/NetBeansProjects/Deal or not Deal/billete.jpg"),JLabel.CENTER);
			moneyl[i].setIconTextGap(-70);
			moneyl[i].setFont(new Font("Arial", Font.BOLD, 10));
			if(i<13){mpp.add(moneyl[i]);}
			else{mppp.add(moneyl[i]);}
		}
		
		Random rnd = new Random();
	      for (int i=shuffledmoney.length-1;i>0;i--){
	      int index = rnd.nextInt(i + 1);
	      double a = shuffledmoney[index];
	      shuffledmoney[index] = shuffledmoney[i];
	      shuffledmoney[i] = a;
	    }
	    
	}

	String boxno="";
	double money[] = {0.01,1,5,10,25,50,75,100,200,300,400,500,750,1000,5000,10000,25000,50000,75000,100000,200000,300000,400000,500000,750000,1000000};
	double shuffledmoney[] = {0.01,1,5,10,25,50,75,100,200,300,400,500,750,1000,5000,10000,25000,50000,75000,100000,200000,300000,400000,500000,750000,1000000};
	int indicator=0;
	int indicator2=0;
	double allvalues=0;
	double bankersoffer=0;
	int roundno=0;
	double thiscasemoney=0;
	
	public class firstaction implements ActionListener{
		
		public void actionPerformed (ActionEvent e){
			
			// player selecting own case
			if(boxno.isEmpty()){
				
				for(int i=0;i<26;i++){
					if(e.getSource()==b[i]){boxno=Integer.toString(i+1);}
				}
				
				String yesorno[] = {"SI","NO"};
				int prompt = JOptionPane.showOptionDialog(null,"¿Seguro que estás eligiendo el ? #"+boxno+"?","estas seguro?",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, yesorno,yesorno[1]);
				
				if(prompt==JOptionPane.YES_OPTION){
					
					p.add(yb);yb.setText(boxno);
					
					for(int i=0;i<26;i++){
						if(e.getSource()==b[i]){b[i].setEnabled(false);b[i].setVisible(false);}
					}
					
					p.add(l1);l1.setBounds(50, 630, 100, 15);
					l2.setText("Abre 6 maletines!");
					
				}
				
				else{boxno="";}
			
			}
			
			// player opening cases
			else{
				
				indicator= indicator+1;indicator2=indicator2-1;
				if(indicator<25){
					
					for(int i=0;i<26;i++){
						if(e.getSource()==b[i]){
							JOptionPane.showMessageDialog(null, "Case #"+Integer.toString(i+1)+" contiene $"+ shuffledmoney[i],"Case #"+Integer.toString(i+1), JOptionPane.DEFAULT_OPTION);
							b[i].setEnabled(false);b[i].setVisible(false);
							thiscasemoney = shuffledmoney[i];
							shuffledmoney[i]=0;
							l2.setText("Abrir "+Integer.toString(indicator2-roundno)+" maletines!");
						}
					}
					for(int i=0;i<26;i++){
						if(money[i]==thiscasemoney){
							moneyl[i].setIcon(null);
						}
					}
					
				}
				
				// banker giving offers
				if(indicator==6||indicator==11||indicator==15||indicator==18||indicator==20||indicator==21||indicator==22||indicator==23||indicator==24){
					
					l2.setText("OFERTA DEL BANQUER0!");
					roundno=roundno+1;
					
					for(int i=0;i<26;i++){allvalues=allvalues+shuffledmoney[i];}
					bankersoffer=allvalues/(26-indicator)*roundno/10;
					
					String dond[] = {"DEAL","NO DEAL"};
					int prompt = JOptionPane.showOptionDialog(null,"La oferta del banquero es $"+Double.toString(Math.round(bankersoffer*100.0)/100.0)+"\nDeal or no deal?","Banker's offer",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/money.jpg"), dond,dond[1]);
					
					if(prompt==JOptionPane.YES_OPTION){
						for(int i=0;i<26;i++){moneyl[i].setIcon(new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/money.jpg"));moneyl[i].setText(Double.toString(Math.round(bankersoffer*100.0)/100.0));}
						JOptionPane.showMessageDialog(null, "¡Felicidades! Te vas a casa con $"+Double.toString(Math.round(bankersoffer*100.0)/100.0),"FELICIDADES", JOptionPane.DEFAULT_OPTION, new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/money.jpg"));
						JOptionPane.showMessageDialog(null, "Podrías haber ido a casa con $"+Double.toString(shuffledmoney[Integer.parseInt(boxno)-1]),"Case #"+boxno, JOptionPane.DEFAULT_OPTION, new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/done.jpg"));
						JOptionPane.showMessageDialog(null, "Graciads por jugar Deal or No Deal!","Game over", JOptionPane.DEFAULT_OPTION, new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/done.jpg"));
						System.exit(0);
					}
					else{allvalues=0;}
					indicator2=6;
					if(roundno<5){l2.setText("Open "+Integer.toString(indicator2-roundno)+" maletines!");}
					else{l2.setText("Abrir 1 maletin!");}
					
				}
				
				//last case
				if(indicator==25){
					
					l2.setText("un caso dejado !!");
					
					String yesorno[] = {"SI","NO"};
					int prompt = JOptionPane.showOptionDialog(null,"Te gustaría mantener tu propio caso?","Deal or no deal",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,yesorno,yesorno[1]);
					
					if(prompt==JOptionPane.YES_OPTION){
						
						for(int i=0;i<26;i++){moneyl[i].setIcon(new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/money.jpg"));moneyl[i].setText(Double.toString(shuffledmoney[Integer.parseInt(boxno)-1]));}
						JOptionPane.showMessageDialog(null, "¡Felicidades! Te vas a casa con $" + Double.toString(shuffledmoney[Integer.parseInt(boxno)-1]),"FELICIDADES", JOptionPane.DEFAULT_OPTION, new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/done.jpg"));
						
					}
					else{
						
						for(int i=0;i<26;i++){moneyl[i].setIcon(new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/money.jpg"));moneyl[i].setText(Double.toString(shuffledmoney[indicator]));}
						for(int i=0;i<26;i++){if(e.getSource()==b[i]){
							JOptionPane.showMessageDialog(null, "¡Felicidades! Te vas a casa con $" + Double.toString(shuffledmoney[i]),"FELICIDADES", JOptionPane.DEFAULT_OPTION, new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/done.jpg"));indicator=i;
						}}
						
					}

					l2.setText("Game Over!");
					JOptionPane.showMessageDialog(null, "Gracias por jugar Deal or No Deal!","Game over", JOptionPane.DEFAULT_OPTION, new ImageIcon("C:/Users/Darwin W. Diaz Simon/Documents/NetBeansProjects/Deal or not Deal/done.jpg"));
					System.exit(0);
					
				}
				
			}
			
		}
		
	}
	
}