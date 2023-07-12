package com.taobao.alivfssdk.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ali.protodb.lsdb.Iterator;
import com.ali.protodb.lsdb.Key;
import com.ali.protodb.lsdb.LSDB;
import com.ali.protodb.lsdb.LSDBConfig;
import com.taobao.alivfssdk.cache.IAVFSCache;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class d implements IAVFSCache {
    private final LSDB a;

    private d(LSDB lsdb) {
        this.a = lsdb;
    }

    private String a(String str, String str2) {
        return str + '-' + str2;
    }

    private String c(String str) {
        return str + '-';
    }

    private String d(String str) {
        return str + '.';
    }

    public static d e(String str, int i, long j) {
        LSDBConfig lSDBConfig = new LSDBConfig();
        lSDBConfig.setWalSize(i);
        lSDBConfig.setTimeToLive(j);
        return new d(LSDB.open(str, lSDBConfig));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void clearMemCache() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void containObjectForKey(@NonNull String str, IAVFSCache.OnObjectContainedCallback onObjectContainedCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void containObjectForKey(@NonNull String str, String str2, IAVFSCache.OnObjectContainedCallback2 onObjectContainedCallback2) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, String str2) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean containObjectForKey(@NonNull String str, String str2, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public List<String> extendsKeysForKey(@NonNull String str) {
        Iterator keyIterator = this.a.keyIterator(new Key(c(str)), new Key(d(str)));
        if (keyIterator == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            Key key = (Key) keyIterator.next();
            if (key == null) {
                return arrayList;
            }
            arrayList.add(key.getStringKey());
        }
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public InputStream inputStreamForKey(@NonNull String str) {
        byte[] binary = this.a.getBinary(new Key(str));
        if (binary != null) {
            return new ByteArrayInputStream(binary);
        }
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public InputStream inputStreamForKey(@NonNull String str, String str2, int i) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void inputStreamForKey(@NonNull String str, IAVFSCache.OnStreamGetCallback onStreamGetCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void inputStreamForKey(@NonNull String str, String str2, IAVFSCache.OnStreamGetCallback2 onStreamGetCallback2) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public Set<String> keySet() {
        Iterator keyIterator = this.a.keyIterator();
        HashSet hashSet = new HashSet();
        if (keyIterator != null) {
            while (true) {
                Key key = (Key) keyIterator.next();
                if (key == null) {
                    break;
                }
                hashSet.add(key.getStringKey());
            }
        }
        return hashSet;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str) {
        return this.a.getDataSize(new Key(str));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str, String str2, int i) {
        return 0L;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, int i) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, Class<T> cls) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, String str2) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, String str2, Class<T> cls) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, String str2, Class<T> cls, int i) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public <T> void objectForKey(@NonNull String str, Class<T> cls, IAVFSCache.OnObjectGetCallback<T> onObjectGetCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public <T> void objectForKey(@NonNull String str, String str2, Class<T> cls, IAVFSCache.OnObjectGetCallback2<T> onObjectGetCallback2) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeAllObject(IAVFSCache.OnAllObjectRemoveCallback onAllObjectRemoveCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeAllObject() {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeObjectForKey(@NonNull String str, IAVFSCache.OnObjectRemoveCallback onObjectRemoveCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void removeObjectForKey(@NonNull String str, String str2, IAVFSCache.OnObjectRemoveCallback2 onObjectRemoveCallback2) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str) {
        return this.a.delete(new Key(str));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, String str2, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull String str, Object obj, int i, IAVFSCache.OnObjectSetCallback onObjectSetCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull String str, Object obj, IAVFSCache.OnObjectSetCallback onObjectSetCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull String str, String str2, Object obj, int i, IAVFSCache.OnObjectSetCallback2 onObjectSetCallback2) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setObjectForKey(@NonNull String str, String str2, Object obj, IAVFSCache.OnObjectSetCallback2 onObjectSetCallback2) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, Object obj) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, Object obj, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, String str2, Object obj) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, String str2, Object obj, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, int i, IAVFSCache.OnStreamSetCallback onStreamSetCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, IAVFSCache.OnStreamSetCallback onStreamSetCallback) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, int i, IAVFSCache.OnStreamSetCallback2 onStreamSetCallback2) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, IAVFSCache.OnStreamSetCallback2 onStreamSetCallback2) {
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, @NonNull InputStream inputStream) {
        return this.a.insertStream(new Key(str), inputStream);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, @NonNull InputStream inputStream, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str, String str2) {
        return this.a.getDataSize(new Key(a(str, str2)));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, String str2) {
        return this.a.delete(new Key(a(str, str2)));
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream) {
        return this.a.insertStream(new Key(a(str, str2)), inputStream);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public InputStream inputStreamForKey(@NonNull String str, String str2) {
        byte[] binary = this.a.getBinary(new Key(a(str, str2)));
        if (binary != null) {
            return new ByteArrayInputStream(binary);
        }
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public List<String> extendsKeysForKey(@NonNull String str, int i) {
        return new ArrayList();
    }
}
