package com.ut.mini;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class UTVariables {
    private static UTVariables s_instance = new UTVariables();
    private String mH5RefPage = null;
    private String mRefPage = null;
    private String mH5Url = null;
    private String mBackupH5Url = null;

    UTVariables() {
    }

    public static UTVariables getInstance() {
        return s_instance;
    }

    public String getBackupH5Url() {
        return this.mBackupH5Url;
    }

    public String getH5RefPage() {
        return this.mH5RefPage;
    }

    public String getH5Url() {
        return this.mH5Url;
    }

    public String getRefPage() {
        return this.mRefPage;
    }

    public void setBackupH5Url(String str) {
        this.mBackupH5Url = str;
    }

    public void setH5RefPage(String str) {
        this.mH5RefPage = str;
    }

    public void setH5Url(String str) {
        this.mH5Url = str;
    }

    public void setRefPage(String str) {
        this.mRefPage = str;
    }
}
