package tb;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class mg {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private View c;
    private TextView d;
    private TextView e;

    public mg(View view) {
        View findViewById = view.findViewById(R$id.card_title_layout);
        this.a = findViewById;
        this.b = (TextView) findViewById.findViewById(R$id.card_title);
        this.c = this.a.findViewById(R$id.card_show_all_ui);
        this.d = (TextView) this.a.findViewById(R$id.card_show_all_subtitle);
        TextView textView = (TextView) this.a.findViewById(R$id.card_show_all_arrow);
        this.e = (TextView) this.a.findViewById(R$id.card_title_latestnews);
    }

    public void a(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656159354")) {
            ipChange.ipc$dispatch("656159354", new Object[]{this, onClickListener});
        } else {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public void b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-158029434")) {
            ipChange.ipc$dispatch("-158029434", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.e.setVisibility(0);
            this.e.setText(str);
        }
    }

    public void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "807797944")) {
            ipChange.ipc$dispatch("807797944", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b.setTextSize(1, i);
        }
    }

    public void d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-814313552")) {
            ipChange.ipc$dispatch("-814313552", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.c.setVisibility(z ? 0 : 8);
        }
    }

    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301010729")) {
            ipChange.ipc$dispatch("-1301010729", new Object[]{this, str});
        } else {
            this.d.setText(str);
        }
    }

    public void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "273368087")) {
            ipChange.ipc$dispatch("273368087", new Object[]{this, str});
        } else {
            this.b.setText(str);
        }
    }

    public void g(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1448508111")) {
            ipChange.ipc$dispatch("-1448508111", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.a.setVisibility(z ? 0 : 8);
        }
    }

    public void h(CardTitleBean cardTitleBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823842303")) {
            ipChange.ipc$dispatch("823842303", new Object[]{this, cardTitleBean});
        } else if (cardTitleBean != null && cardTitleBean.showTitleLayout) {
            g(true);
            f(cardTitleBean.title);
            e("全部");
            d(cardTitleBean.showAll);
        } else {
            g(false);
        }
    }
}
