package cn.damai.commonbusiness.seatbiz.seat.common.bean.seat;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes.dex */
public class SeatPrice implements Parcelable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SeatPrice> CREATOR = new Parcelable.Creator<SeatPrice>() { // from class: cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeatPrice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1637306087") ? (SeatPrice) ipChange.ipc$dispatch("-1637306087", new Object[]{this, parcel}) : new SeatPrice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeatPrice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1675954992") ? (SeatPrice[]) ipChange.ipc$dispatch("1675954992", new Object[]{this, Integer.valueOf(i)}) : new SeatPrice[i];
        }
    };
    public boolean buyPermission;
    public boolean isTopTicket;
    public long maitixPriceId;
    private String message;
    public String priceColor;
    public int priceColorValue;
    public boolean priceEnable;
    public long priceLevelId;
    public String priceLevelName;
    public float priceValue;
    public float singlePriceValue;
    public int sum;
    private String tpName;
    public int tpNum;
    private float tpPrice;

    public SeatPrice() {
        this.isTopTicket = false;
        this.priceEnable = true;
        this.buyPermission = true;
    }

    public Object clone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-627707881")) {
            return ipChange.ipc$dispatch("-627707881", new Object[]{this});
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new SeatPrice(this);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1707647264")) {
            return ((Integer) ipChange.ipc$dispatch("-1707647264", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179090605")) {
            return ((Boolean) ipChange.ipc$dispatch("-1179090605", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SeatPrice seatPrice = (SeatPrice) obj;
        return this.priceLevelId == seatPrice.priceLevelId && this.maitixPriceId == seatPrice.maitixPriceId;
    }

    public String getMessage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-50016673") ? (String) ipChange.ipc$dispatch("-50016673", new Object[]{this}) : this.message;
    }

    public float getPriceValue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1106933130") ? ((Float) ipChange.ipc$dispatch("1106933130", new Object[]{this})).floatValue() : this.priceValue;
    }

    public String getTpName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "116186053") ? (String) ipChange.ipc$dispatch("116186053", new Object[]{this}) : this.tpName;
    }

    public float getTpPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1629502059") ? ((Float) ipChange.ipc$dispatch("1629502059", new Object[]{this})).floatValue() : this.tpPrice;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "287275786")) {
            return ((Integer) ipChange.ipc$dispatch("287275786", new Object[]{this})).intValue();
        }
        long j = this.priceLevelId;
        long j2 = this.maitixPriceId;
        return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean isTopTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-901628251") ? ((Boolean) ipChange.ipc$dispatch("-901628251", new Object[]{this})).booleanValue() : this.isTopTicket;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1853721590") ? ((Boolean) ipChange.ipc$dispatch("-1853721590", new Object[]{this})).booleanValue() : this.buyPermission && this.priceEnable;
    }

    public void setIsTopTicket(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010766281")) {
            ipChange.ipc$dispatch("-2010766281", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isTopTicket = z;
        }
    }

    public void setMessage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1128196855")) {
            ipChange.ipc$dispatch("1128196855", new Object[]{this, str});
        } else {
            this.message = str;
        }
    }

    public void setPriceValue(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984937102")) {
            ipChange.ipc$dispatch("-984937102", new Object[]{this, Float.valueOf(f)});
        } else {
            this.priceValue = f;
        }
    }

    public void setTpName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088291655")) {
            ipChange.ipc$dispatch("-2088291655", new Object[]{this, str});
        } else {
            this.tpName = str;
        }
    }

    public void setTpPrice(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498214425")) {
            ipChange.ipc$dispatch("1498214425", new Object[]{this, Float.valueOf(f)});
        } else {
            this.tpPrice = f;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790461973")) {
            ipChange.ipc$dispatch("-790461973", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.priceLevelId);
        parcel.writeLong(this.maitixPriceId);
        parcel.writeString(this.priceColor);
        parcel.writeFloat(this.priceValue);
        parcel.writeString(this.priceLevelName);
        parcel.writeInt(this.sum);
        parcel.writeByte(this.isTopTicket ? (byte) 1 : (byte) 0);
        parcel.writeString(this.tpName);
        parcel.writeFloat(this.tpPrice);
    }

    protected SeatPrice(Parcel parcel) {
        this.isTopTicket = false;
        this.priceEnable = true;
        this.buyPermission = true;
        this.priceLevelId = parcel.readLong();
        this.maitixPriceId = parcel.readLong();
        this.priceColor = parcel.readString();
        this.priceValue = parcel.readFloat();
        this.priceLevelName = parcel.readString();
        this.sum = parcel.readInt();
        this.isTopTicket = parcel.readByte() != 0;
        this.tpName = parcel.readString();
        this.tpPrice = parcel.readFloat();
    }

    public SeatPrice(SeatPrice seatPrice) {
        this.isTopTicket = false;
        this.priceEnable = true;
        this.buyPermission = true;
        this.message = seatPrice.message;
        this.priceLevelId = seatPrice.priceLevelId;
        this.maitixPriceId = seatPrice.maitixPriceId;
        this.priceColor = seatPrice.priceColor;
        this.priceColorValue = seatPrice.priceColorValue;
        this.priceValue = seatPrice.priceValue;
        this.priceLevelName = seatPrice.priceLevelName;
        this.sum = seatPrice.sum;
        this.isTopTicket = seatPrice.isTopTicket;
        this.singlePriceValue = seatPrice.singlePriceValue;
        this.tpNum = seatPrice.tpNum;
        this.priceEnable = seatPrice.priceEnable;
        this.tpName = seatPrice.tpName;
        this.tpPrice = seatPrice.tpPrice;
        this.buyPermission = seatPrice.buyPermission;
    }
}
