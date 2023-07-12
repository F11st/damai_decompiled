package cn.damai.discover.content.ui.viewholder.item;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.ref.WeakReference;
import tb.cb1;
import tb.xj1;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ContentVideoHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private ContentVideoView a;
    private Context b;
    private WifiStateChangeReceiver c;
    private boolean d = true;
    private boolean e = false;
    private View.OnAttachStateChangeListener f = new View$OnAttachStateChangeListenerC1012a();

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class WifiStateChangeReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;
        WeakReference<ContentVideoView> a;

        WifiStateChangeReceiver(ContentVideoView contentVideoView) {
            if (contentVideoView != null) {
                this.a = new WeakReference<>(contentVideoView);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "948848315")) {
                ipChange.ipc$dispatch("948848315", new Object[]{this, context, intent});
                return;
            }
            cb1.b("ContentVideoHelper", "onReceive/in act:" + intent.getAction());
            if (xj1.c(context)) {
                return;
            }
            cb1.b("ContentVideoHelper", "onReceive/in pause");
            try {
                this.a.get().pausePlayer(false);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.discover.content.ui.viewholder.item.ContentVideoHelper$a */
    /* loaded from: classes14.dex */
    public class View$OnAttachStateChangeListenerC1012a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnAttachStateChangeListenerC1012a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "364508083")) {
                ipChange.ipc$dispatch("364508083", new Object[]{this, view});
                return;
            }
            cb1.b("ContentVideoHelper", "Video.onViewAttachedToWindow auto:" + ContentVideoHelper.this.d + " v:" + view);
            ContentVideoHelper.this.e = true;
            if (ContentVideoHelper.this.d && xj1.c(ContentVideoHelper.this.b)) {
                ContentVideoHelper.this.a.getPlayer().mute(1);
                ContentVideoHelper.this.a.autoPlayMuted();
                ContentVideoHelper contentVideoHelper = ContentVideoHelper.this;
                contentVideoHelper.l(contentVideoHelper.b);
                ContentVideoHelper.this.d = false;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1771546768")) {
                ipChange.ipc$dispatch("-1771546768", new Object[]{this, view});
                return;
            }
            cb1.b("ContentVideoHelper", "Video.onViewDetachedFromWindow mvi:" + ContentVideoHelper.this.a);
            ContentVideoHelper.this.e = false;
            if (ContentVideoHelper.this.a != null) {
                ContentVideoHelper.this.a.pausePlayer(false);
            }
        }
    }

    public ContentVideoHelper(ContentVideoView contentVideoView) {
        if (contentVideoView != null) {
            this.a = contentVideoView;
            this.b = contentVideoView.getContext();
            this.a.addOnAttachStateChangeListener(this.f);
            return;
        }
        throw new RuntimeException("video view cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501608805")) {
            ipChange.ipc$dispatch("-1501608805", new Object[]{this, context});
        } else if (context == null || this.c != null) {
        } else {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            WifiStateChangeReceiver wifiStateChangeReceiver = new WifiStateChangeReceiver(this.a);
            this.c = wifiStateChangeReceiver;
            context.registerReceiver(wifiStateChangeReceiver, intentFilter);
        }
    }

    private void o(Context context) {
        WifiStateChangeReceiver wifiStateChangeReceiver;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825728098")) {
            ipChange.ipc$dispatch("1825728098", new Object[]{this, context});
        } else if (context == null || (wifiStateChangeReceiver = this.c) == null) {
        } else {
            context.unregisterReceiver(wifiStateChangeReceiver);
            this.c = null;
        }
    }

    public ContentVideoView g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-895696499") ? (ContentVideoView) ipChange.ipc$dispatch("-895696499", new Object[]{this}) : this.a;
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117858695")) {
            ipChange.ipc$dispatch("-117858695", new Object[]{this});
            return;
        }
        cb1.b("ContentVideoHelper", "Helper.onActivityDestroy:" + ys.d().b());
        ContentVideoView contentVideoView = this.a;
        if (contentVideoView != null) {
            contentVideoView.releasePlayer();
            this.a = null;
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "418365053")) {
            ipChange.ipc$dispatch("418365053", new Object[]{this});
            return;
        }
        cb1.b("ContentVideoHelper", "Helper.onActivityPause:" + ys.d().b());
        o(this.b);
        ContentVideoView contentVideoView = this.a;
        if (contentVideoView != null) {
            contentVideoView.pausePlayer(false);
        }
    }

    public void j(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136290070")) {
            ipChange.ipc$dispatch("-2136290070", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        cb1.b("ContentVideoHelper", "Helper.onActivityResume：" + ys.d().b());
        l(this.b);
        if (z && xj1.c(this.b) && this.e) {
            this.a.startPlayer();
        }
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469568978")) {
            ipChange.ipc$dispatch("-1469568978", new Object[]{this});
            return;
        }
        ContentVideoView contentVideoView = this.a;
        if (contentVideoView != null) {
            contentVideoView.pausePlayer(false);
        }
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239766781")) {
            ipChange.ipc$dispatch("-1239766781", new Object[]{this});
            return;
        }
        cb1.b("ContentVideoHelper", "resumePlayerOnWifi/in");
        if (this.a == null || !xj1.c(this.b)) {
            return;
        }
        this.a.startPlayer();
    }

    public void n(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098297624")) {
            ipChange.ipc$dispatch("2098297624", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.d = z;
        }
    }
}
