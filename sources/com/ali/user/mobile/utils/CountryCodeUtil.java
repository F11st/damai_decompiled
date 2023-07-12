package com.ali.user.mobile.utils;

import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.model.CountryCode;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.rpc.login.model.GroupedCountryCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CountryCodeUtil {
    public static final String TAG = "login.CountryCodeUtil";

    public static ArrayList<RegionInfo> fillData(String str, List<GroupedCountryCode> list, HashMap<String, Integer> hashMap, List<String> list2) {
        ArrayList<RegionInfo> arrayList = new ArrayList<>();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            GroupedCountryCode groupedCountryCode = list.get(i2);
            List<CountryCode> list3 = groupedCountryCode.countryCodeList;
            for (int i3 = 0; i3 < list3.size(); i3++) {
                CountryCode countryCode = list3.get(i3);
                RegionInfo regionInfo = new RegionInfo();
                if (com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX.equals(groupedCountryCode.index)) {
                    regionInfo.character = str;
                    groupedCountryCode.index = "★";
                } else {
                    regionInfo.character = groupedCountryCode.index;
                }
                if (i3 == 0) {
                    regionInfo.isDisplayLetter = true;
                    String str2 = groupedCountryCode.index;
                    if (str2 != null) {
                        hashMap.put(str2, Integer.valueOf(i));
                        list2.add(groupedCountryCode.index);
                    } else {
                        TLogAdapter.e(TAG, "error!! index can not be null!");
                    }
                } else {
                    regionInfo.isDisplayLetter = false;
                }
                regionInfo.name = countryCode.name;
                regionInfo.code = "" + countryCode.code;
                regionInfo.domain = countryCode.domain;
                regionInfo.checkPattern = countryCode.checkPattern;
                regionInfo.pinyin = countryCode.pinyin;
                i++;
                arrayList.add(regionInfo);
            }
        }
        return arrayList;
    }
}
