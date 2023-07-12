package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ItemPics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectStaticItemBaseBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectStaticItemBaseBean> CREATOR = new Parcelable.Creator<ProjectStaticItemBaseBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticItemBaseBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1709810197") ? (ProjectStaticItemBaseBean) ipChange.ipc$dispatch("-1709810197", new Object[]{this, parcel}) : new ProjectStaticItemBaseBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectStaticItemBaseBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1190414952") ? (ProjectStaticItemBaseBean[]) ipChange.ipc$dispatch("1190414952", new Object[]{this, Integer.valueOf(i)}) : new ProjectStaticItemBaseBean[i];
        }
    };
    public int atomSplit;
    public long categoryId;
    public GeneralAgentBean generalAgent;
    public String hasNoneSeatImg;
    public boolean hasServiceFee;
    public String hasSkuPopup;
    public String isHotProject;
    public String isShowHotProjectModel;
    public long itemId;
    public String itemName;
    public ItemPics itemPics;
    public int itemType;
    public String nationalStandardCityId;
    public int oldCompanyId;
    public ArrayList<PerformSeatImageBean> performSeatImages;
    public String projectStatus;
    public List<String> seatImages;
    public ArrayList<ServiceNote> serviceNotes;
    public long sfpt;
    public String sfptPrefix;
    public String sfptSuffix;
    public String sfptTip;
    public String showDuration;
    public List<String> showTag;
    public String showTime;
    public String subTitle;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class GeneralAgentBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<GeneralAgentBean> CREATOR = new Parcelable.Creator<GeneralAgentBean>() { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean.GeneralAgentBean.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GeneralAgentBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-445736793") ? (GeneralAgentBean) ipChange.ipc$dispatch("-445736793", new Object[]{this, parcel}) : new GeneralAgentBean(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GeneralAgentBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "102190096") ? (GeneralAgentBean[]) ipChange.ipc$dispatch("102190096", new Object[]{this, Integer.valueOf(i)}) : new GeneralAgentBean[i];
            }
        };
        private String description;
        private String generalAgent;
        private int generalType;

        public GeneralAgentBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "474891033")) {
                return ((Integer) ipChange.ipc$dispatch("474891033", new Object[]{this})).intValue();
            }
            return 0;
        }

        public String getDescription() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1104542203") ? (String) ipChange.ipc$dispatch("1104542203", new Object[]{this}) : this.description;
        }

        public String getGeneralAgent() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-29009772") ? (String) ipChange.ipc$dispatch("-29009772", new Object[]{this}) : this.generalAgent;
        }

        public int getGeneralType() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "808717106") ? ((Integer) ipChange.ipc$dispatch("808717106", new Object[]{this})).intValue() : this.generalType;
        }

        public void setDescription(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1876085979")) {
                ipChange.ipc$dispatch("1876085979", new Object[]{this, str});
            } else {
                this.description = str;
            }
        }

        public void setGeneralAgent(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-501421878")) {
                ipChange.ipc$dispatch("-501421878", new Object[]{this, str});
            } else {
                this.generalAgent = str;
            }
        }

        public void setGeneralType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "220490008")) {
                ipChange.ipc$dispatch("220490008", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.generalType = i;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1351911726")) {
                ipChange.ipc$dispatch("-1351911726", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.description);
            parcel.writeString(this.generalAgent);
            parcel.writeInt(this.generalType);
        }

        protected GeneralAgentBean(Parcel parcel) {
            this.description = parcel.readString();
            this.generalAgent = parcel.readString();
            this.generalType = parcel.readInt();
        }
    }

    public ProjectStaticItemBaseBean() {
        this.atomSplit = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1277207098")) {
            return ((Integer) ipChange.ipc$dispatch("-1277207098", new Object[]{this})).intValue();
        }
        return 0;
    }

    public int getAtomSplit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "914584056") ? ((Integer) ipChange.ipc$dispatch("914584056", new Object[]{this})).intValue() : this.atomSplit;
    }

    public long getCategoryId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1361755721") ? ((Long) ipChange.ipc$dispatch("-1361755721", new Object[]{this})).longValue() : this.categoryId;
    }

    public GeneralAgentBean getGeneralAgent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1320153502") ? (GeneralAgentBean) ipChange.ipc$dispatch("-1320153502", new Object[]{this}) : this.generalAgent;
    }

    public Boolean getHasServiceFee() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "854810240") ? (Boolean) ipChange.ipc$dispatch("854810240", new Object[]{this}) : Boolean.valueOf(this.hasServiceFee);
    }

    public String getHasSkuPopup() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1421282683") ? (String) ipChange.ipc$dispatch("1421282683", new Object[]{this}) : this.hasSkuPopup;
    }

    public String getIsHotProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-619593062") ? (String) ipChange.ipc$dispatch("-619593062", new Object[]{this}) : this.isHotProject;
    }

    public String getIsShowHotProjectModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "42107944") ? (String) ipChange.ipc$dispatch("42107944", new Object[]{this}) : this.isShowHotProjectModel;
    }

    public long getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1391397822") ? ((Long) ipChange.ipc$dispatch("-1391397822", new Object[]{this})).longValue() : this.itemId;
    }

    public String getItemName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1398456450") ? (String) ipChange.ipc$dispatch("1398456450", new Object[]{this}) : this.itemName;
    }

    public ItemPics getItemPics() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1966094649") ? (ItemPics) ipChange.ipc$dispatch("1966094649", new Object[]{this}) : this.itemPics;
    }

    public List<PerformSeatImageBean> getListPerformSeatImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1540092154") ? (List) ipChange.ipc$dispatch("-1540092154", new Object[]{this}) : this.performSeatImages;
    }

    public List<String> getListSeatImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-246215463") ? (List) ipChange.ipc$dispatch("-246215463", new Object[]{this}) : this.seatImages;
    }

    public String getNationalStandardCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-324080039") ? (String) ipChange.ipc$dispatch("-324080039", new Object[]{this}) : this.nationalStandardCityId;
    }

    public ArrayList<ServiceNote> getServiceNotes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "726059178") ? (ArrayList) ipChange.ipc$dispatch("726059178", new Object[]{this}) : this.serviceNotes;
    }

    public long getSfpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "277537113") ? ((Long) ipChange.ipc$dispatch("277537113", new Object[]{this})).longValue() : this.sfpt;
    }

    public String getSfptPrefix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1755943027") ? (String) ipChange.ipc$dispatch("-1755943027", new Object[]{this}) : this.sfptPrefix;
    }

    public String getSfptTip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-319406922") ? (String) ipChange.ipc$dispatch("-319406922", new Object[]{this}) : this.sfptTip;
    }

    public String getShowDuration() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1775780875") ? (String) ipChange.ipc$dispatch("-1775780875", new Object[]{this}) : this.showDuration;
    }

    public List<String> getShowTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "253213046") ? (List) ipChange.ipc$dispatch("253213046", new Object[]{this}) : this.showTag;
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2119260754") ? (String) ipChange.ipc$dispatch("-2119260754", new Object[]{this}) : this.showTime;
    }

    public String getSubTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1780133060") ? (String) ipChange.ipc$dispatch("-1780133060", new Object[]{this}) : this.subTitle;
    }

    public boolean isHasNoneSeatImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "235543878") ? ((Boolean) ipChange.ipc$dispatch("235543878", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.hasNoneSeatImg) && this.hasNoneSeatImg.equals("true");
    }

    public boolean isHasSkuPopup() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1808594871") ? ((Boolean) ipChange.ipc$dispatch("1808594871", new Object[]{this})).booleanValue() : TextUtils.equals("true", this.hasSkuPopup);
    }

    public boolean isProjectCancel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "872205581") ? ((Boolean) ipChange.ipc$dispatch("872205581", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.projectStatus) && this.projectStatus.equals("3");
    }

    public boolean isProjectNATType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1102068464") ? ((Boolean) ipChange.ipc$dispatch("-1102068464", new Object[]{this})).booleanValue() : this.itemType == 4;
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "591733502")) {
            ipChange.ipc$dispatch("591733502", new Object[]{this, parcel});
            return;
        }
        this.categoryId = parcel.readLong();
        this.atomSplit = parcel.readInt();
        this.isShowHotProjectModel = parcel.readString();
        this.projectStatus = parcel.readString();
        this.itemType = parcel.readInt();
        this.isHotProject = parcel.readString();
        this.generalAgent = (GeneralAgentBean) parcel.readParcelable(GeneralAgentBean.class.getClassLoader());
        this.itemId = parcel.readLong();
        this.itemName = parcel.readString();
        this.itemPics = (ItemPics) parcel.readParcelable(ItemPics.class.getClassLoader());
        this.seatImages = parcel.createStringArrayList();
        this.performSeatImages = parcel.createTypedArrayList(PerformSeatImageBean.CREATOR);
        this.hasNoneSeatImg = parcel.readString();
        this.nationalStandardCityId = parcel.readString();
        this.oldCompanyId = parcel.readInt();
        this.showTime = parcel.readString();
        this.subTitle = parcel.readString();
        this.showDuration = parcel.readString();
        this.hasSkuPopup = parcel.readString();
        this.showTag = parcel.createStringArrayList();
        this.serviceNotes = parcel.createTypedArrayList(ServiceNote.CREATOR);
        this.hasServiceFee = parcel.readByte() != 0;
        this.sfpt = parcel.readLong();
        this.sfptPrefix = parcel.readString();
        this.sfptTip = parcel.readString();
    }

    public void setAtomSplit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750888978")) {
            ipChange.ipc$dispatch("750888978", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.atomSplit = i;
        }
    }

    public void setCategoryId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204876435")) {
            ipChange.ipc$dispatch("-204876435", new Object[]{this, Long.valueOf(j)});
        } else {
            this.categoryId = j;
        }
    }

    public void setItemId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590502466")) {
            ipChange.ipc$dispatch("590502466", new Object[]{this, Long.valueOf(j)});
        } else {
            this.itemId = j;
        }
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154901776")) {
            ipChange.ipc$dispatch("-1154901776", new Object[]{this, str});
        } else {
            this.showTime = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282970683")) {
            ipChange.ipc$dispatch("-1282970683", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.categoryId);
        parcel.writeInt(this.atomSplit);
        parcel.writeString(this.isShowHotProjectModel);
        parcel.writeString(this.projectStatus);
        parcel.writeInt(this.itemType);
        parcel.writeString(this.isHotProject);
        parcel.writeParcelable(this.generalAgent, i);
        parcel.writeLong(this.itemId);
        parcel.writeString(this.itemName);
        parcel.writeParcelable(this.itemPics, i);
        parcel.writeStringList(this.seatImages);
        parcel.writeTypedList(this.performSeatImages);
        parcel.writeString(this.hasNoneSeatImg);
        parcel.writeString(this.nationalStandardCityId);
        parcel.writeInt(this.oldCompanyId);
        parcel.writeString(this.showTime);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.showDuration);
        parcel.writeString(this.hasSkuPopup);
        parcel.writeStringList(this.showTag);
        parcel.writeTypedList(this.serviceNotes);
        parcel.writeByte(this.hasServiceFee ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.sfpt);
        parcel.writeString(this.sfptPrefix);
        parcel.writeString(this.sfptTip);
    }

    protected ProjectStaticItemBaseBean(Parcel parcel) {
        this.atomSplit = 1;
        this.categoryId = parcel.readLong();
        this.atomSplit = parcel.readInt();
        this.isShowHotProjectModel = parcel.readString();
        this.projectStatus = parcel.readString();
        this.itemType = parcel.readInt();
        this.isHotProject = parcel.readString();
        this.generalAgent = (GeneralAgentBean) parcel.readParcelable(GeneralAgentBean.class.getClassLoader());
        this.itemId = parcel.readLong();
        this.itemName = parcel.readString();
        this.itemPics = (ItemPics) parcel.readParcelable(ItemPics.class.getClassLoader());
        this.seatImages = parcel.createStringArrayList();
        this.performSeatImages = parcel.createTypedArrayList(PerformSeatImageBean.CREATOR);
        this.hasNoneSeatImg = parcel.readString();
        this.nationalStandardCityId = parcel.readString();
        this.oldCompanyId = parcel.readInt();
        this.showTime = parcel.readString();
        this.subTitle = parcel.readString();
        this.showDuration = parcel.readString();
        this.hasSkuPopup = parcel.readString();
        this.showTag = parcel.createStringArrayList();
        this.serviceNotes = parcel.createTypedArrayList(ServiceNote.CREATOR);
        this.hasServiceFee = parcel.readByte() != 0;
        this.sfpt = parcel.readLong();
        this.sfptPrefix = parcel.readString();
        this.sfptTip = parcel.readString();
    }
}
