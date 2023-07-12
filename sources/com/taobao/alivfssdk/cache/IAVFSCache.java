package com.taobao.alivfssdk.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IAVFSCache extends Closeable {
    public static final int CACHE_KEY_NO_ENCRYPTION = 268435456;
    public static final int ENCRYPTED = 1;
    public static final int NAME_MD5 = 8;
    public static final int PERSIST = 4;
    public static final int VERIFY = 2;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnAllObjectRemoveCallback {
        void onAllObjectRemoveCallback(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnObjectContainedCallback {
        void onObjectContainedCallback(@NonNull String str, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnObjectContainedCallback2 {
        void onObjectContainedCallback(@NonNull String str, String str2, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnObjectGetCallback<T> {
        void onObjectGetCallback(@NonNull String str, @Nullable Object obj);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnObjectGetCallback2<T> {
        void onObjectGetCallback(@NonNull String str, String str2, @Nullable Object obj);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnObjectRemoveCallback {
        void onObjectRemoveCallback(@NonNull String str, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnObjectRemoveCallback2 {
        void onObjectRemoveCallback(@NonNull String str, String str2, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnObjectSetCallback {
        void onObjectSetCallback(@NonNull String str, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnObjectSetCallback2 {
        void onObjectSetCallback(@NonNull String str, String str2, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnStreamGetCallback {
        void onStreamGetCallback(@NonNull String str, InputStream inputStream);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnStreamGetCallback2 {
        void onStreamGetCallback(@NonNull String str, String str2, InputStream inputStream);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnStreamSetCallback {
        void onStreamSetCallback(@NonNull String str, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnStreamSetCallback2 {
        void onStreamSetCallback(@NonNull String str, String str2, boolean z);
    }

    void clearMemCache();

    void containObjectForKey(@NonNull String str, OnObjectContainedCallback onObjectContainedCallback);

    void containObjectForKey(@NonNull String str, String str2, OnObjectContainedCallback2 onObjectContainedCallback2);

    boolean containObjectForKey(@NonNull String str);

    boolean containObjectForKey(@NonNull String str, int i);

    boolean containObjectForKey(@NonNull String str, String str2);

    boolean containObjectForKey(@NonNull String str, String str2, int i);

    List<String> extendsKeysForKey(@NonNull String str);

    List<String> extendsKeysForKey(@NonNull String str, int i);

    @Nullable
    InputStream inputStreamForKey(@NonNull String str);

    InputStream inputStreamForKey(@NonNull String str, String str2);

    InputStream inputStreamForKey(@NonNull String str, String str2, int i);

    void inputStreamForKey(@NonNull String str, OnStreamGetCallback onStreamGetCallback);

    void inputStreamForKey(@NonNull String str, String str2, OnStreamGetCallback2 onStreamGetCallback2);

    Set<String> keySet();

    long lengthForKey(String str);

    long lengthForKey(String str, String str2);

    long lengthForKey(String str, String str2, int i);

    @Nullable
    <T> T objectForKey(@NonNull String str);

    @Nullable
    <T> T objectForKey(@NonNull String str, int i);

    @Nullable
    <T> T objectForKey(@NonNull String str, Class<T> cls);

    @Nullable
    <T> T objectForKey(@NonNull String str, String str2);

    @Nullable
    <T> T objectForKey(@NonNull String str, String str2, Class<T> cls);

    @Nullable
    <T> T objectForKey(@NonNull String str, String str2, Class<T> cls, int i);

    <T> void objectForKey(@NonNull String str, Class<T> cls, OnObjectGetCallback<T> onObjectGetCallback);

    <T> void objectForKey(@NonNull String str, String str2, Class<T> cls, OnObjectGetCallback2<T> onObjectGetCallback2);

    void removeAllObject(OnAllObjectRemoveCallback onAllObjectRemoveCallback);

    boolean removeAllObject();

    void removeObjectForKey(@NonNull String str, OnObjectRemoveCallback onObjectRemoveCallback);

    void removeObjectForKey(@NonNull String str, String str2, OnObjectRemoveCallback2 onObjectRemoveCallback2);

    boolean removeObjectForKey(@NonNull String str);

    boolean removeObjectForKey(@NonNull String str, int i);

    boolean removeObjectForKey(@NonNull String str, String str2);

    boolean removeObjectForKey(@NonNull String str, String str2, int i);

    void setObjectForKey(@NonNull String str, Object obj, int i, OnObjectSetCallback onObjectSetCallback);

    void setObjectForKey(@NonNull String str, Object obj, OnObjectSetCallback onObjectSetCallback);

    void setObjectForKey(@NonNull String str, String str2, Object obj, int i, OnObjectSetCallback2 onObjectSetCallback2);

    void setObjectForKey(@NonNull String str, String str2, Object obj, OnObjectSetCallback2 onObjectSetCallback2);

    boolean setObjectForKey(@NonNull String str, Object obj);

    boolean setObjectForKey(@NonNull String str, Object obj, int i);

    boolean setObjectForKey(@NonNull String str, String str2, Object obj);

    boolean setObjectForKey(@NonNull String str, String str2, Object obj, int i);

    void setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, int i, OnStreamSetCallback onStreamSetCallback);

    void setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, OnStreamSetCallback onStreamSetCallback);

    void setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, int i, OnStreamSetCallback2 onStreamSetCallback2);

    void setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, OnStreamSetCallback2 onStreamSetCallback2);

    boolean setStreamForKey(@NonNull String str, @NonNull InputStream inputStream);

    boolean setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, int i);

    boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream);

    boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, int i);
}
