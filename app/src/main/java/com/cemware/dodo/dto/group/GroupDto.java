package com.cemware.dodo.dto.group;

import com.cemware.dodo.domain.Group;
import com.cemware.dodo.dto.group.*;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private int groupId;
    private String groupName;
    private int userId;

    public static GroupDto from(Group group) {
        return GroupDto.builder()
                //.groupId(group.getGroupId())
                .groupName(group.getGroupName())
                .build();
    }

}
