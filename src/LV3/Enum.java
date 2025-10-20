package LV3;

    // Enum을 활용한 사칙연산 관리
public class Enum {
    public  enum Operator{    //Operator라는 부호를 묶기 위한 enum 선언
        PLUS('+'),            // 부호들 enum안에 묶음 설정
        MINUS('-'),
        MULTPLY('*'),
        DIVIDE('/');

        private char operator;

        //생성자
        Operator(char operator) {
            this.operator = operator;
        }

        //기능
        //실제 내부의 부호를 쓰기 위한 getter 활용
        public char getOperator() {
        return operator;}
    }
};
