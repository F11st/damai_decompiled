package com.taobao.android.sso.v2.launch.exception;

import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SSOException extends RuntimeException {
    private static final long serialVersionUID = -2814983847052662937L;
    private int mCode;
    private String mMsg;

    public SSOException(Integer num, String str) {
        super(format(num, str));
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    protected static String format(Integer num, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SSOException: ");
        if (num != null) {
            sb.append(jn1.ARRAY_START_STR);
            sb.append(num);
            sb.append(jn1.ARRAY_END_STR);
        }
        sb.append(" : ");
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public SSOException(Integer num, Throwable th) {
        super(th);
        this.mCode = num.intValue();
    }

    public SSOException(String str) {
        super(str);
        this.mCode = 0;
        this.mMsg = str;
    }
}
