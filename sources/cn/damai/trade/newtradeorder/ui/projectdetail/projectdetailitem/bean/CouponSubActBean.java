package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class CouponSubActBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CouponSubActBean> CREATOR = new Parcelable.Creator<CouponSubActBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.CouponSubActBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponSubActBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-147384509") ? (CouponSubActBean) ipChange.ipc$dispatch("-147384509", new Object[]{this, parcel}) : new CouponSubActBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CouponSubActBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-358062320") ? (CouponSubActBean[]) ipChange.ipc$dispatch("-358062320", new Object[]{this, Integer.valueOf(i)}) : new CouponSubActBean[i];
        }
    };
    private String appAsacCode;
    private String applicable;
    private String decreaseMoneyNum;
    private String decreaseMoneyTag;
    private String desc;
    private String effectiveEndTime;
    private String effectiveStartTime;
    private String effectiveTimeText;
    private String id;
    private String name;
    private String tag;
    private String unapplicableCause;

    public CouponSubActBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "778544971")) {
            return ((Integer) ipChange.ipc$dispatch("778544971", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getAppAsacCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1332481617") ? (String) ipChange.ipc$dispatch("-1332481617", new Object[]{this}) : this.appAsacCode;
    }

    public String getDecreaseMoneyNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-474964307") ? (String) ipChange.ipc$dispatch("-474964307", new Object[]{this}) : this.decreaseMoneyNum;
    }

    public String getDecreaseMoneyTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-757997375") ? (String) ipChange.ipc$dispatch("-757997375", new Object[]{this}) : this.decreaseMoneyTag;
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1877456806") ? (String) ipChange.ipc$dispatch("-1877456806", new Object[]{this}) : this.desc;
    }

    public String getEffectiveEndTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1127165078") ? (String) ipChange.ipc$dispatch("-1127165078", new Object[]{this}) : this.effectiveEndTime;
    }

    public String getEffectiveStartTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1881944113") ? (String) ipChange.ipc$dispatch("1881944113", new Object[]{this}) : this.effectiveStartTime;
    }

    public String getEffectiveTimeText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-736674322") ? (String) ipChange.ipc$dispatch("-736674322", new Object[]{this}) : this.effectiveTimeText;
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2083468644") ? (String) ipChange.ipc$dispatch("2083468644", new Object[]{this}) : this.id;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "829490004") ? (String) ipChange.ipc$dispatch("829490004", new Object[]{this}) : this.name;
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "630099495") ? (String) ipChange.ipc$dispatch("630099495", new Object[]{this}) : this.tag;
    }

    public String getUnapplicableCause() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "182041054") ? (String) ipChange.ipc$dispatch("182041054", new Object[]{this}) : this.unapplicableCause;
    }

    public String isApplicable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1898848172") ? (String) ipChange.ipc$dispatch("1898848172", new Object[]{this}) : this.applicable;
    }

    public void setAppAsacCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-657208409")) {
            ipChange.ipc$dispatch("-657208409", new Object[]{this, str});
        } else {
            this.appAsacCode = str;
        }
    }

    public void setApplicable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706856182")) {
            ipChange.ipc$dispatch("706856182", new Object[]{this, str});
        } else {
            this.applicable = str;
        }
    }

    public void setDecreaseMoneyNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1284180945")) {
            ipChange.ipc$dispatch("1284180945", new Object[]{this, str});
        } else {
            this.decreaseMoneyNum = str;
        }
    }

    public void setDecreaseMoneyTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100090429")) {
            ipChange.ipc$dispatch("1100090429", new Object[]{this, str});
        } else {
            this.decreaseMoneyTag = str;
        }
    }

    public void setDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635624388")) {
            ipChange.ipc$dispatch("1635624388", new Object[]{this, str});
        } else {
            this.desc = str;
        }
    }

    public void setEffectiveEndTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754173772")) {
            ipChange.ipc$dispatch("-1754173772", new Object[]{this, str});
        } else {
            this.effectiveEndTime = str;
        }
    }

    public void setEffectiveStartTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831281203")) {
            ipChange.ipc$dispatch("-1831281203", new Object[]{this, str});
        } else {
            this.effectiveStartTime = str;
        }
    }

    public void setEffectiveTimeText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351072696")) {
            ipChange.ipc$dispatch("-351072696", new Object[]{this, str});
        } else {
            this.effectiveTimeText = str;
        }
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995629318")) {
            ipChange.ipc$dispatch("-995629318", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348370422")) {
            ipChange.ipc$dispatch("-348370422", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523204049")) {
            ipChange.ipc$dispatch("-523204049", new Object[]{this, str});
        } else {
            this.tag = str;
        }
    }

    public void setUnapplicableCause(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1935667112")) {
            ipChange.ipc$dispatch("-1935667112", new Object[]{this, str});
        } else {
            this.unapplicableCause = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397013728")) {
            ipChange.ipc$dispatch("1397013728", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.applicable);
        parcel.writeString(this.decreaseMoneyNum);
        parcel.writeString(this.decreaseMoneyTag);
        parcel.writeString(this.desc);
        parcel.writeString(this.effectiveEndTime);
        parcel.writeString(this.effectiveStartTime);
        parcel.writeString(this.effectiveTimeText);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.tag);
        parcel.writeString(this.unapplicableCause);
        parcel.writeString(this.appAsacCode);
    }

    protected CouponSubActBean(Parcel parcel) {
        this.applicable = parcel.readString();
        this.decreaseMoneyNum = parcel.readString();
        this.decreaseMoneyTag = parcel.readString();
        this.desc = parcel.readString();
        this.effectiveEndTime = parcel.readString();
        this.effectiveStartTime = parcel.readString();
        this.effectiveTimeText = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.tag = parcel.readString();
        this.unapplicableCause = parcel.readString();
        this.appAsacCode = parcel.readString();
    }
}
