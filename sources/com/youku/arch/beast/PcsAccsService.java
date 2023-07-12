package com.youku.arch.beast;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.base.TaoBaseService;
import java.io.UnsupportedEncodingException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PcsAccsService extends TaoBaseService {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mLatestCmdId = null;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class PackedRawAccsData {
        public byte[] data;
        public TaoBaseService.ExtraInfo extraInfo;
        public String s;
        public String s1;
        public String s2;
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109740721")) {
            ipChange.ipc$dispatch("2109740721", new Object[]{this, str, Integer.valueOf(i), extraInfo});
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067523936")) {
            ipChange.ipc$dispatch("-2067523936", new Object[]{this, str, str2, str3, bArr, extraInfo});
        } else if (bArr != null) {
            try {
                String str4 = new String(bArr, "utf-8");
                Log.d("BeastLib", "data:" + str4);
                PackedRawAccsData packedRawAccsData = new PackedRawAccsData();
                packedRawAccsData.s = str;
                packedRawAccsData.s1 = str2;
                packedRawAccsData.s2 = str3;
                packedRawAccsData.data = bArr;
                packedRawAccsData.extraInfo = extraInfo;
                this.mLatestCmdId = PcsManager.parseAndUpdate(str4, packedRawAccsData, this.mLatestCmdId);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605670000")) {
            ipChange.ipc$dispatch("-1605670000", new Object[]{this, str, str2, Integer.valueOf(i), bArr, extraInfo});
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870362758")) {
            ipChange.ipc$dispatch("870362758", new Object[]{this, str, str2, Integer.valueOf(i), extraInfo});
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113871864")) {
            ipChange.ipc$dispatch("2113871864", new Object[]{this, str, Integer.valueOf(i), extraInfo});
        }
    }
}
