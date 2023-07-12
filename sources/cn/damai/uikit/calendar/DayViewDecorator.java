package cn.damai.uikit.calendar;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface DayViewDecorator {
    void decorate(a aVar);

    boolean shouldDecorate(CalendarDay calendarDay);

    boolean updateFacade();

    String updateFacadeDesc(CalendarDay calendarDay);
}
