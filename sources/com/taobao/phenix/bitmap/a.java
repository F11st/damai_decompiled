package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import com.youku.alixplayer.MsgID;
import java.io.ByteArrayOutputStream;
import tb.md2;
import tb.ne0;
import tb.oe0;
import tb.ur1;
import tb.xt2;
import tb.z40;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a extends BaseChainProducer<z40, z40, com.taobao.phenix.request.a> {
    public a() {
        super(0, 2);
    }

    private byte[] H(com.taobao.phenix.request.a aVar, Bitmap bitmap, oe0 oe0Var) {
        MimeType g = oe0Var.g();
        int i = Build.VERSION.SDK_INT;
        boolean z = i == 28 && ur1.w;
        byte[] bArr = null;
        if (g != null && !z) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MsgID.MEDIA_INFO_VIDEO_START_RECOVER);
            if (!com.taobao.pexode.mimetype.a.PNG.g(g) && !com.taobao.pexode.mimetype.a.PNG_A.g(g)) {
                if (com.taobao.pexode.mimetype.a.JPEG.g(g)) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                } else if ((com.taobao.pexode.mimetype.a.WEBP.g(g) || com.taobao.pexode.mimetype.a.WEBP_A.g(g)) && Pexode.b(g)) {
                    bitmap.compress(Bitmap.CompressFormat.WEBP, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    xt2.l("BitmapProcess", oe0Var.i, "compress target bitmap into webp byte array", new Object[0]);
                    MimeType mimeType = com.taobao.pexode.mimetype.a.WEBP_A;
                    if (!mimeType.g(g) || mimeType.f(byteArray)) {
                        bArr = byteArray;
                    } else {
                        xt2.y("BitmapProcess", oe0Var.i, "lost alpha-channel when compress bitmap[ARGB8888 WebP], API-LEVEL=%d", Integer.valueOf(i));
                    }
                }
            } else {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bArr != null);
        objArr[1] = g;
        xt2.k("BitmapProcess", aVar, "compress image with bitmap, result=%B, format=%s", objArr);
        return bArr;
    }

    private Bitmap K(Bitmap bitmap, oe0 oe0Var) {
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = oe0Var.n;
            i = (height * i2) / width;
        } else {
            i = oe0Var.o;
            i2 = (width * i) / height;
        }
        if (width <= i2 && height <= i) {
            xt2.r("BitmapProcess", oe0Var.i, "skip to scale from large bitmap, target(%d) >= actual(%d)", Integer.valueOf(i2), Integer.valueOf(width));
            return null;
        }
        try {
            xt2.l("BitmapProcess", oe0Var.i, "scale down from large bitmap, target(%d) < actual(%d)", Integer.valueOf(i2), Integer.valueOf(width));
            return Bitmap.createScaledBitmap(bitmap, i2, i, true);
        } catch (Throwable th) {
            xt2.y("BitmapProcess", oe0Var.i, "error happen when scaling bitmap, throwable=%s", th);
            return null;
        }
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    /* renamed from: I */
    public void consumeNewResult(Consumer<z40, com.taobao.phenix.request.a> consumer, boolean z, z40 z40Var) {
        oe0 d = z40Var.d();
        if (z40Var.f() && d.l == 4) {
            com.taobao.phenix.request.a context = consumer.getContext();
            if (z) {
                o(consumer);
            }
            xt2.n("Phenix", "BitMapProcessor Started.", context);
            Bitmap b = z40Var.b();
            Bitmap K = K(b, d);
            if (K != null) {
                xt2.k("BitmapProcess", context, "scale bitmap, new size=%d, old size=%d", Integer.valueOf(md2.b(K)), Integer.valueOf(md2.b(b)));
                if (K != b) {
                    b.recycle();
                }
                byte[] H = H(context, K, d);
                if (H != null && H.length > 0) {
                    d.release();
                    d = d.e(new ne0(H, 0, H.length), 1, true);
                }
                z40Var = new z40(d, K);
            }
            if (z) {
                n(consumer, K != null);
            }
            xt2.n("Phenix", "BitMapProcessor Finished.", context);
            J(consumer, z40Var, z);
            return;
        }
        J(consumer, z40Var, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void J(com.taobao.rxm.consume.Consumer<tb.z40, com.taobao.phenix.request.a> r12, tb.z40 r13, boolean r14) {
        /*
            r11 = this;
            java.lang.Object r0 = r12.getContext()
            com.taobao.phenix.request.a r0 = (com.taobao.phenix.request.a) r0
            r11.q(r12, r14)
            r1 = 1
            r2 = 0
            if (r14 == 0) goto L64
            boolean r3 = r13.f()
            if (r3 == 0) goto L64
            android.graphics.Bitmap r3 = r13.b()
            com.taobao.phenix.bitmap.BitmapProcessor[] r4 = r0.A()
            if (r4 == 0) goto L57
            int r5 = r4.length
            if (r5 <= 0) goto L57
            int r5 = r4.length
            r7 = r3
            r6 = 0
        L23:
            if (r6 >= r5) goto L46
            r8 = r4[r6]
            java.lang.String r9 = r0.N()
            com.taobao.phenix.bitmap.b r10 = com.taobao.phenix.bitmap.b.a()
            android.graphics.Bitmap r7 = r8.process(r9, r10, r7)
            if (r7 != 0) goto L43
            r13.release()
            java.lang.Throwable r13 = new java.lang.Throwable
            java.lang.String r14 = "processed result bitmap cannot be null!"
            r13.<init>(r14)
            r12.onFailure(r13)
            return
        L43:
            int r6 = r6 + 1
            goto L23
        L46:
            java.lang.Object[] r5 = new java.lang.Object[r1]
            int r4 = r4.length
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5[r2] = r4
            java.lang.String r4 = "BitmapProcess"
            java.lang.String r6 = "bitmap processors call, length=%d"
            tb.xt2.k(r4, r0, r6, r5)
            goto L58
        L57:
            r7 = r3
        L58:
            if (r3 == r7) goto L64
            tb.z40 r0 = new tb.z40
            tb.oe0 r3 = r13.d()
            r0.<init>(r3, r7)
            goto L65
        L64:
            r0 = r13
        L65:
            if (r0 == r13) goto L68
            goto L69
        L68:
            r1 = 0
        L69:
            r11.p(r12, r1, r14)
            r12.onNewResult(r0, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.phenix.bitmap.a.J(com.taobao.rxm.consume.Consumer, tb.z40, boolean):void");
    }

    @Override // tb.jh
    protected boolean a(Consumer<z40, com.taobao.phenix.request.a> consumer) {
        return false;
    }
}
