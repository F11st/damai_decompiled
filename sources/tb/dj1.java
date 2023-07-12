package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.CalendarBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.DateBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.HolidayBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.adapter.HorizontalCanlendarAdapter;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.CalendarView;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.DayEntity;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.MonthEntity;
import cn.damai.commonbusiness.view.SpaceItemDecoration;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class dj1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private HorizontalRecyclerView b;
    private HorizontalCanlendarAdapter c;
    private CalendarView d;
    private Context e;
    private List<MonthEntity> f;
    private long g;
    private int h;
    private CalendarBean i;
    private List<DateBean> j;

    /* compiled from: Taobao */
    /* renamed from: tb.dj1$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC9047a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC9047a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-354524210")) {
                ipChange.ipc$dispatch("-354524210", new Object[]{this, view});
                return;
            }
            MonthEntity monthEntity = null;
            try {
                monthEntity = (MonthEntity) view.getTag();
            } catch (Exception unused) {
            }
            if (monthEntity == null) {
                return;
            }
            dj1.this.f(monthEntity.index);
            dj1.this.c.g(monthEntity.index);
            C0529c e = C0529c.e();
            td2 i = td2.i();
            long j = dj1.this.g;
            e.x(i.s(j, monthEntity.month + "", monthEntity.index));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.dj1$b */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC9048b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC9048b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1756766159")) {
                ipChange.ipc$dispatch("1756766159", new Object[]{this, view});
                return;
            }
            DayEntity dayEntity = (DayEntity) view.getTag();
            if (dayEntity != null && dayEntity.hasPerform && dayEntity.hasPermission) {
                for (int i = 0; i < dj1.this.j.size(); i++) {
                    DateBean dateBean = (DateBean) dj1.this.j.get(i);
                    if (dateBean != null && !TextUtils.isEmpty(dateBean.dateId) && !TextUtils.isEmpty(dayEntity.dateId) && dateBean.dateId.equals(dayEntity.dateId)) {
                        dj1.this.h(dateBean);
                        C0529c.e().x(td2.i().r(dj1.this.g, dayEntity.dateId, i));
                    }
                }
            }
        }
    }

    public dj1(View view, long j) {
        this.a = view;
        this.e = view.getContext();
        this.g = j;
        g();
    }

    private int e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1519127021")) {
            return ((Integer) ipChange.ipc$dispatch("-1519127021", new Object[]{this, Boolean.valueOf(z)})).intValue();
        }
        if (wh2.e(this.f) != 0 && z) {
            for (int i = 0; i < this.f.size(); i++) {
                MonthEntity monthEntity = this.f.get(i);
                if (monthEntity != null && monthEntity.isSelected) {
                    return i;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1022911491")) {
            ipChange.ipc$dispatch("-1022911491", new Object[]{this, Integer.valueOf(i)});
        } else if (wh2.e(this.f) != 0 && this.f.size() > i) {
            this.d.initMonth(this.f.get(i), new View$OnClickListenerC9048b());
        }
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1474527195")) {
            ipChange.ipc$dispatch("1474527195", new Object[]{this});
            return;
        }
        this.b = (HorizontalRecyclerView) this.a.findViewById(R$id.hrv_canlendar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.e);
        linearLayoutManager.setOrientation(0);
        this.b.setLayoutManager(linearLayoutManager);
        HorizontalCanlendarAdapter horizontalCanlendarAdapter = new HorizontalCanlendarAdapter(this.e, new View$OnClickListenerC9047a());
        this.c = horizontalCanlendarAdapter;
        this.b.setAdapter(horizontalCanlendarAdapter);
        this.b.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(this.e, 7.5f)));
        this.d = (CalendarView) this.a.findViewById(R$id.view_calendar);
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208180554")) {
            ipChange.ipc$dispatch("-1208180554", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (i > 0) {
                MonthEntity monthEntity = this.f.get(i - 1);
                MonthEntity monthEntity2 = this.f.get(i);
                if (monthEntity != null && monthEntity2 != null && monthEntity.year != monthEntity2.year) {
                    monthEntity2.isShowYear = true;
                }
            } else {
                MonthEntity monthEntity3 = this.f.get(i);
                if (monthEntity3 != null && !TextUtils.isEmpty(this.i.today) && this.i.today.length() > 4 && monthEntity3.year > Integer.valueOf(this.i.today.substring(0, 4)).intValue()) {
                    monthEntity3.isShowYear = true;
                }
            }
        }
    }

    private void k(List<DateBean> list, List<HolidayBean> list2, boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1556780400")) {
            ipChange.ipc$dispatch("-1556780400", new Object[]{this, list, list2, Boolean.valueOf(z), str, Integer.valueOf(i)});
            return;
        }
        this.j = list;
        this.f = pf.b(list, list2, z, str, i == 2);
        this.h = e(z);
        List<MonthEntity> list3 = this.f;
        if (list3 == null || list3.size() <= this.h) {
            return;
        }
        j();
        this.c.f(this.f, this.h);
        f(this.h);
    }

    public void h(DateBean dateBean) {
        throw null;
    }

    public void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875308195")) {
            ipChange.ipc$dispatch("-1875308195", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.setVisibility(i);
        }
    }

    public void l(CalendarBean calendarBean, List<HolidayBean> list, boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-88420870")) {
            ipChange.ipc$dispatch("-88420870", new Object[]{this, calendarBean, list, Boolean.valueOf(z), str, Integer.valueOf(i)});
        } else if (calendarBean == null) {
        } else {
            this.i = calendarBean;
            k(calendarBean.dateViews, list, z, str, i);
        }
    }
}
