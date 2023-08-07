package com.pro.infomate.email.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SequenceGenerator(
        name = "SEQ_TBL_REFERENCE_GENERATOR",
        sequenceName = "SEQ_TBL_MAIL_CODE",
        initialValue = 1, allocationSize = 1
)
public class MailReference {

    @Id
    @Column(name = "REFERENCE_CODE")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TBL_REFERENCE_GENERATOR"
    )
    private int referenceCode;

    @ManyToOne
    @JoinColumn(name = "MAIL_CODE", nullable = false)
    private Member mail;

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE", nullable = false)
    private Email member;

}
