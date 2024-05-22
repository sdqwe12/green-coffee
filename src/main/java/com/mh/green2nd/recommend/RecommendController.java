package com.mh.green2nd.recommend;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/recommend")
@RestController
public class RecommendController {

    private final RecommendService recommendService;

    // 추천 메뉴 리스트 조회
    @Operation(summary = "추천 메뉴 리스트 조회")
    @GetMapping("/list")
    public ResponseEntity<List<Recommend>> getRecommendList() {
        List<Recommend> recommendList = recommendService.getRecommendList();
        return new ResponseEntity<>(recommendList, HttpStatus.OK);
    }

    // 추천 메뉴 상세 조회
    @GetMapping("/detail")
    public ResponseEntity<Recommend> getRecommendDetail(Long recommendId) {
        Recommend recommend = recommendService.getRecommendDetail(recommendId);
        return new ResponseEntity<>(recommend, HttpStatus.OK);
    }



}
