package cn.damai.search.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchEggs implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String backgroundPic;
    public String comboDispatchId;
    public String comboDispatchSystem;
    public long currentTime;
    public List<SearchEggHeader> header;
    public List<ProjectItemBean> projectInfo;
    public String type;
    public String url;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class SearchEggHeader implements Serializable {
        public String pic;
        public String url;
    }

    public boolean isTypeJumpPage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-463030263") ? ((Boolean) ipChange.ipc$dispatch("-463030263", new Object[]{this})).booleanValue() : TextUtils.equals("2", this.type);
    }

    public boolean isTypeShowList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-215671317") ? ((Boolean) ipChange.ipc$dispatch("-215671317", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.type);
    }

    public boolean isValidType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1449389724") ? ((Boolean) ipChange.ipc$dispatch("1449389724", new Object[]{this})).booleanValue() : isTypeJumpPage() || isTypeShowList();
    }
}
