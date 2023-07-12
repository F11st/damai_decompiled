package cn.damai.commonbusiness.seatbiz.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CreateOrderExParams implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CreateOrderExParams> CREATOR = new Parcelable.Creator<CreateOrderExParams>() { // from class: cn.damai.commonbusiness.seatbiz.common.bean.CreateOrderExParams.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CreateOrderExParams createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1761109879") ? (CreateOrderExParams) ipChange.ipc$dispatch("1761109879", new Object[]{this, parcel}) : new CreateOrderExParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CreateOrderExParams[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1078177008") ? (CreateOrderExParams[]) ipChange.ipc$dispatch("-1078177008", new Object[]{this, Integer.valueOf(i)}) : new CreateOrderExParams[i];
        }
    };
    private String atomSplit;
    private String channel;
    private String damai;
    private String seatInfo;
    private String umpChannel;

    public CreateOrderExParams() {
        this.atomSplit = "1";
        this.umpChannel = "10001";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "642659761")) {
            return ((Integer) ipChange.ipc$dispatch("642659761", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getAtomSplit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1642122032") ? (String) ipChange.ipc$dispatch("1642122032", new Object[]{this}) : this.atomSplit;
    }

    public String getChannel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1877974550") ? (String) ipChange.ipc$dispatch("-1877974550", new Object[]{this}) : this.channel;
    }

    public String getDamai() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-301311201") ? (String) ipChange.ipc$dispatch("-301311201", new Object[]{this}) : this.damai;
    }

    public String getSeatInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-659839102") ? (String) ipChange.ipc$dispatch("-659839102", new Object[]{this}) : this.seatInfo;
    }

    public String getUmpChannel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-9239750") ? (String) ipChange.ipc$dispatch("-9239750", new Object[]{this}) : this.umpChannel;
    }

    public void setAtomSplit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695937862")) {
            ipChange.ipc$dispatch("1695937862", new Object[]{this, str});
        } else {
            this.atomSplit = str;
        }
    }

    public void setChannel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296077516")) {
            ipChange.ipc$dispatch("296077516", new Object[]{this, str});
        } else {
            this.channel = str;
        }
    }

    public void setDamai(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1740654903")) {
            ipChange.ipc$dispatch("1740654903", new Object[]{this, str});
        } else {
            this.damai = str;
        }
    }

    public void setSeatInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137496476")) {
            ipChange.ipc$dispatch("1137496476", new Object[]{this, str});
        } else {
            this.seatInfo = str;
        }
    }

    public void setUmpChannel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898651620")) {
            ipChange.ipc$dispatch("1898651620", new Object[]{this, str});
        } else {
            this.umpChannel = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1582561478")) {
            ipChange.ipc$dispatch("-1582561478", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.damai);
        parcel.writeString(this.channel);
        parcel.writeString(this.atomSplit);
        parcel.writeString(this.umpChannel);
        parcel.writeString(this.seatInfo);
    }

    public CreateOrderExParams(String str, String str2, String str3) {
        this.atomSplit = "1";
        this.umpChannel = "10001";
        this.channel = str;
        this.atomSplit = str2;
        this.seatInfo = str3;
    }

    protected CreateOrderExParams(Parcel parcel) {
        this.atomSplit = "1";
        this.umpChannel = "10001";
        this.damai = parcel.readString();
        this.channel = parcel.readString();
        this.atomSplit = parcel.readString();
        this.umpChannel = parcel.readString();
        this.seatInfo = parcel.readString();
    }
}
