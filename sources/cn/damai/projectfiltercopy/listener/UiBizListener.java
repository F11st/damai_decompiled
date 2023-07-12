package cn.damai.projectfiltercopy.listener;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.Type;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface UiBizListener {
    void onFastFilterChanged(List<FilterBean> list);

    void onHorCalendarChanged(List<Day> list, @Nullable List<Day> list2, boolean z);

    void onMainFilterChanged(Type type);
}
