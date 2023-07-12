package cn.damai.commonbusiness.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.calendar.adapter.CalendarListAdapter;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.bean.CalendarYearBean;
import cn.damai.commonbusiness.calendar.bean.Day;
import cn.damai.commonbusiness.home.bean.HomeMessage;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import tb.lj0;
import tb.nf;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CalendarPopView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String STR_ONE_WEEK = "一周内";
    private Context a;
    private View b;
    private View c;
    private ViewGroup d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private RecyclerView i;
    private ViewGroup j;
    private TextView k;
    private TextView l;
    private CalendarListAdapter m;
    private CalendarBean n;
    private List<Day> o;
    private boolean q;
    private String s;
    private boolean t;
    private int u;
    private OnDateClickListener v;
    private Day w;
    private Day x;
    private lj0 y;
    private int p = 0;
    public int r = -1;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnDateClickListener {
        void onClose();

        void onDateClick(int i, String str, String str2, int i2, String str3);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendar.CalendarPopView$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0581a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0581a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Day day;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "654192388")) {
                ipChange.ipc$dispatch("654192388", new Object[]{this, view});
            } else if (view.getTag() == null || (day = (Day) view.getTag()) == null || day.showType == 0) {
            } else {
                CalendarPopView calendarPopView = CalendarPopView.this;
                calendarPopView.r = 5;
                if (calendarPopView.w == null) {
                    CalendarPopView.this.w = day;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(day);
                    CalendarPopView.this.C(arrayList);
                } else if (CalendarPopView.this.x != null) {
                    CalendarPopView.this.w = null;
                    CalendarPopView.this.x = null;
                    CalendarPopView.this.C(new ArrayList());
                } else if (day.equals(CalendarPopView.this.w)) {
                    CalendarPopView.this.w = null;
                    CalendarPopView.this.C(new ArrayList());
                } else if (day.isAfterDay(CalendarPopView.this.w)) {
                    CalendarPopView.this.x = day;
                    CalendarPopView calendarPopView2 = CalendarPopView.this;
                    calendarPopView2.C(calendarPopView2.p());
                } else {
                    CalendarPopView calendarPopView3 = CalendarPopView.this;
                    calendarPopView3.x = calendarPopView3.w;
                    CalendarPopView.this.w = day;
                    CalendarPopView calendarPopView4 = CalendarPopView.this;
                    calendarPopView4.C(calendarPopView4.p());
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendar.CalendarPopView$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0582b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0582b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "581805830")) {
                ipChange.ipc$dispatch("581805830", new Object[]{this, view});
                return;
            }
            CalendarPopView calendarPopView = CalendarPopView.this;
            int i = calendarPopView.r;
            if (i == -1 || i == 5) {
                if (calendarPopView.w == null) {
                    CalendarPopView.this.o = null;
                    CalendarPopView.this.y(0, null, null, 0, "全部时间");
                    return;
                }
                String shortDateString = CalendarPopView.this.w.toShortDateString();
                if (CalendarPopView.this.x == null) {
                    CalendarPopView calendarPopView2 = CalendarPopView.this;
                    calendarPopView2.x = calendarPopView2.w;
                } else {
                    shortDateString = shortDateString + "-" + CalendarPopView.this.x.toShortDateString();
                }
                String str = shortDateString;
                if (CalendarPopView.this.y != null) {
                    lj0 lj0Var = CalendarPopView.this.y;
                    CalendarPopView calendarPopView3 = CalendarPopView.this;
                    lj0Var.f(calendarPopView3.r, calendarPopView3.w.toSimpleDateString(), CalendarPopView.this.x == null ? "" : CalendarPopView.this.x.toSimpleDateString());
                }
                CalendarPopView calendarPopView4 = CalendarPopView.this;
                calendarPopView4.y(5, calendarPopView4.w.toSimpleDateString(), CalendarPopView.this.x != null ? CalendarPopView.this.x.toSimpleDateString() : "", 0, str);
                return;
            }
            calendarPopView.y(i, null, null, 0, calendarPopView.s);
            if (CalendarPopView.this.y != null) {
                CalendarPopView.this.y.f(CalendarPopView.this.r, "", "");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendar.CalendarPopView$c */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0583c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0583c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1601871097")) {
                ipChange.ipc$dispatch("-1601871097", new Object[]{this, view});
                return;
            }
            CalendarPopView calendarPopView = CalendarPopView.this;
            calendarPopView.r = 0;
            calendarPopView.G();
            CalendarPopView calendarPopView2 = CalendarPopView.this;
            calendarPopView2.w = calendarPopView2.x = null;
            CalendarPopView.this.C(new ArrayList());
            if (CalendarPopView.this.y != null) {
                CalendarPopView.this.y.h();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendar.CalendarPopView$d */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0584d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0584d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "509419272")) {
                ipChange.ipc$dispatch("509419272", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.y(0, null, null, 0, "全部时间");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendar.CalendarPopView$e */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0585e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0585e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1674257655")) {
                ipChange.ipc$dispatch("-1674257655", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.y(10, null, null, 1, "一周内");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendar.CalendarPopView$f */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0586f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0586f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "437032714")) {
                ipChange.ipc$dispatch("437032714", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.y(4, null, null, 2, "一月内");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendar.CalendarPopView$g */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0587g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0587g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1746644213")) {
                ipChange.ipc$dispatch("-1746644213", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.y(9, null, null, 3, "本周末");
        }
    }

    public CalendarPopView(Context context, boolean z, boolean z2, int i, OnDateClickListener onDateClickListener) {
        v(context, z, z2, i, onDateClickListener, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587211447")) {
            ipChange.ipc$dispatch("1587211447", new Object[]{this});
        } else if (!(this.i.getChildAt(0) instanceof LinearLayout) || (viewGroup = (ViewGroup) this.i.getChildAt(0)) == null || (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) == null || (viewGroup3 = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
        } else {
            D(viewGroup3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(List<Day> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656530407")) {
            ipChange.ipc$dispatch("-656530407", new Object[]{this, list});
            return;
        }
        this.o = list;
        if (wh2.e(list) > 0) {
            Day day = list.get(0);
            if (day != null) {
                this.p = nf.f(day);
            }
        } else {
            this.p = -1;
        }
        this.m.a(this.n, this.o);
    }

    private void D(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313196960")) {
            ipChange.ipc$dispatch("313196960", new Object[]{this, viewGroup});
        } else if (viewGroup == null || viewGroup.getChildCount() < 2 || !(viewGroup.getChildAt(0) instanceof TextView) || !(viewGroup.getChildAt(1) instanceof TextView)) {
        } else {
            TextView textView = (TextView) viewGroup.getChildAt(1);
            this.k.setText(((TextView) viewGroup.getChildAt(0)).getText());
            if (textView.getText() != null && !TextUtils.isEmpty(textView.getText().toString())) {
                this.l.setText(textView.getText());
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    private void F() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041912573")) {
            ipChange.ipc$dispatch("-2041912573", new Object[]{this});
        } else {
            this.c.startAnimation(AnimationUtils.loadAnimation(this.a, R$anim.common_calendar_anim));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793232892")) {
            ipChange.ipc$dispatch("1793232892", new Object[]{this});
            return;
        }
        int i = this.r;
        if (i == 0) {
            this.e.setBackgroundResource(R$drawable.common_date_select_bg);
            TextView textView = this.f;
            int i2 = R$drawable.common_date_normal_bg;
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
            this.p = -1;
        } else if (i == 4) {
            TextView textView3 = this.e;
            int i4 = R$drawable.common_date_normal_bg;
            textView3.setBackgroundResource(i4);
            this.f.setBackgroundResource(i4);
            this.g.setBackgroundResource(R$drawable.common_date_select_bg);
            this.h.setBackgroundResource(i4);
            TextView textView4 = this.e;
            Resources resources2 = this.a.getResources();
            int i5 = R$color.color_000000;
            textView4.setTextColor(resources2.getColor(i5));
            this.f.setTextColor(this.a.getResources().getColor(i5));
            this.g.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.h.setTextColor(this.a.getResources().getColor(i5));
            this.p = -1;
        } else if (i == 9) {
            TextView textView5 = this.e;
            int i6 = R$drawable.common_date_normal_bg;
            textView5.setBackgroundResource(i6);
            this.f.setBackgroundResource(i6);
            this.g.setBackgroundResource(i6);
            this.h.setBackgroundResource(R$drawable.common_date_select_bg);
            TextView textView6 = this.e;
            Resources resources3 = this.a.getResources();
            int i7 = R$color.color_000000;
            textView6.setTextColor(resources3.getColor(i7));
            this.f.setTextColor(this.a.getResources().getColor(i7));
            this.g.setTextColor(this.a.getResources().getColor(i7));
            this.h.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.p = -1;
        } else if (i != 10) {
            TextView textView7 = this.e;
            int i8 = R$drawable.common_date_normal_bg;
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
            int i10 = R$drawable.common_date_normal_bg;
            textView9.setBackgroundResource(i10);
            this.f.setBackgroundResource(R$drawable.common_date_select_bg);
            this.g.setBackgroundResource(i10);
            this.h.setBackgroundResource(i10);
            TextView textView10 = this.e;
            Resources resources5 = this.a.getResources();
            int i11 = R$color.color_000000;
            textView10.setTextColor(resources5.getColor(i11));
            this.f.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.g.setTextColor(this.a.getResources().getColor(i11));
            this.h.setTextColor(this.a.getResources().getColor(i11));
            this.p = -1;
        }
        if (this.r == 5 && TextUtils.equals("一周内", this.s)) {
            TextView textView11 = this.e;
            int i12 = R$drawable.common_date_normal_bg;
            textView11.setBackgroundResource(i12);
            this.f.setBackgroundResource(R$drawable.common_date_select_bg);
            this.g.setBackgroundResource(i12);
            this.h.setBackgroundResource(i12);
            TextView textView12 = this.e;
            Resources resources6 = this.a.getResources();
            int i13 = R$color.color_000000;
            textView12.setTextColor(resources6.getColor(i13));
            this.f.setTextColor(this.a.getResources().getColor(R$color.color_FF2D79));
            this.g.setTextColor(this.a.getResources().getColor(i13));
            this.h.setTextColor(this.a.getResources().getColor(i13));
            this.p = -1;
        }
    }

    private List<Day> r(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846653325")) {
            return (List) ipChange.ipc$dispatch("846653325", new Object[]{this, calendarBean});
        }
        ArrayList arrayList = new ArrayList();
        if (calendarBean != null && !TextUtils.isEmpty(calendarBean.startDate)) {
            Date s = nf.s(calendarBean.startDate);
            if (TextUtils.isEmpty(calendarBean.endDate)) {
                calendarBean.endDate = calendarBean.startDate;
            }
            Date s2 = nf.s(calendarBean.endDate);
            if (s == null) {
                return arrayList;
            }
            int time = (int) ((s2.getTime() - s.getTime()) / 86400000);
            PrintStream printStream = System.out;
            printStream.println("两个时间之间的天数差为：" + time);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            for (int i = 0; i <= time; i++) {
                calendar.setTime(s);
                calendar.add(5, i);
                Day day = new Day(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
                arrayList.add(day);
                if (i == 0) {
                    this.w = day;
                } else if (i == time) {
                    this.x = day;
                }
            }
        }
        return arrayList;
    }

    private void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594069021")) {
            ipChange.ipc$dispatch("-1594069021", new Object[]{this});
            return;
        }
        this.b.findViewById(R$id.item_filter_confirm).setOnClickListener(new View$OnClickListenerC0582b());
        this.b.findViewById(R$id.item_filter_reset).setOnClickListener(new View$OnClickListenerC0583c());
    }

    private void v(Context context, boolean z, boolean z2, int i, OnDateClickListener onDateClickListener, List<CalendarYearBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895621379")) {
            ipChange.ipc$dispatch("-895621379", new Object[]{this, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), onDateClickListener, list});
            return;
        }
        this.t = z;
        this.q = z2;
        View inflate = LayoutInflater.from(context).inflate(R$layout.common_calendar_pop, (ViewGroup) null);
        this.b = inflate;
        inflate.setVisibility(8);
        Context context2 = this.b.getContext();
        this.a = context2;
        this.u = ScreenUtil.dip2px(context2, i);
        this.v = onDateClickListener;
        if (list != null) {
            CalendarBean calendarBean = new CalendarBean();
            this.n = calendarBean;
            calendarBean.calendar = list;
        } else {
            try {
                String B = z20.B(HomeMessage.CALENDAR_DATA);
                if (B != null) {
                    this.n = (CalendarBean) JSON.parseObject(B, CalendarBean.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        x();
    }

    private void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775506772")) {
            ipChange.ipc$dispatch("-775506772", new Object[]{this});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R$id.layout_fourdate);
        this.d = viewGroup;
        if (this.q) {
            viewGroup.setVisibility(0);
            this.e = (TextView) this.d.findViewById(R$id.tv_time1);
            this.f = (TextView) this.d.findViewById(R$id.tv_time2);
            this.g = (TextView) this.d.findViewById(R$id.tv_time3);
            this.h = (TextView) this.d.findViewById(R$id.tv_time4);
            this.e.setOnClickListener(new View$OnClickListenerC0584d());
            this.f.setOnClickListener(new View$OnClickListenerC0585e());
            this.g.setOnClickListener(new View$OnClickListenerC0586f());
            this.h.setOnClickListener(new View$OnClickListenerC0587g());
            G();
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1842445200")) {
            ipChange.ipc$dispatch("1842445200", new Object[]{this});
            return;
        }
        View findViewById = this.b.findViewById(R$id.layout_calendar);
        this.c = findViewById;
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).setMargins(0, 0, 0, this.u);
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R$id.layout_guding);
        this.j = viewGroup;
        if (this.t) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        this.k = (TextView) this.b.findViewById(R$id.tv_calendar_month);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        this.k.setText(simpleDateFormat.format(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime()));
        this.l = (TextView) this.b.findViewById(R$id.tv_shenhua);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R$id.pop_irc);
        this.i = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
        CalendarListAdapter calendarListAdapter = new CalendarListAdapter(this.a, new View$OnClickListenerC0581a());
        this.m = calendarListAdapter;
        this.i.setAdapter(calendarListAdapter);
        this.i.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.commonbusiness.calendar.CalendarPopView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-82579026")) {
                    ipChange2.ipc$dispatch("-82579026", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                CalendarPopView.this.i.getChildAt(0);
                if (CalendarPopView.this.t) {
                    CalendarPopView.this.B();
                }
            }
        });
        w();
        u();
        this.m.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(int r10, java.lang.String r11, java.lang.String r12, int r13, java.lang.String r14) {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.calendar.CalendarPopView.$ipChange
            java.lang.String r1 = "-404809819"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 5
            if (r2 == 0) goto L2b
            r2 = 6
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r7] = r9
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r2[r6] = r10
            r2[r5] = r11
            r2[r4] = r12
            java.lang.Integer r10 = java.lang.Integer.valueOf(r13)
            r2[r3] = r10
            r2[r8] = r14
            r0.ipc$dispatch(r1, r2)
            return
        L2b:
            if (r10 != r8) goto L32
            androidx.recyclerview.widget.RecyclerView r0 = r9.i
            r0.scrollToPosition(r7)
        L32:
            r0 = 10
            if (r10 != r0) goto L3d
            java.util.List r0 = tb.nf.i()
            r9.o = r0
            goto L5c
        L3d:
            if (r10 != r3) goto L49
            java.util.List r0 = tb.nf.j()
            r9.o = r0
            java.lang.String r0 = "一月内"
            r4 = 2
            goto L5f
        L49:
            r0 = 9
            if (r10 != r0) goto L56
            java.util.List r0 = tb.nf.p()
            r9.o = r0
            java.lang.String r0 = "本周末"
            goto L5f
        L56:
            if (r10 != 0) goto L5c
            java.lang.String r0 = "全部时间"
            r4 = 0
            goto L5f
        L5c:
            java.lang.String r0 = "一周内"
            r4 = 1
        L5f:
            tb.lj0 r1 = r9.y
            if (r1 == 0) goto L68
            if (r10 == r8) goto L68
            r1.g(r0, r4)
        L68:
            cn.damai.commonbusiness.calendar.adapter.CalendarListAdapter r0 = r9.m
            cn.damai.commonbusiness.calendar.bean.CalendarBean r1 = r9.n
            java.util.List<cn.damai.commonbusiness.calendar.bean.Day> r2 = r9.o
            r0.a(r1, r2)
            r9.r = r10
            r9.s = r14
            boolean r0 = r9.q
            if (r0 == 0) goto L7c
            r9.G()
        L7c:
            cn.damai.commonbusiness.calendar.CalendarPopView$OnDateClickListener r1 = r9.v
            if (r1 == 0) goto L88
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r1.onDateClick(r2, r3, r4, r5, r6)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.calendar.CalendarPopView.y(int, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    public lj0 A(lj0 lj0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183893706")) {
            return (lj0) ipChange.ipc$dispatch("1183893706", new Object[]{this, lj0Var});
        }
        this.y = lj0Var;
        return lj0Var;
    }

    public void E() {
        Day day;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110316753")) {
            ipChange.ipc$dispatch("1110316753", new Object[]{this});
            return;
        }
        this.b.setVisibility(0);
        F();
        this.m.a(this.n, this.o);
        final int dip2px = (((((DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - ScreenUtil.dip2px(this.a, 18.0f)) / 7) - 6) * 56) / 45) + ScreenUtil.dip2px(this.a, 16.0f);
        if (wh2.e(this.o) > 0 && (day = this.o.get(0)) != null) {
            this.p = nf.f(day);
        }
        this.i.postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.calendar.CalendarPopView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1716516877")) {
                    ipChange2.ipc$dispatch("1716516877", new Object[]{this});
                    return;
                }
                if (CalendarPopView.this.p < 1) {
                    CalendarPopView.this.i.scrollToPosition(0);
                } else {
                    CalendarPopView.this.i.scrollToPosition(CalendarPopView.this.p - 1);
                }
                CalendarPopView.this.i.postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.calendar.CalendarPopView.1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        Day day2;
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "1946544224")) {
                            ipChange3.ipc$dispatch("1946544224", new Object[]{this});
                            return;
                        }
                        int h = nf.h(nf.o(), nf.m());
                        int k = nf.k();
                        if (wh2.e(CalendarPopView.this.o) > 0 && (day2 = (Day) CalendarPopView.this.o.get(0)) != null) {
                            h = nf.h(day2.year, day2.month);
                            Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).set(day2.year, day2.month, day2.day);
                            k = day2.day;
                        }
                        CalendarPopView.this.i.scrollBy(0, dip2px * (((h + k) - 2) / 7));
                    }
                }, 100L);
            }
        }, 100L);
    }

    public List<Day> p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063673158")) {
            return (List) ipChange.ipc$dispatch("1063673158", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        Day day = this.w;
        calendar.set(day.year, day.month - 1, day.day);
        calendar.get(6);
        Date simpleDate = this.w.toSimpleDate();
        Date simpleDate2 = this.x.toSimpleDate();
        if (simpleDate != null && simpleDate2 != null) {
            int time = (int) ((simpleDate2.getTime() - simpleDate.getTime()) / 86400000);
            PrintStream printStream = System.out;
            printStream.println("两个时间之间的天数差为：" + time);
            for (int i = 0; i <= time; i++) {
                Day day2 = this.w;
                calendar.set(day2.year, day2.month - 1, day2.day);
                calendar.add(5, i);
                arrayList.add(new Day(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
            }
        }
        return arrayList;
    }

    public lj0 q() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1697550914") ? (lj0) ipChange.ipc$dispatch("1697550914", new Object[]{this}) : this.y;
    }

    public View s() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-187615700") ? (View) ipChange.ipc$dispatch("-187615700", new Object[]{this}) : this.b;
    }

    public void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678269270")) {
            ipChange.ipc$dispatch("678269270", new Object[]{this});
            return;
        }
        this.b.setVisibility(8);
        this.x = null;
        this.w = null;
    }

    public void z(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1896967397")) {
            ipChange.ipc$dispatch("1896967397", new Object[]{this, calendarBean});
        } else if (calendarBean == null) {
        } else {
            try {
                i = Integer.parseInt(calendarBean.dateType);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (i == 10) {
                this.o = nf.i();
            } else if (i == 4) {
                this.o = nf.j();
            } else if (i == 9) {
                this.o = nf.p();
            } else if (i == 5) {
                this.o = r(calendarBean);
            } else if (i == 0) {
                this.o = new ArrayList();
            }
            this.m.a(this.n, this.o);
            this.r = i;
            this.s = calendarBean.name;
            if (this.q) {
                G();
            }
        }
    }

    public CalendarPopView(Context context, boolean z, boolean z2, int i, OnDateClickListener onDateClickListener, List<CalendarYearBean> list) {
        v(context, z, z2, i, onDateClickListener, list);
    }
}
