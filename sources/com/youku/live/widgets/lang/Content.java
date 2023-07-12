package com.youku.live.widgets.lang;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class Content {
    private static transient /* synthetic */ IpChange $ipChange;
    private byte[] mBinary;
    private String mContent;

    public Content(String str) {
        this.mContent = str;
    }

    public byte[] getBinary() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1187200370") ? (byte[]) ipChange.ipc$dispatch("-1187200370", new Object[]{this}) : this.mBinary;
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1209184417") ? (String) ipChange.ipc$dispatch("-1209184417", new Object[]{this}) : this.mContent;
    }

    public boolean isEmpty() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2022179417")) {
            return ((Boolean) ipChange.ipc$dispatch("-2022179417", new Object[]{this})).booleanValue();
        }
        if (TextUtils.isEmpty(this.mContent)) {
            byte[] bArr = this.mBinary;
            return bArr == null || bArr.length == 0;
        }
        return false;
    }

    public int length() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2037227857")) {
            return ((Integer) ipChange.ipc$dispatch("2037227857", new Object[]{this})).intValue();
        }
        String str = this.mContent;
        if (str != null) {
            return str.length();
        }
        byte[] bArr = this.mBinary;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public Content(byte[] bArr) {
        this.mBinary = bArr;
    }
}
