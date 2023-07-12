package tb;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ag1 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private View b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;

    public ag1(Activity activity, View view) {
        this.a = activity;
        View findViewById = view.findViewById(R$id.fl_vip_container);
        this.b = findViewById;
        this.c = (TextView) findViewById.findViewById(R$id.vip_text_count);
        this.d = (ImageView) this.b.findViewById(R$id.iv_vip_subtitle);
        this.e = (ImageView) this.b.findViewById(R$id.iv_vip_title);
        this.f = (ImageView) this.b.findViewById(R$id.iv_vip_title_bg);
        this.b.setOnClickListener(this);
        this.b.setTag(null);
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141962136")) {
            ipChange.ipc$dispatch("141962136", new Object[]{this});
            return;
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    public void b(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5196662")) {
            ipChange.ipc$dispatch("5196662", new Object[]{this, str, str2, str3});
            return;
        }
        this.c.setVisibility(0);
        this.b.setTag(str3);
        if (!TextUtils.isEmpty(str)) {
            TextView textView = this.c;
            textView.setText(Html.fromHtml("<font color= '#FF1268'>" + str + "  </font>" + str2));
        } else if (!TextUtils.isEmpty(str2)) {
            this.c.setText(str2);
        } else {
            this.c.setVisibility(8);
        }
        if ("1".equals(str3)) {
            this.d.setVisibility(0);
            this.d.setImageDrawable(this.a.getResources().getDrawable(R$drawable.mine_member_bg_yellow_subtitle));
            this.e.setImageDrawable(this.a.getResources().getDrawable(R$drawable.mine_member_bg_yellow_title));
            this.f.setImageDrawable(this.a.getResources().getDrawable(R$drawable.mine_member_bg_yellow));
        } else if ("10".equals(str3)) {
            this.d.setVisibility(0);
            this.d.setImageDrawable(this.a.getResources().getDrawable(R$drawable.mine_member_bg_black_subtitle));
            this.e.setImageDrawable(this.a.getResources().getDrawable(R$drawable.mine_member_bg_black_title));
            this.f.setImageDrawable(this.a.getResources().getDrawable(R$drawable.mine_member_bg_black));
        } else {
            this.d.setVisibility(8);
        }
        vf1.x().p0(this.b, str3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1553290298")) {
            ipChange.ipc$dispatch("-1553290298", new Object[]{this, view});
        } else if (view.getId() == R$id.fl_vip_container) {
            cn.damai.common.user.c.e().x(vf1.x().j0(view.getTag() != null ? (String) view.getTag() : "0"));
            if (LoginManager.k().q()) {
                DMNav.from(this.a).toUri(k23.j());
            } else {
                DMNav.from(this.a).withExtras(new Bundle()).toUri(cs.f());
            }
        }
    }
}
