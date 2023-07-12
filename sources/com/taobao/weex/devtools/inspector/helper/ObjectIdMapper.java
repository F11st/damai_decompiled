package com.taobao.weex.devtools.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ObjectIdMapper {
    protected final Object mSync = new Object();
    @GuardedBy("mSync")
    private int mNextId = 1;
    @GuardedBy("mSync")
    private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap();
    @GuardedBy("mSync")
    private SparseArray<Object> mIdToObjectMap = new SparseArray<>();

    public void clear() {
        SparseArray<Object> sparseArray;
        synchronized (this.mSync) {
            sparseArray = this.mIdToObjectMap;
            this.mObjectToIdMap.clear();
            this.mIdToObjectMap = new SparseArray<>();
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            onUnmapped(sparseArray.valueAt(i), sparseArray.keyAt(i));
        }
    }

    public boolean containsId(int i) {
        boolean z;
        synchronized (this.mSync) {
            z = this.mIdToObjectMap.get(i) != null;
        }
        return z;
    }

    public boolean containsObject(Object obj) {
        boolean containsKey;
        synchronized (this.mSync) {
            containsKey = this.mObjectToIdMap.containsKey(obj);
        }
        return containsKey;
    }

    @Nullable
    public Integer getIdForObject(Object obj) {
        Integer num;
        synchronized (this.mSync) {
            num = this.mObjectToIdMap.get(obj);
        }
        return num;
    }

    @Nullable
    public Object getObjectForId(int i) {
        Object obj;
        synchronized (this.mSync) {
            obj = this.mIdToObjectMap.get(i);
        }
        return obj;
    }

    protected void onMapped(Object obj, int i) {
    }

    protected void onUnmapped(Object obj, int i) {
    }

    public int putObject(Object obj) {
        synchronized (this.mSync) {
            Integer num = this.mObjectToIdMap.get(obj);
            if (num != null) {
                return num.intValue();
            }
            int i = this.mNextId;
            this.mNextId = i + 1;
            Integer valueOf = Integer.valueOf(i);
            this.mObjectToIdMap.put(obj, valueOf);
            this.mIdToObjectMap.put(valueOf.intValue(), obj);
            onMapped(obj, valueOf.intValue());
            return valueOf.intValue();
        }
    }

    @Nullable
    public Integer removeObject(Object obj) {
        synchronized (this.mSync) {
            Integer remove = this.mObjectToIdMap.remove(obj);
            if (remove == null) {
                return null;
            }
            this.mIdToObjectMap.remove(remove.intValue());
            onUnmapped(obj, remove.intValue());
            return remove;
        }
    }

    @Nullable
    public Object removeObjectById(int i) {
        synchronized (this.mSync) {
            Object obj = this.mIdToObjectMap.get(i);
            if (obj == null) {
                return null;
            }
            this.mIdToObjectMap.remove(i);
            this.mObjectToIdMap.remove(obj);
            onUnmapped(obj, i);
            return obj;
        }
    }

    public int size() {
        int size;
        synchronized (this.mSync) {
            size = this.mObjectToIdMap.size();
        }
        return size;
    }
}
