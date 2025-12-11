package com.cemware.dodo.domain;

import jakarta.persistence.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int groupId;

    private String groupName;

    protected Group() {}


    public void updateGroupId(int groupId) {
        this.groupId = groupId;
    }
    public void updateGroupName(String groupName) {
        this.groupName = groupName;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    private List<Task> tasks;
}
