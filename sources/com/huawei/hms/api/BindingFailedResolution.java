package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BindingFailedResolution implements ServiceConnection, IBridgeActivityDelegate {
    private static final Object g = new Object();
    private Activity a;
    private d c;
    private FailedBinderCallBack.BinderCallBack d;
    private boolean b = true;
    private Handler e = null;
    private Handler f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            BindingFailedResolution.this.a(8);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.e("BindingFailedResolution", "In connect, bind core try timeout");
            BindingFailedResolution.this.b(false);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class c implements AbstractDialog.Callback {
        c() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            BindingFailedResolution.this.c = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.a(8);
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            BindingFailedResolution.this.c = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.a(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d extends AbstractPromptDialog {
        private d() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetMessageString(Context context) {
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message", Util.getAppName(context, null), Util.getAppName(context, HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService()));
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.b) {
            this.b = false;
            onStartResult(z);
        }
    }

    private void c() {
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(3);
        } else {
            this.f = new Handler(Looper.getMainLooper(), new a());
        }
        this.f.sendEmptyMessageDelayed(3, DanmakuFactory.MIN_DANMAKU_DURATION);
    }

    private void d() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        d dVar = this.c;
        if (dVar == null) {
            this.c = new d(null);
        } else {
            dVar.dismiss();
        }
        HMSLog.i("BindingFailedResolution", "showPromptdlg to resolve conn error");
        this.c.show(activity, new c());
    }

    protected Activity getActivity() {
        return this.a;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2003;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null && intent.hasExtra(FailedBinderCallBack.CALLER_ID)) {
            this.d = FailedBinderCallBack.getInstance().getCallBack(Long.valueOf(intent.getLongExtra(FailedBinderCallBack.CALLER_ID, 0L)));
        }
        this.a = activity;
        com.huawei.hms.api.a.b.a(activity);
        c();
        a(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        a();
        com.huawei.hms.api.a.b.b(this.a);
        this.a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        HMSLog.i("BindingFailedResolution", "onBridgeActivityResult");
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(3);
            this.f = null;
        }
        a(true);
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.c == null) {
            return;
        }
        HMSLog.i("BindingFailedResolution", "re show prompt dialog");
        d();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.i("BindingFailedResolution", "On key up when resolve conn error");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a();
        b(true);
        if (getActivity() == null) {
            return;
        }
        HMSLog.i("BindingFailedResolution", "test connect success, try to reConnect and reply message");
        BindResolveClients.getInstance().notifyClientReconnect();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    protected void onStartResult(boolean z) {
        if (getActivity() == null) {
            return;
        }
        if (z) {
            a(0);
        } else {
            d();
        }
    }

    private void a(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
        intent.setClassName(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService(), HuaweiApiAvailability.ACTIVITY_NAME);
        HMSLog.i("BindingFailedResolution", "onBridgeActivityCreate：try to start HMS");
        try {
            activity.startActivityForResult(intent, getRequestCode());
        } catch (Throwable th) {
            HMSLog.e("BindingFailedResolution", "ActivityNotFoundException：" + th.getMessage());
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(3);
                this.f = null;
            }
            a(false);
        }
    }

    private void b() {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.e = new Handler(Looper.getMainLooper(), new b());
        }
        this.e.sendEmptyMessageDelayed(2, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    private void a(boolean z, int i) {
        FailedBinderCallBack.BinderCallBack binderCallBack;
        if (!z || (binderCallBack = this.d) == null) {
            return;
        }
        binderCallBack.binderCallBack(i);
    }

    private void a(boolean z) {
        Activity activity = getActivity();
        if (activity == null) {
            HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
            b(false);
            a(z, 8);
            return;
        }
        Intent intent = new Intent(HMSPackageManager.getInstance(activity.getApplicationContext()).getServiceAction());
        intent.setPackage(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService());
        synchronized (g) {
            if (activity.bindService(intent, this, 1)) {
                b();
                return;
            }
            HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
            b(false);
            a(z, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        HMSLog.i("BindingFailedResolution", "finishBridgeActivity：" + i);
        Intent intent = new Intent();
        intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
        activity.setResult(-1, intent);
        Util.unBindServiceCatchException(activity, this);
        activity.finish();
    }

    private void a() {
        synchronized (g) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(2);
                this.e = null;
            }
        }
    }
}
