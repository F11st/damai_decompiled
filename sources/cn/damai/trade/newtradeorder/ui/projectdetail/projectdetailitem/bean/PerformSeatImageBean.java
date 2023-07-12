package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PerformSeatImageBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PerformSeatImageBean> CREATOR = new Parcelable.Creator<PerformSeatImageBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PerformSeatImageBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PerformSeatImageBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1317710839") ? (PerformSeatImageBean) ipChange.ipc$dispatch("-1317710839", new Object[]{this, parcel}) : new PerformSeatImageBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PerformSeatImageBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1512667824") ? (PerformSeatImageBean[]) ipChange.ipc$dispatch("1512667824", new Object[]{this, Integer.valueOf(i)}) : new PerformSeatImageBean[i];
        }
    };
    private String performBeginDTStr;
    private String performId;
    private String performName;
    private String performTimeDetailStr;
    private String seatImg;
    private String seatImgWithoutLogo;

    public PerformSeatImageBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102130936")) {
            return ((Integer) ipChange.ipc$dispatch("-1102130936", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getPerformBeginDTStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1407711575") ? (String) ipChange.ipc$dispatch("-1407711575", new Object[]{this}) : this.performBeginDTStr;
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-520426036") ? (String) ipChange.ipc$dispatch("-520426036", new Object[]{this}) : this.performId;
    }

    public String getPerformName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1842331204") ? (String) ipChange.ipc$dispatch("-1842331204", new Object[]{this}) : this.performName;
    }

    public String getPerformTimeDetailStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1796065272") ? (String) ipChange.ipc$dispatch("1796065272", new Object[]{this}) : this.performTimeDetailStr;
    }

    public String getSeatImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-668702418") ? (String) ipChange.ipc$dispatch("-668702418", new Object[]{this}) : this.seatImg;
    }

    public String getSeatImgWithoutLogo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-356395653") ? (String) ipChange.ipc$dispatch("-356395653", new Object[]{this}) : this.seatImgWithoutLogo;
    }

    public void setPerformBeginDTStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321608941")) {
            ipChange.ipc$dispatch("321608941", new Object[]{this, str});
        } else {
            this.performBeginDTStr = str;
        }
    }

    public void setPerformId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-918542806")) {
            ipChange.ipc$dispatch("-918542806", new Object[]{this, str});
        } else {
            this.performId = str;
        }
    }

    public void setPerformName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "717323578")) {
            ipChange.ipc$dispatch("717323578", new Object[]{this, str});
        } else {
            this.performName = str;
        }
    }

    public void setPerformTimeDetailStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1098862106")) {
            ipChange.ipc$dispatch("-1098862106", new Object[]{this, str});
        } else {
            this.performTimeDetailStr = str;
        }
    }

    public void setSeatImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871192056")) {
            ipChange.ipc$dispatch("-871192056", new Object[]{this, str});
        } else {
            this.seatImg = str;
        }
    }

    public void setSeatImgWithoutLogo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794630083")) {
            ipChange.ipc$dispatch("1794630083", new Object[]{this, str});
        } else {
            this.seatImgWithoutLogo = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724083907")) {
            ipChange.ipc$dispatch("724083907", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.performId);
        parcel.writeString(this.performName);
        parcel.writeString(this.performBeginDTStr);
        parcel.writeString(this.performTimeDetailStr);
        parcel.writeString(this.seatImg);
        parcel.writeString(this.seatImgWithoutLogo);
    }

    protected PerformSeatImageBean(Parcel parcel) {
        this.performId = parcel.readString();
        this.performName = parcel.readString();
        this.performBeginDTStr = parcel.readString();
        this.performTimeDetailStr = parcel.readString();
        this.seatImg = parcel.readString();
        this.seatImgWithoutLogo = parcel.readString();
    }
}
