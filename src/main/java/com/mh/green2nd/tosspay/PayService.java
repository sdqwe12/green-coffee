package com.mh.green2nd.tosspay;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class PayService {

    private final PayRepository payRepository;
    private final InformationRepository informationRepository;

    @Value("${toss.apikey}")
    private String apiKey;

    @Value("${toss.secretkey}")
    private String secretKey;

    @Value("${toss.url}")
    private String tossUrl;

    public void saveInformation(InformationDto informationDto){
        Information information = Information.builder()
                .paymentKey(informationDto.getPaymentKey())
                .amount(informationDto.getAmount())
                .orderId(informationDto.getOrderId())
                .paymentType(informationDto.getPaymentType())
                .build();
        informationRepository.save(information);
    }

    @Transactional
    public PayDto requestFinalPayment(String paymentKey, String orderId, int amount) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String key = apiKey + ":" + secretKey;

        String encode = new String(Base64.getEncoder().encode(key.getBytes(StandardCharsets.UTF_8)));

        headers.setBasicAuth(encode);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        JSONObject json = new JSONObject();
        json.put("orderId", orderId);
        json.put("paymentKey", paymentKey);
        json.put("amount", amount);

        PayDto body = rest.postForEntity(
                "https://api.tosspayments.com/v1/payments/confirm",
                new HttpEntity<>(json, headers),
                PayDto.class
        ).getBody();

        return body;
    }

    // 0: 성공, 1: 실패
    @Transactional
    public PaymentResHandleFailDto requestFail(String errorCode, String orderId) {
        Pay pay = payRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("주문아이디 없음"));

        pay.setPaySuccessYn("N");

        String errorMsg;
        if ("1".equals(errorCode)) {
            errorMsg = "fail";
        } else {
            errorMsg = "success";
        }
        pay.setPayFailReason(errorMsg);

        payRepository.save(pay);
        return PaymentResHandleFailDto.builder()
                .orderId(orderId)
                .errorCode(errorCode)
                .errorMsg(errorMsg)
                .build();
    }

}