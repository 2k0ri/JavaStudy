package com.aucfanlab.k0ri;

import java.awt.Color;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Ball implements Runnable {

	String id;
	int x, y;
	int mx, my;
	int r;
	Color color;
	static Random random;

	static {
		random = new Random();
	}

	public Ball(int r, Color color) {
		this(random.nextInt(330), random.nextInt(300), r, color);
	}

	public Ball(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
		mx = random.nextInt(4) - 2;
		my = random.nextInt(4) - 2;
		color = Color.black;
		id = UUID.randomUUID().toString();
	}

	public Ball(int x, int y, int r, Color color) {
		this(x, y, r);
		this.color = color;
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void reflectX() {
		this.mx *= -1;
	}

	public void reflectY() {
		this.my *= -1;
	}

	@Override
	public void run() {
		while (true) {
			this.x += this.mx;
			this.y += this.my;
			System.out.println("BALL ID[" + id + "] X=" + x + " Y=" + y);

			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
