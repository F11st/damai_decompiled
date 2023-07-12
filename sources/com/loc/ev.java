package com.loc;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.b73;
import tb.k73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ev {
    private File b;
    private Handler d;
    private String e;
    private boolean f;
    private LinkedList<k73> a = new LinkedList<>();
    private boolean c = false;
    private Runnable g = new Runnable() { // from class: com.loc.ev.1
        @Override // java.lang.Runnable
        public final void run() {
            if (ev.this.c) {
                return;
            }
            if (ev.this.f) {
                ev.this.f();
                ev.k(ev.this);
            }
            if (ev.this.d != null) {
                ev.this.d.postDelayed(ev.this.g, DateUtils.MILLIS_PER_MINUTE);
            }
        }
    };

    public ev(Context context, Handler handler) {
        this.e = null;
        this.d = handler;
        String path = context.getFilesDir().getPath();
        if (this.e == null) {
            this.e = m1.e0(context);
        }
        try {
            this.b = new File(path, "hisloc");
        } catch (Throwable th) {
            b73.a(th);
        }
        b();
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.g);
            this.d.postDelayed(this.g, DateUtils.MILLIS_PER_MINUTE);
        }
    }

    private void b() {
        LinkedList<k73> linkedList = this.a;
        if (linkedList == null || linkedList.size() <= 0) {
            for (String str : m1.l(this.b)) {
                try {
                    String str2 = new String(e1.h(p1.g(str), this.e), "UTF-8");
                    k73 k73Var = new k73();
                    k73Var.b(new JSONObject(str2));
                    this.a.add(k73Var);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        StringBuilder sb = new StringBuilder();
        Iterator<k73> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                String a = it.next().a();
                sb.append(p1.f(e1.e(a.getBytes("UTF-8"), this.e)) + StringUtils.LF);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        m1.m(this.b, sb2);
    }

    private static boolean i(ArrayList<b1> arrayList, ArrayList<y0> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    static /* synthetic */ boolean k(ev evVar) {
        evVar.f = false;
        return false;
    }

    public final List<k73> a(ArrayList<b1> arrayList, ArrayList<y0> arrayList2) {
        if (i(arrayList, arrayList2)) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList3 = new ArrayList();
            int i = 0;
            Iterator<k73> it = this.a.iterator();
            while (it.hasNext()) {
                k73 next = it.next();
                if (currentTimeMillis - next.d < 21600000000L) {
                    arrayList3.add(next);
                    i++;
                }
                if (i == 10) {
                    break;
                }
            }
            return arrayList3;
        }
        return null;
    }

    public final void c(k73 k73Var) {
        Iterator<k73> it = this.a.iterator();
        k73 k73Var2 = null;
        k73 k73Var3 = null;
        int i = 0;
        while (it.hasNext()) {
            k73 next = it.next();
            if (next.a == 1) {
                if (k73Var3 == null) {
                    k73Var3 = next;
                }
                i++;
                k73Var2 = next;
            }
        }
        if (k73Var2 != null) {
            new Location(GeocodeSearch.GPS);
            if (k73Var.d - k73Var2.d < 20000 && m1.e(new double[]{k73Var.b, k73Var.c, k73Var2.b, k73Var2.c}) < 20.0f) {
                return;
            }
        }
        if (i >= 5) {
            this.a.remove(k73Var3);
        }
        if (this.a.size() >= 10) {
            this.a.removeFirst();
        }
        this.a.add(k73Var);
        this.f = true;
    }

    public final void d(boolean z) {
        if (!z) {
            this.g.run();
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacks(this.g);
        }
        this.c = true;
    }

    public final void g(k73 k73Var) {
        if (this.a.size() > 0) {
            int i = k73Var.a;
            if (i != 6 && i != 5) {
                if (this.a.contains(k73Var)) {
                    return;
                }
                if (this.a.size() >= 10) {
                    this.a.removeFirst();
                }
                this.a.add(k73Var);
                this.f = true;
                return;
            }
            k73 last = this.a.getLast();
            if (last.c == k73Var.c && last.b == k73Var.b && last.e == k73Var.e) {
                return;
            }
            if (this.a.size() >= 10) {
                this.a.removeFirst();
            }
            this.a.add(k73Var);
            this.f = true;
        }
    }
}
