package org.mcsg.bot.skype.drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.mcsg.bot.skype.util.MapWrapper;
import org.mcsg.bot.skype.util.Progress;

public class DrawDotLines extends Drawer {

	int r=rand.nextInt(255);
	int gc=rand.nextInt(255);
	int b=rand.nextInt(255);
	int a=rand.nextInt(255);

	int x = rand.nextInt(WIDTH);
	int y = rand.nextInt(WIDTH);

	int size = rand.nextInt(45);


	public DrawDotLines(int width, int height, BufferedImage img, Graphics2D g) {
		super(width, height, img, g);
	}


	@Override
	public void draw(Progress<Integer> prog, MapWrapper args) {
		g.setColor(Color.WHITE);

		g.setStroke(new BasicStroke(rand.nextInt(7)));
		
		int stop = rand.nextInt(10000);
		prog.setMax(stop);
		
		for(int aa = 0; aa < stop; aa++){
			r += rand.nextInt(7) - 3;
			b += rand.nextInt(7) - 3;
			gc += rand.nextInt(7) - 3;
			a += rand.nextInt(7) - 3;

			r = r < 0 ? 0 : r > 255 ? 255 : r; 
			b = b < 0 ? 0 : b > 255 ? 255 : b; 
			gc = gc < 0 ? 0 : gc > 255 ? 255 : gc; 
			a = a < 0 ? 0 : a > 255 ? 255 : a; 

			g.setColor(new Color(r, b, gc, a));

			x += rand.nextInt(size) - size / 2;
			y += rand.nextInt(size) - size / 2;
			size += rand.nextInt(3) - 1;

			size = size < 10 ? 10 : size  > 50 ? 50 : size;
			x = x > WIDTH ? WIDTH : x < 0 ? 0 : x;
			y = y > HEIGHT ? HEIGHT : y < 0 ? 0 : y;

			g.fillOval(x, y, size, size);
			g.setColor(g.getColor().brighter());
			g.drawOval(x, y, size, size);
			prog.setProgress(aa);
		}
	}

}
