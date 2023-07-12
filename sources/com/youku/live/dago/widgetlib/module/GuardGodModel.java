package com.youku.live.dago.widgetlib.module;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GuardGodModel implements Parcelable, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<GuardGodModel> CREATOR = new Parcelable.Creator<GuardGodModel>() { // from class: com.youku.live.dago.widgetlib.module.GuardGodModel.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GuardGodModel createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-687126453") ? (GuardGodModel) ipChange.ipc$dispatch("-687126453", new Object[]{this, parcel}) : new GuardGodModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GuardGodModel[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "924600318") ? (GuardGodModel[]) ipChange.ipc$dispatch("924600318", new Object[]{this, Integer.valueOf(i)}) : new GuardGodModel[i];
        }
    };
    public String f;
    public boolean i;

    /* renamed from: io  reason: collision with root package name */
    public boolean f1037io;
    public boolean isEmpty;
    public boolean isSelfGuard;
    public long l;
    public long ld;
    public long lh;
    public long lm;
    public String n;
    public String u;

    public GuardGodModel() {
        this.isEmpty = false;
        this.isSelfGuard = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861536741")) {
            return ((Integer) ipChange.ipc$dispatch("-861536741", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247144432")) {
            ipChange.ipc$dispatch("-247144432", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.u);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.l);
        parcel.writeString(this.f);
        parcel.writeByte(this.f1037io ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.ld);
        parcel.writeLong(this.lh);
        parcel.writeLong(this.lm);
        parcel.writeString(this.n);
        parcel.writeByte(this.isEmpty ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSelfGuard ? (byte) 1 : (byte) 0);
    }

    protected GuardGodModel(Parcel parcel) {
        this.isEmpty = false;
        this.isSelfGuard = false;
        this.u = parcel.readString();
        this.i = parcel.readByte() != 0;
        this.l = parcel.readLong();
        this.f = parcel.readString();
        this.f1037io = parcel.readByte() != 0;
        this.ld = parcel.readLong();
        this.lh = parcel.readLong();
        this.lm = parcel.readLong();
        this.n = parcel.readString();
        this.isEmpty = parcel.readByte() != 0;
        this.isSelfGuard = parcel.readByte() != 0;
    }
}
