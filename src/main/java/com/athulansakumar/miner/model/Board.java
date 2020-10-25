package com.athulansakumar.miner.model;

import java.util.List;

public class Board {

    private int id;
    private List<List<Cell>> cells;

    public Board(List<List<Cell>> cells) {
        id = (int) Math.random() * 1000;
        this.cells = cells;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }
}
