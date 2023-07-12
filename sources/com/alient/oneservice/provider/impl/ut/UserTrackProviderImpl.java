package com.alient.oneservice.provider.impl.ut;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.DamaiConstants;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import com.alibaba.pictures.ut.DogCat;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProvider;
import java.util.HashMap;
import java.util.Map;
import tb.ko;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class UserTrackProviderImpl implements UserTrackProvider {
    private final String KET_CITY = "city";
    boolean isUTDogCatSwitchOn = ko.d().isExpected(DamaiConstants.CONFIG_KEY_UT_DOG_CAT_SWITCH, "on", true);

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void click(View view, TrackInfo trackInfo) {
        click(view, trackInfo, false);
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void expose(View view, TrackInfo trackInfo) {
        if (trackInfo == null) {
            return;
        }
        if (trackInfo.getArgs() == null) {
            trackInfo.setArgs(new HashMap<>());
        }
        HashMap hashMap = new HashMap(trackInfo.getArgs());
        if (trackInfo.getAbBucket() != null) {
            hashMap.put("ABTrackInfo", trackInfo.getAbBucket().toJSONString());
        }
        if (!TextUtils.isEmpty(z20.d())) {
            hashMap.put("city", z20.d());
        }
        if (this.isUTDogCatSwitchOn) {
            DogCat.INSTANCE.i(view).q(trackInfo.getSpmb()).w(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd()).s(hashMap).k();
        } else {
            C0529c.e().G(view, trackInfo.getSpmd(), trackInfo.getSpmc(), trackInfo.getSpmb(), hashMap);
        }
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void expose(String str, TrackInfo trackInfo) {
    }

    public C0525a.C0527b getUTKeyBuilder(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        return new C0525a.C0527b().i(str).f(str2).l(str3).g(bool.booleanValue()).j(map);
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void reportCustom(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(z20.d())) {
            map.put("city", z20.d());
        }
        if (this.isUTDogCatSwitchOn) {
            DogCat.INSTANCE.g().c(str).d(map).b(str2).a();
        } else {
            C0529c.e().A(map, str2, str);
        }
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void reportOriginalCustomEvent(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (!TextUtils.isEmpty(z20.d())) {
            map.put("city", z20.d());
        }
        if ("2201".equals(str)) {
            try {
                C0529c.e().C(str4, str3, str2, "1.0", Long.parseLong(str5), map, Integer.parseInt(str));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        C0529c.e().D(str2, str3, str4, str5, map, Integer.parseInt(str));
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void click(View view, TrackInfo trackInfo, boolean z) {
        if (trackInfo == null) {
            return;
        }
        HashMap<String, String> args = trackInfo.getArgs();
        if (args == null) {
            args = new HashMap<>();
        }
        HashMap<String, String> hashMap = args;
        if (trackInfo.getPabBucket() != null) {
            hashMap.put("PreABTrackInfo", trackInfo.getPabBucket().toJSONString());
        }
        if (trackInfo.getAbBucket() != null) {
            hashMap.put("ABTrackInfo", trackInfo.getAbBucket().toJSONString());
        }
        if (!TextUtils.isEmpty(z20.d())) {
            hashMap.put("city", z20.d());
        }
        if (this.isUTDogCatSwitchOn) {
            DogCat.INSTANCE.d().m(z).n(trackInfo.getSpmb()).q(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd()).o(hashMap).j();
            return;
        }
        C0529c.e().x(getUTKeyBuilder(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd(), hashMap, Boolean.valueOf(z)));
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void expose(View view, String str, TrackInfo trackInfo) {
        if (trackInfo == null) {
            return;
        }
        if (trackInfo.getArgs() == null) {
            trackInfo.setArgs(new HashMap<>());
        }
        HashMap hashMap = new HashMap(trackInfo.getArgs());
        if (trackInfo.getAbBucket() != null) {
            hashMap.put("ABTrackInfo", trackInfo.getAbBucket().toJSONString());
        }
        if (!TextUtils.isEmpty(z20.d())) {
            hashMap.put("city", z20.d());
        }
        DogCat.INSTANCE.i(view).z(str).q(trackInfo.getSpmb()).w(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd()).s(hashMap).k();
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void click(TrackInfo trackInfo) {
        click(trackInfo, false);
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void click(TrackInfo trackInfo, boolean z) {
        click(null, trackInfo, z);
    }
}
