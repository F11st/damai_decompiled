package com.youku.live.dsl.pages;

import android.app.Application;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import com.youku.live.dago.liveplayback.DagoLivePlaybackLib;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDagoLivePlaybackManangerImp implements IDagoLivePlaybackManangerInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private static IDagoLivePlaybackManangerImp sInstance;

    public static IDagoLivePlaybackManangerInterface getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275650310")) {
            return (IDagoLivePlaybackManangerInterface) ipChange.ipc$dispatch("-275650310", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (IDagoLivePlaybackManangerImp.class) {
                if (sInstance == null) {
                    sInstance = new IDagoLivePlaybackManangerImp();
                }
            }
        }
        return sInstance;
    }

    @Override // com.youku.live.dsl.pages.IDagoLivePlaybackManangerInterface
    public String getCkeyInfoForRoomSwitchList(Context context, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1584196870") ? (String) ipChange.ipc$dispatch("1584196870", new Object[]{this, context, map}) : AXPParamsProvider.getMaldivesCKey(context);
    }

    @Override // com.youku.live.dsl.pages.IDagoLivePlaybackManangerInterface
    public void registerAll(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195605574")) {
            ipChange.ipc$dispatch("1195605574", new Object[]{this, application});
        } else {
            DagoLivePlaybackLib.registerAll(application);
        }
    }
}
