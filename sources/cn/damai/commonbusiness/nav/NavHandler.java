package cn.damai.commonbusiness.nav;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.h5container.UniH5ContainerSwitcher;
import com.alibaba.security.common.track.model.C3834a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.mu0;
import tb.wh2;
import tb.xl1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class NavHandler implements DMNav.NavExceptionHandler {
    private static transient /* synthetic */ IpChange $ipChange;

    public Uri getStackUriProxy(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109999505")) {
            return (Uri) ipChange.ipc$dispatch("109999505", new Object[]{this, intent});
        }
        if (intent == null || !"true".equals(intent.getStringExtra(xl1.KEY_DMNAV_PUSH_FLAT))) {
            return null;
        }
        return Uri.parse("damai://home");
    }

    @Override // cn.damai.common.nav.DMNav.NavExceptionHandler
    public boolean onException(Intent intent, Exception exc) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-646170940")) {
            return ((Boolean) ipChange.ipc$dispatch("-646170940", new Object[]{this, intent, exc})).booleanValue();
        }
        if (intent != null && mu0.a() != null) {
            String dataString = intent.getDataString();
            if (!wh2.j(dataString) && dataString.trim().startsWith("http")) {
                Bundle bundle = new Bundle();
                bundle.putAll(intent.getExtras());
                bundle.putString("url", dataString.trim());
                if (UniH5ContainerSwitcher.getInstance().shouldInterceptUrl(dataString)) {
                    DMNav.from(mu0.a()).stack(getStackUriProxy(intent)).withExtras(bundle).toUri(NavUri.b(cs.u));
                } else {
                    DMNav.from(mu0.a()).stack(getStackUriProxy(intent)).withExtras(bundle).toUri(NavUri.b(C3834a.C3837c.d));
                }
            }
        }
        return false;
    }
}
