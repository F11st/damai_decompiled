package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PromotionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PromotionBean> CREATOR = new Parcelable.Creator<PromotionBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PromotionBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PromotionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1638853995") ? (PromotionBean) ipChange.ipc$dispatch("1638853995", new Object[]{this, parcel}) : new PromotionBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PromotionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "102808120") ? (PromotionBean[]) ipChange.ipc$dispatch("102808120", new Object[]{this, Integer.valueOf(i)}) : new PromotionBean[i];
        }
    };
    private String content;
    private String tag;

    public PromotionBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1384031778")) {
            return ((Integer) ipChange.ipc$dispatch("-1384031778", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "530853907") ? (String) ipChange.ipc$dispatch("530853907", new Object[]{this}) : this.content;
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1607819316") ? (String) ipChange.ipc$dispatch("1607819316", new Object[]{this}) : this.tag;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955315651")) {
            ipChange.ipc$dispatch("1955315651", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278660670")) {
            ipChange.ipc$dispatch("-278660670", new Object[]{this, str});
        } else {
            this.tag = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "407511725")) {
            ipChange.ipc$dispatch("407511725", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.tag);
        parcel.writeString(this.content);
    }

    protected PromotionBean(Parcel parcel) {
        this.tag = parcel.readString();
        this.content = parcel.readString();
    }
}
