package com.ali.user.mobile.common.api;

import com.ali.user.mobile.app.dataprovider.BooleanOrangeResult;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.ui.widget.WidgetExtension;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class LoginApprearanceExtensions extends WidgetExtension {
    protected Class mABHelper;
    protected Class mDialogHelper;
    protected Class mNavHelper;
    protected Class mPermissionHelper;
    protected Class mScaleHelper;
    protected Class mUccHelper;
    protected boolean needCountryModule = true;
    protected boolean needHelp = false;
    protected boolean needRegister = true;
    protected boolean needToolbar = true;
    protected boolean needDarkStatusBarMode = true;
    protected boolean needLoginToolbar = true;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface AsoLoginCallback {
        void onNeedSwitch(String str, DataCallback<Boolean> dataCallback);

        void onNeedequestPermission(DataCallback<Boolean> dataCallback);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class AsoLoginFlow {
        private static AsoLoginCallback mAsoLoginCallback;

        public static AsoLoginCallback getAsoLoginCallback() {
            return mAsoLoginCallback;
        }

        public static void setAsoLoginCallback(AsoLoginCallback asoLoginCallback) {
            mAsoLoginCallback = asoLoginCallback;
        }
    }

    public Class getABHelper() {
        return this.mABHelper;
    }

    public int getActivityEnterAnimation() {
        return 0;
    }

    public int getActivityExitAnimation() {
        return 0;
    }

    public Class getDialogHelper() {
        return this.mDialogHelper;
    }

    public Class getNavHelper() {
        return this.mNavHelper;
    }

    public Class getPermissionHelper() {
        return this.mPermissionHelper;
    }

    public Class getScaleHelper() {
        return this.mScaleHelper;
    }

    public Class getUccHelper() {
        return this.mUccHelper;
    }

    public boolean isNeedDarkStatusBarMode() {
        return this.needDarkStatusBarMode;
    }

    public boolean isNeedLoginToolbar() {
        return this.needLoginToolbar;
    }

    public boolean isNeedToolbar() {
        return this.needToolbar;
    }

    public boolean needCountryModule() {
        return this.needCountryModule;
    }

    public boolean needHelp() {
        BooleanOrangeResult needHelp = DataProviderFactory.getOrangeConfig().needHelp();
        return needHelp.orangeExist ? needHelp.value : this.needHelp;
    }

    public boolean needRegister() {
        BooleanOrangeResult needRegister = DataProviderFactory.getOrangeConfig().needRegister();
        return needRegister.orangeExist ? needRegister.value : this.needRegister;
    }

    public void setABHelper(Class cls) {
        this.mABHelper = cls;
    }

    public void setDialogHelper(Class cls) {
        this.mDialogHelper = cls;
    }

    public void setNavHelper(Class cls) {
        this.mNavHelper = cls;
    }

    public void setNeedCountryModule(boolean z) {
        this.needCountryModule = z;
    }

    public void setNeedDarkStatusBarMode(boolean z) {
        this.needDarkStatusBarMode = z;
    }

    public void setNeedHelp(boolean z) {
        this.needHelp = z;
    }

    public void setNeedLoginToolbar(boolean z) {
        this.needLoginToolbar = z;
    }

    public void setNeedRegister(boolean z) {
        this.needRegister = z;
    }

    public void setNeedToolbar(boolean z) {
        this.needToolbar = z;
    }

    public void setPermissionHelper(Class cls) {
        this.mPermissionHelper = cls;
    }

    public void setScaleHelper(Class cls) {
        this.mScaleHelper = cls;
    }

    public void setUccHelper(Class cls) {
        this.mUccHelper = cls;
    }
}
