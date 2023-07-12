package com.squareup.okhttp.internal.spdy;

import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Settings {
    static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    static final int COUNT = 10;
    static final int CURRENT_CWND = 5;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
    static final int DOWNLOAD_BANDWIDTH = 2;
    static final int DOWNLOAD_RETRANS_RATE = 6;
    static final int ENABLE_PUSH = 2;
    static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    static final int FLOW_CONTROL_OPTIONS = 10;
    static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    static final int PERSISTED = 2;
    static final int PERSIST_VALUE = 1;
    static final int ROUND_TRIP_TIME = 3;
    static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int flags(int i) {
        int i2 = isPersisted(i) ? 2 : 0;
        return persistValue(i) ? i2 | 1 : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int get(int i) {
        return this.values[i];
    }

    int getClientCertificateVectorSize(int i) {
        return (this.set & 256) != 0 ? this.values[8] : i;
    }

    int getCurrentCwnd(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    int getDownloadBandwidth(int i) {
        return (this.set & 4) != 0 ? this.values[2] : i;
    }

    int getDownloadRetransRate(int i) {
        return (this.set & 64) != 0 ? this.values[6] : i;
    }

    boolean getEnablePush(boolean z) {
        return ((this.set & 4) != 0 ? this.values[2] : z ? 1 : 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getInitialWindowSize(int i) {
        return (this.set & 128) != 0 ? this.values[7] : i;
    }

    int getMaxConcurrentStreams(int i) {
        return (this.set & 16) != 0 ? this.values[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxFrameSize(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    int getMaxHeaderListSize(int i) {
        return (this.set & 64) != 0 ? this.values[6] : i;
    }

    int getRoundTripTime(int i) {
        return (this.set & 8) != 0 ? this.values[3] : i;
    }

    int getUploadBandwidth(int i) {
        return (this.set & 2) != 0 ? this.values[1] : i;
    }

    boolean isFlowControlDisabled() {
        return (((this.set & 1024) != 0 ? this.values[10] : 0) & 1) != 0;
    }

    boolean isPersisted(int i) {
        return ((1 << i) & this.persisted) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void merge(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.isSet(i)) {
                set(i, settings.flags(i), settings.get(i));
            }
        }
    }

    boolean persistValue(int i) {
        return ((1 << i) & this.persistValue) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Settings set(int i, int i2, int i3) {
        int[] iArr = this.values;
        if (i >= iArr.length) {
            return this;
        }
        int i4 = 1 << i;
        this.set |= i4;
        if ((i2 & 1) != 0) {
            this.persistValue |= i4;
        } else {
            this.persistValue &= ~i4;
        }
        if ((i2 & 2) != 0) {
            this.persisted |= i4;
        } else {
            this.persisted &= ~i4;
        }
        iArr[i] = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return Integer.bitCount(this.set);
    }
}
