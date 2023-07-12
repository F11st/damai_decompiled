package android.taobao.windvane.extra.performance;

import android.taobao.windvane.utils.TimeUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPagePerformance {
    private long h5_PP_FP;
    private long h5_PP_FSP;
    private long h5_PP_FSP_uptime;
    private long h5_PP_T1;
    private long h5_PP_T1_uptime;
    private long h5_PP_T2;
    private long h5_PP_T2_uptime;
    private long h5_PP_TTI;
    long h5_PP_domComplete;
    long h5_PP_domComplete_uptime;
    private long h5_PP_domContentLoadedEventStart;
    private long h5_PP_domContentLoadedEventStart_uptime;
    long h5_PP_domLoading;
    long h5_PP_domLoading_uptime;
    private String h5_PP_errorCode;
    private String h5_PP_errorMessage;
    private long h5_PP_fetchStart;
    private long h5_PP_fetchStart_uptime;
    private long h5_PP_finishLoad;
    private long h5_PP_finishLoad_uptime;
    private long h5_PP_interceptEnd;
    private long h5_PP_interceptStart;
    private boolean h5_PP_isFinished;
    private long h5_PP_loadEventEnd;
    private long h5_PP_loadEventEnd_uptime;
    private long h5_PP_loadEventStart;
    private long h5_PP_loadEventStart_uptime;
    private long h5_PP_navigationStart;
    private long h5_PP_navigationStart_uptime;
    long h5_PP_requestStart;
    long h5_PP_requestStart_uptime;
    private long h5_PP_responseEnd;
    private long h5_PP_responseEnd_uptime;
    private long h5_PP_startLoad;
    private long h5_PP_startLoad_uptime;
    private String url;

    public long getH5_PP_FP() {
        return this.h5_PP_FP + getH5_PP_navigationStart();
    }

    public long getH5_PP_FP_uptime() {
        return this.h5_PP_FP + getH5_PP_navigationStart_uptime();
    }

    public long getH5_PP_FSP() {
        return this.h5_PP_FSP;
    }

    public long getH5_PP_FSP_uptime() {
        return this.h5_PP_FSP_uptime;
    }

    public long getH5_PP_T1() {
        return this.h5_PP_T1;
    }

    public long getH5_PP_T1_uptime() {
        return this.h5_PP_T1_uptime;
    }

    public long getH5_PP_T2() {
        return this.h5_PP_T2;
    }

    public long getH5_PP_T2_uptime() {
        return this.h5_PP_T2_uptime;
    }

    public long getH5_PP_TTI() {
        long j = this.h5_PP_TTI;
        if (j == 0) {
            return getH5_PP_FSP();
        }
        return j + getH5_PP_navigationStart();
    }

    public long getH5_PP_TTI_uptime() {
        long j = this.h5_PP_TTI;
        if (j == 0) {
            return getH5_PP_FSP_uptime();
        }
        return j + getH5_PP_navigationStart_uptime();
    }

    public long getH5_PP_domContentLoadedEventStart() {
        return this.h5_PP_domContentLoadedEventStart;
    }

    public long getH5_PP_domContentLoadedEventStart_uptime() {
        return this.h5_PP_domContentLoadedEventStart_uptime;
    }

    public String getH5_PP_errorCode() {
        String str = this.h5_PP_errorCode;
        return str == null ? "" : str;
    }

    public String getH5_PP_errorMessage() {
        String str = this.h5_PP_errorMessage;
        return str == null ? "" : str;
    }

    public long getH5_PP_fetchStart() {
        return this.h5_PP_fetchStart;
    }

    public long getH5_PP_fetchStart_uptime() {
        return this.h5_PP_fetchStart_uptime;
    }

    public long getH5_PP_finishLoad() {
        return this.h5_PP_finishLoad;
    }

    public long getH5_PP_finishLoad_uptime() {
        return this.h5_PP_finishLoad_uptime;
    }

    public long getH5_PP_interceptEnd() {
        return this.h5_PP_interceptEnd;
    }

    public long getH5_PP_interceptStart() {
        return this.h5_PP_interceptStart;
    }

    public boolean getH5_PP_isFinished() {
        return this.h5_PP_isFinished;
    }

    public long getH5_PP_loadEventEnd() {
        return this.h5_PP_loadEventEnd;
    }

    public long getH5_PP_loadEventEnd_uptime() {
        return this.h5_PP_loadEventEnd_uptime;
    }

    public long getH5_PP_loadEventStart() {
        return this.h5_PP_loadEventStart;
    }

    public long getH5_PP_loadEventStart_uptime() {
        return this.h5_PP_loadEventStart_uptime;
    }

    public long getH5_PP_navigationStart() {
        return this.h5_PP_navigationStart;
    }

    public long getH5_PP_navigationStart_uptime() {
        return this.h5_PP_navigationStart_uptime;
    }

    public long getH5_PP_responseEnd() {
        return this.h5_PP_responseEnd;
    }

    public long getH5_PP_responseEnd_uptime() {
        return this.h5_PP_responseEnd_uptime;
    }

    public long getH5_PP_startLoad() {
        return this.h5_PP_startLoad;
    }

    public long getH5_PP_startLoad_uptime() {
        return this.h5_PP_startLoad_uptime;
    }

    public String getUrl() {
        String str = this.url;
        return str == null ? "" : str;
    }

    public void setH5_PP_FP(long j) {
        this.h5_PP_FP = j;
    }

    public void setH5_PP_FSP(long j) {
        this.h5_PP_FSP = j;
    }

    public void setH5_PP_FSP_uptime(long j) {
        this.h5_PP_FSP_uptime = j;
    }

    public void setH5_PP_T1(long j) {
        this.h5_PP_T1 = j;
    }

    public void setH5_PP_T1_uptime(long j) {
        this.h5_PP_T1_uptime = j;
    }

    public void setH5_PP_T2(long j) {
        this.h5_PP_T2 = j;
    }

    public void setH5_PP_T2_uptime(long j) {
        this.h5_PP_T2_uptime = j;
    }

    public void setH5_PP_TTI(long j) {
        this.h5_PP_TTI = j;
    }

    public void setH5_PP_domComplete(long j) {
        this.h5_PP_domComplete = j;
        this.h5_PP_domComplete_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_domContentLoadedEventStart(long j) {
        this.h5_PP_domContentLoadedEventStart = j;
        this.h5_PP_domContentLoadedEventStart_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_domLoading(long j) {
        this.h5_PP_domLoading = j;
        this.h5_PP_domLoading_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_errorCode(String str) {
        if (str == null) {
            return;
        }
        this.h5_PP_errorCode = str;
    }

    public void setH5_PP_errorMessage(String str) {
        if (str == null) {
            return;
        }
        this.h5_PP_errorMessage = str;
    }

    public void setH5_PP_fetchStart(long j) {
        this.h5_PP_fetchStart = j;
        this.h5_PP_fetchStart_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_finishLoad(long j) {
        this.h5_PP_finishLoad = j;
    }

    public void setH5_PP_finishLoad_uptime(long j) {
        this.h5_PP_finishLoad_uptime = j;
    }

    public void setH5_PP_interceptEnd(long j) {
        this.h5_PP_interceptEnd = j;
    }

    public void setH5_PP_interceptStart(long j) {
        this.h5_PP_interceptStart = j;
    }

    public void setH5_PP_isFinished(boolean z) {
        this.h5_PP_isFinished = z;
    }

    public void setH5_PP_loadEventEnd(long j) {
        this.h5_PP_loadEventEnd = j;
        this.h5_PP_loadEventEnd_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_loadEventStart(long j) {
        this.h5_PP_loadEventStart = j;
        this.h5_PP_loadEventStart_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_navigationStart(long j) {
        this.h5_PP_navigationStart = j;
        this.h5_PP_navigationStart_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_requestStart(long j) {
        this.h5_PP_requestStart = j;
        this.h5_PP_requestStart_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_responseEnd(long j) {
        this.h5_PP_responseEnd = j;
        this.h5_PP_responseEnd_uptime = TimeUtils.generateUptimeFromCurrentTime(j);
    }

    public void setH5_PP_startLoad(long j) {
        this.h5_PP_startLoad = j;
    }

    public void setH5_PP_startLoad_uptime(long j) {
        this.h5_PP_startLoad_uptime = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
