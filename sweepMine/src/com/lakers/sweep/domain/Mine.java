package com.lakers.sweep.domain;

/**
 * 地雷实体类
 * @author m1563
 * 
 */
public class Mine {

	private int row;//所在行
	private int column;//所在列
	
	private String style = "[ # ]";//地雷的样式
	
	/**
	 * 无参构造
	 */
	public Mine() {
		super();
	}
	
	/**
	 * 有参构造
	 */
	public Mine(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	/**
	 * get/set方法
	 * @return
	 */
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
	
	/**
	 * 重写toString()方法
	 */
	@Override
	public String toString() {
		return style;
	}
	
	
}
