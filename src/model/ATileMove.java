package model;

import java.awt.Point;

/*
 * chứa thông tin vị trí và giá trị cho 1 tile 
 * Quy định: 
 * - �?iểm phải ở t�?a độ (x, y) 
 * - (0,0) là ô trên cùng bên trái
 * - (1,2) là ô dưới cách bên phải 2 ô
 */
public class ATileMove {
	private Point curLoc, prvLoc; // current Location, previous location
	private int curVal, prvVal;// current value, previous value
	private boolean merged, deleted;// gộp ô , xóa

	// dựng ô từ điểm và vị trí đã cho
	// loc: location
	// val: value
	public ATileMove(Point loc, int val) {
		curLoc = loc;
		curVal = val;
		prvLoc = null;
		prvVal = 0;
		merged = deleted = false;
	}

	// return vị trí heienj tạo của tile
	public Point getCurLoc() {
		return curLoc;
	}

	// return giá trị hiện tại của tile
	public int getCurValue() {
		return curVal;
	}

	// return vị trí trc đó của tile
	public Point getPrvLoc() {
		return prvLoc;
	}

	public int getPrvValue() {
		return prvVal;
	}

	// cập nhật vị trí của tile
	public void move(Point to) {
		prvLoc = curLoc;
		curLoc = new Point(to.x, to.y);
		prvVal = curVal;
	}

	/*
	 * cập nhật vt hiện tại và giá trị của tile đánh dấu là ô đã dc gộp lại
	 */
	public void merge(Point to, int val) {
		prvLoc = curLoc;
		curLoc = new Point(to.x, to.y);
		prvVal = curVal;
		curVal = val;
		merged = true;
	}

	// đánh dấu xóa ô
	public void delete() {
		prvVal = curVal;
		curVal = 0;
		deleted = true;
	}

	// đánh dấu ô đã dc gộp
	public void merged() {
		merged = true;
	}

	// trả v�? true nếu tile dc gộp false nếu k dc gộp
	public boolean isMerged() {
		return merged;
	}

	// trả v�? true nếu có đánh dấu dc xóa
	public boolean deleted() {
		return deleted;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ATileMove other = (ATileMove) obj;
		if (curLoc == null) {
			if (other.curLoc != null)
				return false;
		} else if (!curLoc.equals(other.curLoc))
			return false;
		if (curVal != other.curVal)
			return false;
		if (deleted != other.deleted)
			return false;
		if (merged != other.merged)
			return false;
		if (prvLoc == null) {
			if (other.prvLoc != null)
				return false;
		} else if (!prvLoc.equals(other.prvLoc))
			return false;
		if (prvVal != other.prvVal)
			return false;
		return true;
	}

}
