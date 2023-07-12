package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MessageNotice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageNotice> CREATOR = new Parcelable.Creator<MessageNotice>() { // from class: cn.damai.message.bean.MessageNotice.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageNotice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "188815485") ? (MessageNotice) ipChange.ipc$dispatch("188815485", new Object[]{this, parcel}) : new MessageNotice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageNotice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "921665392") ? (MessageNotice[]) ipChange.ipc$dispatch("921665392", new Object[]{this, Integer.valueOf(i)}) : new MessageNotice[i];
        }
    };
    private String content;
    private String url;

    public MessageNotice() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919993582")) {
            return ((Integer) ipChange.ipc$dispatch("1919993582", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1574500611") ? (String) ipChange.ipc$dispatch("1574500611", new Object[]{this}) : this.content;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-700192135") ? (String) ipChange.ipc$dispatch("-700192135", new Object[]{this}) : this.url;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-51374893")) {
            ipChange.ipc$dispatch("-51374893", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187428381")) {
            ipChange.ipc$dispatch("1187428381", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436579741")) {
            ipChange.ipc$dispatch("1436579741", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.content);
        parcel.writeString(this.url);
    }

    protected MessageNotice(Parcel parcel) {
        this.content = parcel.readString();
        this.url = parcel.readString();
    }
}
