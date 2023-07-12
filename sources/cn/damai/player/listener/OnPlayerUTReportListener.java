package cn.damai.player.listener;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface OnPlayerUTReportListener {
    void fullScreenBtnClick(String str);

    void onMuteBtnClick(String str, int i);

    void onPauseOrPlayClick(String str, int i);

    void onSeekBarClick(String str);

    void playEnd(String str, int i);

    void playStart(String str);

    void returnSmallScreen(String str);
}
