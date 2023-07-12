package tb;

import android.preference.PreferenceManager;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.instantpatch.InstantPatchUpdater;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wd0 extends yd0 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private static wd0 a = new wd0();
    }

    public static wd0 INSTANCE() {
        return b.a;
    }

    @Override // tb.be0
    public String biz() {
        return lu2.HOTPATCH;
    }

    @Override // tb.be0
    public String requestVersion() {
        return PreferenceManager.getDefaultSharedPreferences(UpdateDataSource.getInstance().getApplication()).getString(InstantPatchUpdater.EFFECTIVE_VERSION, "-1");
    }

    private wd0() {
    }
}
