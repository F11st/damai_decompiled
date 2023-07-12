package tb;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.common.image.C0504a;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: tb.os */
/* loaded from: classes5.dex */
public class C9532os {
    private static transient /* synthetic */ IpChange $ipChange;
    public View a;
    private RoundImageView b;
    private TextView c;
    private TextView d;

    public C9532os(View view) {
        this.a = view;
        this.b = (RoundImageView) view.findViewById(R$id.id_store_or_script_img);
        this.c = (TextView) this.a.findViewById(R$id.id_store_or_script_title);
        this.d = (TextView) this.a.findViewById(R$id.id_store_or_script_desc);
    }

    public void a(String str, String str2, String str3, boolean z, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990110208")) {
            ipChange.ipc$dispatch("-990110208", new Object[]{this, str, str2, str3, Boolean.valueOf(z), str4});
            return;
        }
        this.a.setVisibility(0);
        if (z) {
            dl.I().g(this.a, null, str4, 1);
        } else {
            dl.I().g(this.a, str4, null, 1);
        }
        int a = l62.a(mu0.a(), 41.0f);
        this.b.getLayoutParams().width = a;
        int a2 = l62.a(mu0.a(), z ? 41.0f : 55.0f);
        this.b.getLayoutParams().height = a2;
        this.b.setBorder(0.5f, Color.parseColor("#1A000000"));
        C0504a.b().f(str, a, a2).i(z ? R$drawable.store_defult_img : R$drawable.uikit_default_image_bg_grey).g(this.b);
        this.c.setText(str2);
        this.d.setText(str3);
        this.d.setVisibility(TextUtils.isEmpty(str3) ? 8 : 0);
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439974949")) {
            ipChange.ipc$dispatch("-439974949", new Object[]{this});
        } else {
            this.a.setVisibility(8);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786047881")) {
            ipChange.ipc$dispatch("-1786047881", new Object[]{this, onClickListener});
        } else {
            this.a.setOnClickListener(onClickListener);
        }
    }
}
