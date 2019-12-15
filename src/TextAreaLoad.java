import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.*;

public class TextAreaLoad extends JFrame implements ActionListener
{
   public TextAreaLoad()
	//public static void main(String args[])
	
    {
		
        final JTextArea edit = new JTextArea(30, 60);


        JButton read = new JButton("Read TextAreaLoad.txt");
        read.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	try {
            	    FileReader file =  new FileReader("text.txt"); 
            	    Scanner lexo = new Scanner(file); 

            	    while (lexo.hasNextLine()) 
            	    	edit.setText(lexo.nextLine());
            	    	
            	    lexo.close();
            	  } catch (Exception ex) {
            		 System.err.println("File nuk mund te lexohet") ;
            	  }
            }
        });

        JButton write = new JButton("Write TextAreaLoad.txt");
        write.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileWriter writer = new FileWriter( "text.txt" );
                    BufferedWriter bw = new BufferedWriter( writer );
                    edit.write( bw );
                    bw.close();
                    edit.setText("");
                    edit.requestFocus();
                }
                catch(Exception e2) {}
            }
        });

        JFrame frame = new JFrame("TextArea Load");
        frame.getContentPane().add( new JScrollPane(edit), BorderLayout.NORTH );
        frame.getContentPane().add(read, BorderLayout.WEST);
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