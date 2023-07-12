package cn.damai.issue.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class IssueActivityIntroduce implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<IssueActivityIntroduce> CREATOR = new Parcelable.Creator<IssueActivityIntroduce>() { // from class: cn.damai.issue.net.IssueActivityIntroduce.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IssueActivityIntroduce createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2110120719") ? (IssueActivityIntroduce) ipChange.ipc$dispatch("2110120719", new Object[]{this, parcel}) : new IssueActivityIntroduce(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IssueActivityIntroduce[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1704286416") ? (IssueActivityIntroduce[]) ipChange.ipc$dispatch("1704286416", new Object[]{this, Integer.valueOf(i)}) : new IssueActivityIntroduce[i];
        }
    };
    private String activityPrivilege;
    private int minPicNum;
    private int minWordNum;

    public IssueActivityIntroduce() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349164379")) {
            return ((Integer) ipChange.ipc$dispatch("-1349164379", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getActivityPrivilege() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-201898923") ? (String) ipChange.ipc$dispatch("-201898923", new Object[]{this}) : this.activityPrivilege;
    }

    public int getMinPicNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "672673266") ? ((Integer) ipChange.ipc$dispatch("672673266", new Object[]{this})).intValue() : this.minPicNum;
    }

    public int getMinWordNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1653083366") ? ((Integer) ipChange.ipc$dispatch("1653083366", new Object[]{this})).intValue() : this.minWordNum;
    }

    public void setActivityPrivilege(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952904511")) {
            ipChange.ipc$dispatch("-952904511", new Object[]{this, str});
        } else {
            this.activityPrivilege = str;
        }
    }

    public void setMinPicNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841589080")) {
            ipChange.ipc$dispatch("1841589080", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.minPicNum = i;
        }
    }

    public void setMinWordNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234146180")) {
            ipChange.ipc$dispatch("-1234146180", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.minWordNum = i;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563287750")) {
            ipChange.ipc$dispatch("1563287750", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.activityPrivilege);
        parcel.writeInt(this.minWordNum);
        parcel.writeInt(this.minPicNum);
    }

    protected IssueActivityIntroduce(Parcel parcel) {
        this.activityPrivilege = parcel.readString();
        this.minWordNum = parcel.readInt();
        this.minPicNum = parcel.readInt();
    }
}
