package com.build_ash.boardservice.repository;

import com.build_ash.boardservice.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository     // 레포지토리라고 지정해줌
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);

    // 게시글 조회수 카운트
    @Modifying
    @Query(value = "update Board p set p.view_Count = p.view_Count + 1 where p.id = :id", nativeQuery = true)
    int viewHitCount(@Param("id") Integer id);

}
