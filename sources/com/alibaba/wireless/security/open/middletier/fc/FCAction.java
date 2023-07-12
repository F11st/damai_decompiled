package com.alibaba.wireless.security.open.middletier.fc;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FCAction {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum FCMainAction {
        SUCCESS,
        FAIL,
        CANCEL,
        RETRY,
        TIMEOUT
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum FCSubAction {
        WUA(1),
        NC(2),
        FL(4),
        LOGIN(8),
        DENY(16);
        
        private long a;

        FCSubAction(long j) {
            this.a = 0L;
            this.a = j;
        }

        public long getValue() {
            return this.a;
        }
    }
}
