package games.sudoku.sudoku3;

import games.IUndoable;
import games.IUpdateable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Sudoku implements ISudoku, IUpdateable, IUndoable{
	
	List<SudokuCell> cells = new ArrayList<>();
	Stack<SudokuCell> undoSt = new Stack<>();
	Stack<SudokuCell> redoSt = new Stack<>();


	@Override
	public void init(String level, List<Edit> edits) {
		cells.clear();
		String stringLevel = level;
		
		
		for (int i = 0; i<81;i++){
			SudokuCell cell = new SudokuCell();
			cell.setIsAssignable(false);
			cell.setCellValue(Character.toString(stringLevel.charAt(i)));
			
			cell.setGetBlock(i);
			cells.add(cell);
		}	
	}
	
	
	
	@Override
	public Integer getCellValue(int x, int y) {
		SudokuCell cell;
		
		try {
			cell = cells.get(x+y*9);
		} catch (Exception e) {
			//samme som init 
			
			cell = cells.get(x+y*9);
		}
		return cell.getCellValue();
	}



	@Override
	public int getBlock(int x, int y) {
		SudokuCell cell;
		cell = cells.get(x+y*9);
		return cell.getBlock();
	}

	
	@Override
	public boolean isLegalRow(int row) {
	
		SudokuCell cell;
		List<Integer> list = new ArrayList<>();

		for (int x=0;x<9;x++){
			cell = cells.get(x+row*9);
			try {
				if (!(cell.getCellValue()==0)){
					list.add(cell.getCellValue());
				}
			} catch (Exception e) {}
		}
		Set<Integer> set = new HashSet<Integer>(list);
		if(set.size() < list.size()){
			return false;
		}
		return true;
	}

	@Override
	public boolean isLegalColumn(int col) {
		SudokuCell cell;
		List<Integer> list = new ArrayList<>();

		for (int y=0;y<9;y++){
			cell = cells.get(col+y*9);
			try {
				if (!(cell.getCellValue()==0)){
					list.add(cell.getCellValue());
				}
			} catch (Exception e) {}
		}
		Set<Integer> set = new HashSet<Integer>(list);
		
		if(set.size() < list.size()){
			return false;
		}
		return true;
	}

	@Override
	public boolean isLegalBlock(int block) {
		List<Integer> list = new ArrayList<>();
		for (SudokuCell cell : cells){
			if (block == cell.getBlock() && !(cell.getCellValue()==0)){
				list.add(cell.getCellValue());
			}
		}
		Set<Integer> set = new HashSet<Integer>(list);
		
		if(set.size() < list.size()){
			return false;
		}
		return true;
	}

	@Override
	public boolean isLegalGrid() {
		
		//not properly tested (should test the above tests)
		for (int i=0;i<9;i++){
			if (!isLegalBlock(i) || !isLegalColumn(i) || !isLegalRow(i)){
				return false;
			}
		}
		return true;
	}


	@Override
	public boolean isAssignable(int x, int y) {
		SudokuCell cell;
		cell = cells.get(x+y*9);
		return cell.isAssignable();
	}

	@Override
	public boolean isValidAssignment(int x, int y, Integer value) {
		
		return true;
	}

	@Override
	public void placeDigit(int x, int y, Integer value) {
		SudokuCell cell;
		cell = cells.get(x+y*9);
		if (cell.isAssignable()){
			cell.setCellValue(value);
		}
		cell.setPlace(x,y);
		undoSt.push(cell);
		redoSt.removeAllElements();
		
	}

	@Override
	public boolean isSolved() {
		
	for (SudokuCell cell : cells){
		if ((cell.getCellValue()==0)){
			return false;
		}
	}
	if (isLegalGrid()){
		return true;
	}
		return false;
	}



	@Override
	public boolean canUndo() {
		if (undoSt.size()>1){
			return true;
		}
		return false;
	}



	@Override
	public void undo() {
		SudokuCell cell;
		SudokuCell cell2;
		cell = undoSt.pop();
		cell2 = undoSt.peek();
		redoSt.push(cell);
		placeDigit(cell.getPlaceX(),cell.getPlaceY(),cell2.getCellValue());
		
	}



	@Override
	public boolean canRedo() {
		if (redoSt.size()>1){
			return true;
		}
		return false;
	}



	@Override
	public void redo() {
		
		SudokuCell cell;
		SudokuCell cell2;

		cell = redoSt.pop();
		cell2 = redoSt.peek();

		placeDigit(cell.getPlaceX(),cell.getPlaceY(),cell2.getCellValue());
	}



	@Override
	public void load(InputStream inputStream) throws IOException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void save(OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		
	}



	



	@Override
	public List<Integer> placeableDigits(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addGridListener(SudokuFX sudokuFX) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateState(boolean fullUpdate) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateState(String text) {
		// TODO Auto-generated method stub
		
	}

}
