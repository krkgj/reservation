package org.zerock.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter{

	public Date stringtodateConverter(String str) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date afterConvert = formatter.parse(str);
		
		return afterConvert;
	}

}
