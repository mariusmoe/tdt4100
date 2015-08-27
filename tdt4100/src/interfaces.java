//RPNCalcProgram, RPNOperator og diverse operator-implementasjoner
//Published 3. februar 2015 by Trætteberg, Hallvard
//package interfaces;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.BinaryOperator;
public class interfaces {
    // operand-stacken
    private Stack<Double> operands;
    // liste av RPNOperator-instanser
    // Spørsmålet er: Hvilke metoder trenger RPNOperator-grensesnittet?
    private List<RPNOperator> operators;
    
    public void init() {
        // initialiserer operand-stacken med to verdier
        operands = new Stack<Double>();
        operands.push(7.0);
        operands.push(5.0);
        operators = Arrays.asList(
                new PlusOperator(),
                new MinusOperator(),
                new SwapOperator(),
                new BinOp("/", (op1, op2) -> op1 / op2),                
                new BinOp("*", new BinaryOperator<Double>() {
                    @Override
                    public Double apply(Double op1, Double op2) {
                        return op1 * op2;
                    }
                })
        );
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(operands);
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                operands.push(scanner.nextDouble());
            } else {
                String token = scanner.next();
                for (int i = 0; i < operators.size(); i = i + 1) {
                    RPNOperator rpnOperator = operators.get(i);
                    if (token.equals(rpnOperator.getOperatorName())) {
                        rpnOperator.performOperation(operands);
                        break;
                    }
                }
            }
            System.out.println(operands);
        }
        scanner.close();
    }
    public static void main(String[] args) {
        RPNCalcProgram program = new RPNCalcProgram();
        program.init();
        program.run();
    }
}
 
package interfaces;
import java.util.Stack;
public interface RPNOperator {
    public String getOperatorName();
    public void performOperation(Stack<Double> operands);
}
 
package interfaces;
import java.util.Stack;
public class PlusOperator implements RPNOperator {
    @Override
    public String getOperatorName() {
        return "+";
    }
    @Override
    public void performOperation(Stack<Double> operands) {
        double op2 = operands.pop(), op1 = operands.pop();
        operands.push(op1 + op2);
    }
}
package interfaces;
import java.util.Stack;
public class MinusOperator implements RPNOperator {
    @Override
    public String getOperatorName() {
        return "-";
    }
    @Override
    public void performOperation(Stack<Double> operands) {
        double op2 = operands.pop(), op1 = operands.pop();
        operands.push(op1 - op2);
    }
}
package interfaces;
import java.util.Stack;
public class SwapOperator implements RPNOperator {
    @Override
    public String getOperatorName() {
        return "~";
    }
    @Override
    public void performOperation(Stack<Double> operands) {
        double op2 = operands.pop(), op1 = operands.pop();
        operands.push(op2);
        operands.push(op1);
    }
}

import java.util.Stack;
import java.util.function.BinaryOperator;
public class BinOp implements RPNOperator {
    private String operatorName;
    private BinaryOperator<Double> op;
    
    public BinOp(String operatorName, BinaryOperator<Double> op) {
        this.operatorName = operatorName;
        this.op = op;
    }
    @Override
    public String getOperatorName() {
        return operatorName;
    }
    @Override
    public void performOperation(Stack<Double> operands) {
        double op2 = operands.pop(), op1 = operands.pop();
        double result = op.apply(op1, op2);
        operands.push(result);
    }
}

import java.util.function.BinaryOperator;
public class MultOperator implements BinaryOperator<Double> {
    @Override
    public Double apply(Double op1, Double op2) {
        return op1 * op2;
    }
}
 
