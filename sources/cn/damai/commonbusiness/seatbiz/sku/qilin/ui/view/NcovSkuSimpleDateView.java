package cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.DateBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.DayEntity;
import cn.damai.uikit.view.DefHorScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.m62;
import tb.m91;
import tb.pf;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NcovSkuSimpleDateView {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private DefHorScrollView c;
    private LinearLayout d;
    private View e;
    private Context f;
    private List<DayEntity> g;
    private View h;
    private int i = 0;
    private int j = 0;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface ViewSelectListener {
        void viewSelect(View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements DefHorScrollView.OnScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.view.DefHorScrollView.OnScrollListener
        public void onScroll(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-960498752")) {
                ipChange.ipc$dispatch("-960498752", new Object[]{this, Integer.valueOf(i)});
            } else {
                NcovSkuSimpleDateView.this.j = i;
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
            if (AndroidInstantRuntime.support(ipChange, "-731906015")) {
                ipChange.ipc$dispatch("-731906015", new Object[]{this, view});
            } else {
                NcovSkuSimpleDateView.this.k();
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
            if (AndroidInstantRuntime.support(ipChange, "1379384354")) {
                ipChange.ipc$dispatch("1379384354", new Object[]{this, view});
                return;
            }
            DayEntity dayEntity = (DayEntity) view.getTag();
            if (dayEntity != null && dayEntity.hasPerform && dayEntity.hasPermission) {
                NcovSkuSimpleDateView.this.i = dayEntity.position;
                NcovSkuSimpleDateView.this.j(view, dayEntity);
            }
        }
    }

    public NcovSkuSimpleDateView(View view) {
        this.a = view;
        this.f = view.getContext();
        h();
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1008128629")) {
            ipChange.ipc$dispatch("1008128629", new Object[]{this});
            return;
        }
        this.d.removeAllViews();
        for (int i = 0; i < this.g.size(); i++) {
            DayEntity dayEntity = this.g.get(i);
            if (dayEntity != null) {
                dayEntity.position = i;
                View inflate = LayoutInflater.from(this.f).inflate(R$layout.fragment_sku_ncov_simple_date_item, (ViewGroup) null);
                View findViewById = inflate.findViewById(R$id.left_view);
                View findViewById2 = inflate.findViewById(R$id.right_view);
                View findViewById3 = inflate.findViewById(R$id.view_bg);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_week);
                TextView textView2 = (TextView) inflate.findViewById(R$id.tv_tag);
                TextView textView3 = (TextView) inflate.findViewById(R$id.tv_positive_tag);
                TextView textView4 = (TextView) inflate.findViewById(R$id.tv_date);
                if (i == 0) {
                    findViewById.getLayoutParams().width = m62.a(this.f, 21.0f);
                    findViewById2.getLayoutParams().width = m62.a(this.f, 4.5f);
                } else if (i == this.g.size() - 1) {
                    findViewById.getLayoutParams().width = m62.a(this.f, 4.5f);
                    findViewById2.getLayoutParams().width = m62.a(this.f, 21.0f);
                } else {
                    findViewById.getLayoutParams().width = m62.a(this.f, 4.5f);
                    findViewById2.getLayoutParams().width = m62.a(this.f, 4.5f);
                }
                if (dayEntity.isSelected) {
                    this.h = inflate;
                    if (dayEntity.isSeePage) {
                        findViewById3.setBackgroundResource(R$drawable.ncov_sku_calendar_day_select_bg_red);
                    } else {
                        findViewById3.setBackgroundResource(R$drawable.ncov_sku_calendar_day_select_bg);
                    }
                } else {
                    findViewById3.setBackgroundResource(R$drawable.ncov_sku_perform_bg);
                }
                textView.setVisibility(0);
                textView.setText("周" + dayEntity.week);
                textView4.setText(dayEntity.monthAndDay);
                textView3.setVisibility(8);
                textView2.setVisibility(8);
                if (dayEntity.validTag()) {
                    if (!dayEntity.isPositive()) {
                        textView3.setVisibility(8);
                        textView2.setVisibility(0);
                        textView2.setTextColor(this.f.getResources().getColor(R$color.color_6A7A99));
                        textView2.setText(dayEntity.getValidTag());
                    } else {
                        textView3.setVisibility(0);
                        textView2.setVisibility(8);
                        textView3.setText(dayEntity.getValidTag());
                    }
                    if (!dayEntity.isPositive()) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                } else {
                    textView3.setVisibility(8);
                }
                if (dayEntity.hasPerform && dayEntity.hasPermission) {
                    Resources resources = this.f.getResources();
                    int i2 = R$color.color_000000;
                    textView.setTextColor(resources.getColor(i2));
                    textView4.setTextColor(this.f.getResources().getColor(i2));
                } else {
                    Resources resources2 = this.f.getResources();
                    int i3 = R$color.color_cccccc;
                    textView.setTextColor(resources2.getColor(i3));
                    textView4.setTextColor(this.f.getResources().getColor(i3));
                }
                inflate.setTag(dayEntity);
                inflate.setOnClickListener(new c());
                this.d.addView(inflate);
            }
        }
        this.c.scrollTo(g(f(this.i)), 0);
        if (this.h != null) {
            i();
        }
    }

    private int f(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-332069948") ? ((Integer) ipChange.ipc$dispatch("-332069948", new Object[]{this, Integer.valueOf(i)})).intValue() : 3 - i;
    }

    private int g(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1626980919") ? ((Integer) ipChange.ipc$dispatch("-1626980919", new Object[]{this, Integer.valueOf(i)})).intValue() : m62.a(this.f, i * 68) + this.j;
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1892629805")) {
            ipChange.ipc$dispatch("1892629805", new Object[]{this});
            return;
        }
        this.b = this.a.findViewById(R$id.layout_simple_day);
        DefHorScrollView defHorScrollView = (DefHorScrollView) this.a.findViewById(R$id.scroll_simple_date);
        this.c = defHorScrollView;
        defHorScrollView.setOnScrollListener(new a());
        this.d = (LinearLayout) this.a.findViewById(R$id.lin_simple_date);
        View findViewById = this.a.findViewById(R$id.btn_open_date);
        this.e = findViewById;
        findViewById.setOnClickListener(new b());
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1256704353")) {
            ipChange.ipc$dispatch("1256704353", new Object[]{this});
        } else if (this.h == null) {
        } else {
            this.a.postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.NcovSkuSimpleDateView.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                @RequiresApi(api = 3)
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1235105517")) {
                        ipChange2.ipc$dispatch("1235105517", new Object[]{this});
                    } else {
                        NcovSkuSimpleDateView.this.c.smoothScrollTo(m62.a(NcovSkuSimpleDateView.this.f, 80.0f), 0);
                    }
                }
            }, 100L);
        }
    }

    public void j(View view, DayEntity dayEntity) {
        throw null;
    }

    public void k() {
        throw null;
    }

    public void l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361610481")) {
            ipChange.ipc$dispatch("-361610481", new Object[]{this, Integer.valueOf(i)});
        } else if (this.b.getVisibility() != i) {
            this.b.setVisibility(i);
        }
    }

    public void m(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127792849")) {
            ipChange.ipc$dispatch("-127792849", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.setVisibility(i);
        }
    }

    public void n(List<DateBean> list, boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1108281258")) {
            ipChange.ipc$dispatch("1108281258", new Object[]{this, list, Boolean.valueOf(z), str, Integer.valueOf(i)});
            return;
        }
        List<DayEntity> g = pf.g(list, z, str, i == 2);
        this.g = g;
        if (m91.a(g)) {
            return;
        }
        this.h = null;
        e();
    }
}
