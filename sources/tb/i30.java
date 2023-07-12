package tb;

import com.taobao.update.datasource.UpdateDataSource;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i30 extends mu2 {
    private mm a;

    public i30(mm mmVar) {
        this.a = mmVar;
    }

    @Override // tb.mu2
    public void onForeground() {
        if (this.a.foregroundRequest) {
            UpdateDataSource.getInstance().startUpdate(true, true);
        }
    }
}
