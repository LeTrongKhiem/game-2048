package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * https://viettuts.vn/java-io/serializable-trong-java
 */
public class Board {
	private int[][] grid;
	private int width, height;
	private int score, highScore;
	private boolean isGameWon, isGameOver;

	// chỉ cho phép khởi tạo bên trong model
	protected Board() {
	}

	// trả về giá trị của vị trí ô nằm trên bảng
	public int valueAt(Point cell) {
		if (isContained(cell))
			return grid[cell.x][cell.y];
		return 0;
	}

	// x x tọa độ của vị trí nơi giá trị đang được truy vấn
	// y y tọa độ của vị trí mà giá trị đang được truy vấn
	// return Giá trị tại vị trí đã cho
	public int valueAt(int x, int y) {
		if (isContained(x, y))
			return grid[x][y];
		return 0;
	}

	private boolean isContained(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height)
			return false;
		return true;
	}

	// @return Đúng nếu ô là vị trí hợp lệ trên bảng này, ngược lại là false.
	public boolean isContained(Point cell) {
		if (cell.x < 0 || cell.x >= width || cell.y < 0 || cell.y >= height)
			return false;
		return true;
	}

	// Đặt giá trị của ô đã cho, nếu có trên bảng này, thành giá trị đã cho
	// cell: Vị trí mà giá trị sẽ được thay đổi.
	// val: Giá trị của ô đã cho sẽ được thay đổi thành
	public void setCell(Point cell, int val) {
		if (isContained(cell))
			grid[cell.x][cell.y] = val;
	}

	// Trả về chiều rộng của bảng này
	public int getWidth() {
		return width;
	}

	// Trả về chiều dài của bảng này
	public int getHeight() {
		return height;
	}

	// đặt kích thước cho bảng
	// width: chiều ngang
	// height: dài
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		grid = new int[width][height];
	}

	// retrun điểm số
	public int getScore() {
		return score;
	}

	// ghi điểm
	public void setScore(int score) {
		this.score = score;
	}

	// Trả về điểm cao nhất được liên kết với bảng này
	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public boolean isGameWon() {
		return isGameWon;
	}

	public void setGameWon(boolean isGameWon) {
		this.isGameWon = isGameWon;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	// Trả về danh sách tất cả các ô trên bảng này
	public List<ATileMove> getAllTiles() {
		LinkedList<ATileMove> list = new LinkedList<ATileMove>();
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				if (grid[x][y] == 0)
					continue;
				list.add(new ATileMove(new Point(x, y), grid[x][y]));
			}
		return list;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Width:" + width);
		str.append(",Height:" + height);
		str.append(",Score:" + score);
		str.append(",HighScore:" + highScore);
		str.append(",isGameWon:" + isGameWon);
		str.append(",isGameOver:" + isGameOver);
		str.append(";\n");
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				str.append(grid[x][y] + "\t");
			}
			str.append("\n");
		}
		return str.toString();
	}

}
