package com.uc.webview.export.cyclone.update;

import com.uc.webview.export.cyclone.Constant;
import java.io.File;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public interface UpdateService {
    public static final int EVENT_CHECK = 8;
    public static final int EVENT_DELETE_DOWNLOAD_FILE = 13;
    public static final int EVENT_DOWNLOAD_BEGIN = 10;
    public static final int EVENT_DOWNLOAD_EXCEPTION = 12;
    public static final int EVENT_DOWNLOAD_INFO_CHECKED = 14;
    public static final int EVENT_DOWNLOAD_SUCCESS = 11;
    public static final int EVENT_EXCEPTION = 5;
    public static final int EVENT_EXISTS = 9;
    public static final int EVENT_FAILED = 4;
    public static final int EVENT_LOG = 1;
    public static final int EVENT_PROGRESS = 7;
    public static final int EVENT_RECOVERED = 6;
    public static final int EVENT_RETRY_TIME_OUT = 15;
    public static final int EVENT_STAT = 2;
    public static final int EVENT_SUCCESS = 3;
    public static final String OPTION_CHECK_FILE = "checkfile";
    public static final String OPTION_CHECK_LAST_MODIFIED = "checklm";
    public static final String OPTION_CONNECT_TIME_OUT = "connto";
    public static final String OPTION_CONTEXT = "ctx";
    public static final String OPTION_DELAY_START_MILLIS = "delays";
    public static final String OPTION_DOWNLOADER_DELEGATE = "dwnDlg";
    public static final String OPTION_READ_TIME_OUT = "readto";
    public static final String OPTION_RETRY_MAX_MILLIS = "retrymax";
    public static final String OPTION_RETRY_WAIT_MILLIS = "retrywait";
    public static final String OPTION_ROOT_DIR = "rootdir";
    public static final String OPTION_UPDATE_CORE = "upcore";
    public static final String OPTION_URL = "url";

    /* compiled from: Taobao */
    @Constant
    /* loaded from: classes11.dex */
    public interface EventCallback {
        Object onCalled(int i, UpdateService updateService, Object[] objArr);
    }

    File getDownloadDir();

    File getDownloadFile();

    long getDownloadLastModified();

    long getDownloadTotalSize();

    Throwable getException();

    File getExtractDir();

    int getPercent();

    String getUrl();

    void restart();

    UpdateService setCallback(EventCallback eventCallback);

    UpdateService setup(String str, Object obj);

    void start();

    void stop();

    void stopWith(Runnable runnable);
}
