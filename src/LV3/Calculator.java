package LV3;

import java.util.ArrayList;
import java.util.stream.Collectors;

//연산 결과를 저장하는 컬랙션 타입 필드 선언 및 생성 , Enum을 활용하기 위한 class Enum 참조
public class Calculator {

    // 컬랙션 타입을 Double로 변경함에 따라 실수까지 받을 수 있게 설정
    private ArrayList<Double> resultList = new ArrayList<>();

    //독립적 제네릭 'D'를 활용하여 연산기능 수정
    public <D extends Number> Double resultNum(D first, D second, char operator) {
        double result = 0;
        //1)operator의 사칙연산의 부호가 무엇인지 판단을 한다. 조건문을 통해
        //만약에 operator가 '+'가 들어간다면
        if (operator == Operator.PLUS.getOperator()) {
            // first + second 나온 값을 변수 result에 담는다.
            result = first.doubleValue() + second.doubleValue();
        } else if (operator == Operator.MINUS.getOperator()) {
            result = first.doubleValue() - second.doubleValue();
        } else if (operator == Operator.MULTPLY.getOperator()) {
            result = first.doubleValue() * second.doubleValue();
        } else if (operator == Operator.DIVIDE.getOperator()) {
            // second값이 0이 들어갈 경우 아래 내용을 프린트 이후 result값을 null로 반환
            if (second.doubleValue() == 0){
                System.out.println("0인 분모를 나눌 수 없습니다.");
                return null;
            }
            result = first.doubleValue() / second.doubleValue();
        } else {
            // 외 다른 문자를 썼을 경우 아래와같이 표기 후 result값은 null로 변환
            System.out.println("잘못된 연산 기호 입니다.");
            return null;
        }

        //계산된 result값을 resultList 배열에 저장
        //계산된 result값을 반환
        resultList.add(result);
        return result;
    }
    // 저장된 결과 값을 배열 형태로 불러오는 메서드
    ArrayList<Double> getResultList() {
        return resultList;
    }

    // 저장된 배열 속에서 수정하는 메서드 (0부터시작하는 순서, 바꿔들어갈 숫자)
    void setResultList(int index, double newNum) {
        this.resultList.set(index - 1, newNum); // 순서를 1을 넣으면 첫번째 숫자가 지정되도로 -1을 붙여주었다.
    }

    // 저장된 배열 속에서 첫번째 숫자를 삭제시키는 메서드 (순서 입력(0부터시작))
    void removeResult() {
        this.resultList.remove(0);
    }

    //저장된 배열 속 입력한 숫자값보다 큰 수들을 배열 후 출력시키기
    public   ArrayList<Double> findList(double findNum){
             return resultList.stream()   // 기존 resultList를 스트림 형태로 변환하여 데이터 흐름을 만든다.
                     .filter(n -> n > findNum) // findNum 입력값 보다 큰 수만 필터링한다.(람다 활용)
                     .sorted()  // 필터링된 값을 정렬시킨다.
                     .collect(Collectors.toCollection(ArrayList::new)); //필터링된 데이터를 ArryList에 다시 담는다.
    }
}
