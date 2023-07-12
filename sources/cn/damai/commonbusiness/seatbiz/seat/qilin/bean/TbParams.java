package cn.damai.commonbusiness.seatbiz.seat.qilin.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetailPriceInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BasicInfoBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.eb;
import tb.fr1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TbParams implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<TbParams> CREATOR = new Parcelable.Creator<TbParams>() { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TbParams createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1682646165") ? (TbParams) ipChange.ipc$dispatch("-1682646165", new Object[]{this, parcel}) : new TbParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TbParams[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1457356980") ? (TbParams[]) ipChange.ipc$dispatch("1457356980", new Object[]{this, Integer.valueOf(i)}) : new TbParams[i];
        }
    };
    public int atomSplit;
    public long basketNo;
    public String cityId;
    public boolean firstPayChooseSeat;
    public boolean h5NewUltron;
    @Deprecated
    public String h5Privilege;
    public boolean hasPromotion;
    @Deprecated
    public boolean isUseNewUltron;
    public long itemId;
    public int itemLimitPerOrder;
    public int limitCount;
    public String openRegionId;
    public String orderId;
    public String payFirstPriceIds;
    public long performId;
    public String privilegeId;
    public long projectId;
    public long skuId;
    public long xorPerformId;

    public TbParams() {
        this.atomSplit = 1;
        this.hasPromotion = false;
        this.basketNo = -1L;
        this.isUseNewUltron = false;
        this.h5NewUltron = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867444448")) {
            return ((Integer) ipChange.ipc$dispatch("-867444448", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isOpenSeatDirect() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1705139436") ? ((Boolean) ipChange.ipc$dispatch("-1705139436", new Object[]{this})).booleanValue() : this.basketNo != -1;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555593500")) {
            ipChange.ipc$dispatch("-1555593500", new Object[]{this, parcel});
            return;
        }
        this.firstPayChooseSeat = parcel.readByte() != 0;
        this.cityId = parcel.readString();
        this.projectId = parcel.readLong();
        this.itemId = parcel.readLong();
        this.performId = parcel.readLong();
        this.atomSplit = parcel.readInt();
        this.privilegeId = parcel.readString();
        this.hasPromotion = parcel.readByte() != 0;
        this.orderId = parcel.readString();
        this.payFirstPriceIds = parcel.readString();
        this.xorPerformId = parcel.readLong();
        this.limitCount = parcel.readInt();
        this.itemLimitPerOrder = parcel.readInt();
        this.basketNo = parcel.readLong();
        this.openRegionId = parcel.readString();
        this.isUseNewUltron = parcel.readByte() != 0;
        this.h5Privilege = parcel.readString();
        this.skuId = parcel.readLong();
        this.h5NewUltron = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "864669611")) {
            ipChange.ipc$dispatch("864669611", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeByte(this.firstPayChooseSeat ? (byte) 1 : (byte) 0);
        parcel.writeString(this.cityId);
        parcel.writeLong(this.projectId);
        parcel.writeLong(this.itemId);
        parcel.writeLong(this.performId);
        parcel.writeInt(this.atomSplit);
        parcel.writeString(this.privilegeId);
        parcel.writeByte(this.hasPromotion ? (byte) 1 : (byte) 0);
        parcel.writeString(this.orderId);
        parcel.writeString(this.payFirstPriceIds);
        parcel.writeLong(this.xorPerformId);
        parcel.writeInt(this.limitCount);
        parcel.writeInt(this.itemLimitPerOrder);
        parcel.writeLong(this.basketNo);
        parcel.writeString(this.openRegionId);
        parcel.writeByte(this.isUseNewUltron ? (byte) 1 : (byte) 0);
        parcel.writeString(this.h5Privilege);
        parcel.writeLong(this.skuId);
        parcel.writeByte(this.h5NewUltron ? (byte) 1 : (byte) 0);
    }

    public TbParams(TbParams tbParams) {
        this.atomSplit = 1;
        this.hasPromotion = false;
        this.basketNo = -1L;
        this.isUseNewUltron = false;
        this.h5NewUltron = false;
        this.firstPayChooseSeat = tbParams.firstPayChooseSeat;
        this.cityId = tbParams.cityId;
        this.projectId = tbParams.projectId;
        this.itemId = tbParams.itemId;
        this.performId = tbParams.performId;
        this.atomSplit = tbParams.atomSplit;
        this.privilegeId = tbParams.privilegeId;
        this.orderId = tbParams.orderId;
        this.payFirstPriceIds = tbParams.payFirstPriceIds;
        this.xorPerformId = tbParams.xorPerformId;
        this.limitCount = tbParams.limitCount;
        this.itemLimitPerOrder = tbParams.itemLimitPerOrder;
        this.basketNo = tbParams.basketNo;
        this.openRegionId = tbParams.openRegionId;
        this.isUseNewUltron = tbParams.isUseNewUltron;
        this.skuId = tbParams.skuId;
        this.h5Privilege = tbParams.h5Privilege;
        this.h5NewUltron = tbParams.h5NewUltron;
        this.hasPromotion = tbParams.hasPromotion;
    }

    public TbParams(TbParams tbParams, BasicInfoBean basicInfoBean, PerformBean performBean, boolean z, boolean z2) {
        this.atomSplit = 1;
        this.hasPromotion = false;
        this.basketNo = -1L;
        this.isUseNewUltron = false;
        this.h5NewUltron = false;
        this.firstPayChooseSeat = false;
        this.projectId = basicInfoBean.projectId;
        this.itemId = basicInfoBean.itemId;
        long j = performBean.performId;
        this.performId = j;
        this.limitCount = performBean.limitQuantity;
        this.itemLimitPerOrder = performBean.itemLimitPerOrder;
        this.privilegeId = tbParams.privilegeId;
        this.atomSplit = tbParams.atomSplit;
        this.cityId = tbParams.cityId;
        this.skuId = 0L;
        this.xorPerformId = fr1.a(j);
        if (eb.b(tbParams.privilegeId)) {
            this.h5Privilege = null;
        } else {
            this.h5Privilege = H5Privilege.toH5Privilege(this.privilegeId, performBean);
        }
        this.isUseNewUltron = z;
        this.h5NewUltron = z2;
        this.hasPromotion = performBean.hasPromotion;
    }

    public TbParams(String str, long j, long j2, long j3, int i, long j4, int i2, int i3, String str2, boolean z, boolean z2, String str3, boolean z3) {
        this.atomSplit = 1;
        this.hasPromotion = false;
        this.basketNo = -1L;
        this.isUseNewUltron = false;
        this.h5NewUltron = false;
        this.firstPayChooseSeat = false;
        this.cityId = str;
        this.projectId = j;
        this.itemId = j2;
        this.performId = j3;
        this.privilegeId = str2;
        this.atomSplit = i;
        this.skuId = j4;
        this.limitCount = i2;
        this.itemLimitPerOrder = i3;
        this.xorPerformId = fr1.a(j3);
        this.isUseNewUltron = z;
        this.h5Privilege = str3;
        this.h5NewUltron = z2;
        this.hasPromotion = z3;
    }

    public TbParams(String str, String str2, long j, long j2, String str3, List<OrderDetailPriceInfo> list) {
        long j3;
        this.atomSplit = 1;
        int i = 0;
        this.hasPromotion = false;
        this.basketNo = -1L;
        this.isUseNewUltron = false;
        this.h5NewUltron = false;
        this.firstPayChooseSeat = true;
        try {
            j3 = Long.parseLong(str2);
        } catch (Exception e) {
            e.printStackTrace();
            j3 = 0;
        }
        this.cityId = str;
        this.projectId = j3;
        this.itemId = j;
        this.performId = j2;
        this.orderId = str3;
        this.xorPerformId = fr1.a(j2);
        if (cb2.d(list)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (OrderDetailPriceInfo orderDetailPriceInfo : list) {
            sb.append(orderDetailPriceInfo.priceId);
            sb.append(",");
            try {
                i += Integer.parseInt(orderDetailPriceInfo.buyQuantity);
            } catch (Exception unused) {
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        this.payFirstPriceIds = sb.toString();
        this.limitCount = i;
    }

    protected TbParams(Parcel parcel) {
        this.atomSplit = 1;
        this.hasPromotion = false;
        this.basketNo = -1L;
        this.isUseNewUltron = false;
        this.h5NewUltron = false;
        this.firstPayChooseSeat = parcel.readByte() != 0;
        this.cityId = parcel.readString();
        this.projectId = parcel.readLong();
        this.itemId = parcel.readLong();
        this.performId = parcel.readLong();
        this.atomSplit = parcel.readInt();
        this.privilegeId = parcel.readString();
        this.hasPromotion = parcel.readByte() != 0;
        this.orderId = parcel.readString();
        this.payFirstPriceIds = parcel.readString();
        this.xorPerformId = parcel.readLong();
        this.limitCount = parcel.readInt();
        this.itemLimitPerOrder = parcel.readInt();
        this.basketNo = parcel.readLong();
        this.openRegionId = parcel.readString();
        this.isUseNewUltron = parcel.readByte() != 0;
        this.h5Privilege = parcel.readString();
        this.skuId = parcel.readLong();
        this.h5NewUltron = parcel.readByte() != 0;
    }
}
