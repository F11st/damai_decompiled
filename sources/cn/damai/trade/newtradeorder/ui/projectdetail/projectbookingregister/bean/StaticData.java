package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ItemPics;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class StaticData implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<StaticData> CREATOR = new Parcelable.Creator<StaticData>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StaticData createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-213128117") ? (StaticData) ipChange.ipc$dispatch("-213128117", new Object[]{this, parcel}) : new StaticData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StaticData[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-812275794") ? (StaticData[]) ipChange.ipc$dispatch("-812275794", new Object[]{this, Integer.valueOf(i)}) : new StaticData[i];
        }
    };
    private ItemBase itemBase;
    private ItemExtendInfo itemExtendInfo;
    private VenueBean venue;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class ItemBase implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ItemBase> CREATOR = new Parcelable.Creator<ItemBase>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData.ItemBase.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ItemBase createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1831639117") ? (ItemBase) ipChange.ipc$dispatch("-1831639117", new Object[]{this, parcel}) : new ItemBase(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ItemBase[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-195414256") ? (ItemBase[]) ipChange.ipc$dispatch("-195414256", new Object[]{this, Integer.valueOf(i)}) : new ItemBase[i];
            }
        };
        private String cityId;
        private String cityName;
        private String itemId;
        private String itemName;
        private ItemPics itemPics;
        private String nationalStandardCityId;
        private String showTime;

        public ItemBase() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1511815187")) {
                return ((Integer) ipChange.ipc$dispatch("1511815187", new Object[]{this})).intValue();
            }
            return 0;
        }

        public String getCityId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1806692233") ? (String) ipChange.ipc$dispatch("-1806692233", new Object[]{this}) : this.cityId;
        }

        public String getCityName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-993565273") ? (String) ipChange.ipc$dispatch("-993565273", new Object[]{this}) : this.cityName;
        }

        public String getItemId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "252757023") ? (String) ipChange.ipc$dispatch("252757023", new Object[]{this}) : this.itemId;
        }

        public String getItemName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1842753713") ? (String) ipChange.ipc$dispatch("-1842753713", new Object[]{this}) : this.itemName;
        }

        public ItemPics getItemPics() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-196699450") ? (ItemPics) ipChange.ipc$dispatch("-196699450", new Object[]{this}) : this.itemPics;
        }

        public String getNationalStandardCityId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1983802778") ? (String) ipChange.ipc$dispatch("-1983802778", new Object[]{this}) : this.nationalStandardCityId;
        }

        public String getShowTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1065503621") ? (String) ipChange.ipc$dispatch("-1065503621", new Object[]{this}) : this.showTime;
        }

        public void setCityId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1567976377")) {
                ipChange.ipc$dispatch("-1567976377", new Object[]{this, str});
            } else {
                this.cityId = str;
            }
        }

        public void setCityName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-618080233")) {
                ipChange.ipc$dispatch("-618080233", new Object[]{this, str});
            } else {
                this.cityName = str;
            }
        }

        public void setItemId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2145408415")) {
                ipChange.ipc$dispatch("2145408415", new Object[]{this, str});
            } else {
                this.itemId = str;
            }
        }

        public void setItemName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1173118097")) {
                ipChange.ipc$dispatch("-1173118097", new Object[]{this, str});
            } else {
                this.itemName = str;
            }
        }

        public void setItemPics(ItemPics itemPics) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-812750998")) {
                ipChange.ipc$dispatch("-812750998", new Object[]{this, itemPics});
            } else {
                this.itemPics = itemPics;
            }
        }

        public void setNationalStandardCityId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "80472120")) {
                ipChange.ipc$dispatch("80472120", new Object[]{this, str});
            } else {
                this.nationalStandardCityId = str;
            }
        }

        public void setShowTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1446798275")) {
                ipChange.ipc$dispatch("1446798275", new Object[]{this, str});
            } else {
                this.showTime = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1614637800")) {
                ipChange.ipc$dispatch("-1614637800", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.cityId);
            parcel.writeString(this.cityName);
            parcel.writeString(this.itemId);
            parcel.writeString(this.itemName);
            parcel.writeString(this.showTime);
            parcel.writeParcelable(this.itemPics, i);
            parcel.writeString(this.nationalStandardCityId);
        }

        protected ItemBase(Parcel parcel) {
            this.cityId = parcel.readString();
            this.cityName = parcel.readString();
            this.itemId = parcel.readString();
            this.itemName = parcel.readString();
            this.showTime = parcel.readString();
            this.itemPics = (ItemPics) parcel.readParcelable(ItemPics.class.getClassLoader());
            this.nationalStandardCityId = parcel.readString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class ItemExtendInfo implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ItemExtendInfo> CREATOR = new Parcelable.Creator<ItemExtendInfo>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData.ItemExtendInfo.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ItemExtendInfo createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-2101587195") ? (ItemExtendInfo) ipChange.ipc$dispatch("-2101587195", new Object[]{this, parcel}) : new ItemExtendInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ItemExtendInfo[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-831802896") ? (ItemExtendInfo[]) ipChange.ipc$dispatch("-831802896", new Object[]{this, Integer.valueOf(i)}) : new ItemExtendInfo[i];
            }
        };
        private String itemDescTitle;
        private String itemExtend;

        public ItemExtendInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1341557590")) {
                return ((Integer) ipChange.ipc$dispatch("-1341557590", new Object[]{this})).intValue();
            }
            return 0;
        }

        public String getItemDescTitle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2100027394") ? (String) ipChange.ipc$dispatch("2100027394", new Object[]{this}) : this.itemDescTitle;
        }

        public String getItemExtend() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1498686581") ? (String) ipChange.ipc$dispatch("1498686581", new Object[]{this}) : this.itemExtend;
        }

        public void setItemDescTitle(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1192323916")) {
                ipChange.ipc$dispatch("-1192323916", new Object[]{this, str});
            } else {
                this.itemDescTitle = str;
            }
        }

        public void setItemExtend(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1399727625")) {
                ipChange.ipc$dispatch("1399727625", new Object[]{this, str});
            } else {
                this.itemExtend = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-335971999")) {
                ipChange.ipc$dispatch("-335971999", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.itemDescTitle);
            parcel.writeString(this.itemExtend);
        }

        protected ItemExtendInfo(Parcel parcel) {
            this.itemDescTitle = parcel.readString();
            this.itemExtend = parcel.readString();
        }
    }

    public StaticData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1521699997")) {
            return ((Integer) ipChange.ipc$dispatch("-1521699997", new Object[]{this})).intValue();
        }
        return 0;
    }

    public ItemBase getItemBase() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1258081604") ? (ItemBase) ipChange.ipc$dispatch("1258081604", new Object[]{this}) : this.itemBase;
    }

    public ItemExtendInfo getItemExtendInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "920240982") ? (ItemExtendInfo) ipChange.ipc$dispatch("920240982", new Object[]{this}) : this.itemExtendInfo;
    }

    public VenueBean getVenue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1053626626") ? (VenueBean) ipChange.ipc$dispatch("-1053626626", new Object[]{this}) : this.venue;
    }

    public void setItemBase(ItemBase itemBase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-5665974")) {
            ipChange.ipc$dispatch("-5665974", new Object[]{this, itemBase});
        } else {
            this.itemBase = itemBase;
        }
    }

    public void setItemExtendInfo(ItemExtendInfo itemExtendInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817440534")) {
            ipChange.ipc$dispatch("-1817440534", new Object[]{this, itemExtendInfo});
        } else {
            this.itemExtendInfo = itemExtendInfo;
        }
    }

    public void setVenue(VenueBean venueBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425137590")) {
            ipChange.ipc$dispatch("-1425137590", new Object[]{this, venueBean});
        } else {
            this.venue = venueBean;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "658924488")) {
            ipChange.ipc$dispatch("658924488", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeParcelable(this.itemBase, i);
        parcel.writeParcelable(this.itemExtendInfo, i);
        parcel.writeParcelable(this.venue, i);
    }

    protected StaticData(Parcel parcel) {
        this.itemBase = (ItemBase) parcel.readParcelable(ItemBase.class.getClassLoader());
        this.itemExtendInfo = (ItemExtendInfo) parcel.readParcelable(ItemExtendInfo.class.getClassLoader());
        this.venue = (VenueBean) parcel.readParcelable(VenueBean.class.getClassLoader());
    }
}
