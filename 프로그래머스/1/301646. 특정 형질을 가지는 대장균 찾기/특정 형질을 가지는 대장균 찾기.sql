-- 코드를 작성해주세요
SELECT COUNT(ID) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0 AND ((GENOTYPE & 1) <> 0 OR (GENOTYPE & 4) <> 0)

/*
2번 형질이 보유하지 않으면서 1번이나 3번 형질을 보유하고 있는 대장균의 수를 출력.
*/