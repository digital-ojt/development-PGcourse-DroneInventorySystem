package com.digitalojt.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalojt.web.entity.OperationLog;

/**
 * 操作履歴テーブルリポジトリー
 *
 * @author dotlife
 * 
 */
@Repository
public interface OperationLogRepository extends JpaRepository<OperationLog, Integer> {
}
