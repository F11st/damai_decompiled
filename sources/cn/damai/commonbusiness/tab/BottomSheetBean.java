package cn.damai.commonbusiness.tab;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BottomSheetBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<BottomSheetBean> CREATOR = new a();
    public String backgroundPic;
    public String color;
    public List<Result> content;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class Result implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<Result> CREATOR = new a();
        public int _pos_;
        public String checkBgPic;
        public String checkedPic;
        public String checkedTextColor;
        public String defaultPic;
        public String defaultTextColor;
        @Deprecated
        public int keyIndex;
        public String popText;
        public String reCheckedPic;
        public String scm;
        public String text;
        public String type;
        public String url;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<Result> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Result createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-959344821") ? (Result) ipChange.ipc$dispatch("-959344821", new Object[]{this, parcel}) : new Result(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public Result[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "2092515118") ? (Result[]) ipChange.ipc$dispatch("2092515118", new Object[]{this, Integer.valueOf(i)}) : new Result[i];
            }
        }

        public Result() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-314356861")) {
                return ((Integer) ipChange.ipc$dispatch("-314356861", new Object[]{this})).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "982454184")) {
                ipChange.ipc$dispatch("982454184", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.checkedPic);
            parcel.writeInt(this._pos_);
            parcel.writeString(this.url);
            parcel.writeInt(this.keyIndex);
            parcel.writeString(this.defaultTextColor);
            parcel.writeString(this.defaultPic);
            parcel.writeString(this.text);
            parcel.writeString(this.scm);
            parcel.writeString(this.checkedTextColor);
            parcel.writeString(this.checkBgPic);
            parcel.writeString(this.reCheckedPic);
            parcel.writeString(this.type);
            parcel.writeString(this.popText);
        }

        protected Result(Parcel parcel) {
            this.checkedPic = parcel.readString();
            this._pos_ = parcel.readInt();
            this.url = parcel.readString();
            this.keyIndex = parcel.readInt();
            this.defaultTextColor = parcel.readString();
            this.defaultPic = parcel.readString();
            this.text = parcel.readString();
            this.scm = parcel.readString();
            this.checkedTextColor = parcel.readString();
            this.checkBgPic = parcel.readString();
            this.reCheckedPic = parcel.readString();
            this.type = parcel.readString();
            this.popText = parcel.readString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<BottomSheetBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BottomSheetBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1918746881") ? (BottomSheetBean) ipChange.ipc$dispatch("1918746881", new Object[]{this, parcel}) : new BottomSheetBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BottomSheetBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-101719376") ? (BottomSheetBean[]) ipChange.ipc$dispatch("-101719376", new Object[]{this, Integer.valueOf(i)}) : new BottomSheetBean[i];
        }
    }

    public BottomSheetBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2079599444")) {
            return ((Integer) ipChange.ipc$dispatch("-2079599444", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708728929")) {
            ipChange.ipc$dispatch("-1708728929", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.backgroundPic);
        parcel.writeString(this.color);
        parcel.writeTypedList(this.content);
    }

    protected BottomSheetBean(Parcel parcel) {
        this.backgroundPic = parcel.readString();
        this.color = parcel.readString();
        this.content = parcel.createTypedArrayList(Result.CREATOR);
    }
}
