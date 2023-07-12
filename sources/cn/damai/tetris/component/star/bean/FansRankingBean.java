package cn.damai.tetris.component.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class FansRankingBean implements Serializable {
    public boolean artistVip;
    public String assetId;
    public ButtonBean button;
    public boolean damaiVip;
    public String headPic;
    public String nickName;
    public String rankingDetailUrl;
    public String rankingMoreLinkDesc;
    public String rankingUrl;
    public List<TaskBean> task;
    public int type;
    public String vipDesc;
    public long score = -1;
    public long rank = -1;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class ButtonBean implements Serializable {
        public String destination;
        public String name;
        public int type;

        public ButtonBean() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class TaskBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public int applyStatus;
        public boolean canClick;
        public String dataId;
        public String desc;
        public String name;
        public String taskId;
        public int type;
        public String url;

        public TaskBean() {
        }

        public boolean isGuardTask() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1415899913") ? ((Boolean) ipChange.ipc$dispatch("-1415899913", new Object[]{this})).booleanValue() : this.type == 1;
        }

        public boolean isShareTask() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-533533059") ? ((Boolean) ipChange.ipc$dispatch("-533533059", new Object[]{this})).booleanValue() : this.type == 2;
        }
    }
}
