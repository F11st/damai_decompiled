package com.youku.playerservice.axp.playinfo;

import com.youku.upsplayer.data.ConnectStat;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayInfoError {
    private ConnectStat mConnectStat;
    private int mErrorCode = -1;
    private String mErrorMsg;
    private int mOldErrorCode;

    public ConnectStat getConnectStat() {
        return this.mConnectStat;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public int getOldErrorCode() {
        return this.mOldErrorCode;
    }

    public void setConnectStat(ConnectStat connectStat) {
        this.mConnectStat = connectStat;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public void setOldErrorCode(int i) {
        this.mOldErrorCode = i;
    }
}
