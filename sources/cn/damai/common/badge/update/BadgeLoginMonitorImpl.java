package cn.damai.common.badge.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.damai.common.badge.update.BadgeLoginMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.rb1;
import tb.z9;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class BadgeLoginMonitorImpl implements BadgeLoginMonitor {
    private static transient /* synthetic */ IpChange $ipChange;
    private BadgeLoginMonitor.LoginCallback a;
    private LoginBroadcastReceiver b;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class LoginBroadcastReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;

        private LoginBroadcastReceiver(BadgeLoginMonitorImpl badgeLoginMonitorImpl) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "926974180")) {
                ipChange.ipc$dispatch("926974180", new Object[]{this, context, intent});
            }
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor
    public void setLoginCallback(BadgeLoginMonitor.LoginCallback loginCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664255758")) {
            ipChange.ipc$dispatch("664255758", new Object[]{this, loginCallback});
        } else {
            this.a = loginCallback;
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor
    public void startLoginMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401736769")) {
            ipChange.ipc$dispatch("-401736769", new Object[]{this});
        } else if (this.b == null) {
            try {
                this.b = new LoginBroadcastReceiver();
                z9.a().registerReceiver(this.b, new IntentFilter());
            } catch (Throwable th) {
                this.b = null;
                rb1.b("BadgeLoginMonitorImpl", th);
            }
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor
    public void stopLoginMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290366523")) {
            ipChange.ipc$dispatch("-290366523", new Object[]{this});
        } else if (this.b != null) {
            try {
                z9.a().unregisterReceiver(this.b);
            } catch (Throwable th) {
                rb1.b("BadgeLoginMonitorImpl", th);
            }
        }
    }
}
