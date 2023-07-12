package cn.damai.common.db.ex;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BaseException extends IOException {
    private static final long serialVersionUID = 1;

    public BaseException() {
    }

    public BaseException(String str) {
        super(str);
    }

    public BaseException(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    public BaseException(Throwable th) {
        super(th.getMessage());
        initCause(th);
    }
}
