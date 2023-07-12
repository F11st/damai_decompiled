package com.youku.live.dago.liveplayback.widget;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.live.dago.liveplayback.UTManager;
import com.youku.live.dago.liveplayback.widget.model.SeiDelay;
import com.youku.live.dago.liveplayback.widget.ut.LaifengVVParams;
import com.youku.vpm.constants.TableField;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BusinessTrack {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "BusinessTrack";
    public static boolean mVVTrigger;
    public static long shownTime;
    private Map<String, String> mBaseArgs = new ConcurrentHashMap<String, String>() { // from class: com.youku.live.dago.liveplayback.widget.BusinessTrack.1
        {
            put(TableField.DRM_TYPE, "0");
            put("view", "默认");
            put("decodingType", "1");
            put("data_source", "1");
            put("biz_type", "3");
            put("live_type", "4");
            put("stream_type", "video");
            put("play_codes", "200");
            put("videoCode", "0");
            put("direction", "vplayer");
            put("live_container_sdk_version", "");
            put("screenType", "0");
            put("smallplayer_au", "0");
            put("background_mode", "0");
            put("usePIP", "0");
            put("isPIP", "0");
            put("changeType", "0");
        }
    };
    private Context mContext;
    private HeartBeatHelper mHeartBeatHelper;
    private boolean mIsAppear;
    private boolean mIsFirstPlay;
    private String mLiveId;
    private long mStartTime;
    private boolean mVVBeginReported;
    private boolean mVVEndReported;

    @Deprecated
    public BusinessTrack(Context context) {
        this.mContext = context;
        this.mBaseArgs.putAll(new LaifengVVParams().getVVCommonParams(context, "3"));
    }

    private String getGuid(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439258695")) {
            return (String) ipChange.ipc$dispatch("-1439258695", new Object[]{this, context});
        }
        try {
            return Utils.getGUID(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public boolean containsKey(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "368656142") ? ((Boolean) ipChange.ipc$dispatch("368656142", new Object[]{this, str})).booleanValue() : this.mBaseArgs.containsKey(str);
    }

    public void put(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687551781")) {
            ipChange.ipc$dispatch("1687551781", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            this.mBaseArgs.put(str, str2);
        }
    }

    public void putAll(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7692595")) {
            ipChange.ipc$dispatch("-7692595", new Object[]{this, map});
        } else {
            this.mBaseArgs.putAll(map);
        }
    }

    public void putHeatArgs(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-631275656")) {
            ipChange.ipc$dispatch("-631275656", new Object[]{this, str, str2});
            return;
        }
        HeartBeatHelper heartBeatHelper = this.mHeartBeatHelper;
        if (heartBeatHelper != null) {
            heartBeatHelper.put(str, str2);
        }
    }

    public void remove(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637655632")) {
            ipChange.ipc$dispatch("1637655632", new Object[]{this, str});
        } else if (this.mBaseArgs.containsKey(str)) {
            this.mBaseArgs.remove(str);
        }
    }

    public boolean reportPlayEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459363377")) {
            return ((Boolean) ipChange.ipc$dispatch("459363377", new Object[]{this})).booleanValue();
        }
        if (!this.mVVBeginReported || this.mVVEndReported) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("vv-trigger", mVVTrigger ? "1" : "0");
        long j = shownTime;
        if (j > 0) {
            hashMap.put("showntime", String.valueOf(j));
            Logger.d("showntime", "reportShownTime:" + shownTime + "|" + this.mBaseArgs.get("ismcu") + "|" + this.mBaseArgs.get("ispk"));
            shownTime = 0L;
        }
        hashMap.putAll(this.mBaseArgs);
        UTManager.playStop(this.mLiveId, Utils.getPlaySid(this.mContext), String.valueOf(System.currentTimeMillis() - this.mStartTime), hashMap);
        this.mHeartBeatHelper.stopTime();
        this.mVVEndReported = true;
        return true;
    }

    public void reportPlayStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289189754")) {
            ipChange.ipc$dispatch("-1289189754", new Object[]{this});
        } else if (!this.mVVBeginReported && this.mIsAppear && this.mIsFirstPlay) {
            HashMap hashMap = new HashMap();
            hashMap.put("vv-trigger", mVVTrigger ? "1" : "0");
            if (this.mBaseArgs.containsKey("spm-url")) {
                Map<String, String> map = this.mBaseArgs;
                map.put("spm-pre", map.get("spm-url"));
            }
            hashMap.putAll(this.mBaseArgs);
            UTManager.playStart(this.mLiveId, Utils.getPlaySid(this.mContext), hashMap);
            this.mVVBeginReported = true;
            this.mStartTime = System.currentTimeMillis();
            HeartBeatHelper heartBeatHelper = new HeartBeatHelper(this.mContext, this.mLiveId, this.mBaseArgs.get("screen_id"), this.mBaseArgs);
            this.mHeartBeatHelper = heartBeatHelper;
            heartBeatHelper.startTime();
        }
    }

    public void setAppear(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890533419")) {
            ipChange.ipc$dispatch("1890533419", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsAppear = z;
        }
    }

    public void setDelay(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1575744517")) {
            ipChange.ipc$dispatch("-1575744517", new Object[]{this, Long.valueOf(j)});
            return;
        }
        HeartBeatHelper heartBeatHelper = this.mHeartBeatHelper;
        if (heartBeatHelper != null) {
            heartBeatHelper.setDelay(j);
        }
    }

    public void setFirstPlay(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059979892")) {
            ipChange.ipc$dispatch("-2059979892", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsFirstPlay = z;
        }
    }

    public void setSeiDelay(SeiDelay seiDelay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166135215")) {
            ipChange.ipc$dispatch("-1166135215", new Object[]{this, seiDelay});
            return;
        }
        HeartBeatHelper heartBeatHelper = this.mHeartBeatHelper;
        if (heartBeatHelper != null) {
            heartBeatHelper.setSeiDelay(seiDelay);
        }
    }

    public BusinessTrack(Context context, String str) {
        this.mLiveId = str;
        this.mContext = context;
        this.mBaseArgs.putAll(new LaifengVVParams().getVVCommonParams(context, "3"));
        this.mBaseArgs.put("guid", getGuid(context));
    }
}
