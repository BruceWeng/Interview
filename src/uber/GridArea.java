package uber;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ���棺����code��һ��Сʱ��һ��2d grid����0��1��ɡ���ĳһ��1��ʼ�����������ڵ�1���ɵ�����������
 ���磺. 
 00100
 01101
 00100
 11110
 �ӵ�2�е�3�е��Ǹ�1��ʼ���㣬�����Ӧ����8��Ҳ���������Щ��������������1���ɵ������
 ����BFS��ġ��ƺ�Ҳ������UF��
 Follow up�������⣬��ÿһ��grid���ɱ߳�Ϊ1�������Σ���������������ܳ���
 ��ʵ����һ���BFS�㷨�����������޸ļ��ɡ�

 */
public class GridArea {
	public int getArea(char[][] grid, int x, int y) {
		if (grid.length==0 || grid[0].length==0 || grid[x][y]!='1') return 0; 
		int sum =0;
		int n = grid.length;
		int m = grid[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[][] visited = new boolean[n][m];
		queue.add(xy2num(x,y,m));
		visited[x][y] = true;
		int[] dx = new int[]{1,0,-1,0};
		int[] dy = new int[]{0,1,0,-1};

		while (!queue.isEmpty()) {
			int head = queue.poll();
			int i = head / m;
			int j = head % m;
			sum++;
			for (int k=0; k<4;k++) {
				int newx = i+dx[k];
				int newy = j+dy[k];
				if (0<=newx && newx<n && 0<=newy && newy<m && !visited[newx][newy] && grid[newx][newy]=='1') {
					visited[newx][newy] = true;
					queue.add(xy2num(newx,newy,m));
				}
			}
		}
		return sum;
	}

	public int getLength(char[][] grid, int x, int y) {
		if (grid.length==0 || grid[0].length==0 || grid[x][y]!='1') return 0; 
		int sum =1;
		int n = grid.length;
		int m = grid[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[][] visited = new boolean[n][m];
		queue.add(xy2num(x,y,m));
		visited[x][y] = true;
		int[] dx = new int[]{1,0,-1,0};
		int[] dy = new int[]{0,1,0,-1};

		while (!queue.isEmpty()) {
			int head = queue.poll();
			int i = head / m;
			int j = head % m;
			sum+=3;
			for (int k=0; k<4;k++) {
				int newx = i+dx[k];
				int newy = j+dy[k];
				if (0<=newx && newx<n && 0<=newy && newy<m && !visited[newx][newy] && grid[newx][newy]=='1') {
					visited[newx][newy] = true;
					sum--;
					queue.add(xy2num(newx,newy,m));
				}
			}
		}
		return sum;
	}
	
	private int xy2num(int x, int y, int m) {
		return x*m+y;
	}
	
	public static void main(String[] args) {
		char[][] grid = new char[][]{
			{'0','0','1','0','0'},
			{'0','1','1','0','1'},
			{'0','0','1','0','0'},
			{'1','1','1','1','0'}};
		GridArea q= new GridArea();
		System.out.println(q.getArea(grid,1,2));
		System.out.println(q.getLength(grid,1,2));
	}
}
