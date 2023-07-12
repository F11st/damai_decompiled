package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.taobao.windvane.service.WVEventId;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCSubSetupTask;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.C7325b;
import com.uc.webview.export.internal.utility.C7327d;
import com.uc.webview.export.internal.utility.C7337j;
import com.uc.webview.export.internal.utility.C7343m;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.o */
/* loaded from: classes11.dex */
public class C7285o extends SetupTask {
    private static C7285o c;
    private static Stack<UCSetupTask> d = new Stack<>();
    public AbstractC7282l a;
    private AbstractC7282l e;
    private AbstractC7282l f;
    private AbstractC7282l g;
    private Context h;
    private UCElapseTime i;
    private UCSetupException j;
    private UCSetupTask k;
    private ValueCallback<AbstractC7282l> l;
    private ValueCallback<AbstractC7282l> m;
    private List<ax> n;
    private boolean o = false;
    private final ValueCallback<AbstractC7282l> p = new C7286p(this);
    private final ValueCallback<AbstractC7282l> q = new C7291u(this);
    private final ValueCallback<AbstractC7282l> r = new C7292v(this);
    private final ValueCallback<AbstractC7282l> s = new C7293w(this);
    private final ValueCallback<AbstractC7282l> t = new C7256ad(this);
    private Object u = new Object();
    private bb v = null;

