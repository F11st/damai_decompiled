package com.youku.alixplayer.model;

import android.util.Log;
import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class Identity {
    private long mConcreteId;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum Category {
        MAIN,
        ISOLATED,
        UNDEFINED
    }

    public Identity(long j) {
        this.mConcreteId = j;
        Log.d("Identity", "id:" + Long.toHexString(this.mConcreteId));
    }

    public Category getCategory() {
        int playListId = getPlayListId();
        Category category = Category.UNDEFINED;
        return playListId < category.ordinal() ? Category.values()[playListId] : category;
    }

    public int getPeriodId() {
        return (int) ((this.mConcreteId >> 8) & 255);
    }

    public int getPlayListId() {
        return (int) ((this.mConcreteId >> 16) & 255);
    }

    public int getSourceId() {
        return (int) (this.mConcreteId & 255);
    }
}
