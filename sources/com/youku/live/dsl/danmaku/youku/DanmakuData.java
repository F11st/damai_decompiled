package com.youku.live.dsl.danmaku.youku;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.SpannableString;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.Arch;
import com.youku.live.arch.utils.ContextUtils;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DanmakuData implements IDanmakuData {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_BORDER_COLOR = "borderColor";
    private static final String KEY_BORDER_CORNER_SIZE = "borderCornerSize";
    private static final String KEY_BORDER_SIZE = "borderSize";
    private static final String KEY_FONT_BORDER_COLOR = "fontBorderColor";
    private static final String KEY_FONT_BORDER_SIZE = "fontBorderSize";
    private static final String KEY_FONT_COLOR = "fontColor";
    private static final String KEY_FONT_COLOR_BOTTOM = "fontColorBottom";
    private static final String KEY_FONT_COLOR_TOP = "fontColorTop";
    private static final String KEY_FONT_SHADOW_COLOR = "fontShadowColor";
    private static final String KEY_FONT_SHADOW_OFFSET_X = "fontShadowOffsetX";
    private static final String KEY_FONT_SHADOW_OFFSET_Y = "fontShadowOffsetY";
    private static final String KEY_FONT_SHADOW_SIZE = "fontShadowSize";
    private static final String KEY_FONT_SIZE = "fontSize";
    private static final String KEY_IMMEDIATELY = "immediately";
    private static final String KEY_PADDING_BOTTOM = "paddingBottom";
    private static final String KEY_PADDING_LEFT = "paddingLeft";
    private static final String KEY_PADDING_RIGHT = "paddingRight";
    private static final String KEY_PADDING_TOP = "paddingTop";
    private static final String KEY_ROW = "row";
    private static final String KEY_TEXT = "text";
    private Map<String, Object> valueMap;

    public DanmakuData(Map map) {
        this.valueMap = map;
    }

    private boolean checkValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172109452")) {
            return ((Boolean) ipChange.ipc$dispatch("172109452", new Object[]{this, str})).booleanValue();
        }
        Map<String, Object> map = this.valueMap;
        if (map == null || map.size() == 0) {
            return false;
        }
        return this.valueMap.containsKey(str);
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getBorderColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1908927513")) {
            return ((Integer) ipChange.ipc$dispatch("1908927513", new Object[]{this})).intValue();
        }
        if (checkValue("borderColor")) {
            try {
                return Color.parseColor((String) this.valueMap.get("borderColor"));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getBorderCornerSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760253246")) {
            return ((Integer) ipChange.ipc$dispatch("1760253246", new Object[]{this})).intValue();
        }
        if (checkValue("borderCornerSize")) {
            try {
                return ContextUtils.dip2px(Arch.getApp(), Integer.valueOf(String.valueOf(this.valueMap.get("borderCornerSize"))).intValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public float getBorderSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "663331408")) {
            return ((Float) ipChange.ipc$dispatch("663331408", new Object[]{this})).floatValue();
        }
        if (checkValue("borderSize")) {
            try {
                return ContextUtils.dip2px(Arch.getApp(), (int) Double.parseDouble(String.valueOf(this.valueMap.get("borderSize"))));
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getFontBorderColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756680120")) {
            return ((Integer) ipChange.ipc$dispatch("-756680120", new Object[]{this})).intValue();
        }
        if (checkValue("fontBorderColor")) {
            try {
                return Color.parseColor((String) this.valueMap.get("fontBorderColor"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public float getFontBorderSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577344065")) {
            return ((Float) ipChange.ipc$dispatch("577344065", new Object[]{this})).floatValue();
        }
        if (checkValue("fontBorderSize")) {
            try {
                return ContextUtils.dip2px(Arch.getApp(), (int) Float.valueOf(String.valueOf(this.valueMap.get("fontBorderSize"))).floatValue());
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923400900")) {
            return ((Integer) ipChange.ipc$dispatch("-1923400900", new Object[]{this})).intValue();
        }
        if (checkValue("fontColor")) {
            try {
                return Color.parseColor((String) this.valueMap.get("fontColor"));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public int getFontShadowColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980667196")) {
            return ((Integer) ipChange.ipc$dispatch("980667196", new Object[]{this})).intValue();
        }
        if (checkValue("fontShadowColor")) {
            try {
                return Color.parseColor((String) this.valueMap.get("fontShadowColor"));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public double getFontShadowOffset(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409107005")) {
            return ((Double) ipChange.ipc$dispatch("-1409107005", new Object[]{this, str})).doubleValue();
        }
        if (checkValue(str)) {
            try {
                return Double.parseDouble(String.valueOf(this.valueMap.get(str)));
            } catch (Exception unused) {
            }
        }
        return 0.0d;
    }

    public double getFontShadowSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306275125")) {
            return ((Double) ipChange.ipc$dispatch("-1306275125", new Object[]{this})).doubleValue();
        }
        if (checkValue("fontShadowSize")) {
            try {
                return Double.parseDouble(String.valueOf(this.valueMap.get("fontShadowSize")));
            } catch (Exception unused) {
            }
        }
        return 0.0d;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getFontSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399954736")) {
            return ((Integer) ipChange.ipc$dispatch("-1399954736", new Object[]{this})).intValue();
        }
        if (checkValue("fontSize")) {
            try {
                return Integer.valueOf(String.valueOf(this.valueMap.get("fontSize"))).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 14;
            }
        }
        return 14;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getPaddingBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1905648396")) {
            return ((Integer) ipChange.ipc$dispatch("-1905648396", new Object[]{this})).intValue();
        }
        if (checkValue("paddingBottom")) {
            try {
                return ContextUtils.dip2px(Arch.getApp(), Integer.valueOf(String.valueOf(this.valueMap.get("paddingBottom"))).intValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getPaddingLeft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685503320")) {
            return ((Integer) ipChange.ipc$dispatch("685503320", new Object[]{this})).intValue();
        }
        if (checkValue("paddingLeft")) {
            try {
                return ContextUtils.dip2px(Arch.getApp(), Integer.parseInt(String.valueOf(this.valueMap.get("paddingLeft"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getPaddingRight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917550421")) {
            return ((Integer) ipChange.ipc$dispatch("917550421", new Object[]{this})).intValue();
        }
        if (checkValue("paddingRight")) {
            try {
                return ContextUtils.dip2px(Arch.getApp(), Integer.parseInt(String.valueOf(this.valueMap.get("paddingRight"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getPaddingTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368985020")) {
            return ((Integer) ipChange.ipc$dispatch("1368985020", new Object[]{this})).intValue();
        }
        if (checkValue("paddingTop")) {
            try {
                return ContextUtils.dip2px(Arch.getApp(), Integer.valueOf(String.valueOf(this.valueMap.get("paddingTop"))).intValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public int getRow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1266316790")) {
            return ((Integer) ipChange.ipc$dispatch("1266316790", new Object[]{this})).intValue();
        }
        if (checkValue("row")) {
            try {
                return ContextUtils.dip2px(Arch.getApp(), Integer.valueOf(String.valueOf(this.valueMap.get("row"))).intValue());
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public SpannableString getText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784984552")) {
            return (SpannableString) ipChange.ipc$dispatch("-784984552", new Object[]{this});
        }
        if (checkValue("text")) {
            return new SpannableString((String) this.valueMap.get("text"));
        }
        return null;
    }

    public boolean isFontColorGradient() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "399349549") ? ((Boolean) ipChange.ipc$dispatch("399349549", new Object[]{this})).booleanValue() : checkValue("fontColorTop") && checkValue("fontColorBottom");
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public boolean isShowImmediately() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869829616")) {
            return ((Boolean) ipChange.ipc$dispatch("1869829616", new Object[]{this})).booleanValue();
        }
        if (checkValue("immediately")) {
            return ((Boolean) this.valueMap.get("immediately")).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public void setFontColorGradient(Paint paint, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532050438")) {
            ipChange.ipc$dispatch("-1532050438", new Object[]{this, paint, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (isFontColorGradient()) {
            try {
                paint.setShader(new LinearGradient(i / 2, 0.0f, i / 2, i2, new int[]{Color.parseColor((String) this.valueMap.get("fontColorTop")), Color.parseColor((String) this.valueMap.get("fontColorBottom"))}, (float[]) null, Shader.TileMode.REPEAT));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            paint.setShader(null);
        }
    }

    @Override // com.youku.live.dsl.danmaku.youku.IDanmakuData
    public void setFontShadow(Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828867673")) {
            ipChange.ipc$dispatch("-828867673", new Object[]{this, paint});
        } else if (paint == null) {
        } else {
            double fontShadowSize = getFontShadowSize();
            if (fontShadowSize != 0.0d) {
                paint.setShadowLayer((float) fontShadowSize, (float) getFontShadowOffset("fontShadowOffsetX"), (float) getFontShadowOffset("fontShadowOffsetY"), getFontShadowColor());
            } else {
                paint.clearShadowLayer();
            }
        }
    }
}
