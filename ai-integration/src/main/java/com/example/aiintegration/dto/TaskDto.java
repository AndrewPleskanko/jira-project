package com.example.aiintegration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private Long userId;
    private Long userStoryId;
    private Long blockedByTaskId;
}