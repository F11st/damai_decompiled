package anet.channel.strategy;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConnHistoryItem implements Serializable {
    private static final int BAN_THRESHOLD = 3;
    private static final int BAN_TIME = 300000;
    private static final long UPDATE_INTERVAL = 10000;
    private static final long VALID_PERIOD = 86400000;
    private static final long serialVersionUID = 5245740801355223771L;
    byte history = 0;
    long lastSuccess = 0;
    long lastFail = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int countFail() {
        int i = 0;
        for (int i2 = this.history & 255; i2 > 0; i2 >>= 1) {
            i += i2 & 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isExpire() {
        long j = this.lastSuccess;
        long j2 = this.lastFail;
        if (j <= j2) {
            j = j2;
        }
        return j != 0 && System.currentTimeMillis() - j > 86400000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean latestFail() {
        return (this.history & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldBan() {
        return countFail() >= 3 && System.currentTimeMillis() - this.lastFail <= 300000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - (z ? this.lastSuccess : this.lastFail) > 10000) {
            this.history = (byte) ((this.history << 1) | (!z ? 1 : 0));
            if (z) {
                this.lastSuccess = currentTimeMillis;
            } else {
                this.lastFail = currentTimeMillis;
            }
        }
    }
}
