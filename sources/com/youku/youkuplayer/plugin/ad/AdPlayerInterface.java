package com.youku.youkuplayer.plugin.ad;

import android.content.Context;
import com.alimm.xadsdk.business.playerad.interfaces.IAdPlayerInterface;
import com.youku.playerservice.axp.axpinterface.IPlayerService;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AdPlayerInterface implements IAdPlayerInterface {
    private AdPlugin mAdPlugin;
    private Context mContext;
    private IPlayerService mPlayerService;

    public AdPlayerInterface(Context context, IPlayerService iPlayerService, AdPlugin adPlugin) {
        this.mContext = context;
        this.mPlayerService = iPlayerService;
        this.mAdPlugin = adPlugin;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdPlayerInterface
    public int getCurrentPosition() {
        return (int) this.mPlayerService.getCurrentPosition();
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdPlayerInterface
    public boolean isFullscreen() {
        return false;
    }

    @Override // com.alimm.xadsdk.business.playerad.interfaces.IAdPlayerInterface
    public boolean isMuted() {
        return this.mPlayerService.isMuted();
    }
}
