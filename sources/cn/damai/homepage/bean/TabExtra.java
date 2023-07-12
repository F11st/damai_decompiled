package cn.damai.homepage.bean;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.homepage.MainActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jm1;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class TabExtra implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<TabExtra> CREATOR = new Parcelable.Creator<TabExtra>() { // from class: cn.damai.homepage.bean.TabExtra.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TabExtra createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-534437093") ? (TabExtra) ipChange.ipc$dispatch("-534437093", new Object[]{this, parcel}) : new TabExtra(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TabExtra[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1763351888") ? (TabExtra[]) ipChange.ipc$dispatch("1763351888", new Object[]{this, Integer.valueOf(i)}) : new TabExtra[i];
        }
    };
    public String categoryId;
    public String groupId;
    public String referItemId;
    public int type;

    protected TabExtra(Parcel parcel) {
        this.type = parcel.readInt();
        this.categoryId = parcel.readString();
        this.groupId = parcel.readString();
        this.referItemId = parcel.readString();
    }

    public static TabExtra fromIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1292410171") ? (TabExtra) ipChange.ipc$dispatch("-1292410171", new Object[]{intent}) : new TabExtra(intent.getStringExtra("type"), intent.getStringExtra("id"), intent.getStringExtra("groupId"), intent.getStringExtra(MainActivity.KEY_REF_ITEM_ID));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "535061471")) {
            return ((Integer) ipChange.ipc$dispatch("535061471", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isValidExtra() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1913874455") ? ((Boolean) ipChange.ipc$dispatch("1913874455", new Object[]{this})).booleanValue() : this.type >= 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-810665268")) {
            ipChange.ipc$dispatch("-810665268", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.groupId);
        parcel.writeString(this.referItemId);
    }

    public TabExtra(String str, String str2, String str3, String str4) {
        this.type = jm1.j(str, -1);
        this.categoryId = str2;
        this.groupId = str3;
        this.referItemId = str4;
    }

    public TabExtra() {
    }
}
