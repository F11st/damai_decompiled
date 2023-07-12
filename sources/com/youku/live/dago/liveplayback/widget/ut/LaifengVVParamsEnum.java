package com.youku.live.dago.liveplayback.widget.ut;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public enum LaifengVVParamsEnum {
    YOUKULIVE("page_youkulive", "a2h08.8176999"),
    DAMAI("page_youkulive", "a2h08.8176999"),
    LAIFENG_LF("page_laifeng_room", "a2ha4.13588222"),
    LAIFENG_YK("page_yklaifeng_room", "a2h0m.room"),
    LAIFENG_UC("page_uclive_room", "uclive.room"),
    LAIFENG_XM("page_xiamilaifeng_room", "a2o2q.room");
    
    private String pageName;
    private String spm;

    LaifengVVParamsEnum(String str, String str2) {
        this.pageName = str;
        this.spm = str2;
    }

    public String getPageName() {
        return this.pageName;
    }

    public String getSPM() {
        return this.spm;
    }
}
