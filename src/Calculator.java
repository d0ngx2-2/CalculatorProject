import java.util.ArrayList;

public class Calculator {
    //연산 결과를 저장하는 컬랙션 타입 필드 선언 및 생성
     private ArrayList<Integer> resultList = new ArrayList<>();

    public Integer resultNum(int first, int second, char operator) {
        int result = 0;
         //1)operator의 사칙연산의 부호가 무엇인지 판단을 한다. 조건문을 통해
         //만약에 operator가 '+'가 들어간다면
        if (operator == '+') {
            // first + second 나온 값을 변수 result에 담는다.
            result = first + second;
        } else if (operator == '-') {
            result = first - second;
        } else if (operator == '*') {
            result = first * second;
        } else if (operator == '/') {
        // second값이 0이 들어갈 경우 아래 내용을 프린트
        // 이후 result값을 null로 반환
            if (second == 0){
                System.out.println("0인 분모를 나눌 수 없습니다.");
                return null;
            }
            result = first / second;
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
    ArrayList<Integer> getResultList() {
        return resultList;
    }

    // 저장된 배열 속에서 수정하는 메서드 (0부터시작하는 순서, 바꿔들어갈 숫자)
    void setResultList(int index, int newNum) {
        this.resultList.set(index, newNum);
    }

    // 저장된 배열 속에서 삭제시키는 메서드 (순서 입력(0부터시작))
    void removeResult() {
        this.resultList.remove(0);
    }
}