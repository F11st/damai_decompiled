package com.uc.sandboxExport;

import android.annotation.SuppressLint;
import android.os.ParcelFileDescriptor;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Field;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class DexFileClassLoader extends BaseDexClassLoader {
    private DexFile a;

    public DexFileClassLoader(String str, String str2, String str3, ClassLoader classLoader, ParcelFileDescriptor parcelFileDescriptor, String str4, DexFile dexFile) throws Throwable {
        super(parcelFileDescriptor != null ? str4 : str, parcelFileDescriptor == null ? new File(str2) : null, str3, classLoader);
        if (parcelFileDescriptor != null) {
            dexFile = dexFile == null ? new DexFile(str4) : dexFile;
            Object loadDexByFd = DexFileResolver.loadDexByFd(parcelFileDescriptor.getFd());
            if (loadDexByFd != null) {
                Field declaredField = dexFile.getClass().getDeclaredField("mCookie");
                declaredField.setAccessible(true);
                declaredField.set(dexFile, loadDexByFd);
                this.a = dexFile;
                return;
            }
            throw new Exception("cannot load DexFile!");
        }
    }

    private Class<?> a(String str) throws ClassNotFoundException {
        DexFile dexFile = this.a;
        Class loadClass = dexFile != null ? dexFile.loadClass(str, this) : null;
        try {
            loadClass = super.findClass(str);
        } catch (ClassNotFoundException unused) {
        }
        if (loadClass == null) {
            loadClass = findLoadedClass(str);
        }
        return loadClass == null ? getParent().loadClass(str) : loadClass;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    @SuppressLint({"NewApi"})
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            return a(str);
        } catch (ClassNotFoundException unused) {
            return a(str);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        return (findLibrary == null && (getParent() instanceof BaseDexClassLoader)) ? ((BaseDexClassLoader) getParent()).findLibrary(str) : findLibrary;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("com.uc.") && !str.startsWith("org.chromium.")) {
            return super.loadClass(str, z);
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        return findLoadedClass == null ? findClass(str) : findLoadedClass;
    }
}
