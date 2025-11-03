package com.justintime.schoolmanagement.entity.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("timetables")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Timetable {
    @Id
    private String id;
    private String courseId;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private String room;
}
