package com.taobao.android.dinamic.asyncrender;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.android.dinamic.DViewGenerator;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import tb.iy2;
import tb.nz;
import tb.p80;
import tb.r10;
import tb.r20;
import tb.ry;
import tb.s00;
import tb.yx2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DPreRenderTask implements Runnable {
    private static final String TAG = "DPreRenderTask";
    Context context;
    String module;
    List<DinamicTemplate> templateList;

    public DPreRenderTask(Context context, String str, List<DinamicTemplate> list) {
        this.templateList = list;
        this.module = str;
        this.context = context.getApplicationContext();
    }

    private void preRenderTemplate(yx2 yx2Var) {
        List<DinamicTemplate> list = this.templateList;
        if (list == null) {
            return;
        }
        Iterator<DinamicTemplate> it = list.iterator();
        while (it.hasNext()) {
            DinamicTemplate next = it.next();
            iy2 j = DViewGenerator.o(this.module).j(yx2Var, null, next);
            if (j.f()) {
                s00.f(nz.TAG, nz.TAG, "asyncCreateTemplateView success:" + next.name);
                r20.c().a(j, next, this.module);
            } else {
                String b = j.b().b();
                s00.f(nz.TAG, nz.TAG, "asyncCreateTemplateView fail:\n" + b);
                if (TextUtils.isEmpty(b) || (!b.contains(p80.ERROR_CODE_TEMPLATE_FILE_LOST) && !b.contains(p80.ERROR_CODE_TEMPLATE_NOT_FOUND))) {
                    DXTemplateItem transformTemplateToV3 = next != null ? transformTemplateToV3(next) : null;
                    String str = this.module;
                    DXAppMonitor.q(str, transformTemplateToV3, "AsyncRender", "Pre_Render_2.0_Fail", e.V2_PRE_RENDER_FAIL, "asyncCreateTemplateView fail" + j.b().b());
                }
            }
        }
    }

    private DXTemplateItem transformTemplateToV3(DinamicTemplate dinamicTemplate) {
        if (dinamicTemplate == null) {
            return null;
        }
        try {
            DXTemplateItem dXTemplateItem = new DXTemplateItem();
            dXTemplateItem.name = dinamicTemplate.name;
            if (!TextUtils.isEmpty(dinamicTemplate.version)) {
                dXTemplateItem.version = Long.parseLong(dinamicTemplate.version);
            } else {
                dXTemplateItem.version = -1L;
            }
            dXTemplateItem.templateUrl = dinamicTemplate.templateUrl;
            return dXTemplateItem;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Field declaredField = Looper.class.getDeclaredField("sThreadLocal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(Looper.getMainLooper());
            if (obj instanceof ThreadLocal) {
                ((ThreadLocal) obj).set(Looper.getMainLooper());
            }
            preRenderTemplate(new yx2(this.context));
        } catch (Throwable th) {
            DXAppMonitor.q(r10.DB_NAME, null, "AsyncRender", "Pre_Render_2.0_Crash", e.V2_PRE_RENDER_CRASH, ry.a(th));
        }
    }
}
