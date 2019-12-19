package org.zerock.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringConverter {

	public String datetostringConverter(Date date) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String afterConvert = formatter.format(date);
		
		return afterConvert;
	}

}
