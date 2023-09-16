package com.pro.infomate.calendar.api;


import lombok.*;

import java.time.LocalDateTime;


@Getter
@ToString
@Builder
public class CalendarAlertDTO {

    private Integer memberCode;

    private Integer scheduleId;

    private String scheduleTitle;

    private LocalDateTime endDate;

    private LocalDateTime startDate;

    private LocalDateTime alertDate;

    private Boolean important;

    private Boolean allDay;

}
