use scott;
SELECT * FROM emp;
SELECT * FROM dept;

-- 1. 'ACCOUNTING' 부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오.
SELECT ename, sal, HIREDATE FROM emp 
WHERE deptno = (SELECT deptno FROM dept WHERE dname = 'ACCOUNTING');

-- 2. 'TURNER'와 같은 부서에서 근무하는 직원의 이름과 부서번호를 조회하시오.
SELECT ename, deptno FROM emp 
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'TURNER');

-- 3. 10번 부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서번호, 급여를 조회하시오.
SELECT ename, deptno, sal FROM emp 
WHERE sal > (SELECT AVG(sal) FROM emp GROUP BY deptno HAVING deptno = 10);

-- 4. King에게 보고하는 모든 사원의 이름과 급여를 표시하시오. 사원의 이름은 직원으로 Alias를 부여하시오
SELECT ename 직원, sal 급여 FROM emp 
WHERE mgr = (SELECT empno FROM emp WHERE ename = 'King');

-- 5. 평균 급여보다 많은 급여를 받고 이름에 u가 포함된 사원과 같은 부서에서 근무하는 모든 사원의 사원 번호, 이름 및 급여를 표시하시오
SELECT empno, ename, sal FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp) 
and deptno = (SELECT deptno FROM emp WHERE ename like '%u%');

-- 6. 평균 급여보다 높고 최대 급여보다 낮은 월급을 받는 사원의 정보를 조회하시오
SELECT * FROM emp 
WHERE sal > (SELECT AVG(sal) FROM emp)
AND sal < (SELECT MAX(sal) FROM emp);