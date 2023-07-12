package com.youku.live.dago.widgetlib.ailproom.view.flowview;

import android.content.res.ColorStateList;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TagStyle {
    private static transient /* synthetic */ IpChange $ipChange;
    int backgroundResId;
    int bottomMargin;
    int bottomPadding;
    int leftMargin;
    int leftPadding;
    int rightMargin;
    int rightPadding;
    int textColor;
    ColorStateList textColorState;
    int textSize;
    int topMargin;
    int topPadding;
    int width = -2;
    int height = -2;
    int gravity = 17;

    private TagStyle() {
    }

    public static TagStyle build() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "801636064") ? (TagStyle) ipChange.ipc$dispatch("801636064", new Object[0]) : new TagStyle();
    }

    public TagStyle backgroundResId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701573644")) {
            return (TagStyle) ipChange.ipc$dispatch("-701573644", new Object[]{this, Integer.valueOf(i)});
        }
        this.backgroundResId = i;
        return this;
    }

    public TagStyle gravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080330421")) {
            return (TagStyle) ipChange.ipc$dispatch("2080330421", new Object[]{this, Integer.valueOf(i)});
        }
        this.gravity = i;
        return this;
    }

    public TagStyle margin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334622027")) {
            return (TagStyle) ipChange.ipc$dispatch("-334622027", new Object[]{this, Integer.valueOf(i)});
        }
        this.leftMargin = i;
        this.topMargin = i;
        this.rightMargin = i;
        this.bottomMargin = i;
        return this;
    }

    public TagStyle padding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610751928")) {
            return (TagStyle) ipChange.ipc$dispatch("1610751928", new Object[]{this, Integer.valueOf(i)});
        }
        this.leftPadding = i;
        this.topPadding = i;
        this.rightPadding = i;
        this.bottomPadding = i;
        return this;
    }

    public TagStyle size(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1249678957")) {
            return (TagStyle) ipChange.ipc$dispatch("1249678957", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.width = i;
        this.height = i2;
        return this;
    }

    public TagStyle textColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672317085")) {
            return (TagStyle) ipChange.ipc$dispatch("1672317085", new Object[]{this, Integer.valueOf(i)});
        }
        this.textColor = i;
        return this;
    }

    public TagStyle textColorState(ColorStateList colorStateList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915874479")) {
            return (TagStyle) ipChange.ipc$dispatch("-1915874479", new Object[]{this, colorStateList});
        }
        this.textColorState = colorStateList;
        return this;
    }

    public TagStyle textSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572629461")) {
            return (TagStyle) ipChange.ipc$dispatch("1572629461", new Object[]{this, Integer.valueOf(i)});
        }
        this.textSize = i;
        return this;
    }

    public TagStyle margin(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204062656")) {
            return (TagStyle) ipChange.ipc$dispatch("-204062656", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.leftMargin = i;
        this.topMargin = i2;
        this.rightMargin = i3;
        this.bottomMargin = i4;
        return this;
    }

    public TagStyle padding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857261475")) {
            return (TagStyle) ipChange.ipc$dispatch("-1857261475", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.leftPadding = i;
        this.topPadding = i2;
        this.rightPadding = i3;
        this.bottomPadding = i4;
        return this;
    }
}
