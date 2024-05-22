insert into user (email,password,nickname,phone,birthdate,resign,loginstate,role) values
('abc@naver.com','abc123!','닉네임','01011111111','000101','N','Y','USER'),
('aaa@naver.com','abc123!','고죠사토루','01011111111','990101','N','Y','USER'),
('bbb@naver.com','abc123!','고길동','01011111111','990101','N','Y','USER'),
('ccc@naver.com','abc123!','프리렌','01011111111','990101','N','Y','USER'),
('ddd@naver.com','abc123!','토토로','01011111111','990101','N','Y','ADMIN'),
('eee@naver.com','abc123!','숲튽훈','01011111111','990101','N','Y','SUPERADMIN');

INSERT INTO menu (category, name, menu_ename, menu_price, menu_explain, price_ice, price_shot, price_cream, menu_imgurl, status)
VALUES
    ('goods', 'JNO 하우스 보온병', 'JNO House Thermos', 5000, '고급스러운 디자인의 보온병', 200, 500, 500, 'image/상품/보온병/JNO 하우스 보온병.jpg', 1),
    ('goods', '스탠리 하우스 보온병', 'Stanley House Thermos', 5000, '견고한 스탠리 브랜드 보온병',200, 500, 500, 'image/상품/보온병/스탠리 하우스 보온병.jpg', 1),
    ('goods', 'JNM 하우스 보온병', 'JNM House Thermos', 5000, '실용적인 JNM 브랜드 보온병',200, 500, 500, 'image/상품/보온병/JNM 하우스 보온병.jpg', 1),
    ('goods', 'JNX 그린 워드마크 보온병', 'JNX Green Wordmark Thermos', 5000, '그린 색상 로고 보온병',200, 500, 500, 'image/상품/보온병/JNX 그린 워드마크 보온병.jpg', 1),
    ('goods', 'SS 블랙 앤 골드 스탠리 보온병', 'SS Black and Gold Stanley Thermos', 5000, '블랙과 골드 조합의 보온병',200, 500, 500, 'image/상품/보온병/SS 블랙 앤 골드 스탠리 보온병.jpg', 1),
    ('goods', '리유저블 & 글라스 세트', 'Reusable & Glass Set', 5000, '재사용 가능한 유리 세트',200, 500, 500, 'image/상품/선물세트/리유저블 & 글라스 세트.jpg', 1),
    ('goods', '리유저블 & 머그 세트', 'Reusable & Mug Set', 5000, '재사용 가능한 머그 세트',200, 500, 500, 'image/상품/선물세트/리유저블 & 머그 세트.jpg', 1),
    ('goods', '우리 쌀 파우더', 'Our Rice Powder', 5000, '국내산 쌀로 만든 파우더',200, 500, 500, 'image/상품/선물세트/우리 쌀 파우더.jpg', 1),
    ('goods', '우리 쑥 파우더', 'Our Mugwort Powder', 5000, '국내산 쑥으로 만든 파우더',200, 500, 500, 'image/상품/선물세트/우리 쑥 파우더.jpg', 1),
    ('goods', 'SS 그린 사이렌 케틀', 'SS Green Siren Kettle', 5000, '그린 색상 사이렌 디자인 케틀',200, 500, 500, 'image/상품/커피 용품/SS 그린 사이렌 케틀.jpg', 1),
    ('goods', '사이렌 고케틀', 'Siren Go Kettle', 5000, '고급스러운 사이렌 디자인 케틀',200, 500, 500, 'image/상품/커피 용품/사이렌 고케틀.jpg', 1),
    ('goods', '사이렌 레버 드리퍼', 'Siren Lever Dripper', 5000, '레버 방식의 사이렌 드리퍼',200, 500, 500, 'image/상품/커피 용품/사이렌 레버 드리퍼.jpg', 1),
    ('goods', '사이렌 밀크포머&컵', 'Siren Milk Frother & Cup', 5000, '밀크포머와 컵 세트',200, 500, 500, 'image/상품/커피 용품/사이렌 밀크포머&컵.jpg', 1),
    ('goods', '우드 핸들 글라스 서버', 'Wood Handle Glass Server', 5000, '나무 손잡이의 유리 서버',200, 500, 500, 'image/상품/커피 용품/우드 핸들 글라스 서버.jpg', 1),
    ('goods', '크림 컴프레소', 'Cream Compressed Coffee', 5000, '진한 크림의 컴프레소',200, 500, 500, 'image/상품/커피 용품/크림 컴프레소.jpg', 1),
    ('beverage', '라이트 핑크 자몽 피지오', 'Light Pink Grapefruit Phizzo', 5000, '핑크 자몽 맛 음료',200, 500, 500, 'image/음료/스타벅스 피지오/라이트 핑크 자몽 피지오.jpg', 1),
    ('beverage', '레드 애플 피지오', 'Red Apple Phizzo', 5000, '상큼한 레드 애플 맛 음료',200, 500, 500, 'image/음료/스타벅스 피지오/레드 애플 피지오.jpg', 1),
    ('beverage', '아이스크림 레드 애플 피지오', 'Ice Cream Red Apple Phizzo', 5000, '아이스크림과 애플 음료',200, 500, 500, 'image/음료/스타벅스 피지오/아이스크림 레드 애플 피지오.jpg', 1),
    ('beverage', '여수 바다 자몽 피지오', 'Yeosu Sea Grapefruit Phizzo', 5000, '여수 바다를 닮은 자몽 음료',200, 500, 500, 'image/음료/스타벅스 피지오/여수 바다 자몽 피지오.jpg', 1),
    ('beverage', '유자 패션 피지오', 'Yuzu Passion Phizzo', 5000, '유자와 패션후르츠 맛 음료',200, 500, 500, 'image/음료/스타벅스 피지오/유자 패션 피지오.jpg', 1),
    ('beverage', '제주팔삭 셔벗 피지오', 'Jeju Palshark Sherbet Phizzo', 5000, '제주 특산 셔벗 음료',200, 500, 500, 'image/음료/스타벅스 피지오/제주팔삭 셔벗 피지오.jpg', 1),
    ('beverage', '제주팔삭 피지오', 'Jeju Palshark Phizzo', 5000, '제주산 팔삭 과일 음료',200, 500, 500, 'image/음료/스타벅스 피지오/제주팔삭 피지오.jpg', 1),
    ('beverage', '쿨 라임 피지오', 'Cool Lime Phizzo', 5000, '시원한 라임 맛 음료',200, 500, 500, 'image/음료/스타벅스 피지오/쿨 라임 피지오.jpg', 1),
    ('beverage', '피치 딸기 피지오', 'Peach Strawberry Phizzo', 5000, '복숭아와 딸기 맛 음료',200, 500, 500, 'image/음료/스타벅스 피지오/피치 딸기 피지오.jpg', 1),
    ('beverage', '라벤더 카페 브레베', 'Lavender Cafe Breve', 5000, '라벤더 향의 브레베',200, 500, 500, 'image/음료/에스프레소/라벤더 카페 브레베.png', 1),
    ('coffee', '바닐라 빈 라떼', 'Vanilla Bean Latte', 5000, '바닐라 빈을 넣은 라떼',200, 500, 500, 'image/음료/에스프레소/바닐라 빈 라떼.jpg', 1),
    ('coffee', '바닐라 플랫 화이트', 'Vanilla Flat White', 5000, '부드러운 바닐라 플랫 화이트',200, 500, 500, 'image/음료/에스프레소/바닐라 플랫 화이트.jpg', 1),
    ('coffee', '사케라또 아포가토', 'Shakerato Affogato', 5000, '에스프레소를 부은 아이스크림',200, 500, 500, 'image/음료/에스프레소/사케라또 아포가토.jpg', 1),
    ('coffee', '슈크림 라떼', 'Cream Puff Latte', 5000, '크림이 듬뿍 들어간 라떼',200, 500, 500, 'image/음료/에스프레소/슈크림 라떼.jpg', 1),
    ('coffee', '스타벅스 돌체 라떼', 'Starbucks Dolce Latte', 5000, '달콤한 스타벅스 돌체 라떼',200, 500, 500, 'image/음료/에스프레소/스타벅스 돌체 라떼.jpg', 1),
    ('coffee', '스파클링 시트러스 에스프레소', 'Sparkling Citrus Espresso', 5000, '탄산과 시트러스 맛 에스프레소',200, 500, 500, 'image/음료/에스프레소/스파클링 시트러스 에스프레소.jpg', 1),
    ('coffee', '에스프레소', 'Espresso', 5000, '진한 에스프레소 커피',200, 500, 500, 'image/음료/에스프레소/에스프레소.jpg', 1),
    ('coffee', '카라멜 마키아또', 'Caramel Macchiato', 5000, '카라멜 시럽이 들어간 마키아또',200, 500, 500, 'image/음료/에스프레소/카라멜 마키아또.jpg', 1),
    ('coffee', '콜드브루 마키아또', 'Cold Brew Macchiato', 5000, '콜드브루 커피와 마키아또',200, 500, 500, 'image/음료/에스프레소/콜드브루 마키아또.jpg', 1),
    ('coffee', '크리미 바닐라 마키아또', 'Creamy Vanilla Macchiato', 5000, '크리미한 바닐라 맛 마키아또',200, 500, 500, 'image/음료/에스프레소/크리미 바닐라 마키아또.jpg', 1),
    ('coffee', '탄산 콜드브루', 'Sparkling Cold Brew', 5000, '탄산이 첨가된 콜드브루 커피',200, 500, 500, 'image/음료/에스프레소/탄산 콜드브루.jpg', 1),
    ('coffee', '토피넛 라떼', 'Toffee Nut Latte', 5000, '토피넛 향이 풍부한 라떼',200, 500, 500, 'image/음료/에스프레소/토피넛 라떼.jpg', 1);

