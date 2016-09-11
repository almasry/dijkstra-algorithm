package com.thoughtworks.trains.ProblemDomain;

import com.thoughtworks.trains.Exception.RouteNotFoundException;
import com.thoughtworks.trains.ProblemDomain.Algorithm.DijkstraAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubProblemsTest {

    private SubProblems subpProblems;

    @Before
    public void setUp() throws Exception {

        Solution solution = new Solution(
                "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7",
                DijkstraAlgorithm.class
        );

        this.subpProblems = new SubProblems(solution);
    }

    @Test
    public void solveSubProblem1() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem1(), 9);
    }

    @Test
    public void solveSubProblem2() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem2(), 5);

    }

    @Test
    public void solveSubProblem3() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem3(), 13);
    }

    @Test
    public void solveSubProblem4() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem4(), 22);
    }

    @Test (expected = RouteNotFoundException.class)
    public void solveSubProblem5() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem5(), 100);
    }

    @Test
    public void solveSubProblem6() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem6(), 2);
    }

    @Test
    public void solveSubProblem7() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem7(), 2);
    }

    @Test
    public void solveSubProblem8() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem8(), 9);
    }

    @Test
    public void solveSubProblem9() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem9(), 9);
    }

    @Test
    public void solveSubProblem10() throws Exception {

        assertEquals(this.subpProblems.solveSubProblem10(), 7);
    }

}