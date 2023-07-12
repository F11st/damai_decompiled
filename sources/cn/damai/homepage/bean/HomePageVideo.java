package cn.damai.homepage.bean;

import android.text.TextUtils;
import cn.damai.uikit.view.LiveRoomView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageVideo implements Serializable {
    public List<HomePageVideoItem> content;
    public String mainTitle;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class HomePageVideoItem {
        private static transient /* synthetic */ IpChange $ipChange;
        public String categoryName;
        public int index;
        public boolean isPlay;
        public String liveStatus;
        public String priceLow;
        public String projectId;
        public String projectName;
        public String projectPic;
        public String schema;
        public String vId;
        public String vPic;

        public LiveRoomView.DMLiveRoomType getLiveType() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "497283802")) {
                return (LiveRoomView.DMLiveRoomType) ipChange.ipc$dispatch("497283802", new Object[]{this});
            }
            if (!TextUtils.isEmpty(this.liveStatus)) {
                if (this.liveStatus.equals("2")) {
                    return LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE;
                }
                if (this.liveStatus.equals("1")) {
                    return LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT;
                }
            }
            return LiveRoomView.DMLiveRoomType.TAG_TYPE_INIT;
        }

        public boolean isLiveRoom() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-46603944")) {
                return ((Boolean) ipChange.ipc$dispatch("-46603944", new Object[]{this})).booleanValue();
            }
            if (TextUtils.isEmpty(this.liveStatus)) {
                return false;
            }
            return this.liveStatus.equals("2") || this.liveStatus.equals("1");
        }
    }
}
