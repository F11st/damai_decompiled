package com.uploader.implement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uploader.export.ITaskListener;
import com.uploader.export.IUploaderDependency;
import com.uploader.export.IUploaderManager;
import com.uploader.export.IUploaderTask;
import com.uploader.implement.a.C7376i;
import com.uploader.implement.a.InterfaceC7372d;
import com.uploader.implement.a.InterfaceC7375g;
import com.uploader.implement.b.a.C7382b;
import com.uploader.implement.d.C7405c;
import com.uploader.implement.d.InterfaceC7404b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tb.l33;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploaderManager implements IUploaderManager, InterfaceC7372d {
    private int a;
    private ArrayList<C7376i> b;
    private ArrayList<Pair<Integer, String>> c;
    private SparseArray<ArrayList<Pair<C7376i, InterfaceC7404b>>> d;
    private ArrayList<Pair<C7376i, InterfaceC7404b>> e;
    private C7382b f;
    private BroadcastReceiver g;
    private volatile Handler h;
    private volatile boolean i;
    private Runnable j;
    private boolean k;
    private String l;
    private final int m;
    private C7399c n;
    private final byte[] o;
    private final int p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.UploaderManager$a */
    /* loaded from: classes11.dex */
    public static class RunnableC7362a implements Runnable {
        final UploaderManager a;
        final int b;
        final Object[] c;

        RunnableC7362a(int i, @NonNull UploaderManager uploaderManager, Object... objArr) {
            this.b = i;
            this.a = uploaderManager;
            this.c = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.b;
            if (i == 1) {
                UploaderManager uploaderManager = this.a;
                Object[] objArr = this.c;
                uploaderManager.d((IUploaderTask) objArr[0], (ITaskListener) objArr[1], (Handler) objArr[2]);
            } else if (i == 2) {
                this.a.c((IUploaderTask) this.c[0]);
            } else if (i == 3) {
                this.a.b();
            } else if (i == 4) {
                this.a.i((InterfaceC7375g) this.c[0]);
            } else if (i != 5) {
            } else {
                this.a.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.uploader.implement.UploaderManager$b */
    /* loaded from: classes11.dex */
    public static class C7363b extends BroadcastReceiver {
        private final WeakReference<UploaderManager> a;

        C7363b(UploaderManager uploaderManager) {
            this.a = new WeakReference<>(uploaderManager);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    intent.getBooleanExtra("noConnectivity", false);
                    intent.getStringExtra("extraInfo");
                    UploaderManager uploaderManager = this.a.get();
                    if (uploaderManager == null) {
                        return;
                    }
                    uploaderManager.k();
                } catch (Throwable unused) {
                }
            }
        }
    }

    UploaderManager() {
        this(0);
    }

    private int a(String str) {
        if (str == null) {
            str = "";
        }
        int size = this.c.size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            } else if (((String) this.c.get(size).second).equals(str)) {
                break;
            } else {
                size--;
            }
        }
        if (size < 0) {
            ArrayList<Pair<Integer, String>> arrayList = this.c;
            int i = this.a + 1;
            this.a = i;
            arrayList.add(new Pair<>(Integer.valueOf(i), str));
            size = this.c.size() - 1;
        }
        return ((Integer) this.c.get(size).first).intValue();
    }

    private void f(C7376i c7376i, @Nullable ArrayList<Pair<C7376i, InterfaceC7404b>> arrayList) {
        int G = c7376i.G();
        if (this.f == null) {
            this.f = new C7382b(this.n, this.h.getLooper());
        }
        C7405c c7405c = new C7405c(this.n, this.f, this.h.getLooper());
        if (arrayList == null) {
            arrayList = new ArrayList<>(2);
            this.d.append(G, arrayList);
        }
        Pair<C7376i, InterfaceC7404b> create = Pair.create(c7376i, c7405c);
        arrayList.add(create);
        this.e.add(create);
        c7376i.h(this);
        c7376i.m(c7405c);
        if (C7364a.d(4)) {
            C7364a.a(4, "UploaderManager", this.m + " startAction task:" + c7376i.F().hashCode());
        }
    }

    private Handler g() {
        Handler handler = this.h;
        if (handler != null) {
            return handler;
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderManager", this.m + " doRetrieve and register");
        }
        HandlerThread handlerThread = new HandlerThread("[aus]");
        handlerThread.start();
        Handler handler2 = new Handler(handlerThread.getLooper());
        this.h = handler2;
        return handler2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String str;
        boolean z;
        boolean equals;
        NetworkInfo b = l33.b(this.n.c.getApplicationContext());
        if (b != null) {
            z = b.isConnected();
            str = b.getExtraInfo();
        } else {
            str = null;
            z = false;
        }
        boolean z2 = this.k;
        String str2 = this.l;
        boolean z3 = true;
        if (z2 == z) {
            if (str2 != null) {
                equals = str2.equals(str);
            } else if (str != null) {
                equals = str.equals(str2);
            } else {
                z3 = false;
            }
            z3 = true ^ equals;
        }
        if (C7364a.d(8)) {
            C7364a.a(8, "UploaderManager", this.m + " doNetworkChanged, extraInfo(new|old):" + str + "|" + str2 + " isConnected(new|old):" + z + "|" + z2 + " changed:" + z3);
        }
        if (z3) {
            this.k = z;
            this.l = str;
            if (!z) {
                C7382b c7382b = this.f;
                if (c7382b != null) {
                    c7382b.e();
                    return;
                }
                return;
            }
            int size = this.e.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Pair<C7376i, InterfaceC7404b> pair = this.e.get(i2);
                ((C7376i) pair.first).m((InterfaceC7404b) pair.second);
                i++;
            }
            int l = l();
            if (C7364a.d(2)) {
                C7364a.a(2, "UploaderManager", this.m + " restartedCount:" + i + " suppliedCount:" + l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this.o) {
            Handler handler = this.h;
            if (handler == null) {
                return;
            }
            handler.post(new RunnableC7362a(5, this, new Object[0]));
        }
    }

    private int l() {
        int i = 0;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            C7376i c7376i = this.b.get(size);
            ArrayList<Pair<C7376i, InterfaceC7404b>> arrayList = this.d.get(c7376i.G());
            if (arrayList == null) {
                if (this.d.size() < 2) {
                    this.b.remove(size);
                    f(c7376i, arrayList);
                    i++;
                }
            } else if (arrayList.size() < 2) {
                this.b.remove(size);
                f(c7376i, arrayList);
                i++;
            }
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderManager", this.m + " suppliedCount:" + i);
        }
        return i;
    }

    void b() {
        Handler handler = this.h;
        if (handler == null) {
            return;
        }
        Context applicationContext = this.n.c.getApplicationContext();
        BroadcastReceiver broadcastReceiver = this.g;
        if (broadcastReceiver != null) {
            try {
                try {
                    applicationContext.unregisterReceiver(broadcastReceiver);
                } catch (Exception e) {
                    if (C7364a.d(16)) {
                        C7364a.b(16, "UploaderManager", "doClean unregisterReceiver", e);
                    }
                }
            } finally {
                this.g = null;
            }
        }
        handler.removeCallbacksAndMessages(null);
        handler.getLooper().quit();
        this.j = null;
        this.h = null;
        this.d = new SparseArray<>(2);
        this.e.trimToSize();
        this.c.trimToSize();
        this.b.trimToSize();
        C7382b c7382b = this.f;
        if (c7382b != null) {
            c7382b.e();
            this.f = null;
        }
        if (C7364a.d(2)) {
            C7364a.a(2, "UploaderManager", this.m + " doClean and release");
        }
    }

    void c(IUploaderTask iUploaderTask) {
        boolean z;
        int a = a(iUploaderTask.getBizType());
        int size = this.b.size() - 1;
        while (true) {
            if (size < 0) {
                z = false;
                break;
            } else if (this.b.get(size).F().equals(iUploaderTask)) {
                this.b.remove(size).p(null);
                z = true;
                break;
            } else {
                size--;
            }
        }
        if (z) {
            if (C7364a.d(4)) {
                C7364a.a(4, "UploaderManager", this.m + " doCancel cancel waiting task:" + iUploaderTask);
                return;
            }
            return;
        }
        ArrayList<Pair<C7376i, InterfaceC7404b>> arrayList = this.d.get(a);
        if (arrayList == null) {
            return;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            if (((C7376i) arrayList.get(size2).first).F().equals(iUploaderTask)) {
                Pair<C7376i, InterfaceC7404b> pair = arrayList.get(size2);
                ((C7376i) pair.first).p((InterfaceC7404b) pair.second);
                if (C7364a.d(4)) {
                    C7364a.a(4, "UploaderManager", this.m + " doCancel cancel concurrent task:" + iUploaderTask);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.uploader.export.IUploaderManager
    public boolean cancelAsync(@NonNull IUploaderTask iUploaderTask) {
        boolean z = false;
        if (iUploaderTask == null) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderManager", this.m + " cancelAsync fail,task null");
            }
            return false;
        } else if (this.i) {
            synchronized (this.o) {
                if (this.i) {
                    Handler handler = this.h;
                    if (handler != null && handler.post(new RunnableC7362a(2, this, iUploaderTask))) {
                        z = true;
                    }
                    return z;
                }
                return false;
            }
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void d(com.uploader.export.IUploaderTask r9, com.uploader.export.ITaskListener r10, android.os.Handler r11) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploader.implement.UploaderManager.d(com.uploader.export.IUploaderTask, com.uploader.export.ITaskListener, android.os.Handler):void");
    }

    void i(InterfaceC7375g interfaceC7375g) {
        boolean z;
        C7376i c7376i = (C7376i) interfaceC7375g;
        int G = c7376i.G();
        ArrayList<Pair<C7376i, InterfaceC7404b>> arrayList = this.d.get(G);
        if (arrayList == null) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderManager", this.m + " doFinish no concurrent");
                return;
            }
            return;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                z = false;
                break;
            } else if (((C7376i) arrayList.get(size).first).equals(c7376i)) {
                z = this.e.remove(arrayList.remove(size));
                break;
            }
        }
        if (!z) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderManager", this.m + " doFinish !removed");
                return;
            }
            return;
        }
        if (arrayList.size() == 0) {
            this.d.remove(G);
            if (C7364a.d(4)) {
                C7364a.a(4, "UploaderManager", this.m + " onFinish remove concurrent task:" + c7376i.F().hashCode());
            }
        }
        if (!l33.a(this.n.c.getApplicationContext())) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderManager", this.m + " doFinish no network");
                return;
            }
            return;
        }
        l();
        if (this.d.size() == 0 && this.b.size() == 0) {
            synchronized (this.o) {
                Handler handler = this.h;
                if (C7364a.d(8)) {
                    C7364a.a(8, "UploaderManager", this.m + " start count down:90000");
                }
                if (handler == null) {
                    return;
                }
                RunnableC7362a runnableC7362a = new RunnableC7362a(3, this, new Object[0]);
                this.j = runnableC7362a;
                handler.postDelayed(runnableC7362a, 90000L);
            }
        } else if (C7364a.d(8)) {
            C7364a.a(8, "UploaderManager", this.m + " doFinish has more data");
        }
    }

    @Override // com.uploader.export.IUploaderManager
    public boolean initialize(@NonNull Context context, @NonNull IUploaderDependency iUploaderDependency) {
        if (context == null) {
            if (C7364a.d(16)) {
                C7364a.a(16, "UploaderManager", this.m + " initialize fail, context null");
            }
            return false;
        } else if (this.i) {
            if (C7364a.d(4)) {
                C7364a.a(4, "UploaderManager", this.m + " initialize, is initialized !");
            }
            return false;
        } else {
            synchronized (this.o) {
                if (this.i) {
                    if (C7364a.d(4)) {
                        C7364a.a(4, "UploaderManager", this.m + " initialize, is initialized !");
                    }
                    return false;
                } else if (this.p != iUploaderDependency.getEnvironment().getInstanceType()) {
                    if (C7364a.d(16)) {
                        C7364a.a(16, "UploaderManager", this.m + " initialize, FAILED! environment not equals instance in instanceType");
                    }
                    return false;
                } else {
                    this.n = new C7399c(context, iUploaderDependency);
                    this.i = true;
                    if (C7364a.d(4)) {
                        C7364a.a(4, "UploaderManager", this.m + " initialize !!!");
                    }
                    return true;
                }
            }
        }
    }

    @Override // com.uploader.export.IUploaderManager
    public boolean isInitialized() {
        return this.i;
    }

    @Override // com.uploader.export.IUploaderManager
    public boolean uploadAsync(@NonNull IUploaderTask iUploaderTask, @NonNull ITaskListener iTaskListener, Handler handler) {
        if (iUploaderTask == null) {
            if (C7364a.d(8)) {
                C7364a.a(8, "UploaderManager", this.m + " uploadAsync fail,task null");
            }
            return false;
        }
        synchronized (this.o) {
            if (this.i) {
                return g().post(new RunnableC7362a(1, this, iUploaderTask, iTaskListener, handler));
            }
            return false;
        }
    }

    UploaderManager(int i) {
        this.a = 0;
        this.i = false;
        this.o = new byte[0];
        this.d = new SparseArray<>(2);
        this.e = new ArrayList<>();
        this.c = new ArrayList<>();
        this.b = new ArrayList<>();
        this.m = hashCode();
        this.p = i;
    }

    @Override // com.uploader.implement.a.InterfaceC7372d
    public void a(InterfaceC7375g interfaceC7375g) {
        synchronized (this.o) {
            Handler handler = this.h;
            if (handler == null) {
                return;
            }
            handler.post(new RunnableC7362a(4, this, interfaceC7375g));
        }
    }
}
