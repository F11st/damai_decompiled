package cn.damai.uikit.calendar;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes17.dex */
public enum CalendarMode {
    MONTHS(6),
    MONTHS_LABEL(5),
    MONTHS_CATEGORY(5),
    WEEKS(1);
    
    final int visibleWeeksCount;

    CalendarMode(int i) {
        this.visibleWeeksCount = i;
    }
}
