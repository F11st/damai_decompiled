package com.youku.vpm.track.impairment;

import com.youku.vpm.track.Track;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ImpairmentTrack {
    public static final String TAG = "Impairment";
    private boolean isloading;
    private ImpairmentReport mCommit;
    protected int mDropCount;
    public double mImpairmentDuration = 0.0d;
    public int mImpairmentOrder = 0;
    private Track mTrack;

    public ImpairmentTrack(Track track) {
        this.mTrack = track;
    }

    public double getDropCount() {
        return this.mDropCount;
    }

    public double getImpairmentDuration() {
        return this.mImpairmentDuration;
    }

    public double getImpairmentFrequency() {
        return this.mImpairmentOrder;
    }

    public void onDropVideoFrames(int i) {
        this.mDropCount++;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPlayLoadingEnd(java.lang.String r12, int r13, int r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.vpm.track.impairment.ImpairmentTrack.onPlayLoadingEnd(java.lang.String, int, int, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPlayLoadingStart(java.lang.String r9, int r10, int r11, java.lang.Object r12) {
        /*
            r8 = this;
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "onPlayLoadingStart ----> action:"
            r12.append(r0)
            r12.append(r9)
            java.lang.String r9 = " arg1:"
            r12.append(r9)
            r12.append(r10)
            java.lang.String r9 = " arg2:"
            r12.append(r9)
            r12.append(r11)
            java.lang.String r9 = " mTrack.isRealVideoStarted:"
            r12.append(r9)
            com.youku.vpm.track.Track r9 = r8.mTrack
            boolean r9 = r9.isRealVideoStarted()
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            java.lang.String r10 = "Impairment"
            com.youku.media.arch.instruments.utils.RemoteLogger.log(r10, r9)
            com.youku.vpm.track.Track r9 = r8.mTrack
            boolean r9 = r9.isRealVideoStarted()
            r11 = 0
            if (r9 != 0) goto L45
            java.lang.String r9 = "onPlayLoadingStart is not realVideoStarted "
            com.youku.media.arch.instruments.utils.RemoteLogger.log(r10, r9)
            r8.isloading = r11
            return
        L45:
            com.youku.vpm.track.Track r9 = r8.mTrack
            com.youku.vpm.IVpmFullInfo r9 = r9.getVpmFullInfo()
            r12 = 1
            r0 = 0
            com.youku.vpm.track.Track r2 = r8.mTrack     // Catch: java.lang.Exception -> L74
            com.youku.vpm.IPlayer r2 = r2.getPlayer()     // Catch: java.lang.Exception -> L74
            java.lang.String r11 = r2.getPlayerInfoByKey(r11)     // Catch: java.lang.Exception -> L74
            double r2 = java.lang.Double.parseDouble(r11)     // Catch: java.lang.Exception -> L74
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r2 = r2 / r4
            com.youku.vpm.track.Track r11 = r8.mTrack     // Catch: java.lang.Exception -> L72
            com.youku.vpm.IPlayer r11 = r11.getPlayer()     // Catch: java.lang.Exception -> L72
            java.lang.String r11 = r11.getPlayerInfoByKey(r12)     // Catch: java.lang.Exception -> L72
            double r6 = java.lang.Double.parseDouble(r11)     // Catch: java.lang.Exception -> L72
            double r6 = r6 / r4
            goto L7a
        L72:
            r11 = move-exception
            goto L76
        L74:
            r11 = move-exception
            r2 = r0
        L76:
            r11.printStackTrace()
            r6 = r0
        L7a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r4 = "loading start totaldownload size "
            r11.append(r4)
            r11.append(r2)
            java.lang.String r4 = " totalConsumedSizeStart "
            r11.append(r4)
            r11.append(r6)
            java.lang.String r4 = " left "
            r11.append(r4)
            double r4 = r2 - r6
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            com.youku.media.arch.instruments.utils.RemoteLogger.log(r10, r11)
            com.youku.vpm.track.impairment.ImpairmentReport r10 = new com.youku.vpm.track.impairment.ImpairmentReport
            com.youku.vpm.track.Track r11 = r8.mTrack
            java.lang.String r4 = "progress"
            double r0 = r9.getDouble(r4, r0)
            r10.<init>(r11, r0)
            r10.setDownLoadSizeStart(r2)
            r10.setConsumedSizeStart(r6)
            java.lang.String r9 = "URL"
            java.lang.String r9 = r10.getDimension(r9)
            boolean r11 = android.text.TextUtils.isEmpty(r9)
            if (r11 != 0) goto Ld9
            java.lang.String r11 = "/ad/"
            boolean r11 = r9.contains(r11)
            if (r11 != 0) goto Lcf
            java.lang.String r11 = "ccode=0902"
            boolean r9 = r9.contains(r11)
            if (r9 == 0) goto Ld9
        Lcf:
            com.youku.vpm.track.Track r9 = r8.mTrack
            com.youku.vpm.track.ad.AdTrack r9 = r9.getAdTrack()
            r11 = 4
            r9.onStartLoading(r11)
        Ld9:
            com.youku.vpm.track.impairment.ImpairmentReport r9 = r8.mCommit
            if (r9 == 0) goto Leb
            double r0 = r10.getStartTime()
            com.youku.vpm.track.impairment.ImpairmentReport r9 = r8.mCommit
            double r2 = r9.getEndTime()
            double r0 = r0 - r2
            r10.setImpairmentInterval(r0)
        Leb:
            r8.mCommit = r10
            r8.isloading = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.vpm.track.impairment.ImpairmentTrack.onPlayLoadingStart(java.lang.String, int, int, java.lang.Object):void");
    }
}
