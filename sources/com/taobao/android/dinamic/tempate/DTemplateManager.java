package com.taobao.android.dinamic.tempate;

import android.app.Application;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.taobao.android.dinamic.C6312a;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.tempate.SerialTaskManager;
import com.taobao.android.dinamic.tempate.manager.C6350a;
import com.taobao.weex.annotation.JSMethod;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import tb.o80;
import tb.rc0;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DTemplateManager {
    private String a;
    private C6350a b;
    private Context e;
    private LruCache<String, Integer> c = new LruCache<>(100);
    private LruCache<String, Boolean> d = new LruCache<>(100);
    private int f = 3000;
    private SerialTaskManager g = new SerialTaskManager();
    private String h = "dinamic";
    private CacheStrategy i = CacheStrategy.STRATEGY_DEFAULT;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.DTemplateManager$2  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ long val$consumingTime;
        final /* synthetic */ DinamicTemplate val$exact;
        final /* synthetic */ DinamicTemplate val$origin;

        AnonymousClass2(DinamicTemplate dinamicTemplate, DinamicTemplate dinamicTemplate2, long j) {
            this.val$origin = dinamicTemplate;
            this.val$exact = dinamicTemplate2;
            this.val$consumingTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6313b.e()) {
                DinamicLog.a(C6313b.TAG, "fetch exact template=origin template=" + this.val$origin + "exact template=" + this.val$exact + "consuming=" + (this.val$consumingTime / 1000000.0d));
            }
            C6312a.h().d();
            String unused = DTemplateManager.this.a;
            CacheStrategy unused2 = DTemplateManager.this.i;
            throw null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum CacheStrategy {
        STRATEGY_DEFAULT,
        STRATEGY_ALLOW_VERSION_DEGRADE
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.tempate.DTemplateManager$a */
    /* loaded from: classes11.dex */
    class C6340a implements SerialTaskManager.LayoutFileLoadListener {
        final /* synthetic */ DinamicTemplateDownloaderCallback a;

        C6340a(DTemplateManager dTemplateManager, DinamicTemplateDownloaderCallback dinamicTemplateDownloaderCallback) {
            this.a = dinamicTemplateDownloaderCallback;
        }

        @Override // com.taobao.android.dinamic.tempate.SerialTaskManager.LayoutFileLoadListener
        public void onFinished(rc0 rc0Var) {
            DinamicTemplateDownloaderCallback dinamicTemplateDownloaderCallback = this.a;
            if (dinamicTemplateDownloaderCallback == null) {
                if (C6313b.e()) {
                    DinamicLog.j("DTemplateManager", "DinamicTemplateDownloaderCallback is null");
                    return;
                }
                return;
            }
            dinamicTemplateDownloaderCallback.onDownloadFinish(rc0Var);
        }
    }

    public DTemplateManager(String str) {
        this.a = str;
        Context a = C6313b.a();
        this.e = a;
        if (a == null) {
            Application a2 = o80.a();
            this.e = a2;
            C6313b.f(a2);
        }
        C6350a c6350a = new C6350a(this.e, str);
        this.b = c6350a;
        c6350a.i(C6312a.h().b());
    }

    private int f(String str) {
        if (this.e == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        Integer num = this.c.get(str);
        if (num == null) {
            try {
                num = Integer.valueOf(this.e.getResources().getIdentifier(str, "layout", this.e.getPackageName()));
                this.c.put(str, num);
            } catch (Exception e) {
                Log.e("DTemplateManager", "Get layout parser exception", e);
            }
        }
        if (num == null || num.intValue() == 0) {
            return -1;
        }
        return num.intValue();
    }

    private boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Boolean bool = this.d.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        String str2 = str + ".xml";
        try {
            InputStream open = C6313b.a().getAssets().open(this.h + "/" + str2);
            this.d.put(str, Boolean.valueOf(open != null));
            return open != null;
        } catch (IOException unused) {
            this.d.put(str, Boolean.FALSE);
            return false;
        }
    }

    private void m(DinamicTemplate dinamicTemplate, DinamicTemplate dinamicTemplate2, long j) {
        C6312a.h().d();
    }

    public static DTemplateManager q(String str) {
        if (TextUtils.isEmpty(str)) {
            return C6313b.c("default").b;
        }
        return C6313b.c(str).b;
    }

    public void c(List<DinamicTemplate> list, DinamicTemplateDownloaderCallback dinamicTemplateDownloaderCallback) {
        C6340a c6340a = new C6340a(this, dinamicTemplateDownloaderCallback);
        SerialTaskManager.DownLoadTask downLoadTask = new SerialTaskManager.DownLoadTask(this.b, this.f);
        downLoadTask.b = c6340a;
        downLoadTask.c = list;
        downLoadTask.d = this.a;
        this.g.b(downLoadTask);
    }

    public DinamicTemplate d(DinamicTemplate dinamicTemplate) {
        return this.b.a(dinamicTemplate);
    }

    public DinamicTemplate e(DinamicTemplate dinamicTemplate) {
        if (dinamicTemplate == null) {
            return null;
        }
        long nanoTime = System.nanoTime();
        if (dinamicTemplate.isPreset()) {
            DinamicTemplate i = i(dinamicTemplate);
            m(dinamicTemplate, i, System.nanoTime() - nanoTime);
            return i;
        }
        CacheStrategy cacheStrategy = this.i;
        if (cacheStrategy == CacheStrategy.STRATEGY_DEFAULT) {
            DinamicTemplate l = l(dinamicTemplate);
            if (l != null) {
                m(dinamicTemplate, l, System.nanoTime() - nanoTime);
                return l;
            }
        } else if (cacheStrategy == CacheStrategy.STRATEGY_ALLOW_VERSION_DEGRADE) {
            DinamicTemplate l2 = l(dinamicTemplate);
            if (l2 != null) {
                m(dinamicTemplate, l2, System.nanoTime() - nanoTime);
                return l2;
            }
            DinamicTemplate d = d(dinamicTemplate);
            if (d != null) {
                m(dinamicTemplate, d, System.nanoTime() - nanoTime);
                return d;
            }
        }
        DinamicTemplate i2 = i(dinamicTemplate);
        m(dinamicTemplate, i2, System.nanoTime() - nanoTime);
        return i2;
    }

    public C6350a g() {
        return this.b;
    }

    public XmlResourceParser h(DinamicTemplate dinamicTemplate) {
        if (this.e != null && dinamicTemplate != null && !TextUtils.isEmpty(dinamicTemplate.name)) {
            try {
                int f = f(dinamicTemplate.name);
                if (f > 0) {
                    Log.d("DTemplateManager", "Res parser is applied: " + dinamicTemplate.name);
                    return this.e.getResources().getLayout(f);
                }
            } catch (Exception e) {
                Log.e("DTemplateManager", "Get layout parser exception", e);
            }
        }
        return null;
    }

    public DinamicTemplate i(DinamicTemplate dinamicTemplate) {
        if (f(dinamicTemplate.name) > 0) {
            DinamicTemplate dinamicTemplate2 = new DinamicTemplate();
            dinamicTemplate2.name = dinamicTemplate.name;
            dinamicTemplate2.version = "";
            return dinamicTemplate2;
        } else if (k(dinamicTemplate.name)) {
            DinamicTemplate dinamicTemplate3 = new DinamicTemplate();
            dinamicTemplate3.name = dinamicTemplate.name;
            dinamicTemplate3.version = "";
            return dinamicTemplate3;
        } else {
            return null;
        }
    }

    public String j(DinamicTemplate dinamicTemplate) {
        if (dinamicTemplate == null) {
            return null;
        }
        if (dinamicTemplate.isPreset()) {
            return dinamicTemplate.name;
        }
        return dinamicTemplate.name + JSMethod.NOT_SET + dinamicTemplate.version;
    }

    public DinamicTemplate l(DinamicTemplate dinamicTemplate) {
        if (this.b.d(j(dinamicTemplate))) {
            DinamicTemplate dinamicTemplate2 = new DinamicTemplate();
            dinamicTemplate2.templateUrl = dinamicTemplate.templateUrl;
            dinamicTemplate2.name = dinamicTemplate.name;
            dinamicTemplate2.version = dinamicTemplate.version;
            return dinamicTemplate2;
        }
        return null;
    }

    public byte[] n(DinamicTemplate dinamicTemplate) {
        return this.b.g(this.h, j(dinamicTemplate));
    }

    public byte[] o(DinamicTemplate dinamicTemplate) throws IOException {
        String j = j(dinamicTemplate);
        if (TextUtils.isEmpty(j)) {
            return null;
        }
        return this.b.h(j);
    }

    public void p(CacheStrategy cacheStrategy) {
        this.i = cacheStrategy;
    }
}
