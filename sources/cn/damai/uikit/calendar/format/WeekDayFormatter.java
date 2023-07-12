package cn.damai.uikit.calendar.format;

import tb.qf;
import tb.sf;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface WeekDayFormatter {
    public static final WeekDayFormatter DEFAULT = new sf(qf.d());

    CharSequence format(int i);
}
