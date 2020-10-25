package com.athulansakumar.miner.model;

public class Cell {
    private int row;
    private int column;
    private CellType cellType;
    private int number;

    public Cell(int row, int column, CellType cellType) {
        this.row = row;
        this.column = column;
        this.cellType = cellType;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
