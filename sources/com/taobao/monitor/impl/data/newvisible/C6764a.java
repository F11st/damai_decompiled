package com.taobao.monitor.impl.data.newvisible;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import tb.ho2;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.impl.data.newvisible.a */
/* loaded from: classes11.dex */
public class C6764a {
    private final float a;
    private List<C6766b> b = new ArrayList();
    private C6766b c = null;
    private final boolean d;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.impl.data.newvisible.a$b */
    /* loaded from: classes11.dex */
    private static class C6766b {
        private float a;
        private long b;

        private C6766b() {
        }
    }

    public C6764a(float f) {
        this.a = f;
        if (Math.abs(1.0f - f) > 1.0E-4f) {
            this.d = true;
        } else {
            this.d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.d) {
            this.c.b = ho2.a();
            this.b.add(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.d) {
            this.c = new C6766b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view) {
        if (this.d) {
            this.c.a += view.getWidth() * view.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d(long j) {
        if (this.d) {
            C6766b c6766b = this.c;
            int size = this.b.size() - 2;
            while (size >= 0) {
                C6766b c6766b2 = this.b.get(size);
                if (c6766b2.a / this.c.a <= this.a) {
                    break;
                }
                size++;
                c6766b = c6766b2;
            }
            return c6766b.b;
        }
        return j;
    }
}
