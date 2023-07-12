package cn.damai.commonbusiness.seatbiz.seat.qilin.bean;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SeatPreloadExtra implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SeatPreloadExtra> CREATOR = new Parcelable.Creator<SeatPreloadExtra>() { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatPreloadExtra.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeatPreloadExtra createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "199008619") ? (SeatPreloadExtra) ipChange.ipc$dispatch("199008619", new Object[]{this, parcel}) : new SeatPreloadExtra(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeatPreloadExtra[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1828293508") ? (SeatPreloadExtra[]) ipChange.ipc$dispatch("1828293508", new Object[]{this, Integer.valueOf(i)}) : new SeatPreloadExtra[i];
        }
    };
    public String cityId;
    public long itemId;
    public long performId;
    public int type;

    public SeatPreloadExtra() {
    }

    @Nullable
    public static SeatPreloadExtra obtainExtra(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525865986")) {
            return (SeatPreloadExtra) ipChange.ipc$dispatch("-1525865986", new Object[]{intent});
        }
        if (intent != null) {
            return obtainExtra(intent.getExtras());
        }
        return null;
    }

    public static void putPreloadExtraIfNeed(@Nullable SeatPreloadExtra seatPreloadExtra, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1567468701")) {
            ipChange.ipc$dispatch("-1567468701", new Object[]{seatPreloadExtra, bundle});
        } else if (seatPreloadExtra == null || !seatPreloadExtra.isValid() || bundle == null) {
        } else {
            bundle.putParcelable(NcovSkuActivity.KEY_SEAT_PRELOAD_EXTRA, seatPreloadExtra);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080753848")) {
            return ((Integer) ipChange.ipc$dispatch("1080753848", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1489297102") ? ((Boolean) ipChange.ipc$dispatch("-1489297102", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.cityId) || this.performId == 0 || this.itemId == 0) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838648595")) {
            ipChange.ipc$dispatch("1838648595", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeLong(this.itemId);
        parcel.writeLong(this.performId);
        parcel.writeString(this.cityId);
    }

    public SeatPreloadExtra(int i, long j, long j2, String str) {
        this.type = i;
        this.itemId = j;
        this.performId = j2;
        this.cityId = str;
    }

    @Nullable
    public static SeatPreloadExtra obtainExtra(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696668369")) {
            return (SeatPreloadExtra) ipChange.ipc$dispatch("696668369", new Object[]{bundle});
        }
        if (bundle != null) {
            return (SeatPreloadExtra) bundle.getParcelable(NcovSkuActivity.KEY_SEAT_PRELOAD_EXTRA);
        }
        return null;
    }

    protected SeatPreloadExtra(Parcel parcel) {
        this.type = parcel.readInt();
        this.itemId = parcel.readLong();
        this.performId = parcel.readLong();
        this.cityId = parcel.readString();
    }
}
