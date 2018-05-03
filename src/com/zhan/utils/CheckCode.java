package com.zhan.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 
 * @author zhanmeihe
 *
 */
public class CheckCode {

	public CheckCode() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 随机产生干扰线颜色
	 * @author zhanmeihe
	 * @param Low
	 * @param High
	 * @return
	 */
	public static Color interLine(int Low, int High) {
		if (Low > 255)
			Low = 255;
		if (High > 255)
			High = 255;
		if (Low < 0)
			Low = 0;
		if (High < 0)
			High = 0;
		int interval = High - Low;
		int r = Low + (int) (Math.random() * interval);
		int g = Low + (int) (Math.random() * interval);
		int b = Low + (int) (Math.random() * interval);
		return new Color(r, g, b);
	}

	/**
	 * 生成验证码
	 * @author zhanmeihe
	 * @param bfi
	 * @param g
	 * @return
	 */
	public static StringBuffer getCode(BufferedImage bfi,Graphics g) {
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
				.toCharArray();
		Random r = new Random();
		int index;
		StringBuffer sb = new StringBuffer(); // 保存字符串
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(ch.length);
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			Font font = new Font("宋体", 30, 20);
			g.setFont(font);
			g.drawString(ch[index] + "", (i * 20) + 2, 23);
			sb.append(ch[index]);
		}
		// 添加噪点
		int area = (int) (0.02 * 80 * 25);
		for (int i = 0; i < area; ++i) {
			int x = (int) (Math.random() * 80);
			int y = (int) (Math.random() * 25);
			bfi.setRGB(x, y, (int) (Math.random() * 255));
		}

		// 设置验证码中的干扰线
		for (int i = 0; i < 6; i++) {
			// 随机获取干扰线的起点和终点
			int xstart = (int) (Math.random() * 80);
			int ystart = (int) (Math.random() * 25);
			int xend = (int) (Math.random() * 80);
			int yend = (int) (Math.random() * 25);
			g.setColor(CheckCode.interLine(1, 255));
			g.drawLine(xstart, ystart, xend, yend);
		}
		return sb;
	}

}
