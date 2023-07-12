package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mt implements PlatformManager.IScrollFactory {
    Map<String, PlatformManager.ScrollListener> a = new HashMap();

    public PlatformManager.ScrollListener a(String str) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.a.get(str);
    }

    @Override // com.alibaba.android.bindingx.core.PlatformManager.IScrollFactory
    public void addScrollListenerWith(@NonNull String str, @NonNull PlatformManager.ScrollListener scrollListener) {
        f(str, scrollListener);
    }

    public void b(String str, int i, int i2, JSONObject jSONObject) {
        PlatformManager.ScrollListener a = a(str);
        if (a != null) {
            a.onScrollEnd(i, i2);
        }
    }

    public void c(String str, int i, int i2, JSONObject jSONObject) {
        PlatformManager.ScrollListener a = a(str);
        if (a != null) {
            a.onScrollStart();
        }
    }

    public void d(String str, int i, int i2, JSONObject jSONObject) {
        PlatformManager.ScrollListener a = a(str);
        if (a != null) {
            a.onScrolled(i, i2);
        }
    }

    public void e(String str) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.remove(str);
    }

    public void f(String str, PlatformManager.ScrollListener scrollListener) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, scrollListener);
    }

    @Override // com.alibaba.android.bindingx.core.PlatformManager.IScrollFactory
    public void removeScrollListenerWith(@NonNull String str, @NonNull PlatformManager.ScrollListener scrollListener) {
        e(str);
    }
}
