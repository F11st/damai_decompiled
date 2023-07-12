package com.taobao.alivfssdk.cache;

import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.alivfssdk.cache.IAVFSCache;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AVFSBaseCache implements IAVFSCache {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.AVFSBaseCache$a */
    /* loaded from: classes8.dex */
    class C6252a implements IAVFSCache.OnStreamGetCallback2 {
        final /* synthetic */ IAVFSCache.OnStreamGetCallback a;

        C6252a(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnStreamGetCallback onStreamGetCallback) {
            this.a = onStreamGetCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnStreamGetCallback2
        public void onStreamGetCallback(@NonNull String str, String str2, InputStream inputStream) {
            this.a.onStreamGetCallback(str, inputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.AVFSBaseCache$b */
    /* loaded from: classes8.dex */
    public class C6253b implements IAVFSCache.OnStreamSetCallback2 {
        final /* synthetic */ IAVFSCache.OnStreamSetCallback a;

        C6253b(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnStreamSetCallback onStreamSetCallback) {
            this.a = onStreamSetCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnStreamSetCallback2
        public void onStreamSetCallback(@NonNull String str, String str2, boolean z) {
            this.a.onStreamSetCallback(str, z);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.AVFSBaseCache$c */
    /* loaded from: classes8.dex */
    class C6254c implements IAVFSCache.OnObjectContainedCallback2 {
        final /* synthetic */ IAVFSCache.OnObjectContainedCallback a;

        C6254c(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnObjectContainedCallback onObjectContainedCallback) {
            this.a = onObjectContainedCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectContainedCallback2
        public void onObjectContainedCallback(@NonNull String str, String str2, boolean z) {
            this.a.onObjectContainedCallback(str, z);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.AVFSBaseCache$d */
    /* loaded from: classes8.dex */
    class C6255d<T> implements IAVFSCache.OnObjectGetCallback2<T> {
        final /* synthetic */ IAVFSCache.OnObjectGetCallback a;

        C6255d(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnObjectGetCallback onObjectGetCallback) {
            this.a = onObjectGetCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectGetCallback2
        public void onObjectGetCallback(@NonNull String str, String str2, Object obj) {
            this.a.onObjectGetCallback(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.AVFSBaseCache$e */
    /* loaded from: classes8.dex */
    public class C6256e implements IAVFSCache.OnObjectSetCallback2 {
        final /* synthetic */ IAVFSCache.OnObjectSetCallback a;

        C6256e(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnObjectSetCallback onObjectSetCallback) {
            this.a = onObjectSetCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectSetCallback2
        public void onObjectSetCallback(@NonNull String str, String str2, boolean z) {
            this.a.onObjectSetCallback(str, z);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.cache.AVFSBaseCache$f */
    /* loaded from: classes8.dex */
    class C6257f implements IAVFSCache.OnObjectRemoveCallback2 {
        final /* synthetic */ IAVFSCache.OnObjectRemoveCallback a;

        C6257f(AVFSBaseCache aVFSBaseCache, IAVFSCache.OnObjectRemoveCallback onObjectRemoveCallback) {
            this.a = onObjectRemoveCallback;
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectRemoveCallback2
        public void onObjectRemoveCallback(@NonNull String str, String str2, boolean z) {
            this.a.onObjectRemoveCallback(str, z);
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str) {
        return containObjectForKey(str, (String) null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public InputStream inputStreamForKey(@NonNull String str) {
        return inputStreamForKey(str, (String) null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str) {
        return lengthForKey(str, null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str) {
        return (T) objectForKey(str, (String) null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeAllObject(final IAVFSCache.OnAllObjectRemoveCallback onAllObjectRemoveCallback) {
        AsyncTask.execute(new Runnable() { // from class: com.taobao.alivfssdk.cache.AVFSBaseCache.10
            @Override // java.lang.Runnable
            public void run() {
                onAllObjectRemoveCallback.onAllObjectRemoveCallback(AVFSBaseCache.this.removeAllObject());
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str) {
        return removeObjectForKey(str, (String) null);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, Object obj) {
        return setObjectForKey(str, (String) null, obj);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, @NonNull InputStream inputStream) {
        return setStreamForKey(str, (String) null, inputStream);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void containObjectForKey(@NonNull String str, IAVFSCache.OnObjectContainedCallback onObjectContainedCallback) {
        containObjectForKey(str, (String) null, new C6254c(this, onObjectContainedCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void inputStreamForKey(@NonNull String str, IAVFSCache.OnStreamGetCallback onStreamGetCallback) {
        inputStreamForKey(str, (String) null, new C6252a(this, onStreamGetCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, Class<T> cls) {
        return (T) objectForKey(str, (String) null, cls);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeObjectForKey(@NonNull String str, IAVFSCache.OnObjectRemoveCallback onObjectRemoveCallback) {
        removeObjectForKey(str, (String) null, new C6257f(this, onObjectRemoveCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, String str2, Object obj) {
        return setObjectForKey(str, (String) null, obj, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream) {
        return setStreamForKey(str, str2, inputStream, 0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void containObjectForKey(@NonNull final String str, final String str2, final IAVFSCache.OnObjectContainedCallback2 onObjectContainedCallback2) {
        AsyncTask.execute(new Runnable() { // from class: com.taobao.alivfssdk.cache.AVFSBaseCache.2
            @Override // java.lang.Runnable
            public void run() {
                IAVFSCache.OnObjectContainedCallback2 onObjectContainedCallback22 = onObjectContainedCallback2;
                String str3 = str;
                String str4 = str2;
                onObjectContainedCallback22.onObjectContainedCallback(str3, str4, AVFSBaseCache.this.containObjectForKey(str3, str4));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void inputStreamForKey(@NonNull final String str, final String str2, final IAVFSCache.OnStreamGetCallback2 onStreamGetCallback2) {
        AsyncTask.execute(new Runnable() { // from class: com.taobao.alivfssdk.cache.AVFSBaseCache.12
            @Override // java.lang.Runnable
            public void run() {
                IAVFSCache.OnStreamGetCallback2 onStreamGetCallback22 = onStreamGetCallback2;
                String str3 = str;
                String str4 = str2;
                onStreamGetCallback22.onStreamGetCallback(str3, str4, AVFSBaseCache.this.inputStreamForKey(str3, str4));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public <T> void objectForKey(@NonNull String str, Class<T> cls, IAVFSCache.OnObjectGetCallback<T> onObjectGetCallback) {
        objectForKey(str, (String) null, cls, new C6255d(this, onObjectGetCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeObjectForKey(@NonNull final String str, final String str2, final IAVFSCache.OnObjectRemoveCallback2 onObjectRemoveCallback2) {
        AsyncTask.execute(new Runnable() { // from class: com.taobao.alivfssdk.cache.AVFSBaseCache.9
            @Override // java.lang.Runnable
            public void run() {
                IAVFSCache.OnObjectRemoveCallback2 onObjectRemoveCallback22 = onObjectRemoveCallback2;
                String str3 = str;
                String str4 = str2;
                onObjectRemoveCallback22.onObjectRemoveCallback(str3, str4, AVFSBaseCache.this.removeObjectForKey(str3, str4));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, Object obj, int i) {
        return setObjectForKey(str, (String) null, obj, i);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, int i) {
        return setStreamForKey(str, (String) null, inputStream, i);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public <T> void objectForKey(@NonNull final String str, final String str2, final Class<T> cls, final IAVFSCache.OnObjectGetCallback2<T> onObjectGetCallback2) {
        AsyncTask.execute(new Runnable() { // from class: com.taobao.alivfssdk.cache.AVFSBaseCache.4
            @Override // java.lang.Runnable
            public void run() {
                IAVFSCache.OnObjectGetCallback2 onObjectGetCallback22 = onObjectGetCallback2;
                String str3 = str;
                String str4 = str2;
                onObjectGetCallback22.onObjectGetCallback(str3, str4, AVFSBaseCache.this.objectForKey(str3, str4, cls));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull String str, Object obj, IAVFSCache.OnObjectSetCallback onObjectSetCallback) {
        setObjectForKey(str, obj, 0, onObjectSetCallback);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, IAVFSCache.OnStreamSetCallback onStreamSetCallback) {
        setStreamForKey(str, inputStream, 0, onStreamSetCallback);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull final String str, final String str2, final Object obj, final IAVFSCache.OnObjectSetCallback2 onObjectSetCallback2) {
        AsyncTask.execute(new Runnable() { // from class: com.taobao.alivfssdk.cache.AVFSBaseCache.5
            @Override // java.lang.Runnable
            public void run() {
                IAVFSCache.OnObjectSetCallback2 onObjectSetCallback22 = onObjectSetCallback2;
                String str3 = str;
                String str4 = str2;
                onObjectSetCallback22.onObjectSetCallback(str3, str4, AVFSBaseCache.this.setObjectForKey(str3, str4, obj));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, IAVFSCache.OnStreamSetCallback2 onStreamSetCallback2) {
        setStreamForKey(str, str2, inputStream, 0, onStreamSetCallback2);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull String str, Object obj, int i, IAVFSCache.OnObjectSetCallback onObjectSetCallback) {
        setObjectForKey(str, (String) null, obj, new C6256e(this, onObjectSetCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, int i, IAVFSCache.OnStreamSetCallback onStreamSetCallback) {
        setStreamForKey(str, (String) null, inputStream, new C6253b(this, onStreamSetCallback));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull final String str, final String str2, final Object obj, final int i, final IAVFSCache.OnObjectSetCallback2 onObjectSetCallback2) {
        AsyncTask.execute(new Runnable() { // from class: com.taobao.alivfssdk.cache.AVFSBaseCache.7
            @Override // java.lang.Runnable
            public void run() {
                IAVFSCache.OnObjectSetCallback2 onObjectSetCallback22 = onObjectSetCallback2;
                String str3 = str;
                String str4 = str2;
                onObjectSetCallback22.onObjectSetCallback(str3, str4, AVFSBaseCache.this.setObjectForKey(str3, str4, obj, i));
            }
        });
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull final String str, final String str2, @NonNull final InputStream inputStream, int i, final IAVFSCache.OnStreamSetCallback2 onStreamSetCallback2) {
        AsyncTask.execute(new Runnable() { // from class: com.taobao.alivfssdk.cache.AVFSBaseCache.14
            @Override // java.lang.Runnable
            public void run() {
                IAVFSCache.OnStreamSetCallback2 onStreamSetCallback22 = onStreamSetCallback2;
                String str3 = str;
                String str4 = str2;
                onStreamSetCallback22.onStreamSetCallback(str3, str4, AVFSBaseCache.this.setStreamForKey(str3, str4, inputStream, 0));
            }
        });
    }
}
