package view;

import java.util.List;

import model.ATileMove;

public interface ViewInterface {
	public void resetBoard(int width, int height) throws IllegalArgumentException;


	public void moveTiles(List<ATileMove> moves);


	public void addTiles(List<ATileMove> newTiles);


	public void showWin();

	void showLoss();


	public void showScore(int score, int highScore);

}