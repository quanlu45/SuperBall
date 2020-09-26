import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author quan
 * С��
 */
public class Ball {
	private int x;     //x����
	private int y;     //y����
	private int r;     //�뾶
	private int v;     //�ٶ�
	private Color color;  //��ɫ
	private static int  gravity=1;    //����ϵ��
	private static ArrayList<Ball> balls =new ArrayList<Ball>();   //С���б�
	
	public Ball(int x,int y) {
		this.x=x;
		this.y=y;
		this.v=0;
		Random random = new Random();
		r=random.nextInt(20)+25;
		color =new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
		balls.add(this);
	}
    
	public void paint(Graphics g,Dimension winSize) {
		
		v+=gravity;          //�ٶȸ��¹�ʽ   v1=v0+gt
		y+=0.5*v;            //������¹�ʽ   y1=y0+0.5gt*t,(���������˶�)
		                     //����tȡ1
		if (y+r>=winSize.getHeight()) {
			y=(int) winSize.getHeight()-r; //����
			v-=2;
			v*=-1;
		}
		g.setColor(color);
		g.fillOval(x, y, r,r);
	}
	
	
}
