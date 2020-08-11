-- ★ 모든 SQL문은 EMP 테이블에서 검색합니다.
SELECT * FROM emp;

-- 1. 급여가 1500 이상인 직원들의 이름, 급여, 부서번호를 조회하시오.
SELECT ename, sal, deptno FROM emp WHERE sal >= 1500;

-- 2. 직원 중에서 연봉이 2000 이상인 직원들의 이름, 연봉을 조회하시오.
SELECT ename, sal*12+IFNULL(comm, 0) FROM emp 
WHERE sal*12+IFNULL(comm, 0) >= 2000; 

-- 3. 직원 중에서 comm이 없는 직원의 이름과 급여, 업무, comm를 조회하시오.
SELECT ename, sal, job, comm FROM emp WHERE comm IS NULL;

-- 4. 입사한지 가장 오래된 직원 순으로 5명을 조회하시오.
SELECT * FROM emp ORDER BY hiredate ASC LIMIT 1, 5;

-- 5. 1981년에 입사한 직원들 중에서 급여가 1500 이상 2500 이하인 직원들의 이름,
-- 급여, 부서번호,입사일을 조회하시오.
SELECT ename, sal, deptno, hiredate FROM emp 
WHERE YEAR(hiredate) = 1981 AND sal >= 1500 AND sal <= 2500;

-- 6. 이름이 A로 시작하는 직원의 이름, 급여, 입사일을 조회하시오.
SELECT ename, sal, hiredate FROM emp WHERE ename LIKE 'a%';

-- 7. 05월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
SELECT ename, sal, hiredate FROM emp WHERE MONTH(hiredate) = 5;

-- 8. 세 번째 이름에 A 가 들어간 직원의 이름, 급여, 입사일을 조회하시오.
SELECT ename, sal, hiredate FROM emp WHERE ename LIKE '__a%';

-- 9. 이름이 K로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.
SELECT ename, sal, hiredate FROM emp WHERE ename LIKE '%k';

-- 10. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.
SELECT ename, comm, sal FROM emp WHERE comm IS NOT NULL;