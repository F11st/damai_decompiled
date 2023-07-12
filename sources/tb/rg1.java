package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.compat.mtop.MtopCertificateException;
import com.taobao.phenix.compat.mtop.MtopConnectTimeoutException;
import com.taobao.phenix.compat.mtop.MtopIndifferentException;
import com.taobao.phenix.compat.mtop.MtopInvalidHostException;
import com.taobao.phenix.compat.mtop.MtopInvalidUrlException;
import com.taobao.phenix.compat.mtop.MtopReadTimeoutException;
import com.taobao.phenix.compat.stat.NetworkAnalyzer;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class rg1 implements NetworkAnalyzer {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isCertificateException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1392185522") ? ((Boolean) ipChange.ipc$dispatch("1392185522", new Object[]{this, th})).booleanValue() : th instanceof MtopCertificateException;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isConnectTimeoutException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1734236090") ? ((Boolean) ipChange.ipc$dispatch("-1734236090", new Object[]{this, th})).booleanValue() : th instanceof MtopConnectTimeoutException;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isIndifferentException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "442346805") ? ((Boolean) ipChange.ipc$dispatch("442346805", new Object[]{this, th})).booleanValue() : th instanceof MtopIndifferentException;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isInvalidHostException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1844887798") ? ((Boolean) ipChange.ipc$dispatch("-1844887798", new Object[]{this, th})).booleanValue() : th instanceof MtopInvalidHostException;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isInvalidUrlException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "236919429") ? ((Boolean) ipChange.ipc$dispatch("236919429", new Object[]{this, th})).booleanValue() : th instanceof MtopInvalidUrlException;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isNoNetworkException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "728248668") ? ((Boolean) ipChange.ipc$dispatch("728248668", new Object[]{this, th})).booleanValue() : (th instanceof MtopIndifferentException) && ((MtopIndifferentException) th).getExtraCode() == -200;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    public boolean isReadTimeoutException(@Nullable Throwable th) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1335061026") ? ((Boolean) ipChange.ipc$dispatch("-1335061026", new Object[]{this, th})).booleanValue() : th instanceof MtopReadTimeoutException;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfCdnIpPort() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1008795274") ? (String) ipChange.ipc$dispatch("-1008795274", new Object[]{this}) : qh1.MTOP_EXTRA_CDN_IP_PORT;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfConnectType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-729945883") ? (String) ipChange.ipc$dispatch("-729945883", new Object[]{this}) : qh1.MTOP_EXTRA_CONNECT_TYPE;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfFirstData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1987647131") ? (String) ipChange.ipc$dispatch("1987647131", new Object[]{this}) : qh1.MTOP_EXTRA_FIRST_DATA;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfHitCdnCache() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2094338135") ? (String) ipChange.ipc$dispatch("-2094338135", new Object[]{this}) : qh1.MTOP_EXTRA_HIT_CDN_CACHE;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfResponseCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1275420035") ? (String) ipChange.ipc$dispatch("1275420035", new Object[]{this}) : qh1.MTOP_EXTRA_RESPONSE_CODE;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfSendBefore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "418935004") ? (String) ipChange.ipc$dispatch("418935004", new Object[]{this}) : qh1.MTOP_EXTRA_SEND_BEFORE;
    }

    @Override // com.taobao.phenix.compat.stat.NetworkAnalyzer
    @Nullable
    public String keyOfServerRt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1358772250") ? (String) ipChange.ipc$dispatch("1358772250", new Object[]{this}) : qh1.MTOP_EXTRA_SERVER_RT;
    }
}
