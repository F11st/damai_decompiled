package android.taobao.windvane.config;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class WVConfigHandler {
    private boolean isUpdating = false;
    private String snapshotN = "0";

    public String getSnapshotN() {
        return this.snapshotN;
    }

    public boolean getUpdateStatus() {
        return this.isUpdating;
    }

    public void setSnapshotN(String str) {
        this.snapshotN = str;
    }

    public void setUpdateStatus(boolean z) {
        this.isUpdating = z;
    }

    public abstract void update(String str, WVConfigUpdateCallback wVConfigUpdateCallback);
}
