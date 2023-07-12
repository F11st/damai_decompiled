package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CouponApplyResultBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private CouponApplyDataBean data;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class CouponAppliedBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<CouponAppliedBean> CREATOR = new Parcelable.Creator<CouponAppliedBean>() { // from class: cn.damai.mine.bean.CouponApplyResultBean.CouponAppliedBean.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CouponAppliedBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-582524149") ? (CouponAppliedBean) ipChange.ipc$dispatch("-582524149", new Object[]{this, parcel}) : new CouponAppliedBean(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CouponAppliedBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "179140986") ? (CouponAppliedBean[]) ipChange.ipc$dispatch("179140986", new Object[]{this, Integer.valueOf(i)}) : new CouponAppliedBean[i];
            }
        };
        private String createTime;
        private String decreaseMoneyNum;
        private String decreaseMoneyTag;
        private String effectiveEndTime;
        private String effectiveStartTime;
        private String effectiveTimeText;
        private String id;
        private String name;
        private String status;
        private String umpCouponTplId;
        private String umpCouponTplSpreadId;
        private String useCouponUrlH5;
        private String useCouponUrlMobile;

        public CouponAppliedBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1718501859")) {
                return ((Integer) ipChange.ipc$dispatch("-1718501859", new Object[]{this})).intValue();
            }
            return 0;
        }

        public String getCreateTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1824972668") ? (String) ipChange.ipc$dispatch("-1824972668", new Object[]{this}) : this.createTime;
        }

        public String getDecreaseMoneyNum() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1871898497") ? (String) ipChange.ipc$dispatch("-1871898497", new Object[]{this}) : this.decreaseMoneyNum;
        }

        public String getDecreaseMoneyTag() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2140035731") ? (String) ipChange.ipc$dispatch("2140035731", new Object[]{this}) : this.decreaseMoneyTag;
        }

        public String getEffectiveEndTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1770868028") ? (String) ipChange.ipc$dispatch("1770868028", new Object[]{this}) : this.effectiveEndTime;
        }

        public String getEffectiveStartTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-542016125") ? (String) ipChange.ipc$dispatch("-542016125", new Object[]{this}) : this.effectiveStartTime;
        }

        public String getEffectiveTimeText() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1091961252") ? (String) ipChange.ipc$dispatch("-1091961252", new Object[]{this}) : this.effectiveTimeText;
        }

        public String getId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1915918666") ? (String) ipChange.ipc$dispatch("-1915918666", new Object[]{this}) : this.id;
        }

        public String getName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1414015014") ? (String) ipChange.ipc$dispatch("1414015014", new Object[]{this}) : this.name;
        }

        public String getStatus() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1613090803") ? (String) ipChange.ipc$dispatch("-1613090803", new Object[]{this}) : this.status;
        }

        public String getUmpCouponTplId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "738533064") ? (String) ipChange.ipc$dispatch("738533064", new Object[]{this}) : this.umpCouponTplId;
        }

        public String getUmpCouponTplSpreadId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1887812965") ? (String) ipChange.ipc$dispatch("-1887812965", new Object[]{this}) : this.umpCouponTplSpreadId;
        }

        public String getUseCouponUrlH5() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-359045718") ? (String) ipChange.ipc$dispatch("-359045718", new Object[]{this}) : this.useCouponUrlH5;
        }

        public String getUseCouponUrlMobile() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1352494081") ? (String) ipChange.ipc$dispatch("-1352494081", new Object[]{this}) : this.useCouponUrlMobile;
        }

        public void setCreateTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1445506010")) {
                ipChange.ipc$dispatch("1445506010", new Object[]{this, str});
            } else {
                this.createTime = str;
            }
        }

        public void setDecreaseMoneyNum(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "928894015")) {
                ipChange.ipc$dispatch("928894015", new Object[]{this, str});
            } else {
                this.decreaseMoneyNum = str;
            }
        }

        public void setDecreaseMoneyTag(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "744803499")) {
                ipChange.ipc$dispatch("744803499", new Object[]{this, str});
            } else {
                this.decreaseMoneyTag = str;
            }
        }

        public void setEffectiveEndTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2109460702")) {
                ipChange.ipc$dispatch("-2109460702", new Object[]{this, str});
            } else {
                this.effectiveEndTime = str;
            }
        }

        public void setEffectiveStartTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "335362747")) {
                ipChange.ipc$dispatch("335362747", new Object[]{this, str});
            } else {
                this.effectiveStartTime = str;
            }
        }

        public void setEffectiveTimeText(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1519934362")) {
                ipChange.ipc$dispatch("1519934362", new Object[]{this, str});
            } else {
                this.effectiveTimeText = str;
            }
        }

        public void setId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-422584344")) {
                ipChange.ipc$dispatch("-422584344", new Object[]{this, str});
            } else {
                this.id = str;
            }
        }

        public void setName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "592035704")) {
                ipChange.ipc$dispatch("592035704", new Object[]{this, str});
            } else {
                this.name = str;
            }
        }

        public void setStatus(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "138700657")) {
                ipChange.ipc$dispatch("138700657", new Object[]{this, str});
            } else {
                this.status = str;
            }
        }

        public void setUmpCouponTplId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1992385514")) {
                ipChange.ipc$dispatch("-1992385514", new Object[]{this, str});
            } else {
                this.umpCouponTplId = str;
            }
        }

        public void setUmpCouponTplSpreadId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "665029539")) {
                ipChange.ipc$dispatch("665029539", new Object[]{this, str});
            } else {
                this.umpCouponTplSpreadId = str;
            }
        }

        public void setUseCouponUrlH5(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1657589388")) {
                ipChange.ipc$dispatch("-1657589388", new Object[]{this, str});
            } else {
                this.useCouponUrlH5 = str;
            }
        }

        public void setUseCouponUrlMobile(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "980349887")) {
                ipChange.ipc$dispatch("980349887", new Object[]{this, str});
            } else {
                this.useCouponUrlMobile = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "712303694")) {
                ipChange.ipc$dispatch("712303694", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.createTime);
            parcel.writeString(this.decreaseMoneyNum);
            parcel.writeString(this.decreaseMoneyTag);
            parcel.writeString(this.effectiveEndTime);
            parcel.writeString(this.effectiveStartTime);
            parcel.writeString(this.effectiveTimeText);
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.status);
            parcel.writeString(this.umpCouponTplId);
            parcel.writeString(this.umpCouponTplSpreadId);
            parcel.writeString(this.useCouponUrlH5);
            parcel.writeString(this.useCouponUrlMobile);
        }

        protected CouponAppliedBean(Parcel parcel) {
            this.createTime = parcel.readString();
            this.decreaseMoneyNum = parcel.readString();
            this.decreaseMoneyTag = parcel.readString();
            this.effectiveEndTime = parcel.readString();
            this.effectiveStartTime = parcel.readString();
            this.effectiveTimeText = parcel.readString();
            this.id = parcel.readString();
            this.name = parcel.readString();
            this.status = parcel.readString();
            this.umpCouponTplId = parcel.readString();
            this.umpCouponTplSpreadId = parcel.readString();
            this.useCouponUrlH5 = parcel.readString();
            this.useCouponUrlMobile = parcel.readString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class CouponApplyDataBean {
        private static transient /* synthetic */ IpChange $ipChange;
        private List<CouponAppliedBean> successCoupons;

        public List<CouponAppliedBean> getSuccessCoupons() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1973941831") ? (List) ipChange.ipc$dispatch("1973941831", new Object[]{this}) : this.successCoupons;
        }

        public void setSuccessCoupons(List<CouponAppliedBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1928884891")) {
                ipChange.ipc$dispatch("-1928884891", new Object[]{this, list});
            } else {
                this.successCoupons = list;
            }
        }
    }

    public void setData(CouponApplyDataBean couponApplyDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319776724")) {
            ipChange.ipc$dispatch("-1319776724", new Object[]{this, couponApplyDataBean});
        } else {
            this.data = couponApplyDataBean;
        }
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public CouponApplyDataBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-983480814") ? (CouponApplyDataBean) ipChange.ipc$dispatch("-983480814", new Object[]{this}) : this.data;
    }
}
