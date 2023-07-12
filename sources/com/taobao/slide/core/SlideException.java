package com.taobao.slide.core;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SlideException extends Exception {
    private int errorCode;

    public SlideException(int i) {
        this.errorCode = i;
    }

    public int getCode() {
        return this.errorCode;
    }

    public SlideException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public SlideException(int i, Throwable th) {
        super(th);
        this.errorCode = i;
    }

    public SlideException(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }
}
