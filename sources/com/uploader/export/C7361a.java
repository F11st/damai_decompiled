package com.uploader.export;

import com.uploader.implement.UploaderManager;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.uploader.export.a */
/* loaded from: classes11.dex */
public class C7361a {
    private static final ConcurrentHashMap<Integer, IUploaderManager> a = new ConcurrentHashMap<>();

    public static IUploaderManager a() throws RuntimeException {
        return b(0);
    }

    public static IUploaderManager b(int i) {
        IUploaderDependency a2;
        ConcurrentHashMap<Integer, IUploaderManager> concurrentHashMap = a;
        IUploaderManager iUploaderManager = concurrentHashMap.get(Integer.valueOf(i));
        if (iUploaderManager != null) {
            return iUploaderManager;
        }
        synchronized (C7361a.class) {
            IUploaderManager iUploaderManager2 = concurrentHashMap.get(Integer.valueOf(i));
            if (iUploaderManager2 != null) {
                return iUploaderManager2;
            }
            Constructor declaredConstructor = UploaderManager.class.getDeclaredConstructor(Integer.TYPE);
            declaredConstructor.setAccessible(true);
            IUploaderManager iUploaderManager3 = (IUploaderManager) declaredConstructor.newInstance(Integer.valueOf(i));
            concurrentHashMap.put(Integer.valueOf(i), iUploaderManager3);
            if (!iUploaderManager3.isInitialized() && (a2 = UploaderGlobal.a(Integer.valueOf(i))) != null) {
                iUploaderManager3.initialize(UploaderGlobal.f(), a2);
            }
            return iUploaderManager3;
        }
    }
}
