package cn.damai.discover.main.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ReadModel {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<ReadContent> contentList;
    public String type;

    public ReadContent getFirstReadContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605044537")) {
            return (ReadContent) ipChange.ipc$dispatch("-1605044537", new Object[]{this});
        }
        if (cb2.d(this.contentList)) {
            return null;
        }
        return this.contentList.get(0);
    }

    public boolean isNoteRecommend() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1167480846") ? ((Boolean) ipChange.ipc$dispatch("-1167480846", new Object[]{this})).booleanValue() : TextUtils.equals("2", this.type);
    }
}
