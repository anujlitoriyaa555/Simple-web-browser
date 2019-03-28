import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JFrame;

class ReadF extends JFrame{
	private JTextField addressb;
	private JEditorPane display;
	
	public ReadF(){
		super("Anuj browser");
		addressb = new JTextField("Enter the URL");
		addressb.addActionListener(
		   new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				   loadhtml(e.getActionCommand());
			   }
		   }
		);
		add(addressb,BorderLayout.NORTH);
		display = new JEditorPane();
		display.setEditable(false);
		
		display.addHyperlinkListener(
		  new HyperlinkListener(){
			  public void hyperlinkUpdate(HyperlinkEvent event){
				  if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
					  loadhtml(event.getURL().toString());
				  }
			  }
		  }
		);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
	//load html method
	
	private void loadhtml(String text){
		try{
			display.setPage(text);
			addressb.setText(text);
		}
		catch(Exception e){
			System.out.println("Not a valid address");
		}
	}
}
class ReadFile{
	public static void main(String args[]){
		ReadF anuj =  new ReadF();
		anuj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
		
