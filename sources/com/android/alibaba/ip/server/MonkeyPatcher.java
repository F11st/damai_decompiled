package com.android.alibaba.ip.server;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;
import android.view.ContextThemeWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MonkeyPatcher {
    public static Object getActivityThread(Context context, Class<?> cls) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        if (cls == null) {
            try {
                cls = Class.forName("android.app.ActivityThread");
            } catch (Throwable unused) {
                return null;
            }
        }
        Method method = cls.getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null || context == null) {
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        Object obj = field.get(context);
        Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static void monkeyPatchExistingResources(Context context, String str, Collection<Activity> collection) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InstantiationException {
        Collection<WeakReference> values;
        if (str != null) {
            AssetManager assetManager = (AssetManager) AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
            Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            declaredMethod.setAccessible(true);
            if (((Integer) declaredMethod.invoke(assetManager, str)).intValue() != 0) {
                Method declaredMethod2 = AssetManager.class.getDeclaredMethod("ensureStringBlocks", new Class[0]);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(assetManager, new Object[0]);
                if (collection != null) {
                    for (Activity activity : collection) {
                        Resources resources = activity.getResources();
                        try {
                            Field declaredField = Resources.class.getDeclaredField("mAssets");
                            declaredField.setAccessible(true);
                            declaredField.set(resources, assetManager);
                        } catch (Throwable th) {
                            new IllegalStateException(th);
                        }
                        Resources.Theme theme = activity.getTheme();
                        try {
                            Field declaredField2 = Resources.Theme.class.getDeclaredField("mAssets");
                            declaredField2.setAccessible(true);
                            declaredField2.set(theme, assetManager);
                        } catch (NoSuchFieldException unused) {
                            Field declaredField3 = Resources.Theme.class.getDeclaredField("mThemeImpl");
                            declaredField3.setAccessible(true);
                            Object obj = declaredField3.get(theme);
                            Field declaredField4 = obj.getClass().getDeclaredField("mAssets");
                            declaredField4.setAccessible(true);
                            declaredField4.set(obj, assetManager);
                        } catch (Throwable th2) {
                            Log.e(Logging.LOG_TAG, "Failed to update existing theme for activity " + activity, th2);
                        }
                        Field declaredField5 = ContextThemeWrapper.class.getDeclaredField("mTheme");
                        declaredField5.setAccessible(true);
                        declaredField5.set(activity, null);
                        Method declaredMethod3 = ContextThemeWrapper.class.getDeclaredMethod("initializeTheme", new Class[0]);
                        declaredMethod3.setAccessible(true);
                        declaredMethod3.invoke(activity, new Object[0]);
                        if (Build.VERSION.SDK_INT < 24) {
                            Method declaredMethod4 = AssetManager.class.getDeclaredMethod("createTheme", new Class[0]);
                            declaredMethod4.setAccessible(true);
                            Object invoke = declaredMethod4.invoke(assetManager, new Object[0]);
                            Field declaredField6 = Resources.Theme.class.getDeclaredField("mTheme");
                            declaredField6.setAccessible(true);
                            declaredField6.set(theme, invoke);
                        }
                        pruneResourceCaches(resources);
                    }
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    Class<?> cls = Class.forName("android.app.ResourcesManager");
                    Method declaredMethod5 = cls.getDeclaredMethod("getInstance", new Class[0]);
                    declaredMethod5.setAccessible(true);
                    Object invoke2 = declaredMethod5.invoke(null, new Object[0]);
                    try {
                        Field declaredField7 = cls.getDeclaredField("mActiveResources");
                        declaredField7.setAccessible(true);
                        values = ((ArrayMap) declaredField7.get(invoke2)).values();
                    } catch (NoSuchFieldException unused2) {
                        Field declaredField8 = cls.getDeclaredField("mResourceReferences");
                        declaredField8.setAccessible(true);
                        values = (Collection) declaredField8.get(invoke2);
                    }
                } else {
                    Class<?> cls2 = Class.forName("android.app.ActivityThread");
                    Field declaredField9 = cls2.getDeclaredField("mActiveResources");
                    declaredField9.setAccessible(true);
                    values = ((HashMap) declaredField9.get(getActivityThread(context, cls2))).values();
                }
                for (WeakReference weakReference : values) {
                    Resources resources2 = (Resources) weakReference.get();
                    if (resources2 != null) {
                        try {
                            Field declaredField10 = Resources.class.getDeclaredField("mAssets");
                            declaredField10.setAccessible(true);
                            declaredField10.set(resources2, assetManager);
                        } catch (Throwable unused3) {
                            Field declaredField11 = Resources.class.getDeclaredField("mResourcesImpl");
                            declaredField11.setAccessible(true);
                            Object obj2 = declaredField11.get(resources2);
                            Field declaredField12 = obj2.getClass().getDeclaredField("mAssets");
                            declaredField12.setAccessible(true);
                            declaredField12.set(obj2, assetManager);
                        }
                        resources2.updateConfiguration(resources2.getConfiguration(), resources2.getDisplayMetrics());
                    }
                }
                return;
            }
            throw new IllegalStateException("Could not create new AssetManager");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean pruneResourceCache(java.lang.Object r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.alibaba.ip.server.MonkeyPatcher.pruneResourceCache(java.lang.Object, java.lang.String):boolean");
    }

    private static void pruneResourceCaches(Object obj) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mTypedArrayPool");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                Method declaredMethod = obj2.getClass().getDeclaredMethod("acquire", new Class[0]);
                declaredMethod.setAccessible(true);
                do {
                } while (declaredMethod.invoke(obj2, new Object[0]) != null);
            } catch (Throwable unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Field declaredField2 = Resources.class.getDeclaredField("mResourcesImpl");
                declaredField2.setAccessible(true);
                obj = declaredField2.get(obj);
            } catch (Throwable unused2) {
            }
        }
        Object obj3 = null;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                Field declaredField3 = obj.getClass().getDeclaredField("mAccessLock");
                declaredField3.setAccessible(true);
                obj3 = declaredField3.get(obj);
            } else {
                Field declaredField4 = Resources.class.getDeclaredField("mTmpValue");
                declaredField4.setAccessible(true);
                obj3 = declaredField4.get(obj);
            }
        } catch (Throwable unused3) {
        }
        if (obj3 == null) {
            obj3 = MonkeyPatcher.class;
        }
        synchronized (obj3) {
            pruneResourceCache(obj, "mDrawableCache");
            pruneResourceCache(obj, "mColorDrawableCache");
            pruneResourceCache(obj, "mColorStateListCache");
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                pruneResourceCache(obj, "mAnimatorCache");
                pruneResourceCache(obj, "mStateListAnimatorCache");
            } else if (i == 19) {
                pruneResourceCache(obj, "sPreloadedDrawables");
                pruneResourceCache(obj, "sPreloadedColorDrawables");
                pruneResourceCache(obj, "sPreloadedColorStateLists");
            }
        }
    }
}
