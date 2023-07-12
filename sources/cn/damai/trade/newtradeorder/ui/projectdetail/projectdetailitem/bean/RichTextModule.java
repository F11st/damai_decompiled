package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class RichTextModule implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RichTextModule> CREATOR = new Parcelable.Creator<RichTextModule>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RichTextModule.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichTextModule createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "941219817") ? (RichTextModule) ipChange.ipc$dispatch("941219817", new Object[]{this, parcel}) : new RichTextModule(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RichTextModule[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "994281776") ? (RichTextModule[]) ipChange.ipc$dispatch("994281776", new Object[]{this, Integer.valueOf(i)}) : new RichTextModule[i];
        }
    };
    private String content;
    private String title;

    public RichTextModule() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688549704")) {
            return ((Integer) ipChange.ipc$dispatch("-688549704", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1272515833") ? (String) ipChange.ipc$dispatch("1272515833", new Object[]{this}) : this.content;
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1841095016") ? (String) ipChange.ipc$dispatch("-1841095016", new Object[]{this}) : this.title;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822968419")) {
            ipChange.ipc$dispatch("-822968419", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251996894")) {
            ipChange.ipc$dispatch("1251996894", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354548461")) {
            ipChange.ipc$dispatch("-1354548461", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeString(this.content);
    }

    protected RichTextModule(Parcel parcel) {
        this.title = parcel.readString();
        this.content = parcel.readString();
    }
}
