package com.youku.css.binder;

import android.view.View;
import androidx.annotation.Nullable;
import com.youku.css.dto.Css;
import com.youku.css.finder.CssFinder;
import com.youku.css.setter.CssSetter;
import com.youku.style.IStyleContainer;
import com.youku.style.IStyleManager;
import com.youku.style.IStyleView;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CssBinder<STYLE extends Map> implements Serializable {
    private Map<String, Css> cssMap;
    private boolean isMerged;
    @Nullable
    private transient IStyleManager<STYLE> mContainerStyleManager;
    private String styleLabel;
    private boolean updateFromGlobalStyle;
    private Long updateTime;

    public CssBinder(String str, Map<String, Css> map, Long l) {
        this.cssMap = map;
        this.styleLabel = str;
        this.updateTime = l;
    }

    public void bindCss(View view, String str) {
        CssSetter.setCss(view, str, this.cssMap);
    }

    public void bindCssFollow(View view, String str, String... strArr) {
        CssSetter.setCssFollow(view, str, this.cssMap, strArr);
    }

    public void bindCssToField(View view, String str, String... strArr) {
        CssSetter.setCssToField(view, str, this.cssMap, strArr);
    }

    public void bindCssWithAlphaCompact(View view, String str, String... strArr) {
        CssSetter.setCssWithAlphaCompact(view, str, this.cssMap, strArr);
    }

    public Css findCss(String str) {
        return CssFinder.findCss(this.cssMap, str);
    }

    public STYLE getContainerCurrentStyle() {
        IStyleManager<STYLE> iStyleManager = this.mContainerStyleManager;
        if (iStyleManager != null) {
            return iStyleManager.getCurrentStyle();
        }
        return null;
    }

    @Nullable
    public IStyleManager<STYLE> getContainerStyleManager() {
        return this.mContainerStyleManager;
    }

    public Map<String, Css> getCssMap() {
        return this.cssMap;
    }

    public String getStyleLabel() {
        return this.styleLabel;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isMerged() {
        return this.isMerged;
    }

    public boolean isUpdateFromGlobalStyle() {
        return this.updateFromGlobalStyle;
    }

    public void putAllCssMap(Map<String, Css> map) {
        if (this.cssMap == null) {
            this.cssMap = map;
        } else if (map == null || map.isEmpty()) {
        } else {
            this.cssMap.putAll(map);
        }
    }

    public void putCssMap(Map<String, Css> map) {
        if (this.cssMap == null) {
            this.cssMap = map;
        } else if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                if (!this.cssMap.containsKey(str)) {
                    this.cssMap.put(str, map.get(str));
                }
            }
        }
    }

    public void putGlobalCssMap(Map<String, Css> map) {
        putCssMap(map);
        this.updateFromGlobalStyle = true;
    }

    public void setContainer(IStyleContainer<STYLE> iStyleContainer) {
        if (iStyleContainer != null) {
            this.mContainerStyleManager = iStyleContainer.getStyleManager();
        }
    }

    public void setContainerStyleManager(IStyleManager<STYLE> iStyleManager) {
        this.mContainerStyleManager = iStyleManager;
    }

    public void setCssMap(Map<String, Css> map) {
        this.cssMap = map;
    }

    public void setMerged(boolean z) {
        this.isMerged = z;
    }

    public void setStyleLabel(String str) {
        this.styleLabel = str;
    }

    public void setUpdateTime(Long l) {
        this.updateTime = l;
    }

    public void bindCss(IStyleView iStyleView, String str) {
        CssSetter.setCss(iStyleView, str, this.cssMap);
    }
}
