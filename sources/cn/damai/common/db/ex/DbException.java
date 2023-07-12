package cn.damai.common.db.ex;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DbException extends BaseException {
    private static final long serialVersionUID = 1;

    public DbException() {
    }

    public DbException(String str) {
        super(str);
    }

    public DbException(String str, Throwable th) {
        super(str, th);
    }

    public DbException(Throwable th) {
        super(th);
    }
}
