package com.taobao.alivfssdk.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.cache.e */
/* loaded from: classes8.dex */
public class C6271e extends AVFSBaseCache {
    private static C6271e a;

    private C6271e() {
    }

    public static synchronized C6271e a() {
        C6271e c6271e;
        synchronized (C6271e.class) {
            if (a == null) {
                a = new C6271e();
            }
            c6271e = a;
        }
        return c6271e;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public void clearMemCache() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
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
        return new ArrayList(0);
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public List<String> extendsKeysForKey(@NonNull String str, int i) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public InputStream inputStreamForKey(@NonNull String str, String str2) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public InputStream inputStreamForKey(@NonNull String str, String str2, int i) {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public Set<String> keySet() {
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str, String str2) {
        return -1L;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public long lengthForKey(String str, String str2, int i) {
        return 0L;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    @Nullable
    public <T> T objectForKey(@NonNull String str, int i) {
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
    public boolean removeAllObject() {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, String str2) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean removeObjectForKey(@NonNull String str, String str2, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setObjectForKey(@NonNull String str, String str2, Object obj, int i) {
        return false;
    }

    @Override // com.taobao.alivfssdk.cache.IAVFSCache
    public boolean setStreamForKey(@NonNull String str, String str2, @NonNull InputStream inputStream, int i) {
        return false;
    }
}
