package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.poplayer.factory.PLViewInfo;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class k81 {
    public static final String TAG = "k81";
    private final HashMap<String, Class<? extends PopLayerBaseView>> a;
    private Class<? extends PopLayerBaseView> b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.k81$b */
    /* loaded from: classes8.dex */
    public static class C9342b {
        private static k81 a = new k81();
    }

    public static k81 b() {
        return C9342b.a;
    }

    public PopLayerBaseView a(Context context, String str) {
        Class<? extends PopLayerBaseView> cls;
        Class<? extends PopLayerBaseView> cls2 = this.a.get(str);
        if (cls2 == null && TextUtils.isEmpty(str) && (cls = this.b) != null) {
            dt1.b("%s.create:use baseItem.", TAG);
            cls2 = cls;
        }
        if (cls2 == null) {
            dt1.b("%s.create:can't find type.", TAG);
            return null;
        }
        try {
            Constructor<? extends PopLayerBaseView> declaredConstructor = cls2.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(context);
        } catch (Throwable th) {
            dt1.c(TAG + ".newInstance fail!", th);
            return null;
        }
    }

    public void c(Class<? extends PopLayerBaseView> cls) {
        if (cls != null) {
            PLViewInfo pLViewInfo = (PLViewInfo) cls.getAnnotation(PLViewInfo.class);
            if (pLViewInfo != null) {
                if (!this.a.containsKey(pLViewInfo.type())) {
                    this.a.put(pLViewInfo.type(), cls);
                    if (pLViewInfo.isDefaultType()) {
                        this.b = cls;
                        return;
                    }
                    return;
                }
                throw new RuntimeException("type:" + pLViewInfo.type() + " already registered.");
            }
            throw new RuntimeException("no annotation " + PLViewInfo.class.getName() + " found for " + cls);
        }
        throw new RuntimeException("class is null;");
    }

    private k81() {
        this.a = new HashMap<>();
    }
}
