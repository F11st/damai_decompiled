package cn.damai.commonbusiness.seatbiz.sku.wolf.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PerformPrice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PerformPrice> CREATOR = new Parcelable.Creator<PerformPrice>() { // from class: cn.damai.commonbusiness.seatbiz.sku.wolf.bean.PerformPrice.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PerformPrice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1114001291") ? (PerformPrice) ipChange.ipc$dispatch("1114001291", new Object[]{this, parcel}) : new PerformPrice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PerformPrice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1807190178") ? (PerformPrice[]) ipChange.ipc$dispatch("1807190178", new Object[]{this, Integer.valueOf(i)}) : new PerformPrice[i];
        }
    };
    private int buyNowSum;
    private boolean isSelected;
    private int num;
    private boolean packagesFlag;
    private double price;
    private long priceId;
    private String priceName;
    private int priceStatus;

    public PerformPrice() {
        this.num = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024434697")) {
            return ((Integer) ipChange.ipc$dispatch("2024434697", new Object[]{this})).intValue();
        }
        return 0;
    }

    public int getBuyNowSum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "72529673") ? ((Integer) ipChange.ipc$dispatch("72529673", new Object[]{this})).intValue() : this.buyNowSum;
    }

    public int getNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1390517666") ? ((Integer) ipChange.ipc$dispatch("-1390517666", new Object[]{this})).intValue() : this.num;
    }

    public double getPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "212189878") ? ((Double) ipChange.ipc$dispatch("212189878", new Object[]{this})).doubleValue() : this.price;
    }

    public long getPriceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2083218145") ? ((Long) ipChange.ipc$dispatch("2083218145", new Object[]{this})).longValue() : this.priceId;
    }

    public String getPriceName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1369552771") ? (String) ipChange.ipc$dispatch("1369552771", new Object[]{this}) : this.priceName;
    }

    public int getPriceStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1922935593") ? ((Integer) ipChange.ipc$dispatch("1922935593", new Object[]{this})).intValue() : this.priceStatus;
    }

    public boolean isPackagesFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-47533156") ? ((Boolean) ipChange.ipc$dispatch("-47533156", new Object[]{this})).booleanValue() : this.packagesFlag;
    }

    public boolean isSelected() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1619546694") ? ((Boolean) ipChange.ipc$dispatch("-1619546694", new Object[]{this})).booleanValue() : this.isSelected;
    }

    public void setBuyNowSum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "417006881")) {
            ipChange.ipc$dispatch("417006881", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.buyNowSum = i;
        }
    }

    public void setNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780460396")) {
            ipChange.ipc$dispatch("1780460396", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.num = i;
        }
    }

    public void setPackagesFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352013760")) {
            ipChange.ipc$dispatch("352013760", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.packagesFlag = z;
        }
    }

    public void setPrice(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463030550")) {
            ipChange.ipc$dispatch("-463030550", new Object[]{this, Double.valueOf(d)});
        } else {
            this.price = d;
        }
    }

    public void setPriceId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1616453334")) {
            ipChange.ipc$dispatch("-1616453334", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.priceId = i;
        }
    }

    public void setPriceName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1836225363")) {
            ipChange.ipc$dispatch("1836225363", new Object[]{this, str});
        } else {
            this.priceName = str;
        }
    }

    public void setPriceStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "401524737")) {
            ipChange.ipc$dispatch("401524737", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.priceStatus = i;
        }
    }

    public void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101713566")) {
            ipChange.ipc$dispatch("-101713566", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isSelected = z;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "715672546")) {
            ipChange.ipc$dispatch("715672546", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.buyNowSum);
        parcel.writeByte(this.packagesFlag ? (byte) 1 : (byte) 0);
        parcel.writeDouble(this.price);
        parcel.writeLong(this.priceId);
        parcel.writeString(this.priceName);
        parcel.writeInt(this.priceStatus);
        parcel.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.num);
    }

    protected PerformPrice(Parcel parcel) {
        this.num = 1;
        this.buyNowSum = parcel.readInt();
        this.packagesFlag = parcel.readByte() != 0;
        this.price = parcel.readDouble();
        this.priceId = parcel.readInt();
        this.priceName = parcel.readString();
        this.priceStatus = parcel.readInt();
        this.isSelected = parcel.readByte() != 0;
        this.num = parcel.readInt();
    }
}
