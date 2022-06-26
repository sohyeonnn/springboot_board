package com.build_ash.boardservice.service;

import com.build_ash.boardservice.entity.Board;
import com.build_ash.boardservice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 글 작성 처리
    public void write(Board board) {

        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    //게시글 검색 처리
    public Page<Board> boardSearchList(String searchKeyword, Pageable pageable) {

        return boardRepository.findByTitleContaining(searchKeyword, pageable);

    }

    // 게시글 상세 페이지 처리
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    // 게시글 삭제 처리
    public void boardDelete(Integer id) {

        boardRepository.deleteById(id);
    }

    // 게시글 조회수 카운트 처리
    @Transactional
    public int viewHitCount(Integer id) {

        return boardRepository.viewHitCount(id);
    }

}
