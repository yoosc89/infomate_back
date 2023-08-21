package com.pro.infomate.approval.repository;

import com.pro.infomate.approval.dto.response.DocumentListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DocumentRepositoryCustom {

  Page<DocumentListResponse> findByDeptDoc(int memberCode, Pageable pageable);
}
