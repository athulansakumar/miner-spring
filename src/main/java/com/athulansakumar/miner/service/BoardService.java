package com.athulansakumar.miner.service;

import com.athulansakumar.miner.model.Board;
import com.athulansakumar.miner.model.Cell;
import com.athulansakumar.miner.model.CellType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    public Board makeNewBoard(int rows, int columns, int mines){
        int squares = rows * columns;
        List<List<Cell>> cells = new ArrayList<>();

        for(int i=0; i<rows; i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0; j<columns; j++){
                if(Math.random() <= (mines/squares)){
                    row.add(new Cell(i,j, CellType.MINE));
                    mines --;
                }else {
                    row.add(new Cell(i,j,CellType.EMPTY));
                }
                squares--;
            }
            cells.add(row);
        }

        for(int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                Cell cell = cells.get(i).get(j);
                if (!cell.getCellType().equals(CellType.MINE)){
                    cell.setNumber(getAdjMines(cells,i,j,rows,columns));
                    cell.setCellType(cell.getNumber() > 0 ? CellType.NUMBER : CellType.EMPTY);
                }
            }
        }

        return new Board(cells);
    }

    private int getAdjMines(List<List<Cell>> cells, int i, int j, int rows, int columns){
        int number = 0;
        if (i-1 >= 0 && j-1 >= 0 && cells.get(i-1).get(j-1).getCellType().equals(CellType.MINE)){
            number++;
        }
        if (i-1 >= 0 && cells.get(i-1).get(j).getCellType().equals(CellType.MINE)){
            number ++;
        }
        if (i-1 >= 0 && j+1 < columns && cells.get(i-1).get(j+1).getCellType().equals(CellType.MINE)){
            number ++;
        }
        if (j-1 >= 0 && cells.get(i).get(j-1).getCellType().equals(CellType.MINE)){
            number ++;
        }
        if (j+1 < columns && cells.get(i).get(j+1).getCellType().equals(CellType.MINE)){
            number ++;
        }
        if (i+1 < rows && j-1 >= 0 && cells.get(i+1).get(j-1).getCellType().equals(CellType.MINE)){
            number ++;
        }
        if (i+1 < rows && cells.get(i+1).get(j).getCellType().equals(CellType.MINE)){
            number ++;
        }
        if (i+1 < rows && j+1 < columns && cells.get(i+1).get(j+1).getCellType().equals(CellType.MINE)){
            number ++;
        }
        return number;
    }
}
