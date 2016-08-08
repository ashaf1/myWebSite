package com.aaronshafron.mysite.model;

import java.sql.Date;

public interface DataDAO {

	public MarketData getDataByDateRangeAndDB(Date begin, Date end, String stockName);
	
}
