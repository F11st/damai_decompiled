package com.taobao.tao.log.statistics;

import cn.damai.launcher.utils.SplashXFlushHelper;
import tb.gz0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum ErrorCode {
    COMMON(0, "-1001"),
    CODE_EXC(1, "-1002"),
    DATA_EMPTY(2, "-1003"),
    DATA_ERROR(3, "-1004"),
    NET_ERROR(4, gz0.HOMEPAGE_CHANNEL_FEED_FAIL_CODE),
    UPLOAD_NOT_WIFI(5, "-1006"),
    UPLOAD_NO_FILE(6, "-1007"),
    NOT_IMPLEMENTED(7, "-1008"),
    TOKEN_REPLY_ERROR(8, "-1009"),
    TOKEN_EMPTY(9, SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE0),
    UNSUPPORTED_BIZ_TYPE(10, "-1011"),
    BIZ_ERROR(11, SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE2),
    TOKEN_REFUSE_ERROR(12, SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE3),
    FILE_ZIP_ERROR(13, SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE4),
    FILE_ZIP_NOT_EXIST(14, "-1015"),
    TLOG_INIT_ERROR(15, "-1016");
    
    private String desc;
    private int value;

    ErrorCode(int i, String str) {
        this.value = i;
        this.desc = str;
    }

    public String getValue() {
        return this.desc;
    }
}
