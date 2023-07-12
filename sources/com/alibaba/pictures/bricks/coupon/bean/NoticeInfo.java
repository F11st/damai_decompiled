package com.alibaba.pictures.bricks.coupon.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NoticeInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @Nullable
    private String ruleDesc;
    @Nullable
    private String ruleName;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class CREATOR implements Parcelable.Creator<NoticeInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        private CREATOR() {
        }

        public /* synthetic */ CREATOR(k50 k50Var) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NoticeInfo createFromParcel(@NotNull Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-80256346")) {
                return (NoticeInfo) ipChange.ipc$dispatch("-80256346", new Object[]{this, parcel});
            }
            b41.i(parcel, "parcel");
            return new NoticeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NoticeInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "528645299") ? (NoticeInfo[]) ipChange.ipc$dispatch("528645299", new Object[]{this, Integer.valueOf(i)}) : new NoticeInfo[i];
        }
    }

    public NoticeInfo(@Nullable String str, @Nullable String str2) {
        this.ruleName = str;
        this.ruleDesc = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113099037")) {
            return ((Integer) ipChange.ipc$dispatch("-1113099037", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Nullable
    public final String getRuleDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1236235762") ? (String) ipChange.ipc$dispatch("-1236235762", new Object[]{this}) : this.ruleDesc;
    }

    @Nullable
    public final String getRuleName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1470711048") ? (String) ipChange.ipc$dispatch("1470711048", new Object[]{this}) : this.ruleName;
    }

    public final void setRuleDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449069200")) {
            ipChange.ipc$dispatch("449069200", new Object[]{this, str});
        } else {
            this.ruleDesc = str;
        }
    }

    public final void setRuleName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534925610")) {
            ipChange.ipc$dispatch("-1534925610", new Object[]{this, str});
        } else {
            this.ruleName = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761867704")) {
            ipChange.ipc$dispatch("-761867704", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        b41.i(parcel, "parcel");
        parcel.writeString(this.ruleName);
        parcel.writeString(this.ruleDesc);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoticeInfo(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        b41.i(parcel, "parcel");
    }
}
