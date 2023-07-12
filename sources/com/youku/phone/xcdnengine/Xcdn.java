package com.youku.phone.xcdnengine;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface Xcdn {

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface Config {
        public static final String BIZ_ID = "biz_id";
        public static final String CONFIG_DISABLE_MOBILE = "disable_mobile";
        public static final String CONFIG_HEADER_REFER = "http_header_refer";
        public static final String CONFIG_HTTP_CONNECT_TIMEOUT = "http_conn_timeout";
        public static final String CONFIG_HTTP_READ_TIMEOUT = "http_read_timeout";
        public static final String CONFIG_MAX_CONCURRENT_DOWNLOAD_TASK = "max_concurrent_download_task";
        public static final String CONFIG_MAX_HTTP_TRUNK = "max_http_trunk";
        public static final String CONFIG_MAX_RETRY_COUNT = "retry_count";
        public static final String CONFIG_MD5 = "md5";
        public static final String CONFIG_PRIORITY = "dwn_prio";
        public static final String CONFIG_RESOURCE_ID = "source_id";
        public static final String CONFIG_SHA1 = "sha1";
        public static final String CONFIG_START_TIMEMS = "start_timeMS";
        public static final String CONFIG_UPLOAD_LIMIT_DAY = "upload_limit_day";
        public static final String CONFIG_UPLOAD_LIMIT_MIN = "upload_limit_min";
        public static final String CONFIG_USE_MINER = "use_miner";
        public static final String CONFIG_USE_RANDOM_MINER = "use_random_miner";
        public static final String SUPPORT_HTTP = "support_http";
        public static final String USE_BACKUP_STORAGE = "use_backup_storage";
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface MsgCode {
        public static final int XCDN_CHECKSUM_FAILED = 35;
        public static final int XCDN_DOWNLOAD_SUCCESS = 32;
        public static final int XCDN_EDGE_ERR_START = 3000;
        public static final int XCDN_HTTP_ERR_START = 2000;
        public static final int XCDN_OPEN_FAILED = 37;
        public static final int XCDN_PEER_ERR_START = 4000;
        public static final int XCDN_RENAME_FAILED = 36;
        public static final int XCDN_SOCKET_CONNECT_FAILED = 1003;
        public static final int XCDN_SOCKET_CREATE_FAILED = 1002;
        public static final int XCDN_SOCKET_ERR_START = 1000;
        public static final int XCDN_SOCKET_READ_CONTENT_FAILED = 1007;
        public static final int XCDN_SOCKET_READ_HEADER_FAILED = 1006;
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface MsgType {
        public static final int XCDN_DOWNLOAD_FINISH = 8;
        public static final int XCDN_DOWNLOAD_PROGRESS = 9;
        public static final int XCDN_DOWNLOAD_START = 7;
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface Priority {
        public static final int PRIORITY_HIGH = 2;
        public static final int PRIORITY_MID = 1;
        public static final int PRIOTITY_LOW = 0;
    }
}