    private C7285o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AbstractC7282l f(C7285o c7285o) {
        c7285o.e = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AbstractC7282l i(C7285o c7285o) {
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_CREATE_DELAY_SEARE_CORE_FILE_TASK_PV);
        AbstractC7282l a = c7285o.a(new C7266ar(), "ShareCoreSearchCoreFileTask");
        a.setParent(UCSetupTask.getRoot());
        return a;
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public void run() {
        AbstractC7282l abstractC7282l;
        AbstractC7282l a;
        AbstractC7282l abstractC7282l2;
        AbstractC7282l a2;
        C7302b.a(5);
        this.i = new UCElapseTime();
        C7327d.a("HasStartedU4SDKSetup", "true");
        Log.rInfo("ucstartup", "start U4 SDK setup");
        ((SetupTask) setup(UCCore.OPTION_UCM_ZIP_DIR, (Object) null)).setup(UCCore.OPTION_USE_SDK_SETUP, (Object) Boolean.TRUE);
        setupGlobalOnce();
        onEvent(UCCore.EVENT_STAT, (ValueCallback) new C7288r(this, getCallback(UCCore.EVENT_STAT)));
        callbackStat(new Pair<>(IWaStat.SETUP_START, null));
        if (C7349p.b(C7349p.a(this.mOptions, UCCore.OPTION_USE_SYSTEM_WEBVIEW))) {
            d.push(null);
        }
        C7302b.a(287);
        this.h = (Context) getOption("CONTEXT");
        this.m = new UCAsyncTask.C7251a();
        this.l = new UCSubSetupTask.C7253a();
        af.a(this.mOptions);
        if (!C7349p.b(C7349p.a(this.mOptions, UCCore.OPTION_USE_SYSTEM_WEBVIEW))) {
            Log.i("SdkSetupTask", "force to use system webview");
            b((AbstractC7282l) new ba()).start();
        } else if (C7349p.a(this.mOptions)) {
            Log.i("SdkSetupTask", "isThickSDK");
            C7302b.a(314);
            String str = (String) this.mOptions.get(UCCore.OPTION_UCM_KRL_DIR);
            String str2 = (String) this.mOptions.get(UCCore.OPTION_SO_FILE_PATH);
            String str3 = (String) this.mOptions.get(UCCore.OPTION_RES_FILE_PATH);
            String str4 = (String) this.mOptions.get(UCCore.OPTION_UCM_ZIP_FILE);
            String str5 = C7349p.a(str) ? str2 : str;
            if (C7343m.b(this.h, this.mOptions)) {
                String str6 = C7343m.a().soDirPath;
                C7302b.a(509);
                abstractC7282l2 = a(b(), str6);
                C7302b.a(510);
                abstractC7282l2.setUCM(C7343m.a());
                C7302b.a(500, "1");
            } else if (!C7349p.a(str5)) {
                abstractC7282l2 = (AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) a(new bb(), aj.a(str5)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) str2)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) str3)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) str);
            } else if (C7349p.a(str4)) {
                abstractC7282l2 = null;
            } else {
                abstractC7282l2 = (AbstractC7282l) a(new C7268b(), str4).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) str4);
                if (C7349p.a((Boolean) this.mOptions.get(UCCore.OPTION_FIRST_USE_SYSTEM_WEBVIEW))) {
                    Log.i("SdkSetupTask", "first use system webview for unzip in thick");
                    this.g = abstractC7282l2;
                    abstractC7282l2 = b((AbstractC7282l) new ba());
                }
            }
            if (C7343m.a(this.h, this.mOptions) && (a2 = a(abstractC7282l2, true)) != null) {
                abstractC7282l2 = a2;
            }
            C7302b.a(315);
            if (abstractC7282l2 != null) {
                C7302b.a(291);
                abstractC7282l2.start();
            } else if (this.e != null) {
                C7302b.a(291);
                a(new bb(), "").start();
            } else {
                throw new UCSetupException((int) WVEventId.WV_CORE_SWITCH, "At least 1 of OPTION_SO_FILE_PATH |OPTION_UCM_KRL_DIR |OPTION_UCM_UPD_URL  should be given.");
            }
            SDKFactory.c("Thick SDK");
        } else {
            C7302b.a(288);
            C7302b.a(141);
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NEW_DEF_TASK);
            String str7 = (String) this.mOptions.get(UCCore.OPTION_DEX_FILE_PATH);
            if (C7343m.b(this.h, this.mOptions)) {
                abstractC7282l = a((AbstractC7282l) new bh().setUCM(C7343m.a()), (String) C7343m.a().coreImplModule.second);
                C7302b.a(500, "1");
            } else if (!C7349p.a(str7)) {
                abstractC7282l = (AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) a(new bh(), str7).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) str7)).setup(UCCore.OPTION_SO_FILE_PATH, getOption(UCCore.OPTION_SO_FILE_PATH))).setup(UCCore.OPTION_RES_FILE_PATH, getOption(UCCore.OPTION_RES_FILE_PATH));
            } else {
                String str8 = (String) this.mOptions.get(UCCore.OPTION_UCM_ZIP_FILE);
                if (!C7349p.a(str8)) {
                    abstractC7282l = (AbstractC7282l) a(new C7268b(), str8).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) str8);
                    if (C7349p.a((Boolean) this.mOptions.get(UCCore.OPTION_FIRST_USE_SYSTEM_WEBVIEW))) {
                        Log.i("SdkSetupTask", "first use system webview for unzip");
                        this.g = abstractC7282l;
                        abstractC7282l = b((AbstractC7282l) new ba());
                    }
                } else {
                    String str9 = (String) this.mOptions.get(UCCore.OPTION_UCM_LIB_DIR);
                    if (!C7349p.a(str9)) {
                        this.mOptions.get(UCCore.OPTION_FORBID_GEN_REPAIR_DIR);
                        abstractC7282l = (AbstractC7282l) a(new bh(), str9).setup(UCCore.OPTION_UCM_LIB_DIR, (Object) str9);
                    } else {
                        String str10 = (String) this.mOptions.get(UCCore.OPTION_UCM_KRL_DIR);
                        if (!C7349p.a(str10)) {
                            abstractC7282l = (AbstractC7282l) a(new bh(), str10).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) str10);
                        } else {
                            String str11 = (String) this.mOptions.get(UCCore.OPTION_UCM_CFG_FILE);
                            abstractC7282l = !C7349p.a(str11) ? (AbstractC7282l) a(new bh(), str11).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) str11) : null;
                        }
                    }
                }
            }
            if (C7343m.a(this.h, this.mOptions) && (a = a(abstractC7282l, C7349p.a((Boolean) getOption(UCCore.OPTION_SKIP_OLD_KERNEL)))) != null) {
                abstractC7282l = a;
            }
            C7302b.a(142);
            AbstractC7282l e = CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY)) ? e() : null;
            Log.d("SdkSetupTask", "mUpdateTask: " + this.e + " shareCoreTask: " + e);
            C7302b.a(289);
            if (abstractC7282l != null) {
                if (this.e != null && e != null) {
                    a(e);
                    d.push(e);
                }
                C7302b.a(290);
                abstractC7282l.start();
            } else if (this.e != null) {
                C7302b.a(290);
                a(new bh(), "").start();
            } else if (e != null) {
                a(e);
                C7302b.a(290);
                e.start();
            } else {
                throw new UCSetupException((int) WVEventId.WV_CORE_SWITCH, "At least 1 of OPTION_DEX_FILE_PATH|OPTION_UCM_LIB_DIR|OPTION_UCM_KRL_DIR|OPTION_UCM_CFG_FILE|OPTION_UCM_UPD_URL and CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY should be given.");
            }
        }
        C7302b.a(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractC7282l e() {
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NEW_SC_TASK);
        return (AbstractC7282l) a(new aq(), "ShareCoreSdcardSetupTask").setup(UCCore.OPTION_SHARE_CORE_SETUP_TASK_FLAG, (Object) Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (UCSetupTask.getTotalLoadedUCM().coreType != 2) {
                C7325b.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            SDKFactory.c(SDKFactory.a(UCSetupTask.getTotalLoadedUCM().ucmPackageInfo, (String) getOption(UCCore.OPTION_LOAD_POLICY)));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            C7337j.a((String) getOption(UCCore.OPTION_LOAD_SHARE_CORE_HOST));
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        bt btVar;
        if (!af.b() || (btVar = UCSetupTask.getTotalLoadedUCM().ucmPackageInfo) == null || this.h == null) {
            return;
        }
        C7343m.a(btVar, this.mOptions);
        C7343m.a(btVar, C7343m.b(this.h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractC7282l b(AbstractC7282l abstractC7282l) {
        ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) abstractC7282l.setParent(this)).setOptions(this.mOptions)).onEvent(UCCore.LEGACY_EVENT_SETUP, (ValueCallback) this.m)).onEvent("load", (ValueCallback) this.m)).onEvent(UCCore.LEGACY_EVENT_INIT, (ValueCallback) this.m)).onEvent("switch", (ValueCallback) this.m)).onEvent(UCCore.EVENT_STAT, (ValueCallback) this.l)).onEvent("success", (ValueCallback) this.p)).onEvent("exception", (ValueCallback) this.q);
        return abstractC7282l;
    }

    public static synchronized C7285o a() {
        C7285o c7285o;
        synchronized (C7285o.class) {
            if (c == null) {
                C7302b.a(327);
                c = new C7285o();
                C7302b.a(331);
            }
            c7285o = c;
        }
        return c7285o;
    }

    private AbstractC7282l a(AbstractC7282l abstractC7282l, String str) {
        ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) b(abstractC7282l).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) null)).setup(UCCore.OPTION_UCM_LIB_DIR, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null);
        if (!C7349p.a(str)) {
            aj setupCrashImprover = abstractC7282l.getSetupCrashImprover(getContext(), str);
            ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) abstractC7282l.onEvent("start", (ValueCallback) setupCrashImprover.b)).onEvent(UCCore.EVENT_DIE, (ValueCallback) setupCrashImprover.c)).onEvent("crash_none", (ValueCallback) null)).onEvent("crash_seen", (ValueCallback) null)).onEvent("crash_repeat", (ValueCallback) this.r);
        }
        return abstractC7282l;
    }

    public final bb b() {
        if (this.v == null) {
            synchronized (this.u) {
                if (this.v == null) {
                    this.v = new bb();
                }
            }
        }
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x025a A[Catch: all -> 0x036c, TRY_LEAVE, TryCatch #16 {all -> 0x036c, blocks: (B:99:0x0233, B:102:0x025a), top: B:242:0x0233 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02cd A[Catch: all -> 0x036a, TryCatch #17 {all -> 0x036a, blocks: (B:105:0x0268, B:109:0x027b, B:113:0x028e, B:117:0x02d1, B:121:0x02e8, B:125:0x02f9, B:127:0x0303, B:131:0x0316, B:132:0x033e, B:136:0x0351, B:139:0x035e, B:140:0x0364, B:116:0x02cd, B:104:0x0262), top: B:241:0x0262 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0303 A[Catch: all -> 0x036a, TryCatch #17 {all -> 0x036a, blocks: (B:105:0x0268, B:109:0x027b, B:113:0x028e, B:117:0x02d1, B:121:0x02e8, B:125:0x02f9, B:127:0x0303, B:131:0x0316, B:132:0x033e, B:136:0x0351, B:139:0x035e, B:140:0x0364, B:116:0x02cd, B:104:0x0262), top: B:241:0x0262 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03ab A[Catch: all -> 0x03f5, TryCatch #21 {all -> 0x0525, blocks: (B:3:0x001b, B:5:0x0024, B:7:0x0031, B:9:0x003b, B:11:0x0065, B:153:0x037a, B:184:0x0485, B:216:0x04fe, B:152:0x0377, B:62:0x0193, B:197:0x04c4, B:199:0x04d0, B:201:0x04d4, B:63:0x0196, B:67:0x01a1, B:180:0x045b, B:182:0x045f, B:205:0x04e6, B:158:0x03a1, B:160:0x03ab, B:164:0x03b4, B:166:0x03be, B:170:0x03cc, B:172:0x03dd, B:176:0x040d, B:218:0x050a, B:220:0x0510, B:210:0x04ef, B:212:0x04f3, B:12:0x0068, B:154:0x037d, B:190:0x048e, B:192:0x0492), top: B:234:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03be A[Catch: all -> 0x03f5, TryCatch #21 {all -> 0x0525, blocks: (B:3:0x001b, B:5:0x0024, B:7:0x0031, B:9:0x003b, B:11:0x0065, B:153:0x037a, B:184:0x0485, B:216:0x04fe, B:152:0x0377, B:62:0x0193, B:197:0x04c4, B:199:0x04d0, B:201:0x04d4, B:63:0x0196, B:67:0x01a1, B:180:0x045b, B:182:0x045f, B:205:0x04e6, B:158:0x03a1, B:160:0x03ab, B:164:0x03b4, B:166:0x03be, B:170:0x03cc, B:172:0x03dd, B:176:0x040d, B:218:0x050a, B:220:0x0510, B:210:0x04ef, B:212:0x04f3, B:12:0x0068, B:154:0x037d, B:190:0x048e, B:192:0x0492), top: B:234:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03dd A[Catch: all -> 0x03f5, TRY_LEAVE, TryCatch #21 {all -> 0x0525, blocks: (B:3:0x001b, B:5:0x0024, B:7:0x0031, B:9:0x003b, B:11:0x0065, B:153:0x037a, B:184:0x0485, B:216:0x04fe, B:152:0x0377, B:62:0x0193, B:197:0x04c4, B:199:0x04d0, B:201:0x04d4, B:63:0x0196, B:67:0x01a1, B:180:0x045b, B:182:0x045f, B:205:0x04e6, B:158:0x03a1, B:160:0x03ab, B:164:0x03b4, B:166:0x03be, B:170:0x03cc, B:172:0x03dd, B:176:0x040d, B:218:0x050a, B:220:0x0510, B:210:0x04ef, B:212:0x04f3, B:12:0x0068, B:154:0x037d, B:190:0x048e, B:192:0x0492), top: B:234:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x045f A[Catch: all -> 0x0488, TRY_LEAVE, TryCatch #21 {all -> 0x0525, blocks: (B:3:0x001b, B:5:0x0024, B:7:0x0031, B:9:0x003b, B:11:0x0065, B:153:0x037a, B:184:0x0485, B:216:0x04fe, B:152:0x0377, B:62:0x0193, B:197:0x04c4, B:199:0x04d0, B:201:0x04d4, B:63:0x0196, B:67:0x01a1, B:180:0x045b, B:182:0x045f, B:205:0x04e6, B:158:0x03a1, B:160:0x03ab, B:164:0x03b4, B:166:0x03be, B:170:0x03cc, B:172:0x03dd, B:176:0x040d, B:218:0x050a, B:220:0x0510, B:210:0x04ef, B:212:0x04f3, B:12:0x0068, B:154:0x037d, B:190:0x048e, B:192:0x0492), top: B:234:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0492 A[Catch: all -> 0x04be, TRY_LEAVE, TryCatch #21 {all -> 0x0525, blocks: (B:3:0x001b, B:5:0x0024, B:7:0x0031, B:9:0x003b, B:11:0x0065, B:153:0x037a, B:184:0x0485, B:216:0x04fe, B:152:0x0377, B:62:0x0193, B:197:0x04c4, B:199:0x04d0, B:201:0x04d4, B:63:0x0196, B:67:0x01a1, B:180:0x045b, B:182:0x045f, B:205:0x04e6, B:158:0x03a1, B:160:0x03ab, B:164:0x03b4, B:166:0x03be, B:170:0x03cc, B:172:0x03dd, B:176:0x040d, B:218:0x050a, B:220:0x0510, B:210:0x04ef, B:212:0x04f3, B:12:0x0068, B:154:0x037d, B:190:0x048e, B:192:0x0492), top: B:234:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04d0 A[Catch: all -> 0x04e2, TryCatch #21 {all -> 0x0525, blocks: (B:3:0x001b, B:5:0x0024, B:7:0x0031, B:9:0x003b, B:11:0x0065, B:153:0x037a, B:184:0x0485, B:216:0x04fe, B:152:0x0377, B:62:0x0193, B:197:0x04c4, B:199:0x04d0, B:201:0x04d4, B:63:0x0196, B:67:0x01a1, B:180:0x045b, B:182:0x045f, B:205:0x04e6, B:158:0x03a1, B:160:0x03ab, B:164:0x03b4, B:166:0x03be, B:170:0x03cc, B:172:0x03dd, B:176:0x040d, B:218:0x050a, B:220:0x0510, B:210:0x04ef, B:212:0x04f3, B:12:0x0068, B:154:0x037d, B:190:0x048e, B:192:0x0492), top: B:234:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04f3 A[Catch: all -> 0x04fa, TRY_LEAVE, TryCatch #21 {all -> 0x0525, blocks: (B:3:0x001b, B:5:0x0024, B:7:0x0031, B:9:0x003b, B:11:0x0065, B:153:0x037a, B:184:0x0485, B:216:0x04fe, B:152:0x0377, B:62:0x0193, B:197:0x04c4, B:199:0x04d0, B:201:0x04d4, B:63:0x0196, B:67:0x01a1, B:180:0x045b, B:182:0x045f, B:205:0x04e6, B:158:0x03a1, B:160:0x03ab, B:164:0x03b4, B:166:0x03be, B:170:0x03cc, B:172:0x03dd, B:176:0x040d, B:218:0x050a, B:220:0x0510, B:210:0x04ef, B:212:0x04f3, B:12:0x0068, B:154:0x037d, B:190:0x048e, B:192:0x0492), top: B:234:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x050a A[Catch: all -> 0x051a, TRY_ENTER, TryCatch #21 {all -> 0x0525, blocks: (B:3:0x001b, B:5:0x0024, B:7:0x0031, B:9:0x003b, B:11:0x0065, B:153:0x037a, B:184:0x0485, B:216:0x04fe, B:152:0x0377, B:62:0x0193, B:197:0x04c4, B:199:0x04d0, B:201:0x04d4, B:63:0x0196, B:67:0x01a1, B:180:0x045b, B:182:0x045f, B:205:0x04e6, B:158:0x03a1, B:160:0x03ab, B:164:0x03b4, B:166:0x03be, B:170:0x03cc, B:172:0x03dd, B:176:0x040d, B:218:0x050a, B:220:0x0510, B:210:0x04ef, B:212:0x04f3, B:12:0x0068, B:154:0x037d, B:190:0x048e, B:192:0x0492), top: B:234:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x051e A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0156 A[Catch: all -> 0x0189, TryCatch #18 {all -> 0x0189, blocks: (B:28:0x00cf, B:30:0x00ef, B:33:0x00f6, B:34:0x00fd, B:35:0x00fe, B:37:0x010c, B:39:0x012c, B:42:0x0133, B:43:0x013a, B:44:0x013b, B:49:0x0156, B:45:0x0146), top: B:240:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b2 A[Catch: all -> 0x0370, TRY_LEAVE, TryCatch #13 {all -> 0x0370, blocks: (B:71:0x01a9, B:73:0x01b2, B:79:0x01bd, B:84:0x01e1, B:86:0x01ff), top: B:247:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bd A[Catch: all -> 0x0370, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x0370, blocks: (B:71:0x01a9, B:73:0x01b2, B:79:0x01bd, B:84:0x01e1, B:86:0x01ff), top: B:247:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0216 A[Catch: all -> 0x0228, TRY_LEAVE, TryCatch #19 {all -> 0x0228, blocks: (B:88:0x0209, B:91:0x0216), top: B:238:0x0209 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void b(com.uc.webview.export.internal.setup.C7285o r26, com.uc.webview.export.internal.setup.UCMRunningInfo r27) {
        /*
            Method dump skipped, instructions count: 1329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.C7285o.b(com.uc.webview.export.internal.setup.o, com.uc.webview.export.internal.setup.UCMRunningInfo):void");
    }

    public final void a(String str, Callable<Boolean> callable) {
        Boolean bool = Boolean.TRUE;
        AbstractC7282l abstractC7282l = (AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) new by().setParent(UCSetupTask.getRoot())).setOptions(this.mOptions)).setup(UCCore.OPTION_UCM_ZIP_DIR, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) null)).setup(UCCore.OPTION_USE_SDK_SETUP, (Object) bool)).setup(UCCore.OPTION_CHECK_MULTI_CORE, (Object) bool);
        Object obj = this.l;
        if (obj == null) {
            obj = new UCSubSetupTask.C7253a();
        }
        AbstractC7282l abstractC7282l2 = (AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) abstractC7282l.onEvent(UCCore.EVENT_STAT, (ValueCallback) obj)).onEvent("switch", (ValueCallback) this.t)).onEvent(UCCore.EVENT_DOWNLOAD_EXCEPTION, (ValueCallback) new ac(this))).onEvent(UCCore.EVENT_DOWNLOAD_FILE_DELETE, (ValueCallback) new C7255ab(this, str))).onEvent(UCCore.EVENT_UPDATE_PROGRESS, (ValueCallback) new aa(this));
        this.a = abstractC7282l2;
        this.e = abstractC7282l2;
        if (callable != null) {
            abstractC7282l2.setup(UCCore.OPTION_DOWNLOAD_CHECKER, (Object) callable);
        }
        if (!C7349p.a(str)) {
            this.e.setup(UCCore.OPTION_UCM_UPD_URL, (Object) str);
        }
        if (CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY))) {
            this.e.onEvent(UCCore.EVENT_UPDATE_SHARE_CORE, (ValueCallback) this.s);
        }
    }

    private AbstractC7282l a(AbstractC7282l abstractC7282l, boolean z) {
        String str = (String) getOption(UCCore.OPTION_UCM_UPD_URL);
        if (C7349p.a(str)) {
            return null;
        }
        a((String) getOption(UCCore.OPTION_UCM_UPD_URL), (Callable<Boolean>) null);
        try {
            File a = C7349p.a(this.h, "updates");
            if (a.list().length > 0) {
                if (z) {
                    String sourceHash = UCCyclone.getSourceHash(str);
                    String[] list = a.list();
                    Log.d("SdkSetupTask", "hashcode: " + sourceHash + " list: " + list);
                    int length = list.length;
                    boolean z2 = false;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (list[i].equals(sourceHash)) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z2) {
                        return null;
                    }
                }
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NEW_UPD_TASK);
                this.o = true;
                if (abstractC7282l != null) {
                    d.push(abstractC7282l);
                }
                String absolutePath = a.getAbsolutePath();
                if (z || a.list().length > 1) {
                    absolutePath = new File(a, UCCyclone.getSourceHash(str)).getAbsolutePath();
                }
                return (AbstractC7282l) ((AbstractC7282l) a(C7349p.f() ? new bb() : new bh(), absolutePath).setup(UCCore.OPTION_CHECK_DECOMPRESS_FINISH, (Object) Boolean.TRUE)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) absolutePath);
            }
        } catch (Exception e) {
            Log.d("SdkSetupTask", "UCMPackageInfo.getUpdateRoot exception: " + e);
        }
        return null;
    }

    private void a(AbstractC7282l abstractC7282l) {
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_FAULT_TOLERANCE_TASK);
        AbstractC7282l a = (C7349p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_KRL_DIR)) && C7349p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_ZIP_FPATH))) ? null : a(new ap(), "ShareCoreFaultToleranceTask");
        if (a != null) {
            d.push(a);
            abstractC7282l.onEvent(UCCore.EVENT_DELAY_SEARCH_CORE_FILE, (ValueCallback) new C7296z(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(C7285o c7285o, UCMRunningInfo uCMRunningInfo) {
        c7285o.setLoadedUCM(uCMRunningInfo);
        c7285o.setTotalLoadedUCM(uCMRunningInfo);
        SDKFactory.h = uCMRunningInfo.loadType;
        Log.d("SdkSetupTask", "initLoadUcm sLoadType: " + SDKFactory.h + ", isShareCore:" + uCMRunningInfo.isShareCore);
        if (uCMRunningInfo.isShareCore) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDCARD_SETUP_SUCCESS);
        }
        if (uCMRunningInfo.isOldExtraKernel) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_OLD_KERNAL_SETUP_SUCCESS);
        }
        if (uCMRunningInfo.isFirstTimeOdex) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_FIRST_KERNAL_SETUP_SUCCESS);
        }
    }
}
