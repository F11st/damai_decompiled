package okhttp3.internal.connection;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteException(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addConnectException(IOException iOException) {
        okhttp3.internal.a.b(this.firstException, iOException);
        this.lastException = iOException;
    }

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }
}
