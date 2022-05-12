package controller;

//interface biểu diễn những hành động mà controller phải làm
public interface ControllerInterface {
	/*
	 * thực thi các hành động thích hợp để làm cho Model liên kết với Controller
	 * dịch chuyển các ô theo hướng đã cho, có thể cập nhật View dc liên kết với
	 * Controller này
	 */
	public void makeMove(Direction d); // d là hướng di chuyển của ngư�?i dùng g�?i ra trong class Direction

	/*
	 * làm cho model liên kết với controller cập nhật lại số lượng ô ngang d�?c đã
	 * cho sau đó cập nhật bên View
	 */
	public void restartGame(int newWidth, int newHeight);

	public void endGame(); // kết thúc trò chơi
}
