package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class MarketingStallBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MarketingStallBean> CREATOR = new Parcelable.Creator<MarketingStallBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.MarketingStallBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MarketingStallBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "728603391") ? (MarketingStallBean) ipChange.ipc$dispatch("728603391", new Object[]{this, parcel}) : new MarketingStallBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MarketingStallBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1692537488") ? (MarketingStallBean[]) ipChange.ipc$dispatch("1692537488", new Object[]{this, Integer.valueOf(i)}) : new MarketingStallBean[i];
        }
    };
    public String bannerImageUrl;
    public String btnText;
    public String forwardUrl;
    public String iconUrl;
    public int interactiveMode;
    public String mainText;
    public int stallStyle;
    public String utd;

    public MarketingStallBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088283411")) {
            return ((Integer) ipChange.ipc$dispatch("-1088283411", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "510918526")) {
            ipChange.ipc$dispatch("510918526", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.stallStyle);
        parcel.writeInt(this.interactiveMode);
        parcel.writeString(this.forwardUrl);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.mainText);
        parcel.writeString(this.btnText);
        parcel.writeString(this.bannerImageUrl);
        parcel.writeString(this.utd);
    }

    protected MarketingStallBean(Parcel parcel) {
        this.stallStyle = parcel.readInt();
        this.interactiveMode = parcel.readInt();
        this.forwardUrl = parcel.readString();
        this.iconUrl = parcel.readString();
        this.mainText = parcel.readString();
        this.btnText = parcel.readString();
        this.bannerImageUrl = parcel.readString();
        this.utd = parcel.readString();
    }
}
