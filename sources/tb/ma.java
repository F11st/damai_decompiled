package tb;

import androidx.annotation.NonNull;
import com.taobao.phenix.cache.disk.DiskCache;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.produce.BaseChainProducer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ma<OUT, NEXT_OUT extends Releasable> extends BaseChainProducer<OUT, NEXT_OUT, com.taobao.phenix.request.a> {
    private final DiskCacheSupplier j;

    public ma(int i, int i2, DiskCacheSupplier diskCacheSupplier) {
        super(i, i2);
        this.j = diskCacheSupplier;
    }

    private p22 I(int i, String str, int i2, int[] iArr) {
        int i3;
        DiskCache K = K(i);
        if (K.open(ur1.o().applicationContext())) {
            if (K.isSupportCatalogs() && (i3 = iArr[0]) != 1) {
                int[] catalogs = K.getCatalogs(str);
                if (catalogs != null && catalogs.length > 0) {
                    int[] H = H(catalogs, i2);
                    int i4 = H[0];
                    if (com.taobao.phenix.request.a.W(i3, i4)) {
                        iArr[0] = i4;
                        xt2.a("DiskCache", "find best size level=%d, actual=%d, target=%d, key=%s", Integer.valueOf(i4), Integer.valueOf(md2.e(H[1])), Integer.valueOf(md2.e(i2)), str);
                        return K.get(str, H[1]);
                    }
                    return null;
                }
                xt2.a("DiskCache", "find catalogs failed, key=%s", str);
                return null;
            }
            return K.get(str, i2);
        }
        xt2.i("DiskCache", "%s open failed in DiskCacheReader", K);
        return null;
    }

    protected int[] H(int[] iArr, int i) {
        int e = md2.e(i);
        int d = md2.d(i);
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = 2;
        while (true) {
            if (i4 >= length) {
                break;
            }
            int i6 = iArr[i4];
            int e2 = md2.e(i6) - e;
            int d2 = md2.d(i6) - d;
            int abs = Math.abs(e2) + Math.abs(d2);
            if (abs == 0) {
                i2 = i6;
                i5 = 1;
                break;
            }
            if (i5 == 2 && e2 > 0 && d2 > 0) {
                i2 = i6;
                i3 = abs;
                i5 = 4;
            } else if ((i5 != 4 || (e2 >= 0 && d2 >= 0)) && abs < i3) {
                i2 = i6;
                i3 = abs;
            }
            i4++;
        }
        return new int[]{i5, i2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ne0 J(@NonNull com.taobao.phenix.request.a aVar, String str, int i, int[] iArr) {
        p22 I = I(aVar.E(), str, i, iArr);
        if (I != null) {
            try {
                return ne0.c(I, null);
            } catch (Exception e) {
                xt2.m("DiskCache", aVar, "transform data from response[type:%d] error=%s", Integer.valueOf(I.a), e);
                return null;
            }
        }
        return null;
    }

    protected DiskCache K(int i) {
        DiskCache diskCache = this.j.get(i);
        return diskCache == null ? this.j.get(17) : diskCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int L(com.taobao.phenix.request.a r17, tb.oe0 r18, boolean r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r18.a()
            r3 = 3
            r4 = 2
            java.lang.String r5 = "DiskCache"
            r6 = 1
            r7 = 0
            if (r2 != 0) goto L2c
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r3 = r17.D()
            r2[r7] = r3
            int r3 = r17.C()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r6] = r3
            java.lang.String r3 = "write skipped, because encode data not available, key=%s, catalog=%d"
            tb.xt2.k(r5, r0, r3, r2)
            r3 = 1
        L28:
            r9 = r16
            goto Lbd
        L2c:
            boolean r2 = r18.i()
            r8 = 4
            if (r2 == 0) goto L5c
            java.lang.Object[] r2 = new java.lang.Object[r8]
            boolean r8 = r1.k
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r2[r7] = r8
            boolean r7 = r1.j
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2[r6] = r7
            java.lang.String r6 = r17.D()
            r2[r4] = r6
            int r6 = r17.C()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r3] = r6
            java.lang.String r3 = "write skipped, because encode data not need to be cached(fromDisk=%b, fromScale=%b), key=%s, catalog=%d"
            tb.xt2.k(r5, r0, r3, r2)
            r3 = 2
            goto L28
        L5c:
            int r2 = r17.E()
            r9 = r16
            com.taobao.phenix.cache.disk.DiskCache r10 = r9.K(r2)
            tb.ur1 r2 = tb.ur1.o()
            android.content.Context r2 = r2.applicationContext()
            boolean r2 = r10.open(r2)
            if (r2 == 0) goto Lb4
            java.lang.String r11 = r17.D()
            int r12 = r17.C()
            byte[] r13 = r1.c
            int r14 = r1.d
            int r15 = r1.b
            boolean r2 = r10.put(r11, r12, r13, r14, r15)
            if (r2 != 0) goto L8a
            r10 = 4
            goto L8b
        L8a:
            r10 = 0
        L8b:
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r8[r7] = r2
            int r2 = r17.E()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8[r6] = r2
            java.lang.String r2 = r17.D()
            r8[r4] = r2
            int r2 = r17.C()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8[r3] = r2
            java.lang.String r2 = "write result=%B，priority=%d, key=%s, catalog=%d"
            tb.xt2.k(r5, r0, r2, r8)
            r3 = r10
            goto Lbd
        Lb4:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r7] = r10
            java.lang.String r2 = "%s open failed in DiskCacheWriter"
            tb.xt2.i(r5, r2, r0)
        Lbd:
            if (r19 == 0) goto Lc2
            r18.release()
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ma.L(com.taobao.phenix.request.a, tb.oe0, boolean):int");
    }
}
