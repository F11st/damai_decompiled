package cn.damai.commonbusiness.faceverify.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class IdentityInfoQueryBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<IdentityInfoQueryBean> CREATOR = new Parcelable.Creator<IdentityInfoQueryBean>() { // from class: cn.damai.commonbusiness.faceverify.bean.IdentityInfoQueryBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IdentityInfoQueryBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1556928905") ? (IdentityInfoQueryBean) ipChange.ipc$dispatch("1556928905", new Object[]{this, parcel}) : new IdentityInfoQueryBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IdentityInfoQueryBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1932701776") ? (IdentityInfoQueryBean[]) ipChange.ipc$dispatch("-1932701776", new Object[]{this, Integer.valueOf(i)}) : new IdentityInfoQueryBean[i];
        }
    };
    public String idCard;
    public String idCardType;
    public String identityHash;
    public String name;
    public String needFaceVerify;

    public IdentityInfoQueryBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337542520")) {
            return ((Integer) ipChange.ipc$dispatch("-1337542520", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getIdCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-942759663") ? (String) ipChange.ipc$dispatch("-942759663", new Object[]{this}) : this.idCard;
    }

    public String getIdCardType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "672686187") ? (String) ipChange.ipc$dispatch("672686187", new Object[]{this}) : this.idCardType;
    }

    public String getIdentityHash() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1450164622") ? (String) ipChange.ipc$dispatch("-1450164622", new Object[]{this}) : this.identityHash;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1140688785") ? (String) ipChange.ipc$dispatch("1140688785", new Object[]{this}) : this.name;
    }

    public boolean isNeedFaceVerify() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "471408584") ? ((Boolean) ipChange.ipc$dispatch("471408584", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.needFaceVerify) && this.needFaceVerify.equals("true");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913433411")) {
            ipChange.ipc$dispatch("1913433411", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.needFaceVerify);
        parcel.writeString(this.name);
        parcel.writeString(this.idCard);
        parcel.writeString(this.idCardType);
        parcel.writeString(this.identityHash);
    }

    protected IdentityInfoQueryBean(Parcel parcel) {
        this.needFaceVerify = parcel.readString();
        this.name = parcel.readString();
        this.idCard = parcel.readString();
        this.idCardType = parcel.readString();
        this.identityHash = parcel.readString();
    }
}
