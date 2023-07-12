package cn.damai.uikit.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Date;
import tb.qf;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public final class CalendarDay implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CalendarDay> CREATOR = new C2480a();
    private transient Calendar _calendar;
    private transient Date _date;
    private final int day;
    private final int month;
    private boolean weekEnd;
    private final int year;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.calendar.CalendarDay$a */
    /* loaded from: classes17.dex */
    public static final class C2480a implements Parcelable.Creator<CalendarDay> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2480a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CalendarDay createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1578657511") ? (CalendarDay) ipChange.ipc$dispatch("-1578657511", new Object[]{this, parcel}) : new CalendarDay(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CalendarDay[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1392526288") ? (CalendarDay[]) ipChange.ipc$dispatch("-1392526288", new Object[]{this, Integer.valueOf(i)}) : new CalendarDay[i];
        }
    }

    @Deprecated
    public CalendarDay() {
        this(qf.d());
    }

    @NonNull
    public static CalendarDay from(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "100884471") ? (CalendarDay) ipChange.ipc$dispatch("100884471", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) : new CalendarDay(i, i2, i3);
    }

    private static int hashCode(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1348066337") ? ((Integer) ipChange.ipc$dispatch("-1348066337", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue() : (i * 10000) + (i2 * 100) + i3;
    }

    @NonNull
    public static CalendarDay today() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-634557421") ? (CalendarDay) ipChange.ipc$dispatch("-634557421", new Object[0]) : from(qf.d());
    }

    public void copyTo(@NonNull Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470619245")) {
            ipChange.ipc$dispatch("-470619245", new Object[]{this, calendar});
            return;
        }
        calendar.clear();
        calendar.set(this.year, this.month, this.day);
    }

    void copyToMonthOnly(@NonNull Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019039507")) {
            ipChange.ipc$dispatch("-2019039507", new Object[]{this, calendar});
            return;
        }
        calendar.clear();
        calendar.set(this.year, this.month, 1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400780000")) {
            return ((Integer) ipChange.ipc$dispatch("-1400780000", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772625005")) {
            return ((Boolean) ipChange.ipc$dispatch("-772625005", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || CalendarDay.class != obj.getClass()) {
            return false;
        }
        CalendarDay calendarDay = (CalendarDay) obj;
        return this.day == calendarDay.day && this.month == calendarDay.month && this.year == calendarDay.year;
    }

    @NonNull
    public Calendar getCalendar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159738141")) {
            return (Calendar) ipChange.ipc$dispatch("-1159738141", new Object[]{this});
        }
        if (this._calendar == null) {
            Calendar d = qf.d();
            this._calendar = d;
            copyTo(d);
        }
        return this._calendar;
    }

    @NonNull
    public Date getDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065996957")) {
            return (Date) ipChange.ipc$dispatch("-2065996957", new Object[]{this});
        }
        if (this._date == null) {
            this._date = getCalendar().getTime();
        }
        return this._date;
    }

    public int getDay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1567722079") ? ((Integer) ipChange.ipc$dispatch("1567722079", new Object[]{this})).intValue() : this.day;
    }

    public int getMonth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1145051195") ? ((Integer) ipChange.ipc$dispatch("1145051195", new Object[]{this})).intValue() : this.month;
    }

    public boolean getWeekEnd() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "973442149") ? ((Boolean) ipChange.ipc$dispatch("973442149", new Object[]{this})).booleanValue() : this.weekEnd;
    }

    public int getYear() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1387960232") ? ((Integer) ipChange.ipc$dispatch("-1387960232", new Object[]{this})).intValue() : this.year;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1371154250") ? ((Integer) ipChange.ipc$dispatch("1371154250", new Object[]{this})).intValue() : hashCode(this.year, this.month, this.day);
    }

    public boolean isAfter(@NonNull CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303577322")) {
            return ((Boolean) ipChange.ipc$dispatch("303577322", new Object[]{this, calendarDay})).booleanValue();
        }
        if (calendarDay != null) {
            int i = this.year;
            int i2 = calendarDay.year;
            if (i != i2) {
                return i > i2;
            }
            int i3 = this.month;
            int i4 = calendarDay.month;
            if (i3 == i4) {
                if (this.day > calendarDay.day) {
                    return true;
                }
            } else if (i3 > i4) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("other cannot be null");
    }

    public boolean isBefore(@NonNull CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123053241")) {
            return ((Boolean) ipChange.ipc$dispatch("-1123053241", new Object[]{this, calendarDay})).booleanValue();
        }
        if (calendarDay != null) {
            int i = this.year;
            int i2 = calendarDay.year;
            if (i != i2) {
                return i < i2;
            }
            int i3 = this.month;
            int i4 = calendarDay.month;
            if (i3 == i4) {
                if (this.day < calendarDay.day) {
                    return true;
                }
            } else if (i3 < i4) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("other cannot be null");
    }

    public boolean isInRange(@Nullable CalendarDay calendarDay, @Nullable CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1317587694") ? ((Boolean) ipChange.ipc$dispatch("1317587694", new Object[]{this, calendarDay, calendarDay2})).booleanValue() : (calendarDay == null || !calendarDay.isAfter(this)) && (calendarDay2 == null || !calendarDay2.isBefore(this));
    }

    public void setWeekEnd(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659755001")) {
            ipChange.ipc$dispatch("-1659755001", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.weekEnd = z;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364862470")) {
            return (String) ipChange.ipc$dispatch("-1364862470", new Object[]{this});
        }
        return "CalendarDay{" + this.year + "-" + this.month + "-" + this.day + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196484523")) {
            ipChange.ipc$dispatch("196484523", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
        parcel.writeInt(this.day);
    }

    @Deprecated
    public CalendarDay(Calendar calendar) {
        this(qf.g(calendar), qf.f(calendar), qf.b(calendar));
    }

    public static CalendarDay from(@Nullable Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1681508853")) {
            return (CalendarDay) ipChange.ipc$dispatch("1681508853", new Object[]{calendar});
        }
        if (calendar == null) {
            return null;
        }
        return from(qf.g(calendar), qf.f(calendar), qf.b(calendar));
    }

    @Deprecated
    public CalendarDay(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public static CalendarDay from(@Nullable Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1882700027")) {
            return (CalendarDay) ipChange.ipc$dispatch("-1882700027", new Object[]{date});
        }
        if (date == null) {
            return null;
        }
        return from(qf.e(date));
    }

    @Deprecated
    public CalendarDay(Date date) {
        this(qf.e(date));
    }

    public CalendarDay(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
