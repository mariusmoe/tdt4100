package games.sudoku.sudoku1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Sudoku implements ISudoku{
	
	List<SudokuCell> cells = new ArrayList<>();


	@Override
	public void init(String level) {
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

}
