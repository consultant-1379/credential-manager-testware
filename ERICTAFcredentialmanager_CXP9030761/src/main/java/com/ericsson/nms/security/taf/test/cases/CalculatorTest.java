package com.ericsson.nms.security.taf.test.cases;

import com.ericsson.cifwk.taf.TestCase;
import com.ericsson.cifwk.taf.TestExecutionHelper;
import com.ericsson.cifwk.taf.TorTestCaseHelper;
import com.ericsson.cifwk.taf.annotations.Context;
import com.ericsson.cifwk.taf.annotations.DataDriven;
import com.ericsson.cifwk.taf.annotations.Input;
import com.ericsson.cifwk.taf.annotations.Output;
import com.ericsson.cifwk.taf.guice.OperatorRegistry;
import com.ericsson.nms.security.taf.test.operators.CalculatorOperator;
import org.testng.annotations.Test;
import se.ericsson.jcat.fw.BaseSUT;
import se.ericsson.jcat.fw.EventThreadPool;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class CalculatorTest extends TorTestCaseHelper implements TestCase {

    @Inject
    OperatorRegistry<CalculatorOperator> operatorRegistry;

    @Context(context = {Context.CLI, Context.API, Context.REST, Context.UI})
    @Test
    public void shouldProvideOperatorsBasedOnContext() {
        String currentContext = TestExecutionHelper.getCurrentContext();
        CalculatorOperator calc = operatorRegistry.provide(CalculatorOperator.class);
        assertEquals(currentContext,calc.getName());
    }

    @Context(context = {Context.CLI, Context.API, Context.REST, Context.UI})
    @DataDriven(name = "ERICTAFmodulename_CXPxxxxxxxx.calculator")
    @Test
    public void shouldSum(@Input("x") int x, @Input("y") int y, @Output("sum") int expected) {
        CalculatorOperator calc = operatorRegistry.provide(CalculatorOperator.class);
        assertEquals(expected,calc.sum(x,y));
    }

    @Context(context = {Context.CLI, Context.API, Context.REST, Context.UI})
    @DataDriven(name = "ERICTAFmodulename_CXPxxxxxxxx.calculator")
    @Test
    public void shouldSubtract(@Input("x") int x, @Input("y") int y, @Output("subtraction") int expected) {
        CalculatorOperator calc = operatorRegistry.provide(CalculatorOperator.class);
        assertEquals(expected,calc.subtraction(x,y));
    }

    @Context(context = {Context.CLI, Context.API, Context.REST, Context.UI})
    @DataDriven(name = "ERICTAFmodulename_CXPxxxxxxxx.calculator")
    @Test
    public void shouldDivide(@Input("x") int x, @Input("y") int y, @Output("divide") int expected) {
        CalculatorOperator calc = operatorRegistry.provide(CalculatorOperator.class);
        assertEquals(expected,calc.divide(x,y));
    }

    @Context(context = {Context.CLI, Context.API, Context.REST, Context.UI})
    @DataDriven(name = "ERICTAFmodulename_CXPxxxxxxxx.calculator")
    @Test
    public void shouldMultiply(@Input("x") int x, @Input("y") int y, @Output("multiply") int expected) {
        CalculatorOperator calc = operatorRegistry.provide(CalculatorOperator.class);
        assertEquals(expected,calc.multiply(x,y));
    }

}
