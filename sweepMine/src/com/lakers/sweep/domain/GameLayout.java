package com.lakers.sweep.domain;

/**
 * 游戏布局实体类
 * @author m1563
 * Grids 九宫格由9*9个小格子组成
 * width 小格子所在列
 * height 小格子的所在行号
 */
public class GameLayout {

	private int width;//决定第几列
	private int height;//决定第几行
	private int gridCount;//游戏中的格子数
	
	private Grid[][] grids = null;
	
	/**
	 * 无参构造
	 */
	public GameLayout() {
		super();
	}
	/**
	 * 有参构造方法
	 * @param width 初始宽度
	 * @param height 初始高度
	 * @param gridCount 初始格子数
	 */
	public GameLayout(int width, int height, int gridCount) {
		super();
		this.width = width;
		this.height = height;
		this.gridCount = gridCount;
		grids = new Grid[height][width];
	}
	
	/**
	 * 显示游戏开始时的布局
	 * @return 无返回值
	 */
	public void showLayout() {
		for(int i = 0;i<height;i++) {
			for(int j = 0;j<width;j++) {
				Grid grid = new Grid(i,j);
				grids[i][j] = grid;
				System.out.print(grid.toString());
			}
			System.out.println();
			System.out.println();
		}
	}
	
	/**
	 * 当游戏失败时
	 * 显示游戏结果
	 * @return 无返回值
	 */
	public void showGameResult() {
		for(int i = 0;i<height;i++) {
			for(int j = 0;j<width;j++) {
				Grid grid = grids[i][j];
				if(grid.getFlag()==null) {
					System.out.print(grid.getMine().toString()+"   ");
					continue;
				}
				System.out.print(grid.getFlag().toString()+"   ");
			}
			System.out.println();
			System.out.println();
		}
	}
	/**
	 * 没有猜到炸弹时,更新出的游戏布局
	 * @param layout 上一次的布局
	 * @param row    行号
	 * @param column 列数
	 * @return 无返回值
	 */
	public void showNewLayout(GameLayout layout,int row, int column) {
		for(int i = 0;i<height;i++) {
			for(int j = 0;j<width;j++) {
				if(i==row&&j==column) {
					Grid grid = new Grid(row,column);
					grid.setStyle("[ "+layout.getGrids()[row][column].getFlag().getCount()+" ]");
					Grid[][] grids = layout.getGrids();
					grids[row][column] = grid;
					layout.setGrids(grids);
					System.out.print(layout.getGrids()[row][column].toString());
				}else {
					System.out.print(layout.getGrids()[i][j].toString());
				}
				
			}
			System.out.println();
			System.out.println();
		}
	}
		
	/**
	 * get/set方法
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getGridCount() {
		return gridCount;
	}
	public void setGridCount(int gridCount) {
		this.gridCount = gridCount;
	}
	public Grid[][] getGrids() {
		return grids;
	}
	public void setGrids(Grid[][] grids) {
		this.grids = grids;
	}
	
}
