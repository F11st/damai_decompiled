package com.ut.mini.module.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class UTPlugin {
    private boolean mIsOldPlugin = true;
    private boolean mIsSyncMessage = true;
    private List<String> mWritableKeyList = null;
    private List<String> mUtparamCntList = null;

    public static boolean isEventIDInRange(int[] iArr, int i) {
        if (iArr != null) {
            if (iArr[0] == -1) {
                return true;
            }
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract int[] getAttentionEventIds();

    public String getPluginName() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSyncMessage() {
        return this.mIsSyncMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isWritableKey(String str) {
        if (this.mIsOldPlugin) {
            return true;
        }
        List<String> list = this.mWritableKeyList;
        if (list == null) {
            return false;
        }
        if (list.contains(jn1.MUL)) {
            return true;
        }
        return this.mWritableKeyList.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isWritableUtparamCnt(String str) {
        if (this.mIsOldPlugin) {
            return true;
        }
        List<String> list = this.mUtparamCntList;
        if (list == null) {
            return false;
        }
        if (list.contains(jn1.MUL)) {
            return true;
        }
        return this.mUtparamCntList.contains(str);
    }

    public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4) {
        return null;
    }

    public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4, Map<String, String> map) {
        return onEventDispatch(str, i, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUTPluginParam(boolean z, boolean z2, List<String> list, List<String> list2) {
        this.mIsOldPlugin = z;
        this.mIsSyncMessage = z2;
        if (list == null) {
            this.mWritableKeyList = null;
        } else {
            this.mWritableKeyList = new ArrayList(list);
        }
        if (list2 == null) {
            this.mUtparamCntList = null;
        } else {
            this.mUtparamCntList = new ArrayList(list2);
        }
    }
}
