public class Calculator {
    //연산 결과를 저장하는 컬랙션 타입 필드 선언 및 생성

//- [x]  반환 자료형(데이터 타입)
//- [x]  함수이름
//- [x]  매개변수
//- [x]  작업내용
//- [x]  데이터 반환

    int resultNum(int first, int second, char operator) {
        int result = 0;
//         1)operator의 사칙연산의 부호가 무엇인지 판단을 한다. 조건문을 통해
//         1.만약에 operator가 '+'가 들어간다면
        if (operator == '+') {
            // first + second 나온 값을 변수 result에 담는다.
            result = first + second;
            // 3. result값을 반환한다.
            return result;
        } else if (operator == '-') {
            result = first - second;
            return result;
        } else if (operator == '*') {
            result = first * second;
            return result;
        } else if (operator == '/') {
            result = first / second;
            return result;
        } else {
            return result;
        }
    }
}

