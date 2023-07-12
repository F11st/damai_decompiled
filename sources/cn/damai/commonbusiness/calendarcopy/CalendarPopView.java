package cn.damai.commonbusiness.calendarcopy;

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
import cn.damai.commonbusiness.calendarcopy.adapter.CalendarListAdapter;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarEntity;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import cn.damai.commonbusiness.home.bean.HomeMessage;
import cn.damai.projectfiltercopy.bean.CalendarInitBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.R$anim;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
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
import tb.bb2;
import tb.gm;
import tb.k62;
import tb.kj0;
import tb.of;

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
    private kj0 y;
    private int p = 0;
    public int r = -1;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnDateClickListener {
        void onClose();

        void onDateClick(int i, String str, String str2, int i2, String str3);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.CalendarPopView$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0590a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0590a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Day day;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1414833593")) {
                ipChange.ipc$dispatch("1414833593", new Object[]{this, view});
            } else if (view.getTag() == null || (day = (Day) view.getTag()) == null || day.showType == 0) {
            } else {
                CalendarPopView calendarPopView = CalendarPopView.this;
                calendarPopView.r = 5;
                if (calendarPopView.w == null) {
                    CalendarPopView.this.w = day;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(day);
                    CalendarPopView.this.D(arrayList);
                } else if (CalendarPopView.this.x != null) {
                    CalendarPopView.this.w = null;
                    CalendarPopView.this.x = null;
                    CalendarPopView.this.D(new ArrayList());
                } else if (day.equals(CalendarPopView.this.w)) {
                    CalendarPopView.this.w = null;
                    CalendarPopView.this.D(new ArrayList());
                } else if (day.isAfterDay(CalendarPopView.this.w)) {
                    CalendarPopView.this.x = day;
                    CalendarPopView calendarPopView2 = CalendarPopView.this;
                    calendarPopView2.D(calendarPopView2.q());
                } else {
                    CalendarPopView calendarPopView3 = CalendarPopView.this;
                    calendarPopView3.x = calendarPopView3.w;
                    CalendarPopView.this.w = day;
                    CalendarPopView calendarPopView4 = CalendarPopView.this;
                    calendarPopView4.D(calendarPopView4.q());
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.CalendarPopView$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0591b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0591b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1342447035")) {
                ipChange.ipc$dispatch("1342447035", new Object[]{this, view});
                return;
            }
            CalendarPopView calendarPopView = CalendarPopView.this;
            int i = calendarPopView.r;
            if (i == -1 || i == 5) {
                if (calendarPopView.w == null) {
                    CalendarPopView.this.o = null;
                    CalendarPopView.this.z(0, null, null, 0, "全部时间");
                    return;
                }
                String simpleShortDateString = CalendarPopView.this.w.toSimpleShortDateString();
                if (CalendarPopView.this.x == null) {
                    CalendarPopView calendarPopView2 = CalendarPopView.this;
                    calendarPopView2.x = calendarPopView2.w;
                } else {
                    simpleShortDateString = simpleShortDateString + "-" + CalendarPopView.this.x.toSimpleShortDateString();
                }
                String str = simpleShortDateString;
                if (CalendarPopView.this.y != null) {
                    kj0 kj0Var = CalendarPopView.this.y;
                    CalendarPopView calendarPopView3 = CalendarPopView.this;
                    kj0Var.c(calendarPopView3.r, calendarPopView3.w.toSimpleDateString(), CalendarPopView.this.x == null ? "" : CalendarPopView.this.x.toSimpleDateString());
                }
                CalendarPopView calendarPopView4 = CalendarPopView.this;
                calendarPopView4.z(5, calendarPopView4.w.toSimpleDateString(), CalendarPopView.this.x != null ? CalendarPopView.this.x.toSimpleDateString() : "", 0, str);
                return;
            }
            calendarPopView.z(i, null, null, 0, calendarPopView.s);
            if (CalendarPopView.this.y != null) {
                CalendarPopView.this.y.c(CalendarPopView.this.r, "", "");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.CalendarPopView$c */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0592c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0592c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-841229892")) {
                ipChange.ipc$dispatch("-841229892", new Object[]{this, view});
                return;
            }
            CalendarPopView calendarPopView = CalendarPopView.this;
            calendarPopView.r = 0;
            calendarPopView.H();
            CalendarPopView calendarPopView2 = CalendarPopView.this;
            calendarPopView2.w = calendarPopView2.x = null;
            CalendarPopView.this.D(new ArrayList());
            if (CalendarPopView.this.y != null) {
                CalendarPopView.this.y.e();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.CalendarPopView$d */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0593d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0593d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1270060477")) {
                ipChange.ipc$dispatch("1270060477", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.z(0, null, null, 0, "全部时间");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.CalendarPopView$e */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0594e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0594e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-913616450")) {
                ipChange.ipc$dispatch("-913616450", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.z(10, null, null, 1, "一周内");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.CalendarPopView$f */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0595f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0595f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1197673919")) {
                ipChange.ipc$dispatch("1197673919", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.z(4, null, null, 2, "一月内");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.CalendarPopView$g */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0596g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0596g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-986003008")) {
                ipChange.ipc$dispatch("-986003008", new Object[]{this, view});
                return;
            }
            CalendarPopView.this.o = null;
            CalendarPopView.this.z(9, null, null, 3, "本周末");
        }
    }

    public CalendarPopView(Context context, boolean z, boolean z2, int i, OnDateClickListener onDateClickListener, CalendarInitBean calendarInitBean) {
        w(context, z, z2, i, onDateClickListener, calendarInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1315188770")) {
            ipChange.ipc$dispatch("1315188770", new Object[]{this});
        } else if (!(this.i.getChildAt(0) instanceof LinearLayout) || (viewGroup = (ViewGroup) this.i.getChildAt(0)) == null || (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) == null || (viewGroup3 = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
        } else {
            E(viewGroup3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(List<Day> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1446216388")) {
            ipChange.ipc$dispatch("1446216388", new Object[]{this, list});
            return;
        }
        this.o = list;
        if (bb2.c(list) > 0) {
            Day day = list.get(0);
            if (day != null) {
                this.p = of.f(day);
            }
        } else {
            this.p = -1;
        }
        this.m.a(this.n, this.o);
    }

    private void E(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876729461")) {
            ipChange.ipc$dispatch("-1876729461", new Object[]{this, viewGroup});
        } else if (viewGroup == null || viewGroup.getChildCount() < 2 || !(viewGroup.getChildAt(0) instanceof TextView) || !(viewGroup.getChildAt(1) instanceof TextView)) {
        } else {
            TextView textView = (TextView) viewGroup.getChildAt(1);
            this.k.setText(((TextView) viewGroup.getChildAt(0)).getText());
            if (textView.getText() != null && !TextUtils.isEmpty(textView.getText().toString())) {
                CharSequence text = textView.getText();
                boolean equals = TextUtils.equals(this.l.getText(), text);
                this.l.setText(text);
                this.l.setVisibility(0);
                if (equals) {
                    return;
                }
                this.l.post(new Runnable() { // from class: cn.damai.commonbusiness.calendarcopy.CalendarPopView.10
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1980396668")) {
                            ipChange2.ipc$dispatch("-1980396668", new Object[]{this});
                        } else {
                            CalendarPopView.this.l.requestLayout();
                        }
                    }
                });
                return;
            }
            this.l.setVisibility(8);
        }
    }

    private void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392825464")) {
            ipChange.ipc$dispatch("392825464", new Object[]{this});
        } else {
            this.c.startAnimation(AnimationUtils.loadAnimation(this.a, R$anim.copy_common_calendar_anim));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "819310129")) {
            ipChange.ipc$dispatch("819310129", new Object[]{this});
            return;
        }
        int i = this.r;
        if (i == 0) {
            this.e.setBackgroundResource(R$drawable.copy_common_date_select_bg);
            TextView textView = this.f;
            int i2 = R$drawable.copy_common_date_normal_bg;
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
            int i4 = R$drawable.copy_common_date_normal_bg;
            textView3.setBackgroundResource(i4);
            this.f.setBackgroundResource(i4);
            this.g.setBackgroundResource(R$drawable.copy_common_date_select_bg);
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
            int i6 = R$drawable.copy_common_date_normal_bg;
            textView5.setBackgroundResource(i6);
            this.f.setBackgroundResource(i6);
            this.g.setBackgroundResource(i6);
            this.h.setBackgroundResource(R$drawable.copy_common_date_select_bg);
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
            int i8 = R$drawable.copy_common_date_normal_bg;
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
            int i10 = R$drawable.copy_common_date_normal_bg;
            textView9.setBackgroundResource(i10);
            this.f.setBackgroundResource(R$drawable.copy_common_date_select_bg);
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
            int i12 = R$drawable.copy_common_date_normal_bg;
            textView11.setBackgroundResource(i12);
            this.f.setBackgroundResource(R$drawable.copy_common_date_select_bg);
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

    private List<Day> s(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2087069047")) {
            return (List) ipChange.ipc$dispatch("2087069047", new Object[]{this, calendarBean});
        }
        ArrayList arrayList = new ArrayList();
        if (calendarBean != null && !TextUtils.isEmpty(calendarBean.startDate)) {
            Date s = of.s(calendarBean.startDate);
            if (TextUtils.isEmpty(calendarBean.endDate)) {
                calendarBean.endDate = calendarBean.startDate;
            }
            Date s2 = of.s(calendarBean.endDate);
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

    private void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436837416")) {
            ipChange.ipc$dispatch("-1436837416", new Object[]{this});
            return;
        }
        this.b.findViewById(R$id.item_filter_confirm).setOnClickListener(new View$OnClickListenerC0591b());
        this.b.findViewById(R$id.item_filter_reset).setOnClickListener(new View$OnClickListenerC0592c());
    }

    private void w(Context context, boolean z, boolean z2, int i, OnDateClickListener onDateClickListener, CalendarInitBean calendarInitBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256225320")) {
            ipChange.ipc$dispatch("-256225320", new Object[]{this, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), onDateClickListener, calendarInitBean});
            return;
        }
        this.t = z;
        this.q = z2;
        View inflate = LayoutInflater.from(context).inflate(R$layout.copy_common_calendar_pop, (ViewGroup) null);
        this.b = inflate;
        inflate.setVisibility(8);
        Context context2 = this.b.getContext();
        this.a = context2;
        this.u = k62.a(context2, i);
        this.v = onDateClickListener;
        if (calendarInitBean.mYearBeanList != null) {
            CalendarBean calendarBean = new CalendarBean();
            this.n = calendarBean;
            calendarBean.calendar = calendarInitBean.mYearBeanList;
        } else {
            try {
                String spValue = gm.INSTANCE.a().getSpValue(HomeMessage.CALENDAR_DATA);
                if (spValue != null) {
                    this.n = (CalendarBean) JSON.parseObject(spValue, CalendarBean.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        y(calendarInitBean.mCalendarEntityList);
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686928343")) {
            ipChange.ipc$dispatch("1686928343", new Object[]{this});
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
            this.e.setOnClickListener(new View$OnClickListenerC0593d());
            this.f.setOnClickListener(new View$OnClickListenerC0594e());
            this.g.setOnClickListener(new View$OnClickListenerC0595f());
            this.h.setOnClickListener(new View$OnClickListenerC0596g());
            H();
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void y(List<CalendarEntity> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773259702")) {
            ipChange.ipc$dispatch("773259702", new Object[]{this, list});
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
        CalendarListAdapter calendarListAdapter = new CalendarListAdapter(this.a, list, new View$OnClickListenerC0590a());
        this.m = calendarListAdapter;
        this.i.setAdapter(calendarListAdapter);
        this.i.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.commonbusiness.calendarcopy.CalendarPopView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1498508519")) {
                    ipChange2.ipc$dispatch("-1498508519", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                CalendarPopView.this.i.getChildAt(0);
                if (CalendarPopView.this.t) {
                    CalendarPopView.this.C();
                }
            }
        });
        x();
        v();
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
    public void z(int r10, java.lang.String r11, java.lang.String r12, int r13, java.lang.String r14) {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.calendarcopy.CalendarPopView.$ipChange
            java.lang.String r1 = "1794846544"
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
            java.util.List r0 = tb.of.k()
            r9.o = r0
            goto L5c
        L3d:
            if (r10 != r3) goto L49
            java.util.List r0 = tb.of.l()
            r9.o = r0
            java.lang.String r0 = "一月内"
            r4 = 2
            goto L5f
        L49:
            r0 = 9
            if (r10 != r0) goto L56
            java.util.List r0 = tb.of.q()
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
            tb.kj0 r1 = r9.y
            if (r1 == 0) goto L68
            if (r10 == r8) goto L68
            r1.d(r0, r4)
        L68:
            cn.damai.commonbusiness.calendarcopy.adapter.CalendarListAdapter r0 = r9.m
            cn.damai.commonbusiness.calendarcopy.bean.CalendarBean r1 = r9.n
            java.util.List<cn.damai.commonbusiness.calendarcopy.bean.Day> r2 = r9.o
            r0.a(r1, r2)
            r9.r = r10
            r9.s = r14
            boolean r0 = r9.q
            if (r0 == 0) goto L7c
            r9.H()
        L7c:
            cn.damai.commonbusiness.calendarcopy.CalendarPopView$OnDateClickListener r1 = r9.v
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
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.calendarcopy.CalendarPopView.z(int, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    public void A(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2000608571")) {
            ipChange.ipc$dispatch("2000608571", new Object[]{this, calendarBean});
        } else if (calendarBean == null) {
        } else {
            try {
                i = Integer.parseInt(calendarBean.dateType);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (i == 10) {
                this.o = of.k();
            } else if (i == 4) {
                this.o = of.l();
            } else if (i == 9) {
                this.o = of.q();
            } else if (i == 5) {
                this.o = s(calendarBean);
            } else if (i == 0) {
                this.o = new ArrayList();
            }
            this.m.a(this.n, this.o);
            this.r = i;
            this.s = calendarBean.name;
            if (this.q) {
                H();
            }
        }
    }

    public kj0 B(kj0 kj0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449981919")) {
            return (kj0) ipChange.ipc$dispatch("449981919", new Object[]{this, kj0Var});
        }
        this.y = kj0Var;
        return kj0Var;
    }

    public void F() {
        Day day;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874278652")) {
            ipChange.ipc$dispatch("1874278652", new Object[]{this});
            return;
        }
        this.b.setVisibility(0);
        G();
        this.m.a(this.n, this.o);
        final int a = (((((DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - k62.a(this.a, 18.0f)) / 7) - 6) * 56) / 45) + k62.a(this.a, 16.0f);
        if (bb2.c(this.o) > 0 && (day = this.o.get(0)) != null) {
            this.p = of.f(day);
        }
        this.i.postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.calendarcopy.CalendarPopView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1719555848")) {
                    ipChange2.ipc$dispatch("-1719555848", new Object[]{this});
                    return;
                }
                if (CalendarPopView.this.p < 1) {
                    CalendarPopView.this.i.scrollToPosition(0);
                } else {
                    CalendarPopView.this.i.scrollToPosition(CalendarPopView.this.p - 1);
                }
                CalendarPopView.this.i.postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.calendarcopy.CalendarPopView.1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        Day day2;
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-1584461173")) {
                            ipChange3.ipc$dispatch("-1584461173", new Object[]{this});
                            return;
                        }
                        int h = of.h(of.p(), of.n());
                        int m = of.m();
                        if (bb2.c(CalendarPopView.this.o) > 0 && (day2 = (Day) CalendarPopView.this.o.get(0)) != null) {
                            h = of.h(day2.year, day2.month);
                            Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).set(day2.year, day2.month, day2.day);
                            m = day2.day;
                        }
                        CalendarPopView.this.i.scrollBy(0, a * (((h + m) - 2) / 7));
                    }
                }, 100L);
            }
        }, 100L);
    }

    public List<Day> q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454806351")) {
            return (List) ipChange.ipc$dispatch("-1454806351", new Object[]{this});
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

    public kj0 r() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1995850722") ? (kj0) ipChange.ipc$dispatch("1995850722", new Object[]{this}) : this.y;
    }

    public View t() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1588872087") ? (View) ipChange.ipc$dispatch("1588872087", new Object[]{this}) : this.b;
    }

    public void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1442231169")) {
            ipChange.ipc$dispatch("1442231169", new Object[]{this});
            return;
        }
        this.b.setVisibility(8);
        this.x = null;
        this.w = null;
    }
}
