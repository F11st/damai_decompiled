package cn.damai.mine.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class UserCenterDynamicMenu implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<DynamicMenuItem> itemList;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class DynamicMenuItem implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String bubbleText;
        public String iconUrl;
        public String targetUrl;
        public String title;

        public String getBubbleText() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1440640249") ? (String) ipChange.ipc$dispatch("-1440640249", new Object[]{this}) : this.bubbleText;
        }

        public String getIconUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "240357374") ? (String) ipChange.ipc$dispatch("240357374", new Object[]{this}) : this.iconUrl;
        }

        public String getTargetUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-878488410") ? (String) ipChange.ipc$dispatch("-878488410", new Object[]{this}) : this.targetUrl;
        }

        public String getTitle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-782674336") ? (String) ipChange.ipc$dispatch("-782674336", new Object[]{this}) : this.title;
        }

        public void setTitle(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-296700394")) {
                ipChange.ipc$dispatch("-296700394", new Object[]{this, str});
            } else {
                this.title = str;
            }
        }
    }

    public List<DynamicMenuItem> getItemList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "425959929") ? (List) ipChange.ipc$dispatch("425959929", new Object[]{this}) : this.itemList;
    }
}
