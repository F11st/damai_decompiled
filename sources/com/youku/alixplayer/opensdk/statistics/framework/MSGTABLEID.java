package com.youku.alixplayer.opensdk.statistics.framework;

import com.youku.alixplayer.Reporter;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public enum MSGTABLEID {
    ONEPLAY(Reporter.MonitorTableName.ONE_PLAY),
    IMPAIRMENT(Reporter.MonitorTableName.IMPAIRMENT),
    BEFORE_PLAY(Reporter.MonitorTableName.BEFORE_PLAY),
    PLAYING(Reporter.MonitorTableName.PLAYING),
    ONECHANGE_SEEK(Reporter.MonitorTableName.ONE_CHANGE_SEEK),
    ONECHANGE_QUALITY(Reporter.MonitorTableName.ONE_CHANGE_QUALITY),
    PLAYHEARTBEAT(Reporter.MonitorTableName.PLAY_HEART_BEAT),
    ONEEVENT(Reporter.MonitorTableName.ONE_EVENT),
    AD_PLAY(Reporter.MonitorTableName.AD_PLAY),
    AD_ERROR(Reporter.MonitorTableName.AD_ERROR),
    AD_IMPAIRMENT(Reporter.MonitorTableName.AD_IMPAIRMENT),
    START_LOADING(Reporter.MonitorTableName.START_LOADING),
    SUBTITLE_EVENT(null),
    PLAY_ABNORMAL_DETAIL(Reporter.MonitorTableName.PLAY_ABNORMAL_DETAIL),
    PLAY_ABNORMAL_SUMMARY(Reporter.MonitorTableName.PLAY_ABNORMAL_SUMMARY);
    
    private Reporter.MonitorTableName mMonitorTableName;

    MSGTABLEID(Reporter.MonitorTableName monitorTableName) {
        this.mMonitorTableName = monitorTableName;
    }

    public Reporter.MonitorTableName getMonitorTableName() {
        return this.mMonitorTableName;
    }
}
