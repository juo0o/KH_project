## 📌 Company Intranet Project
4조 파이널 프로젝트 사내 인트라넷 사이트를 기획/제작한 웹 사이트입니다.   
조장 정진수, 이광준,  김동주, 손명수 가 참가하였습니다.

<br>

[결과물 바로가기](#결과물)
<br>


<a href="https://www.youtube.com/watch?v=-0LDqazFLAE  ">시연영상 보러가기</a>

<br>


## 👩‍💻팀원소개👨‍💻

| [👩 J096 정진수](https://github.com/JINSU-JEONG1)                                                                                   | [💩 J135 이광준](https://github.com/juny0901)                                                                                   | [🐜 J163 김동주](https://github.com/juo0o)                                                                         | [🧑 J180 손명수]([https://github.com/saeeng](https://github.com/SonMyeongsu))                                                                                   |
| ----------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- |
| <img src="" width="100"/> | <img src="" width="100"/> | <img src="" width="100"/> | <img src="" width="100"/> |
| 16진수                                                                                                                    | 광준                                                                                                                       | 동주                                                                                                                   |                                                                                                                |



<br>

## 📌 프로젝트 기간
* 프로젝트 기간 : 2022년 10월 26일 ~  2022년 12월 8일

![프로젝트 일정관리](https://user-images.githubusercontent.com/104358180/207742966-070b88b6-fabb-416a-8474-60b38e060329.png)



## 📌기획의도
사내 업무를 보다 편하게 이용하기 위한 사내 인트라넷



## 📌 개발환경
    Server : Apache Tomcat 8.5
    Database : Oracle 18c
    Development Tool :  SpringBoot Tool Suite  4.11.1
    Framework : MyBatis 3.3.0, Spring 5.3.13
    Build Tool : Maven 
    Development Language :  JAVA 11 , HTML5, CSS3, JavaScript, jQuery, thymeleaf, Ajax
    Shape management : Github 
    Open API : 다음 우편검색, FullCalender
    Design tool : Bootstrap5
    
    
## 📌 주요기능
[회원]
- 회원 가입, 로그인, 로그아웃, 회원 정보 수정

[캘린더]
- Full calendar API를 활용한 회의실 예약/조회


[전자문서 결재 기능]
- 전자문서 작성, 조회기능
- 결재선 지정, 결재기능
- 전자문서 검색기능


[게시판]
- 공지사항 게시판,자유 게시판,
- 게시글 조회/작성/수정/삭제
- 댓글 작성/수정/삭제
- 좋아요 기능
- 검색


[주소록] 
- 개인 주소록에서 그룹등록 및 개인연락처 등록,수정.
- 공용 주소록 검색 가능


[회의실 예약]
- 해당월, 해당주, 당일에 대한 회의실 예약기능
- 색깔별로 예약불가일과 가능일을 구분
- 내 예약 조회가 가능


[관리자 페이지]

- 사내 부서및 사원의 정보를 관리


[채팅]
- 사내 채팅방 페이지
- 부서별 채팅방 사용가능




## 📌 폴더 구조

<details>
<summary>Project Folder</summary>
  <div markdown="1">
  
```
🗃 Project Folder  
📁src/main/java 
├── 📁config      
├── 📁address
│   ├── 📁controller
│   ├── 📁service
│   └── 📁vo
├── 📁admin
│   ├── 📁controller
│   ├── 📁service
│   └── 📁vo
├── 📁approval
│   ├── 📁controller
│   ├── 📁service
│   └── 📁vo
├── 📁board
│   ├── 📁controller
│   ├── 📁service
│   └── 📁vo
├── 📁chat
│   ├── 📁controller
│   ├── 📁service
│   └── 📁vo
├── 📁emp
│   ├── 📁controller
│   ├── 📁service
│   └── 📁vo
├── 📁main
│   ├── 📁controller
│   ├── 📁service
│   └── 📁vo
├── 📁reservation
│   ├── 📁controller
│   ├── 📁service
│   └── 📁vo
└──......

 
📁src/main/resources 
├── 📁mappers
│   ├── 📁address-mapper
│   ├── 📁admin-mapper
│   ├── 📁approval-mapper
│   ├── 📁board-mapper
│   ├── 📁chat-mapper
│   ├── 📁emp-mapper    
│   ├── 📁main-mapper  
│   └── 📁reservation-mapper
│      
├── 📁static
│   ├── 📁css
│   │    └──......  
│   ├── 📁imgs
│   │    └──......  
│   └── 📁js
│        └──...... 
│     
├── 📁template
│   ├── 📁fragment
│   ├── 📁layout
│   ├── 📁main  
│   └── 📁pages
│        ├── 📁address
│        ├── 📁admin
│        ├── 📁approval
│        ├── 📁board
│        ├── 📁chat
│        ├── 📁emp   
│        ├── 📁main 
│        └── 📁reservation
│     
└──......
```
</div>
</details>

## 📌 DB 설계

![테이블 관계도](https://user-images.githubusercontent.com/104358180/206993936-36e43b15-ba85-4c1d-88d5-917afd5912c6.PNG)


##  내가 맡은 기능 결과물

###  전자 서류 결재 요청

![전자 결재 서류 작성](https://user-images.githubusercontent.com/107612677/212478516-453d45a3-61ab-4a20-8667-c208d0aacf31.gif)

##### 서류 작성 페이지로 이동
> <img width="800" alt="1" src="https://user-images.githubusercontent.com/107612677/212479160-b61edbc9-6fbf-4f55-843a-58486aee0930.png">

##### 기안서 종류
> <img width="800" alt="4" src="https://user-images.githubusercontent.com/107612677/212479253-9a4fd11f-1199-4b36-bf47-a106b8735ed1.png">

##### 서류 작성 페이지
> <img width="800" alt="2" src="https://user-images.githubusercontent.com/107612677/212479228-4cfa5138-1198-4231-957f-8a58aedf2c3b.png">

### 결재 요청시 알림

<img width="800" alt="결재 알림" src="https://user-images.githubusercontent.com/107612677/212480188-dfff729f-e359-49e5-8c48-0e4e64f54366.png">

<img width="800" alt="알림2" src="https://user-images.githubusercontent.com/107612677/212479519-d8a80e72-155b-425f-9b7e-e4a9a59f3bb7.png">

### 개인 결재 문서함

<img width="800" alt="5" src="https://user-images.githubusercontent.com/107612677/212479266-c8d4bedd-4141-4f31-a4ad-f77b349c6ad7.png">

### 팀장 결재

![팀장 결재](https://user-images.githubusercontent.com/107612677/212478554-77019554-b6dc-4624-bba9-976e5583eb17.gif)

### 부장 결재

![부장 결재](https://user-images.githubusercontent.com/107612677/212478591-1dfd13c9-cf03-4c22-b274-7264497c1b01.gif)

> ##### 최종 결재

<img width="800" alt="6" src="https://user-images.githubusercontent.com/107612677/212479276-e68d75f8-4458-41b4-bb86-a22f22347c24.png">

### 조건별 기안서 검색

![결재 문서함](https://user-images.githubusercontent.com/107612677/212478681-f263e35e-6f3d-4416-ada7-37e7860b0042.gif)

<br><br>
***
<br><br>




### 특징
- MVC 패턴에 기반한 웹 어플리케이션 개발 
- Transaction 처리로 데이터의 무결성 보장
- AOP를 이용한 로그처리
- Interceptor를 이용한 페이지 접근 권한 설정
- Bcrypt를 이용한 비밀번호 암호화 처리
- DI (Dependency Injection) 패턴을 적용하여 불필요한 의존관계 해소 
- annotation 사용으로 설정 파일을 간결화
