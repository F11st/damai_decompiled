package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MessageGroupResponse implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageGroupResponse> CREATOR = new Parcelable.Creator<MessageGroupResponse>() { // from class: cn.damai.message.bean.MessageGroupResponse.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageGroupResponse createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1231204309") ? (MessageGroupResponse) ipChange.ipc$dispatch("-1231204309", new Object[]{this, parcel}) : new MessageGroupResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageGroupResponse[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1077912644") ? (MessageGroupResponse[]) ipChange.ipc$dispatch("1077912644", new Object[]{this, Integer.valueOf(i)}) : new MessageGroupResponse[i];
        }
    };
    private MessageModel model;

    public MessageGroupResponse() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662286360")) {
            return ((Integer) ipChange.ipc$dispatch("662286360", new Object[]{this})).intValue();
        }
        return 0;
    }

    public MessageModel getModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1525530288") ? (MessageModel) ipChange.ipc$dispatch("1525530288", new Object[]{this}) : this.model;
    }

    public void setModel(MessageModel messageModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746464844")) {
            ipChange.ipc$dispatch("-1746464844", new Object[]{this, messageModel});
        } else {
            this.model = messageModel;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1482016691")) {
            ipChange.ipc$dispatch("1482016691", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeParcelable(this.model, i);
        }
    }

    protected MessageGroupResponse(Parcel parcel) {
        this.model = (MessageModel) parcel.readParcelable(MessageModel.class.getClassLoader());
    }
}
