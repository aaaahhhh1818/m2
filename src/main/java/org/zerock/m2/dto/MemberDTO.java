package org.zerock.m2.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String mid, mpw, mname, nickname;
    private Timestamp joindate, moddate;

}
