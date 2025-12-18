package com.cemware.dodo.dto.group;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GroupListResponse {

    private List<GroupDto> groups;

    public static GroupListResponse from(List<GroupDto> groups) {
        return new GroupListResponse(groups);
    }

}
