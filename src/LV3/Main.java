package LV3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //Calculator 객체를 생성

        //계산기 기능을 구현할 콘솔창을 띄우기
        Scanner scan = new Scanner(System.in);
        //시스템에 입력을 할 수 있는 Scanner라는 객체를 새로 만들어서 scan 이라는 변수에 담겠다.

        System.out.print("첫 번째 숫자를 입력해주세요.: ");
        double num1 = scan.nextDouble();//입력된 첫번째 숫자를 저장

        //계산을 이어나가기 위한 부호 입력부터 반복하도록 while문 사용
        while (true) {      //반복문 내용이 true일 시 지속 반복
            System.out.print("기호를 입력해주세요.: ");
            char gh = scan.next().charAt(0);
            //문자열이 아닌 문자이기에 char을 사용, 이후 문자열의 ()번째를 추출하는 객체인 charAt()를 사용.
            double num2 = 0;

            //try-catch문 통해 숫자 외 다른문자 입력 시 오류를 잡고 다시 입력하도록 설정
            try {
                System.out.print("두 번째 숫자를 입력해주세요.: ");
                num2 = scan.nextDouble(); //입력된 두번째 숫자를 저장
            }catch (InputMismatchException e){
                System.out.println("숫자를 다시 입력해주세요");
                scan.next();
                continue; // 숫자 잘못 입력 시 다음 문구와 함께 넘어가 다시 기호부터 설정
            }

            //결과 값을 result에 저장, 결과 값 배열을 resultList에 저장
            Double result = calculator.resultNum(num1, num2, gh);
            ArrayList<Double> resultList = calculator.getResultList();

            //결과 값이 null이 나올경우 건너뛰고 다시 돌아가도록 설정
            if (result == null) {
                continue;
            }

            System.out.println("결과: " + result);
            // 결과 값 출력
            System.out.println("저장된 결과 : " + resultList);
            // 결과값을 배열 형태로 출력

            // 계산에 이어가기 위한 결과값 첫 숫자에 넣어주기
            num1 = result;

            //이후 진행여부 확인
            System.out.println("원하시는 진행숫자를 입력해 주세요.[]");
            System.out.println("1.이어서 계산\n2.저장값 수정\n3.첫번째 저장 값 제거\n4.숫자 필터링\n5.종료");
            int allAnswer = scan.nextInt();

            //각 숫자 입력시 실행되는 기능
            // 1번 이어서 계산하도록 continue
            if (allAnswer == 1) {
                continue;
            }

            // 2번 결과 값 배열 내 숫자 수정하는 기능
            else if (allAnswer == 2) {
                int index;

                while (true) {
                    System.out.println("몇번째 값을 수정하시겠습니까?");
                    index = scan.nextInt(); //수정할 n번째를 입력

                    if (index < 1) {   //index는 0부터 시작이기에 아래 값보다 설정될 경우 오류가 나도록 설정
                        System.out.println("잘못된 순서값입니다. 다시 입력해주세요");
                    } else {
                        break;  //
                    }
                }


                System.out.println("수정될 값을 입력해주세요");
                double newnum = scan.nextInt();

                calculator.setResultList(index, newnum);

                System.out.println("수정된 저장값 = " + resultList);
                System.out.println("이어서 계산 하겠습니다.");
            }

            //첫번째 저장 값을 지우는 remove기능 제거 설정
            else if (allAnswer == 3) {
                calculator.removeResult();
                System.out.println("수정된 저장값 = " + resultList);
            }

            //스트림 및 람다를 이용한 정한 숫자 보다 큰 값 조회하기
            else if (allAnswer == 4) {
                System.out.println("숫자를 입력해주세요. 다음 입력한 숫자보다 큰 숫자들을 조회합니다.");
                double num3 = scan.nextDouble();
                ArrayList<Double> filtering = calculator.findList(num3);
                System.out.println( num3 + "보다 큰값 :  " + filtering);
            }


            //종료를 위한 입력
            else if (allAnswer == 5) {
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