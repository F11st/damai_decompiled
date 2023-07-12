package cn.damai.category.discountticket.bean.biz;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import cn.damai.category.discountticket.bean.HeaderData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DtParams implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final Parcelable.Creator<DtParams> CREATOR = new Parcelable.Creator<DtParams>() { // from class: cn.damai.category.discountticket.bean.biz.DtParams.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DtParams createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1526760747") ? (DtParams) ipChange.ipc$dispatch("1526760747", new Object[]{this, parcel}) : new DtParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DtParams[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "62437156") ? (DtParams[]) ipChange.ipc$dispatch("62437156", new Object[]{this, Integer.valueOf(i)}) : new DtParams[i];
        }
    };
    public static final int TYPE_DISCOUNT_ACTIVITY = 6;
    public static final int TYPE_FROM_CATEGORY_FRAGMENT = 8;
    public static final int TYPE_MORE_DISCOUNT_ACTIVITY = 7;
    @Nullable
    public String cityId;
    @Nullable
    public HeaderData extra;
    @Nullable
    public String specBPageName;
    public int type;

    public DtParams() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883212712")) {
            return ((Integer) ipChange.ipc$dispatch("1883212712", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isTypeFormCategoryFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1443804904") ? ((Boolean) ipChange.ipc$dispatch("1443804904", new Object[]{this})).booleanValue() : this.type == 8;
    }

    public boolean isTypeMoreDiscountActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1281063051") ? ((Boolean) ipChange.ipc$dispatch("-1281063051", new Object[]{this})).booleanValue() : this.type == 7;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890614819")) {
            ipChange.ipc$dispatch("1890614819", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeParcelable(this.extra, i);
        parcel.writeString(this.cityId);
        parcel.writeString(this.specBPageName);
    }

    protected DtParams(Parcel parcel) {
        this.type = parcel.readInt();
        this.extra = (HeaderData) parcel.readParcelable(HeaderData.class.getClassLoader());
        this.cityId = parcel.readString();
        this.specBPageName = parcel.readString();
    }

    public DtParams(int i) {
        this(i, null, null, null);
    }

    public DtParams(int i, @Nullable String str) {
        this(i, null, null, str);
    }

    public DtParams(int i, HeaderData headerData, String str) {
        this(i, headerData, str, null);
    }

    public DtParams(int i, HeaderData headerData, @Nullable String str, @Nullable String str2) {
        this.type = i;
        this.extra = headerData;
        this.cityId = str;
        this.specBPageName = str2;
    }
}
