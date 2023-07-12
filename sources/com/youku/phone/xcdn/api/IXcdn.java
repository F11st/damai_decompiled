package com.youku.phone.xcdn.api;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes13.dex */
public interface IXcdn {

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface Config {
        public static final String BIZ_ID = "biz_id";
        public static final String CONFIG_MAX_RETRY_COUNT = "retry_count";
        public static final String CONFIG_MD5 = "md5";
        public static final String CONFIG_PRIORITY = "dwn_prio";
        public static final String SUPPORT_HTTP = "support_http";
        public static final String USE_BACKUP_STORAGE = "use_backup_storage";
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface MsgCode {
        public static final int XCDN_DOWNLOAD_SUCCESS = 32;
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
