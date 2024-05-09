package com.mh.green2nd.event;

import com.mh.green2nd.cart.CartReqDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
@Tag(name = "이벤트 상세페이지", description = "1~4번까지 4개 이미지 넣었습니다")
public class EventController {

    private final EventService eventService;

    @Operation(summary = "이벤트 상세 페이지입니다"
            , description = "이벤트 상세페이지입니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 때 나오는 코드"),
            @ApiResponse(responseCode = "500", description = "?")
    })
    @GetMapping("/{eventId}")
    public ResponseEntity<String> eventdetail(@PathVariable Long eventId) {
        String result = eventService.eventdetail(eventId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
