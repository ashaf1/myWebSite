package com.aaronshafron.mysite.model;

import java.time.LocalDate;
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
	public MarketData getDataByDateRangeAndDB(LocalDate begin, LocalDate end, String databaseName) {
		String sqlGetAllData = "Select max(close) AS maxPrice, "
				+ "min(close) AS minPrice, cast(avg(volume) as numeric(20,0)) AS avgVolume, "
				+ "max(volume) AS maxVolume, min(volume) AS minVolume,"
				+ "(Select (Select close from ? where date = ?) - (Select close from ? where date = ?) from ? limit 1) AS dollarChange,"
				+ "(Select cast((((Select close from ? where date = ?) - (Select close from ? where date = ?))*100/(Select close from ? where date = ?))as numeric(10,2)) from ? limit 1) AS percChange, "
				+ "(select cast(stddev(close) as numeric(10,2)) from ? where date >= ? AND date <= ?) AS stdDev "
				+ "from ? "
				+ "where date >= ? AND date <= ?";
		SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sqlGetAllData, databaseName, begin, databaseName, end, databaseName,
												          databaseName, begin, databaseName, end, databaseName, end, databaseName,
												          databaseName, begin, end,
												          databaseName,
												          begin, end);
		MarketData data = new MarketData();
		while(resultSet.next()){
			data.setMaxPrice(resultSet.getDouble("maxPrice"));
			data.setMinPrice(resultSet.getDouble("minPrice"));
			data.setAvgVolume(resultSet.getLong("avgVolume"));
			data.setMaxVolume(resultSet.getLong("maxVolume"));
			data.setMinVolume(resultSet.getLong("minVolume"));
			data.setDollarChange(resultSet.getDouble("dollarChange"));
			data.setPercChange(resultSet.getDouble("percChange"));
			data.setStdDeviation(resultSet.getDouble("stdDev"));
		}
		return data;
	}
	public MarketData getDataByDateRangeAndTwoDBNames(LocalDate begin, LocalDate end, String databaseName1, String databaseName2){
		String sqlGetAllData = "Select cast(regr_slope(?.close, ?.close) as numeric(10,2)) as regSlope, "
				+ "cast(corr(?.close, ?.close) as numeric(10,2)) as correlation, "
				+ "cast(regr_intercept(?.close, ?.close) as numeric(10,2)) as y_intercept "
				+ "from ? join ? ON ?_day_id = ?_day_id "
				+ "where ?.date >= ? AND ?.date <= ?";
		SqlRowSet resultSet= jdbcTemplate.queryForRowSet(sqlGetAllData, databaseName2, databaseName1,
														 databaseName2, databaseName1,
														 databaseName2, databaseName1,
														 databaseName1, databaseName2, databaseName1, databaseName2,
														 databaseName1, begin, databaseName1, end);
		MarketData data = new MarketData();
		while(resultSet.next()){
			data.setCorrelation(resultSet.getDouble("correlation"));
			data.setyIntercept(resultSet.getDouble("y_intercept"));
			data.setRegCoef(resultSet.getDouble("regSlope"));
		}
		return data;
	}
}
