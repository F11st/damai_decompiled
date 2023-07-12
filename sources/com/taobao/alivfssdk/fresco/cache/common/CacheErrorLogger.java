package com.taobao.alivfssdk.fresco.cache.common;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface CacheErrorLogger {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum CacheErrorCategory {
        READ_DECODE,
        READ_FILE,
        READ_FILE_NOT_FOUND,
        READ_INVALID_ENTRY,
        WRITE_ENCODE,
        WRITE_CREATE_TEMPFILE,
        WRITE_UPDATE_FILE_NOT_FOUND,
        WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND,
        WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND,
        WRITE_RENAME_FILE_OTHER,
        WRITE_CREATE_DIR,
        WRITE_CALLBACK_ERROR,
        WRITE_INVALID_ENTRY,
        DELETE_FILE,
        EVICTION,
        GENERIC_IO,
        OTHER
    }

    void logError(CacheErrorCategory cacheErrorCategory, String str, String str2, @Nullable Throwable th);
}
