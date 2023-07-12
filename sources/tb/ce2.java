package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.solid.bean.SoGroupEnum;
import cn.damai.solid.bean.VRAlarmBean;
import cn.damai.solid.listener.SoInstallListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ce2 implements DMNav.NavPreprocessor {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements SoInstallListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ Intent b;

        a(ce2 ce2Var, Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public Map<String, String> alarmExtraMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-845228882")) {
                return (Map) ipChange.ipc$dispatch("-845228882", new Object[]{this});
            }
            HashMap hashMap = new HashMap();
            hashMap.put("msg2Dev", "选座VR跳转失败了");
            try {
                VRAlarmBean vRAlarmBean = (VRAlarmBean) this.b.getParcelableExtra(VRAlarmBean.VR_ALARM_KEY);
                if (vRAlarmBean != null) {
                    hashMap.putAll(vRAlarmBean.toMap());
                }
            } catch (Exception e) {
                e.printStackTrace();
                hashMap.put("alarmExp", e.getMessage());
            }
            return hashMap;
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public void onInstallFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "70136016")) {
                ipChange.ipc$dispatch("70136016", new Object[]{this, str, str2});
            } else {
                ToastUtil.a().j(mu0.a(), str2);
            }
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public void onInstallSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-138860467")) {
                ipChange.ipc$dispatch("-138860467", new Object[]{this});
                return;
            }
            if (!(this.a instanceof Activity)) {
                this.b.addFlags(268435456);
            }
            this.a.startActivity(this.b);
        }
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public void addStackUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189018359")) {
            ipChange.ipc$dispatch("-189018359", new Object[]{this, uri});
        }
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public boolean beforeNavTo(Intent intent, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885489493")) {
            return ((Boolean) ipChange.ipc$dispatch("-885489493", new Object[]{this, intent, context})).booleanValue();
        }
        Uri data = intent.getData();
        if (data == null || !TextUtils.equals("vr_seat_activity", data.getHost())) {
            return false;
        }
        cn.damai.solid.a.d().b(context, SoGroupEnum.VR, new a(this, context, intent));
        cn.damai.solid.a.f("VrNavProcessor 启动了 VR DMNav 拦截");
        return true;
    }
}
