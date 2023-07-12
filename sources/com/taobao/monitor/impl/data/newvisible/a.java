package com.taobao.monitor.impl.data.newvisible;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import tb.ho2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a {
    private final float a;
    private List<b> b = new ArrayList();
    private b c = null;
    private final boolean d;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class b {
        private float a;
        private long b;

        private b() {
        }
    }

    public a(float f) {
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
            this.c = new b();
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
            b bVar = this.c;
            int size = this.b.size() - 2;
            while (size >= 0) {
                b bVar2 = this.b.get(size);
                if (bVar2.a / this.c.a <= this.a) {
                    break;
                }
                size++;
                bVar = bVar2;
            }
            return bVar.b;
        }
        return j;
    }
}
