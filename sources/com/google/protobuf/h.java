package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class h extends i {
    private final MessageLite f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, h> a;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            h value = this.a.getValue();
            if (value == null) {
                return null;
            }
            return value.i();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.a.getValue().g((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, h> entry) {
            this.a = entry;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class c<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.a.next();
            return next.getValue() instanceof h ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }

    @Override // com.google.protobuf.i
    public boolean a() {
        return super.a() || this.c == this.f;
    }

    @Override // com.google.protobuf.i
    public boolean equals(Object obj) {
        return i().equals(obj);
    }

    @Override // com.google.protobuf.i
    public int hashCode() {
        return i().hashCode();
    }

    public MessageLite i() {
        return c(this.f);
    }

    public String toString() {
        return i().toString();
    }
}
