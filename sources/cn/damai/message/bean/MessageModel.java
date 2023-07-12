package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MessageModel implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageModel> CREATOR = new Parcelable.Creator<MessageModel>() { // from class: cn.damai.message.bean.MessageModel.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageModel createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1053884789") ? (MessageModel) ipChange.ipc$dispatch("-1053884789", new Object[]{this, parcel}) : new MessageModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageModel[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "473021042") ? (MessageModel[]) ipChange.ipc$dispatch("473021042", new Object[]{this, Integer.valueOf(i)}) : new MessageModel[i];
        }
    };
    private List<MessageGroupItem> messageGroupList;
    private MessageNotice notice;

    public MessageModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2073546657")) {
            return ((Integer) ipChange.ipc$dispatch("2073546657", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<MessageGroupItem> getMessageGroupList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1671418884") ? (List) ipChange.ipc$dispatch("-1671418884", new Object[]{this}) : this.messageGroupList;
    }

    public MessageNotice getNotice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "444439031") ? (MessageNotice) ipChange.ipc$dispatch("444439031", new Object[]{this}) : this.notice;
    }

    public void setMessageGroupList(List<MessageGroupItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514062160")) {
            ipChange.ipc$dispatch("1514062160", new Object[]{this, list});
        } else {
            this.messageGroupList = list;
        }
    }

    public void setNotice(MessageNotice messageNotice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296239007")) {
            ipChange.ipc$dispatch("-296239007", new Object[]{this, messageNotice});
        } else {
            this.notice = messageNotice;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529822902")) {
            ipChange.ipc$dispatch("-529822902", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.messageGroupList);
        parcel.writeParcelable(this.notice, i);
    }

    protected MessageModel(Parcel parcel) {
        this.messageGroupList = parcel.createTypedArrayList(MessageGroupItem.CREATOR);
        this.notice = (MessageNotice) parcel.readParcelable(MessageNotice.class.getClassLoader());
    }
}
