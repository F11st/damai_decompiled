package tb;

import com.taobao.tcommon.core.BytesPool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i91 implements BytesPool {
    protected static final Comparator<byte[]> i = new C9257a();
    private List<byte[]> a = new LinkedList();
    private List<byte[]> b = new ArrayList(64);
    private int c = 0;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    /* compiled from: Taobao */
    /* renamed from: tb.i91$a */
    /* loaded from: classes11.dex */
    static class C9257a implements Comparator<byte[]> {
        C9257a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public i91(int i2) {
        this.h = i2;
    }

    private void a() {
        if (hh0.g(3)) {
            xt2.a("BytesPool", "%d/%d , puts:%d, misses:%d, hits:%d, evicts:%d", Integer.valueOf(this.c), Integer.valueOf(this.h), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.d), Integer.valueOf(this.g));
        }
    }

    private synchronized void b(int i2) {
        while (this.c > i2) {
            byte[] remove = this.a.remove(0);
            this.b.remove(remove);
            this.c -= remove.length;
            this.g++;
        }
    }

    @Override // com.taobao.tcommon.core.BytesPool
    public void clear() {
        b(0);
    }

    @Override // com.taobao.tcommon.core.BytesPool
    public synchronized byte[] offer(int i2) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            byte[] bArr = this.b.get(i3);
            if (bArr.length >= i2) {
                this.c -= bArr.length;
                this.b.remove(i3);
                this.a.remove(bArr);
                this.d++;
                xt2.a("BytesPool", "success get buffer from pool, request=%d, result=%d", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                a();
                return bArr;
            }
        }
        this.f++;
        xt2.a("BytesPool", "failed get buffer from pool, request=%d", Integer.valueOf(i2));
        a();
        return new byte[i2];
    }

    @Override // com.taobao.tcommon.core.BytesPool
    public synchronized byte[] offerMaxAvailable() {
        byte[] bArr;
        if (this.b.size() > 0) {
            List<byte[]> list = this.b;
            bArr = list.remove(list.size() - 1);
            this.c -= bArr.length;
            this.a.remove(bArr);
            this.d++;
            xt2.a("BytesPool", "offer available max successfully from pool, result=%d", Integer.valueOf(bArr.length));
            a();
        } else {
            this.f++;
            xt2.a("BytesPool", "offer available max failed from pool, the linked list is empty", new Object[0]);
            a();
            bArr = new byte[32768];
        }
        return bArr;
    }

    @Override // com.taobao.tcommon.core.BytesPool
    public synchronized void release(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.h && !this.a.contains(bArr)) {
                this.e++;
                this.a.add(bArr);
                int binarySearch = Collections.binarySearch(this.b, bArr, i);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.b.add(binarySearch, bArr);
                this.c += bArr.length;
                b(this.h);
                xt2.a("BytesPool", "release a buffer into pool, length=%d", Integer.valueOf(bArr.length));
            }
        }
    }

    @Override // com.taobao.tcommon.core.BytesPool
    public synchronized void resize(int i2) {
        this.h = i2;
    }
}
