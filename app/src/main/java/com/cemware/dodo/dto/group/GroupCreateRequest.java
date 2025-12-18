package com.cemware.dodo.dto.group;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupCreateRequest {

    //private int groupId;
    private String groupName;
    //private int userId;

}
