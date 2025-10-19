package LV3;

public class Enum {
    public  enum Operator{
        PLUS('+'),
        MINUS('-'),
        MULTPLY('*'),
        DIVIDE('/');

        private char operator;

        Operator(char operator) {
            this.operator = operator;
        }
        public char getOperator() {
        return operator;}
    }
};
