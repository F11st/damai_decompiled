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
    /* loaded from: classes8.dex */
    public static class a {
        public List<b> a = new ArrayList();
        public Map<String, Integer> b = new HashMap();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class b {
        public final String a;

        public b(String str, String str2, float f, String str3) {
            this.a = str2;
        }
    }

    void clearAll() throws IOException;

    boolean contains(String str, CacheKey cacheKey, Object obj) throws IOException;

    List<String> getCatalogs(String str);

    a getDumpInfo() throws IOException;

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
