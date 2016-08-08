package com.aaronshafron.mysite.model;


import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCDataDAO implements DataDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCDataDAO(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public MarketData getDataByDateRangeAndDB(Date begin, Date end, String stockName) {
		String sqlGetAllData = "Select (select close from market_data where name = ? AND date = ?) as begin_close, "
                + "(select close from market_data where name = ? AND date = ?) as end_close, "
				+ "max(close) AS max_close, "
				+ "min(close) AS min_close, cast(avg(volume) as numeric(20,0)) AS avg_volume, "
				+ "max(volume) AS max_volume, min(volume) AS min_volume, "
				+ "((Select close from market_data where name = ? AND date = ?) - (Select close from market_data where name = ? AND date = ?)) AS dollar_change, "
				+ "cast((((Select close from market_data where name = ? AND date = ?) - (Select close from market_data where name = ? AND date = ?))*100/(Select close from market_data where name = ? AND date = ?))as numeric(10,2)) AS perc_change, "
				+ "cast(stddev(close) as numeric(10,2)) AS std_dev "
				+ "from market_data "
				+ "where name = ? AND date >= ? AND date <= ?";
		SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sqlGetAllData, stockName, begin, 
														  stockName, end, 
														  stockName, end, stockName, begin,
												          stockName, end, stockName, begin, stockName, begin,
												          stockName, begin, end
												      	  );
		MarketData data = new MarketData();
		while(resultSet.next()){
			data.setBeginClose(resultSet.getDouble("begin_close"));
			data.setEndClose(resultSet.getDouble("end_close"));
			data.setMaxPrice(resultSet.getDouble("max_close"));
			data.setMinPrice(resultSet.getDouble("min_close"));
			data.setAvgVolume(resultSet.getLong("avg_volume"));
			data.setMaxVolume(resultSet.getLong("max_volume"));
			data.setMinVolume(resultSet.getLong("min_volume"));
			data.setDollarChange(resultSet.getDouble("dollar_change"));
			data.setPercChange(resultSet.getDouble("perc_change"));
			data.setStdDeviation(resultSet.getDouble("std_dev"));
		}
		return data;
	}
	public MarketData getDataByDateRangeAndTwoDBNames(Date begin, Date end, String stockName1, String stockName2){
		String sqlGetAllData = "Select cast(regr_slope(query2.close, query1.close) as numeric(10,2)) as regSlope, "
				+ "cast(corr(query2.close, query1.close) as numeric(10,2)) as correlation, "
				+ "cast(regr_intercept(query2.close, query1.close) as numeric(10,2)) as y_intercept "
				+ "from (select close, date, name from market_data where name = ? AND date >= ? AND date <= ?) as query1 "
				+ "inner join "
				+ "(select close, date, name from market_data where name = ? AND date >= ? AND date <= ?) as query2 " 
				+ "ON query1.date = query2.date";
		SqlRowSet resultSet= jdbcTemplate.queryForRowSet(sqlGetAllData, stockName1, begin, end,
														 stockName2, begin, end
														);
		MarketData data = new MarketData();
		while(resultSet.next()){
			
			data.setCorrelation(resultSet.getDouble("correlation"));
			data.setyIntercept(resultSet.getDouble("y_intercept"));
			data.setRegCoef(resultSet.getDouble("regSlope"));
		}
		return data;
	}
}
