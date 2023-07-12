package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.google.protobuf.h */
/* loaded from: classes10.dex */
public class C5402h extends C5406i {
    private final MessageLite f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.h$b */
    /* loaded from: classes10.dex */
    public static class C5404b<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, C5402h> a;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            C5402h value = this.a.getValue();
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

        private C5404b(Map.Entry<K, C5402h> entry) {
            this.a = entry;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.h$c */
    /* loaded from: classes10.dex */
    static class C5405c<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> a;

        public C5405c(Iterator<Map.Entry<K, Object>> it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.a.next();
            return next.getValue() instanceof C5402h ? new C5404b(next) : next;
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

    @Override // com.google.protobuf.C5406i
    public boolean a() {
        return super.a() || this.c == this.f;
    }

    @Override // com.google.protobuf.C5406i
    public boolean equals(Object obj) {
        return i().equals(obj);
    }

    @Override // com.google.protobuf.C5406i
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
