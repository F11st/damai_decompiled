package com.youku.live.dago.liveplayback.widget.plugins.tipsview.tipsconfig;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.live.dago.liveplayback.PlayerSharedPreference;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TipsConfigManagerEx extends TipsConfigManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_PREFIX = "tip_id_";
    private static final String KEY_SAVE_DATE = "tip_save_date_";
    private static final String KEY_SUFFIX = "_last_date";
    private static final int MASK_MODE = 61440;
    private static final int MASK_VALUE = 4095;
    private static final int ONE_DAY_TIME = 86400000;
    private static final String TAG = "TipsConfigManagerEx";
    private static final HashMap<String, Integer> appLifeTimeTipCountMap = new HashMap<>();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());

    public static boolean canShowTips(AlixPlayerContext alixPlayerContext, TipsConfig tipsConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "801560043")) {
            return ((Boolean) ipChange.ipc$dispatch("801560043", new Object[]{alixPlayerContext, tipsConfig})).booleanValue();
        }
        if (tipsConfig != null) {
            return canShowTips(alixPlayerContext, tipsConfig.getTipId(), tipsConfig.getFrequencyType(), tipsConfig.getFrequency());
        }
        return true;
    }

    public static void recordTipsHasShown(AlixPlayerContext alixPlayerContext, TipsConfig tipsConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051182970")) {
            ipChange.ipc$dispatch("-1051182970", new Object[]{alixPlayerContext, tipsConfig});
        } else if (tipsConfig != null) {
            recordTipsHasShown(alixPlayerContext, tipsConfig.getTipId(), tipsConfig.getFrequencyType());
        }
    }

    public static void updateRemoteConfig(TipsConfig tipsConfig) {
        TipInfo tipInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912338176")) {
            ipChange.ipc$dispatch("-1912338176", new Object[]{tipsConfig});
        } else if (tipsConfig == null || (tipInfo = TipsConfigManager.getTipInfo(tipsConfig.getTipId())) == null) {
        } else {
            int i = tipInfo.duration;
            if (i > 0) {
                tipsConfig.setDisplayTime(i);
            }
            int i2 = tipInfo.frequencyType;
            if (i2 > -1) {
                tipsConfig.setFrequency(tipInfo.frequencyCount);
                if (i2 == 0) {
                    tipsConfig.setFrequencyType(TipsConfig.FrequencyType.NO_LIMIT);
                } else if (i2 == 1) {
                    tipsConfig.setFrequencyType(TipsConfig.FrequencyType.APP_INSTALL);
                } else if (i2 == 2) {
                    tipsConfig.setFrequencyType(TipsConfig.FrequencyType.APP_RUN);
                } else if (i2 == 3) {
                    tipsConfig.setFrequencyType(TipsConfig.FrequencyType.DAY);
                } else if (i2 != 4) {
                } else {
                    tipsConfig.setFrequencyType(TipsConfig.FrequencyType.DAYS);
                }
            }
        }
    }

    public static void recordTipsHasShown(AlixPlayerContext alixPlayerContext, String str, TipsConfig.FrequencyType frequencyType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644880182")) {
            ipChange.ipc$dispatch("-1644880182", new Object[]{alixPlayerContext, str, frequencyType});
        } else if (frequencyType == null) {
        } else {
            String str2 = KEY_PREFIX + str;
            int preferenceInt = PlayerSharedPreference.getPreferenceInt(alixPlayerContext, str2);
            int i = (MASK_MODE & preferenceInt) >> 12;
            if (TipsConfig.FrequencyType.APP_INSTALL == frequencyType) {
                PlayerSharedPreference.savePreference(alixPlayerContext, str2, (((preferenceInt & MASK_VALUE) + 1) & MASK_VALUE) | 4096);
            } else if (TipsConfig.FrequencyType.APP_RUN == frequencyType) {
                HashMap<String, Integer> hashMap = appLifeTimeTipCountMap;
                Integer num = hashMap.get(str2);
                String str3 = KEY_PREFIX + str + KEY_SUFFIX;
                String str4 = KEY_SAVE_DATE + str;
                if (num != null) {
                    hashMap.put(str2, Integer.valueOf(num.intValue() + 1));
                } else {
                    hashMap.put(str2, 1);
                }
                PlayerSharedPreference.savePreference(alixPlayerContext, str2, 0);
                PlayerSharedPreference.savePreference(alixPlayerContext, str3, "");
                PlayerSharedPreference.savePreference(alixPlayerContext, str4, "");
            } else if (TipsConfig.FrequencyType.DAY == frequencyType) {
                int i2 = preferenceInt & MASK_VALUE;
                String str5 = KEY_SAVE_DATE + str;
                String preference = PlayerSharedPreference.getPreference(alixPlayerContext, str5);
                String format = sDateFormat.format(new Date());
                if (i == 3 && TextUtils.equals(preference, format)) {
                    PlayerSharedPreference.savePreference(alixPlayerContext, str2, ((i2 + 1) & MASK_VALUE) | MessageConstant$CommandId.COMMAND_BASE);
                    PlayerSharedPreference.savePreference(alixPlayerContext, str5, format);
                    return;
                }
                PlayerSharedPreference.savePreference(alixPlayerContext, str2, (int) MessageConstant$CommandId.COMMAND_REGISTER);
                PlayerSharedPreference.savePreference(alixPlayerContext, str5, format);
            } else if (TipsConfig.FrequencyType.DAYS == frequencyType) {
                String str6 = KEY_PREFIX + str + KEY_SUFFIX;
                String format2 = sDateFormat.format(new Date());
                String str7 = KEY_SAVE_DATE + str;
                if (i != 4) {
                    PlayerSharedPreference.savePreference(alixPlayerContext, str2, 16385);
                }
                PlayerSharedPreference.savePreference(alixPlayerContext, str6, format2);
                PlayerSharedPreference.savePreference(alixPlayerContext, str7, "");
            } else {
                String str8 = KEY_PREFIX + str + KEY_SUFFIX;
                PlayerSharedPreference.savePreference(alixPlayerContext, str2, 0);
                PlayerSharedPreference.savePreference(alixPlayerContext, str8, "");
                PlayerSharedPreference.savePreference(alixPlayerContext, KEY_SAVE_DATE + str, "");
            }
        }
    }

    public static boolean canShowTips(AlixPlayerContext alixPlayerContext, String str, TipsConfig.FrequencyType frequencyType, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548845116")) {
            return ((Boolean) ipChange.ipc$dispatch("1548845116", new Object[]{alixPlayerContext, str, frequencyType, Integer.valueOf(i)})).booleanValue();
        }
        if (frequencyType == null) {
            return true;
        }
        String str2 = KEY_PREFIX + str;
        int preferenceInt = PlayerSharedPreference.getPreferenceInt(alixPlayerContext, str2);
        int i2 = (MASK_MODE & preferenceInt) >> 12;
        int i3 = preferenceInt & MASK_VALUE;
        if (TipsConfig.FrequencyType.APP_INSTALL == frequencyType) {
            return i2 != 1 || i3 < i;
        } else if (TipsConfig.FrequencyType.APP_RUN == frequencyType) {
            Integer num = appLifeTimeTipCountMap.get(str2);
            return num == null || num.intValue() < i;
        } else if (TipsConfig.FrequencyType.DAY == frequencyType) {
            StringBuilder sb = new StringBuilder();
            sb.append(KEY_SAVE_DATE);
            sb.append(str);
            return (TextUtils.equals(sDateFormat.format(new Date()), PlayerSharedPreference.getPreference(alixPlayerContext, sb.toString())) && i2 == 3 && i3 >= i) ? false : true;
        } else if (TipsConfig.FrequencyType.DAYS == frequencyType) {
            String str3 = KEY_PREFIX + str + KEY_SUFFIX;
            if (i2 == 4) {
                String preference = PlayerSharedPreference.getPreference(alixPlayerContext, str3, "");
                if (!TextUtils.isEmpty(preference)) {
                    try {
                        return ((int) (System.currentTimeMillis() - sDateFormat.parse(preference).getTime())) / 86400000 >= i;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }
}
