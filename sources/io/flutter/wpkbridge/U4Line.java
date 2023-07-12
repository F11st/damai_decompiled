package io.flutter.wpkbridge;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class U4Line extends ConcurrentHashMap<String, String> {
    private static final String ACTION = "ev_ac";
    private static final String CATEGORY = "ct";
    private static final String TYPE = "ev_ct";

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Clearable {
        void clear();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class RecyclePool<D extends Clearable> {
        private static final int MAX_POOL_SIZE = 50;
        private final Constructor<D> mConstructor;
        private final Object[] mPVS;
        private AtomicLong mSize = new AtomicLong();
        private ConcurrentLinkedQueue<D> mPool = new ConcurrentLinkedQueue<>();

        public RecyclePool(Class<D> cls, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<D> declaredConstructor = cls.getDeclaredConstructor(clsArr);
                this.mConstructor = declaredConstructor;
                declaredConstructor.setAccessible(true);
                this.mPVS = objArr;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        public D obtain() {
            D poll = this.mPool.poll();
            if (poll == null) {
                try {
                    return this.mConstructor.newInstance(this.mPVS);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            this.mSize.decrementAndGet();
            return poll;
        }

        public void recycle(D d) {
            d.clear();
            if (this.mSize.get() < 50) {
                this.mPool.add(d);
                this.mSize.incrementAndGet();
            }
        }
    }

    public U4Line kvs(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            if (strArr.length % 2 == 0) {
                for (int i = 0; i < strArr.length; i += 2) {
                    put(strArr[i], strArr[i + 1]);
                }
            } else {
                throw new IllegalArgumentException("Number of parameters should be multiples of 2");
            }
        }
        return this;
    }

    public U4Line putAction(String str) {
        put(ACTION, str);
        return this;
    }

    public U4Line putMap(Map<? extends String, String> map) {
        putAll(map);
        return this;
    }

    public U4Line kvs(Map<String, String> map) {
        return kvs(map, "");
    }

    public U4Line kvs(Map<String, String> map, String str) {
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put(str + entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public U4Line kvs(JSONObject jSONObject) {
        return kvs(jSONObject, "");
    }

    public U4Line kvs(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.length() > 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                put(str + next, optString);
            }
        }
        return this;
    }
}
