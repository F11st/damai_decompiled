package cn.damai.commonbusiness.wannasee.bean;

import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class FeedBean<T> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_USER_EMPTY_FEED = 3;
    public static final int TYPE_USER_NOTE = 2;
    public static final int TYPE_USER_PUBLISH = 1;
    public final T bean;
    public final int viewType;

    public FeedBean(int i, T t) {
        this.viewType = i;
        this.bean = t;
    }

    public static List<FeedBean> transfer(List<NoteBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923009591")) {
            return (List) ipChange.ipc$dispatch("-1923009591", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (NoteBean noteBean : list) {
            arrayList.add(new FeedBean(2, noteBean));
        }
        return arrayList;
    }
}
