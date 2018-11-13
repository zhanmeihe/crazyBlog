package com.test.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.zhan.utils.MyIp;

public class XX {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		BufferedReader reader = null;
		reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("/Users/zhanmeihe/WorkData/proxyip.txt"),
						"utf-8"));
		String string = null;
		List<MyIp> ipList = new ArrayList<>();
		while ((string = reader.readLine()) != null) {
			MyIp myIp = new MyIp();
			String[] tn = string.split(":");
			myIp.setAddress(tn[0]);
			myIp.setPort(tn[1]);
			ipList.add(myIp);

		}
		 for (MyIp myIp : ipList) {
			 System.err.println(myIp.getAddress()+":"+myIp.getPort());
			
		}
	}

}
