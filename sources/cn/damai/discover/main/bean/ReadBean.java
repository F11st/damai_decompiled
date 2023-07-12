package cn.damai.discover.main.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ReadBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String errorCode;
    public List<ReadModel> model;
    public String success;

    public ReadContent getFirstReadCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "780778014")) {
            return (ReadContent) ipChange.ipc$dispatch("780778014", new Object[]{this});
        }
        ReadModel firstReadModel = getFirstReadModel();
        if (firstReadModel != null) {
            return firstReadModel.getFirstReadContent();
        }
        return null;
    }

    public ReadModel getFirstReadModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1217502316")) {
            return (ReadModel) ipChange.ipc$dispatch("-1217502316", new Object[]{this});
        }
        if (cb2.d(this.model)) {
            return null;
        }
        return this.model.get(0);
    }

    public boolean isNoteRecommendValid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156059063")) {
            return ((Boolean) ipChange.ipc$dispatch("156059063", new Object[]{this})).booleanValue();
        }
        ReadModel firstReadModel = getFirstReadModel();
        if (firstReadModel != null) {
            boolean isNoteRecommend = firstReadModel.isNoteRecommend();
            ReadContent firstReadContent = firstReadModel.getFirstReadContent();
            if (isNoteRecommend && firstReadContent != null && firstReadContent.isValid()) {
                return true;
            }
        }
        return false;
    }

    public boolean success() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1125723492") ? ((Boolean) ipChange.ipc$dispatch("-1125723492", new Object[]{this})).booleanValue() : TextUtils.equals("true", this.success);
    }
}
