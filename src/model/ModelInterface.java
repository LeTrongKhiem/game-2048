package model;

import java.util.List;

import controller.Direction;

//nhũng hành động model làm
public interface ModelInterface {
	// bắt đầu trò chơi bằng 1 tệp đã lưu, nếu k cóc sử dụng kích thước mặc định
	// danh sách tất cả các ô trên bảng

	public List<ATileMove> startGame();

	/*
	 * bắt đầu game với kích thước đã cho width: chiều ngang height: chiều rộng
	 */
	public List<ATileMove> startGame(int width, int height);

	// kết thúc trò chơi hiện tại và bắt đầu bằng kích thước đã cho
	public List<ATileMove> restartGame(int width, int height);

	public void endGame();

	// Dịch chuyển tất cả các ô trên bảng theo hướng đã cho
	// @return Vị trí và giá trị trong quá khứ và hiện tại của tất cả các ô đã được
	// bị ảnh hưởng bởi việc di chuyển cũng như ô đã được thêm vào bảng
	// (chỉ được thêm vào sau khi di chuyển thành công).
	public List<ATileMove> makeMove(Direction d);

	public int getScore();

	// trả về điểm cao nhất trò chơi này
	public int getHighScore();

	// nếu có ô 2048 thì người chơi thắng nhưng vẫn chơi tiếp
	public boolean isGameWon();

	// true nếu trò chơi kết thúc ô dc lấp dầy k thể di chuyển
	public boolean isGameOver();

	public int getWidth();

	public int getHeight();
}
