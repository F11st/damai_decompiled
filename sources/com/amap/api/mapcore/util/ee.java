package com.amap.api.mapcore.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ee extends ex<a> {
    private a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a extends ey<a> {
        ByteBuffer a;
        ShortBuffer b;
        FloatBuffer c;
        IntBuffer d;
        int e;

        a() {
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
    public a a(int i) {
        a aVar = (a) this.a;
        if (aVar == null) {
            aVar = new a();
        } else {
            this.a = aVar.f;
            aVar.f = null;
        }
        if (aVar.e < i) {
            aVar.a(i);
        }
        this.b = (a) ey.a(this.b, aVar);
        return aVar;
    }

    public ShortBuffer b(int i) {
        a a2 = a(i * 2);
        ShortBuffer shortBuffer = a2.b;
        if (shortBuffer == null) {
            a2.a.clear();
            a2.b = a2.a.asShortBuffer();
        } else {
            shortBuffer.clear();
        }
        return a2.b;
    }

    public FloatBuffer c(int i) {
        a a2 = a(i * 4);
        FloatBuffer floatBuffer = a2.c;
        if (floatBuffer == null) {
            a2.a.clear();
            a2.c = a2.a.asFloatBuffer();
        } else {
            floatBuffer.clear();
        }
        a2.c.clear();
        return a2.c;
    }

    public void a() {
        this.b = b((ee) this.b);
    }
}
