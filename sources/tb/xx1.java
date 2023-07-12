package tb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.user.userhome.bean.MinepublishCheckBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class xx1 implements OnItemBindListener<MinepublishCheckBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private int b;

    public xx1(Activity activity, int i) {
        this.a = activity;
        this.b = i;
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
    /* renamed from: a */
    public void exposeItem(View view, MinepublishCheckBean minepublishCheckBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361579647")) {
            ipChange.ipc$dispatch("1361579647", new Object[]{this, view, minepublishCheckBean, Integer.valueOf(i)});
        }
    }

    public void b(MinepublishCheckBean minepublishCheckBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722646796")) {
            ipChange.ipc$dispatch("-722646796", new Object[]{this, minepublishCheckBean, Integer.valueOf(i)});
            return;
        }
        Activity activity = this.a;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (!LoginManager.k().q()) {
            LoginManager.k().x(this.a, new Intent(), this.b);
        } else if (minepublishCheckBean != null) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(minepublishCheckBean.appPublishHint)) {
                bundle.putString("appPublishHint", minepublishCheckBean.appPublishHint);
            }
            bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_PRIVILEGE);
            bundle.putString(g41.ISSUE_PARAM_COMMENT_TYPE, "62");
            bundle.putString("targetType", "0");
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b("issue"));
        }
    }
}
