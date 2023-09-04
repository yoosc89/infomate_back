ALTER TABLE TBL_SCHDL
    DROP CONSTRAINT TBL_SCHDL_REF_CLNDR_ID_FK;

ALTER TABLE TBL_SCHDL
    ADD CONSTRAINT TBL_SCHDL_REF_CLNDR_ID_FK FOREIGN KEY (REF_CLNDR_ID) REFERENCES TBL_CLNDR (CLNDR_CODE);

ALTER TABLE TBL_FVRT_CLNDR
    DROP CONSTRAINT TBL_FVRT_CLNDR_REF_CLDNR_ID_FK;

ALTER TABLE TBL_FVRT_CLNDR
    ADD CONSTRAINT TBL_FVRT_CLNDR_REF_CLDNR_ID_FK FOREIGN KEY (REF_CLDNR_ID) REFERENCES TBL_CLNDR (CLNDR_CODE);

ALTER TABLE TBL_FVRT_CLNDR
    DROP CONSTRAINT TBL_FVRT_CLNDR_REF_MEMBER_CODE_FK;

ALTER TABLE TBL_FVRT_CLNDR
    ADD CONSTRAINT TBL_FVRT_CLNDR_REF_MEMBER_CODE_FK FOREIGN KEY (REF_MEMBER_CODE) REFERENCES TBL_MEMBER (MEMBER_CODE);

ALTER TABLE TBL_CLNDR
    DROP CONSTRAINT TBL_CLNDR_REF_MEMBER_CODE_FK;

ALTER TABLE TBL_CLNDR
    ADD CONSTRAINT TBL_CLNDR_REF_MEMBER_CODE_FK FOREIGN KEY (REF_MEMBER_CODE) REFERENCES TBL_MEMBER (MEMBER_CODE);

ALTER TABLE TBL_POST
    DROP CONSTRAINT TBL_POST_BOARD_CODE_FK;

ALTER TABLE TBL_POST
    ADD CONSTRAINT TBL_POST_BOARD_CODE_FK FOREIGN KEY (BOARD_CODE) REFERENCES TBL_BOARD (BOARD_CODE);


COMMIT ;

ALTER TABLE TBL_APPROVAL
    ADD CONSTRAINT TBL_APPROVAL_TBL_MEMBER_FK
        FOREIGN KEY (MEMBER_CODE) REFERENCES TBL_MEMBER (MEMBER_CODE);

ALTER TABLE TBL_APPROVAL
    ADD CONSTRAINT TBL_APPROVAL_TBL_DOCUMENT_FK
        FOREIGN KEY (DOCUMENT_ID) REFERENCES TBL_DOCUMENT (DOCUMENT_ID);

ALTER TABLE TBL_DOCFILE
    ADD CONSTRAINT TBL_DOCFILE_TBL_DOCUMENT_FK
        FOREIGN KEY (DOCUMENT_ID) REFERENCES TBL_DOCUMENT (DOCUMENT_ID);

ALTER TABLE TBL_DOCREF
    ADD CONSTRAINT TBL_DOCREF_TBL_DOCUMENT_FK
        FOREIGN KEY (DOCUMENT_ID) REFERENCES TBL_DOCUMENT (DOCUMENT_ID);

ALTER TABLE TBL_DOCREF
    ADD CONSTRAINT TBL_DOCREF_TBL_MEMBER_FK
        FOREIGN KEY (MEMBER_CODE) REFERENCES TBL_MEMBER (MEMBER_CODE);

ALTER TABLE TBL_DOCUMENT
    ADD CONSTRAINT TBL_DOCUMENT_TBL_MEMBER_FK
        FOREIGN KEY (MEMBER_CODE) REFERENCES TBL_MEMBER (MEMBER_CODE);

ALTER TABLE TBL_PAYMENT
    ADD CONSTRAINT TBL_PAYMENT_FK
        FOREIGN KEY (DOCUMENT_ID) REFERENCES TBL_DOCUMENT;

ALTER TABLE TBL_PAYMENTLIST
    ADD CONSTRAINT TBL_PAYMENTLIST_TBL_PAYMENT_FK
        FOREIGN KEY (DOCUMENT_ID) REFERENCES TBL_PAYMENT;

ALTER TABLE TBL_VACATION
    ADD CONSTRAINT TBL_VACATION_TBL_DOCUMENT_FK
        FOREIGN KEY (DOCUMENT_ID) REFERENCES TBL_DOCUMENT;


ALTER TABLE TBL_MEMBER
    ADD CONSTRAINT TBL_MEMBER_TBL_RANK_FK
    FOREIGN KEY (RANK_CODE) REFERENCES TBL_RANK;


ALTER TABLE TBL_MEMBER
    ADD CONSTRAINT TBL_MEMBER_TBL_DEPT_FK
        FOREIGN KEY (DEPT_CODE) REFERENCES TBL_DEPT;


