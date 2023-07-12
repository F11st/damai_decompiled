package com.youku.alixplayer.raphael;

import com.youku.alixplayer.model.Identity;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class IdentityExt extends Identity {
    public IdentityExt(long j) {
        super(j);
    }

    @Override // com.youku.alixplayer.model.Identity
    public Identity.Category getCategory() {
        return Identity.Category.MAIN;
    }

    @Override // com.youku.alixplayer.model.Identity
    public int getPeriodId() {
        return 0;
    }

    @Override // com.youku.alixplayer.model.Identity
    public int getPlayListId() {
        return 0;
    }

    @Override // com.youku.alixplayer.model.Identity
    public int getSourceId() {
        return 0;
    }
}
