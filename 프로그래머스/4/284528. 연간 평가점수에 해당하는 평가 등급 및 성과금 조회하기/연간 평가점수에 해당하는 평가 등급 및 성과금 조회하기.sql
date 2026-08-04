-- 코드를 작성해주세요

SELECT A.EMP_NO,A.EMP_NAME,	B.GRADE, (A.SAL * (CASE WHEN B.GRADE = 'S' THEN 0.2
                                              WHEN B.GRADE = 'A' THEN 0.15
                                              WHEN B.GRADE = 'B' THEN 0.1
                                              ELSE 0 END)) AS BONUS
FROM HR_EMPLOYEES AS A JOIN (SELECT EMP_NO,     
       CASE WHEN AVG(SCORE) >= 96 THEN 'S'
       WHEN AVG(SCORE) >= 90 AND AVG(SCORE) < 96 THEN 'A'
       WHEN AVG(SCORE) >= 80 AND AVG(SCORE) < 90 THEN 'B'
       ELSE 'C' END AS GRADE
       FROM HR_GRADE
       GROUP BY EMP_NO) AS B ON A.EMP_NO = B.EMP_NO
       
ORDER BY EMP_NO ASC