package tb;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class u81 extends AbstractList<String> implements RandomAccess, LazyStringList {
    public static final LazyStringList EMPTY = new u81().getUnmodifiableView();
    private final List<Object> a;

    public u81() {
        this.a = new ArrayList();
    }

    private static ByteString b(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.f((String) obj);
        }
        return ByteString.d((byte[]) obj);
    }

    private static String c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).t();
        }
        return Internal.b((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public void add(int i, String str) {
        this.a.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d */
    public String get(int i) {
        Object obj = this.a.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String t = byteString.t();
            if (byteString.k()) {
                this.a.set(i, t);
            }
            return t;
        }
        byte[] bArr = (byte[]) obj;
        String b = Internal.b(bArr);
        if (Internal.a(bArr)) {
            this.a.set(i, b);
        }
        return b;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: e */
    public String remove(int i) {
        Object remove = this.a.remove(i);
        ((AbstractList) this).modCount++;
        return c(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f */
    public String set(int i, String str) {
        return c(this.a.set(i, str));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        Object obj = this.a.get(i);
        ByteString b = b(obj);
        if (b != obj) {
            this.a.set(i, b);
        }
        return b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return new zt2(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
    public void add(ByteString byteString) {
        this.a.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.a.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public u81(LazyStringList lazyStringList) {
        this.a = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }
}
