package com.lakers.sweep.client;

import java.util.Scanner;
import com.lakers.sweep.domain.Flag;
import com.lakers.sweep.domain.GameLayout;
import com.lakers.sweep.domain.Mine;

public class Sweep {
	private static GameLayout layout = null;
	private static final int minecount = 9;//默认地雷的数量
	private static int gridCount = 0;
	public static void main(String[] args) {
		
		//初始化游戏布局
		initGameLayout(9,9);
		
		//埋雷
		Mine[] mines = plantMines();
		
		//计算地雷周围的旗子数量
		for(int i = 0;i<9;i++) {
			countFlag(mines[i]);
		}
		
		//用户输入扫雷指令
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>>>>>>>>>>>>>>>>>>游戏开始<<<<<<<<<<<<<<<<<<<<");
		
		while(true) {
			System.out.println("请输入所选择的坐标: 例如: 0 0然后按下回车 ");
			int row = sc.nextInt();
			int column =sc.nextInt();
			if(row>=9||column>=9) {
				System.out.println("#######输入坐标无效,请重新输入#######");
				continue;
			}
			Mine mine = layout.getGrids()[row][column].getMine();
			if(mine==null) {
				showCurrentFlag(row,column);
				gridCount--;//没有踩到雷 排除一次风险
				if(gridCount==layout.getGridCount()-minecount) {
					System.out.println(">>>>>>>>>恭喜你,闯关成功<<<<<<<<<");
					showFinalGameResult();
				}
			}else {
				showFinalGameResult();
				System.out.println(">>>>>>>>>>>>>>>>>>>>游戏失败<<<<<<<<<<<<<<<<<<<<");
				sc.close();
				return;
			}
		}
		
	}
	
	/**
	 * 如果没有踩到雷,展示数字
	 * @param row
	 * @param column
	 */
	private static void showCurrentFlag(int row, int column) {
		layout.showNewLayout(layout,row,column);
	}

	/**
	 * 初始化游戏布局
	 * 游戏开始时用户看到的游戏画面
	 * @param width 布局宽度
	 * @param height 布局高度
	 */
	public static void initGameLayout(int width,int height) {
		layout = new GameLayout(width,height,width*height);
		gridCount = layout.getGridCount();
		layout.showLayout();
	}
	
	/**
	 * 放置隐藏的地雷
	 * 游戏结束前不会显示
	 * @param minecount 埋雷数
	 */
	public static Mine[] plantMines() {
		
		Mine[] mines = new Mine[minecount];
		
		for(int i = 0;i<minecount;i++) {
			int row = (int)(Math.random() * 9);
			int column = (int)(Math.random() * 9);
			Mine mine = new Mine(row,column);
			/**
			 * 如果没雷,那就放一个雷
			 * 放完雷,要把旗拔掉
			 */
			if(layout.getGrids()[row][column].getMine()==null) {
				layout.getGrids()[row][column].setMine(mine);
				layout.getGrids()[row][column].setFlag(null);
				mines[i] = mine;
			}else {//如果之前有雷 这个位置就不能再放雷了 那么浪费一次循环
				i--;
			}
			
		}
		
		return mines;
	}
	
	/**
	 * 游戏结束后, 显示埋雷点
	 */
	public static void showFinalGameResult() {
		layout.showGameResult();
	}
	
	/**
	 * 埋雷后 计算出 周围的旗子数量
	 * @param mine 雷
	 */
	public static void countFlag(Mine mine) {
		int row = mine.getRow();
		int column = mine.getColumn();
		/**
		 * 上面一行
		 */
		if(row>0) {
			Flag topFlag = layout.getGrids()[row-1][column].getFlag();
			if(topFlag!=null) {
				topFlag.setCount(topFlag.getCount()+1);
				layout.getGrids()[row-1][column].setFlag(topFlag);
			}
			//判断左边界
			if(column>0) {
				Flag leftFlag = layout.getGrids()[row-1][column-1].getFlag();
				if(leftFlag!=null) {
					leftFlag.setCount(leftFlag.getCount()+1);
					layout.getGrids()[row-1][column-1].setFlag(leftFlag);
				}
			}
			//判断右边界
			if(column<8) {
				Flag rightFlag = layout.getGrids()[row-1][column+1].getFlag();
				if(rightFlag!=null) {
					rightFlag.setCount(rightFlag.getCount()+1);
					layout.getGrids()[row-1][column+1].setFlag(rightFlag);
				}
				
			}
		}
		/**
		 * 本行
		 */
		//判断左边界
		if(column>0) {
			Flag leftFlag = layout.getGrids()[row][column-1].getFlag();
			if(leftFlag!=null) {
				leftFlag.setCount(leftFlag.getCount()+1);
				layout.getGrids()[row][column-1].setFlag(leftFlag);
			}
			
		}
		//判断右边界
		if(column<8) {
			Flag rightFlag = layout.getGrids()[row][column+1].getFlag();
			if(rightFlag!=null) {
				rightFlag.setCount(rightFlag.getCount()+1);
				layout.getGrids()[row][column+1].setFlag(rightFlag);
			}
			
		}
		/**
		 * 下面一行
		 */
		if(row<8) {
			Flag bottomFlag = layout.getGrids()[row+1][column].getFlag();
			if(bottomFlag!=null) {
				bottomFlag.setCount(bottomFlag.getCount()+1);
				layout.getGrids()[row+1][column].setFlag(bottomFlag);
			}
			//判断左边界
			if(column>0) {
				Flag leftFlag = layout.getGrids()[row+1][column-1].getFlag();
				if(leftFlag!=null) {
					leftFlag.setCount(leftFlag.getCount()+1);
					layout.getGrids()[row+1][column-1].setFlag(leftFlag);
				}
				
			}
			//判断右边界
			if(column<8) {
				Flag rightFlag = layout.getGrids()[row+1][column+1].getFlag();
				if(rightFlag!=null) {
					rightFlag.setCount(rightFlag.getCount()+1);
					layout.getGrids()[row+1][column+1].setFlag(rightFlag);
				}
				
			}
		}
		
	}

}
