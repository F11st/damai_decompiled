package com.taobao.orange.accssupport;

import android.content.Intent;
import com.alibaba.fastjson.JSON;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.orange.ConfigCenter;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.model.NameSpaceDO;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeUtils;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OrangeAccsService extends TaoBaseService {
    private static final String TAG = "OrangeAccs";
    private static Set<NameSpaceDO> waitingNamesapces = new HashSet();

    public static void complete() {
        if (waitingNamesapces.isEmpty()) {
            return;
        }
        OLog.v(TAG, "complete", "accs waiting", Integer.valueOf(waitingNamesapces.size()));
        for (NameSpaceDO nameSpaceDO : waitingNamesapces) {
            ConfigCenter.getInstance().loadConfigLazy(nameSpaceDO);
        }
        waitingNamesapces.clear();
        OLog.v(TAG, "complete end", new Object[0]);
    }

    public static void handleUpdate(final byte[] bArr) {
        OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.accssupport.OrangeAccsService.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr2 = bArr;
                if (bArr2 != null && bArr2.length > 0) {
                    NameSpaceDO nameSpaceDO = (NameSpaceDO) JSON.parseObject(new String(bArr2), NameSpaceDO.class);
                    if (nameSpaceDO == null) {
                        OLog.e(OrangeAccsService.TAG, "handleUpdate fail as namespace null", new Object[0]);
                        return;
                    }
                    OLog.d(OrangeAccsService.TAG, "handleUpdate", "namespace", OrangeUtils.formatNamespaceDO(nameSpaceDO));
                    if (ConfigCenter.getInstance().mIsOrangeInit.get()) {
                        ConfigCenter.getInstance().loadConfigLazy(nameSpaceDO);
                    } else {
                        OLog.w(OrangeAccsService.TAG, "handleUpdate fail as not init completed", new Object[0]);
                        OrangeAccsService.waitingNamesapces.add(nameSpaceDO);
                    }
                    if (GlobalOrange.context != null) {
                        Intent intent = new Intent("com.taobao.orange.monitor.DATA");
                        intent.setPackage(GlobalOrange.context.getPackageName());
                        intent.putExtra("changeType", "grey");
                        intent.putExtra("namespace", nameSpaceDO.name);
                        intent.putExtra("version", nameSpaceDO.version);
                        GlobalOrange.context.sendBroadcast(intent);
                        OLog.e(OrangeAccsService.TAG, "sendBroadcast", "namespace", nameSpaceDO.name, "version", nameSpaceDO.version);
                        return;
                    }
                    return;
                }
                OLog.e(OrangeAccsService.TAG, "handleUpdate data is empty", new Object[0]);
            }
        });
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if ("orange".equals(str)) {
            OLog.i(TAG, "onData", Constants.KEY_DATA_ID, str3, "userId", str2);
            handleUpdate(bArr);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }
}
