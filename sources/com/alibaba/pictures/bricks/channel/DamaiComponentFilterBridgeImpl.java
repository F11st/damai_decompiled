package com.alibaba.pictures.bricks.channel;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.city.net.CityListRequest;
import cn.damai.commonbusiness.citycopy.net.CityListResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.channel.bean.LocationInfo;
import com.alibaba.pictures.bricks.channel.bean.NewLocationInfo;
import com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge;
import com.alibaba.pictures.bricks.channel.bridge.OnBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.List;
import java.util.Map;
import tb.gr1;
import tb.kc;
import tb.mu0;
import tb.yi;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DamaiComponentFilterBridgeImpl implements ComponentFilterBridge {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "148132804") ? (String) ipChange.ipc$dispatch("148132804", new Object[]{this}) : "mtop.damai.mec.aristotle.get";
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getApiVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2108279029") ? (String) ipChange.ipc$dispatch("2108279029", new Object[]{this}) : LiveFullInfo.VER;
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1989141885") ? (String) ipChange.ipc$dispatch("1989141885", new Object[]{this}) : z20.c();
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "375787821") ? (String) ipChange.ipc$dispatch("375787821", new Object[]{this}) : z20.d();
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getComboChannel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1937351340") ? (String) ipChange.ipc$dispatch("1937351340", new Object[]{this}) : "1";
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public Double[] getDMCoordinates() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806993534")) {
            return (Double[]) ipChange.ipc$dispatch("1806993534", new Object[]{this});
        }
        double[] dMCoordinates = Util.getDMCoordinates();
        if (dMCoordinates == null || dMCoordinates.length != 2) {
            return null;
        }
        return new Double[]{Double.valueOf(dMCoordinates[0]), Double.valueOf(dMCoordinates[1])};
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public CityListResponse getLocalCityList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1770973532")) {
            return (CityListResponse) ipChange.ipc$dispatch("1770973532", new Object[]{this});
        }
        String B = z20.B(ShareperfenceConstants.CITY_DATA_New);
        if (TextUtils.isEmpty(B)) {
            B = yi.a(mu0.a());
        }
        try {
            return (CityListResponse) JSON.parseObject(B, CityListResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public String getSpValue(@NonNull String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1601864631") ? (String) ipChange.ipc$dispatch("-1601864631", new Object[]{this, str}) : z20.B(str);
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getTtid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1879981134") ? (String) ipChange.ipc$dispatch("-1879981134", new Object[]{this}) : AppConfig.p();
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public String getUserCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "153547247") ? (String) ipChange.ipc$dispatch("153547247", new Object[]{this}) : z20.E();
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void reportClick(@NonNull kc.C9346b c9346b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237169644")) {
            ipChange.ipc$dispatch("237169644", new Object[]{this, c9346b});
            return;
        }
        kc kcVar = c9346b.a;
        if (kcVar != null) {
            C0525a.C0527b c0527b = new C0525a.C0527b();
            c0527b.d(kcVar.i());
            c0527b.a(kcVar.f());
            c0527b.e(kcVar.j());
            c0527b.h(kcVar.l());
            c0527b.k(kcVar.o());
            c0527b.b(kcVar.g());
            c0527b.i(kcVar.m());
            c0527b.l(kcVar.p());
            c0527b.c(kcVar.h());
            c0527b.f(kcVar.k());
            c0527b.j(kcVar.n());
            c0527b.g(kcVar.q());
            C0529c.e().x(c0527b);
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void reportExposureSingleCustomEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j, @Nullable Map<String, String> map, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101425249")) {
            ipChange.ipc$dispatch("2101425249", new Object[]{this, str, str2, str3, str4, Long.valueOf(j), map, Integer.valueOf(i)});
        } else {
            C0529c.e().C(str, str2, str3, str4, j, map, i);
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void requestCityList(@NonNull final OnBizListener<CityListResponse> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "398232484")) {
            ipChange.ipc$dispatch("398232484", new Object[]{this, onBizListener});
            return;
        }
        CityListRequest cityListRequest = new CityListRequest();
        cityListRequest.showLoginUI(false);
        cityListRequest.request(new DMMtopRequestListener<CityListResponse>(CityListResponse.class) { // from class: com.alibaba.pictures.bricks.channel.DamaiComponentFilterBridgeImpl.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1432802991")) {
                    ipChange2.ipc$dispatch("1432802991", new Object[]{this, str, str2});
                } else {
                    onBizListener.onBizFail(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CityListResponse cityListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "8156945")) {
                    ipChange2.ipc$dispatch("8156945", new Object[]{this, cityListResponse});
                    return;
                }
                onBizListener.onBizSuccess(cityListResponse);
                if (cityListResponse != null) {
                    try {
                        z20.T(ShareperfenceConstants.CITY_DATA_New, JSON.toJSONString(cityListResponse));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void saveLocationInfo(@NonNull LocationInfo locationInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668201596")) {
            ipChange.ipc$dispatch("-1668201596", new Object[]{this, locationInfo});
            return;
        }
        long j = locationInfo.cityDamaiId;
        if (j == 0) {
            return;
        }
        double d = locationInfo.locationLat;
        double d2 = locationInfo.locationLng;
        String str = locationInfo.locationadd;
        String str2 = locationInfo.locationgname;
        z20.o0(d);
        z20.p0(d2);
        z20.m0(str);
        z20.q0(str2);
        z20.n0(j + "," + d + "," + d2);
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void saveSpValue(@NonNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1610440644")) {
            ipChange.ipc$dispatch("-1610440644", new Object[]{this, str, str2});
        } else {
            z20.T(str, str2);
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void setExposureTag(@Nullable View view, @Nullable String str, @NonNull String str2, @NonNull String str3, @Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265026735")) {
            ipChange.ipc$dispatch("265026735", new Object[]{this, view, str, str2, str3, map});
        } else {
            C0529c.e().G(view, str, str2, str3, map);
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void setNewLocationData(@NonNull NewLocationInfo newLocationInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287526935")) {
            ipChange.ipc$dispatch("-287526935", new Object[]{this, newLocationInfo});
            return;
        }
        long j = newLocationInfo.cityDamaiId;
        if (j == 0) {
            return;
        }
        String str = newLocationInfo.locationgname;
        double d = newLocationInfo.locationLat;
        double d2 = newLocationInfo.locationLng;
        mu0.b = j;
        mu0.c = str;
        z20.c0(j + "");
        z20.f0(str);
        z20.d0(d);
        z20.e0(d2);
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void showPermissionDialog(@NonNull Context context, @NonNull String str, @Nullable List<String> list, boolean z, @Nullable DialogInterface.OnClickListener onClickListener, @Nullable DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709858552")) {
            ipChange.ipc$dispatch("-1709858552", new Object[]{this, context, str, list, Boolean.valueOf(z), onClickListener, onClickListener2});
        } else {
            gr1.a(context, str, list, z, onClickListener, onClickListener2);
        }
    }
}
