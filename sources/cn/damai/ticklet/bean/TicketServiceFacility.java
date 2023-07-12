package cn.damai.ticklet.bean;

import android.text.TextUtils;
import cn.damai.member.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketServiceFacility implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CONVENINCE_STORE = "便利店";
    public static final String EXCHANGE_SITE = "取票点";
    public static final String FINE_FOOD = "美食小吃";
    public static final String PARKING = "停车场";
    public static final String PUBLIC_TRANSIT = "公共交通";
    public static final String SHOP_MALL = "商场";
    public static final int TICKLET_VENUE_CONVENICE_STORE = 4;
    public static final int TICKLET_VENUE_FINE_FOOD = 2;
    public static final int TICKLET_VENUE_PARK = 1;
    public static final int TICKLET_VENUE_SHOP_MALL = 5;
    public static final int TICKLET_VENUE_TOILET = 3;
    public static final int TICKLET_VENUE_TRAFFIC = 0;
    public static final int TICKLET_VENUE_VENUE_TITLE = 100;
    public static final String TOILET = "洗手间";
    private static final long serialVersionUID = 1;
    public String icon;
    public int iconFontId;
    public String link;
    public String name;
    public int type;

    public TicketServiceFacility() {
    }

    public static List<TicketServiceFacility> getFixedService() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871232438")) {
            return (List) ipChange.ipc$dispatch("-871232438", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TicketServiceFacility(PUBLIC_TRANSIT, R$string.iconfont_transportation, 0));
        arrayList.add(new TicketServiceFacility(PARKING, R$string.iconfont_parking, 1));
        arrayList.add(new TicketServiceFacility(FINE_FOOD, R$string.iconfont_Dining, 2));
        arrayList.add(new TicketServiceFacility(TOILET, R$string.iconfont_washroom, 3));
        arrayList.add(new TicketServiceFacility(CONVENINCE_STORE, R$string.iconfont_shop, 4));
        arrayList.add(new TicketServiceFacility(SHOP_MALL, R$string.iconfont_store, 5));
        return arrayList;
    }

    private boolean textEq(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1588837269") ? ((Boolean) ipChange.ipc$dispatch("-1588837269", new Object[]{this, str})).booleanValue() : !TextUtils.isEmpty(this.name) && this.name.contentEquals(str);
    }

    public String getIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "715363515") ? (String) ipChange.ipc$dispatch("715363515", new Object[]{this}) : this.icon;
    }

    public String getLink() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "796999100") ? (String) ipChange.ipc$dispatch("796999100", new Object[]{this}) : this.link;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "64755149") ? (String) ipChange.ipc$dispatch("64755149", new Object[]{this}) : this.name;
    }

    public boolean hasUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1364789413") ? ((Boolean) ipChange.ipc$dispatch("1364789413", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.link);
    }

    public boolean isParking() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-759329750") ? ((Boolean) ipChange.ipc$dispatch("-759329750", new Object[]{this})).booleanValue() : textEq(PARKING);
    }

    public boolean isPublicTransit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1995357368") ? ((Boolean) ipChange.ipc$dispatch("1995357368", new Object[]{this})).booleanValue() : textEq(PUBLIC_TRANSIT);
    }

    public void setIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408675715")) {
            ipChange.ipc$dispatch("408675715", new Object[]{this, str});
        } else {
            this.icon = str;
        }
    }

    public void setLink(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355588446")) {
            ipChange.ipc$dispatch("-1355588446", new Object[]{this, str});
        } else {
            this.link = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1714652849")) {
            ipChange.ipc$dispatch("1714652849", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public TicketServiceFacility(String str) {
        this.name = str;
    }

    public TicketServiceFacility(String str, int i, int i2) {
        this.name = str;
        this.iconFontId = i;
        this.type = i2;
    }
}
