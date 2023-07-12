package com.taobao.update.apk;

import tb.el2;
import tb.pu2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApkUpdateContext extends el2 {
    public String apkPath;
    public boolean background;
    public boolean hasNotified;
    public boolean isDownloadError;
    public MainUpdateData mainUpdate;
    public NotifyPolicy notifyPolicy = NotifyPolicy.DEFAULT;
    public Boolean exceedUpdateTimes = Boolean.FALSE;
    public NotifySource updateAlertSource = NotifySource.UPDATE;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    enum NotifyPolicy {
        DEFAULT,
        SCENCE
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum NotifySource {
        UPDATE
    }

    public boolean isDefaultUpdate() {
        int i;
        if (2 == pu2.getNetworkType() || !(3 == (i = this.mainUpdate.remindStrategy) || 5 == i)) {
            return 2 == pu2.getNetworkType() && 8 == this.mainUpdate.remindStrategy;
        }
        return true;
    }

    public boolean isForceUpdate() {
        if (2 == this.mainUpdate.remindStrategy) {
            return true;
        }
        return 2 == pu2.getNetworkType() && 3 == this.mainUpdate.remindStrategy;
    }

    public boolean isSilentUpdate() {
        if (6 == this.mainUpdate.remindStrategy) {
            return true;
        }
        if (2 == pu2.getNetworkType()) {
            int i = this.mainUpdate.remindStrategy;
            return 4 == i || 5 == i;
        }
        return false;
    }

    public boolean skipUpdate() {
        if (7 == this.mainUpdate.remindStrategy) {
            return true;
        }
        if (2 != pu2.getNetworkType()) {
            int i = this.mainUpdate.remindStrategy;
            return 4 == i || 8 == i;
        }
        return false;
    }
}
