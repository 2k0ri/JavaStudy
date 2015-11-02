package com.aucfanlab.k0ri;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

/**
 * JFrameフレーム
 */
public class Window extends JFrame {

	private static final long serialVersionUID = -6172202390053955066L;

	List<Ball> balls;
	private boolean initialized;
	Image bufferImage;
	Graphics buffer;

	Window(String title) {
		setTitle(title);
		setVisible(true);
		setSize(320, 240);
		setLocationRelativeTo(null);
		bufferImage = createImage(getSize().width, getSize().height);
		buffer = bufferImage.getGraphics();

		balls = new ArrayList<>();
		balls.add(new Ball(50, Color.red));
		balls.add(new Ball(50, Color.green));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Executor使ってThread実行するやつ
		ExecutorService ballExecutor = Executors.newFixedThreadPool(balls.size());
		for (Ball ball : balls) {
			ballExecutor.execute(ball);
		}

		// 単一Thread 実行するやつ
		new Thread(() -> {
			while (true) {
				repaint();
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		initialized = true;
	}

	@Override
	public void paint(Graphics g) {
		if (initialized) {
			buffer.clearRect(0, 0, getWidth(), getHeight());
			for (Ball ball : balls) {
				if (ball.getY() < getHeight() || getHeight() < ball.getY())
					ball.reflectY();
				if (ball.getX() < getWidth() || getWidth() < ball.getX())
					ball.reflectX();
				buffer.setColor(ball.getColor());
				buffer.fillOval(ball.getX(), ball.getY(), ball.getR(), ball.getR());
			}
			g.drawImage(bufferImage, 0, 0, this);
		} else {
		}
	}
}
