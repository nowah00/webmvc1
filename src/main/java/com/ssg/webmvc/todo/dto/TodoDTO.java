package com.ssg.webmvc.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

//DTO 용도 : 여러개의 데이터를 묶어서 하나의 객체로 구성
//           서비스객체 메소드들의 파라미터나 리턴 타입으로 사용된다.

@Data     //getter setter toString equals hashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
     private Long tno;   //할일 고유값 pk
     private String title;    //할일 제목
     private LocalDate dueDate;  //등록시간
     private boolean finished;   // 할일 체크
}
