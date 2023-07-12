package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.mapcore.util.gd;
import com.amap.api.mapcore.util.gi;
import com.amap.api.mapcore.util.id;
import com.amap.api.mapcore.util.t;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static boolean a = true;
    private static boolean b = true;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = true;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = true;
    private static ExceptionLogger i = null;
    private static boolean j = true;
    private static String k = "";
    private static String l = "";
    private static int m = 1;
    public static String sdcardDir = "";

    public static void disableCachedMapDataUpdate(boolean z) {
    }

    public static ExceptionLogger getExceptionLogger() {
        return i;
    }

    public static boolean getNetWorkEnable() {
        return a;
    }

    public static int getProtocol() {
        return m;
    }

    public static boolean getTextureDestroyRender() {
        return f;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return g;
    }

    public static boolean getTextureViewDestorySync() {
        return e;
    }

    public static String getVersion() {
        return "7.4.0";
    }

    public static String getWorldVectorOfflineMapStyleAssetsPath() {
        return l;
    }

    public static String getWorldVectorOfflineMapStyleFilePath() {
        return k;
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            t.a = context.getApplicationContext();
        } else {
            Log.w("MapsInitializer", "the context is null");
        }
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return b;
    }

    public static boolean isLoadWorldGridMap() {
        return c;
    }

    public static boolean isLoadWorldVectorMap() {
        return j;
    }

    public static boolean isSupportRecycleView() {
        return h;
    }

    public static void loadWorldGridMap(boolean z) {
        c = z;
    }

    public static void loadWorldVectorMap(boolean z) {
        j = z;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        gd.a(t.a, str);
    }

    public static void setBuildingHeight(int i2) {
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
        b = z;
    }

    public static void setExceptionLogger(ExceptionLogger exceptionLogger) {
        i = exceptionLogger;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            id.a = -1;
            id.b = "";
            return;
        }
        id.a = 1;
        id.b = str;
    }

    public static void setNetWorkEnable(boolean z) {
        a = z;
    }

    public static void setProtocol(int i2) {
        m = i2;
        gi.a().a(m == 2);
    }

    public static void setSupportRecycleView(boolean z) {
        h = z;
    }

    public static void setTextureDestroyedRender(boolean z) {
        f = z;
    }

    public static void setTextureSizeChangedInvoked(boolean z) {
        g = z;
    }

    public static void setTextureViewDestorySync(boolean z) {
        e = z;
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(String str) {
        l = str;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(String str) {
        k = str;
    }
}
