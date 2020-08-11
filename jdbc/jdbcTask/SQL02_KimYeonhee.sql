-- ★ 모든 SQL문은 EMP 테이블에서 검색합니다.
SELECT * FROM emp;

-- 1. 이름이 'adams' 인 직원의 급여와 입사일을 조회하시오.
SELECT sal 급여, hiredate 입사일 FROM emp WHERE ename = 'adams';

-- 2. 7년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무 년차를 조회하시오.
SELECT ename 이름, hiredate 입사일, sal 급여, floor(datediff(curdate(), hiredate)/365) 근무년차
FROM emp
WHERE floor(datediff(curdate(), hiredate)/365) >= 7;
-- WHERE 근무년차 >= 7 이렇게 못 씀. Alias가 WHERE절에는 못 옴.

-- 3. 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력 되도록 하시오
SELECT deptno 부서, COUNT(empno) 인원수 
FROM emp 
group by deptno 
having COUNT(empno) >= 5;
-- Primary Key인 empno를 인자로 넣어주는 게 좋음.

-- 4. 각 부서별 최대급여와 최소급여를 조회하시오. 
-- 단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기 때문에 조회결과에서 제외시킨다.
SELECT deptno, MAX(sal), MIN(sal) 
FROM emp 
GROUP BY deptno 
having MAX(sal) != MIN(sal);
-- having MAX(sal) <> MIN(sal); <>도 같지 않다는 의미.

-- 5. 10,20 번 부서에 속해있으면서 급여가 2000 이상인 
-- 직원의 이름, 급여, 업무, 부서번호를 조회하시오.
SELECT ename, sal, job, deptno 
FROM emp 
WHERE deptno IN(10, 20) and sal >= 2000 
ORDER BY deptno, sal;

-- 6. 1981년대에 입사해서 10, 20, 30 번 부서에 속해있으면서, 
-- 급여를 1500 이상 3000 이하를 받는 직원을 조회하시오.
-- 단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며,
-- 먼저 입사한 직원이 먼저 출력되어야 하며 입사일이 같은 경우 급여가
-- 많은 직원이 먼저 출력 되도록 하시오.
SELECT * FROM emp 
WHERE year(HIREDATE) LIKE '%81' 
-- LIKE 연산자. %81 ==> #81이든 ##81이든 찾음.
AND deptno IN(10, 20, 30) 
AND sal between 1500 and 3000
AND comm is not null
order by hiredate, sal desc;

-- 7. 부서가 10,20,30 번인 직원들 중에서 급여를 1500 이상 3000 이하를 받는
-- 직원들을 대상으로 부서별 평균 급여를 조회하시오.
-- 단, 평균급여가 2000 이상인 부서만 출력되어야 하며,
-- 출력결과를 평균급여가 높은 부서 먼저 출력되도록 해야 한다
SELECT deptno, avg(sal)
from emp 
WHERE deptno IN(10, 20, 30) 
AND sal between 1500 and 3000
group by deptno
having avg(sal) >= 2000
order by 2 desc; 
-- SELECT deptno, avg(sal)에서
-- 1하면 deptno 2하면 avg(sal)을 가리킴.
-- 그래서 2를 내림차순으로 정렬 == avg(sal)을 내림차순으로 정렬