package com.taobao.alivfssdk.fresco.cache.disk;

import com.taobao.alivfssdk.fresco.binaryresource.BinaryResource;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import com.taobao.alivfssdk.fresco.cache.common.WriterCallback;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface DiskStorage extends Closeable {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Entry {
        String getId();

        BinaryResource getResource();

        long getSize();

        long getTimestamp();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Inserter {
        boolean cleanUp();

        BinaryResource commit(CacheKey cacheKey, Object obj) throws IOException;

        void writeData(WriterCallback writerCallback, CacheKey cacheKey, Object obj) throws IOException;
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.fresco.cache.disk.DiskStorage$a */
    /* loaded from: classes8.dex */
    public static class C6281a {
        public List<C6282b> a = new ArrayList();
        public Map<String, Integer> b = new HashMap();
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.alivfssdk.fresco.cache.disk.DiskStorage$b */
    /* loaded from: classes8.dex */
    public static class C6282b {
        public final String a;

        public C6282b(String str, String str2, float f, String str3) {
            this.a = str2;
        }
    }

    void clearAll() throws IOException;

    boolean contains(String str, CacheKey cacheKey, Object obj) throws IOException;

    List<String> getCatalogs(String str);

    C6281a getDumpInfo() throws IOException;

    Collection<Entry> getEntries() throws IOException;

    BinaryResource getResource(String str, CacheKey cacheKey, Object obj) throws IOException;

    String getStorageName();

    Inserter insert(String str, CacheKey cacheKey, Object obj) throws IOException;

    boolean isEnabled();

    boolean isExternal();

    void purgeUnexpectedResources() throws IOException;

    long remove(Entry entry) throws IOException;

    long remove(String str, CacheKey cacheKey) throws IOException;

    boolean touch(String str, CacheKey cacheKey, Object obj) throws IOException;
}
