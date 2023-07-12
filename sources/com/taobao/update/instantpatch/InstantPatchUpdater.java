package com.taobao.update.instantpatch;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.common.PatchInfo;
import com.android.alibaba.ip.server.InstantPatcher;
import com.android.alibaba.ip.server.Restarter;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.UpdateListener;
import com.taobao.update.instantpatch.model.InstantUpdateInfo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import tb.d31;
import tb.e31;
import tb.lu2;
import tb.mu2;
import tb.pu2;
import tb.uq1;
import tb.xq1;
import tb.yq1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class InstantPatchUpdater extends mu2 implements UpdateListener {
    public static final String EFFECTIVE_VERSION = "instantpatch_effective_version";
    public static final String PATCH_FROM = "patch_from";
    private Context a;
    private String b;
    private volatile boolean c;
    private PublishType d;
    private String e;
    private UpdateListener.PatchListener f;
    private SharedPreferences g;
    private boolean h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum PublishType {
        BETA,
        RELEASE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PublishType.values().length];
            a = iArr;
            try {
                iArr[PublishType.BETA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PublishType.RELEASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private static final InstantPatchUpdater a = new InstantPatchUpdater();
    }

    private void a() {
        for (Activity activity : Restarter.getActivities(getContext(), false)) {
            activity.finish();
        }
    }

    private void b(InstantUpdateInfo instantUpdateInfo, String str) {
        if (str.equals(lu2.SCAN)) {
            j("start to do instantpatch!");
        }
        long currentTimeMillis = System.currentTimeMillis();
        yq1.stat(true, "revupdate", 0L, 0, "", Long.valueOf(instantUpdateInfo.patchVersion).longValue());
        e31 e31Var = new e31();
        e31Var.context = this.a;
        e31Var.workDir = e31Var.getPatchPath();
        new uq1(e31Var).download(instantUpdateInfo);
        if (e31Var.success && !TextUtils.isEmpty(e31Var.path)) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (str.equals(lu2.SCAN)) {
                j("instantpatch download success!");
            }
            yq1.stat(true, "download", currentTimeMillis2, e31Var.errorCode, e31Var.errorMsg, Long.valueOf(instantUpdateInfo.patchVersion).longValue());
            new xq1(e31Var).install(instantUpdateInfo);
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            if (e31Var.success) {
                yq1.stat(true, "install", currentTimeMillis3, e31Var.errorCode, e31Var.errorMsg, Long.valueOf(instantUpdateInfo.patchVersion).longValue());
                i(str);
                UpdateListener.PatchListener patchListener = this.f;
                if (patchListener != null) {
                    patchListener.patchSuccess();
                }
                if (str.equals(lu2.SCAN)) {
                    j("instantpatch do patch success!");
                    if (InstantPatcher.hasResources && d31.waitForConfirmAction("Instantpatch当前有资源patch,重启生效?")) {
                        Context context = this.a;
                        Restarter.restartApp(context, Restarter.getActivities(context, false));
                    }
                }
                if (InstantPatcher.hasResources) {
                    this.h = true;
                    return;
                }
                return;
            }
            yq1.stat(false, "install", 0L, e31Var.errorCode, e31Var.errorMsg, Long.valueOf(instantUpdateInfo.patchVersion).longValue());
            UpdateListener.PatchListener patchListener2 = this.f;
            if (patchListener2 != null) {
                patchListener2.patchFailed(e31Var.errorMsg);
            }
            if (str.equals(lu2.SCAN)) {
                j("instantpatch do patch failed!");
                return;
            }
            return;
        }
        if (str.equals(lu2.SCAN)) {
            j("instantpatch download failed!");
        }
        yq1.stat(false, "download", 0L, e31Var.errorCode, e31Var.errorMsg, Long.valueOf(instantUpdateInfo.patchVersion).longValue());
        UpdateListener.PatchListener patchListener3 = this.f;
        if (patchListener3 != null) {
            patchListener3.patchFailed(e31Var.errorMsg);
        }
    }

    private boolean c(InstantUpdateInfo instantUpdateInfo) {
        return InstantPatcher.create(this.a).hasPatched(createPatchInfo(instantUpdateInfo));
    }

    private boolean d() {
        try {
            this.i = (getContext().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            this.i = true;
        }
        return this.i;
    }

    private String e() {
        return this.g.getString(PATCH_FROM, "");
    }

    private boolean f(String str) {
        if (!d() || lu2.SCAN.equals(str)) {
            return lu2.SCAN.equals(str) || !e().equals(lu2.SCAN);
        }
        return false;
    }

    private boolean g(InstantUpdateInfo instantUpdateInfo) {
        this.d = instantUpdateInfo.beta ? PublishType.BETA : PublishType.RELEASE;
        this.e = instantUpdateInfo.patchVersion;
        String string = this.g.getString("instantpatch_effective_type", "");
        String string2 = this.g.getString(EFFECTIVE_VERSION, "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return true;
        }
        int i = a.a[this.d.ordinal()];
        return i != 1 ? i != 2 || string.equals(this.d.name()) || !string.equals(PublishType.BETA) || Integer.valueOf(this.e).intValue() > Integer.valueOf(string2).intValue() : Integer.valueOf(this.e).intValue() > Integer.valueOf(string2).intValue();
    }

    private void h() {
        try {
            InstantPatcher create = InstantPatcher.create(this.a);
            Method declaredMethod = InstantPatcher.class.getDeclaredMethod("clearPatchInfo", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(create, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        this.g.edit().putString(EFFECTIVE_VERSION, "").putString("instantpatch_effective_type", "").apply();
    }

    private void i(String str) {
        this.g.edit().putString("instantpatch_effective_type", this.d.name()).putString(EFFECTIVE_VERSION, this.e).putString(PATCH_FROM, str).apply();
    }

    public static InstantPatchUpdater instance() {
        return b.a;
    }

    private void j(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taobao.update.instantpatch.InstantPatchUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(UpdateDataSource.sContext, str, 1).show();
            }
        });
    }

    public PatchInfo createPatchInfo(InstantUpdateInfo instantUpdateInfo) {
        PatchInfo patchInfo = new PatchInfo();
        patchInfo.setPatchVersion(Integer.valueOf(instantUpdateInfo.patchVersion).intValue());
        patchInfo.setBaseVersion(instantUpdateInfo.baseVersion);
        patchInfo.setPriority(Integer.valueOf(instantUpdateInfo.priority).intValue());
        return patchInfo;
    }

    public Context getContext() {
        return this.a;
    }

    @Override // tb.mu2
    public void init(Context context) {
        this.a = context;
        this.b = pu2.getVersionName();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.g = defaultSharedPreferences;
        if (this.b.equals(defaultSharedPreferences.getString("instantpatch_mainversion", ""))) {
            return;
        }
        this.g.edit().putString("instantpatch_mainversion", this.b).putString(EFFECTIVE_VERSION, "").putString("instantpatch_effective_type", "").apply();
        try {
            InstantPatcher.create(context).purge();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // tb.mu2
    public void onBackground() {
        super.onBackground();
        if (this.h) {
            a();
            pu2.killChildProcesses(getContext());
            System.exit(0);
        }
    }

    @Override // tb.mu2
    public void onExit() {
        if (this.h) {
            a();
            pu2.killChildProcesses(getContext());
            System.exit(0);
        }
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        InstantUpdateInfo create;
        if (f(str)) {
            if (this.c) {
                if (str.equals(lu2.SCAN)) {
                    j("instantpatch updating ......");
                    return;
                }
                return;
            }
            this.c = true;
            try {
                try {
                    create = InstantUpdateInfo.create(jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(create.patchUrl) || create.rollback) {
                    if (create.rollback) {
                        h();
                    } else if (c(create)) {
                        if (str.equals(lu2.SCAN)) {
                            j("instantpatch has patched!");
                        } else {
                            UpdateListener.PatchListener patchListener = this.f;
                            if (patchListener != null) {
                                patchListener.hasPatched(true);
                            }
                        }
                    } else if (g(create)) {
                        b(create, str);
                    }
                }
            } finally {
                this.c = false;
            }
        }
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void patchProcessListener(UpdateListener.PatchListener patchListener) {
        this.f = patchListener;
    }

    private InstantPatchUpdater() {
        this.h = false;
    }
}
