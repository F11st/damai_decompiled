package cn.damai.category.discountticket.bean.biz;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.o90;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Column3WrapBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PROJECT_COUNT_PER_ROW = 3;
    public List<ProjectItemBean> list;

    private int getProjectCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "633689292") ? ((Integer) ipChange.ipc$dispatch("633689292", new Object[]{this})).intValue() : wh2.e(this.list);
    }

    public static List<Column3WrapBean> toAdapterList(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685334243")) {
            return (List) ipChange.ipc$dispatch("685334243", new Object[]{list});
        }
        Column3WrapBean column3WrapBean = null;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (i % 3 == 0) {
                column3WrapBean = new Column3WrapBean();
                column3WrapBean.list = new ArrayList();
                arrayList.add(column3WrapBean);
            }
            column3WrapBean.list.add(list.get(i));
        }
        return arrayList;
    }

    public List<ProjectItemBean> supply(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-416576224")) {
            return (List) ipChange.ipc$dispatch("-416576224", new Object[]{this, list});
        }
        int projectCount = getProjectCount();
        if (projectCount < 3) {
            if (this.list == null) {
                this.list = new ArrayList();
            }
            if (!o90.b(list)) {
                int min = Math.min(3 - projectCount, list.size());
                for (int i = 0; i < min; i++) {
                    this.list.add(list.get(i));
                }
                if (this.list.size() > 0) {
                    for (int i2 = 0; i2 < this.list.size(); i2++) {
                        list.remove(this.list.get(i2));
                    }
                }
            }
        }
        return list;
    }
}
