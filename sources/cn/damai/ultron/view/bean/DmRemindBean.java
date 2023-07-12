package cn.damai.ultron.view.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DmRemindBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<DmRemindBean> CREATOR = new Parcelable.Creator<DmRemindBean>() { // from class: cn.damai.ultron.view.bean.DmRemindBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DmRemindBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1565338389") ? (DmRemindBean) ipChange.ipc$dispatch("-1565338389", new Object[]{this, parcel}) : new DmRemindBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DmRemindBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1407624008") ? (DmRemindBean[]) ipChange.ipc$dispatch("1407624008", new Object[]{this, Integer.valueOf(i)}) : new DmRemindBean[i];
        }
    };
    public String closeIcon;
    public String icon;
    public String text;
    public String textColor;
    public String tip;

    public DmRemindBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1700183722")) {
            return ((Integer) ipChange.ipc$dispatch("-1700183722", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91167285")) {
            ipChange.ipc$dispatch("91167285", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.icon);
        parcel.writeString(this.text);
        parcel.writeString(this.textColor);
        parcel.writeString(this.tip);
        parcel.writeString(this.closeIcon);
    }

    protected DmRemindBean(Parcel parcel) {
        this.icon = parcel.readString();
        this.text = parcel.readString();
        this.textColor = parcel.readString();
        this.tip = parcel.readString();
        this.closeIcon = parcel.readString();
    }
}
