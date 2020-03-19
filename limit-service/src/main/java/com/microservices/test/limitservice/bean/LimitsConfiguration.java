package com.microservices.test.limitservice.bean;

public class LimitsConfiguration {
private int minimum;
private int miximum;
public LimitsConfiguration() {
	super();
	// TODO Auto-generated constructor stub
}
public LimitsConfiguration(int minimum, int miximum) {
	super();
	this.minimum = minimum;
	this.miximum = miximum;
}
public int getMinimum() {
	return minimum;
}
public void setMinimum(int minimum) {
	this.minimum = minimum;
}
public int getMiximum() {
	return miximum;
}
public void setMiximum(int miximum) {
	this.miximum = miximum;
}

}
