package com.cosmos.teamcodingservice.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter //Setter는 쓰지않는다. 값 타입은 될 수 있으면 불변 객체로 설계해야 하기때문에.
@Entity
@Builder
@Table(name = "teamStudyDetail")
@NoArgsConstructor //파라미터가 없는 기본생성자 생성
@AllArgsConstructor //모든 필드값을 파라미터로 받는 생성자 생성
public class TeamStudyDetailEntity {

    @Id //PK선언
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamStudyDetailSeq; //teamStudyDetail seq

    @Column(length = 200)
    private String userId; //유저 id

    @Column(length = 300)
    private String teamStudyDetailContents; //유저별 특정 날짜 스터디 후기

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private TeamStudyInfoEntity teamStudyInfo;
}
