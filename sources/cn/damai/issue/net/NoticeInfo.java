package cn.damai.issue.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class NoticeInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<NoticeInfo> CREATOR = new Parcelable.Creator<NoticeInfo>() { // from class: cn.damai.issue.net.NoticeInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoticeInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "951738993") ? (NoticeInfo) ipChange.ipc$dispatch("951738993", new Object[]{this, parcel}) : new NoticeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoticeInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1980088016") ? (NoticeInfo[]) ipChange.ipc$dispatch("-1980088016", new Object[]{this, Integer.valueOf(i)}) : new NoticeInfo[i];
        }
    };
    private ArrayList<IssueActivityIntroduce> activityIntroduce;
    private String activityNotice;
    private String activityPic;
    private String redActivityNotice;

    public NoticeInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573208724")) {
            return ((Integer) ipChange.ipc$dispatch("573208724", new Object[]{this})).intValue();
        }
        return 0;
    }

    public ArrayList<IssueActivityIntroduce> getActivityIntroduce() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-240122170") ? (ArrayList) ipChange.ipc$dispatch("-240122170", new Object[]{this}) : this.activityIntroduce;
    }

    public String getActivityNotice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1093840153") ? (String) ipChange.ipc$dispatch("1093840153", new Object[]{this}) : this.activityNotice;
    }

    public String getActivityPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1545698719") ? (String) ipChange.ipc$dispatch("1545698719", new Object[]{this}) : this.activityPic;
    }

    public String getRedActivityNotice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "71155740") ? (String) ipChange.ipc$dispatch("71155740", new Object[]{this}) : this.redActivityNotice;
    }

    public void setActivityIntroduce(ArrayList<IssueActivityIntroduce> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1870609230")) {
            ipChange.ipc$dispatch("-1870609230", new Object[]{this, arrayList});
        } else {
            this.activityIntroduce = arrayList;
        }
    }

    public void setActivityNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432199653")) {
            ipChange.ipc$dispatch("432199653", new Object[]{this, str});
        } else {
            this.activityNotice = str;
        }
    }

    public void setActivityPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627931209")) {
            ipChange.ipc$dispatch("-1627931209", new Object[]{this, str});
        } else {
            this.activityPic = str;
        }
    }

    public void setRedActivityNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078144550")) {
            ipChange.ipc$dispatch("-1078144550", new Object[]{this, str});
        } else {
            this.redActivityNotice = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1123518135")) {
            ipChange.ipc$dispatch("1123518135", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.activityNotice);
        parcel.writeString(this.redActivityNotice);
        parcel.writeTypedList(this.activityIntroduce);
        parcel.writeString(this.activityPic);
    }

    protected NoticeInfo(Parcel parcel) {
        this.activityNotice = parcel.readString();
        this.redActivityNotice = parcel.readString();
        this.activityIntroduce = parcel.createTypedArrayList(IssueActivityIntroduce.CREATOR);
        this.activityPic = parcel.readString();
    }
}
