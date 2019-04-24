package com.test.main;

import java.util.ArrayList;
import java.util.List;

public class WW {

	public WW() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/**
		 * INSERT INTO TBL_IBP_CATEGORY_PROGRAM_MAP (ID,
		 * CATEGORY_ID,OPERATE_TYPE,PROGRAM_ID,SEQUENCE,
		 * VALID_START,VALID_END,INSERT_TIME,ORIGINAL_TIME,LOG_ID) VALUES
		 * 
		 * 
		 * (SEQ_IBP_CATEGORY_CHANNEL_MAP.NEXTVAL,
		 * 'ff8080815d30aefa015d34bbf6b50049','REGIST',
		 * 'ff8080815d30aefa015d34bc60be004c',
		 * '9997','20170712000000','20470712000000',SYSDATE-350,'20170719','404826
		 * ' ) 
		 * SEQ_IBP_CATEGORY_CHANNEL_MAP.NEXTVAL
		 * 'ff8080814581e8a001458846e05e720a' 'REGIST'
		 * 'ff8080815d398fb4015d39bc5c270052' '9992' '20140422000000'
		 * '20440422000000' SYSDATE-350 '20170719' '404842'
		 */
		String str = "INSERT INTO TBL_IBP_CATEGORY_PROGRAM_MAP (ID,ELEMENT_ID,ACTION,PARENT_CODE,ELEMENT_CODE,PARENT_ID,SEQUENCE2,VALID_START,"
				+ "VALID_END,INSERT_TIME,ORIGINAL_TIME,LOG_ID)VALUES (SEQ_IBP_CATEGORY_CHANNEL_MAP.NEXTVAL,'ff8080814581e8a001458846e05e720a',"
				+ "'REGIST','ff8080815d398fb4015d39bc5c270052','00000021000000022014042200000002','ff8080815d30aefa015d35b1acb90081','9992',"
				+ "'20140422000000','20440422000000',SYSDATE-350,'20170719','404842')";
		String dd = str.substring(str.indexOf("TBL_"),str.indexOf(" ("));
		if (str.indexOf("SEQUENCE2") != -1&&dd.equals("TBL_IBP_CATEGORY_PROGRAM_MAP")) {

			String start = "INSERT INTO TBL_IBP_CATEGORY_PROGRAM_MAP (ID, CATEGORY_ID,OPERATE_TYPE,PROGRAM_ID,SEQUENCE2,"
					+ "VALID_START,VALID_END,INSERT_TIME,ORIGINAL_TIME,LOG_ID) VALUES ";

			String end[] = str
					.substring(str.indexOf("(SEQ"), str.lastIndexOf(")") + 1)
					.replace("(", "").replace(")", "").split(",");
			
			String[] ru = { "("+end[0]+",", end[1]+",", end[2]+",", end[3]+",", end[6]+",", end[7]+",",
					end[8]+",", end[9]+",", end[10]+",", end[11]+")" };
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < ru.length; i++) {
				sb.append(ru[i]);
			}
			String result =start + sb.toString();
			System.out.println(result);
		} else {
			System.err.println("不包含");
		}

	}
}
