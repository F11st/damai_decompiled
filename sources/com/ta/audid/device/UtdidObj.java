package com.ta.audid.device;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class UtdidObj {
    private boolean isValid = false;
    private long timestamp;
    private int version;

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
