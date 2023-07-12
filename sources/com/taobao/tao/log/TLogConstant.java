package com.taobao.tao.log;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogConstant {
    static final int BYTE_K = 1024;
    static final int BYTE_M = 1048576;
    public static final String CHANNEL_MODLE = "realtime";
    static final char CONTENT_FIELD_SEPARATOR = 31;
    public static final int DEFAULT_FILE_RATE = 50;
    public static final long DEFAULT_LOG_BUFFER_SIZE = 600;
    public static final boolean DEFAULT_MULTI_PROCESS_NOTIFY = true;
    public static final boolean DEFAULT_SCAN_UPLOAD = true;
    public static final int DEFAULT_STATISTICS_RATE = 4000;
    static final int MAX_CODE_LOG_LENGTH = 10240;
    static final int MAX_LOG_FILE_SIZE = 52428800;
    static final int MAX_LOG_LENGTH = 30720;
    static final int MAX_TRACE_EVENT_LENGTH = 1024;
    public static final String MODEL = "TLOG";
    public static final int NEW_PROTOCOL_V9 = 9;
    public static final String PERSIST_EXTDATA = "tlog_upload_extdata";
    public static final String PERSIST_SERIAL_NUMBER = "serialNumber";
    public static final String PERSIST_SERVICE_ID = "serviceId";
    public static final String PERSIST_TASK_ID = "taskId";
    public static final String PERSIST_UPLOAD_FILES = "tlog_upload_files";
    public static final String PERSIST_UPLOAD_TYPE = "tlog_upload_type";
    public static final String PERSIST_USER_ID = "userId";
    public static final String REMOTE_DEBUGER_LOG_DESTROY = "tlog_destroy";
    public static final String REMOTE_DEBUGER_LOG_ENDTIME = "tlog_endtime";
    public static final String REMOTE_DEBUGER_LOG_LEVEL = "tlog_level";
    public static final String REMOTE_DEBUGER_LOG_MODULE = "tlog_module";
    public static final String REMOTE_DEBUGER_LOG_SWITCH = "tlog_switch";
    public static final String REMOTE_DEBUGER_LOG_VERSION = "tlog_version";
    public static final String RUBBISH_DIR = "tmp";
    public static final String SDKVERSION = "1.0";
    public static final int STATISTICS_RATE_RANGE = 10000;
    public static final String TLOG_BUFFER_SIZE = "tlog_buffer_size";
    public static final String TLOG_CONFIG_LOG_FILE_SIZE = "tlog_file_size";
    public static final String TLOG_FILE_STATISTICS_DAY = "tlog_file_statistics_day";
    public static final String TLOG_FILE_STATISTICS_SAMPLE = "tlog_file_statistics_sample";
    public static final String TLOG_FILE_VERSION = "tlog_file_version";
    public static final String TLOG_IS_DEBUG = "tlog_isDebug";
    public static final String TLOG_MODULE_OFF = "off";
    public static final String TLOG_MULTI_PROCESS_NOTIFY = "tlog_multi_process_notify";
    public static final String TLOG_SCAN_UPLOAD = "tlog_scan_upload";
    public static final String TLOG_STATISTICS_SAMPLE = "tlog_statistics_sample";
    public static final String TLOG_USE_ZSTD = "tlog_use_zstd";
    public static final String TOKEN_OSS_BUCKET_NAME_KEY = "ossBucketName";
    public static final String TOKEN_TYPE_ARUP = "arup";
    public static final String TOKEN_TYPE_CEPH = "ceph";
    public static final String TOKEN_TYPE_OSS = "oss";
    public static final String UPLOAD_DIR = TLogInitializer.getInstance().getFileDir() + File.separator + "upload";
    public static String FILE_PREFIX = "TAOBAO";
}
