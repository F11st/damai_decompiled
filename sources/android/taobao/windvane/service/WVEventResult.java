package android.taobao.windvane.service;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVEventResult {
    public boolean isSuccess;
    public Object resultObj;

    public WVEventResult(boolean z, Object obj) {
        this.isSuccess = z;
        this.resultObj = obj;
    }

    public WVEventResult(boolean z) {
        this.isSuccess = z;
        this.resultObj = null;
    }
}
