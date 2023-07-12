package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.calander.C6487a;
import com.taobao.android.dinamicx.widget.calander.Calendar;
import com.taobao.android.dinamicx.widget.calander.CalendarView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qt extends DXWidgetNode {
    public static final long DXCALENDARVIEW_ANCHORDATE = -8904535438500141309L;
    public static final long DXCALENDARVIEW_AUTOCHANGEMONTH = 8833414845409451796L;
    public static final long DXCALENDARVIEW_BEGINDATE = -1860805752639688564L;
    public static final long DXCALENDARVIEW_CALENDARITEMHEIGHT = -1496427289189049292L;
    public static final long DXCALENDARVIEW_CALENDARVIEW = 116344237634520001L;
    public static final long DXCALENDARVIEW_CURRENTDAYTEXTSIZE = -7647500290265887373L;
    public static final long DXCALENDARVIEW_DATETOPGAP = -5929381539273250573L;
    public static final long DXCALENDARVIEW_DAYTEXTGRAVITY = 262055229558107607L;
    public static final long DXCALENDARVIEW_DAYTEXTSIZE = -8982072168126024311L;
    public static final long DXCALENDARVIEW_DISABLEDDATES = 2788104028282969654L;
    public static final long DXCALENDARVIEW_ENDDATE = 4804791552104474556L;
    public static final long DXCALENDARVIEW_FONT = 34149272427L;
    public static final long DXCALENDARVIEW_HIGHLIGHTDATES = -4039211786071886953L;
    public static final long DXCALENDARVIEW_ONCHANGE = 5288679823228297259L;
    public static final long DXCALENDARVIEW_ONMONTHCHANGE = -5286047925153782218L;
    public static final long DXCALENDARVIEW_SCROLLABLE = 5099976257538233901L;
    public static final long DXCALENDARVIEW_SELECTEDDATE = 792202854466360275L;
    public static final long DXCALENDARVIEW_SELECTTEXTCOLOR = 2053814541299040819L;
    public static final long DXCALENDARVIEW_WEEKBARTEXTCOLOR = -3668263311141608587L;
    private String a;
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String i;
    private int j;
    private CalendarView k;
    private TextView l;
    private JSONArray m;
    private JSONObject n;
    private int q;
    private boolean b = true;
    private int h = -1;
    private int o = 0;
    private boolean p = true;
    private int r = -13421773;
    private final CalendarView.OnMonthChangeListener s = new C9624c();
    private final CalendarView.OnMonthUIRangeChangeListener t = new C9625d();

    /* compiled from: Taobao */
    /* renamed from: tb.qt$a */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC9622a implements View.OnClickListener {
        View$OnClickListenerC9622a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            qt.this.k.scrollToPre(true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.qt$b */
    /* loaded from: classes11.dex */
    class View$OnClickListenerC9623b implements View.OnClickListener {
        View$OnClickListenerC9623b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            qt.this.k.scrollToNext(true);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.qt$c */
    /* loaded from: classes11.dex */
    class C9624c implements CalendarView.OnMonthChangeListener {
        C9624c() {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnMonthChangeListener
        public void onMonthChange(int i, int i2) {
            qt.this.l.setText(String.format(Locale.getDefault(), "%d年%d月", Integer.valueOf(i), Integer.valueOf(i2)));
            qt.this.k.updateMonthArrowStatus();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.qt$d */
    /* loaded from: classes11.dex */
    class C9625d implements CalendarView.OnMonthUIRangeChangeListener {
        C9625d() {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnMonthUIRangeChangeListener
        public void onMonthUIRangeChange(Calendar calendar, String str, Pair<String, String> pair) {
            vz vzVar = new vz(qt.DXCALENDARVIEW_ONMONTHCHANGE);
            if (calendar != null) {
                vzVar.f("selectedDate", calendar.getDateString());
            }
            if (!TextUtils.isEmpty(str)) {
                vzVar.f("anchorDate", str);
            }
            if (pair != null) {
                vzVar.f("startDate", (String) pair.first);
                vzVar.f("endDate", (String) pair.second);
                qt.this.postEvent(vzVar);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.qt$e */
    /* loaded from: classes11.dex */
    public static class C9626e implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new qt();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.qt$f */
    /* loaded from: classes11.dex */
    private class C9627f implements CalendarView.OnCalendarSelectListener {
        private C9627f() {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnCalendarSelectListener
        public void onCalendarOutOfRange(Calendar calendar) {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnCalendarSelectListener
        public void onCalendarSelect(@NonNull Calendar calendar, boolean z) {
            if (z) {
                wz wzVar = new wz(5288679823228297259L);
                wzVar.f("selectedDate", calendar.getDateString());
                qt.this.postEvent(wzVar);
            }
        }

        /* synthetic */ C9627f(qt qtVar, View$OnClickListenerC9622a view$OnClickListenerC9622a) {
            this();
        }
    }

    private boolean c(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("(\\d{4})-((0[1-9])|(1[0-2]))-(([0-2][1-9])|3[0-1]|([1-2]0))", str);
    }

    private HashMap<String, Calendar> d() {
        String key;
        Calendar e;
        JSONObject jSONObject = this.n;
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        HashMap<String, Calendar> hashMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : this.n.entrySet()) {
            Object value = entry.getValue();
            if ((value instanceof JSONObject) && (e = e((key = entry.getKey()))) != null) {
                JSONObject jSONObject2 = (JSONObject) value;
                e.setBooked(jSONObject2.getBooleanValue("booked"));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("activityInfo");
                if (jSONObject3 != null) {
                    Calendar.C6483a c6483a = new Calendar.C6483a();
                    c6483a.a = jSONObject3.getString("title");
                    c6483a.b = jSONObject3.getString("color");
                    e.setCalendarInfo(c6483a);
                }
                hashMap.put(key, e);
            }
        }
        return hashMap;
    }

    private Calendar e(String str) {
        if (c(str)) {
            int parseInt = Integer.parseInt(str.substring(0, 4));
            int parseInt2 = Integer.parseInt(str.substring(5, 7));
            int parseInt3 = Integer.parseInt(str.substring(8, 10));
            Calendar calendar = new Calendar();
            calendar.setYear(parseInt);
            calendar.setMonth(parseInt2);
            calendar.setDay(parseInt3);
            return calendar;
        }
        return null;
    }

    private List<Pair<Calendar, Calendar>> f() {
        Calendar e;
        Calendar e2;
        JSONArray jSONArray = this.m;
        if (jSONArray == null || jSONArray.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.m.size(); i++) {
            String string = this.m.getString(i);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                if (split.length == 2 && (e = e(split[0])) != null && (e2 = e(split[1])) != null) {
                    arrayList.add(new Pair(e, e2));
                }
            }
        }
        return arrayList;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new qt();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode instanceof qt) {
            super.onClone(dXWidgetNode, z);
            qt qtVar = (qt) dXWidgetNode;
            this.j = qtVar.j;
            this.c = qtVar.c;
            this.e = qtVar.e;
            this.o = qtVar.o;
            this.f = qtVar.f;
            this.h = qtVar.h;
            this.i = qtVar.i;
            this.m = qtVar.m;
            this.n = qtVar.n;
            this.p = qtVar.p;
            this.b = qtVar.b;
            this.a = qtVar.a;
            this.g = qtVar.g;
            this.d = qtVar.d;
            this.q = qtVar.q;
            this.r = qtVar.r;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        View a = e10.a(context, R$layout.datepicker_widget);
        this.k = (CalendarView) a.findViewById(R$id.calendarView);
        this.l = (TextView) a.findViewById(R$id.tv_cur_month);
        int i = R$id.iv_left;
        ImageView imageView = (ImageView) a.findViewById(i);
        int i2 = R$id.iv_right;
        ImageView imageView2 = (ImageView) a.findViewById(i2);
        imageView.setOnClickListener(new View$OnClickListenerC9622a());
        imageView2.setOnClickListener(new View$OnClickListenerC9623b());
        int i3 = this.e;
        if (i3 != 0) {
            this.k.setDayTextSize(i3);
        }
        int i4 = this.d;
        if (i4 != 0) {
            this.k.setCurrentDayTextSize(i4);
        }
        this.k.setCalendarItemHeight(this.j);
        this.k.setOnMonthChangeListener(this.s);
        this.k.setOnMonthUIRangeChangeListener(this.t);
        a.setTag(R$id.dx_date_picker_view_tag, this.k);
        this.k.setTag(i, imageView);
        this.k.setTag(i2, imageView2);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) {
            super.onMeasure(i, i2);
            return;
        }
        int c = C6487a.c(getDXRuntimeContext().getContext(), 50.0f);
        int i3 = this.j;
        if (i3 <= 0) {
            i3 = C6487a.c(getDXRuntimeContext().getContext(), 56.0f);
        }
        setMeasuredDimension(i, c + C6487a.c(getDXRuntimeContext().getContext(), 40.0f) + this.q + (i3 * 6));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        super.onRenderView(context, view);
        if (view == null) {
            return;
        }
        if (this.k == null) {
            Object tag = view.getTag(R$id.dx_date_picker_view_tag);
            if (tag instanceof CalendarView) {
                this.k = (CalendarView) tag;
            }
        }
        this.k.setSelectedTextColor(this.h);
        this.k.setWeekBarTextColor(this.r);
        this.k.setDateTopGap(this.q);
        this.k.setDateTextGravity(this.o);
        this.k.setDateTextFont(this.g);
        this.k.setScrollable(this.p);
        this.k.setAutoChangeMonth(this.b);
        this.k.setOnCalendarSelectListener(new C9627f(this, null));
        Calendar e = e(this.c);
        Calendar e2 = e(this.f);
        Calendar e3 = e(this.a);
        List<Pair<Calendar, Calendar>> f = f();
        HashMap<String, Calendar> d = d();
        if (e != null) {
            int year = e.getYear();
            int month = e.getMonth();
            i3 = e.getDay();
            i = year;
            i2 = month;
        } else {
            i = 1971;
            i2 = 1;
            i3 = 1;
        }
        if (e2 != null) {
            int year2 = e2.getYear();
            int month2 = e2.getMonth();
            i4 = year2;
            i6 = e2.getDay();
            i5 = month2;
        } else {
            i4 = GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL;
            i5 = 12;
            i6 = -1;
        }
        this.k.setAnchorCalendar(e3);
        this.k.setRange(i, i2, i3, i4, i5, i6, f, d);
        if (e3 != null && this.k.isInRange(e3)) {
            this.k.scrollToCalendar(e3.getYear(), e3.getMonth(), e3.getDay(), false, false, false);
            return;
        }
        Calendar e4 = e(this.i);
        if (e4 != null && this.k.isInRange(e4)) {
            this.k.scrollToCalendar(e4.getYear(), e4.getMonth(), e4.getDay());
        } else {
            this.k.scrollToCalendar(i, i2, i3, false, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DXCALENDARVIEW_AUTOCHANGEMONTH) {
            this.b = i != 0;
        } else if (j == DXCALENDARVIEW_CALENDARITEMHEIGHT) {
            this.j = i;
        } else if (j == DXCALENDARVIEW_CURRENTDAYTEXTSIZE) {
            this.d = i;
        } else if (j == DXCALENDARVIEW_DATETOPGAP) {
            this.q = i;
        } else if (j == DXCALENDARVIEW_DAYTEXTGRAVITY) {
            this.o = i;
        } else if (j == DXCALENDARVIEW_DAYTEXTSIZE) {
            this.e = i;
        } else if (j == DXCALENDARVIEW_SELECTTEXTCOLOR) {
            this.h = i;
        } else if (j == DXCALENDARVIEW_SCROLLABLE) {
            this.p = i != 0;
        } else if (j == DXCALENDARVIEW_WEEKBARTEXTCOLOR) {
            this.r = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (j == DXCALENDARVIEW_DISABLEDDATES) {
            this.m = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetMapAttribute(long j, JSONObject jSONObject) {
        if (j == DXCALENDARVIEW_HIGHLIGHTDATES) {
            this.n = jSONObject;
        } else {
            super.onSetMapAttribute(j, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == DXCALENDARVIEW_ANCHORDATE) {
            this.a = str;
        } else if (j == DXCALENDARVIEW_BEGINDATE) {
            this.c = str;
        } else if (j == DXCALENDARVIEW_ENDDATE) {
            this.f = str;
        } else if (j == 34149272427L) {
            this.g = str;
        } else if (j == DXCALENDARVIEW_SELECTEDDATE) {
            this.i = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
