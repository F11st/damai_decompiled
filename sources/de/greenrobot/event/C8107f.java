package de.greenrobot.event;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: de.greenrobot.event.f */
/* loaded from: classes3.dex */
class C8107f {
    private static final Map<String, List<C8106e>> b = new HashMap();
    private final Map<Class<?>, Class<?>> a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8107f(List<Class<?>> list) {
        if (list != null) {
            for (Class<?> cls : list) {
                this.a.put(cls, cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<C8106e> a(Class<?> cls) {
        List<C8106e> list;
        Method[] declaredMethods;
        ThreadMode threadMode;
        String name = cls.getName();
        Map<String, List<C8106e>> map = b;
        synchronized (map) {
            list = map.get(name);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name2 = cls2.getName();
            if (name2.startsWith("java.") || name2.startsWith("javax.") || name2.startsWith("android.")) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name3 = method.getName();
                if (name3.startsWith("onEvent")) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            String substring = name3.substring(7);
                            if (substring.length() == 0) {
                                threadMode = ThreadMode.PostThread;
                            } else if (substring.equals("MainThread")) {
                                threadMode = ThreadMode.MainThread;
                            } else if (substring.equals("BackgroundThread")) {
                                threadMode = ThreadMode.BackgroundThread;
                            } else if (substring.equals("Async")) {
                                threadMode = ThreadMode.Async;
                            } else if (!this.a.containsKey(cls2)) {
                                throw new EventBusException("Illegal onEvent method, check for typos: " + method);
                            }
                            Class<?> cls3 = parameterTypes[0];
                            sb.setLength(0);
                            sb.append(name3);
                            sb.append('>');
                            sb.append(cls3.getName());
                            if (hashSet.add(sb.toString())) {
                                arrayList.add(new C8106e(method, threadMode, cls3));
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.a.containsKey(cls2)) {
                        Log.d(EventBus.p, "Skipping method (not public, static or abstract): " + cls2 + "." + name3);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Map<String, List<C8106e>> map2 = b;
            synchronized (map2) {
                map2.put(name, arrayList);
            }
            return arrayList;
        }
        throw new EventBusException("Subscriber " + cls + " has no public methods called onEvent");
    }
}
