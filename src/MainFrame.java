import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setContentPane(new DrawPanel());   
	    setTitle("SuperBall");
	    setSize(800,600);

	}
	public static void main(String[] args) {
		MainFrame frame =new MainFrame();
		frame.setVisible(true);
		
	} 

}


class DrawPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	ArrayList<Ball> balList;
	Graphics g;
	
	public  DrawPanel() {
		
		MyListener listener = new MyListener(); 
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		balList =new ArrayList<Ball>();
		g=this.getGraphics();
		setBackground(new Color(0));
		
		new Thread(new Runnable(){
			public void run() {
				while(true){	
					 try {
					      Thread.sleep(10);
					     } catch (InterruptedException e) {
					      e.printStackTrace();
					     }
					  repaint();
	
			}}}).start();
	
	}
    
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Ball ball : balList) {
			ball.paint(g, getSize());
		}
	 }	
	
	
	
	class MyListener implements MouseListener, MouseMotionListener
	{
		private int count =0;
	    public void mouseClicked(MouseEvent e) {
	    	
	    	Ball ball =new Ball(e.getX(), e.getY());
	    	balList.add(ball);
			}

		public void mouseDragged(MouseEvent e) {
			count++;
	    	if (count>=5) {
	    		Ball ball =new Ball(e.getX(), e.getY());
		    	balList.add(ball);
		    	count=0;
			}
		}
		
		public void mouseMoved(MouseEvent e) {
				
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
			
		}
}

