package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.downloader.adpater.BizPriManager;
import com.taobao.downloader.adpater.FileCacheManager;
import com.taobao.downloader.adpater.Monitor;
import com.taobao.downloader.adpater.impl.SimpleTaskManager;
import com.taobao.downloader.request.DownloadListener;
import com.taobao.downloader.wrapper.ListenerWrapper;
import com.uc.webview.export.extension.UCCore;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class sc0 {
    private static volatile sc0 b;
    private Class<?> a;

    private sc0() {
        try {
            Class<?> cls = Class.forName("com.taobao.downloader.TbDownloader");
            this.a = cls;
            Method declaredMethod = cls.getDeclaredMethod("initDownLoad", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (um.h == null) {
            um.h = new ad2();
        }
        if (um.g == null) {
            um.g = new SimpleTaskManager();
        }
        if (um.f == null) {
            um.f = new bd2();
        }
    }

    public static sc0 c() {
        if (b == null) {
            synchronized (sc0.class) {
                if (b == null) {
                    b = new sc0();
                }
            }
        }
        return b;
    }

    public static void e(Context context) {
        if (context == null) {
            ka0.e("Downloader", UCCore.LEGACY_EVENT_INIT, "context is null");
        } else {
            um.a = context.getApplicationContext();
        }
    }

    public void a(int i) {
        um.g.modifyTask(i, 2);
    }

    public int b(qc0 qc0Var, DownloadListener downloadListener) {
        FileCacheManager fileCacheManager;
        ka0.c("Downloader", "download", "start download");
        if (qc0Var != null && TextUtils.isEmpty(qc0Var.b.f) && (fileCacheManager = um.f) != null) {
            qc0Var.b.f = fileCacheManager.getTmpCache();
        }
        if (qc0Var != null && qc0Var.a()) {
            BizPriManager bizPriManager = um.e;
            if (bizPriManager != null) {
                jq1 jq1Var = qc0Var.b;
                jq1Var.b = bizPriManager.getPriBy(jq1Var);
            }
            kl2 kl2Var = new kl2();
            int a = d11.a();
            kl2Var.b = a;
            ka0.c("Downloader", "download", "assign taskId", Integer.valueOf(a));
            kl2Var.c = qc0Var.b;
            kl2Var.e = qc0Var.a;
            kl2Var.d = new ListenerWrapper(qc0Var, downloadListener);
            ArrayList arrayList = new ArrayList();
            for (l41 l41Var : qc0Var.a) {
                id2 id2Var = new id2();
                id2Var.e = l41Var;
                jq1 jq1Var2 = qc0Var.b;
                id2Var.f = jq1Var2;
                id2Var.g = jq1Var2.f;
                arrayList.add(id2Var);
            }
            um.g.addTask(arrayList, kl2Var);
            return kl2Var.b;
        }
        if (downloadListener != null) {
            downloadListener.onFinish(false);
        }
        nh1.a(Monitor.POINT_ADD, "paramerror", null, null);
        return -100;
    }

    public String d(String str, l41 l41Var) {
        return ui0.b(str, l41Var);
    }
}
