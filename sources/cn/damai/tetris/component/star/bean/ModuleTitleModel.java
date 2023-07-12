package cn.damai.tetris.component.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ModuleTitleModel {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<OperationBean> opList;
    public String title;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class OperationBean {
        public int moduleId;
        public String opName;
        public String opUrl;
    }

    public static ModuleTitleModel create(String str, List<OperationBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231132825")) {
            return (ModuleTitleModel) ipChange.ipc$dispatch("1231132825", new Object[]{str, list});
        }
        ModuleTitleModel moduleTitleModel = new ModuleTitleModel();
        moduleTitleModel.title = str;
        moduleTitleModel.opList = list;
        return moduleTitleModel;
    }
}
