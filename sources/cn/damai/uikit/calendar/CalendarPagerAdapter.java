package cn.damai.uikit.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.uikit.calendar.CalendarPagerView;
import cn.damai.uikit.calendar.MaterialCalendarView;
import cn.damai.uikit.calendar.format.DayFormatter;
import cn.damai.uikit.calendar.format.TitleFormatter;
import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class CalendarPagerAdapter<V extends CalendarPagerView> extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ArrayDeque<V> a;
    protected final MaterialCalendarView b;
    private DateRangeIndex k;
    private TitleFormatter d = null;
    private Integer e = null;
    private Integer f = null;
    private Integer g = null;
    @MaterialCalendarView.ShowOtherDates
    private int h = 4;
    private CalendarDay i = null;
    private CalendarDay j = null;
    private List<CalendarDay> l = new ArrayList();
    private WeekDayFormatter m = WeekDayFormatter.DEFAULT;
    private DayFormatter n = DayFormatter.DEFAULT;
    private List<DayViewDecorator> o = new ArrayList();
    private List<b> p = null;
    private boolean q = true;
    private final CalendarDay c = CalendarDay.today();

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarPagerAdapter(MaterialCalendarView materialCalendarView) {
        this.b = materialCalendarView;
        ArrayDeque<V> arrayDeque = new ArrayDeque<>();
        this.a = arrayDeque;
        arrayDeque.iterator();
        t(null, null);
    }

    private void A() {
        CalendarDay calendarDay;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2115423118")) {
            ipChange.ipc$dispatch("2115423118", new Object[]{this});
            return;
        }
        while (i < this.l.size()) {
            CalendarDay calendarDay2 = this.l.get(i);
            CalendarDay calendarDay3 = this.i;
            if ((calendarDay3 != null && calendarDay3.isAfter(calendarDay2)) || ((calendarDay = this.j) != null && calendarDay.isBefore(calendarDay2))) {
                this.l.remove(i);
                this.b.onDateUnselected(calendarDay2);
                i--;
            }
            i++;
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672581005")) {
            ipChange.ipc$dispatch("-672581005", new Object[]{this});
            return;
        }
        A();
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setSelectedDates(this.l);
        }
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254937106")) {
            ipChange.ipc$dispatch("-1254937106", new Object[]{this});
            return;
        }
        this.l.clear();
        m();
    }

    protected abstract DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2);

    protected abstract V c(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public int d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242513824")) {
            return ((Integer) ipChange.ipc$dispatch("-242513824", new Object[]{this})).intValue();
        }
        Integer num = this.f;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303575083")) {
            ipChange.ipc$dispatch("303575083", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        CalendarPagerView calendarPagerView = (CalendarPagerView) obj;
        this.a.remove(calendarPagerView);
        viewGroup.removeView(calendarPagerView);
    }

    public int e(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3338502")) {
            return ((Integer) ipChange.ipc$dispatch("3338502", new Object[]{this, calendarDay})).intValue();
        }
        if (calendarDay == null) {
            return getCount() / 2;
        }
        CalendarDay calendarDay2 = this.i;
        if (calendarDay2 == null || !calendarDay.isBefore(calendarDay2)) {
            CalendarDay calendarDay3 = this.j;
            if (calendarDay3 != null && calendarDay.isAfter(calendarDay3)) {
                return getCount() - 1;
            }
            return this.k.indexOf(calendarDay);
        }
        return 0;
    }

    public CalendarDay f(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "450933510") ? (CalendarDay) ipChange.ipc$dispatch("450933510", new Object[]{this, Integer.valueOf(i)}) : this.k.getItem(i);
    }

    public DateRangeIndex g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-594198942") ? (DateRangeIndex) ipChange.ipc$dispatch("-594198942", new Object[]{this}) : this.k;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-773518206") ? ((Integer) ipChange.ipc$dispatch("-773518206", new Object[]{this})).intValue() : this.k.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int k;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995038655")) {
            return ((Integer) ipChange.ipc$dispatch("1995038655", new Object[]{this, obj})).intValue();
        }
        if (n(obj)) {
            CalendarPagerView calendarPagerView = (CalendarPagerView) obj;
            if (calendarPagerView.getFirstViewDay() != null && (k = k(calendarPagerView)) >= 0) {
                return k;
            }
            return -2;
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788725204")) {
            return (CharSequence) ipChange.ipc$dispatch("-1788725204", new Object[]{this, Integer.valueOf(i)});
        }
        TitleFormatter titleFormatter = this.d;
        return titleFormatter == null ? "" : titleFormatter.format(f(i));
    }

    @NonNull
    public List<CalendarDay> h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1699584435") ? (List) ipChange.ipc$dispatch("1699584435", new Object[]{this}) : Collections.unmodifiableList(this.l);
    }

    @MaterialCalendarView.ShowOtherDates
    public int i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1425403789") ? ((Integer) ipChange.ipc$dispatch("1425403789", new Object[]{this})).intValue() : this.h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444184685")) {
            return ipChange.ipc$dispatch("-1444184685", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        V c = c(i);
        c.setContentDescription(this.b.getCalendarContentDescription());
        c.setAlpha(0.0f);
        c.setSelectionEnabled(this.q);
        c.setWeekDayFormatter(this.m);
        c.setDayFormatter(this.n);
        Integer num = this.e;
        if (num != null) {
            c.setSelectionColor(num.intValue());
        }
        Integer num2 = this.f;
        if (num2 != null) {
            c.setDateTextAppearance(num2.intValue());
        }
        Integer num3 = this.g;
        if (num3 != null) {
            c.setWeekDayTextAppearance(num3.intValue());
        }
        c.setShowOtherDates(this.h);
        c.setMinimumDate(this.i);
        c.setMaximumDate(this.j);
        c.setSelectedDates(this.l);
        viewGroup.addView(c);
        this.a.add(c);
        c.setDayViewDecorators(this.p);
        return c;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "162340226") ? ((Boolean) ipChange.ipc$dispatch("162340226", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154867528")) {
            return ((Integer) ipChange.ipc$dispatch("-154867528", new Object[]{this})).intValue();
        }
        Integer num = this.g;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    protected abstract int k(V v);

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186837493")) {
            ipChange.ipc$dispatch("186837493", new Object[]{this});
            return;
        }
        this.p = new ArrayList();
        for (DayViewDecorator dayViewDecorator : this.o) {
            a aVar = new a();
            dayViewDecorator.decorate(aVar);
            if (aVar.o()) {
                this.p.add(new b(dayViewDecorator, aVar));
            }
        }
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setDayViewDecorators(this.p);
        }
    }

    protected abstract boolean n(Object obj);

    public CalendarPagerAdapter<?> o(CalendarPagerAdapter<?> calendarPagerAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-823510795")) {
            return (CalendarPagerAdapter) ipChange.ipc$dispatch("-823510795", new Object[]{this, calendarPagerAdapter});
        }
        calendarPagerAdapter.d = this.d;
        calendarPagerAdapter.e = this.e;
        calendarPagerAdapter.f = this.f;
        calendarPagerAdapter.g = this.g;
        calendarPagerAdapter.h = this.h;
        calendarPagerAdapter.i = this.i;
        calendarPagerAdapter.j = this.j;
        calendarPagerAdapter.l = this.l;
        calendarPagerAdapter.m = this.m;
        calendarPagerAdapter.n = this.n;
        calendarPagerAdapter.o = this.o;
        calendarPagerAdapter.p = this.p;
        calendarPagerAdapter.q = this.q;
        return calendarPagerAdapter;
    }

    public void p(CalendarDay calendarDay, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988346049")) {
            ipChange.ipc$dispatch("-1988346049", new Object[]{this, calendarDay, Boolean.valueOf(z)});
        } else if (z) {
            if (this.l.contains(calendarDay)) {
                return;
            }
            this.l.add(calendarDay);
            m();
        } else if (this.l.contains(calendarDay)) {
            this.l.remove(calendarDay);
            m();
        }
    }

    public void q(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915327554")) {
            ipChange.ipc$dispatch("1915327554", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
        } else {
            this.f = Integer.valueOf(i);
            Iterator<V> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setDateTextAppearance(i);
            }
        }
    }

    public void r(DayFormatter dayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573773298")) {
            ipChange.ipc$dispatch("1573773298", new Object[]{this, dayFormatter});
            return;
        }
        this.n = dayFormatter;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setDayFormatter(dayFormatter);
        }
    }

    public void s(List<DayViewDecorator> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167590745")) {
            ipChange.ipc$dispatch("1167590745", new Object[]{this, list});
            return;
        }
        this.o = list;
        l();
    }

    public void t(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122453048")) {
            ipChange.ipc$dispatch("2122453048", new Object[]{this, calendarDay, calendarDay2});
            return;
        }
        this.i = calendarDay;
        this.j = calendarDay2;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            V next = it.next();
            next.setMinimumDate(calendarDay);
            next.setMaximumDate(calendarDay2);
        }
        if (calendarDay == null) {
            calendarDay = CalendarDay.from(this.c.getYear() - 200, this.c.getMonth(), this.c.getDay());
        }
        if (calendarDay2 == null) {
            calendarDay2 = CalendarDay.from(this.c.getYear() + 200, this.c.getMonth(), this.c.getDay());
        }
        this.k = b(calendarDay, calendarDay2);
        notifyDataSetChanged();
        m();
    }

    public void u(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696152890")) {
            ipChange.ipc$dispatch("696152890", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.e = Integer.valueOf(i);
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setSelectionColor(i);
        }
    }

    public void v(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147273129")) {
            ipChange.ipc$dispatch("2147273129", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.q = z;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setSelectionEnabled(this.q);
        }
    }

    public void w(@MaterialCalendarView.ShowOtherDates int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-520881995")) {
            ipChange.ipc$dispatch("-520881995", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.h = i;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setShowOtherDates(i);
        }
    }

    public void x(@NonNull TitleFormatter titleFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "816996658")) {
            ipChange.ipc$dispatch("816996658", new Object[]{this, titleFormatter});
        } else {
            this.d = titleFormatter;
        }
    }

    public void y(WeekDayFormatter weekDayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273116942")) {
            ipChange.ipc$dispatch("-1273116942", new Object[]{this, weekDayFormatter});
            return;
        }
        this.m = weekDayFormatter;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setWeekDayFormatter(weekDayFormatter);
        }
    }

    public void z(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "732232530")) {
            ipChange.ipc$dispatch("732232530", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
        } else {
            this.g = Integer.valueOf(i);
            Iterator<V> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setWeekDayTextAppearance(i);
            }
        }
    }
}
