package tb;

import cn.damai.common.db.db.annotation.Column;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class uk2 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static void a(Class<?> cls, HashMap<String, uk> hashMap) {
        Field[] declaredFields;
        Column column;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-273427918")) {
            ipChange.ipc$dispatch("-273427918", new Object[]{cls, hashMap});
        } else if (!Object.class.equals(cls)) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && (column = (Column) field.getAnnotation(Column.class)) != null && tk.c(field.getType())) {
                        uk ukVar = new uk(cls, field, column);
                        if (!hashMap.containsKey(ukVar.d())) {
                            hashMap.put(ukVar.d(), ukVar);
                        }
                    }
                }
                a(cls.getSuperclass(), hashMap);
            } catch (Throwable th) {
                gb1.c(th.getMessage(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized LinkedHashMap<String, uk> b(Class<?> cls) {
        synchronized (uk2.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1450790050")) {
                return (LinkedHashMap) ipChange.ipc$dispatch("-1450790050", new Object[]{cls});
            }
            LinkedHashMap<String, uk> linkedHashMap = new LinkedHashMap<>();
            a(cls, linkedHashMap);
            return linkedHashMap;
        }
    }
}
