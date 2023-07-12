package cn.damai.commonbusiness.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class UserAttentionBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private DataBean data;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class DataBean {
        private static transient /* synthetic */ IpChange $ipChange;
        private int status;

        public int getStatus() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-388508490") ? ((Integer) ipChange.ipc$dispatch("-388508490", new Object[]{this})).intValue() : this.status;
        }

        public void setStatus(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1615299756")) {
                ipChange.ipc$dispatch("1615299756", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.status = i;
            }
        }
    }

    public DataBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "773517698") ? (DataBean) ipChange.ipc$dispatch("773517698", new Object[]{this}) : this.data;
    }

    public void setData(DataBean dataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175538674")) {
            ipChange.ipc$dispatch("1175538674", new Object[]{this, dataBean});
        } else {
            this.data = dataBean;
        }
    }
}
