package com.aaronshafron.mysite.model;

import java.time.LocalDate;

public class MarketData {
	
	private LocalDate startDate;
	private LocalDate endDate;
	private double beginClose;
	private double endClose;
	private double open;
	private double high;
	private double low;
	private double close;
	private long volume;
	private long avgVolume;
	private long maxVolume;
	private long minVolume;
	private double correlation;
	private double regCoef;
	private double yIntercept;
	private double stdDeviation;
	private double dollarChange;
	private double percChange;
	private double maxPrice;
	private double minPrice;
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	
	public double getCorrelation() {
		return correlation;
	}
	public void setCorrelation(double correlation) {
		this.correlation = correlation;
	}
	
	public double getDollarChange() {
		return dollarChange;
	}
	public void setDollarChange(double dollarChange) {
		this.dollarChange = dollarChange;
	}
	public double getPercChange() {
		return percChange;
	}
	public void setPercChange(double percChange) {
		this.percChange = percChange;
	}
	public double getStdDeviation() {
		return stdDeviation;
	}
	public void setStdDeviation(double stdDeviation) {
		this.stdDeviation = stdDeviation;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public long getAvgVolume() {
		return avgVolume;
	}
	public void setAvgVolume(long avgVolume) {
		this.avgVolume = avgVolume;
	}
	public long getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(long maxVolume) {
		this.maxVolume = maxVolume;
	}
	public long getMinVolume() {
		return minVolume;
	}
	public void setMinVolume(long minVolume) {
		this.minVolume = minVolume;
	}
	public double getRegCoef() {
		return regCoef;
	}
	public void setRegCoef(double regCoef) {
		this.regCoef = regCoef;
	}
	public double getyIntercept() {
		return yIntercept;
	}
	public void setyIntercept(double yIntercept) {
		this.yIntercept = yIntercept;
	}
	public double getBeginClose() {
		return beginClose;
	}
	public void setBeginClose(double beginClose) {
		this.beginClose = beginClose;
	}
	public double getEndClose() {
		return endClose;
	}
	public void setEndClose(double endClose) {
		this.endClose = endClose;
	}
	
}
