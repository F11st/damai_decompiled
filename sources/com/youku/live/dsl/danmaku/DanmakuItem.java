package com.youku.live.dsl.danmaku;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DanmakuItem {
    public String avatarUrl;
    public CharSequence content;
    public DanmakuConfig danmuConfig;
    public long id;
    public boolean isGuest;
    public String nickName;
    public long userId;

    public DanmakuItem(CharSequence charSequence) {
        this.danmuConfig = new DanmakuConfig();
        this.id = System.currentTimeMillis();
        this.content = charSequence;
    }

    public DanmakuItem(long j, boolean z, String str, String str2, CharSequence charSequence) {
        this.danmuConfig = new DanmakuConfig();
        this.id = System.currentTimeMillis();
        this.userId = j;
        this.isGuest = z;
        this.avatarUrl = str;
        this.content = charSequence;
        this.nickName = str2;
    }

    public DanmakuItem(long j, boolean z, String str, String str2, CharSequence charSequence, DanmakuConfig danmakuConfig) {
        this.danmuConfig = new DanmakuConfig();
        this.id = System.currentTimeMillis();
        this.userId = j;
        this.isGuest = z;
        this.avatarUrl = str;
        this.content = charSequence;
        this.nickName = str2;
        this.danmuConfig = danmakuConfig;
    }
}
