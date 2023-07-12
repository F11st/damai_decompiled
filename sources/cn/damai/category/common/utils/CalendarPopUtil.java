package cn.damai.category.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.calendar.bean.Day;
import cn.damai.category.calendar.ui.adapter.CalendarListAdapter;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.qw0;
import tb.rf;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CalendarPopUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean A;
    private int B;
    private View.OnClickListener C;
    private Context a;
    private View b;
    private ViewGroup c;
    private ViewGroup d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private IRecyclerView i;
    private ViewGroup j;
    private ViewGroup k;
    private TextView l;
    private TextView m;
    private CalendarListAdapter n;
    private View.OnClickListener o;
    private int p;
    private qw0 q;
    private CalendarBean r;
    private List<Day> s;
    private boolean u;
    private DMIconFontTextView w;
    private TextView x;
    private String y;
    private boolean z;
    private int t = 0;
    public int v = 0;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.common.utils.CalendarPopUtil$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0375a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0375a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-746473156")) {
                ipChange.ipc$dispatch("-746473156", new Object[]{this, view});
                return;
            }
            CalendarPopUtil.this.i();
            if (CalendarPopUtil.this.C != null) {
                CalendarPopUtil.this.C.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.common.utils.CalendarPopUtil$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0376b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0376b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-818859714")) {
                ipChange.ipc$dispatch("-818859714", new Object[]{this, view});
                return;
            }
            if (view.getTag() != null) {
                Day day = (Day) view.getTag();
                if (day == null || day.showType == 0) {
                    return;
                }
                CalendarPopUtil calendarPopUtil = CalendarPopUtil.this;
                calendarPopUtil.y = day.month + "月" + day.day + "日";
                CalendarPopUtil.this.k(-1, 0, "");
            }
            CalendarPopUtil.this.o.onClick(view);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.common.utils.CalendarPopUtil$c */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0377c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0377c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-891246272")) {
                ipChange.ipc$dispatch("-891246272", new Object[]{this, view});
            } else {
                CalendarPopUtil.this.k(0, 0, "全部时间");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.common.utils.CalendarPopUtil$d */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0378d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0378d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1220044097")) {
                ipChange.ipc$dispatch("1220044097", new Object[]{this, view});
            } else {
                CalendarPopUtil.this.k(6, 1, "一周内");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.common.utils.CalendarPopUtil$e */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0379e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0379e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-963632830")) {
                ipChange.ipc$dispatch("-963632830", new Object[]{this, view});
            } else {
                CalendarPopUtil.this.k(4, 2, "一月内");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.common.utils.CalendarPopUtil$f */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0380f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0380f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1147657539")) {
                ipChange.ipc$dispatch("1147657539", new Object[]{this, view});
            } else {
                CalendarPopUtil.this.k(8, 3, "周末场");
            }
        }
    }

    public CalendarPopUtil(Context context, View view, View view2, ViewGroup viewGroup, boolean z, boolean z2, boolean z3, int i, View.OnClickListener onClickListener) {
        this.x = (TextView) view;
        this.z = z;
        this.a = context;
        this.b = view2;
        this.c = viewGroup;
        this.u = z2;
        this.A = z3;
        this.B = i;
        this.o = onClickListener;
        j();
        if (z3) {
            Context context2 = this.a;
            this.p = ((int) (this.B * 0.6d)) + ScreenUtil.dip2px(context2, ScreenUtil.dip2px(context2, 87.0f));
        } else {
            Context context3 = this.a;
            this.p = ((int) (this.B * 0.6d)) + ScreenUtil.dip2px(context3, ScreenUtil.dip2px(context3, 37.0f));
        }
        this.q = qw0.b(this.a, this.c, this.p);
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1675012023")) {
            ipChange.ipc$dispatch("-1675012023", new Object[]{this});
            return;
        }
        this.j = (ViewGroup) this.c.findViewById(R$id.layout_guding);
        this.k = (ViewGroup) this.c.findViewById(R$id.layout_guding_tv);
        if (this.z) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.l = (TextView) this.c.findViewById(R$id.tv_calendar_month);
        this.m = (TextView) this.c.findViewById(R$id.tv_shenhua);
        IRecyclerView iRecyclerView = (IRecyclerView) this.c.findViewById(R$id.pop_irc);
        this.i = iRecyclerView;
        iRecyclerView.setLayoutManager(new WrapLinearLayoutManager(this.a));
        CalendarListAdapter calendarListAdapter = new CalendarListAdapter(this.a, new View$OnClickListenerC0376b());
        this.n = calendarListAdapter;
        this.i.setAdapter(calendarListAdapter);
        this.i.setRefreshEnabled(false);
        this.i.setLoadMoreEnabled(false);
        this.i.setIsAutoToDefault(false);
        this.i.getLoadMoreFooterView().setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        if (this.A) {
            layoutParams.height = ((int) (this.B * 0.6d)) - ScreenUtil.dip2px(this.a, 50.0f);
        } else {
            layoutParams.height = (int) (this.B * 0.6d);
        }
        this.i.setLayoutParams(layoutParams);
        this.i.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.category.common.utils.CalendarPopUtil.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "70717876")) {
                    ipChange2.ipc$dispatch("70717876", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                CalendarPopUtil.this.i.getChildAt(0);
                if (CalendarPopUtil.this.z) {
                    CalendarPopUtil.this.m();
                }
            }
        });
        ViewGroup viewGroup = (ViewGroup) this.c.findViewById(R$id.layout_date_select);
        this.d = viewGroup;
        if (this.u) {
            viewGroup.setVisibility(0);
            this.e = (TextView) this.d.findViewById(R$id.tv_time1);
            this.f = (TextView) this.d.findViewById(R$id.tv_time2);
            this.g = (TextView) this.d.findViewById(R$id.tv_time3);
            this.h = (TextView) this.d.findViewById(R$id.tv_time4);
            this.e.setOnClickListener(new View$OnClickListenerC0377c());
            this.f.setOnClickListener(new View$OnClickListenerC0378d());
            this.g.setOnClickListener(new View$OnClickListenerC0379e());
            this.h.setOnClickListener(new View$OnClickListenerC0380f());
            r();
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-79780066")) {
            ipChange.ipc$dispatch("-79780066", new Object[]{this});
        } else if (!(this.i.getChildAt(0) instanceof LinearLayout) || this.i.getChildAt(1) == null) {
        } else {
            ViewGroup viewGroup3 = null;
            if (this.i.getChildAt(1).getTop() > 0) {
                this.k.setVisibility(0);
                this.j.setBackgroundColor(this.a.getResources().getColor(R$color.color_f8f8f8));
                viewGroup3 = (ViewGroup) this.i.getChildAt(0);
            }
            if (viewGroup3 == null || (viewGroup = (ViewGroup) viewGroup3.getChildAt(0)) == null || (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) == null) {
                return;
            }
            p(viewGroup2);
        }
    }

    private void p(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "867730055")) {
            ipChange.ipc$dispatch("867730055", new Object[]{this, viewGroup});
        } else if (viewGroup != null) {
            TextView textView = (TextView) viewGroup.getChildAt(1);
            this.l.setText(((TextView) viewGroup.getChildAt(0)).getText());
            if (textView.getText() != null && !TextUtils.isEmpty(textView.getText().toString())) {
                this.m.setText(textView.getText());
                this.m.setVisibility(0);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    private void r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192403893")) {
            ipChange.ipc$dispatch("1192403893", new Object[]{this});
            return;
        }
        int i = this.v;
        if (i == 0) {
            this.e.setBackgroundResource(R$drawable.category_date_select_bg);
            TextView textView = this.f;
            int i2 = R$drawable.category_date_normal_bg;
            textView.setBackgroundResource(i2);
            this.g.setBackgroundResource(i2);
            this.h.setBackgroundResource(i2);
            this.e.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            TextView textView2 = this.f;
            Resources resources = this.a.getResources();
            int i3 = R$color.color_000000;
            textView2.setTextColor(resources.getColor(i3));
            this.g.setTextColor(this.a.getResources().getColor(i3));
            this.h.setTextColor(this.a.getResources().getColor(i3));
            this.y = "全部时间";
            this.t = -1;
        } else if (i == 4) {
            TextView textView3 = this.e;
            int i4 = R$drawable.category_date_normal_bg;
            textView3.setBackgroundResource(i4);
            this.f.setBackgroundResource(i4);
            this.g.setBackgroundResource(R$drawable.category_date_select_bg);
            this.h.setBackgroundResource(i4);
            TextView textView4 = this.e;
            Resources resources2 = this.a.getResources();
            int i5 = R$color.color_000000;
            textView4.setTextColor(resources2.getColor(i5));
            this.f.setTextColor(this.a.getResources().getColor(i5));
            this.g.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.h.setTextColor(this.a.getResources().getColor(i5));
            this.y = "一月内";
            this.t = -1;
        } else if (i == 6) {
            TextView textView5 = this.e;
            int i6 = R$drawable.category_date_normal_bg;
            textView5.setBackgroundResource(i6);
            this.f.setBackgroundResource(R$drawable.category_date_select_bg);
            this.g.setBackgroundResource(i6);
            this.h.setBackgroundResource(i6);
            TextView textView6 = this.e;
            Resources resources3 = this.a.getResources();
            int i7 = R$color.color_000000;
            textView6.setTextColor(resources3.getColor(i7));
            this.f.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.g.setTextColor(this.a.getResources().getColor(i7));
            this.h.setTextColor(this.a.getResources().getColor(i7));
            this.y = "一周内";
            this.t = -1;
        } else if (i != 8) {
            TextView textView7 = this.e;
            int i8 = R$drawable.category_date_normal_bg;
            textView7.setBackgroundResource(i8);
            this.f.setBackgroundResource(i8);
            this.g.setBackgroundResource(i8);
            this.h.setBackgroundResource(i8);
            TextView textView8 = this.e;
            Resources resources4 = this.a.getResources();
            int i9 = R$color.color_000000;
            textView8.setTextColor(resources4.getColor(i9));
            this.f.setTextColor(this.a.getResources().getColor(i9));
            this.g.setTextColor(this.a.getResources().getColor(i9));
            this.h.setTextColor(this.a.getResources().getColor(i9));
        } else {
            TextView textView9 = this.e;
            int i10 = R$drawable.category_date_normal_bg;
            textView9.setBackgroundResource(i10);
            this.f.setBackgroundResource(i10);
            this.g.setBackgroundResource(i10);
            this.h.setBackgroundResource(R$drawable.category_date_select_bg);
            TextView textView10 = this.e;
            Resources resources5 = this.a.getResources();
            int i11 = R$color.color_000000;
            textView10.setTextColor(resources5.getColor(i11));
            this.f.setTextColor(this.a.getResources().getColor(i11));
            this.g.setTextColor(this.a.getResources().getColor(i11));
            this.h.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.y = "周末场";
            this.t = -1;
        }
    }

    public boolean h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-160292290") ? ((Boolean) ipChange.ipc$dispatch("-160292290", new Object[]{this})).booleanValue() : this.c.getVisibility() == 0;
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673181565")) {
            ipChange.ipc$dispatch("1673181565", new Object[]{this});
        } else if (this.w != null) {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.w.setText(this.a.getText(R$string.iconfont_shaixuanxia12));
        }
    }

    public void k(int i, int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650688096")) {
            ipChange.ipc$dispatch("650688096", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        if (i != -1) {
            this.s = null;
            this.n.b(this.r, null);
            this.i.scrollToPosition(0);
        }
        this.v = i;
        if (this.u) {
            r();
            this.x.setText(this.y);
        }
        i();
    }

    public void l(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103249618")) {
            ipChange.ipc$dispatch("103249618", new Object[]{this, calendarBean});
            return;
        }
        this.r = calendarBean;
        this.n.a(calendarBean);
    }

    public void n(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881683914")) {
            ipChange.ipc$dispatch("-1881683914", new Object[]{this, onClickListener});
        } else {
            this.C = onClickListener;
        }
    }

    public void o(List<Day> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028960960")) {
            ipChange.ipc$dispatch("1028960960", new Object[]{this, list});
            return;
        }
        this.s = list;
        if (wh2.e(list) > 0) {
            Day day = list.get(0);
            if (day != null) {
                this.t = rf.g(day);
            }
        } else {
            this.t = -1;
        }
        this.n.b(this.r, this.s);
    }

    public void q(DMIconFontTextView dMIconFontTextView, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822212017")) {
            ipChange.ipc$dispatch("-822212017", new Object[]{this, dMIconFontTextView, Boolean.valueOf(z)});
            return;
        }
        this.w = dMIconFontTextView;
        if (this.c.getVisibility() == 0) {
            this.b.setVisibility(8);
            i();
            dMIconFontTextView.setText(this.a.getText(R$string.iconfont_shaixuanxia12));
            return;
        }
        this.b.setVisibility(0);
        this.b.setOnClickListener(new View$OnClickListenerC0375a());
        this.c.setVisibility(0);
        if (z) {
            this.q.d(350);
        }
        dMIconFontTextView.setText(this.a.getText(R$string.iconfont_shaixuanshang12));
        this.n.b(this.r, this.s);
        this.i.postDelayed(new Runnable() { // from class: cn.damai.category.common.utils.CalendarPopUtil.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-141529325")) {
                    ipChange2.ipc$dispatch("-141529325", new Object[]{this});
                    return;
                }
                CalendarPopUtil.this.i.scrollToPosition(CalendarPopUtil.this.t + 1);
                CalendarPopUtil.this.i.postDelayed(new Runnable() { // from class: cn.damai.category.common.utils.CalendarPopUtil.2.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-1224428058")) {
                            ipChange3.ipc$dispatch("-1224428058", new Object[]{this});
                        } else {
                            CalendarPopUtil.this.i.smoothScrollBy(0, 1);
                        }
                    }
                }, 100L);
            }
        }, 100L);
    }
}
