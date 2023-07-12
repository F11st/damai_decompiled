package tb;

import android.content.Context;
import com.alibaba.pictures.cornerstone.protocol.ICloudConfig;
import com.alibaba.pictures.cornerstone.protocol.IInitProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConfig;
import com.taobao.orange.OConstant;
import com.taobao.orange.OrangeConfig;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class dk implements IInitProxy<ICloudConfig> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
    public void afterInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-15563979")) {
            ipChange.ipc$dispatch("-15563979", new Object[]{this});
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
    public boolean init(@Nullable Context context, @Nullable hb<ICloudConfig> hbVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434084717")) {
            return ((Boolean) ipChange.ipc$dispatch("-434084717", new Object[]{this, context, hbVar})).booleanValue();
        }
        t6 t6Var = t6.INSTANCE;
        String versionName = t6Var.getVersionName();
        if (versionName == null) {
            versionName = "";
        }
        String appKey = t6Var.getAppKey();
        String str = appKey != null ? appKey : "";
        ab1 ab1Var = ab1.INSTANCE;
        ab1Var.d("CloudConfigProxyInit", "appVersion:" + versionName + ",appKey:" + str);
        OrangeConfig.getInstance().init(t6Var.getApplication(), new OConfig.Builder().setAppKey(str).setAppVersion(versionName).setEnv(t6Var.getEnv().getEnvMode()).setIndexUpdateMode(OConstant.UPDMODE.O_ALL.ordinal()).build());
        return true;
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IInitProxy
    public void preInit(@Nullable Context context, @Nullable hb<ICloudConfig> hbVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681396668")) {
            ipChange.ipc$dispatch("-1681396668", new Object[]{this, context, hbVar});
        }
    }
}
