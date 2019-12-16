import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.*;

//Projekt 1_2 ne Java 2
//Informatike viti III
//Data e marrjes së projektit : 3.12.2019
//Data e dorëzimit të projektit : 15.12.2019
//Ky program ben te mundur leximin nga nje skedar text, afishimin,shtimin e rreshtave nga perdoruesi
//me ane te menyse perzgjedhese.
//Punuan Gjovalin Deda,Eljona Arrinaj,Klevisa Zekaj, Gledis Kapidani

public class TextAreaLoad extends JFrame implements ActionListener
{
   public TextAreaLoad()
	
	
    {
		
        final JTextArea edit = new JTextArea(50, 100);

        //lexon te dhenat e skedarit dhe i afishon ne textarea
        JButton read = new JButton("Lexo Skedarin");
        read.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	try {
            	    FileReader file =  new FileReader("text.txt"); 
            	    BufferedReader lexo = new BufferedReader(file); 

            	    
            	    	edit.read(lexo,null);
            	    	lexo.close();
            	        edit.requestFocus();
            	   
            	  } catch (Exception ex) {
            		  JOptionPane.showMessageDialog(read, "E pamundur te lexohet nga file") ;
            	  }
            }
        });
        
        
        //per te kerkuar emrin
        JButton kerko = new JButton("Kerko me Emer");
        kerko.addActionListener( new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)	{
        		try {
        			String str=JOptionPane.showInputDialog("shkruani emrin : ");
        			String emri = "Emri i kerkuar nuk gjendet ne skedar";
        			String temp = "";
        				ArrayList<String> lista = new ArrayList<>();
        			Scanner s = new Scanner(new File("text.txt")).useDelimiter("\\n"); 
        				   
        				while (s.hasNext()) 
        		    	lista.add(s.next());
        				
        		    	for (int i=0;i<lista.size();i++ ) {
        					 if (lista.get(i).startsWith(str)) 
        						  temp=temp+lista.get(i)+"\r\n";}
        				
        		    	if (temp=="")
        		    	JOptionPane.showMessageDialog(null, emri);
        		    	else 
        		    		JOptionPane.showMessageDialog(null, temp);
        		   
        			
        			
        				}catch(Exception ex){
        			JOptionPane.showMessageDialog(kerko,"Lidhja me skedarin nuk mund te kryhet");
        			
        		}
        		
        		
        	}
        	
        		});
        
        // Shton rresht me vlerat perkatese ne skedar
        
        JButton write = new JButton("Shto ne Skedar");
        write.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
             
            	edit.setText("");
            	 FileWriter writer1 =null;
        		 try 
        		 {	writer1 = new FileWriter("text.txt",true);
        		 	String str1,str2,str3,str4,str5,str6;
        		 	str1= JOptionPane.showInputDialog("shkruani emrin : ");
        		 	str2= JOptionPane.showInputDialog("shkruani mbiemrin : ");
        		 	str3= JOptionPane.showInputDialog("shkruani ditlindjen : ");
        		 	str4= JOptionPane.showInputDialog("shkruani vitin e vdekjes : ");
        		 	str5= JOptionPane.showInputDialog("shkruani rrymen muzikore : ");
        		 	str6= JOptionPane.showInputDialog("shkruani vendlindjen : ");
        		 	JOptionPane.showMessageDialog(null, "shtimi me sukses ");
        		 	
        		 
        		 writer1.append(str1+"\t"+str2+"\t"+str3+"\t"+str4+"\t"+str5+"\t"+str6+"\r\n");
        		
        		 writer1.close(); 
        		 

        	}
        	 catch (Exception ex) {JOptionPane.showMessageDialog(read, "E pamundur te shtohet");} }
        	
            }
        );

        JFrame frame = new JFrame("TextArea");
        frame.getContentPane().add( new JScrollPane(edit), BorderLayout.NORTH );
        frame.getContentPane().add(read, BorderLayout.WEST);
        frame.getContentPane().add(kerko, BorderLayout.CENTER);
        frame.getContentPane().add(write, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}



}