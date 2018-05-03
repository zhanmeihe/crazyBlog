package com.app.framework;

import java.util.Calendar;
import java.util.Date;

public class CurrentTimeProvider {

	public Date getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	public void setTime(Date time) {
	}

	public void restore() {
	}
}
