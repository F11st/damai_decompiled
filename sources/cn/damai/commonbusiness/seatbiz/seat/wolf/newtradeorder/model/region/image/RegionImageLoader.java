package cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.data.RegionImageData;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.listener.OnRegionImageLoadListener;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.IRegionImage;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.IRegionImageCallback;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.JPGRegionImage;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.SVGNRegionImage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.cb2;
import tb.j52;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionImageLoader implements IRegionImageCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile RegionImageLoader mInstance;
    private boolean isSVGRegion;
    private boolean isOSSRegionImageEnable = true;
    private final Map<String, List<WeakReference<SVGNRegionImage>>> mRequestMap = new HashMap();
    private Map<String, WeakReference<RegionImageData>> mRegionImageResultList = new HashMap();
    private Map<String, List<OnRegionImageLoadListener>> mRegionImageListenerList = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class SVGUrl {
        public final j52 assist;
        public final boolean isRainBowUrl;
        public final String url;

        public SVGUrl(String str, j52 j52Var, boolean z) {
            this.url = str;
            this.assist = j52Var;
            this.isRainBowUrl = z;
        }
    }

    private RegionImageLoader() {
    }

    private void addImageLoadListener(SVGUrl sVGUrl, OnRegionImageLoadListener onRegionImageLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018047682")) {
            ipChange.ipc$dispatch("1018047682", new Object[]{this, sVGUrl, onRegionImageLoadListener});
            return;
        }
        String str = sVGUrl.url;
        RegionImageData regionImageData = this.mRegionImageResultList.get(str) != null ? this.mRegionImageResultList.get(str).get() : null;
        if (regionImageData != null && regionImageData.getRegionImageStatus() != RegionImageData.RegionImageStatus.INIT && regionImageData.getRegionImageStatus() == RegionImageData.RegionImageStatus.SUCCESS) {
            onRegionImageLoadListener.onLoadRegionImageSuccess(regionImageData);
            return;
        }
        if (this.mRegionImageListenerList.get(str) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(onRegionImageLoadListener);
            this.mRegionImageListenerList.put(str, arrayList);
        } else {
            List<OnRegionImageLoadListener> list = this.mRegionImageListenerList.get(str);
            if (!list.contains(onRegionImageLoadListener)) {
                list.add(onRegionImageLoadListener);
            }
        }
        requestRegionImage(sVGUrl);
    }

    private void addSvgRequest(String str, SVGNRegionImage sVGNRegionImage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827072473")) {
            ipChange.ipc$dispatch("827072473", new Object[]{this, str, sVGNRegionImage});
            return;
        }
        List<WeakReference<SVGNRegionImage>> list = this.mRequestMap.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.mRequestMap.put(str, list);
        }
        list.add(new WeakReference<>(sVGNRegionImage));
    }

    @Nullable
    private String[] buildRegionImageUrl(RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883826284")) {
            return (String[]) ipChange.ipc$dispatch("1883826284", new Object[]{this, regionData});
        }
        if (regionData == null || regionData.ri == null) {
            return null;
        }
        boolean isSVGRegion = isSVGRegion(regionData);
        this.isSVGRegion = isSVGRegion;
        if (isSVGRegion) {
            RegionInfo regionInfo = regionData.ri;
            if (regionInfo.rainbowSupportII) {
                String unEnableHttpsValidation = unEnableHttpsValidation(regionInfo.seatSvgImg);
                regionInfo.seatSvgImg = unEnableHttpsValidation;
                RegionInfo regionInfo2 = regionData.ri;
                String unEnableHttpsValidation2 = unEnableHttpsValidation(regionInfo2.rainbowSvgImg);
                regionInfo2.rainbowSvgImg = unEnableHttpsValidation2;
                return new String[]{unEnableHttpsValidation, unEnableHttpsValidation2};
            }
            String unEnableHttpsValidation3 = unEnableHttpsValidation(regionInfo.seatSvgImg);
            regionInfo.seatSvgImg = unEnableHttpsValidation3;
            return new String[]{unEnableHttpsValidation3};
        }
        String[] strArr = new String[1];
        if (isOSSRegionImageEnable()) {
            strArr[0] = regionData.ri.seatOssImg;
            return strArr;
        }
        strArr[0] = regionData.ri.seatImg;
        return strArr;
    }

    private SVGUrl[] buildRegionImageUrl2(RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898394409")) {
            return (SVGUrl[]) ipChange.ipc$dispatch("1898394409", new Object[]{this, regionData});
        }
        if (regionData == null || regionData.ri == null) {
            return null;
        }
        j52 makeDegradeAssist = regionData.makeDegradeAssist();
        boolean isSVGRegion = isSVGRegion(regionData);
        this.isSVGRegion = isSVGRegion;
        if (isSVGRegion) {
            RegionInfo regionInfo = regionData.ri;
            String unEnableHttpsValidation = unEnableHttpsValidation(regionInfo.seatSvgImg);
            regionInfo.seatSvgImg = unEnableHttpsValidation;
            RegionInfo regionInfo2 = regionData.ri;
            if (regionInfo2.rainbowSupportII) {
                String unEnableHttpsValidation2 = unEnableHttpsValidation(regionInfo2.rainbowSvgImg);
                regionInfo2.rainbowSvgImg = unEnableHttpsValidation2;
                return new SVGUrl[]{new SVGUrl(unEnableHttpsValidation, makeDegradeAssist, false), new SVGUrl(unEnableHttpsValidation2, null, true)};
            }
            return new SVGUrl[]{new SVGUrl(unEnableHttpsValidation, makeDegradeAssist, false)};
        }
        SVGUrl[] sVGUrlArr = new SVGUrl[1];
        if (isOSSRegionImageEnable()) {
            sVGUrlArr[0] = new SVGUrl(regionData.ri.seatOssImg, null, false);
            return sVGUrlArr;
        }
        sVGUrlArr[0] = new SVGUrl(regionData.ri.seatImg, null, false);
        return sVGUrlArr;
    }

    public static RegionImageLoader getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043178373")) {
            return (RegionImageLoader) ipChange.ipc$dispatch("-2043178373", new Object[0]);
        }
        if (mInstance == null) {
            synchronized (RegionImageLoader.class) {
                if (mInstance == null) {
                    mInstance = new RegionImageLoader();
                }
            }
        }
        return mInstance;
    }

    private void requestRegionImage(SVGUrl sVGUrl) {
        IRegionImage iRegionImage;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813162475")) {
            ipChange.ipc$dispatch("-813162475", new Object[]{this, sVGUrl});
            return;
        }
        if (this.isSVGRegion) {
            SVGNRegionImage sVGNRegionImage = new SVGNRegionImage(this, sVGUrl.assist, sVGUrl.isRainBowUrl);
            addSvgRequest(sVGUrl.url, sVGNRegionImage);
            iRegionImage = sVGNRegionImage;
        } else {
            iRegionImage = new JPGRegionImage(this, this);
        }
        iRegionImage.loadRegionImage(sVGUrl.url);
    }

    private String unEnableHttpsValidation(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "361117148") ? (String) ipChange.ipc$dispatch("361117148", new Object[]{this, str}) : (!TextUtils.isEmpty(str) && AppConfig.g() == AppConfig.EnvMode.test && str.startsWith("https://sseat.damai.test")) ? str.replace("https://sseat.damai.test", "https://sseat.damai.test") : str;
    }

    public void addOnRegionImageLoadListener(RegionData regionData, OnRegionImageLoadListener onRegionImageLoadListener) {
        String[] buildRegionImageUrl;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2072054971")) {
            ipChange.ipc$dispatch("2072054971", new Object[]{this, regionData, onRegionImageLoadListener});
        } else if (regionData != null && onRegionImageLoadListener != null && (buildRegionImageUrl = buildRegionImageUrl(regionData)) != null) {
            for (String str : buildRegionImageUrl) {
                if (this.mRegionImageListenerList.get(str) == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(onRegionImageLoadListener);
                    this.mRegionImageListenerList.put(str, arrayList);
                } else {
                    List<OnRegionImageLoadListener> list = this.mRegionImageListenerList.get(str);
                    if (!list.contains(onRegionImageLoadListener)) {
                        list.add(onRegionImageLoadListener);
                    }
                }
            }
        }
    }

    public void clearRegionImageRequest(RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86499006")) {
            ipChange.ipc$dispatch("86499006", new Object[]{this, regionData});
            return;
        }
        String[] buildRegionImageUrl = buildRegionImageUrl(regionData);
        if (buildRegionImageUrl != null) {
            for (String str : buildRegionImageUrl) {
                if (!TextUtils.isEmpty(str)) {
                    List<WeakReference<SVGNRegionImage>> list = this.mRequestMap.get(str);
                    if (!cb2.d(list)) {
                        for (WeakReference<SVGNRegionImage> weakReference : list) {
                            SVGNRegionImage sVGNRegionImage = weakReference.get();
                            if (sVGNRegionImage != null) {
                                sVGNRegionImage.cancel();
                            }
                        }
                    }
                    this.mRequestMap.remove(str);
                }
            }
        }
    }

    public void fetchRegionImage(RegionData regionData, OnRegionImageLoadListener onRegionImageLoadListener) {
        SVGUrl[] buildRegionImageUrl2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2086115655")) {
            ipChange.ipc$dispatch("2086115655", new Object[]{this, regionData, onRegionImageLoadListener});
        } else if (regionData != null && onRegionImageLoadListener != null && (buildRegionImageUrl2 = buildRegionImageUrl2(regionData)) != null) {
            for (SVGUrl sVGUrl : buildRegionImageUrl2) {
                addImageLoadListener(sVGUrl, onRegionImageLoadListener);
            }
        }
    }

    public boolean isOSSRegionImageEnable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2070140057") ? ((Boolean) ipChange.ipc$dispatch("-2070140057", new Object[]{this})).booleanValue() : this.isOSSRegionImageEnable;
    }

    public boolean isSVGRegion(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "57188009")) {
            return ((Boolean) ipChange.ipc$dispatch("57188009", new Object[]{this, regionData})).booleanValue();
        }
        if (regionData != null && (regionInfo = regionData.ri) != null && regionInfo.isZWB2b2c) {
            if (TextUtils.isEmpty(regionInfo.seatSvgImg)) {
                RegionInfo regionInfo2 = regionData.ri;
                if (!regionInfo2.rainbowSupportII || TextUtils.isEmpty(regionInfo2.rainbowSvgImg)) {
                }
            }
            return true;
        }
        return false;
    }

    public void loadRegionImage(RegionData regionData) {
        SVGUrl[] buildRegionImageUrl2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599631154")) {
            ipChange.ipc$dispatch("1599631154", new Object[]{this, regionData});
        } else if (regionData != null && regionData.ri != null && (buildRegionImageUrl2 = buildRegionImageUrl2(regionData)) != null) {
            for (SVGUrl sVGUrl : buildRegionImageUrl2) {
                String str = sVGUrl.url;
                RegionImageData regionImageData = this.mRegionImageResultList.get(str) != null ? this.mRegionImageResultList.get(str).get() : null;
                if (regionImageData != null && regionImageData.getRegionImageStatus() == RegionImageData.RegionImageStatus.SUCCESS) {
                    onLoadRegionImageSuccess(regionImageData);
                } else {
                    requestRegionImage(sVGUrl);
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.IRegionImageCallback
    public void onLoadRegionImageFailed(RegionImageData regionImageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1690865269")) {
            ipChange.ipc$dispatch("-1690865269", new Object[]{this, regionImageData});
            return;
        }
        this.mRegionImageResultList.put(regionImageData.getRegionImageUrl(), new WeakReference<>(regionImageData));
        List<OnRegionImageLoadListener> list = this.mRegionImageListenerList.get(regionImageData.getRegionImageUrl());
        if (list != null) {
            for (OnRegionImageLoadListener onRegionImageLoadListener : list) {
                if (onRegionImageLoadListener != null) {
                    onRegionImageLoadListener.onLoadRegionImageFailed(regionImageData);
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.loader.IRegionImageCallback
    public void onLoadRegionImageSuccess(RegionImageData regionImageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-712212857")) {
            ipChange.ipc$dispatch("-712212857", new Object[]{this, regionImageData});
        } else if (regionImageData != null) {
            this.mRegionImageResultList.put(regionImageData.getRegionImageUrl(), new WeakReference<>(regionImageData));
            List<OnRegionImageLoadListener> list = this.mRegionImageListenerList.get(regionImageData.getRegionImageUrl());
            if (list != null) {
                for (OnRegionImageLoadListener onRegionImageLoadListener : list) {
                    if (onRegionImageLoadListener != null) {
                        onRegionImageLoadListener.onLoadRegionImageSuccess(regionImageData);
                    }
                }
            }
        }
    }

    public void removeListener(RegionData regionData, OnRegionImageLoadListener onRegionImageLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-107287566")) {
            ipChange.ipc$dispatch("-107287566", new Object[]{this, regionData, onRegionImageLoadListener});
            return;
        }
        String[] buildRegionImageUrl = buildRegionImageUrl(regionData);
        if (buildRegionImageUrl == null) {
            return;
        }
        for (String str : buildRegionImageUrl) {
            removeListener(str, onRegionImageLoadListener);
        }
    }

    public RegionImageLoader setOSSRegionImageEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45904285")) {
            return (RegionImageLoader) ipChange.ipc$dispatch("-45904285", new Object[]{this, Boolean.valueOf(z)});
        }
        this.isOSSRegionImageEnable = z;
        return this;
    }

    private void removeListener(String str, OnRegionImageLoadListener onRegionImageLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971881543")) {
            ipChange.ipc$dispatch("-1971881543", new Object[]{this, str, onRegionImageLoadListener});
        } else if (this.mRegionImageListenerList.get(str) != null) {
            this.mRegionImageListenerList.get(str).remove(onRegionImageLoadListener);
        }
    }
}
