package com.youku.middlewareservice.provider;

import android.app.Activity;
import android.content.Context;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface AtlasProvider {
    void clearActivityStack();

    Field findField(Object obj, String str) throws NoSuchFieldException;

    ClassLoader getBundleClassLoader(String str);

    boolean isActivityStackEmpty();

    void load(String str, Runnable runnable, Runnable runnable2, Runnable runnable3);

    Class<?> loadClass(String str, String str2);

    Activity peekTopActivity();

    void pushToActivityStack(Activity activity);

    void updateResources(Context context, String str);
}
