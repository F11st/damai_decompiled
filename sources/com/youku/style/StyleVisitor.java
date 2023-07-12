package com.youku.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSONObject;
import com.youku.css.binder.CssBinder;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Css;
import com.youku.css.setter.CssSetter;
import com.youku.css.setter.IMultiStyleSetter;
import com.youku.css.storage.CssCache;
import com.youku.css.util.ColorUtil;
import com.youku.resource.utils.DynamicColorDefine;
import com.youku.resource.utils.StaticColorDefine;
import com.youku.style.core.BaseStyleVisitor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StyleVisitor<STYLE extends Map> extends BaseStyleVisitor<STYLE> {
    private static Map<String, String> mTokenStyleMapping;
    private static int[][] states = new int[2];
    private CssBinder<STYLE> cssBinder;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class StyleBuilder {
        private Map<String, String> map;

        public StyleBuilder() {
            HashMap hashMap = new HashMap();
            this.map = hashMap;
            hashMap.put(CssConst.CssKey.SCENE_THEME_COLOR, "#24a5ff");
            this.map.put(CssConst.CssKey.SCENE_SCORE_COLOR, "#ff6f3b");
        }

        public StyleVisitor build() {
            return new StyleVisitor(this.map);
        }

        public StyleBuilder setFillColor(String str) {
            this.map.put("sceneImgBgColor", str);
            return this;
        }

        public StyleBuilder setPrimaryBgColor(String str) {
            this.map.put(CssConst.CssKey.SCENE_BG_COLOR, str);
            return this;
        }

        public StyleBuilder setPrimaryInfoColor(String str) {
            this.map.put(CssConst.CssKey.SCENE_TITLE_COLOR, str);
            this.map.put(CssConst.CssKey.SCENE_CARD_HEADER_TITLE_COLOR, str);
            this.map.put(CssConst.CssKey.SCENE_CARD_FOOTER_TITLE_COLOR, str);
            return this;
        }

        public StyleBuilder setScoreColor(String str) {
            this.map.put(CssConst.CssKey.SCENE_SCORE_COLOR, str);
            return this;
        }

        public StyleBuilder setSecondaryBgColor(String str) {
            this.map.put(CssConst.CssKey.SCENE_CARD_FOOTER_BG_COLOR, str);
            if (!this.map.containsKey("sceneImgBgColor")) {
                this.map.put("sceneImgBgColor", str);
            }
            if (!this.map.containsKey(CssConst.CssKey.SCENE_SEPARATOR_COLOR)) {
                this.map.put(CssConst.CssKey.SCENE_SEPARATOR_COLOR, str);
            }
            return this;
        }

        public StyleBuilder setSecondaryInfoColor(String str) {
            this.map.put(CssConst.CssKey.SCENE_CARD_HEADER_KEYWORD_COLOR, str);
            this.map.put(CssConst.CssKey.SCENE_CARD_HEADER_ARROW_COLOR, str);
            if (!this.map.containsKey(CssConst.CssKey.SCENE_SUB_TITLE_COLOR)) {
                this.map.put(CssConst.CssKey.SCENE_SUB_TITLE_COLOR, str);
            }
            return this;
        }

        public StyleBuilder setSeparatorColor(String str) {
            this.map.put(CssConst.CssKey.SCENE_SEPARATOR_COLOR, str);
            return this;
        }

        public StyleBuilder setTertiaryInfoColor(String str) {
            this.map.put(CssConst.CssKey.SCENE_SUB_TITLE_COLOR, str);
            return this;
        }

        public StyleBuilder setThemeColor(String str) {
            this.map.put(CssConst.CssKey.SCENE_THEME_COLOR, str);
            return this;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        mTokenStyleMapping = hashMap;
        hashMap.put(DynamicColorDefine.YKN_PRIMARY_INFO, CssConst.CssScenes.TITLE);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_SECONDARY_INFO, CssConst.CssScenes.CARD_HEADER_KEYWORD);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_TERTIARY_INFO, CssConst.CssScenes.SUB_TITLE);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_QUATERNARY_INFO, CssConst.CssScenes.SUB_TITLE);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_PRIMARY_BACKGROUND, CssConst.CssScenes.VIEW);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_SECONDARY_BACKGROUND, CssConst.CssScenes.CARD_FOOTER);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_TERTIARY_BACKGROUND, CssConst.CssScenes.CARD_FOOTER);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_PRIMARY_FILL_COLOR, CssConst.CssScenes.IMG);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_SECONDARY_FILL_COLOR, CssConst.CssScenes.IMG);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_TERTIARY_FILL_COLOR, CssConst.CssScenes.IMG);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_SEPARATOR, CssConst.CssScenes.SEPARATOR);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_HIDE_ABLE_SEPARATOR, CssConst.CssScenes.HIDEABLE_SEPARATOR);
        mTokenStyleMapping.put(StaticColorDefine.CB_1, CssConst.CssScenes.THEME);
        mTokenStyleMapping.put(StaticColorDefine.CY_3, CssConst.CssScenes.SCORE);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_ELEVATED_PRIMARY_BACKGROUND, CssConst.CssScenes.ELEVATED_PRIMARY);
        mTokenStyleMapping.put(DynamicColorDefine.YKN_ELEVATED_SECONDARY_BACKGROUND, CssConst.CssScenes.ELEVATED_SECONDARY);
        mTokenStyleMapping.put("ykn_primary_info", CssConst.CssScenes.TITLE);
        mTokenStyleMapping.put("ykn_secondary_info", CssConst.CssScenes.CARD_HEADER_KEYWORD);
        mTokenStyleMapping.put("ykn_tertiary_info", CssConst.CssScenes.SUB_TITLE);
        mTokenStyleMapping.put("ykn_quaternary_info", CssConst.CssScenes.SUB_TITLE);
        mTokenStyleMapping.put("ykn_primary_background", CssConst.CssScenes.VIEW);
        mTokenStyleMapping.put("ykn_secondary_background", CssConst.CssScenes.CARD_FOOTER);
        mTokenStyleMapping.put("ykn_tertiary_background", CssConst.CssScenes.CARD_FOOTER);
        mTokenStyleMapping.put("ykn_primary_fill_color", CssConst.CssScenes.IMG);
        mTokenStyleMapping.put("ykn_secondary_fill_color", CssConst.CssScenes.IMG);
        mTokenStyleMapping.put("ykn_tertiary_fill_color", CssConst.CssScenes.IMG);
        mTokenStyleMapping.put("ykn_hide_able_separator", CssConst.CssScenes.HIDEABLE_SEPARATOR);
        mTokenStyleMapping.put("ykn_cb_1", CssConst.CssScenes.THEME);
        mTokenStyleMapping.put("ykn_cy_3", CssConst.CssScenes.SCORE);
        mTokenStyleMapping.put("ykn_elevated_primary_background", CssConst.CssScenes.ELEVATED_PRIMARY);
        mTokenStyleMapping.put("ykn_elevated_secondary_background", CssConst.CssScenes.ELEVATED_SECONDARY);
        int[][] iArr = states;
        int[] iArr2 = new int[1];
        iArr2[0] = 16842913;
        iArr[0] = iArr2;
        iArr[1] = new int[0];
    }

    public StyleVisitor(STYLE style) {
        super(style);
        CssBinder<STYLE> cssBinder = CssCache.getCssBinder(style);
        this.cssBinder = cssBinder;
        if (cssBinder == null) {
            this.cssBinder = new CssBinder<>("", new ConcurrentHashMap(), 0L);
        }
    }

    private boolean isBgColorToken(String str) {
        return str != null && (str.toLowerCase().contains("background") || str.toLowerCase().contains("fill"));
    }

    private boolean isInArray(String str, String... strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str, str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String tokenToScene(String str) {
        return mTokenStyleMapping.containsKey(str) ? mTokenStyleMapping.get(str) : str;
    }

    public void bindSelectedStyle(TextView textView, String str, @ColorRes int i) {
        ColorStateList colorStateList = ContextCompat.getColorStateList(textView.getContext(), i);
        if (colorStateList == null) {
            colorStateList = textView.getTextColors();
        }
        if (colorStateList != null) {
            int colorForState = colorStateList.getColorForState(states[0], 0);
            int colorForState2 = colorStateList.getColorForState(states[1], 0);
            Css findStyle = findStyle(str);
            if (findStyle != null) {
                colorForState = ColorUtil.parseColorSafely(findStyle.color);
            }
            if (colorForState == 0 || colorForState2 == 0) {
                return;
            }
            textView.setTextColor(new ColorStateList(states, new int[]{colorForState, colorForState2}));
        }
    }

    public void bindStatusStyle(TextView textView, String str, String str2, @ColorRes int i) {
        ColorStateList colorStateList = ContextCompat.getColorStateList(textView.getContext(), i);
        if (colorStateList == null) {
            colorStateList = textView.getTextColors();
        }
        if (colorStateList != null) {
            int colorForState = colorStateList.getColorForState(states[0], 0);
            int colorForState2 = colorStateList.getColorForState(states[1], 0);
            Css findStyle = findStyle(str2);
            if (findStyle != null) {
                colorForState = ColorUtil.parseColorSafely(findStyle.color);
            }
            Css findStyle2 = findStyle(str);
            if (findStyle2 != null) {
                colorForState2 = ColorUtil.parseColorSafely(findStyle2.color);
            }
            if (colorForState == 0 || colorForState2 == 0) {
                return;
            }
            textView.setTextColor(new ColorStateList(states, new int[]{colorForState, colorForState2}));
        }
    }

    public void bindStyle(View view, String str) {
        if (hasStyleStringValue(str)) {
            CssSetter.setColor(view, str, (String) this.styleMap.get(str), new String[0]);
            return;
        }
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.bindCss(view, tokenToScene(str));
        }
    }

    public void bindStyleAlpha(View view, String str, String str2, @IntRange(from = 0, to = 100) int i) {
        if (hasStyleStringValue(str)) {
            CssSetter.setColorAlpha(view, str, (String) this.styleMap.get(str), i, str2);
            return;
        }
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.bindCssToField(view, tokenToScene(str), str2, String.valueOf(i));
        }
    }

    public void bindStyleAlphaBgColor(View view, String str, @IntRange(from = 0, to = 100) int i) {
        bindStyleAlpha(view, str, "backgroundColor", i);
    }

    public void bindStyleAlphaColor(View view, String str, @IntRange(from = 0, to = 100) int i) {
        bindStyleAlpha(view, str, "color", i);
    }

    public void bindStyleBgColor(View view, String str) {
        bindStyle(view, str, "backgroundColor");
    }

    public void bindStyleColor(View view, String str) {
        bindStyle(view, str, "color");
    }

    public void bindStyles(IMultiStyleSetter iMultiStyleSetter, String... strArr) {
        if (iMultiStyleSetter != null) {
            iMultiStyleSetter.bindStyles(this, strArr);
        }
    }

    public void bindUnSelectedStyle(TextView textView, String str, @ColorRes int i) {
        ColorStateList colorStateList = ContextCompat.getColorStateList(textView.getContext(), i);
        if (colorStateList == null) {
            colorStateList = textView.getTextColors();
        }
        if (colorStateList != null) {
            int colorForState = colorStateList.getColorForState(states[0], 0);
            int colorForState2 = colorStateList.getColorForState(states[1], 0);
            Css findStyle = findStyle(str);
            if (findStyle != null) {
                colorForState2 = ColorUtil.parseColorSafely(findStyle.color);
            }
            if (colorForState == 0 || colorForState2 == 0) {
                return;
            }
            textView.setTextColor(new ColorStateList(states, new int[]{colorForState, colorForState2}));
        }
    }

    public Css findStyle(String str) {
        if (str == null) {
            return null;
        }
        if (hasStyleStringValue(str)) {
            Css css = new Css();
            if (!str.toLowerCase().contains("bg") && !isBgColorToken(str)) {
                css.color = (String) this.styleMap.get(str);
            } else {
                css.backgroundColor = (String) this.styleMap.get(str);
            }
            return css;
        }
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            return cssBinder.findCss(tokenToScene(str));
        }
        return null;
    }

    public STYLE getContainerCurrentStyle() {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            return cssBinder.getContainerCurrentStyle();
        }
        return null;
    }

    @Nullable
    public IStyleManager<STYLE> getContainerStyleManager() {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            return cssBinder.getContainerStyleManager();
        }
        return null;
    }

    public CssBinder getCssBinder() {
        return this.cssBinder;
    }

    public Map<String, Css> getCssMap() {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            return cssBinder.getCssMap();
        }
        return new ConcurrentHashMap();
    }

    public int getStyleColor(String str) {
        return BaseStyleVisitor.getStyleColor(this.styleMap, str);
    }

    public int getStyleColorByToken(String str) {
        return ColorUtil.parseColorSafely(getStyleStringValueByToken(str), 0);
    }

    public int getStyleColorFromRes(Context context, String str, int i) {
        return BaseStyleVisitor.getStyleColorFromRes(context, this.styleMap, str, i);
    }

    public float getStyleFloatValue(String str) {
        return BaseStyleVisitor.getStyleFloatValue(this.styleMap, str);
    }

    public int getStyleIntValue(String str) {
        return BaseStyleVisitor.getStyleIntValue(this.styleMap, str);
    }

    public String getStyleLabel() {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            return cssBinder.getStyleLabel();
        }
        return null;
    }

    public String getStyleStringValue(String str) {
        return BaseStyleVisitor.getStyleStringValue(this.styleMap, str);
    }

    public String getStyleStringValueByToken(String str) {
        Css css;
        return (!hasStyleStringByToken(str) || (css = getCssMap().get(tokenToScene(str))) == null) ? "" : isBgColorToken(str) ? css.backgroundColor : css.color;
    }

    public String getStyleUriString(String str, String... strArr) {
        STYLE style = this.styleMap;
        if (style != null && style.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (String str2 : this.styleMap.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str) && !isInArray(str2, strArr) && this.styleMap.get(str2) != null && this.styleMap.get(str2) != "") {
                    jSONObject.put(str2, this.styleMap.get(str2));
                }
            }
            if (jSONObject.size() > 0) {
                return Uri.encode(jSONObject.toJSONString());
            }
        }
        return null;
    }

    public Long getUpdateTime() {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            return cssBinder.getUpdateTime();
        }
        return null;
    }

    public boolean hasNavBg() {
        return hasStyleValue("navBgColor") || hasStyleValue(IStyle.NAV_BG_URL_IMG) || hasStyleValue("home_nav_bg_l.png");
    }

    public boolean hasStyleStringByToken(String str) {
        return mTokenStyleMapping.containsKey(str) && BaseStyleVisitor.hasStyleTypedValue(getCssMap(), tokenToScene(str), Css.class);
    }

    public boolean hasStyleStringValue(String str) {
        return BaseStyleVisitor.hasStyleStringValue(this.styleMap, str);
    }

    public boolean hasStyleTypedValue(String str, Class cls) {
        return BaseStyleVisitor.hasStyleTypedValue(this.styleMap, str, cls);
    }

    public boolean hasStyleValue(String str) {
        return hasStyleStringValue(str) || hasStyleTypedValue(str, Integer.class) || hasStyleStringByToken(str) || BaseStyleVisitor.hasStyleTypedValue(getCssMap(), str, Css.class);
    }

    public boolean isLight() {
        return isLight(this.styleMap);
    }

    public boolean isMerged() {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        return cssBinder != null && cssBinder.isMerged();
    }

    public boolean isSkin() {
        return isSkin(this.styleMap);
    }

    public void putAllCssMap(Map<String, Css> map) {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.putAllCssMap(map);
        } else if (map == null || map.size() <= 0) {
        } else {
            this.cssBinder = new CssBinder<>("", map, 0L);
        }
    }

    public void putCssMap(Map<String, Css> map) {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.putCssMap(map);
        } else if (map == null || map.size() <= 0) {
        } else {
            this.cssBinder = new CssBinder<>("", map, 0L);
        }
    }

    public void putStyleVisitor(StyleVisitor styleVisitor) {
        if (styleVisitor != null) {
            putCssMap(styleVisitor.getCssMap());
            STYLE style = (STYLE) styleVisitor.getStyle();
            if (style == null || style.isEmpty()) {
                return;
            }
            STYLE style2 = this.styleMap;
            if (style2 == null) {
                this.styleMap = style;
            } else if (style2 != style) {
                for (String str : style.keySet()) {
                    if (!this.styleMap.containsKey(str)) {
                        this.styleMap.put(str, style.get(str));
                    }
                }
            }
        }
    }

    public void setContainer(IStyleContainer<STYLE> iStyleContainer) {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder == null || iStyleContainer == null) {
            return;
        }
        cssBinder.setContainer(iStyleContainer);
    }

    public void setContainerStyleManager(IStyleManager<STYLE> iStyleManager) {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.setContainerStyleManager(iStyleManager);
        }
    }

    public void setCssMap(Map<String, Css> map) {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.setCssMap(map);
        } else if (map == null || map.size() <= 0) {
        } else {
            this.cssBinder = new CssBinder<>("", map, 0L);
        }
    }

    public void setMerged(boolean z) {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.setMerged(z);
        }
    }

    public void setStyleLabel(String str) {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.setStyleLabel(str);
        }
    }

    public void setUpdateTime(Long l) {
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.setUpdateTime(l);
        }
    }

    public static boolean isLight(@Nullable Map map) {
        return TextUtils.equals("1", BaseStyleVisitor.getStyleStringValue(map, IStyle.IS_LIGHT_BACKGROUND));
    }

    public static boolean isSkin(@Nullable Map map) {
        return TextUtils.equals("skin", BaseStyleVisitor.getStyleStringValue(map, "type"));
    }

    public int getStyleColor(String str, String str2) {
        return BaseStyleVisitor.getStyleColor(this.styleMap, str, str2);
    }

    public int getStyleColor(String str, int i) {
        return BaseStyleVisitor.getStyleColor(this.styleMap, str, i);
    }

    public void bindStyle(IStyleView iStyleView, String str) {
        if (hasStyleStringValue(str)) {
            CssSetter.setColor(iStyleView, str, (String) this.styleMap.get(str), new String[0]);
            return;
        }
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.bindCss(iStyleView, tokenToScene(str));
        }
    }

    public void bindStyle(View view, String str, String str2) {
        if (hasStyleStringValue(str)) {
            CssSetter.setColor(view, str, (String) this.styleMap.get(str), str2);
            return;
        }
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.bindCssToField(view, tokenToScene(str), str2);
        }
    }

    public void bindStatusStyle(TextView textView, String str, String str2, @ColorRes int i, @DrawableRes int i2) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Css findStyle = findStyle(str2);
        Css findStyle2 = findStyle(str);
        if (findStyle == null || findStyle2 == null) {
            return;
        }
        int parseColorSafely = ColorUtil.parseColorSafely(findStyle.backgroundColor);
        int parseColorSafely2 = ColorUtil.parseColorSafely(findStyle2.backgroundColor);
        Drawable drawable = ContextCompat.getDrawable(textView.getContext(), i2);
        if ((drawable instanceof StateListDrawable) && (drawableContainerState = (DrawableContainer.DrawableContainerState) drawable.mutate().getConstantState()) != null && drawableContainerState.getChildCount() == 2) {
            Drawable[] children = drawableContainerState.getChildren();
            Drawable drawable2 = children[0];
            Drawable drawable3 = children[1];
            if (drawable2 != null) {
                drawable2.mutate().setColorFilter(parseColorSafely, PorterDuff.Mode.SRC_IN);
            }
            if (drawable3 != null) {
                drawable3.mutate().setColorFilter(parseColorSafely2, PorterDuff.Mode.SRC_IN);
            }
            if (drawable2 != null && drawable3 != null) {
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842913}, drawable2);
                stateListDrawable.addState(new int[0], drawable3);
                textView.setBackground(stateListDrawable);
            }
        }
        ColorStateList colorStateList = ContextCompat.getColorStateList(textView.getContext(), i);
        if (colorStateList == null) {
            colorStateList = textView.getTextColors();
        }
        int parseColorSafely3 = ColorUtil.parseColorSafely(findStyle.color);
        int parseColorSafely4 = ColorUtil.parseColorSafely(findStyle2.color);
        if (colorStateList != null) {
            if (parseColorSafely3 == 0) {
                parseColorSafely3 = colorStateList.getColorForState(states[0], 0);
            }
            if (parseColorSafely4 == 0) {
                parseColorSafely4 = colorStateList.getColorForState(states[1], 0);
            }
            if (parseColorSafely3 == 0 || parseColorSafely4 == 0) {
                return;
            }
            textView.setTextColor(new ColorStateList(states, new int[]{parseColorSafely3, parseColorSafely4}));
        }
    }

    public void bindStyle(View view, String str, String str2, String str3) {
        if (hasStyleStringValue(str)) {
            CssSetter.setColor(view, str, (String) this.styleMap.get(str), str2, str3);
            return;
        }
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.bindCssToField(view, tokenToScene(str), str2, str3);
        }
    }

    public void bindStyle(View view, String str, String str2, String str3, @IntRange(from = 0, to = 100) int i) {
        if (hasStyleStringValue(str)) {
            CssSetter.setColorAlpha(view, str, (String) this.styleMap.get(str), i, str2, str3);
            return;
        }
        CssBinder<STYLE> cssBinder = this.cssBinder;
        if (cssBinder != null) {
            cssBinder.bindCssToField(view, tokenToScene(str), str2, str3, String.valueOf(i));
        }
    }
}
