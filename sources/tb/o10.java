package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.db.C6394b;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class o10 {
    private volatile C6394b a;

    /* compiled from: Taobao */
    /* renamed from: tb.o10$b */
    /* loaded from: classes11.dex */
    private static class C9492b {
        private static final o10 a = new o10();
    }

    public static o10 b() {
        return C9492b.a;
    }

    private boolean f() {
        if (this.a == null) {
            c(DinamicXEngine.i(), r10.DB_NAME);
        }
        if (this.a == null) {
            g("DB_Open", C6368e.DX_DB_NULL, "dXDataBaseHelper == null");
            return false;
        }
        return true;
    }

    private void g(String str, int i, String str2) {
        C6368e c6368e = new C6368e("DinamicX_db");
        C6368e.C6369a c6369a = new C6368e.C6369a("DB", str, i);
        c6369a.e = str2;
        ArrayList arrayList = new ArrayList();
        c6368e.c = arrayList;
        arrayList.add(c6369a);
        DXAppMonitor.n(c6368e);
    }

    private void h(String str, String str2, DXTemplateItem dXTemplateItem, long j) {
        DXAppMonitor.s(2, str2, "DB", str, dXTemplateItem, DXAppMonitor.g((float) j), j, true);
    }

    public void a(String str, DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        if (f()) {
            this.a.e(str, dXTemplateItem);
        }
        h("DB_Delete", str, dXTemplateItem, System.nanoTime() - nanoTime);
    }

    public synchronized void c(Context context, String str) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (this.a == null) {
                    this.a = new C6394b(context, str);
                }
            }
        }
    }

    public void d(String str, DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        if (f()) {
            this.a.h(str, dXTemplateItem);
        }
        h("DB_Store", str, dXTemplateItem, System.nanoTime() - nanoTime);
    }

    public LinkedList<DXTemplateItem> e(String str, DXTemplateItem dXTemplateItem) {
        long nanoTime = System.nanoTime();
        if (f()) {
            return this.a.g(str, dXTemplateItem);
        }
        h("DB_Query", str, dXTemplateItem, System.nanoTime() - nanoTime);
        return null;
    }

    private o10() {
    }
}
