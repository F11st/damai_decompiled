package cn.damai.message.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MessageList implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<MessageList> CREATOR = new Parcelable.Creator<MessageList>() { // from class: cn.damai.message.bean.MessageList.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageList createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "963465777") ? (MessageList) ipChange.ipc$dispatch("963465777", new Object[]{this, parcel}) : new MessageList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageList[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1116431408") ? (MessageList[]) ipChange.ipc$dispatch("1116431408", new Object[]{this, Integer.valueOf(i)}) : new MessageList[i];
        }
    };
    private List<MessageItem> messageList;

    public MessageList() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596113932")) {
            return ((Integer) ipChange.ipc$dispatch("-1596113932", new Object[]{this})).intValue();
        }
        return 0;
    }

    public List<MessageItem> getMessageList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-546055568") ? (List) ipChange.ipc$dispatch("-546055568", new Object[]{this}) : this.messageList;
    }

    public void setMessageList(List<MessageItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-807511564")) {
            ipChange.ipc$dispatch("-807511564", new Object[]{this, list});
        } else {
            this.messageList = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804079273")) {
            ipChange.ipc$dispatch("-1804079273", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeList(this.messageList);
        }
    }

    protected MessageList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.messageList = arrayList;
        parcel.readList(arrayList, MessageItem.class.getClassLoader());
    }
}
