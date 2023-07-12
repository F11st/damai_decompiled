package com.taobao.orange.sync;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseRequest<T> {
    public static final int CODE_EMPTY = -2;
    public static final int CODE_INVAILD = -5;
    public static final int CODE_MD5 = -3;
    public static final int CODE_PRASE = -4;
    public static final int CODE_UNKNOW = -1;
    public static final int CODE_UTDIDISNULL = -6;
    protected int code = -1;
    protected String message;

    public String getCode() {
        return String.valueOf(this.code);
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public abstract T syncRequest();
}
