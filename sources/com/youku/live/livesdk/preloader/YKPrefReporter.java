package com.youku.live.livesdk.preloader;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class YKPrefReporter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DATA_KEY_DEVICE_SCORE = "live_device_score";
    public static final String DATA_KEY_FLOW_TYPE = "flow_type";
    public static final String DATA_KEY_HAS_PLAYINFO = "has_play_info";
    public static final String DATA_KEY_HAS_TMP_ID = "has_tmp_id";
    public static final String DATA_KEY_IS_FIRST_LOAD = "live_first_load";
    public static final String DATA_KEY_IS_NAV = "is_nav";
    public static final String DATA_KEY_LIVE_ROOM_BIZ_TYPE = "live_room_biz_type";
    public static final String DATA_KEY_LIVE_ROOM_SOURCE = "live_room_source";
    public static final String DATA_KEY_MODULE_NAME = "yk_live_perf_trace";
    public static final String DATA_KEY_MONITOR_NAME = "yk_live_perf";
    public static final String DATA_KEY_ONCREATE_FULLINFO = "oncreate_has_fullinfo";
    public static final String DATA_KEY_ROOM_SCROLL_SWITCH = "room_scroll_switch";
    public static final String DATA_TIME_INIT_HOSTVIEW = "initHostView";
    public static final String DATA_TIME_INIT_WITHDATA = "initWithData";
    public static final String DATA_TIME_LIVEACTIVITY_ONCREATE = "LiveAcivityOnCreate";
    public static final String DATA_TIME_ONCREATE_INIT_HOST_VIEW = "onCreateInitHostView";
    public static final String DATA_TIME_PLAYEA_FIRST_FRAME = "playerFirstFrameTime";
    public static final String DATA_TIME_PLAYER_FIRST_ADFRAME_TIME = "playerFirstAdFrameTime";
    public static final String DATA_TIME_PRELOADER = "preloaderTime";
    public static final String DATA_TIME_RENDER_WITH_LIVE_FULLINFO = "renderWithLiveFullInfoTime";
    public static final String DATA_TIME_REQUESTFULLINFO = "requestFullInfoTime";
    private static final int MAX_SIZE = 200;
    private static final String TAG = "YKPrefReporter";
    private static YKPrefReporter mInstance = null;
    private static boolean mIsFirstLoad = true;
    private volatile ConcurrentHashMap<String, OnePlay> mPlayMap;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class OnePlay {
        private long mADFirstFrameTime;
        private long mClickTime;
        private long mFirstFrameTime;
        private String mFlowType;
        private long mFullInfoEndTime;
        private long mFullInfoRenderEndTime;
        private long mFullInfoRenderStartTime;
        private long mFullInfoStartTime;
        private long mInitHostViewEndTime;
        private long mInitHostViewStartTime;
        private long mInitWithDataEndTime;
        private long mInitWithDataStartTime;
        private boolean mIsMcu;
        private long mOnCreateEndTime;
        private long mOnCreateStartTime;
        private long mPreloadEndTime;
        private long mPreloadStartTime;
        private String mSessionId;
        private String mHasPlayinfo = "0";
        private String mHasTmpId = "0";
        private String mNav = "0";
        private String mOnCreateHasFullInfo = "0";
        private String mRoomSwitch = "0";
        private String mLiveRoomBizType = "0";
        private String mLiveRoomSource = "未知";
        private String mLiveDeviceScore = "0";

        public OnePlay(String str) {
            this.mSessionId = str;
        }

        public long getADFirstFrameTime() {
            return this.mADFirstFrameTime;
        }

        public long getClickTime() {
            return this.mClickTime;
        }

        public long getFirstFrameTime() {
            return this.mFirstFrameTime;
        }

        public String getFlowType() {
            return this.mFlowType;
        }

        public long getFullInfoEndTime() {
            return this.mFullInfoEndTime;
        }

        public long getFullInfoRenderEndTime() {
            return this.mFullInfoRenderEndTime;
        }

        public long getFullInfoRenderStartTime() {
            return this.mFullInfoRenderStartTime;
        }

        public long getFullInfoStartTime() {
            return this.mFullInfoStartTime;
        }

        public String getHasPlayinfo() {
            return this.mHasPlayinfo;
        }

        public String getHasTmpId() {
            return this.mHasTmpId;
        }

        public long getInitHostViewEndTime() {
            return this.mInitHostViewEndTime;
        }

        public long getInitHostViewStartTime() {
            return this.mInitHostViewStartTime;
        }

        public long getInitWithDataEndTime() {
            return this.mInitWithDataEndTime;
        }

        public long getInitWithDataStartTime() {
            return this.mInitWithDataStartTime;
        }

        public String getLiveDeviceScore() {
            return this.mLiveDeviceScore;
        }

        public String getLiveRoomBizType() {
            return this.mLiveRoomBizType;
        }

        public String getLiveRoomSource() {
            return this.mLiveRoomSource;
        }

        public String getNav() {
            return this.mNav;
        }

        public long getOnCreateEndTime() {
            return this.mOnCreateEndTime;
        }

        public String getOnCreateHasFullInfo() {
            return this.mOnCreateHasFullInfo;
        }

        public long getOnCreateStartTime() {
            return this.mOnCreateStartTime;
        }

        public long getPreloadEndTime() {
            return this.mPreloadEndTime;
        }

        public long getPreloadStartTime() {
            return this.mPreloadStartTime;
        }

        public String getRoomSwitch() {
            return this.mRoomSwitch;
        }

        public boolean isMcu() {
            return this.mIsMcu;
        }

        public void report() {
            DimensionValueSet value = DimensionValueSet.create().setValue(YKPrefReporter.DATA_KEY_HAS_PLAYINFO, this.mHasPlayinfo);
            value.setValue(YKPrefReporter.DATA_KEY_HAS_TMP_ID, this.mHasTmpId);
            value.setValue(YKPrefReporter.DATA_KEY_IS_NAV, this.mNav);
            value.setValue(YKPrefReporter.DATA_KEY_FLOW_TYPE, this.mFlowType);
            value.setValue(YKPrefReporter.DATA_KEY_ONCREATE_FULLINFO, this.mOnCreateHasFullInfo);
            value.setValue(YKPrefReporter.DATA_KEY_ROOM_SCROLL_SWITCH, this.mRoomSwitch);
            if (YKPrefReporter.mIsFirstLoad) {
                value.setValue(YKPrefReporter.DATA_KEY_IS_FIRST_LOAD, "1");
                boolean unused = YKPrefReporter.mIsFirstLoad = false;
            } else {
                value.setValue(YKPrefReporter.DATA_KEY_IS_FIRST_LOAD, "0");
            }
            value.setValue(YKPrefReporter.DATA_KEY_LIVE_ROOM_BIZ_TYPE, this.mLiveRoomBizType);
            value.setValue(YKPrefReporter.DATA_KEY_LIVE_ROOM_SOURCE, this.mLiveRoomSource);
            value.setValue(YKPrefReporter.DATA_KEY_DEVICE_SCORE, this.mLiveDeviceScore);
            float f = (float) (this.mPreloadEndTime - this.mPreloadStartTime);
            float f2 = (float) (this.mFullInfoEndTime - this.mFullInfoStartTime);
            float f3 = (float) (this.mFullInfoRenderEndTime - this.mFullInfoRenderStartTime);
            long j = this.mOnCreateEndTime;
            float f4 = (float) (j - this.mOnCreateStartTime);
            long j2 = this.mFirstFrameTime;
            long j3 = this.mClickTime;
            float f5 = (float) (j2 - j3);
            float f6 = (float) (this.mADFirstFrameTime - j3);
            long j4 = this.mInitHostViewStartTime;
            float f7 = (float) (j4 - j);
            float f8 = (float) (this.mInitHostViewEndTime - j4);
            float f9 = (float) (this.mInitWithDataEndTime - this.mInitWithDataStartTime);
            if (f6 < 0.0f) {
                f6 = -1.0f;
            }
            if (f9 < 0.0f) {
                f9 = -1.0f;
            }
            MeasureValueSet value2 = MeasureValueSet.create().setValue(YKPrefReporter.DATA_TIME_PRELOADER, f);
            value2.setValue(YKPrefReporter.DATA_TIME_REQUESTFULLINFO, f2);
            value2.setValue(YKPrefReporter.DATA_TIME_RENDER_WITH_LIVE_FULLINFO, f3);
            value2.setValue(YKPrefReporter.DATA_TIME_LIVEACTIVITY_ONCREATE, f4);
            value2.setValue(YKPrefReporter.DATA_TIME_PLAYEA_FIRST_FRAME, f5);
            value2.setValue(YKPrefReporter.DATA_TIME_PLAYER_FIRST_ADFRAME_TIME, f6);
            value2.setValue(YKPrefReporter.DATA_TIME_ONCREATE_INIT_HOST_VIEW, f7);
            value2.setValue(YKPrefReporter.DATA_TIME_INIT_HOSTVIEW, f8);
            value2.setValue(YKPrefReporter.DATA_TIME_INIT_WITHDATA, f9);
            if (this.mClickTime != 0 && !TextUtils.isEmpty(this.mSessionId)) {
                AppMonitor.Stat.commit(YKPrefReporter.DATA_KEY_MODULE_NAME, YKPrefReporter.DATA_KEY_MONITOR_NAME, value, value2);
            }
            if (YKPrefReporter.getInstance().getPlayBySessionId(this.mSessionId) != null) {
                YKPrefReporter.getInstance().removePlayBySessionId(this.mSessionId);
            }
            Log.d(YKPrefReporter.TAG, "SessiondId = " + this.mSessionId);
            StringBuilder sb = new StringBuilder();
            sb.append("OnePlay{mHasPlayinfo='");
            sb.append(this.mHasPlayinfo);
            sb.append('\'');
            sb.append(", mHasTmpId='");
            sb.append(this.mHasTmpId);
            sb.append('\'');
            sb.append(", mNav='");
            sb.append(this.mNav);
            sb.append('\'');
            sb.append(", mFlowType='");
            sb.append(this.mFlowType);
            sb.append('\'');
            sb.append(", mOnCreateHasFullInfo='");
            sb.append(this.mOnCreateHasFullInfo);
            sb.append('\'');
            sb.append(", mRoomSwitch='");
            sb.append(this.mRoomSwitch);
            sb.append('\'');
            sb.append(", mFirstLoad ='");
            sb.append(YKPrefReporter.mIsFirstLoad ? "1" : "0");
            sb.append('\'');
            sb.append(", mLiveRoomBizType ='");
            sb.append(this.mLiveRoomBizType);
            sb.append('\'');
            sb.append(", mIsMcu ='");
            sb.append(this.mIsMcu);
            sb.append('\'');
            sb.append(", mLiveRoomSource ='");
            sb.append(this.mLiveRoomSource);
            sb.append('\'');
            sb.append(", mLiveDeviceScore ='");
            sb.append(this.mLiveDeviceScore);
            sb.append('\'');
            sb.append(", preloaderTime=");
            sb.append(f);
            sb.append(", fullInfoTime=");
            sb.append(f2);
            sb.append(", fullInfoRenderTime=");
            sb.append(f3);
            sb.append(", omCreateTime=");
            sb.append(f4);
            sb.append(", firstFrameTime=");
            sb.append(f5);
            sb.append(", firstADFrameTime=");
            sb.append(f6);
            sb.append(", onCreateToHostTime=");
            sb.append(f7);
            sb.append(", initHostViewTime=");
            sb.append(f8);
            sb.append(", initWithDataTime=");
            sb.append(f9);
            sb.append('}');
            Log.d(YKPrefReporter.TAG, sb.toString());
        }

        public void setADFirstFrameTime(long j) {
            this.mADFirstFrameTime = j;
        }

        public void setClickTime(long j) {
            this.mClickTime = j;
        }

        public void setFirstFrameTime(long j) {
            this.mFirstFrameTime = j;
        }

        public void setFlowType(String str) {
            this.mFlowType = str;
        }

        public void setFullInfoEndTime(long j) {
            this.mFullInfoEndTime = j;
        }

        public void setFullInfoRenderEndTime(long j) {
            this.mFullInfoRenderEndTime = j;
        }

        public void setFullInfoRenderStartTime(long j) {
            this.mFullInfoRenderStartTime = j;
        }

        public void setFullInfoStartTime(long j) {
            this.mFullInfoStartTime = j;
        }

        public void setHasPlayinfo(String str) {
            this.mHasPlayinfo = str;
        }

        public void setHasTmpId(String str) {
            this.mHasTmpId = str;
        }

        public void setInitHostViewEndTime(long j) {
            this.mInitHostViewEndTime = j;
        }

        public void setInitHostViewStartTime(long j) {
            this.mInitHostViewStartTime = j;
        }

        public void setInitWithDataEndTime(long j) {
            this.mInitWithDataEndTime = j;
        }

        public void setInitWithDataStartTime(long j) {
            this.mInitWithDataStartTime = j;
        }

        public void setIsMcu(boolean z) {
            this.mIsMcu = z;
        }

        public void setLiveDeviceScore(String str) {
            this.mLiveDeviceScore = str;
        }

        public void setLiveRoomBizType(String str) {
            this.mLiveRoomBizType = str;
        }

        public void setLiveRoomSource(String str) {
            this.mLiveRoomSource = str;
        }

        public void setNav(String str) {
            this.mNav = str;
        }

        public void setOnCreateEndTime(long j) {
            this.mOnCreateEndTime = j;
        }

        public void setOnCreateHasFullInfo(String str) {
            this.mOnCreateHasFullInfo = str;
        }

        public void setOnCreateStartTime(long j) {
            this.mOnCreateStartTime = j;
        }

        public void setPreloadEndTime(long j) {
            this.mPreloadEndTime = j;
        }

        public void setPreloadStartTime(long j) {
            this.mPreloadStartTime = j;
        }

        public void setRoomSwitch(String str) {
            this.mRoomSwitch = str;
        }
    }

    private YKPrefReporter() {
        Log.d(TAG, "YKPrefReporter register");
        DimensionSet create = DimensionSet.create();
        create.addDimension(DATA_KEY_HAS_PLAYINFO);
        create.addDimension(DATA_KEY_HAS_TMP_ID);
        create.addDimension(DATA_KEY_IS_NAV);
        create.addDimension(DATA_KEY_FLOW_TYPE);
        create.addDimension(DATA_KEY_ONCREATE_FULLINFO);
        create.addDimension(DATA_KEY_ROOM_SCROLL_SWITCH);
        create.addDimension(DATA_KEY_IS_FIRST_LOAD);
        create.addDimension(DATA_KEY_LIVE_ROOM_BIZ_TYPE);
        create.addDimension(DATA_KEY_LIVE_ROOM_SOURCE);
        create.addDimension(DATA_KEY_DEVICE_SCORE);
        MeasureSet create2 = MeasureSet.create();
        create2.addMeasure(DATA_TIME_PRELOADER);
        create2.addMeasure(DATA_TIME_REQUESTFULLINFO);
        create2.addMeasure(DATA_TIME_RENDER_WITH_LIVE_FULLINFO);
        create2.addMeasure(DATA_TIME_LIVEACTIVITY_ONCREATE);
        create2.addMeasure(DATA_TIME_PLAYEA_FIRST_FRAME);
        create2.addMeasure(DATA_TIME_PLAYER_FIRST_ADFRAME_TIME);
        create2.addMeasure(DATA_TIME_ONCREATE_INIT_HOST_VIEW);
        create2.addMeasure(DATA_TIME_INIT_HOSTVIEW);
        create2.addMeasure(DATA_TIME_INIT_WITHDATA);
        AppMonitor.register(DATA_KEY_MODULE_NAME, DATA_KEY_MONITOR_NAME, create2, create);
    }

    public static String genOnePlayId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2142086739")) {
            return (String) ipChange.ipc$dispatch("2142086739", new Object[]{Long.valueOf(j)});
        }
        return j + "" + Math.floor(Math.random() * 10.0d);
    }

    public static synchronized YKPrefReporter getInstance() {
        synchronized (YKPrefReporter.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-96247627")) {
                return (YKPrefReporter) ipChange.ipc$dispatch("-96247627", new Object[0]);
            }
            if (mInstance == null) {
                mInstance = new YKPrefReporter();
            }
            return mInstance;
        }
    }

    private ConcurrentHashMap<String, OnePlay> getPlayMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1973046172")) {
            return (ConcurrentHashMap) ipChange.ipc$dispatch("1973046172", new Object[]{this});
        }
        if (this.mPlayMap == null) {
            synchronized (this) {
                if (this.mPlayMap == null) {
                    this.mPlayMap = new ConcurrentHashMap<>();
                }
            }
        }
        return this.mPlayMap;
    }

    public OnePlay getPlayBySessionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844338190")) {
            return (OnePlay) ipChange.ipc$dispatch("-844338190", new Object[]{this, str});
        }
        OnePlay onePlay = getPlayMap().get(str);
        if (onePlay == null) {
            if (getPlayMap().size() >= 200) {
                getPlayMap().clear();
            }
            OnePlay onePlay2 = new OnePlay(str);
            getPlayMap().put(str, onePlay2);
            return onePlay2;
        }
        return onePlay;
    }

    public void removePlayBySessionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647409590")) {
            ipChange.ipc$dispatch("1647409590", new Object[]{this, str});
        } else if (getPlayMap().containsKey(str)) {
            getPlayMap().put(str, new OnePlay(str));
        }
    }
}
