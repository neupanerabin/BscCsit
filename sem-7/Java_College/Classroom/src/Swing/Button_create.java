package Swing;
import java.awt.*;

public class Button_create extends Frame {  
	
	
	Button_create(){
		 
		    
		    Button b=new Button("Click Here");  
		    b.setBounds(50,100,95,30);  
		    add(b);  
		    setSize(400,400);  
		    setLayout(null);  
		    setVisible(true);   
//		    Frame.DISPOSE_ON_CLOSE;

		
	}
	public static void main(String[] args) {  
	    new Button_create();
	}  
}  