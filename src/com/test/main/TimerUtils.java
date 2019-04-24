package com.test.main;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerUtils {
	static int count = 0;

	public static void showTimer() {
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				++count;
				System.out.println("时间=" + new Date() + " 执行了" + count + "次"); // 1次
			}
		};
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);// 每天
		int hour = calendar.get(Calendar.HOUR);
		int miss = calendar.get(Calendar.MINUTE);
		int sen = calendar.get(Calendar.SECOND);

		calendar.set(year, month, day, hour, miss,sen);
		Date date = calendar.getTime();
		Timer timer = new Timer();
		System.out.println(date);

		int period = 10 * 1000;

		 timer.schedule(task, date, period);
		//timer.schedule(task, date);
	}

	public static void main(String[] args) {
		showTimer();
	}

}
