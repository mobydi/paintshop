package com.paintshop;

import com.paintshop.models.CaseResult;
import com.paintshop.models.Customer;
import com.paintshop.models.TestCase;
import com.paintshop.models.TestResult;

class Solver {
    static TestResult processTestCase(TestCase testCase) {
        boolean[] solution = new boolean[testCase.getNumColors()];
        Customer[] customers = testCase.getCustomers();
        CaseResult result;

        while ((result = isSolutionSolved(solution, customers)) != CaseResult.Solved) {
            if (result == CaseResult.CannotBeSolved) {
                return new TestResult(testCase.getNumColors(),null);
            }
        }

        return new TestResult(testCase.getNumColors(), solution);
    }

    private static CaseResult isSolutionSolved(boolean[] solution, Customer[] customers)
    {
        CaseResult fixed = CaseResult.Solved;

        for (Customer customer : customers) {
            if (customer.isSolutionSuitable(solution)) {
                continue;
            }

            if (customer.hasMatte()) {
                solution[customer.getMatte()] = true;
                fixed = CaseResult.NotSolved;
            }
            else {
                return CaseResult.CannotBeSolved;
            }
        }
        return fixed;
    }
}
