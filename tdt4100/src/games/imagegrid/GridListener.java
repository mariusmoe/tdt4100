package games.imagegrid;

public interface GridListener {
	void gridChanged(ObservableGrid grid, int x, int y, int w, int h);
}
