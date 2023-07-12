package com.uc.webview.export.cyclone;

import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class UCKnownException extends RuntimeException {
    private int mCode;

    public UCKnownException(int i, String str, Throwable th) {
        super(str, th);
        this.mCode = GlobalErrorCode.INIT;
        this.mCode = i;
    }

    public static UCKnownException create(Throwable th, int i) {
        if (th instanceof UCKnownException) {
            return (UCKnownException) th;
        }
        return new UCKnownException(i, th);
    }

    public final int errCode() {
        return this.mCode;
    }

    public final Throwable getRootCause() {
        Throwable th = this;
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    public final Runnable toRunnable() {
        return new Runnable() { // from class: com.uc.webview.export.cyclone.UCKnownException.1
            @Override // java.lang.Runnable
            public void run() {
                throw UCKnownException.this;
            }
        };
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return this.mCode + ":" + super.toString();
    }

    public UCKnownException(int i, Throwable th) {
        this(th);
        this.mCode = i;
    }

    public UCKnownException(int i, String str) {
        super(str);
        this.mCode = GlobalErrorCode.INIT;
        this.mCode = i;
    }

    public UCKnownException(Throwable th) {
        super(th);
        this.mCode = GlobalErrorCode.INIT;
        while (th != null) {
            if (th instanceof UCKnownException) {
                this.mCode = ((UCKnownException) th).mCode;
                return;
            } else if (th.getCause() == null || th.getCause() == th) {
                return;
            } else {
                th = th.getCause();
            }
        }
    }

    public UCKnownException(String str) {
        super(str);
        this.mCode = GlobalErrorCode.INIT;
    }
}
