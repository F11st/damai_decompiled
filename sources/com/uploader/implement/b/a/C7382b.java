package com.uploader.implement.b.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.uploader.implement.C7364a;
import com.uploader.implement.C7399c;
import com.uploader.implement.a.InterfaceC7373e;
import com.uploader.implement.b.InterfaceC7396c;
import com.uploader.implement.b.InterfaceC7397d;
import com.uploader.implement.b.InterfaceC7398e;
import com.uploader.implement.d.InterfaceC7404b;
import java.util.ArrayList;
import java.util.Iterator;
import tb.j33;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.b.a.b */
/* loaded from: classes11.dex */
public class C7382b implements InterfaceC7396c {
    private final Handler e;
    private final C7399c g;
    private ArrayList<InterfaceC7398e> a = new ArrayList<>();
    private ArrayList<RunnableC7384b> b = new ArrayList<>();
    private ArrayList<C7383a> c = new ArrayList<>();
    private ArrayList<Pair<C7383a, InterfaceC7398e>> d = new ArrayList<>();
    private final int f = hashCode();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.b.a.b$a */
    /* loaded from: classes11.dex */
    public static class C7383a {
        final InterfaceC7404b a;
        final InterfaceC7373e b;
        final InterfaceC7397d c;

        C7383a(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, InterfaceC7397d interfaceC7397d) {
            this.a = interfaceC7404b;
            this.b = interfaceC7373e;
            this.c = interfaceC7397d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.b.a.b$b */
    /* loaded from: classes11.dex */
    public static final class RunnableC7384b implements Runnable {
        final InterfaceC7398e a;
        final ArrayList<InterfaceC7398e> b;
        final ArrayList<RunnableC7384b> c;

        RunnableC7384b(InterfaceC7398e interfaceC7398e, ArrayList<InterfaceC7398e> arrayList, ArrayList<RunnableC7384b> arrayList2) {
            this.a = interfaceC7398e;
            this.b = arrayList;
            this.c = arrayList2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.remove(this.a);
            this.c.remove(this);
            this.a.c();
        }
    }

    public C7382b(C7399c c7399c, Looper looper) {
        this.g = c7399c;
        this.e = new Handler(looper);
    }

    private static int a(InterfaceC7398e interfaceC7398e, ArrayList<RunnableC7384b> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).a.equals(interfaceC7398e)) {
                return i;
            }
        }
        return -1;
    }

    private static int b(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, ArrayList<Pair<C7383a, InterfaceC7398e>> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C7383a c7383a = (C7383a) arrayList.get(i).first;
            if (c7383a.b.equals(interfaceC7373e) && c7383a.a.equals(interfaceC7404b)) {
                return i;
            }
        }
        return -1;
    }

    private static int c(j33 j33Var, ArrayList<InterfaceC7398e> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).a().equals(j33Var)) {
                return i;
            }
        }
        return -1;
    }

    private InterfaceC7398e d(j33 j33Var, InterfaceC7398e interfaceC7398e, boolean z) {
        int c;
        int a;
        if (interfaceC7398e == null && (c = c(j33Var, this.a)) != -1 && (a = a((interfaceC7398e = this.a.remove(c)), this.b)) != -1) {
            this.e.removeCallbacks(this.b.remove(a));
        }
        if (interfaceC7398e != null) {
            interfaceC7398e.a(null);
            if (!z) {
                interfaceC7398e.c();
            }
            if (interfaceC7398e.d()) {
                interfaceC7398e = j33Var.a(this.g);
            }
        } else {
            interfaceC7398e = j33Var.a(this.g);
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " retrieve, connection:" + interfaceC7398e.hashCode() + " keepAlive:" + z);
        }
        return interfaceC7398e;
    }

    private void f(InterfaceC7398e interfaceC7398e) {
        int h = h(interfaceC7398e.a(), this.c);
        if (h != -1) {
            C7383a remove = this.c.remove(h);
            this.d.add(new Pair<>(remove, interfaceC7398e));
            remove.c.a(remove.a, remove.b, interfaceC7398e);
            if (C7364a.d(2)) {
                C7364a.a(2, "ConnectionRecycler", this.f + " rebind, onAvailable:" + remove.a.hashCode() + " request:" + remove.b.hashCode());
                return;
            }
            return;
        }
        this.a.add(interfaceC7398e);
        RunnableC7384b runnableC7384b = new RunnableC7384b(interfaceC7398e, this.a, this.b);
        this.e.postDelayed(runnableC7384b, 27000L);
        this.b.add(runnableC7384b);
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " rebind, start timeout connection:" + interfaceC7398e.hashCode());
        }
    }

    private static int g(InterfaceC7404b interfaceC7404b, InterfaceC7373e interfaceC7373e, ArrayList<C7383a> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C7383a c7383a = arrayList.get(i);
            if (c7383a.b.equals(interfaceC7373e) && c7383a.a.equals(interfaceC7404b)) {
                return i;
            }
        }
        return -1;
    }

    private static int h(j33 j33Var, ArrayList<C7383a> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).b.a().equals(j33Var)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean i(j33 j33Var, ArrayList<Pair<C7383a, InterfaceC7398e>> arrayList) {
        int size = arrayList.size();
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            if (((C7383a) arrayList.get(i2).first).b.a().equals(j33Var) && i - 1 == 0) {
                return false;
            }
        }
        return true;
    }

    public void e() {
        this.c.clear();
        for (int size = this.b.size() - 1; size >= 0; size--) {
            this.e.removeCallbacks(this.b.get(size));
        }
        this.b.clear();
        int size2 = this.d.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            InterfaceC7398e interfaceC7398e = (InterfaceC7398e) this.d.get(size2).second;
            interfaceC7398e.a(null);
            interfaceC7398e.c();
        }
        this.d.clear();
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            InterfaceC7398e interfaceC7398e2 = this.a.get(size3);
            interfaceC7398e2.a(null);
            interfaceC7398e2.c();
        }
        this.a.clear();
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " reset");
        }
    }

    @Override // com.uploader.implement.b.InterfaceC7396c
    public boolean a(@NonNull InterfaceC7404b interfaceC7404b, @NonNull InterfaceC7373e interfaceC7373e, @NonNull InterfaceC7373e interfaceC7373e2, @NonNull InterfaceC7397d interfaceC7397d, boolean z) {
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " replace start, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode() + " newRequest:" + interfaceC7373e2.hashCode() + " keepAlive:" + z);
        }
        j33 a = interfaceC7373e.a();
        if (!a.equals(interfaceC7373e2.a())) {
            if (C7364a.d(2)) {
                C7364a.a(2, "ConnectionRecycler", this.f + " replace:failure, false !=, request:" + interfaceC7373e.hashCode() + " newRequest:" + interfaceC7373e2.hashCode());
            }
            return false;
        } else if (!a.e) {
            if (C7364a.d(2)) {
                C7364a.a(2, "ConnectionRecycler", this.f + " replace:false, !isLongLived");
            }
            return false;
        } else {
            int g = g(interfaceC7404b, interfaceC7373e, this.c);
            if (g != -1) {
                this.c.set(g, new C7383a(interfaceC7404b, interfaceC7373e2, interfaceC7397d));
                if (C7364a.d(2)) {
                    C7364a.a(2, "ConnectionRecycler", this.f + " replace, waiting, request:" + interfaceC7373e.hashCode() + " newRequest:" + interfaceC7373e2.hashCode());
                }
                return true;
            }
            int b = b(interfaceC7404b, interfaceC7373e, this.d);
            if (b == -1) {
                if (C7364a.d(2)) {
                    C7364a.a(2, "ConnectionRecycler", this.f + " replace failure, !bounding, request:" + interfaceC7373e.hashCode());
                }
                return false;
            }
            InterfaceC7398e d = d(a, (InterfaceC7398e) this.d.get(b).second, z);
            this.d.set(b, new Pair<>(new C7383a(interfaceC7404b, interfaceC7373e2, interfaceC7397d), d));
            interfaceC7397d.a(interfaceC7404b, interfaceC7373e2, d);
            if (C7364a.d(8)) {
                C7364a.a(8, "ConnectionRecycler", this.f + " replace, bounding, request:" + interfaceC7373e.hashCode() + " newRequest:" + interfaceC7373e2.hashCode() + " available connection:" + d.hashCode());
            }
            return true;
        }
    }

    @Override // com.uploader.implement.b.InterfaceC7396c
    public boolean a(@NonNull InterfaceC7404b interfaceC7404b, @NonNull InterfaceC7373e interfaceC7373e, @NonNull InterfaceC7397d interfaceC7397d) {
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " register start, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode());
        }
        j33 a = interfaceC7373e.a();
        if (!a.e) {
            InterfaceC7398e a2 = a.a(this.g);
            interfaceC7397d.a(interfaceC7404b, interfaceC7373e, a2);
            if (C7364a.d(2)) {
                C7364a.a(2, "ConnectionRecycler", this.f + " register, onAvailable short lived connection:" + a2.hashCode() + " request:" + interfaceC7373e.hashCode());
            }
            return true;
        }
        if (b(interfaceC7404b, interfaceC7373e, this.d) != -1 && C7364a.d(8)) {
            C7364a.a(8, "ConnectionRecycler", this.f + " register, is bounding, request:" + interfaceC7373e.hashCode());
        }
        if (g(interfaceC7404b, interfaceC7373e, this.c) != -1 && C7364a.d(8)) {
            C7364a.a(8, "ConnectionRecycler", this.f + " register, is waiting, request:" + interfaceC7373e.hashCode());
        }
        C7383a c7383a = new C7383a(interfaceC7404b, interfaceC7373e, interfaceC7397d);
        if (3 > this.d.size() && i(a, this.d)) {
            InterfaceC7398e d = d(a, null, true);
            this.d.add(new Pair<>(c7383a, d));
            interfaceC7397d.a(interfaceC7404b, interfaceC7373e, d);
            if (C7364a.d(2)) {
                C7364a.a(2, "ConnectionRecycler", this.f + " register, onAvailable long lived connection:" + d.hashCode() + " request:" + interfaceC7373e.hashCode());
            }
            return true;
        }
        this.c.add(c7383a);
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " register, waiting request:" + interfaceC7373e.hashCode());
        }
        return true;
    }

    @Override // com.uploader.implement.b.InterfaceC7396c
    public boolean a(@NonNull InterfaceC7404b interfaceC7404b, @NonNull InterfaceC7373e interfaceC7373e, boolean z) {
        j33 a = interfaceC7373e.a();
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " unregister start, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode());
        }
        if (!a.e) {
            if (C7364a.d(2)) {
                C7364a.a(2, "ConnectionRecycler", this.f + " unregister, !isLongLived, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode());
            }
            return false;
        }
        int g = g(interfaceC7404b, interfaceC7373e, this.c);
        if (g != -1) {
            this.c.remove(g);
            if (C7364a.d(2)) {
                C7364a.a(2, "ConnectionRecycler", this.f + " unregister, waiting, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode());
            }
            return true;
        }
        int b = b(interfaceC7404b, interfaceC7373e, this.d);
        if (b == -1) {
            return false;
        }
        Pair<C7383a, InterfaceC7398e> remove = this.d.remove(b);
        InterfaceC7398e d = d(((C7383a) remove.first).b.a(), (InterfaceC7398e) remove.second, z);
        f(d);
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " unregister, session:" + interfaceC7404b.hashCode() + " request:" + interfaceC7373e.hashCode() + " connection:" + d.hashCode());
        }
        return true;
    }

    @Override // com.uploader.implement.b.InterfaceC7396c
    public boolean a(@NonNull InterfaceC7404b interfaceC7404b) {
        boolean z = false;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (this.c.get(size).a.equals(interfaceC7404b)) {
                this.c.remove(size);
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int size2 = this.d.size() - 1; size2 >= 0; size2--) {
            Pair<C7383a, InterfaceC7398e> pair = this.d.get(size2);
            if (((C7383a) pair.first).a.equals(interfaceC7404b)) {
                this.d.remove(size2);
                arrayList.add(d(((C7383a) pair.first).b.a(), (InterfaceC7398e) pair.second, false));
                z = true;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f((InterfaceC7398e) it.next());
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "ConnectionRecycler", this.f + " unregister, session:" + interfaceC7404b.hashCode() + " removed:" + z);
        }
        return z;
    }
}
