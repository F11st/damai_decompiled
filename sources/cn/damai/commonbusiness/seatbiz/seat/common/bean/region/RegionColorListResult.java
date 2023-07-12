package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import mtopsdk.mtop.domain.BaseOutDo;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionColorListResult extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    public RegionColorList data;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class RegionColorList implements Serializable {
        public HashMap<String, ArrayList<RegionColor>> standColor;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public static class RegionColor implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange;
            public String color;
            public boolean maxPrice;
            public String priceId;
            public float priceValue;
            public String status;

            /* compiled from: Taobao */
            /* loaded from: classes.dex */
            public static class RegionColorCompartor implements Comparator<RegionColor> {
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.util.Comparator
                public int compare(RegionColor regionColor, RegionColor regionColor2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1767064139")) {
                        return ((Integer) ipChange.ipc$dispatch("-1767064139", new Object[]{this, regionColor, regionColor2})).intValue();
                    }
                    if (regionColor == null || regionColor2 == null) {
                        return 0;
                    }
                    return (int) (regionColor2.priceValue - regionColor.priceValue);
                }
            }

            public String getFormatColor() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-228958437")) {
                    return (String) ipChange.ipc$dispatch("-228958437", new Object[]{this});
                }
                if (TextUtils.isEmpty(this.color)) {
                    return null;
                }
                if (!this.color.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                    return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.color;
                }
                return this.color;
            }
        }
    }

    public boolean hasValidSeat() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "24407556")) {
            return ((Boolean) ipChange.ipc$dispatch("24407556", new Object[]{this})).booleanValue();
        }
        RegionColorList regionColorList = this.data;
        if (regionColorList == null) {
            return false;
        }
        HashMap<String, ArrayList<RegionColorList.RegionColor>> hashMap = regionColorList.standColor;
        if (hashMap == null || hashMap.size() <= 0) {
            i = 0;
        } else {
            i = 0;
            for (String str : hashMap.keySet()) {
                if (!cb2.d(hashMap.get(str))) {
                    i++;
                }
            }
        }
        return i > 0;
    }

    public void updateRegionState(List<RegionState> list) {
        HashMap<String, ArrayList<RegionColorList.RegionColor>> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312061216")) {
            ipChange.ipc$dispatch("312061216", new Object[]{this, list});
        } else if (!cb2.d(list)) {
            ArrayList arrayList = new ArrayList();
            RegionColorList regionColorList = this.data;
            if (regionColorList != null && (hashMap = regionColorList.standColor) != null && hashMap.size() > 0) {
                HashMap<String, ArrayList<RegionColorList.RegionColor>> hashMap2 = this.data.standColor;
                for (String str : hashMap2.keySet()) {
                    if (!cb2.d(hashMap2.get(str))) {
                        arrayList.add(str);
                    }
                }
            }
            for (RegionState regionState : list) {
                StringBuilder sb = new StringBuilder();
                sb.append(regionState.id);
                sb.append("");
                regionState.state = arrayList.contains(sb.toString()) ? 1 : 0;
            }
        }
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public RegionColorList getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1348329857") ? (RegionColorList) ipChange.ipc$dispatch("1348329857", new Object[]{this}) : this.data;
    }
}
