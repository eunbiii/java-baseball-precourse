# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 로직 구성
####1. 랜덤한 숫자 생성
- 자리 수 : 3
- 범위 : 0~9 
- 겹치지 않는 숫자로 구성

####2. 숫자를 입력받음
- 1 : 재시작, 2 : 종료
- 3자리 숫자 외의 값은 exception

####3. 숫자 판별
- 숫자가 Contain이면 Ball
- 숫자가 index도 같으면 Strike 

####4. 정답 판별 및 분기
- Strike 숫자가 3이면 승리
- 승리 시 문구 출력
- 승리하지 않을 시 [2]번부터 재시작