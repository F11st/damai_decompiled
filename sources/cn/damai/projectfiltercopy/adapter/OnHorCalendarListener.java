package cn.damai.projectfiltercopy.adapter;

import cn.damai.commonbusiness.calendarcopy.bean.Day;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface OnHorCalendarListener {
    void onCalendarClick(@NotNull Day day, @Nullable List<? extends Day> list);
}
