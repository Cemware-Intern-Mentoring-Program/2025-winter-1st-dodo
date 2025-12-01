package com.cemware.dodo.dto.user;

import com.cemware.dodo.domain.User;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/*Lombok은 빌더 객체를 만들고 → 마지막에 전체 필드 생성자를 호출해서 DTO 객체를 만들어.
        👉 즉, 빌더 패턴도 결국 전체 필드 생성자를 기반으로 동작함.*/
/*
builder: 인스턴스 생성(like setter)
필요한 데이터만 설정할 수 있음
유연성을 확보할 수 있음
가독성을 높일 수 있음
변경 가능성을 최소화할 수 있음*/

@Getter
@Builder
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //전체 필드 생성자
public class UserCreateRequest {

    private String userEmail;
    private String password;

}

