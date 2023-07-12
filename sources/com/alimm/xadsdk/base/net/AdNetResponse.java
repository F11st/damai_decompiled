package com.alimm.xadsdk.base.net;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdNetResponse {
    private byte[] mBytes;
    private boolean mCallSucceed;
    private List<String> mCookies;
    private int mErrorCode;
    private String mErrorMsg;
    private int mResponseCode;

    public AdNetResponse(int i, String str, int i2, byte[] bArr) {
        this.mErrorCode = 0;
        this.mResponseCode = -1;
        this.mErrorCode = i;
        this.mErrorMsg = str;
        this.mResponseCode = i2;
        this.mBytes = bArr;
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public List<String> getCookies() {
        return this.mCookies;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public boolean isCallSucceed() {
        return this.mCallSucceed;
    }

    public void setBytes(byte[] bArr) {
        this.mBytes = bArr;
    }

    public void setCallSucceed(boolean z) {
        this.mCallSucceed = z;
    }

    public void setCookies(List<String> list) {
        this.mCookies = list;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public void setResponseCode(int i) {
        this.mResponseCode = i;
    }
}
