package com.lakers.sweep.domain;

/**
 * 旗子的实体类  
 * 它的容器是Grid
 * @author m1563
 *
 */
public class Flag {
	private int row ;//所在行数
	private int column;//所在列数
	/**
	 * 旗子的数量
	 */
	private int count;
	/**
	 * 无参构造
	 */
	public Flag() {
		super();
	}
	/**
	 * 有参构造
	 * @param row
	 * @param column
	 */
	public Flag(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * 重写toString()方法
	 */
	@Override
	public String toString() {
		return "[ "+count+" ]";
	}
	
}
