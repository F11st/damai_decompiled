package tb;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class w22 {
    private static ConcurrentHashMap<Integer, b32> a = new ConcurrentHashMap<>();
    private static volatile w22 b;

    public static w22 d() {
        if (b == null) {
            synchronized (w22.class) {
                if (b == null) {
                    b = new w22();
                }
            }
        }
        return b;
    }

    public void a(Context context) {
        a.remove(Integer.valueOf(context.hashCode()));
    }

    public int b(Context context) {
        int hashCode = context.hashCode();
        b32 b32Var = a.get(Integer.valueOf(hashCode));
        if (b32Var == null) {
            b32Var = new b32();
            a.put(Integer.valueOf(hashCode), b32Var);
        }
        return b32Var.a();
    }

    public int c(Context context) {
        int hashCode = context.hashCode();
        b32 b32Var = a.get(Integer.valueOf(hashCode));
        if (b32Var == null) {
            b32Var = new b32();
            a.put(Integer.valueOf(hashCode), b32Var);
        }
        return b32Var.b();
    }

    public int e(Context context) {
        if (context == null) {
            return 1000;
        }
        int hashCode = context.hashCode();
        b32 b32Var = a.get(Integer.valueOf(hashCode));
        if (b32Var == null) {
            b32Var = new b32();
            a.put(Integer.valueOf(hashCode), b32Var);
        }
        return b32Var.c();
    }

    public void f(Context context, int i) {
        int hashCode = context.hashCode();
        b32 b32Var = a.get(Integer.valueOf(hashCode));
        if (b32Var == null) {
            b32Var = new b32();
            a.put(Integer.valueOf(hashCode), b32Var);
        }
        b32Var.d(i);
    }

    public void g(Context context, int i) {
        int hashCode = context.hashCode();
        b32 b32Var = a.get(Integer.valueOf(hashCode));
        if (b32Var == null) {
            b32Var = new b32();
            a.put(Integer.valueOf(hashCode), b32Var);
        }
        b32Var.e(i);
    }

    public void h(Context context, int i) {
        int hashCode = context.hashCode();
        b32 b32Var = a.get(Integer.valueOf(hashCode));
        if (b32Var == null) {
            b32Var = new b32();
            a.put(Integer.valueOf(hashCode), b32Var);
        }
        b32Var.f(i);
    }

    public void i(Context context, int i) {
        if (context == null) {
            return;
        }
        int hashCode = context.hashCode();
        b32 b32Var = a.get(Integer.valueOf(hashCode));
        if (b32Var == null) {
            b32Var = new b32();
            a.put(Integer.valueOf(hashCode), b32Var);
        }
        b32Var.g(i);
    }
}
