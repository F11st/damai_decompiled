package cn.damai.tetris.component.common.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BaseTabResultItem implements Serializable {
    public String tabIconUrl;
    public List<BaseTabListItem> tabList;
    public List<BaseTabBtn> tabMores;
    public String tabName;
    public TabStyle tabStyle;
    public String tabType;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class BaseTabBtn implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 5109143246824994867L;
        public String btnAction;
        public String btnName;

        public boolean isValid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "319787735") ? ((Boolean) ipChange.ipc$dispatch("319787735", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.btnName) || TextUtils.isEmpty(this.btnName)) ? false : true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public enum CMSTabTypeEnum {
        PROJECT("项目"),
        RANKING("榜单");

        CMSTabTypeEnum(String str) {
        }
    }
}
