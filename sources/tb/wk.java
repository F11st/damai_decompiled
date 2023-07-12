package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class wk {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final HashSet<Class<?>> a;
    private static final HashSet<Class<?>> b;
    private static final HashSet<Class<?>> c;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>(2);
        a = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>(2);
        b = hashSet2;
        HashSet<Class<?>> hashSet3 = new HashSet<>(4);
        c = hashSet3;
        hashSet.add(Boolean.TYPE);
        hashSet.add(Boolean.class);
        hashSet2.add(Integer.TYPE);
        hashSet2.add(Integer.class);
        hashSet3.addAll(hashSet2);
        hashSet3.add(Long.TYPE);
        hashSet3.add(Long.class);
    }

    public static Object a(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "421910080") ? ipChange.ipc$dispatch("421910080", new Object[]{obj}) : obj != null ? tk.a(obj.getClass()).fieldValue2DbValue(obj) : obj;
    }

    private static Method b(Class<?> cls, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894897443")) {
            return (Method) ipChange.ipc$dispatch("-894897443", new Object[]{cls, str});
        }
        if (!str.startsWith("is")) {
            str = "is" + str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        try {
            return cls.getDeclaredMethod(str, new Class[0]);
        } catch (NoSuchMethodException unused) {
            gb1.a(cls.getName() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + " not exist");
            return null;
        }
    }

    private static Method c(Class<?> cls, String str, Class<?> cls2) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854501230")) {
            return (Method) ipChange.ipc$dispatch("854501230", new Object[]{cls, str, cls2});
        }
        if (str.startsWith("is")) {
            str2 = "set" + str.substring(2, 3).toUpperCase() + str.substring(3);
        } else {
            str2 = "set" + str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        try {
            return cls.getDeclaredMethod(str2, cls2);
        } catch (NoSuchMethodException unused) {
            gb1.a(cls.getName() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str2 + " not exist");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method d(Class<?> cls, Field field) {
        String name;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942031792")) {
            return (Method) ipChange.ipc$dispatch("-942031792", new Object[]{cls, field});
        }
        if (Object.class.equals(cls)) {
            return null;
        }
        Method b2 = g(field.getType()) ? b(cls, field.getName()) : null;
        if (b2 == null) {
            String str = gn1.TYPE_OPEN_URL_METHOD_GET + name.substring(0, 1).toUpperCase() + name.substring(1);
            try {
                b2 = cls.getDeclaredMethod(str, new Class[0]);
            } catch (NoSuchMethodException unused) {
                gb1.a(cls.getName() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + " not exist");
            }
        }
        return b2 == null ? d(cls.getSuperclass(), field) : b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method e(Class<?> cls, Field field) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499406684")) {
            return (Method) ipChange.ipc$dispatch("499406684", new Object[]{cls, field});
        }
        if (Object.class.equals(cls)) {
            return null;
        }
        String name = field.getName();
        Class<?> type = field.getType();
        Method c2 = g(type) ? c(cls, name, type) : null;
        if (c2 == null) {
            String str = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            try {
                c2 = cls.getDeclaredMethod(str, type);
            } catch (NoSuchMethodException unused) {
                gb1.a(cls.getName() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + " not exist");
            }
        }
        return c2 == null ? e(cls.getSuperclass(), field) : c2;
    }

    public static boolean f(Class<?> cls) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1563376289") ? ((Boolean) ipChange.ipc$dispatch("1563376289", new Object[]{cls})).booleanValue() : c.contains(cls);
    }

    public static boolean g(Class<?> cls) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1485994109") ? ((Boolean) ipChange.ipc$dispatch("-1485994109", new Object[]{cls})).booleanValue() : a.contains(cls);
    }

    public static boolean h(Class<?> cls) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-930073191") ? ((Boolean) ipChange.ipc$dispatch("-930073191", new Object[]{cls})).booleanValue() : b.contains(cls);
    }
}
