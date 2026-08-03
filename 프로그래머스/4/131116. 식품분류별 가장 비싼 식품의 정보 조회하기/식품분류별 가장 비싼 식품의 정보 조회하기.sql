-- 코드를 입력하세요
SELECT CATEGORY, PRICE, PRODUCT_NAME 
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (SELECT A.CATEGORY, MAX(A.PRICE)
                            FROM FOOD_PRODUCT AS A
                            WHERE A.CATEGORY IN('과자', '국', '김치', '식용유')
                            GROUP BY A.CATEGORY)
ORDER BY PRICE DESC

-- 식품분류별 가격이 제일 비싼 식품의 분류, 가격,이름 조회
-- '과자', '국', '김치', '식용유'