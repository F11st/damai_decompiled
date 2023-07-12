package com.youku.style.core;

import com.youku.style.StyleVisitor;
import com.youku.style.vo.AtmosphereStyle;
import com.youku.style.vo.SkinStyle;
import com.youku.style.vo.StyleValue;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StyleFactory<STYLE extends Map> {
    public static final String STYLE_TYPE = "type";
    public static final String TYPE_SKIN = "skin";
    private static volatile StyleFactory sInstance;

    private StyleFactory() {
    }

    private StyleValue determinateStyle(STYLE style) {
        if (StyleVisitor.isSkin(style)) {
            return new SkinStyle(style);
        }
        return new AtmosphereStyle(style);
    }

    public static StyleFactory getInstance() {
        if (sInstance == null) {
            synchronized (StyleFactory.class) {
                if (sInstance == null) {
                    sInstance = new StyleFactory();
                }
            }
        }
        return sInstance;
    }

    public StyleValue create(STYLE style) {
        return determinateStyle(style);
    }
}
