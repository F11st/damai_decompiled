package tb;

import com.taobao.application.common.IAppPreferences;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a7 implements IAppPreferences {
    private static final a7 b = new a7();
    private final Map<String, Object> a = new ConcurrentHashMap();

    private a7() {
    }

    private <T> T a(String str) {
        return (T) this.a.get(str);
    }

    public static a7 b() {
        return b;
    }

    private void g(String str, Object obj) {
        Object put;
        if (str != null && obj != null && (put = this.a.put(str, obj)) != null && put.getClass() != obj.getClass()) {
            throw new IllegalArgumentException(String.format("new value type:%s != old value type:%s", obj.getClass(), put.getClass()));
        }
    }

    public void c(String str, boolean z) {
        g(str, Boolean.valueOf(z));
    }

    public void d(String str, int i) {
        g(str, Integer.valueOf(i));
    }

    public void e(String str, long j) {
        g(str, Long.valueOf(j));
    }

    public void f(String str, String str2) {
        g(str, str2);
    }

    @Override // com.taobao.application.common.IAppPreferences
    public boolean getBoolean(String str, boolean z) {
        Boolean bool = (Boolean) a(str);
        return bool != null ? bool.booleanValue() : z;
    }

    @Override // com.taobao.application.common.IAppPreferences
    public float getFloat(String str, float f) {
        Float f2 = (Float) a(str);
        return f2 != null ? f2.floatValue() : f;
    }

    @Override // com.taobao.application.common.IAppPreferences
    public int getInt(String str, int i) {
        Integer num = (Integer) a(str);
        return num != null ? num.intValue() : i;
    }

    @Override // com.taobao.application.common.IAppPreferences
    public long getLong(String str, long j) {
        Long l = (Long) a(str);
        return l != null ? l.longValue() : j;
    }

    @Override // com.taobao.application.common.IAppPreferences
    public String getString(String str, String str2) {
        String str3 = (String) a(str);
        return str3 != null ? str3 : str2;
    }
}
