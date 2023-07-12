package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.commonbusiness.notice.bean.NoticeItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailMecItemInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<OrderDetailMecItemInfo> CREATOR = new Parcelable.Creator<OrderDetailMecItemInfo>() { // from class: cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailMecItemInfo.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailMecItemInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "569696939") ? (OrderDetailMecItemInfo) ipChange.ipc$dispatch("569696939", new Object[]{this, parcel}) : new OrderDetailMecItemInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderDetailMecItemInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "872934736") ? (OrderDetailMecItemInfo[]) ipChange.ipc$dispatch("872934736", new Object[]{this, Integer.valueOf(i)}) : new OrderDetailMecItemInfo[i];
        }
    };
    public ArrayList<NoticeItem> announcementList;
    public String changeShowTimeReason;
    public String isNewItem;
    public List<String> itemFeatureTags;
    public String itemId;
    public String itemUrl;
    public long oldShowDateTime;
    public String performId;
    public String performImageUrl;
    public String performName;
    public String projectCityName;
    public String projectName;
    public OrderDetailSeatImgBean seatImgBean;
    public List<OrderDetailSeatBean> seatList;
    public long showDateTime;
    public String showTimeRangeDetail;
    public String showTimeStr;
    public OrderDetailSkuInfo skuInfo;
    public String venueId;
    public String venueName;
    public OrderDetailSeatPic venueSeatPic;

    public OrderDetailMecItemInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563729385")) {
            return ((Integer) ipChange.ipc$dispatch("-563729385", new Object[]{this})).intValue();
        }
        return 0;
    }

    public boolean isChangeTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "481836678") ? ((Boolean) ipChange.ipc$dispatch("481836678", new Object[]{this})).booleanValue() : this.oldShowDateTime != 0;
    }

    public boolean isTimeValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-712127520") ? ((Boolean) ipChange.ipc$dispatch("-712127520", new Object[]{this})).booleanValue() : this.showDateTime != 0;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "731685069")) {
            ipChange.ipc$dispatch("731685069", new Object[]{this, parcel});
            return;
        }
        this.itemId = parcel.readString();
        this.itemUrl = parcel.readString();
        this.projectName = parcel.readString();
        this.projectCityName = parcel.readString();
        this.showTimeStr = parcel.readString();
        this.performImageUrl = parcel.readString();
        this.performId = parcel.readString();
        this.performName = parcel.readString();
        this.venueId = parcel.readString();
        this.venueName = parcel.readString();
        this.seatImgBean = (OrderDetailSeatImgBean) parcel.readParcelable(OrderDetailSeatImgBean.class.getClassLoader());
        this.showTimeRangeDetail = parcel.readString();
        this.changeShowTimeReason = parcel.readString();
        this.itemFeatureTags = parcel.createStringArrayList();
        this.seatList = parcel.createTypedArrayList(OrderDetailSeatBean.CREATOR);
        this.skuInfo = (OrderDetailSkuInfo) parcel.readParcelable(OrderDetailSkuInfo.class.getClassLoader());
        this.venueSeatPic = (OrderDetailSeatPic) parcel.readParcelable(OrderDetailSeatPic.class.getClassLoader());
        this.isNewItem = parcel.readString();
    }

    public ArrayList<ItemContent> subItemContentList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111221727")) {
            return (ArrayList) ipChange.ipc$dispatch("111221727", new Object[]{this});
        }
        ArrayList<ItemContent> arrayList = new ArrayList<>();
        if (!cb2.d(this.announcementList)) {
            Iterator<NoticeItem> it = this.announcementList.iterator();
            while (it.hasNext()) {
                NoticeItem next = it.next();
                if (!cb2.d(next.getContentList())) {
                    Iterator<ItemContent> it2 = next.getContentList().iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        ItemContent next2 = it2.next();
                        if (i == 0) {
                            next2.setRootTitle(next.getTitle());
                        }
                        arrayList.add(next2);
                        i++;
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143019116")) {
            ipChange.ipc$dispatch("-1143019116", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.itemId);
        parcel.writeString(this.itemUrl);
        parcel.writeString(this.projectName);
        parcel.writeString(this.projectCityName);
        parcel.writeString(this.showTimeStr);
        parcel.writeString(this.performImageUrl);
        parcel.writeString(this.performId);
        parcel.writeString(this.performName);
        parcel.writeString(this.venueId);
        parcel.writeString(this.venueName);
        parcel.writeParcelable(this.seatImgBean, i);
        parcel.writeString(this.showTimeRangeDetail);
        parcel.writeString(this.changeShowTimeReason);
        parcel.writeStringList(this.itemFeatureTags);
        parcel.writeTypedList(this.seatList);
        parcel.writeParcelable(this.skuInfo, i);
        parcel.writeParcelable(this.venueSeatPic, i);
        parcel.writeString(this.isNewItem);
    }

    protected OrderDetailMecItemInfo(Parcel parcel) {
        this.itemId = parcel.readString();
        this.itemUrl = parcel.readString();
        this.projectName = parcel.readString();
        this.projectCityName = parcel.readString();
        this.showTimeStr = parcel.readString();
        this.performImageUrl = parcel.readString();
        this.performId = parcel.readString();
        this.performName = parcel.readString();
        this.venueId = parcel.readString();
        this.venueName = parcel.readString();
        this.seatImgBean = (OrderDetailSeatImgBean) parcel.readParcelable(OrderDetailSeatImgBean.class.getClassLoader());
        this.showTimeRangeDetail = parcel.readString();
        this.changeShowTimeReason = parcel.readString();
        this.itemFeatureTags = parcel.createStringArrayList();
        this.seatList = parcel.createTypedArrayList(OrderDetailSeatBean.CREATOR);
        this.skuInfo = (OrderDetailSkuInfo) parcel.readParcelable(OrderDetailSkuInfo.class.getClassLoader());
        this.venueSeatPic = (OrderDetailSeatPic) parcel.readParcelable(OrderDetailSeatPic.class.getClassLoader());
        this.isNewItem = parcel.readString();
    }
}
