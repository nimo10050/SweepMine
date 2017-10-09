package com.lakers.sweep.domain;

/**
 * 格子的实体类
 * @author m1563
 * Mine 格子中存放的炸弹
 * Flag 格子中存放的旗
 */
public class Grid {
	private int row;//格子所在行
	private int column;//格子所在列
	private String style = "";//格子的默认显示样式
	//style = "[ " +row + ","+ column+" ]"
	/**
	 * 格子里面存放的是 要么是地雷要么是旗
	 */
	private Mine mine = null;
	private Flag flag = null;
	
	/**
	 * 无参构造
	 */
	public Grid() {
		super();
	}
	/**
	 * 有参构造
	 * @param row
	 * @param column
	 */
	public Grid(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.style = "[" + row + "," + column + "]";
		flag = new Flag(row,column);//默认放的都是旗子,没有雷
	}
	
	/**
	 * 重写toString()方法
	 */
	@Override
	public String toString() {
		return getStyle();
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
	
	public Mine getMine() {
		return mine;
	}
	public void setMine(Mine mine) {
		this.mine = mine;
	}
	public Flag getFlag() {
		return flag;
	}
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
}
