package com.youku.usercenter.passport.remote;

import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ThemeBundle {
    private static final String THEME_BG_REMIND = "theme_bg_remind";
    private static final String THEME_BOTTOM_BG = "theme_bottom_bg";
    private static final String THEME_ICON_ALIPAY = "theme_icon_alipay";
    private static final String THEME_ICON_BACK = "theme_icon_back";
    private static final String THEME_ICON_CLEAR = "theme_icon_clear";
    private static final String THEME_ICON_CLOSE = "theme_icon_close";
    private static final String THEME_ICON_QQ = "theme_icon_QQ";
    private static final String THEME_ICON_TAOBAO = "theme_icon_taobao";
    private static final String THEME_ICON_WECHAT = "theme_icon_wechat";
    private static final String THEME_ICON_WEIBO = "theme_icon_weibo";
    private static final String THEME_ICON_YOUKU = "theme_icon_youku";
    private static final String THEME_LOGO = "theme_logo";
    private static final String THEME_MAIN_COLOR = "theme_main_color";
    private static final String THEME_NO_BOTTOM_BG = "theme_no_bottom_bg";
    private static final String THEME_PRIMARY_BTN_BG_COLOR = "theme_primary_btn_bg_color";
    private static final String THEME_PRIMARY_BTN_TEXT_COLOR = "theme_primary_btn_text_color";
    private static final String THEME_SECONDARY_BTN_BG_COLOR = "theme_secondary_btn_bg_color";
    private static final String THEME_SECONDARY_BTN_TEXT_COLOR = "theme_secondary_btn_text_color";
    private Bundle mBundle;

    public ThemeBundle() {
        this.mBundle = new Bundle();
    }

    public int getBgRemind(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_BG_REMIND, i);
    }

    public int getBottomBg(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_BOTTOM_BG, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle getBundle() {
        return this.mBundle;
    }

    public int getIconAlipay(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_ALIPAY, i);
    }

    public int getIconBack(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_BACK, i);
    }

    public int getIconClear(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_CLEAR, i);
    }

    public int getIconClose(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_CLOSE, i);
    }

    public int getIconQQ(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_QQ, i);
    }

    public int getIconTaobao(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_TAOBAO, i);
    }

    public int getIconWechat(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_WECHAT, i);
    }

    public int getIconWeibo(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_WEIBO, i);
    }

    public int getIconYouku(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_ICON_YOUKU, i);
    }

    public int getLogo(@DrawableRes int i) {
        return this.mBundle.getInt(THEME_LOGO, i);
    }

    public int getMainColor(@ColorInt int i) {
        return this.mBundle.getInt(THEME_MAIN_COLOR, i);
    }

    public int getPrimaryBtnBgColor(@ColorInt int i) {
        return this.mBundle.getInt(THEME_PRIMARY_BTN_BG_COLOR, i);
    }

    public int getPrimaryBtnTextColor(@ColorInt int i) {
        return this.mBundle.getInt(THEME_PRIMARY_BTN_TEXT_COLOR, i);
    }

    public int getSecondaryBtnBgColor(@ColorInt int i) {
        return this.mBundle.getInt(THEME_SECONDARY_BTN_BG_COLOR, i);
    }

    public int getSecondaryBtnTextColor(@ColorInt int i) {
        return this.mBundle.getInt(THEME_SECONDARY_BTN_TEXT_COLOR, i);
    }

    public boolean isNoBottomBg() {
        return this.mBundle.getBoolean(THEME_NO_BOTTOM_BG);
    }

    public void setBgRemind(@DrawableRes int i) {
        this.mBundle.putInt(THEME_BG_REMIND, i);
    }

    public void setBottomBg(@DrawableRes int i) {
        this.mBundle.putInt(THEME_BOTTOM_BG, i);
    }

    public void setIconAlipay(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_ALIPAY, i);
    }

    public void setIconBack(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_BACK, i);
    }

    public void setIconClear(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_CLEAR, i);
    }

    public void setIconClose(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_CLOSE, i);
    }

    public void setIconQQ(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_QQ, i);
    }

    public void setIconTaobao(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_TAOBAO, i);
    }

    public void setIconWechat(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_WECHAT, i);
    }

    public void setIconWeibo(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_WEIBO, i);
    }

    public void setIconYouku(@DrawableRes int i) {
        this.mBundle.putInt(THEME_ICON_YOUKU, i);
    }

    public void setLogo(@DrawableRes int i) {
        this.mBundle.putInt(THEME_LOGO, i);
    }

    public void setMainColor(@ColorInt int i) {
        this.mBundle.putInt(THEME_MAIN_COLOR, i);
    }

    public void setNoBottomBg(boolean z) {
        this.mBundle.putBoolean(THEME_NO_BOTTOM_BG, z);
    }

    public void setPrimaryBtnBgColor(@ColorInt int i) {
        this.mBundle.putInt(THEME_PRIMARY_BTN_BG_COLOR, i);
    }

    public void setPrimaryBtnTextColor(@ColorInt int i) {
        this.mBundle.putInt(THEME_PRIMARY_BTN_TEXT_COLOR, i);
    }

    public void setSecondaryBtnBgColor(@ColorInt int i) {
        this.mBundle.putInt(THEME_SECONDARY_BTN_BG_COLOR, i);
    }

    public void setSecondaryBtnTextColor(@ColorInt int i) {
        this.mBundle.putInt(THEME_SECONDARY_BTN_TEXT_COLOR, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThemeBundle(Bundle bundle) {
        if (bundle != null) {
            this.mBundle = bundle;
            return;
        }
        throw new IllegalArgumentException("aBundle cannot be null");
    }
}
