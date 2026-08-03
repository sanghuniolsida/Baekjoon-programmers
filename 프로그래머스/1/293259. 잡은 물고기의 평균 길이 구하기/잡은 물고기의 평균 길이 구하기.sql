-- 코드를 작성해주세요
SELECT ROUND(AVG(CASE WHEN LENGTH IS NULL THEN 10 ELSE LENGTH END), 2) AS AVERAGE_LENGTH
FROM FISH_INFO


-- 잡은 물고기의 평균 길이 
-- 소수점 3째자리에서 반올림, 10CM이하는 10CM로 취급해서 평균 계산하기 