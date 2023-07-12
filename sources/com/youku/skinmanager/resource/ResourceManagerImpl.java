package com.youku.skinmanager.resource;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.youku.skinmanager.SkinManager;
import com.youku.skinmanager.utils.SkinResourceUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ResourceManagerImpl implements IResourceManager {
    private Map<String, WeakReference<Drawable>> mDrawableMap = new HashMap();
    private Map<String, Integer> mColorMap = new HashMap();
    private Map<String, String> mJsonMap = new HashMap();

    @Override // com.youku.skinmanager.resource.IResourceManager
    public void clear() {
        this.mJsonMap.clear();
        this.mColorMap.clear();
        this.mDrawableMap.clear();
    }

    @Override // com.youku.skinmanager.resource.IResourceManager
    public Integer getColor(String str, String str2) {
        Map<String, Integer> map = this.mColorMap;
        if (map.containsKey(str + str2)) {
            Map<String, Integer> map2 = this.mColorMap;
            return map2.get(str + str2);
        }
        String str3 = this.mJsonMap.get(str);
        if (TextUtils.isEmpty(str3)) {
            str3 = SkinResourceUtils.getJson(str);
            this.mJsonMap.put(str, str3);
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            Integer color = SkinResourceUtils.getColor(JSON.parseObject(str3), str2);
            if (color != null) {
                Map<String, Integer> map3 = this.mColorMap;
                map3.put(str + str2, color);
                return color;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.youku.skinmanager.resource.IResourceManager
    public ColorStateList getColorStateList(String str, String str2, String str3) {
        int intValue = getColor(str, str2).intValue();
        int intValue2 = getColor(str, str3).intValue();
        if (intValue == -1 || intValue2 == -1) {
            return null;
        }
        return SkinResourceUtils.makeColorList(intValue, intValue2);
    }

    @Override // com.youku.skinmanager.resource.IResourceManager
    @Nullable
    public Drawable getDrawable(String str) {
        WeakReference<Drawable> weakReference = this.mDrawableMap.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        Context context = SkinManager.sContext;
        if (context == null) {
            return null;
        }
        Drawable drawable = SkinResourceUtils.getDrawable(context, str);
        if (drawable != null) {
            this.mDrawableMap.put(str, new WeakReference<>(drawable));
        }
        return drawable;
    }
}
