SELECT CAR_TYPE, COUNT(CAR_ID) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%가죽시트%' OR OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%열선시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE


/*
자동차 종류 별로
통풍시트, 열선시트, 가죽시트 중 하나 이상 옵션이 있는 자동차가 몇대인지

정렬 기준: 자동차 종류 오름차순
*/