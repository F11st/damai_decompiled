package cn.damai.commonbusiness.address.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AddressBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<AddressBean> CREATOR = new Parcelable.Creator<AddressBean>() { // from class: cn.damai.commonbusiness.address.bean.AddressBean.1
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddressBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "787052523") ? (AddressBean) ipChange.ipc$dispatch("787052523", new Object[]{this, parcel}) : new AddressBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddressBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-906347044") ? (AddressBean[]) ipChange.ipc$dispatch("-906347044", new Object[]{this, Integer.valueOf(i)}) : new AddressBean[i];
        }
    };
    private String addressDetail;
    private String addressId;
    private String addressName;
    private String addressStatus;
    private Boolean checked;
    private String city;
    private String cityCode;
    private String consigneeName;
    private String county;
    private String countyCode;
    private String dmCity;
    private String dmCityCode;
    private String dmCounty;
    private String dmCountyCode;
    private String dmProvince;
    private String dmProvinceCode;
    private String email;
    private String gmtCreate;
    private String gmtModified;
    private String isDefault;
    private String match;
    private String mobile;
    private String nationPrefix;
    private String needImprove;
    private String province;
    private String provinceCode;
    private String street;
    private String streetCode;
    private String telephone;
    private String userId;
    private String version;
    private String zipCode;

    public AddressBean() {
        this.checked = Boolean.FALSE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371191924")) {
            return ((Integer) ipChange.ipc$dispatch("-1371191924", new Object[]{this})).intValue();
        }
        return 0;
    }

    public String getAddressDetail() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "220698065") ? (String) ipChange.ipc$dispatch("220698065", new Object[]{this}) : this.addressDetail;
    }

    public String getAddressId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "755409947") ? (String) ipChange.ipc$dispatch("755409947", new Object[]{this}) : this.addressId;
    }

    public String getAddressName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "170369099") ? (String) ipChange.ipc$dispatch("170369099", new Object[]{this}) : this.addressName;
    }

    public String getAddressStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1539060466") ? (String) ipChange.ipc$dispatch("1539060466", new Object[]{this}) : this.addressStatus;
    }

    public Boolean getChecked() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1264654166") ? (Boolean) ipChange.ipc$dispatch("-1264654166", new Object[]{this}) : this.checked;
    }

    public String getCity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1924677771") ? (String) ipChange.ipc$dispatch("-1924677771", new Object[]{this}) : this.city;
    }

    public String getCityCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1157919746") ? (String) ipChange.ipc$dispatch("1157919746", new Object[]{this}) : this.cityCode;
    }

    public String getConsigneeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2009274826") ? (String) ipChange.ipc$dispatch("-2009274826", new Object[]{this}) : this.consigneeName;
    }

    public String getCounty() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-541499884") ? (String) ipChange.ipc$dispatch("-541499884", new Object[]{this}) : this.county;
    }

    public String getCountyCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1304974559") ? (String) ipChange.ipc$dispatch("-1304974559", new Object[]{this}) : this.countyCode;
    }

    public String getDmCity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "770453854") ? (String) ipChange.ipc$dispatch("770453854", new Object[]{this}) : this.dmCity;
    }

    public String getDmCityCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "953928043") ? (String) ipChange.ipc$dispatch("953928043", new Object[]{this}) : this.dmCityCode;
    }

    public String getDmCounty() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-385287747") ? (String) ipChange.ipc$dispatch("-385287747", new Object[]{this}) : this.dmCounty;
    }

    public String getDmCountyCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "227494474") ? (String) ipChange.ipc$dispatch("227494474", new Object[]{this}) : this.dmCountyCode;
    }

    public String getDmProvince() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2030508707") ? (String) ipChange.ipc$dispatch("2030508707", new Object[]{this}) : this.dmProvince;
    }

    public String getDmProvinceCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1042712624") ? (String) ipChange.ipc$dispatch("1042712624", new Object[]{this}) : this.dmProvinceCode;
    }

    public String getEmail() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-397379704") ? (String) ipChange.ipc$dispatch("-397379704", new Object[]{this}) : this.email;
    }

    public String getGmtCreate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "911911766") ? (String) ipChange.ipc$dispatch("911911766", new Object[]{this}) : this.gmtCreate;
    }

    public String getGmtModified() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-51528477") ? (String) ipChange.ipc$dispatch("-51528477", new Object[]{this}) : this.gmtModified;
    }

    public String getIsDefault() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-538364509") ? (String) ipChange.ipc$dispatch("-538364509", new Object[]{this}) : this.isDefault;
    }

    public String getMatch() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1642616625") ? (String) ipChange.ipc$dispatch("1642616625", new Object[]{this}) : this.match;
    }

    public String getMobile() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1694498452") ? (String) ipChange.ipc$dispatch("-1694498452", new Object[]{this}) : this.mobile;
    }

    public String getNationPrefix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1968922819") ? (String) ipChange.ipc$dispatch("1968922819", new Object[]{this}) : this.nationPrefix;
    }

    public String getNeedImprove() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1973636654") ? (String) ipChange.ipc$dispatch("1973636654", new Object[]{this}) : this.needImprove;
    }

    public String getProvince() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2060466886") ? (String) ipChange.ipc$dispatch("-2060466886", new Object[]{this}) : this.province;
    }

    public String getProvinceCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1513754439") ? (String) ipChange.ipc$dispatch("1513754439", new Object[]{this}) : this.provinceCode;
    }

    public String getStreet() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-508934579") ? (String) ipChange.ipc$dispatch("-508934579", new Object[]{this}) : this.street;
    }

    public String getStreetCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "77057754") ? (String) ipChange.ipc$dispatch("77057754", new Object[]{this}) : this.streetCode;
    }

    public String getTelephone() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "275620720") ? (String) ipChange.ipc$dispatch("275620720", new Object[]{this}) : this.telephone;
    }

    public String getUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-647142128") ? (String) ipChange.ipc$dispatch("-647142128", new Object[]{this}) : this.userId;
    }

    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "193646212") ? (String) ipChange.ipc$dispatch("193646212", new Object[]{this}) : this.version;
    }

    public String getZipCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "865266522") ? (String) ipChange.ipc$dispatch("865266522", new Object[]{this}) : this.zipCode;
    }

    public void setAddressDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678009029")) {
            ipChange.ipc$dispatch("678009029", new Object[]{this, str});
        } else {
            this.addressDetail = str;
        }
    }

    public void setAddressId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22332997")) {
            ipChange.ipc$dispatch("-22332997", new Object[]{this, str});
        } else {
            this.addressId = str;
        }
    }

    public void setAddressName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313476469")) {
            ipChange.ipc$dispatch("-1313476469", new Object[]{this, str});
        } else {
            this.addressName = str;
        }
    }

    public void setAddressStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1402429500")) {
            ipChange.ipc$dispatch("-1402429500", new Object[]{this, str});
        } else {
            this.addressStatus = str;
        }
    }

    public void setChecked(Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401089484")) {
            ipChange.ipc$dispatch("-401089484", new Object[]{this, bool});
        } else {
            this.checked = bool;
        }
    }

    public void setCity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171774473")) {
            ipChange.ipc$dispatch("171774473", new Object[]{this, str});
        } else {
            this.city = str;
        }
    }

    public void setCityCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1653445916")) {
            ipChange.ipc$dispatch("1653445916", new Object[]{this, str});
        } else {
            this.cityCode = str;
        }
    }

    public void setConsigneeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "268326144")) {
            ipChange.ipc$dispatch("268326144", new Object[]{this, str});
        } else {
            this.consigneeName = str;
        }
    }

    public void setCounty(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1001719222")) {
            ipChange.ipc$dispatch("-1001719222", new Object[]{this, str});
        } else {
            this.county = str;
        }
    }

    public void setCountyCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385578205")) {
            ipChange.ipc$dispatch("385578205", new Object[]{this, str});
        } else {
            this.countyCode = str;
        }
    }

    public void setDmCity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014140992")) {
            ipChange.ipc$dispatch("1014140992", new Object[]{this, str});
        } else {
            this.dmCity = str;
        }
    }

    public void setDmCityCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692082131")) {
            ipChange.ipc$dispatch("1692082131", new Object[]{this, str});
        } else {
            this.dmCityCode = str;
        }
    }

    public void setDmCounty(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058653889")) {
            ipChange.ipc$dispatch("1058653889", new Object[]{this, str});
        } else {
            this.dmCounty = str;
        }
    }

    public void setDmCountyCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1139724844")) {
            ipChange.ipc$dispatch("-1139724844", new Object[]{this, str});
        } else {
            this.dmCountyCode = str;
        }
    }

    public void setDmProvince(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706344347")) {
            ipChange.ipc$dispatch("706344347", new Object[]{this, str});
        } else {
            this.dmProvince = str;
        }
    }

    public void setDmProvinceCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152753746")) {
            ipChange.ipc$dispatch("-1152753746", new Object[]{this, str});
        } else {
            this.dmProvinceCode = str;
        }
    }

    public void setEmail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237468690")) {
            ipChange.ipc$dispatch("-1237468690", new Object[]{this, str});
        } else {
            this.email = str;
        }
    }

    public void setGmtCreate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "534256096")) {
            ipChange.ipc$dispatch("534256096", new Object[]{this, str});
        } else {
            this.gmtCreate = str;
        }
    }

    public void setGmtModified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397633267")) {
            ipChange.ipc$dispatch("397633267", new Object[]{this, str});
        } else {
            this.gmtModified = str;
        }
    }

    public void setIsDefault(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474635469")) {
            ipChange.ipc$dispatch("-1474635469", new Object[]{this, str});
        } else {
            this.isDefault = str;
        }
    }

    public void setMatch(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872875365")) {
            ipChange.ipc$dispatch("1872875365", new Object[]{this, str});
        } else {
            this.match = str;
        }
    }

    public void setMobile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910030834")) {
            ipChange.ipc$dispatch("1910030834", new Object[]{this, str});
        } else {
            this.mobile = str;
        }
    }

    public void setNationPrefix(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304946299")) {
            ipChange.ipc$dispatch("1304946299", new Object[]{this, str});
        } else {
            this.nationPrefix = str;
        }
    }

    public void setNeedImprove(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246757112")) {
            ipChange.ipc$dispatch("-1246757112", new Object[]{this, str});
        } else {
            this.needImprove = str;
        }
    }

    public void setProvince(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667708132")) {
            ipChange.ipc$dispatch("667708132", new Object[]{this, str});
        } else {
            this.province = str;
        }
    }

    public void setProvinceCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79628407")) {
            ipChange.ipc$dispatch("79628407", new Object[]{this, str});
        } else {
            this.provinceCode = str;
        }
    }

    public void setStreet(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7805233")) {
            ipChange.ipc$dispatch("7805233", new Object[]{this, str});
        } else {
            this.street = str;
        }
    }

    public void setStreetCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278906948")) {
            ipChange.ipc$dispatch("278906948", new Object[]{this, str});
        } else {
            this.streetCode = str;
        }
    }

    public void setTelephone(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010897146")) {
            ipChange.ipc$dispatch("-2010897146", new Object[]{this, str});
        } else {
            this.telephone = str;
        }
    }

    public void setUserId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "18338510")) {
            ipChange.ipc$dispatch("18338510", new Object[]{this, str});
        } else {
            this.userId = str;
        }
    }

    public void setVersion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91811698")) {
            ipChange.ipc$dispatch("91811698", new Object[]{this, str});
        } else {
            this.version = str;
        }
    }

    public void setZipCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562795172")) {
            ipChange.ipc$dispatch("-562795172", new Object[]{this, str});
        } else {
            this.zipCode = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-610187073")) {
            ipChange.ipc$dispatch("-610187073", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.nationPrefix);
        parcel.writeString(this.addressDetail);
        parcel.writeString(this.addressId);
        parcel.writeString(this.addressName);
        parcel.writeString(this.addressStatus);
        parcel.writeString(this.city);
        parcel.writeString(this.cityCode);
        parcel.writeString(this.consigneeName);
        parcel.writeString(this.county);
        parcel.writeString(this.countyCode);
        parcel.writeString(this.gmtCreate);
        parcel.writeString(this.gmtModified);
        parcel.writeString(this.isDefault);
        parcel.writeString(this.mobile);
        parcel.writeString(this.needImprove);
        parcel.writeString(this.province);
        parcel.writeString(this.provinceCode);
        parcel.writeString(this.street);
        parcel.writeString(this.streetCode);
        parcel.writeString(this.userId);
        parcel.writeString(this.email);
        parcel.writeString(this.zipCode);
        parcel.writeString(this.telephone);
        parcel.writeString(this.dmProvince);
        parcel.writeString(this.dmProvinceCode);
        parcel.writeString(this.dmCity);
        parcel.writeString(this.dmCityCode);
        parcel.writeString(this.dmCounty);
        parcel.writeString(this.dmCountyCode);
        parcel.writeString(this.version);
        parcel.writeString(this.match);
        parcel.writeValue(this.checked);
    }

    protected AddressBean(Parcel parcel) {
        this.checked = Boolean.FALSE;
        this.nationPrefix = parcel.readString();
        this.addressDetail = parcel.readString();
        this.addressId = parcel.readString();
        this.addressName = parcel.readString();
        this.addressStatus = parcel.readString();
        this.city = parcel.readString();
        this.cityCode = parcel.readString();
        this.consigneeName = parcel.readString();
        this.county = parcel.readString();
        this.countyCode = parcel.readString();
        this.gmtCreate = parcel.readString();
        this.gmtModified = parcel.readString();
        this.isDefault = parcel.readString();
        this.mobile = parcel.readString();
        this.needImprove = parcel.readString();
        this.province = parcel.readString();
        this.provinceCode = parcel.readString();
        this.street = parcel.readString();
        this.streetCode = parcel.readString();
        this.userId = parcel.readString();
        this.email = parcel.readString();
        this.zipCode = parcel.readString();
        this.telephone = parcel.readString();
        this.dmProvince = parcel.readString();
        this.dmProvinceCode = parcel.readString();
        this.dmCity = parcel.readString();
        this.dmCityCode = parcel.readString();
        this.dmCounty = parcel.readString();
        this.dmCountyCode = parcel.readString();
        this.version = parcel.readString();
        this.match = parcel.readString();
        this.checked = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
