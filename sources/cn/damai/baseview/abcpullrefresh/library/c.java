package cn.damai.baseview.abcpullrefresh.library;

import android.content.Context;
import android.view.View;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import tb.b1;
import tb.n72;
import tb.pw2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Class<?>[] a = new Class[0];
    private static final HashMap<Class, Class> b = new HashMap<>();

    static {
        a(b1.SUPPORTED_VIEW_CLASSES, b1.class);
        a(n72.SUPPORTED_VIEW_CLASSES, n72.class);
    }

    private static void a(Class[] clsArr, Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631480904")) {
            ipChange.ipc$dispatch("-631480904", new Object[]{clsArr, cls});
            return;
        }
        for (Class cls2 : clsArr) {
            b.put(cls2, cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewDelegate b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844812488")) {
            return (ViewDelegate) ipChange.ipc$dispatch("-844812488", new Object[]{view});
        }
        for (Map.Entry<Class, Class> entry : b.entrySet()) {
            if (entry.getKey().isInstance(view)) {
                return (ViewDelegate) d(view.getContext(), entry.getValue(), a, new Object[0]);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T c(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-752671851")) {
            return (T) ipChange.ipc$dispatch("-752671851", new Object[]{context, str});
        }
        try {
            return (T) d(context, context.getClassLoader().loadClass(str), a, new Object[0]);
        } catch (Exception e) {
            pw2.d("InstanceCreationUtils", "Cannot instantiate class: " + str + e.getMessage());
            return null;
        }
    }

    private static <T> T d(Context context, Class cls, Class[] clsArr, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1089734990")) {
            return (T) ipChange.ipc$dispatch("-1089734990", new Object[]{context, cls, clsArr, objArr});
        }
        try {
            return cls.getConstructor(clsArr).newInstance(objArr);
        } catch (Exception e) {
            pw2.d("InstanceCreationUtils", "Cannot instantiate class: " + cls.getName() + e.getMessage());
            return null;
        }
    }
}
