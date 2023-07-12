package tb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.taobao.monitor.procedure.IPage;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pp1 implements IPage {
    private ra a;
    private IPage.PageLifecycleCallback b;
    private IPage.PageRenderStandard c;
    private WeakReference<View> d;
    private WeakReference<View> e;
    private WeakReference<Activity> j;
    private WeakReference<Fragment> k;
    private String m;
    private boolean n;
    private String f = null;
    private String g = null;
    private String h = null;
    private volatile boolean i = false;
    private final AtomicLong l = new AtomicLong(-1);
    private final AtomicLong o = new AtomicLong(-1);
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private final Map<String, Integer> s = new ConcurrentHashMap();
    private final Map<String, Integer> t = new ConcurrentHashMap();

    public void A(String str) {
        this.g = str;
    }

    public void B(String str) {
        this.m = str;
    }

    public void C(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.t.get(str);
        if (num == null) {
            num = 0;
        }
        this.t.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public void D(@NonNull IPage.PageLifecycleCallback pageLifecycleCallback) {
        this.b = pageLifecycleCallback;
    }

    public void E(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.s.get(str);
        if (num == null) {
            num = 0;
        }
        this.s.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public void F(WeakReference<View> weakReference) {
        this.e = weakReference;
    }

    public void G(long j) {
    }

    public void H(boolean z) {
        this.n = z;
    }

    public void I(long j) {
        this.l.set(j);
    }

    public void J(String str) {
        this.f = str;
    }

    public void K(IPage.PageRenderStandard pageRenderStandard) {
        this.c = pageRenderStandard;
    }

    public void L(View view) {
        this.d = new WeakReference<>(view);
    }

    public void M(String str) {
        this.h = str;
    }

    public void N(@NonNull ra raVar) {
        this.a = raVar;
    }

    @Nullable
    public Activity a() {
        WeakReference<Activity> weakReference = this.j;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int b() {
        return this.q;
    }

    @Nullable
    public Context c() {
        View view;
        WeakReference<View> weakReference = this.d;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return null;
        }
        return view.getContext();
    }

    public long d() {
        return this.o.get();
    }

    @Nullable
    public Fragment e() {
        WeakReference<Fragment> weakReference = this.k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int f() {
        return this.p;
    }

    public int g() {
        return this.r;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageBeginStandard getPageBeginStandard() {
        return this.a;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageDataSetter getPageDataSetter() {
        return this.a;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageLifecycleCallback getPageLifecycleCallback() {
        return this.b;
    }

    @Override // com.taobao.monitor.procedure.IPage
    @NonNull
    public IPage.PageRenderStandard getPageRenderStandard() {
        return this.c;
    }

    @Nullable
    public String h() {
        return this.g;
    }

    public String i() {
        return this.m;
    }

    public Map<String, Integer> j() {
        return this.t;
    }

    public Map<String, Integer> k() {
        return this.s;
    }

    public WeakReference<View> l() {
        return this.e;
    }

    @Nullable
    public String m() {
        return this.f;
    }

    public long n() {
        return this.l.get();
    }

    @Nullable
    public View o() {
        WeakReference<View> weakReference = this.d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public String p() {
        return this.h;
    }

    public void q() {
        this.q++;
    }

    public void r() {
        this.p++;
    }

    public void s() {
        this.r++;
    }

    public boolean t() {
        WeakReference<Activity> weakReference = this.j;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public boolean u() {
        boolean z;
        Activity a = a();
        Fragment e = e();
        boolean z2 = a != null && a.isFinishing();
        if (e != null) {
            if (e.isRemoving()) {
                z = true;
            } else {
                FragmentActivity activity = e.getActivity();
                if (activity != null) {
                    z = activity.isFinishing();
                }
            }
            return !z2 ? true : true;
        }
        z = false;
        return !z2 ? true : true;
    }

    public boolean v() {
        WeakReference<Fragment> weakReference = this.k;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public boolean w() {
        return this.n;
    }

    public void x(Activity activity) {
        this.j = new WeakReference<>(activity);
    }

    public void y(long j) {
        this.o.set(j);
    }

    public void z(Fragment fragment) {
        this.k = new WeakReference<>(fragment);
    }
}
