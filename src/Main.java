import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //계산기 기능을 구현할 콘솔창을 띄우기
        Scanner scan = new Scanner(System.in);
        //시스템에 입력을 할 수 있는 Scanner라는 객체를 새로 만들어서 scan 이라는 변수에 담겠다.

        while (true) {
            System.out.print("첫 번째 숫자 입력: ");
            int num1 = scan.nextInt();

            System.out.print("기호를 입력: ");
            char gh = scan.next().charAt(0);
            //문자열이 아닌 문자이기에 char을 사용, 이후 문자열의 ()번째를 추출하는 객체인 charAt()를 사용.

            System.out.print("두 번째 숫자 입력: ");
            int num2 = scan.nextInt();

            int result = 0;

            //콘솔을 통해 입력된 숫자가 실제 계산되기 위한 기능 구현(switch.ver)
            switch (gh) {
                case '+':
                    result = num1 + num2;break;
                case '-':
                    result = num1 - num2;break;
                case '*':
                    result = num1 * num2;break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("분모에는 0이 들어갈 수 없습니다.");
                    }
                    result = num1 / num2;break;
                default:
                    System.out.println("잘못된 연산자 입니다.");
            }

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? 원하지 않을 경우 입력: [exit]");
            String answer = scan.next();

            if (answer.equals("exit")) {
                System.out.println("종료하겠습니다");
                break;
            } else {
                continue;
            }
        }
    }
}


//        String tex = scan.next();
//        if(tex.equals("exit")) {
//            System.out.println("종료하겠습니다.");
//            break;
//        }
//        int num1 = Integer.parseInt(tex);

//콘솔을 통해 입력된 숫자가 실제 계산되기 위한 기능 구현(if.ver)
//        if (gh == '+') {
//            result = num1 + num2;
//        } else if (gh == '-') {
//            result = num1 - num2;
//        } else if (gh == '*') {
//            result = num1 * num2;
//        } else if (gh == '/') {
//            if (num2 == 0) {
//                System.out.println("나눗셈에 분모가 0이될 수는 없습니다.");
//                return;
//            } else {
//                result = num1 / num2;
//            }
//        }
