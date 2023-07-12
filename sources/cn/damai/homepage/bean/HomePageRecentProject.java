package cn.damai.homepage.bean;

import android.text.TextUtils;
import cn.damai.uikit.view.LiveRoomView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageRecentProject implements Serializable {
    public CustomLabel customLabel;
    public List<Labels> labels;
    public String mainTitle;
    public String moreText;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class CustomLabel implements Serializable {
        public String endDate;
        public String startDate;
        public String text;
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class Labels implements Serializable {
        public ArrayList<HomePageRecentItems> items;
        public String label;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class HomePageRecentItems implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange;
            public String alg;
            public String categoryName;
            public String discountRate;
            public double itemScore;
            public double itemStar;
            public String liveStatus;
            public int position;
            public String priceLow;
            public String projectDatetime;
            public String projectId;
            public String projectName;
            public String projectPic;
            public String schema;
            public String scm;

            public LiveRoomView.DMLiveRoomType getLiveType() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-675331869")) {
                    return (LiveRoomView.DMLiveRoomType) ipChange.ipc$dispatch("-675331869", new Object[]{this});
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
                if (AndroidInstantRuntime.support(ipChange, "140171311")) {
                    return ((Boolean) ipChange.ipc$dispatch("140171311", new Object[]{this})).booleanValue();
                }
                if (TextUtils.isEmpty(this.liveStatus)) {
                    return false;
                }
                return this.liveStatus.equals("2") || this.liveStatus.equals("1");
            }
        }
    }
}
