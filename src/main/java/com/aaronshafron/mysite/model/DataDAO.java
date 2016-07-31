package com.aaronshafron.mysite.model;

import java.time.LocalDate;

public interface DataDAO {

	public MarketData getDataByDateRangeAndDB(LocalDate begin, LocalDate end, String databaseName);
	
}
