package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZone;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class q1<ExposeKey, ExposeData> implements IExposureZone<ExposeKey, ExposeData> {
    public static String b = "default_exposure";
    @NonNull
    private final String a;

    public q1(@Nullable String str) {
        if (str == null) {
            this.a = b;
        } else {
            this.a = str;
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZone
    public void attach() {
        exposure().prepare();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZone
    public void detach() {
        exposure().destroy();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZone
    @NonNull
    public String key() {
        return this.a;
    }
}
