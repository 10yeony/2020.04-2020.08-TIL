-- 모든 SQL문은 EMP, DEPT 테이블에서 검색합니다.
SELECT * FROM emp;
SELECT * FROM dept;

-- 1. 'ACCOUNTING‘ 부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오. 
-- ( 조건  join 사용 )
SELECT ename, sal, hiredate FROM emp, dept 
WHERE emp.deptno = dept.deptno AND dname = 'ACCOUNTING';

-- 2. 직원의 이름과 관리자 이름을 조회하시오.
SELECT e.ename 직원, m.ename 관리자 
FROM (SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;
 
-- 3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오.
-- 단, 관리 직원수가 3명 이상인 관리자만 출력되도록 하시오.
SELECT a.ename 관리자이름, b.num 직원수
FROM 
(SELECT DISTINCT empno, ename FROM (SELECT mgr FROM emp) e, (SELECT empno, ename FROM emp) m) a,
(SELECT mgr, COUNT(*) num FROM emp GROUP BY mgr HAVING mgr IS NOT NULL) b
WHERE a.empno = mgr AND b.num >= 3;