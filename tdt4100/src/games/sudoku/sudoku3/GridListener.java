package games.sudoku.sudoku3;

import games.imagegrid.ObservableGrid;

public interface GridListener {
	void gridChanged(ObservableGrid grid, int x, int y, int w, int h);
		
	

}
