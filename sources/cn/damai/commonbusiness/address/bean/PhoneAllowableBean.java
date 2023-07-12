package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class PhoneAllowableBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PhoneAllowableBean> CREATOR = new Parcelable.Creator<PhoneAllowableBean>() { // from class: cn.damai.commonbusiness.address.bean.PhoneAllowableBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAllowableBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1648771965") ? (PhoneAllowableBean) ipChange.ipc$dispatch("-1648771965", new Object[]{this, parcel}) : new PhoneAllowableBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAllowableBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1962274608") ? (PhoneAllowableBean[]) ipChange.ipc$dispatch("-1962274608", new Object[]{this, Integer.valueOf(i)}) : new PhoneAllowableBean[i];
        }
    };
    public String areaChineseTranditionalName;
    public String areaEnglishName;
    public long areaId;
    public String areaName;
    public String checkKey;
    public String code;
    public String domainAbbreviation;
    public String pinyin;
    public long sortWeightKey;

    public PhoneAllowableBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213279531")) {
            return ((Integer) ipChange.ipc$dispatch("1213279531", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224677120")) {
            ipChange.ipc$dispatch("-224677120", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.areaChineseTranditionalName);
        parcel.writeString(this.areaEnglishName);
        parcel.writeLong(this.areaId);
        parcel.writeString(this.areaName);
        parcel.writeString(this.checkKey);
        parcel.writeString(this.code);
        parcel.writeString(this.domainAbbreviation);
        parcel.writeString(this.pinyin);
        parcel.writeLong(this.sortWeightKey);
    }

    protected PhoneAllowableBean(Parcel parcel) {
        this.areaChineseTranditionalName = parcel.readString();
        this.areaEnglishName = parcel.readString();
        this.areaId = parcel.readLong();
        this.areaName = parcel.readString();
        this.checkKey = parcel.readString();
        this.code = parcel.readString();
        this.domainAbbreviation = parcel.readString();
        this.pinyin = parcel.readString();
        this.sortWeightKey = parcel.readLong();
    }
}
