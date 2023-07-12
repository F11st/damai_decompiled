package tb;

import com.taobao.update.datasource.UpdateDataSource;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i30 extends mu2 {
    private C9444mm a;

    public i30(C9444mm c9444mm) {
        this.a = c9444mm;
    }

    @Override // tb.mu2
    public void onForeground() {
        if (this.a.foregroundRequest) {
            UpdateDataSource.getInstance().startUpdate(true, true);
        }
    }
}
