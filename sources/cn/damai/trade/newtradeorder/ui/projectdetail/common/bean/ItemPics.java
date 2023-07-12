package cn.damai.trade.newtradeorder.ui.projectdetail.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ItemPics implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ItemPics> CREATOR = new Parcelable.Creator<ItemPics>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ItemPics.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ItemPics createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1557733323") ? (ItemPics) ipChange.ipc$dispatch("1557733323", new Object[]{this, parcel}) : new ItemPics(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ItemPics[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "395639510") ? (ItemPics[]) ipChange.ipc$dispatch("395639510", new Object[]{this, Integer.valueOf(i)}) : new ItemPics[i];
        }
    };
    public ArrayList<PicInfo> itemPicList;

    public ItemPics() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134617135")) {
            return ((Integer) ipChange.ipc$dispatch("1134617135", new Object[]{this})).intValue();
        }
        return 0;
    }

    public ArrayList<PicInfo> getItemPicList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1162456228") ? (ArrayList) ipChange.ipc$dispatch("-1162456228", new Object[]{this}) : this.itemPicList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448355452")) {
            ipChange.ipc$dispatch("1448355452", new Object[]{this, parcel, Integer.valueOf(i)});
        } else {
            parcel.writeTypedList(this.itemPicList);
        }
    }

    protected ItemPics(Parcel parcel) {
        this.itemPicList = parcel.createTypedArrayList(PicInfo.CREATOR);
    }
}
