package com.mh.green2nd.tosspay;

import com.mh.green2nd.tosspay.response.SingleResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pay")
public class PayController {

    private final PayService payService;
    private final ResponseService responseService;

    @Operation(summary = "결제 요청")
    @GetMapping("/success")
    public ResponseEntity<PayDto> success(@RequestParam String paymentKey,
                                          @RequestParam String orderId,
                                          @RequestParam Integer amount){
        InformationDto informationDto = new InformationDto();
        informationDto.setPaymentKey(paymentKey);
        informationDto.setOrderId(orderId);
        informationDto.setAmount(amount);
        payService.saveInformation(informationDto);
        PayDto payDto = payService.requestFinalPayment(paymentKey, orderId, amount);
        return ResponseEntity.ok(payDto);
    }

    @Operation(summary = "결제 실패", description = "0: 성공, 1: 실패")
    @GetMapping("/fail")
    public SingleResult<PaymentResHandleFailDto> requestFinalPaymentsFail(@RequestParam String errorCode,
                                                                          @RequestParam String orderId){
        try {
            return responseService.getSingleResult(
                    payService.requestFail(errorCode, orderId)
            );
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
