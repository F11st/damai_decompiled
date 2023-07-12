package de.greenrobot.event;

import java.lang.reflect.Method;

/* compiled from: Taobao */
/* renamed from: de.greenrobot.event.e */
/* loaded from: classes3.dex */
final class C8106e {
    final Method a;
    final ThreadMode b;
    final Class<?> c;
    String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8106e(Method method, ThreadMode threadMode, Class<?> cls) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
    }

    private synchronized void a() {
        if (this.d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.d = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C8106e) {
            a();
            C8106e c8106e = (C8106e) obj;
            c8106e.a();
            return this.d.equals(c8106e.d);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
