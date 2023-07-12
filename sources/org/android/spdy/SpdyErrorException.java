package org.android.spdy;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpdyErrorException extends RuntimeException {
    private static final long serialVersionUID = 4422888579699220045L;
    private int error;

    public SpdyErrorException(int i) {
        this.error = 0;
        this.error = i;
    }

    public int SpdyErrorGetCode() {
        return this.error;
    }

    public SpdyErrorException(String str, int i) {
        super(str);
        this.error = 0;
        this.error = i;
    }

    public SpdyErrorException(String str, Throwable th, int i) {
        super(str, th);
        this.error = 0;
        this.error = i;
    }

    public SpdyErrorException(Throwable th, int i) {
        super(th);
        this.error = 0;
        this.error = i;
    }
}
