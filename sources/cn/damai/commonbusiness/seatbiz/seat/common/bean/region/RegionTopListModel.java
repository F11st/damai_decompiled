package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionTopListModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RegionTopListModel> CREATOR = new Parcelable.Creator<RegionTopListModel>() { // from class: cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionTopListModel.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegionTopListModel createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1527068405") ? (RegionTopListModel) ipChange.ipc$dispatch("-1527068405", new Object[]{this, parcel}) : new RegionTopListModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegionTopListModel[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "868731930") ? (RegionTopListModel[]) ipChange.ipc$dispatch("868731930", new Object[]{this, Integer.valueOf(i)}) : new RegionTopListModel[i];
        }
    };
    private String color;
    private String cts;
    public float cutPrice;
    private List<RegionTopListDetailModel> detail;
    public List<Long> matixIdSet;
    private String ols;
    private String pots;
    private String priceFlag;
    public List<Float> priceSet;
    private long tpId;
    private String tpName;
    private String tpNum;
    private float tpPrice;

    private String getColorStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1030455911") ? (String) ipChange.ipc$dispatch("-1030455911", new Object[]{this}) : (TextUtils.isEmpty(this.color) || this.color.length() != 6) ? "FF0000" : this.color.toUpperCase();
    }

    @Nullable
    public SeatPrice fixedTaoPiao2SeatPrice(List<SeatPrice> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211085189")) {
            return (SeatPrice) ipChange.ipc$dispatch("211085189", new Object[]{this, list});
        }
        SeatPrice seatPrice = null;
        if (isOlsValid() && isFixedTaoPiao() && !TextUtils.isEmpty(this.color)) {
            if (!cb2.d(list) && !cb2.d(this.detail)) {
                try {
                    seatPrice = list.get(Integer.parseInt(this.detail.get(0).getPref()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            SeatPrice seatPrice2 = new SeatPrice();
            long j = this.tpId;
            seatPrice2.priceLevelId = j;
            seatPrice2.maitixPriceId = j;
            String colorStr = getColorStr();
            seatPrice2.priceColor = colorStr;
            seatPrice2.priceColorValue = Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + colorStr);
            seatPrice2.isTopTicket = true;
            seatPrice2.singlePriceValue = seatPrice == null ? -1.0f : seatPrice.priceValue;
            try {
                seatPrice2.tpNum = Integer.parseInt(this.tpNum);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            seatPrice2.priceValue = this.tpPrice;
            return seatPrice2;
        }
        return null;
    }

    public String getColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1293707950") ? (String) ipChange.ipc$dispatch("1293707950", new Object[]{this}) : this.color;
    }

    public String getCts() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1861015571") ? (String) ipChange.ipc$dispatch("-1861015571", new Object[]{this}) : this.cts;
    }

    @Nullable
    public List<RegionTopListDetailModel> getDetail() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-375690429") ? (List) ipChange.ipc$dispatch("-375690429", new Object[]{this}) : this.detail;
    }

    public String getOls() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-684162559") ? (String) ipChange.ipc$dispatch("-684162559", new Object[]{this}) : this.ols;
    }

    public String getPots() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2023356791") ? (String) ipChange.ipc$dispatch("-2023356791", new Object[]{this}) : this.pots;
    }

    public String getPriceFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1974085280") ? (String) ipChange.ipc$dispatch("1974085280", new Object[]{this}) : this.priceFlag;
    }

    public long getTpId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "24992850") ? ((Long) ipChange.ipc$dispatch("24992850", new Object[]{this})).longValue() : this.tpId;
    }

    public String getTpName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "681754226") ? (String) ipChange.ipc$dispatch("681754226", new Object[]{this}) : this.tpName;
    }

    public String getTpNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1185461557") ? (String) ipChange.ipc$dispatch("1185461557", new Object[]{this}) : this.tpNum;
    }

    public float getTpPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1992091880") ? ((Float) ipChange.ipc$dispatch("-1992091880", new Object[]{this})).floatValue() : this.tpPrice;
    }

    public boolean isFixedTaoPiao() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1317579332") ? ((Boolean) ipChange.ipc$dispatch("1317579332", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.pots) && this.pots.equals("0");
    }

    public boolean isModelValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1380502470") ? ((Boolean) ipChange.ipc$dispatch("1380502470", new Object[]{this})).booleanValue() : isOlsValid() && !TextUtils.isEmpty(this.cts) && this.cts.equals("1");
    }

    public boolean isOlsValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-502136365") ? ((Boolean) ipChange.ipc$dispatch("-502136365", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.ols) && this.ols.equals("0");
    }

    public void setColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353358968")) {
            ipChange.ipc$dispatch("-353358968", new Object[]{this, str});
        } else {
            this.color = str;
        }
    }

    public void setCts(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-438359767")) {
            ipChange.ipc$dispatch("-438359767", new Object[]{this, str});
        } else {
            this.cts = str;
        }
    }

    public void setDetail(List<RegionTopListDetailModel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851288553")) {
            ipChange.ipc$dispatch("1851288553", new Object[]{this, list});
        } else {
            this.detail = list;
        }
    }

    public void setOls(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1684345237")) {
            ipChange.ipc$dispatch("1684345237", new Object[]{this, str});
        } else {
            this.ols = str;
        }
    }

    public void setPots(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407692149")) {
            ipChange.ipc$dispatch("1407692149", new Object[]{this, str});
        } else {
            this.pots = str;
        }
    }

    public void setPriceFlag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-898103338")) {
            ipChange.ipc$dispatch("-898103338", new Object[]{this, str});
        } else {
            this.priceFlag = str;
        }
    }

    public void setTpId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686229298")) {
            ipChange.ipc$dispatch("686229298", new Object[]{this, Long.valueOf(j)});
        } else {
            this.tpId = j;
        }
    }

    public void setTpName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1735547476")) {
            ipChange.ipc$dispatch("-1735547476", new Object[]{this, str});
        } else {
            this.tpName = str;
        }
    }

    public void setTpNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585970145")) {
            ipChange.ipc$dispatch("585970145", new Object[]{this, str});
        } else {
            this.tpNum = str;
        }
    }

    public void setTpPrice(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897952012")) {
            ipChange.ipc$dispatch("897952012", new Object[]{this, Float.valueOf(f)});
        } else {
            this.tpPrice = f;
        }
    }

    public RegionTopListModel() {
    }

    private RegionTopListModel(Parcel parcel) {
        this.tpId = parcel.readLong();
        this.tpName = parcel.readString();
        this.tpPrice = parcel.readFloat();
        this.tpNum = parcel.readString();
        parcel.readTypedList(this.detail, RegionTopListDetailModel.CREATOR);
        this.ols = parcel.readString();
        this.cts = parcel.readString();
    }
}
