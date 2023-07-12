package tb;

import com.taobao.android.AliLogInterface;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class o4 {
    private static AliLogInterface a;

    public static <T> T a(Class<T> cls) {
        T t = (T) a;
        if (t != null) {
            return t;
        }
        T t2 = (T) b(cls);
        if (t2 != null) {
            a = (AliLogInterface) t2;
        }
        return t2;
    }

    private static <T> T b(Class<T> cls) {
        String str;
        Class cls2;
        String name = cls.getName();
        if (name.endsWith("Interface")) {
            str = name.replace("Interface", "Imp");
        } else {
            str = name + "Imp";
        }
        try {
            try {
                Method declaredMethod = Class.forName(str).getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    return (T) declaredMethod.invoke(null, new Object[0]);
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return (T) cls2.newInstance();
                } catch (Exception unused) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static AliLogInterface c() {
        Object a2 = a(AliLogInterface.class);
        if (a2 instanceof AliLogInterface) {
            return (AliLogInterface) a2;
        }
        return null;
    }
}
