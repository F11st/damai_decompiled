package com.youku.skinmanager.resource;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IResourceManager {
    void clear();

    Integer getColor(String str, String str2);

    ColorStateList getColorStateList(String str, String str2, String str3);

    Drawable getDrawable(String str);
}
