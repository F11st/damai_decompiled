package com.youku.arch.solid;

import android.os.Build;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.log.SLog;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SoLoader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "LibLoader";
    private static volatile boolean hasAppendLibSearchPath;

    SoLoader() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean appendLibSearchPath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "11013387")) {
            return ((Boolean) ipChange.ipc$dispatch("11013387", new Object[]{str})).booleanValue();
        }
        if (hasAppendLibSearchPath) {
            SLog.e(TAG, "do not append lib path twice");
            return false;
        }
        hasAppendLibSearchPath = true;
        ClassLoader classLoader = SoLoader.class.getClassLoader();
        if (classLoader == null) {
            SLog.e(TAG, "ClassLoader is null.");
            return false;
        }
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            SLog.e(TAG, "Can't create solid library dir.");
            return false;
        }
        try {
            Object obj = findField(classLoader, "pathList").get(classLoader);
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                expandFieldArray(obj, "nativeLibraryDirectories", new Object[]{file});
            } else {
                expandFieldList(obj, "nativeLibraryDirectories", file);
            }
            if (i >= 23) {
                expandFieldArray(obj, "nativeLibraryPathElements", new Object[]{makeNativeLibraryElement(file)});
            }
            return true;
        } catch (Exception e) {
            SLog.e(TAG, "Expand library search path failed: " + e.getMessage());
            return false;
        }
    }

    private static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "140917647")) {
            ipChange.ipc$dispatch("140917647", new Object[]{obj, str, objArr});
            return;
        }
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            objArr3[i] = objArr[i];
        }
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        findField.set(obj, objArr3);
    }

    private static void expandFieldList(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751680665")) {
            ipChange.ipc$dispatch("1751680665", new Object[]{obj, str, obj2});
        } else {
            ((List) findField(obj, str).get(obj)).add(0, obj2);
        }
    }

    private static Field findField(Object obj, String str) throws NoSuchFieldException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1186292759")) {
            return (Field) ipChange.ipc$dispatch("1186292759", new Object[]{obj, str});
        }
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Constructor getElementConstructor(Class cls, Class... clsArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394136415")) {
            return (Constructor) ipChange.ipc$dispatch("-394136415", new Object[]{cls, clsArr});
        }
        try {
            return cls.getDeclaredConstructor(clsArr);
        } catch (Throwable unused) {
            Log.w(TAG, "can not create element by args" + clsArr);
            return null;
        }
    }

    private static Object makeNativeLibraryElement(File file) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573736236")) {
            return ipChange.ipc$dispatch("573736236", new Object[]{file});
        }
        int i = Build.VERSION.SDK_INT;
        if (i <= 25 && (i != 25 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            try {
                Constructor elementConstructor = getElementConstructor(Class.forName("dalvik.system.DexPathList$Element"), File.class, Boolean.TYPE, File.class, DexFile.class);
                if (elementConstructor != null) {
                    return elementConstructor.newInstance(file, Boolean.TRUE, null, null);
                }
                throw new IOException("make nativeElement fail | error constructor");
            } catch (Exception e) {
                throw new IOException("make nativeElement fail", e);
            }
        }
        try {
            Constructor<?> declaredConstructor = Class.forName("dalvik.system.DexPathList$NativeLibraryElement").getDeclaredConstructor(File.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(file);
        } catch (Exception e2) {
            throw new IOException("make nativeElement fail", e2);
        }
    }
}
