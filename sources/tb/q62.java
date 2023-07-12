package tb;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.Option;
import cn.damai.uikit.view.SwitchButton;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class q62 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private View c;
    private TextView d;
    private TextView e;
    private SwitchButton f;
    private DMIconFontTextView g;
    private DMIconFontTextView h;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2130520458")) {
                ipChange.ipc$dispatch("-2130520458", new Object[]{this, view});
            } else {
                q62.this.a(1);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-19230089")) {
                ipChange.ipc$dispatch("-19230089", new Object[]{this, view});
            } else {
                q62.this.a(2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2092060280")) {
                ipChange.ipc$dispatch("2092060280", new Object[]{this, view});
            } else {
                q62.this.b((Option) view.getTag());
            }
        }
    }

    public q62(View view) {
        this.a = view.getContext();
        this.b = view;
        View findViewById = view.findViewById(R$id.layout_tab1);
        int i = R$id.layout_tab2;
        View findViewById2 = view.findViewById(i);
        findViewById.setOnClickListener(new a());
        findViewById2.setOnClickListener(new b());
        this.f = (SwitchButton) view.findViewById(R$id.switch_btn);
        ArrayList arrayList = new ArrayList();
        Option option = new Option();
        option.id = 3;
        option.index = 0;
        option.title = "推荐";
        Option option2 = new Option();
        option2.id = 4;
        option2.index = 1;
        option2.title = "距离";
        Option option3 = new Option();
        option3.id = 1;
        option3.index = 2;
        option3.title = "上新";
        arrayList.add(option);
        arrayList.add(option2);
        arrayList.add(option3);
        this.f.setOption(arrayList);
        this.f.setVisibility(0);
        this.f.setBtnClickListener(new c());
        this.d = (TextView) view.findViewById(R$id.tv_tab1);
        this.e = (TextView) view.findViewById(R$id.tv_tab2);
        this.g = (DMIconFontTextView) view.findViewById(R$id.icon_tab1);
        this.h = (DMIconFontTextView) view.findViewById(R$id.icon_tab2);
        this.c = view.findViewById(i);
    }

    public void a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1061261369")) {
            ipChange.ipc$dispatch("-1061261369", new Object[]{this, Integer.valueOf(i)});
        } else {
            g();
        }
    }

    public void b(Option option) {
        throw null;
    }

    public void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889393050")) {
            ipChange.ipc$dispatch("-1889393050", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.f.setDefaultSelect(i);
        }
    }

    public void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017241917")) {
            ipChange.ipc$dispatch("-2017241917", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.f.setVisibility(i);
        }
    }

    public void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1842462824")) {
            ipChange.ipc$dispatch("-1842462824", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.c.setVisibility(i);
        }
    }

    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1207842299")) {
            ipChange.ipc$dispatch("-1207842299", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b.setVisibility(i);
        }
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611647180")) {
            ipChange.ipc$dispatch("-611647180", new Object[]{this});
            return;
        }
        if (this.d.getText().toString().equals(z20.d())) {
            TextView textView = this.d;
            Resources resources = this.a.getResources();
            int i = R$color.color_999999;
            textView.setTextColor(resources.getColor(i));
            this.g.setTextColor(this.a.getResources().getColor(i));
        } else {
            TextView textView2 = this.d;
            Resources resources2 = this.a.getResources();
            int i2 = R$color.color_000000;
            textView2.setTextColor(resources2.getColor(i2));
            this.g.setTextColor(this.a.getResources().getColor(i2));
        }
        if (this.e.getText() != null && "全部时间".equals(this.e.getText().toString())) {
            TextView textView3 = this.e;
            Resources resources3 = this.a.getResources();
            int i3 = R$color.color_999999;
            textView3.setTextColor(resources3.getColor(i3));
            this.h.setTextColor(this.a.getResources().getColor(i3));
            return;
        }
        TextView textView4 = this.e;
        Resources resources4 = this.a.getResources();
        int i4 = R$color.color_000000;
        textView4.setTextColor(resources4.getColor(i4));
        this.h.setTextColor(this.a.getResources().getColor(i4));
    }
}
