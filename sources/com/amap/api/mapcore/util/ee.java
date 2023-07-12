package com.amap.api.mapcore.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ee extends AbstractC4538ex<C4529a> {
    private C4529a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ee$a */
    /* loaded from: classes10.dex */
    public static final class C4529a extends ey<C4529a> {
        ByteBuffer a;
        ShortBuffer b;
        FloatBuffer c;
        IntBuffer d;
        int e;

        C4529a() {
        }

        void a(int i) {
            if (i < 32768) {
                i = 32768;
            }
            this.a = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            this.e = i;
            this.b = null;
            this.d = null;
            this.c = null;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T extends com.amap.api.mapcore.util.ey<T>, T extends com.amap.api.mapcore.util.ey<?>] */
    public C4529a a(int i) {
        C4529a c4529a = (C4529a) this.a;
        if (c4529a == null) {
            c4529a = new C4529a();
        } else {
            this.a = c4529a.f;
            c4529a.f = null;
        }
        if (c4529a.e < i) {
            c4529a.a(i);
        }
        this.b = (C4529a) ey.a(this.b, c4529a);
        return c4529a;
    }

    public ShortBuffer b(int i) {
        C4529a a = a(i * 2);
        ShortBuffer shortBuffer = a.b;
        if (shortBuffer == null) {
            a.a.clear();
            a.b = a.a.asShortBuffer();
        } else {
            shortBuffer.clear();
        }
        return a.b;
    }

    public FloatBuffer c(int i) {
        C4529a a = a(i * 4);
        FloatBuffer floatBuffer = a.c;
        if (floatBuffer == null) {
            a.a.clear();
            a.c = a.a.asFloatBuffer();
        } else {
            floatBuffer.clear();
        }
        a.c.clear();
        return a.c;
    }

    public void a() {
        this.b = b((ee) this.b);
    }
}
