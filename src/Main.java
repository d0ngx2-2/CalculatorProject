import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //계산기 기능을 구현할 콘솔창을 띄우기
        Scanner scan = new Scanner(System.in);
        //시스템에 입력을 할 수 있는 Scanner라는 객체를 새로 만들어서 scan 이라는 변수에 담겠다.

        System.out.print("첫 번째 숫자 입력: ");
        int num1 = scan.nextInt();    //입력된 첫번째 숫자를 저장

        //계산을 이어나가기 위해 부호 입력부터 반복하도록 while문 사용
        while (true) {      //반복문 내용이 true일 시 지속 반복
            System.out.print("기호를 입력: ");
            char gh = scan.next().charAt(0);
            //문자열이 아닌 문자이기에 char을 사용, 이후 문자열의 ()번째를 추출하는 객체인 charAt()를 사용.

            System.out.print("두 번째 숫자 입력: ");
            int num2 = scan.nextInt(); //입력된 두번째 숫자를 저장

            int result = 0;

            //콘솔을 통해 입력된 숫자가 실제 계산되기 위한 기능 구현(switch.ver)
            // switch문을 통해 각 부호 입력 시 실행되는 기능 작성
            switch (gh) {
                case '+':
                    result = num1 + num2;break;
                case '-':
                    result = num1 - num2;break;
                case '*':
                    result = num1 * num2;break;
                case '/':
                    if (num2 == 0) {    //if문을 통해 나눗셈에 분모 0이 들어갈 시 다음 문구가 나오도록 기능 작성
                        System.out.println("분모에는 0이 들어갈 수 없습니다.");
                    }
                    result = num1 / num2;break;
                default:     //위 사칙연산 부호 외 다른 것이 입력 시 아래 문구가 나오도록 기능 작성
                    System.out.println("잘못된 연산자 입니다.");
            }

            System.out.println("결과: " + result);
            // 결과 값을 보여주기

            num1 = result;
            // 나온 결과 값을 다음 계산에 이어가기 위해 첫번째 숫자에 넣어주기

            // if문을 통해 while 구문에서 if조건문을 통해 exit 입력 시 종료할 수 있도록 break 기능 사용
            System.out.println("종료를 원하시면 [exit]를 입력해주세요.");
            String answer = scan.next();

            if (answer.equals("exit")) {
                System.out.println("종료하겠습니다");
                break;
            }
        }
    }
}