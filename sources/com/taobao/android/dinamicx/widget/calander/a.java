package com.taobao.android.dinamicx.widget.calander;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import com.taobao.android.dinamicx.widget.calander.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class a {
    public static int a(int i, int i2, int i3, int i4, int i5, int i6) {
        Calendar calendar = new Calendar();
        calendar.setYear(i);
        calendar.setMonth(i2);
        calendar.setDay(i3);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(i4);
        calendar2.setMonth(i5);
        calendar2.setDay(i6);
        return calendar.compareTo(calendar2);
    }

    public static int b(Calendar calendar, Calendar calendar2) {
        if (calendar == null) {
            return Integer.MIN_VALUE;
        }
        if (calendar2 == null) {
            return Integer.MAX_VALUE;
        }
        java.util.Calendar calendar3 = java.util.Calendar.getInstance();
        calendar3.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0, 0);
        long timeInMillis = calendar3.getTimeInMillis();
        calendar3.set(calendar2.getYear(), calendar2.getMonth() - 1, calendar2.getDay(), 12, 0, 0);
        return (int) ((timeInMillis - calendar3.getTimeInMillis()) / 86400000);
    }

    public static int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"SimpleDateFormat"})
    public static int d(String str, Date date) {
        return Integer.parseInt(new SimpleDateFormat(str).format(date));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar e(int i, b bVar) {
        Calendar calendar = new Calendar();
        boolean z = true;
        calendar.setYear((((bVar.v() + i) - 1) / 12) + bVar.t());
        calendar.setMonth((((i + bVar.v()) - 1) % 12) + 1);
        if (bVar.m() != 0) {
            int g = g(calendar.getYear(), calendar.getMonth());
            Calendar calendar2 = bVar.M;
            if (calendar2 == null || calendar2.getDay() == 0) {
                g = 1;
            } else if (g >= calendar2.getDay()) {
                g = calendar2.getDay();
            }
            calendar.setDay(g);
        } else {
            calendar.setDay(1);
        }
        if (!q(calendar, bVar)) {
            if (t(calendar, bVar)) {
                calendar = bVar.s();
            } else {
                calendar = bVar.o();
            }
        }
        calendar.setCurrentMonth((calendar.getYear() == bVar.g().getYear() && calendar.getMonth() == bVar.g().getMonth()) ? false : false);
        calendar.setCurrentDay(calendar.equals(bVar.g()));
        return calendar;
    }

    public static String f(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("-");
        sb.append(i2 < 10 ? "0" : "");
        sb.append(i2);
        sb.append("-01");
        return sb.toString();
    }

    public static int g(int i, int i2) {
        int i3 = (i2 == 1 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 10 || i2 == 12) ? 31 : 0;
        return i2 == 2 ? s(i) ? 29 : 28 : (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 30;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, int i2, int i3) {
        return i(i, i2, g(i, i2), i3);
    }

    private static int i(int i, int i2, int i3, int i4) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(i, i2 - 1, i3);
        int i5 = calendar.get(7);
        if (i4 == 1) {
            return 7 - i5;
        }
        if (i4 == 2) {
            if (i5 == 1) {
                return 0;
            }
            return (7 - i5) + 1;
        } else if (i5 == 7) {
            return 6;
        } else {
            return (7 - i5) - 1;
        }
    }

    public static int j(int i, int i2, int i3, int i4) {
        java.util.Calendar.getInstance().set(i, i2 - 1, 1, 12, 0, 0);
        int l = l(i, i2, i4);
        int g = g(i, i2);
        return (((l + g) + i(i, i2, g, i4)) / 7) * i3;
    }

    public static int k(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? i3 * 6 : j(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(int i, int i2, int i3) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(i, i2 - 1, 1, 12, 0, 0);
        int i4 = calendar.get(7);
        if (i3 == 1) {
            return i4 - 1;
        }
        if (i3 == 2) {
            if (i4 == 1) {
                return 6;
            }
            return i4 - i3;
        } else if (i4 == 7) {
            return 0;
        } else {
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar m(Calendar calendar, b bVar) {
        if (q(bVar.g(), bVar) && bVar.m() != 2) {
            return bVar.a();
        }
        if (q(calendar, bVar)) {
            return calendar;
        }
        if (bVar.s().isSameMonth(calendar)) {
            return bVar.s();
        }
        return bVar.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Calendar> n(int i, int i2, b bVar) {
        int g;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i2 - 1;
        java.util.Calendar.getInstance().set(i, i7, 1);
        int l = l(i, i2, bVar.E());
        int g2 = g(i, i2);
        ArrayList arrayList = new ArrayList();
        int i8 = 12;
        if (i2 == 1) {
            i3 = i - 1;
            int i9 = i2 + 1;
            g = l == 0 ? 0 : g(i3, 12);
            i4 = i9;
            i5 = i;
        } else if (i2 == 12) {
            i5 = i + 1;
            g = l == 0 ? 0 : g(i, i7);
            i4 = 1;
            i8 = i7;
            i3 = i;
        } else {
            int i10 = i2 + 1;
            i8 = i7;
            g = l == 0 ? 0 : g(i, i7);
            i3 = i;
            i4 = i10;
            i5 = i3;
        }
        Calendar[] calendarArr = new Calendar[2];
        int i11 = 0;
        int i12 = 1;
        while (i11 < 42) {
            Calendar calendar = new Calendar();
            if (i11 < l) {
                calendar.setYear(i3);
                calendar.setMonth(i8);
                i6 = i3;
                calendar.setDay((g - l) + i11 + 1);
            } else {
                i6 = i3;
                if (i11 >= g2 + l) {
                    calendar.setYear(i5);
                    calendar.setMonth(i4);
                    calendar.setDay(i12);
                    i12++;
                } else {
                    calendar.setYear(i);
                    calendar.setMonth(i2);
                    calendar.setCurrentMonth(true);
                    calendar.setDay((i11 - l) + 1);
                }
            }
            if (calendar.equals(bVar.g())) {
                calendar.setCurrentDay(true);
            }
            u(calendar, bVar);
            v(i11 % 7 == 0 ? null : (Calendar) arrayList.get(i11 - 1), calendar);
            arrayList.add(calendar);
            if (i11 == 0) {
                calendarArr[0] = calendar;
            } else if (i11 == 41) {
                calendarArr[1] = calendar;
            }
            i11++;
            i3 = i6;
        }
        bVar.L(i, i2, calendarArr[0], calendarArr[1]);
        return arrayList;
    }

    static boolean o(Calendar calendar, List<Pair<Calendar, Calendar>> list) {
        if (list == null) {
            return false;
        }
        for (Pair<Calendar, Calendar> pair : list) {
            if (calendar.compareTo((Calendar) pair.first) >= 0 && calendar.compareTo((Calendar) pair.second) <= 0) {
                return true;
            }
        }
        return false;
    }

    static boolean p(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6) {
        if (calendar == null) {
            return false;
        }
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(i, i2 - 1, i3);
        long timeInMillis = calendar2.getTimeInMillis();
        calendar2.set(i4, i5 - 1, i6);
        long timeInMillis2 = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        long timeInMillis3 = calendar2.getTimeInMillis();
        return timeInMillis3 >= timeInMillis && timeInMillis3 <= timeInMillis2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q(Calendar calendar, b bVar) {
        return p(calendar, bVar.t(), bVar.v(), bVar.u(), bVar.p(), bVar.r(), bVar.q()) && !o(calendar, bVar.n());
    }

    public static boolean r(List<Pair<Calendar, Calendar>> list) {
        if (list == null) {
            return false;
        }
        for (Pair<Calendar, Calendar> pair : list) {
            if (((Calendar) pair.second).compareTo((Calendar) pair.first) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(int i) {
        return (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
    }

    private static boolean t(Calendar calendar, b bVar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(bVar.t(), bVar.v() - 1, bVar.u(), 12, 0);
        long timeInMillis = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0);
        return calendar2.getTimeInMillis() < timeInMillis;
    }

    static void u(Calendar calendar, b bVar) {
        HashMap<String, Calendar> c;
        Calendar calendar2;
        if (!q(calendar, bVar) || (c = bVar.c()) == null) {
            return;
        }
        String dateString = calendar.getDateString();
        if (!c.containsKey(dateString) || (calendar2 = c.get(dateString)) == null) {
            return;
        }
        calendar.setBooked(calendar2.isBooked());
        calendar.setCalendarInfo(calendar2.getCalendarInfo());
    }

    static void v(Calendar calendar, Calendar calendar2) {
        boolean z = calendar != null && calendar.containHighLightCalendarInfo();
        boolean containHighLightCalendarInfo = calendar2.containHighLightCalendarInfo();
        if (!z) {
            if (containHighLightCalendarInfo) {
                calendar2.setRoundRectType(containHighLightCalendarInfo ? Calendar.RoundRectType.ALL : Calendar.RoundRectType.NONE);
            }
        } else if (containHighLightCalendarInfo) {
            if (calendar.getRoundRectType() == Calendar.RoundRectType.ALL) {
                calendar.setRoundRectType(Calendar.RoundRectType.LEFT);
            } else if (calendar.getRoundRectType() == Calendar.RoundRectType.RIGHT) {
                calendar.setRoundRectType(Calendar.RoundRectType.NONE);
            }
            calendar2.setRoundRectType(Calendar.RoundRectType.RIGHT);
        }
    }
}
