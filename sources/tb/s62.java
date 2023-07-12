package tb;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class s62 extends cp2<ScriptBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private LinearLayout d;
    @Nullable
    private ScriptBean e;
    @Nullable
    private RoundImageView f;
    @Nullable
    private TextView g;
    @Nullable
    private TextView h;

    public s62(@Nullable Context context) {
        super(context);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "288591581") ? ((Integer) ipChange.ipc$dispatch("288591581", new Object[]{this})).intValue() : R$layout.live_content_detail_script;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818263254")) {
            ipChange.ipc$dispatch("-818263254", new Object[]{this});
            return;
        }
        this.d = (LinearLayout) this.b.findViewById(R$id.live_content_dm_layout);
        this.f = (RoundImageView) this.b.findViewById(R$id.script_pic);
        this.g = (TextView) this.b.findViewById(R$id.script_title);
        this.h = (TextView) this.b.findViewById(R$id.tv_script_des);
    }

    public void d(@Nullable ScriptBean scriptBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1442724993")) {
            ipChange.ipc$dispatch("1442724993", new Object[]{this, scriptBean});
        } else if (scriptBean == null) {
            c(false);
        } else {
            LinearLayout linearLayout = this.d;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(this);
            }
            getLiveUt().m(this.d, scriptBean.getId());
            this.e = scriptBean;
            DMImageCreator f = cn.damai.common.image.a.b().f(scriptBean.getPosterUrl(), m62.a(mu0.a(), 48.0f), m62.a(mu0.a(), 64.0f));
            int i = R$drawable.store_defult_img;
            f.i(i).c(i).g(this.f);
            String des = scriptBean.getDes();
            TextView textView = this.g;
            if (textView != null) {
                textView.setText(scriptBean.getName());
            }
            if (!(des.length() == 0)) {
                TextView textView2 = this.h;
                if (textView2 != null) {
                    textView2.setText(scriptBean.getDes());
                }
            } else {
                TextView textView3 = this.h;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            }
            c(true);
        }
    }

    @Override // tb.cp2, android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "910869174")) {
            ipChange.ipc$dispatch("910869174", new Object[]{this, view});
            return;
        }
        b41.i(view, "v");
        super.onClick(view);
        ScriptBean scriptBean = this.e;
        if (scriptBean != null) {
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            q91 liveUt = getLiveUt();
            ScriptBean scriptBean2 = this.e;
            e.x(liveUt.E(scriptBean2 != null ? scriptBean2.getId() : null));
            DMNav.from(this.a).toUri(scriptBean.getActionUrl());
        }
    }
}
