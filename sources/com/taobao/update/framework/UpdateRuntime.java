package com.taobao.update.framework;

import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.update.adapter.ThreadExecutor;
import com.taobao.update.adapter.UIConfirm;
import com.taobao.update.adapter.UIToast;
import com.taobao.update.adapter.UserAction;
import org.android.agoo.common.AgooConstants;
import tb.C9444mm;
import tb.j3;
import tb.nm2;
import tb.qr2;
import tb.sr2;
import tb.ur2;
import tb.va1;
import tb.vr2;
import tb.wb;
import tb.xc1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateRuntime {
    private static Application a = null;
    public static int bundleUpdateMinDisk = 200;
    public static boolean forceInstallAfaterDownload;
    public static boolean installBundleAfterDownload;
    public static boolean popDialogBeforeInstall;
    public static String processName;
    public static String sAppName;
    public static boolean sBundleUpdateSuccess;
    public static String sGroup;
    public static int sLogoResourceId;
    public static String sTTid;
    public boolean commited;

    public static void doUIAlertForConfirm(final String str, final UserAction userAction) {
        xc1.execute(new Runnable() { // from class: com.taobao.update.framework.UpdateRuntime.1
            @Override // java.lang.Runnable
            public void run() {
                UIConfirm uIConfirm = (UIConfirm) wb.getInstance(UIConfirm.class);
                if (uIConfirm != null) {
                    uIConfirm.alertForConfirm(str, userAction);
                } else {
                    Log.e("Updater", "UIConfirm is null");
                }
            }
        });
    }

    public static void execute(final Runnable runnable) {
        ThreadExecutor threadExecutor = (ThreadExecutor) wb.getInstance(ThreadExecutor.class);
        if (threadExecutor != null) {
            threadExecutor.execute(runnable);
        } else {
            new Thread(new Runnable() { // from class: com.taobao.update.framework.UpdateRuntime.3
                @Override // java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    runnable.run();
                }
            }).start();
        }
    }

    public static Application getContext() {
        return a;
    }

    public static void init(Application application, String str, String str2, String str3) {
        a = application;
        sGroup = str3;
        sTTid = str;
        if (!TextUtils.isEmpty(str2)) {
            sAppName = str2;
        } else {
            sAppName = application.getApplicationInfo().loadLabel(application.getPackageManager()).toString();
        }
        a.registerActivityLifecycleCallbacks(new j3());
        qr2.sClickbg2Exit = false;
        wb.registerClass(vr2.class);
        wb.registerClass("sysnotify", ur2.class);
        wb.registerClass(AgooConstants.MESSAGE_NOTIFICATION, sr2.class);
        wb.registerClass(qr2.class);
        wb.registerInstance(new va1());
        wb.registerInstance(new nm2());
        popDialogBeforeInstall = true;
        forceInstallAfaterDownload = false;
        bundleUpdateMinDisk = 200;
        sLogoResourceId = a.getApplicationInfo().icon;
    }

    public static void log(String str) {
        com.taobao.update.adapter.Log log = (com.taobao.update.adapter.Log) wb.getInstance(com.taobao.update.adapter.Log.class);
        if (log != null) {
            log.debug("update.sdk", str);
        } else {
            Log.d("update.sdk", str);
        }
    }

    public static void tips(boolean z, String str, String str2) {
        Log.d(str, str2);
        if (z) {
            toast(str2);
        }
    }

    public static void toast(final String str) {
        xc1.execute(new Runnable() { // from class: com.taobao.update.framework.UpdateRuntime.2
            @Override // java.lang.Runnable
            public void run() {
                UIToast uIToast = (UIToast) wb.getInstance(UIToast.class);
                if (uIToast != null) {
                    uIToast.toast(str);
                }
            }
        });
    }

    public static void log(String str, Throwable th) {
        com.taobao.update.adapter.Log log = (com.taobao.update.adapter.Log) wb.getInstance(com.taobao.update.adapter.Log.class);
        if (log != null) {
            log.error("update.sdk", str, th);
        } else {
            Log.e("update.sdk", str, th);
        }
    }

    public static void execute(final Runnable runnable, final int i) {
        ThreadExecutor threadExecutor = (ThreadExecutor) wb.getInstance(ThreadExecutor.class);
        if (threadExecutor != null) {
            threadExecutor.delayExecute(runnable, i);
        } else {
            new Thread(new Runnable() { // from class: com.taobao.update.framework.UpdateRuntime.4
                @Override // java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    try {
                        Thread.sleep(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runnable.run();
                }
            }).start();
        }
    }

    public static void init(Application application, C9444mm c9444mm) {
        a = application;
        sGroup = c9444mm.group;
        sTTid = c9444mm.ttid;
        if (!TextUtils.isEmpty(c9444mm.appName)) {
            sAppName = c9444mm.appName;
        } else {
            sAppName = application.getApplicationInfo().loadLabel(application.getPackageManager()).toString();
        }
        a.registerActivityLifecycleCallbacks(new j3());
        qr2.sClickbg2Exit = false;
        Class[] clsArr = new Class[1];
        Class<vr2> cls = c9444mm.uiToastClass;
        if (cls == null) {
            cls = vr2.class;
        }
        clsArr[0] = cls;
        wb.registerClass(clsArr);
        Class<ur2> cls2 = c9444mm.uiSysNotifyClass;
        if (cls2 == null) {
            cls2 = ur2.class;
        }
        wb.registerClass("sysnotify", cls2);
        Class<sr2> cls3 = c9444mm.uiNotifyClass;
        if (cls3 == null) {
            cls3 = sr2.class;
        }
        wb.registerClass(AgooConstants.MESSAGE_NOTIFICATION, cls3);
        Class[] clsArr2 = new Class[1];
        Class<qr2> cls4 = c9444mm.uiConfirmClass;
        if (cls4 == null) {
            cls4 = qr2.class;
        }
        clsArr2[0] = cls4;
        wb.registerClass(clsArr2);
        Object obj = c9444mm.logImpl;
        if (obj == null) {
            obj = new va1();
        }
        wb.registerInstance(obj);
        Object obj2 = c9444mm.threadExecutorImpl;
        if (obj2 == null) {
            obj2 = new nm2();
        }
        wb.registerInstance(obj2);
        popDialogBeforeInstall = c9444mm.popDialogBeforeInstall;
        forceInstallAfaterDownload = c9444mm.forceInstallAfaterDownload;
        installBundleAfterDownload = c9444mm.installBundleAfterDownload;
        bundleUpdateMinDisk = c9444mm.bundleUpdateMinDisk;
        sLogoResourceId = a.getApplicationInfo().icon;
    }
}
