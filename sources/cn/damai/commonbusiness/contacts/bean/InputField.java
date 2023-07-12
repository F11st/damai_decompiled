package cn.damai.commonbusiness.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class InputField implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<InputField> CREATOR = new Parcelable.Creator<InputField>() { // from class: cn.damai.commonbusiness.contacts.bean.InputField.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputField createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1622432821") ? (InputField) ipChange.ipc$dispatch("-1622432821", new Object[]{this, parcel}) : new InputField(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputField[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-824580746") ? (InputField[]) ipChange.ipc$dispatch("-824580746", new Object[]{this, Integer.valueOf(i)}) : new InputField[i];
        }
    };
    String name;
    String placeholder;
    String uploadKey;

    public InputField() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212956735")) {
            return ((Integer) ipChange.ipc$dispatch("1212956735", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "444033096") ? (String) ipChange.ipc$dispatch("444033096", new Object[]{this}) : this.name;
    }

    public String getPlaceholder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-416814068") ? (String) ipChange.ipc$dispatch("-416814068", new Object[]{this}) : this.placeholder;
    }

    public String getUploadKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1386960073") ? (String) ipChange.ipc$dispatch("-1386960073", new Object[]{this}) : this.uploadKey;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "653025701")) {
            ipChange.ipc$dispatch("653025701", new Object[]{this, parcel});
            return;
        }
        this.name = parcel.readString();
        this.placeholder = parcel.readString();
        this.uploadKey = parcel.readString();
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587367318")) {
            ipChange.ipc$dispatch("587367318", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setPlaceholder(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1958681834")) {
            ipChange.ipc$dispatch("1958681834", new Object[]{this, str});
        } else {
            this.placeholder = str;
        }
    }

    public void setUploadKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011294177")) {
            ipChange.ipc$dispatch("-2011294177", new Object[]{this, str});
        } else {
            this.uploadKey = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221678484")) {
            ipChange.ipc$dispatch("-1221678484", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.placeholder);
        parcel.writeString(this.uploadKey);
    }

    protected InputField(Parcel parcel) {
        this.name = parcel.readString();
        this.placeholder = parcel.readString();
        this.uploadKey = parcel.readString();
    }
}
