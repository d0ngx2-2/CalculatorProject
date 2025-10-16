import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //Calculator 객체를 생성

        //계산기 기능을 구현할 콘솔창을 띄우기
        Scanner scan = new Scanner(System.in);
        //시스템에 입력을 할 수 있는 Scanner라는 객체를 새로 만들어서 scan 이라는 변수에 담겠다.

        System.out.print("첫 번째 숫자를 입력해주세요.: ");
        int num1 = scan.nextInt();    //입력된 첫번째 숫자를 저장

        //계산을 이어나가기 위해 부호 입력부터 반복하도록 while문 사용
        while (true) {      //반복문 내용이 true일 시 지속 반복
            System.out.print("기호를 입력해주세요.: ");
            char gh = scan.next().charAt(0);
            //문자열이 아닌 문자이기에 char을 사용, 이후 문자열의 ()번째를 추출하는 객체인 charAt()를 사용.

            System.out.print("두 번째 숫자를 입력해주세요.: ");
            int num2 = scan.nextInt(); //입력된 두번째 숫자를 저장

            Integer result = calculator.resultNum(num1, num2, gh);
            ArrayList<Integer> resultList = calculator.getResultList();


            if (result == null) {
                continue;
            }


            System.out.println("결과: " + result);
            // 결과 값 출력
            System.out.println("저장된 결과 : " + resultList);
            // 결과값을 배열 형태로 출력

            num1 = result;
            // 계산에 이어가기 위한 결과값 첫번째 넣어주기

            //이후 진행여부 확인
            System.out.println("원하시는 진행숫자를 입력해 주세요.[]");
            System.out.println("1.이어서 계산\n2.저장값 수정\n3.저장 값 제거\n4.종료");
            int allAnswer = scan.nextInt();

            //각 숫자 입력시 실행되는 기능
            // 1번 이어서 계산하도록 continue
            if (allAnswer == 1) {
                continue;
            }

            //
            if (allAnswer == 2) {
                System.out.println("몇번째 값을 수정하시겠습니까?(순서는 0부터시작입니다.)");
                int index = scan.nextInt();


                System.out.println("수정될 값을 입력해주세요");
                int newnum = scan.nextInt();


                calculator.setResultList(index, newnum);
                System.out.println("수정된 저장값 = " + resultList);
            }

            if (allAnswer == 3) {
                calculator.removeResult();
                System.out.println("수정된 저장값 = " + resultList);
            }




            //종료를 위한 입력
            if (allAnswer == 4) {
                System.out.println("exit를 입력해주세요.");
            // if문을 통해 while 구문에서 exit 입력 시 종료할 수 있도록 break 기능 사용
                String answer = scan.next();
                if (answer.equals("exit")) {
                    System.out.println("종료하였습니다");
                    break;
                }
            }
        }
    }
}