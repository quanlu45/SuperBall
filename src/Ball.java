import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author quan
 * 小球
 */
public class Ball {
	private int x;     //x坐标
	private int y;     //y坐标
	private int r;     //半径
	private int v;     //速度
	private Color color;  //颜色
	private static int  gravity=1;    //重力系数
	private static ArrayList<Ball> balls =new ArrayList<Ball>();   //小球列表
	
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
		
		v+=gravity;          //速度更新公式   v1=v0+gt
		y+=0.5*v;            //坐标更新公式   y1=y0+0.5gt*t,(自由落体运动)
		                     //这里t取1
		if (y+r>=winSize.getHeight()) {
			y=(int) winSize.getHeight()-r; //修正
			v-=2;
			v*=-1;
		}
		g.setColor(color);
		g.fillOval(x, y, r,r);
	}
	
	
}
