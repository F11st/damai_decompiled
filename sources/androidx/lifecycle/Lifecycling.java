package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.Lifecycle;
import com.taobao.weex.annotation.JSMethod;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static Map<Class<?>, Integer> sCallbackCache = new HashMap();
    private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> sClassToAdapters = new HashMap();

    private Lifecycling() {
    }

    private static GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Nullable
    private static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String adapterName = getAdapterName(canonicalName);
            if (!name.isEmpty()) {
                adapterName = name + "." + adapterName;
            }
            Constructor declaredConstructor = Class.forName(adapterName).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAdapterName(String str) {
        return str.replace(".", JSMethod.NOT_SET) + "_LifecycleAdapter";
    }

    @NonNull
    @Deprecated
    static GenericLifecycleObserver getCallback(Object obj) {
        final LifecycleEventObserver lifecycleEventObserver = lifecycleEventObserver(obj);
        return new GenericLifecycleObserver() { // from class: androidx.lifecycle.Lifecycling.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                LifecycleEventObserver.this.onStateChanged(lifecycleOwner, event);
            }
        };
    }

    private static int getObserverConstructorType(Class<?> cls) {
        Integer num = sCallbackCache.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int resolveObserverCallbackType = resolveObserverCallbackType(cls);
        sCallbackCache.put(cls, Integer.valueOf(resolveObserverCallbackType));
        return resolveObserverCallbackType;
    }

    private static boolean isLifecycleParent(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static LifecycleEventObserver lifecycleEventObserver(Object obj) {
        boolean z = obj instanceof LifecycleEventObserver;
        boolean z2 = obj instanceof FullLifecycleObserver;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, (LifecycleEventObserver) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, null);
        }
        if (z) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (getObserverConstructorType(cls) == 2) {
            List<Constructor<? extends GeneratedAdapter>> list = sClassToAdapters.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(createGeneratedAdapter(list.get(0), obj));
            }
            GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
            for (int i = 0; i < list.size(); i++) {
                generatedAdapterArr[i] = createGeneratedAdapter(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    private static int resolveObserverCallbackType(Class<?> cls) {
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> generatedConstructor = generatedConstructor(cls);
        if (generatedConstructor != null) {
            sClassToAdapters.put(cls, Collections.singletonList(generatedConstructor));
            return 2;
        } else if (ClassesInfoCache.sInstance.hasLifecycleMethods(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (isLifecycleParent(superclass)) {
                if (getObserverConstructorType(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(sClassToAdapters.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (isLifecycleParent(cls2)) {
                    if (getObserverConstructorType(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(sClassToAdapters.get(cls2));
                }
            }
            if (arrayList != null) {
                sClassToAdapters.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }
}
