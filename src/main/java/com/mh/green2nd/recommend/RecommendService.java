package com.mh.green2nd.recommend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor

public class RecommendService {

    private final RecommendRepository recommendRepository;


    // 추천 메뉴 리스트 조회
    public List<Recommend> getRecommendList() {
        return recommendRepository.findAll();
    }

    // 추천 메뉴 상세 조회
    public Recommend getRecommendDetail(Long recommendId) {
        return recommendRepository.findById(recommendId).orElse(null);
    }
}