INSERT INTO home_ad (ad_head, ad_content, ad_upload_time, ad_due_date, image_url, banner_image_url) VALUES
('이벤트1', '혜택1', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'image/HomeEvent/2024-03-28 4월 프로모션.jpg', 'image/HomeEvent/2024-03-28 4월 프로모션-1.jpg'),
('이벤트2', '혜택2', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'image/HomeEvent/2024-04-18 제주 지역 리유저블 컵 이벤트.jpg', 'image/HomeEvent/2024-04-18 제주 지역 리유저블 컵 이벤트-1.jpg');

INSERT into recommend (menu_category,menu_name,menu_ename,menu_price,menu_explain,menu_image_url) VALUES
('beverage', '제주팔삭 셔벗 피지오', 'Jeju Palshark Sherbet Phizzo', 5000, '제주 특산 셔벗 음료','image/음료/스타벅스 피지오/제주팔삭 셔벗 피지오.jpg'),
('beverage', '제주팔삭 피지오', 'Jeju Palshark Phizzo', 5000, '제주산 팔삭 과일 음료','image/음료/스타벅스 피지오/제주팔삭 피지오.jpg'),
('coffee', '바닐라 빈 라떼', 'Vanilla Bean Latte', 5000, '바닐라 빈을 넣은 라떼','image/음료/에스프레소/바닐라 빈 라떼.jpg'),
('coffee', '카페 라떼', 'Cafe Latte', 5000, '부드러운 우유가 들어간 라떼','image/음료/에스프레소/카페 라떼.jpg'),
('coffee', '카페 모카', 'Cafe Mocha', 5000, '초콜릿 시럽과 에스프레소가 들어간 모카','image/음료/에스프레소/카페 모카.jpg'),
('coffee', '카푸치노', 'Cappuccino', 5000, '거품 많은 이탈리아식 커피','image/음료/에스프레소/카푸치노.jpg'),
('beverage', '잉글리쉬 브렉퍼스트 티', 'English Breakfast Tea', 5000, '전통적인 영국식 아침 티','image/음료/티(티바나)/잉글리쉬 브렉퍼스트 티.jpg'),
('food', '꿀 고구마 생크림 케이크', 'Honey Sweet Potato Fresh Cream Cake', 5000, '고구마 생크림 케이크','image/푸드/케이크/꿀 고구마 생크림 케이크.jpg'),
('food', '딸기 생크림 케이크', 'Strawberry Fresh Cream Cake', 5000, '딸기가 들어간 생크림 케이크','image/푸드/케이크/딸기 생크림 케이크.jpg'),
('food', '딸기 초코 쏙 생크림 케이크', 'Strawberry Chocolate Fresh Cream Cake', 5000, '딸기와 초코 생크림 케이크','image/푸드/케이크/딸기 초코 쏙 생크림 케이크.jpg');

INSERT INTO store (name, address, phone, open, close, holiday, status)
VALUES
    ('Store 1', 'Address 1', '1234567890', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 2', 'Address 2', '1234567891', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 3', 'Address 3', '1234567892', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 4', 'Address 4', '1234567893', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 5', 'Address 5', '1234567894', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 6', 'Address 6', '1234567895', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 7', 'Address 7', '1234567896', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 8', 'Address 8', '1234567897', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 9', 'Address 9', '1234567898', '09:00', '18:00', 'Sunday', 'Open'),
    ('Store 10', 'Address 10', '1234567899', '09:00', '18:00', 'Sunday', 'Open');
