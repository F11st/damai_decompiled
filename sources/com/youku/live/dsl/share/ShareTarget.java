package com.youku.live.dsl.share;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum ShareTarget {
    SHARE_TARGET_QQ(0),
    SHARE_TARGET_QZONE(1),
    SHARE_TARGET_WECHAT(2),
    SHARE_TARGET_FRIEND(3),
    SHARE_TARGET_SINA_WEIBO(4),
    SHARE_TARGET_ALIPAY(5);
    
    private final int mTargetId;

    ShareTarget(int i) {
        this.mTargetId = i;
    }

    public int getTargetId() {
        return this.mTargetId;
    }
}
