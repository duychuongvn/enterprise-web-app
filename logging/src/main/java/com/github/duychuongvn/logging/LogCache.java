package com.github.duychuongvn.logging;

import com.github.duychuongvn.logging.dao.entity.LogDetails;
import com.github.duychuongvn.logging.dao.entity.LogRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huynhduychuong on 10/23/2016.
 */
public class LogCache {

    private LogRecord logRecord;
    private List<LogDetails> logDetails = new ArrayList<>();

    public LogCache(LogRecord logRecord) {
        this.logRecord = logRecord;
    }

    public LogRecord getLogRecord() {
        return logRecord;
    }

    public List<LogDetails> getLogDetails() {
        return logDetails;
    }
}
