package com.uc.webview.export.internal.update;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.cyclone.update.UpdateServiceImpl;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.AbstractC7282l;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.by;
import com.uc.webview.export.internal.utility.C7336i;
import com.uc.webview.export.internal.utility.C7340l;
import com.uc.webview.export.internal.utility.C7345n;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.update.b */
/* loaded from: classes11.dex */
public final class C7312b {
    private static AtomicBoolean a = new AtomicBoolean(false);
    private static volatile Method b = null;

    public static final File a(Context context) throws UCSetupException {
        String str = (String) C7336i.a().a(UCCore.OPTION_UC_PLAYER_ROOT);
        return !C7349p.a(str) ? new File(str) : C7349p.a(context, "ucplayer");
    }

    public static final File b(Context context) throws UCSetupException {
        return C7349p.a(context, "updates");
    }

    private static Method b() {
        if (b == null) {
            try {
                int i = UpdateServiceImpl.a;
                b = UpdateServiceImpl.class.getMethod("create", new Class[0]);
                b.setAccessible(true);
            } catch (Throwable unused) {
                Log.e("UpdateUtils", "UpdateService disabled");
            }
        }
        return b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.update.b$a */
    /* loaded from: classes11.dex */
    public static class C7313a implements UpdateService.EventCallback {
        protected final Context d;
        protected final Callable<Boolean> e;
        protected final Map<String, ValueCallback> f;
        protected volatile boolean g = false;
        protected volatile int h = 3;

        public C7313a(Context context, Callable<Boolean> callable, Map<String, ValueCallback> map) {
            this.d = context;
            this.e = callable;
            this.f = map;
        }

        public static void a(String str, String str2) {
            if (C7349p.a(str2)) {
                IWaStat.WaStat.stat(str);
            } else {
                IWaStat.WaStat.stat(str, str2);
            }
        }

        public void a() {
        }

        public ValueCallback<Object[]> b() {
            return null;
        }

        public void b(UpdateService updateService) {
            Log.i("UpdateUtils", "onException url:" + updateService.getUrl(), updateService.getException());
            a("exception", updateService.getException());
            int i = this.h;
            this.h = i - 1;
            if (i > 0) {
                updateService.setup(UpdateService.OPTION_DELAY_START_MILLIS, Long.valueOf((long) DateUtils.MILLIS_PER_MINUTE)).start();
            }
        }

        public void c(UpdateService updateService) {
            Log.i("UpdateUtils", "onDownloadException url:" + updateService.getUrl(), updateService.getException());
            e(updateService);
        }

        public void d(UpdateService updateService) {
            Log.i("UpdateUtils", "onSuccess url:" + updateService.getUrl());
            a("success", (Object) null);
        }

        public void e(UpdateService updateService) {
            Log.i("UpdateUtils", "onFailed url:" + updateService.getUrl(), updateService.getException());
            a("failed", updateService.getException());
            updateService.stopWith(new RunnableC7320i(this, updateService));
        }

        public void f(UpdateService updateService) {
            Log.i("UpdateUtils", "onFileExists url:" + updateService.getUrl());
        }

        public void g(UpdateService updateService) {
            Log.i("UpdateUtils", "onDeleteDownloadFile url:" + updateService.getUrl());
        }

        public void h(UpdateService updateService) {
            Log.i("UpdateUtils", "onProgressChanged url:" + updateService.getUrl() + ", percent:" + updateService.getPercent());
            a("progress", Integer.valueOf(updateService.getPercent()));
        }

        public void i(UpdateService updateService) {
            Log.i("UpdateUtils", "onDownloadBegin url:" + updateService.getUrl());
        }

        public void j(UpdateService updateService) {
            Log.i("UpdateUtils", "onDownloadSuccess url:" + updateService.getUrl());
            this.g = updateService.getUrl().toLowerCase().endsWith(".7z");
            k(updateService);
            l(updateService);
        }

        public void k(UpdateService updateService) {
            if (this.g) {
                return;
            }
            File downloadFile = updateService.getDownloadFile();
            if (downloadFile != null) {
                String absolutePath = downloadFile.getAbsolutePath();
                Context context = this.d;
                if (C7340l.a(absolutePath, context, context, b(), null)) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("doVerify failed, url:");
            sb.append(updateService.getUrl());
            sb.append(", file:");
            sb.append(downloadFile != null ? downloadFile.getAbsolutePath() : "null");
            Log.i("UpdateUtils", sb.toString());
            a(IWaStat.UCM_FAILED_VERIFY, (String) null);
            throw new RuntimeException("Donwload file verify failed");
        }

        public void l(UpdateService updateService) {
            File extractDir = updateService.getExtractDir();
            if (extractDir != null) {
                UCCyclone.expectCreateDirFile(extractDir);
                String url = updateService.getUrl();
                File downloadFile = updateService.getDownloadFile();
                UCCyclone.decompressIfNeeded(this.d, this.g, url, updateService.getDownloadTotalSize(), updateService.getDownloadLastModified(), downloadFile, extractDir, (FilenameFilter) null, false, UCCyclone.DecFileOrign.Update);
                StringBuilder sb = new StringBuilder();
                UCCyclone.listAllFiles(sb, extractDir);
                Log.i("UpdateUtils", "doExtract finished extractDir:" + extractDir.getAbsolutePath() + sb.toString());
                return;
            }
            throw new RuntimeException("Extract dir is null");
        }

        @Override // com.uc.webview.export.cyclone.update.UpdateService.EventCallback
        public Object onCalled(int i, UpdateService updateService, Object[] objArr) {
            switch (i) {
                case 1:
                    Log.i((String) objArr[0], (String) objArr[1], objArr.length >= 3 ? (Throwable) objArr[2] : null);
                    break;
                case 2:
                    a((String) objArr[0], objArr.length >= 2 ? (String) objArr[1] : null);
                    break;
                case 3:
                    d(updateService);
                    break;
                case 4:
                    e(updateService);
                    break;
                case 5:
                    b(updateService);
                    break;
                case 6:
                    Log.i("UpdateUtils", "onRecovered url:" + updateService.getUrl());
                    break;
                case 7:
                    h(updateService);
                    break;
                case 8:
                    a(updateService);
                    break;
                case 9:
                    f(updateService);
                    break;
                case 10:
                    i(updateService);
                    break;
                case 11:
                    j(updateService);
                    break;
                case 12:
                    c(updateService);
                    break;
                case 13:
                    g(updateService);
                    break;
                case 14:
                    a(updateService, objArr != null ? (Throwable) objArr[0] : null);
                    break;
                case 15:
                    a();
                    break;
                default:
                    Log.e("UpdateUtils", "onCalled invalid eventId:" + i);
                    break;
            }
            return null;
        }

        public void a(UpdateService updateService) {
            Log.i("UpdateUtils", "onCheck url:" + updateService.getUrl());
            try {
                Callable<Boolean> callable = this.e;
                if (callable != null && !callable.call().booleanValue()) {
                    throw new RuntimeException("Update should be in wifi network.");
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        public void a(UpdateService updateService, Throwable th) {
            Log.i("UpdateUtils", "onDownloadInfoChecked url:" + updateService.getUrl());
        }

        private void a(String str, Object obj) {
            C7312b.a(this.f, str, obj);
        }
    }

    public static void a(Context context, String str, Callable<Boolean> callable, Map<String, ValueCallback> map, Map<String, Object> map2) throws UCSetupException {
        C7345n.b(new RunnableC7314c(context, str, callable, map, map2));
    }

    public static void a(Context context, String str, Callable<Boolean> callable, Map<String, ValueCallback> map) throws UCSetupException {
        if (!C7349p.d(context)) {
            Log.e("UpdateUtils", "ignore updateUCPlayer in process " + C7349p.c(context));
        } else if (a.getAndSet(true)) {
            Log.i("UpdateUtils", "want to updateUCPlayer again - " + str);
        } else {
            C7345n.b(new RunnableC7315d(context, str, callable, map));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(Context context, String str, Callable callable, Map map, Map map2) throws UCSetupException {
        UCAsyncTask uCAsyncTask = new UCAsyncTask((Integer) 0);
        by byVar = new by();
        Log.d("UpdateUtils", "doUpdateUCCore url:" + str + ", updatetask:" + byVar);
        Boolean bool = Boolean.TRUE;
        ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) byVar.setup("CONTEXT", (Object) context.getApplicationContext())).setParent(uCAsyncTask)).setup(UCCore.OPTION_UCM_ZIP_DIR, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) null)).setup(UCCore.OPTION_USE_SDK_SETUP, (Object) bool)).setup(UCCore.OPTION_CHECK_MULTI_CORE, (Object) bool)).onEvent("exception", (ValueCallback) new C7317f(str, map))).onEvent("switch", (ValueCallback) new C7316e(map));
        if (map != null) {
            byVar.g = map;
        }
        if (callable != null) {
            byVar.setup(UCCore.OPTION_DOWNLOAD_CHECKER, (Object) callable);
        }
        if (!C7349p.a(str)) {
            byVar.setup(UCCore.OPTION_UCM_UPD_URL, (Object) str);
        }
        if (map2 != null && !map2.isEmpty()) {
            for (Map.Entry entry : map2.entrySet()) {
                byVar.setup((String) entry.getKey(), entry.getValue());
            }
        }
        byVar.start(2000L);
        uCAsyncTask.start();
    }

    public static UpdateService a() {
        Method b2 = b();
        if (b2 == null) {
            return null;
        }
        try {
            return (UpdateService) b2.invoke(null, new Object[0]);
        } catch (Throwable th) {
            Log.e("UpdateUtils", "createService failed", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Map map, String str, Object obj) {
        ValueCallback valueCallback;
        if (map == null || (valueCallback = (ValueCallback) map.get(str)) == null) {
            return;
        }
        try {
            valueCallback.onReceiveValue(obj);
        } catch (Throwable th) {
            Log.e("UpdateUtils", "callback failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(Context context, String str, Callable callable, Map map) throws UCSetupException {
        SDKFactory.b((Long) 1024L);
        SDKFactory.b((Long) 2048L);
        SDKFactory.b((Long) 4096L);
        SDKFactory.b(Long.valueOf((long) PlaybackStateCompat.ACTION_PLAY_FROM_URI));
        SDKFactory.b(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE));
        SDKFactory.b(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID));
        SDKFactory.b(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH));
        SDKFactory.p.remove(IWaStat.VIDEO_ERROR_CODE_UPDATE_CHECK_REQUEST);
        SDKFactory.p.remove(IWaStat.VIDEO_ERROR_CODE_DOWNLOAD);
        SDKFactory.p.remove(IWaStat.VIDEO_ERROR_CODE_VERIFY);
        SDKFactory.p.remove(IWaStat.VIDEO_ERROR_CODE_UNZIP);
        UpdateService a2 = a();
        if (a2 != null) {
            C7318g c7318g = new C7318g();
            File a3 = a(context);
            a2.setup(UpdateService.OPTION_CONTEXT, context.getApplicationContext()).setup("url", str).setup(UpdateService.OPTION_ROOT_DIR, a3).setup(UpdateService.OPTION_CHECK_FILE, "libu3player.so").setup(UpdateService.OPTION_CHECK_LAST_MODIFIED, Boolean.valueOf(C7336i.a().b(UCCore.OPTION_EXACT_LAST_MODIFIED_CHECK))).setup(UpdateService.OPTION_CONNECT_TIME_OUT, Integer.valueOf(C7349p.c())).setup(UpdateService.OPTION_READ_TIME_OUT, Integer.valueOf(C7349p.d())).setCallback(new C7319h(context, callable, map, a3, c7318g)).start();
            return;
        }
        throw new RuntimeException("No UpdateService");
    }
}
