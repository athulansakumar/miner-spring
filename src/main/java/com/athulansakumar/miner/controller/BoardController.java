package com.athulansakumar.miner.controller;

import com.athulansakumar.miner.model.Board;
import com.athulansakumar.miner.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public Board makeNewBoard(){
        return boardService.makeNewBoard(16,16,40);
    }
}
