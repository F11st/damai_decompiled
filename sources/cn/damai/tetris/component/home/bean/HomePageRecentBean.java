package cn.damai.tetris.component.home.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.MarketTabBase;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.uikit.view.LiveRoomView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.m91;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomePageRecentBean extends CommonBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -4174322016424146871L;
    public List<Labels> content;
    public CustomLabel customLabel;
    public String mainTitle;
    public String moreText;
    private ArrayList<String> mLabels = new ArrayList<>();
    private Map<Integer, ArrayList<Labels.HomePageRecentItems>> mDataMap = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class CustomLabel implements Serializable {
        private static final long serialVersionUID = -6987384837742277697L;
        public String endDate;
        public String startDate;
        public String text;
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class Labels implements Serializable {
        private static final long serialVersionUID = 676302402815966694L;
        public ArrayList<HomePageRecentItems> items;
        public String labelName;
        public String labelType;

        /* compiled from: Taobao */
        /* loaded from: classes7.dex */
        public static class HomePageRecentItems extends MarketTabBase {
            private static transient /* synthetic */ IpChange $ipChange = null;
            private static final long serialVersionUID = 1548369244071853655L;
            public String alg;
            public String categoryName;
            public String desc;
            public String describeName;
            public String discountRate;
            public String guideSubCategoryName;
            public boolean isReferItem = false;
            public double itemScore;
            public String itemShowStyle;
            public double itemStar;
            public String liveStatus;
            public int position;
            public String priceLow;
            public String projectDatetime;
            public String projectId;
            public String projectName;
            public String projectPic;
            public String ranking;
            public String schema;
            public String scm;
            public TrackInfo trackInfo;
            public boolean wantSee;
            public String wantSeeCount;

            public String getCategoryNameCompat() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1834954773")) {
                    return (String) ipChange.ipc$dispatch("1834954773", new Object[]{this});
                }
                if (!TextUtils.isEmpty(this.guideSubCategoryName)) {
                    return this.guideSubCategoryName;
                }
                return this.categoryName;
            }

            public String getDesc() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1146093659")) {
                    return (String) ipChange.ipc$dispatch("1146093659", new Object[]{this});
                }
                if (!"2".equals(this.itemShowStyle) && !"1".equals(this.itemShowStyle)) {
                    return this.projectDatetime;
                }
                return this.desc;
            }

            public LiveRoomView.DMLiveRoomType getLiveType() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-572170783")) {
                    return (LiveRoomView.DMLiveRoomType) ipChange.ipc$dispatch("-572170783", new Object[]{this});
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
                if (AndroidInstantRuntime.support(ipChange, "290353009")) {
                    return ((Boolean) ipChange.ipc$dispatch("290353009", new Object[]{this})).booleanValue();
                }
                if (TextUtils.isEmpty(this.liveStatus)) {
                    return false;
                }
                return this.liveStatus.equals("2") || this.liveStatus.equals("1");
            }
        }
    }

    private Map<Integer, ArrayList<Labels.HomePageRecentItems>> parseDataMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450896672")) {
            return (Map) ipChange.ipc$dispatch("1450896672", new Object[]{this});
        }
        if (m91.a(this.content)) {
            return this.mDataMap;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < this.content.size(); i2++) {
            Labels labels = this.content.get(i2);
            if (labels != null && !TextUtils.isEmpty(labels.labelName) && wh2.e(labels.items) >= 4) {
                hashMap.put(Integer.valueOf(i), labels.items);
                i++;
            }
        }
        return hashMap;
    }

    private ArrayList<String> parseLabels() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287602264")) {
            return (ArrayList) ipChange.ipc$dispatch("-287602264", new Object[]{this});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (m91.a(this.content)) {
            return this.mLabels;
        }
        for (int i = 0; i < this.content.size(); i++) {
            Labels labels = this.content.get(i);
            if (labels != null && !TextUtils.isEmpty(labels.labelName) && wh2.e(labels.items) >= 4) {
                arrayList.add(labels.labelName);
            }
        }
        return arrayList;
    }

    private Map<Integer, ArrayList<Labels.HomePageRecentItems>> parseWantSeeDataMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102446381")) {
            return (Map) ipChange.ipc$dispatch("-1102446381", new Object[]{this});
        }
        if (m91.a(this.content)) {
            return this.mDataMap;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < this.content.size(); i2++) {
            Labels labels = this.content.get(i2);
            if (labels != null && !TextUtils.isEmpty(labels.labelName) && wh2.e(labels.items) >= 4) {
                Iterator<Labels.HomePageRecentItems> it = labels.items.iterator();
                while (it.hasNext()) {
                    it.next().itemShowStyle = labels.labelType;
                }
                hashMap.put(Integer.valueOf(i), labels.items);
                i++;
            }
        }
        return hashMap;
    }

    public ArrayList<String> getContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814538719")) {
            return (ArrayList) ipChange.ipc$dispatch("-1814538719", new Object[]{this});
        }
        if (wh2.e(this.mLabels) <= 0) {
            return parseLabels();
        }
        return this.mLabels;
    }

    public Map<Integer, ArrayList<Labels.HomePageRecentItems>> getDataMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "403784195")) {
            return (Map) ipChange.ipc$dispatch("403784195", new Object[]{this});
        }
        Map<Integer, ArrayList<Labels.HomePageRecentItems>> map = this.mDataMap;
        if (map != null && map.size() > 0) {
            return this.mDataMap;
        }
        return parseDataMap();
    }

    public Map<Integer, ArrayList<Labels.HomePageRecentItems>> getWantSeeDataMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "660076176")) {
            return (Map) ipChange.ipc$dispatch("660076176", new Object[]{this});
        }
        Map<Integer, ArrayList<Labels.HomePageRecentItems>> map = this.mDataMap;
        if (map != null && map.size() > 0) {
            return this.mDataMap;
        }
        return parseWantSeeDataMap();
    }
}
