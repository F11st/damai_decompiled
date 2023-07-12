package com.alibaba.security.biometrics.service.common;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.listener.OnLogTrackListener;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.c.C3800a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABLogRecorder implements ABLogRecorderKeys {
    protected static ABLogRecorder INSTANCE = null;
    private static final String TAG = "ABLogRecorder";
    private long actStartTime;
    private long adjustStartTime;
    private long detectStartTime;
    protected Handler handler;
    protected HandlerThread handlerThread;
    private long reflectStartTime;
    private long resultStartTime;
    protected OnLogTrackListener mOnLogRecordListener = null;
    protected long lastSensorDataRecordTime = 0;
    protected int sensorRecordIntervals = 0;

    private ABLogRecorder() {
        HandlerThread handlerThread = new HandlerThread("ab_log_recorder");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper());
    }

    public static String getStack(Throwable th, String str) {
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(th.getMessage());
        sb.append(str);
        if (th.getStackTrace() != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append(stackTraceElement);
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static ABLogRecorder i() {
        if (INSTANCE == null) {
            INSTANCE = new ABLogRecorder();
        }
        return INSTANCE;
    }

    public static void releaseI() {
        HandlerThread handlerThread;
        try {
            ABLogRecorder aBLogRecorder = INSTANCE;
            if (aBLogRecorder != null && (handlerThread = aBLogRecorder.handlerThread) != null) {
                handlerThread.getLooper().quit();
            }
            INSTANCE = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void copyData(String str, Bundle bundle) {
        if (bundle == null || str == null || ABDetectContext.getInstance().getRecordData() == null || !ABDetectContext.getInstance().getRecordData().containsKey(str)) {
            return;
        }
        bundle.putString(str, ABDetectContext.getInstance().getRecordData().getString(str));
    }

    public long getLastSensorDataRecordTime() {
        return this.lastSensorDataRecordTime;
    }

    public int getSensorRecordIntervals() {
        return this.sensorRecordIntervals;
    }

    public void record(Throwable th) {
        Bundle bundle = new Bundle();
        bundle.putString("stack", getStack(th, " "));
        record("10099", bundle);
        if (th != null) {
            th.printStackTrace();
        }
    }

    public void recordStartDetect(ALBiometricsParams aLBiometricsParams) {
        Bundle bundle = new Bundle();
        bundle.putInt("cam_w", ABDetectContext.getInstance().getDisplayWidth());
        bundle.putInt("cam_h", ABDetectContext.getInstance().getDisplayHeight());
        bundle.putInt("cam_a", ABDetectContext.getInstance().getRotationAngle());
        bundle.putFloat("act_th", aLBiometricsParams.activeActionThreshold);
        bundle.putFloat("act_wr_th", aLBiometricsParams.inactiveActionThreshold);
        int actionCount = ABDetectContext.getInstance().getActionCount();
        bundle.putInt("act_c", actionCount);
        if (actionCount > 0) {
            bundle.putInt("act_1", ABDetectContext.getInstance().getActions().get(0).getValue());
        }
        if (actionCount > 1) {
            bundle.putInt("act_2", ABDetectContext.getInstance().getActions().get(1).getValue());
        }
        if (actionCount > 2) {
            bundle.putInt("act_3", ABDetectContext.getInstance().getActions().get(2).getValue());
        }
        if (actionCount > 3) {
            bundle.putInt("act_4", ABDetectContext.getInstance().getActions().get(3).getValue());
        }
        if (actionCount > 4) {
            bundle.putInt("act_5", ABDetectContext.getInstance().getActions().get(4).getValue());
        }
        if (actionCount == 0) {
            bundle.putInt("act_c", aLBiometricsParams.actionCount);
        }
        bundle.putInt("retry_m", aLBiometricsParams.retryThreshold);
        bundle.putInt("fail_m", aLBiometricsParams.mineThreshold);
        bundle.putInt("aju_to", aLBiometricsParams.timeout);
        bundle.putInt("act_to", aLBiometricsParams.timeout);
        bundle.putInt("min_face_th", 100);
        bundle.putFloat("act_th", aLBiometricsParams.activeActionThreshold);
        bundle.putFloat("act_wr_th", aLBiometricsParams.inactiveActionThreshold);
        bundle.putFloat("no_face_th", aLBiometricsParams.noFaceThreshold);
        bundle.putFloat("qua_th", aLBiometricsParams.minQuality);
        bundle.putFloat("gblur_th", aLBiometricsParams.gaussianBlur);
        bundle.putFloat("mblur_th", aLBiometricsParams.motionBlur);
        bundle.putInt("retry_tt", ABDetectContext.getInstance().getRetryTimes());
        record("10003", bundle);
        ABDetectContext.getInstance().setFrameCount(0);
    }

    public void setLastSensorDataRecordTime(long j) {
        this.lastSensorDataRecordTime = j;
    }

    public void setOnLogRecordListener(OnLogTrackListener onLogTrackListener) {
        this.mOnLogRecordListener = onLogTrackListener;
    }

    public void setSensorRecordIntervals(int i) {
        this.sensorRecordIntervals = i;
    }

    protected void timeStat(String str, Bundle bundle) {
        try {
            if ("10003".equals(str)) {
                this.detectStartTime = System.currentTimeMillis();
            } else if ("10033".equals(str)) {
                bundle.putString("time_key", "time_liveness");
                bundle.putLong("time_time", System.currentTimeMillis() - this.detectStartTime);
                this.detectStartTime = System.currentTimeMillis();
            } else if ("10031".equals(str)) {
                bundle.putString("time_key", "time_liveness");
                bundle.putLong("time_time", System.currentTimeMillis() - this.detectStartTime);
            } else if (ABLogRecorderKeys.EventIdEnterAdjust.equals(str)) {
                this.adjustStartTime = System.currentTimeMillis();
            } else if (ABLogRecorderKeys.EventIdLeaveAdjust.equals(str)) {
                bundle.putString("time_key", "time_liveness_adj");
                bundle.putLong("time_time", System.currentTimeMillis() - this.adjustStartTime);
            } else if (ABLogRecorderKeys.EventIdEnterAct.equals(str)) {
                this.actStartTime = System.currentTimeMillis();
            } else if (ABLogRecorderKeys.EventIdActFail.equals(str)) {
                bundle.putString("time_key", "time_liveness_act_" + bundle.getInt("act_type", -1));
                bundle.putInt("time_result", 1);
                bundle.putLong("time_time", System.currentTimeMillis() - this.actStartTime);
            } else if (ABLogRecorderKeys.EventIdActSucc.equals(str)) {
                bundle.putString("time_key", "time_liveness_act_" + bundle.getInt("act_type", -1));
                bundle.putInt("time_result", 0);
                bundle.putLong("time_time", System.currentTimeMillis() - this.actStartTime);
            } else if (ABLogRecorderKeys.EventIdEnterReflect.equals(str)) {
                this.reflectStartTime = System.currentTimeMillis();
            } else if (ABLogRecorderKeys.EventIdLeaveReflect.equals(str)) {
                bundle.putString("time_key", "time_liveness_rfl");
                bundle.putLong("time_time", System.currentTimeMillis() - this.reflectStartTime);
            } else if ("10041".equals(str)) {
                this.resultStartTime = System.currentTimeMillis();
            } else if ("10042".equals(str)) {
                bundle.putString("time_key", "time_result");
                bundle.putLong("time_time", System.currentTimeMillis() - this.resultStartTime);
                this.resultStartTime = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void record(String str, Bundle bundle) {
        if (this.mOnLogRecordListener != null) {
            try {
                final Bundle bundle2 = new Bundle();
                bundle2.putString("code", str);
                bundle2.putString("eventId", str);
                if ("10000".equals(str)) {
                    copyData("vol_s", bundle2);
                } else if ("10003".equals(str)) {
                    copyData("cam_w", bundle2);
                    copyData("cam_h", bundle2);
                    copyData("cam_a", bundle2);
                    copyData("vol_s", bundle2);
                    copyData("nav", bundle2);
                    copyData("act_c", bundle2);
                    copyData("act_1", bundle2);
                    copyData("act_2", bundle2);
                    copyData("act_3", bundle2);
                    copyData("act_4", bundle2);
                    copyData("act_5", bundle2);
                    copyData("retry_m", bundle2);
                    copyData("fail_m", bundle2);
                    copyData("aju_to", bundle2);
                    copyData("act_to", bundle2);
                    copyData("act_th", bundle2);
                    copyData("act_wr_th", bundle2);
                    copyData("min_face_th", bundle2);
                    copyData("gblur_th", bundle2);
                    copyData("mblur_th", bundle2);
                    copyData("qua_th", bundle2);
                    copyData("no_face_th", bundle2);
                    copyData("gra", bundle2);
                } else if ("10001".equals(str)) {
                    copyData("gra", bundle2);
                } else if ("10002".equals(str)) {
                    copyData("gra", bundle2);
                } else if (ABLogRecorderKeys.EventIdEnterAdjust.equals(str)) {
                    copyData("aju_c", bundle2);
                    copyData("gra", bundle2);
                } else if (ABLogRecorderKeys.EventIdLeaveAdjust.equals(str)) {
                    copyData("result", bundle2);
                    copyData("frm_c", bundle2);
                    copyData("bri", bundle2);
                    copyData("gblur", bundle2);
                    copyData("mblur", bundle2);
                    copyData("qua", bundle2);
                    copyData("gra", bundle2);
                } else if (ABLogRecorderKeys.EventIdEnterAct.equals(str)) {
                    copyData("act_idx", bundle2);
                    copyData("act_type", bundle2);
                } else if ("10007".equals(str)) {
                    copyData("hint_c", bundle2);
                    copyData("gra", bundle2);
                } else if ("10008".equals(str)) {
                    copyData("snd_c", bundle2);
                    copyData("gra", bundle2);
                } else if (ABLogRecorderKeys.EventIdActSucc.equals(str)) {
                    copyData("result", bundle2);
                    copyData("frm_c", bundle2);
                    copyData("bri", bundle2);
                    copyData("gblur", bundle2);
                    copyData("mblur", bundle2);
                    copyData("qua", bundle2);
                    copyData("gra", bundle2);
                } else if (ABLogRecorderKeys.EventIdActFail.equals(str)) {
                    copyData("fail_t", bundle2);
                    copyData("result", bundle2);
                    copyData("frm_c", bundle2);
                    copyData("gra", bundle2);
                } else if ("10011".equals(str)) {
                    copyData("err_tt", bundle2);
                } else if ("10012".equals(str)) {
                    copyData("retry_tt", bundle2);
                } else if ("10013".equals(str)) {
                    copyData("confirm", bundle2);
                } else if (ABLogRecorderKeys.EventIdLivenessSucc.equals(str)) {
                    copyData("img1_ts", bundle2);
                    copyData("result", bundle2);
                    copyData("bri", bundle2);
                    copyData("gblur", bundle2);
                    copyData("mblur", bundle2);
                    copyData("qua", bundle2);
                    copyData("img2_ts", bundle2);
                    copyData("img3_ts", bundle2);
                    copyData("img4_ts", bundle2);
                    copyData("img5_ts", bundle2);
                } else if (!"10026".equals(str)) {
                    if ("10027".equals(str)) {
                        copyData("confirm", bundle2);
                    } else if ("10031".equals(str)) {
                        copyData("succ", bundle2);
                        copyData("reason", bundle2);
                        copyData("vol_s", bundle2);
                    } else if ("10099".equals(str)) {
                        bundle2.putString("flsdkversion", VersionKey.FL_SDK_VERSION);
                        bundle2.putString("rpsdkversion", VersionKey.RP_SDK_VERSION);
                    }
                }
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
                timeStat(str, bundle2);
                this.handler.post(new Runnable() { // from class: com.alibaba.security.biometrics.service.common.ABLogRecorder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ABLogRecorder.this.mOnLogRecordListener.onOldLogRecord(bundle2);
                        } catch (Exception unused) {
                            C3800a.b();
                        } catch (Throwable unused2) {
                            C3800a.b();
                        }
                    }
                });
            } catch (Exception unused) {
                C3800a.b();
            } catch (Throwable unused2) {
                C3800a.b();
            }
        }
    }
}
