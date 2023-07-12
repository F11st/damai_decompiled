package cn.damai.mine.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class FeedBack implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<FeedBack> CREATOR = new Parcelable.Creator<FeedBack>() { // from class: cn.damai.mine.bean.FeedBack.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeedBack createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1327990653") ? (FeedBack) ipChange.ipc$dispatch("1327990653", new Object[]{this, parcel}) : new FeedBack(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeedBack[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1014887568") ? (FeedBack[]) ipChange.ipc$dispatch("-1014887568", new Object[]{this, Integer.valueOf(i)}) : new FeedBack[i];
        }
    };
    public String desc;
    public int index;
    public String name;
    public String subTitle;
    public String title;

    public FeedBack() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833937938")) {
            return ((Integer) ipChange.ipc$dispatch("-1833937938", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885820061")) {
            ipChange.ipc$dispatch("885820061", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
    }

    protected FeedBack(Parcel parcel) {
        this.name = parcel.readString();
        this.subTitle = parcel.readString();
        this.title = parcel.readString();
        this.desc = parcel.readString();
    }
}
