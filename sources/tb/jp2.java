package tb;

import android.text.TextUtils;
import com.ut.mini.module.plugin.UTPlugin;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class jp2 extends UTPlugin {
    private ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.a.get(str) != null) {
            return false;
        }
        this.a.put(str, str2);
        return true;
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    public int[] getAttentionEventIds() {
        return new int[]{-1};
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4) {
        if (i == 2001 || i == 1010) {
            return this.a;
        }
        return null;
    }
}
