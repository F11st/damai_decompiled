package cn.damai.im;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.commonbusiness.model.UserVipBean;
import cn.damai.im.request.PersonalInfoRequest;
import cn.damai.login.LoginManager;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.mu0;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class UserInfoUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String USER_VIP_PREFIX = "user_vip_info_prefix";

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnUserInfoListener {
        void onFailed(String str, String str2);

        void onSuccess(UserData userData);
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class PersonalInfoResult implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<PersonalInfoResult> CREATOR = new a();
        private String result;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public class a implements Parcelable.Creator<PersonalInfoResult> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public PersonalInfoResult createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "193090747") ? (PersonalInfoResult) ipChange.ipc$dispatch("193090747", new Object[]{this, parcel}) : new PersonalInfoResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public PersonalInfoResult[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-737924144") ? (PersonalInfoResult[]) ipChange.ipc$dispatch("-737924144", new Object[]{this, Integer.valueOf(i)}) : new PersonalInfoResult[i];
            }
        }

        public PersonalInfoResult() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1532227855")) {
                return ((Integer) ipChange.ipc$dispatch("1532227855", new Object[]{this})).intValue();
            }
            return 0;
        }

        public String getResult() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1782836950") ? (String) ipChange.ipc$dispatch("-1782836950", new Object[]{this}) : this.result;
        }

        public void setResult(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-828462604")) {
                ipChange.ipc$dispatch("-828462604", new Object[]{this, str});
            } else {
                this.result = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "889500572")) {
                ipChange.ipc$dispatch("889500572", new Object[]{this, parcel, Integer.valueOf(i)});
            } else {
                parcel.writeString(this.result);
            }
        }

        protected PersonalInfoResult(Parcel parcel) {
            this.result = parcel.readString();
        }
    }

    public static UserData a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-400039427")) {
            return (UserData) ipChange.ipc$dispatch("-400039427", new Object[0]);
        }
        try {
            return (UserData) JSON.parseObject(z20.f(), UserData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void b(PersonalInfoRequest personalInfoRequest, final OnUserInfoListener onUserInfoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586104921")) {
            ipChange.ipc$dispatch("-586104921", new Object[]{personalInfoRequest, onUserInfoListener});
            return;
        }
        Context applicationContext = mu0.a().getApplicationContext();
        if (!LoginManager.k().q()) {
            c(applicationContext);
        } else {
            personalInfoRequest.request(new DMMtopRequestListener<UserData>(UserData.class) { // from class: cn.damai.im.UserInfoUtil.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1208257572")) {
                        ipChange2.ipc$dispatch("1208257572", new Object[]{this, str, str2});
                        return;
                    }
                    OnUserInfoListener onUserInfoListener2 = onUserInfoListener;
                    if (onUserInfoListener2 != null) {
                        onUserInfoListener2.onFailed(str, str2);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(UserData userData) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1169768412")) {
                        ipChange2.ipc$dispatch("-1169768412", new Object[]{this, userData});
                    } else if (userData != null) {
                        OnUserInfoListener onUserInfoListener2 = onUserInfoListener;
                        if (onUserInfoListener2 != null) {
                            onUserInfoListener2.onSuccess(userData);
                        }
                    } else {
                        OnUserInfoListener onUserInfoListener3 = onUserInfoListener;
                        if (onUserInfoListener3 != null) {
                            onUserInfoListener3.onFailed("", "");
                        }
                    }
                }
            });
        }
    }

    private static void c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1579084825")) {
            ipChange.ipc$dispatch("-1579084825", new Object[]{context});
        } else {
            DMNav.from(context).toUri(cs.f());
        }
    }

    public static void d(UserData userData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103260512")) {
            ipChange.ipc$dispatch("1103260512", new Object[]{userData});
        } else {
            z20.j0(JSON.toJSONString(userData));
        }
    }

    public static void e(UserVipBean userVipBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10349294")) {
            ipChange.ipc$dispatch("-10349294", new Object[]{userVipBean});
            return;
        }
        String E = z20.E();
        if (TextUtils.isEmpty(E)) {
            return;
        }
        String jSONString = userVipBean != null ? JSON.toJSONString(userVipBean) : "";
        z20.T(USER_VIP_PREFIX + E, jSONString);
    }
}
