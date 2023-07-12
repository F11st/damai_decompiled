package com.youku.arch.v3.util;

import android.app.Activity;
import android.content.Context;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.EventHandler;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import org.joor.C8883a;
import org.joor.ReflectException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ViewUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final LruCache<String, Integer> sIdCaches = new LruCache<>(32);
    private static final HashMap<String, Integer> sFastLayoutIdCache = new HashMap<>();
    private static final HashMap<String, Integer> sFastDimenIdCache = new HashMap<>();

    public static void addFastDimenIdCache(HashMap<String, Integer> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356332256")) {
            ipChange.ipc$dispatch("1356332256", new Object[]{hashMap});
            return;
        }
        HashMap<String, Integer> hashMap2 = sFastDimenIdCache;
        synchronized (hashMap2) {
            hashMap2.putAll(hashMap);
        }
    }

    public static void addFastLayoutIdCache(HashMap<String, Integer> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119359983")) {
            ipChange.ipc$dispatch("1119359983", new Object[]{hashMap});
            return;
        }
        HashMap<String, Integer> hashMap2 = sFastLayoutIdCache;
        synchronized (hashMap2) {
            hashMap2.putAll(hashMap);
        }
    }

    public static int getDimenIdFromFastIdCache(String str) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410282712")) {
            return ((Integer) ipChange.ipc$dispatch("1410282712", new Object[]{str})).intValue();
        }
        HashMap<String, Integer> hashMap = sFastDimenIdCache;
        synchronized (hashMap) {
            num = hashMap.get(str);
        }
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static int getIdentifier(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063648344")) {
            return ((Integer) ipChange.ipc$dispatch("-1063648344", new Object[]{context, str, str2})).intValue();
        }
        int i = -1;
        if ("layout".equals(str2)) {
            i = getLayoutIdFromFastIdCache(str);
        } else if (Constants.DIMEN.equals(str2)) {
            i = getDimenIdFromFastIdCache(str);
        }
        if (i > 0) {
            return i;
        }
        String str3 = str2 + "&" + str;
        LruCache<String, Integer> lruCache = sIdCaches;
        Integer num = lruCache.get(str3);
        if (num != null && num.intValue() > 0) {
            return num.intValue();
        }
        int identifier = context.getResources().getIdentifier(str, str2, context.getClass().getPackage().getName());
        int identifier2 = identifier == 0 ? context.getResources().getIdentifier(str, str2, context.getPackageName()) : identifier;
        if (identifier2 > 0) {
            lruCache.put(str3, Integer.valueOf(identifier2));
            return identifier2;
        }
        return identifier2;
    }

    public static int getLayoutIdFromFastIdCache(String str) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649970885")) {
            return ((Integer) ipChange.ipc$dispatch("-649970885", new Object[]{str})).intValue();
        }
        HashMap<String, Integer> hashMap = sFastLayoutIdCache;
        synchronized (hashMap) {
            num = hashMap.get(str);
        }
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static LayoutInflater getLayoutInflater(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180157535")) {
            return (LayoutInflater) ipChange.ipc$dispatch("1180157535", new Object[]{context});
        }
        if (context == null) {
            context = AppInfoProviderProxy.getApplication();
        } else if (context instanceof Activity) {
            return ((Activity) context).getLayoutInflater();
        }
        return LayoutInflater.from(context);
    }

    public static Object newInstance(ClassLoader classLoader, String str, String str2, String str3, View view, EventHandler eventHandler, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "144968400")) {
            return ipChange.ipc$dispatch("144968400", new Object[]{classLoader, str, str2, str3, view, eventHandler, str4});
        }
        try {
            return C8883a.k(str, classLoader).c(str2, str3, view, eventHandler, str4).f();
        } catch (ReflectException e) {
            e.printStackTrace();
            LogUtil.e("OneArch", "newInstance " + e);
            return null;
        }
    }

    public static Object newInstance(ClassLoader classLoader, String str, String str2, String str3, View view, EventHandler eventHandler, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113199323")) {
            return ipChange.ipc$dispatch("-113199323", new Object[]{classLoader, str, str2, str3, view, eventHandler, map});
        }
        try {
            return C8883a.k(str, classLoader).c(str2, str3, view, eventHandler, map).f();
        } catch (ReflectException e) {
            LogUtil.e("ViewUtil", "newInstance " + e);
            return null;
        }
    }
}
