package tb;

import android.text.TextUtils;
import com.uploader.implement.a.InterfaceC7374f;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i33 implements InterfaceC7374f {
    final int a;
    final Map<String, String> b;
    public final Object[] c;

    public i33(int i, Map<String, String> map, Object... objArr) {
        this.a = i;
        this.b = map;
        this.c = objArr;
    }

    public int a() {
        return this.a;
    }

    public String b(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.b) == null) {
            return null;
        }
        return map.get(str);
    }

    public Map<String, String> c() {
        return this.b;
    }

    public i33(int i, Map<String, String> map) {
        this.a = i;
        this.b = map;
        this.c = null;
    }
}
