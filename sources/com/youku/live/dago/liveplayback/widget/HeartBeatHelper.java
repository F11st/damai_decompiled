package com.youku.live.dago.liveplayback.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.device.UTDevice;
import com.youku.live.dago.liveplayback.UTManager;
import com.youku.live.dago.liveplayback.widget.model.SeiDelay;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HeartBeatHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "HeartBeatHelper";
    private Runnable liveTime;
    private Map<String, String> mBasicArgs;
    private Context mContext;
    private long mDelay;
    private String mLiveId;
    private String mScreenId;
    private long liveTimeCount = 0;
    private int delayTime = 1000;
    private SeiDelay mSeiDelay = new SeiDelay();
    private Map<String, String> mArgs = new LinkedHashMap<String, String>() { // from class: com.youku.live.dago.liveplayback.widget.HeartBeatHelper.1
        {
            put("background_mode", "0");
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public HeartBeatHelper(Context context, String str, String str2, Map<String, String> map) {
        this.mContext = context;
        this.mLiveId = str;
        this.mScreenId = str2;
        this.mBasicArgs = map;
    }

    static /* synthetic */ long access$108(HeartBeatHelper heartBeatHelper) {
        long j = heartBeatHelper.liveTimeCount;
        heartBeatHelper.liveTimeCount = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analyticsPlayHeart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123931367")) {
            ipChange.ipc$dispatch("123931367", new Object[]{this, Long.valueOf(j)});
            return;
        }
        HashMap hashMap = new HashMap();
        int i = ((j % 20) > 0L ? 1 : ((j % 20) == 0L ? 0 : -1));
        long j2 = i == 0 ? 20L : j;
        StringBuilder sb = new StringBuilder();
        sb.append(i == 0 ? 20L : j);
        sb.append("");
        hashMap.put("heartInterval", sb.toString());
        long j3 = 2;
        if (j == 5) {
            j3 = 1;
        } else if (j != 10) {
            j3 = i == 0 ? 2 + (j / 20) : 0L;
        }
        hashMap.put("lognum", j3 + "");
        hashMap.put("view", "onlineEducation");
        Map<String, String> map = this.mBasicArgs;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.mArgs;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        long j4 = this.mDelay;
        if (j4 != 0) {
            hashMap.put("delay", String.valueOf(j4));
        }
        if (this.mSeiDelay.mDelay != 0) {
            hashMap.put("seiDelay", this.mSeiDelay.mDelay + "");
            hashMap.put("seiNtpOffset", this.mSeiDelay.ntpOffset + "");
            hashMap.put("seiLocalTs", this.mSeiDelay.localTimestamp);
            hashMap.put("seiTs", this.mSeiDelay.seiTimestamp);
        }
        Log.i("BusinessTrack", toString() + " report 12030 : liveId=" + this.mLiveId + " mDelay=" + this.mDelay + " seiDelay=" + this.mSeiDelay.mDelay + " seiNtpOffset=" + this.mSeiDelay.ntpOffset + " seiTs=" + this.mSeiDelay.seiTimestamp + " seiLocalTs=" + this.mSeiDelay.localTimestamp);
        String str = this.mLiveId;
        String sessionId = getSessionId();
        String str2 = this.mScreenId;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j2);
        sb2.append("");
        UTManager.playHeart(str, sessionId, str2, sb2.toString(), hashMap);
        this.mSeiDelay.reset();
    }

    private String getSessionId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "713114962")) {
            return (String) ipChange.ipc$dispatch("713114962", new Object[]{this});
        }
        return md5(System.currentTimeMillis() + "" + Math.floor(Math.random() * 10.0d) + UTDevice.getUtdid(this.mContext));
    }

    private void initHeartBeat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660529013")) {
            ipChange.ipc$dispatch("1660529013", new Object[]{this});
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.liveTimeCount = 0L;
        this.liveTime = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.HeartBeatHelper.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "269273768")) {
                    ipChange2.ipc$dispatch("269273768", new Object[]{this});
                    return;
                }
                HeartBeatHelper heartBeatHelper = HeartBeatHelper.this;
                heartBeatHelper.removeHandler(heartBeatHelper.liveTime);
                HeartBeatHelper.access$108(HeartBeatHelper.this);
                if (HeartBeatHelper.this.liveTimeCount == 5 || HeartBeatHelper.this.liveTimeCount == 10 || (HeartBeatHelper.this.liveTimeCount >= 20 && HeartBeatHelper.this.liveTimeCount % 20 == 0)) {
                    HeartBeatHelper heartBeatHelper2 = HeartBeatHelper.this;
                    heartBeatHelper2.analyticsPlayHeart(heartBeatHelper2.liveTimeCount);
                }
                HeartBeatHelper heartBeatHelper3 = HeartBeatHelper.this;
                heartBeatHelper3.postHandler(heartBeatHelper3.delayTime, HeartBeatHelper.this.liveTime);
            }
        };
    }

    private static String md5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891725715")) {
            return (String) ipChange.ipc$dispatch("1891725715", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void postHandler(int i, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136167754")) {
            ipChange.ipc$dispatch("1136167754", new Object[]{this, Integer.valueOf(i), runnable});
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(runnable, i);
        }
    }

    public void put(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "694029446")) {
            ipChange.ipc$dispatch("694029446", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2) || "-1".equals(str2)) {
        } else {
            this.mArgs.put(str, str2);
        }
    }

    public void removeHandler(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304947719")) {
            ipChange.ipc$dispatch("-304947719", new Object[]{this, runnable});
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void setDelay(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546109156")) {
            ipChange.ipc$dispatch("-546109156", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mDelay = j;
        }
    }

    public void setSeiDelay(SeiDelay seiDelay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188670926")) {
            ipChange.ipc$dispatch("-1188670926", new Object[]{this, seiDelay});
        } else {
            this.mSeiDelay = seiDelay;
        }
    }

    public void startTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231489074")) {
            ipChange.ipc$dispatch("1231489074", new Object[]{this});
            return;
        }
        initHeartBeat();
        postHandler(this.delayTime, this.liveTime);
    }

    public synchronized void stopTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120092730")) {
            ipChange.ipc$dispatch("120092730", new Object[]{this});
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.liveTime);
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }
}
