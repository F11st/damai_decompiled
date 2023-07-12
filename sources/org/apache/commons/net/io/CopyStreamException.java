package org.apache.commons.net.io;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CopyStreamException extends IOException {
    private static final long serialVersionUID = -2602899129433221532L;
    private final long totalBytesTransferred;

    public CopyStreamException(String str, long j, IOException iOException) {
        super(str);
        initCause(iOException);
        this.totalBytesTransferred = j;
    }

    public IOException getIOException() {
        return (IOException) getCause();
    }

    public long getTotalBytesTransferred() {
        return this.totalBytesTransferred;
    }
}
