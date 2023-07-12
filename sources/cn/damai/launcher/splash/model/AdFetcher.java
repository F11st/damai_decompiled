package cn.damai.launcher.splash.model;

import androidx.annotation.NonNull;
import cn.damai.launcher.splash.api.SplashResponse;
import cn.damai.launcher.splash.model.listener.OnAdFetchListener;
import cn.damai.launcher.splash.model.request.TimeSensitiveRequest;
import cn.damai.launcher.splash.model.request.TsAdDownloadRequest;
import cn.damai.launcher.splash.model.request.TsAdMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AdFetcher implements OnAdFetchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnAdFetchListener mListener;

    public AdFetcher(OnAdFetchListener onAdFetchListener) {
        this.mListener = onAdFetchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadImg(final SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027464352")) {
            ipChange.ipc$dispatch("2027464352", new Object[]{this, splashResponse});
        } else {
            new TsAdDownloadRequest(2000, splashResponse.getPic()).request(new TimeSensitiveRequest.OnResultListener<File>() { // from class: cn.damai.launcher.splash.model.AdFetcher.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest.OnResultListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1121734628")) {
                        ipChange2.ipc$dispatch("1121734628", new Object[]{this, str, str2});
                        return;
                    }
                    AdLoader.log("img download onFail ");
                    AdFetcher.this.dispatchAdFetchPhaseFail(3, str, str2);
                }

                @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest.OnResultListener
                public void onTimeOutPreset() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1388826844")) {
                        ipChange2.ipc$dispatch("1388826844", new Object[]{this});
                        return;
                    }
                    AdLoader.log("img download onTimeOutPreset ");
                    AdFetcher.this.dispatchAdFetchPhaseFail(5, "-1", AdConstant.MSG_AD_IMG_DOWNLOAD_TIME_OUT_PRESET);
                }

                @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest.OnResultListener
                public void onSuccess(boolean z, File file) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "163662194")) {
                        ipChange2.ipc$dispatch("163662194", new Object[]{this, Boolean.valueOf(z), file});
                        return;
                    }
                    AdLoader.log("img download success " + file.getAbsolutePath());
                    if (file.exists() && file.isFile()) {
                        AdFetcher.this.dispatchAdFetchSuccess(file, splashResponse);
                    } else {
                        AdFetcher.this.dispatchAdFetchPhaseFail(3, "-1", AdConstant.MSG_AD_IMG_FILE_UN_VALID);
                    }
                }
            });
        }
    }

    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchPhaseFail(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167148084")) {
            ipChange.ipc$dispatch("167148084", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        OnAdFetchListener onAdFetchListener = this.mListener;
        if (onAdFetchListener != null) {
            onAdFetchListener.dispatchAdFetchPhaseFail(i, str, str2);
        }
    }

    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchSuccess(@NonNull File file, @NonNull SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1576324000")) {
            ipChange.ipc$dispatch("1576324000", new Object[]{this, file, splashResponse});
            return;
        }
        OnAdFetchListener onAdFetchListener = this.mListener;
        if (onAdFetchListener != null) {
            onAdFetchListener.dispatchAdFetchSuccess(file, splashResponse);
        }
    }

    public void doAdFetch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472601183")) {
            ipChange.ipc$dispatch("472601183", new Object[]{this});
        } else {
            new TsAdMtopRequest(1000).request(new TimeSensitiveRequest.OnResultListener<SplashResponse>() { // from class: cn.damai.launcher.splash.model.AdFetcher.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest.OnResultListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1129493987")) {
                        ipChange2.ipc$dispatch("1129493987", new Object[]{this, str, str2});
                    } else {
                        AdFetcher.this.dispatchAdFetchPhaseFail(2, str, str2);
                    }
                }

                @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest.OnResultListener
                public void onTimeOutPreset() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-868084163")) {
                        ipChange2.ipc$dispatch("-868084163", new Object[]{this});
                    } else {
                        AdFetcher.this.dispatchAdFetchPhaseFail(6, "-1", AdConstant.MSG_AD_MTOP_TIME_OUT_PRESET);
                    }
                }

                @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest.OnResultListener
                public void onSuccess(boolean z, SplashResponse splashResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "438368086")) {
                        ipChange2.ipc$dispatch("438368086", new Object[]{this, Boolean.valueOf(z), splashResponse});
                    } else if (splashResponse != null && splashResponse.isPicUrlValid()) {
                        AdFetcher.this.downloadImg(splashResponse);
                    } else {
                        AdFetcher.this.dispatchAdFetchPhaseFail(1, "-1", "data_none_config");
                    }
                }
            });
        }
    }
}
