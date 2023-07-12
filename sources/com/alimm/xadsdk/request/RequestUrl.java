package com.alimm.xadsdk.request;

import android.text.TextUtils;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.request.builder.BaseAdRequestBuilder;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RequestUrl {
    private static final String BANNER_AD_PATH = "/adv/banner2";
    private static final String CUSTOM_AD_PATH = "/adv/m";
    private static final String LOOP_AD_PATH = "/adv/m";
    private static final String NEW_OFFICIAL_YOUKU_AD_DOMAIN = "mc.atm.youku.com";
    private static final String OFFICIAL_YOUKU_AD_DOMAIN = "iyes.youku.com";
    private static final String OTT_CUSTOM_AD_PATH = "/vs";
    private static final String OTT_MID_PASTER_AD_PATH = "/mo";
    private static final String OTT_OFFICIAL_CIBN_AD_DOMAIN = "valf.atm.cp31.ott.cibntv.net";
    private static final String OTT_OFFICIAL_WASU_AD_DOMAIN = "valfatm.cp12.wasu.tv";
    private static final String OTT_PAUSE_AD_PATH = "/mp";
    private static final String OTT_SCENE_AD_PATH = "/sc";
    private static final String PASTER_AD_PATH = "/adv";
    private static final String PAUSE_AD_PATH = "/adv";
    private static final String SCENE_AD_PATH = "/sc";
    private static final String TEST_YOUKU_AD_DOMAIN = "pre.iyes.youku.com";

    private static String getNewUrlDomain() {
        return AdSdkManager.getInstance().getConfig().getDeviceType() == 1 ? TextUtils.equals(AdSdkManager.getInstance().getConfig().getLicense(), BaseAdRequestBuilder.LICENSE_WASU) ? OTT_OFFICIAL_WASU_AD_DOMAIN : OTT_OFFICIAL_CIBN_AD_DOMAIN : NEW_OFFICIAL_YOUKU_AD_DOMAIN;
    }

    private static String getOttUrl(int i) {
        StringBuilder sb;
        String str;
        if (10 == i) {
            sb = new StringBuilder();
            sb.append(getProtocol());
            sb.append(getUrlDomain());
            str = OTT_PAUSE_AD_PATH;
        } else if (23 == i) {
            sb = new StringBuilder();
            sb.append(getProtocol());
            sb.append(getNewUrlDomain());
            str = "/sc";
        } else if (24 == i) {
            sb = new StringBuilder();
            sb.append(getProtocol());
            sb.append(getUrlDomain());
            str = OTT_CUSTOM_AD_PATH;
        } else if (8 != i) {
            return "";
        } else {
            sb = new StringBuilder();
            sb.append(getProtocol());
            sb.append(getUrlDomain());
            str = OTT_MID_PASTER_AD_PATH;
        }
        sb.append(str);
        return sb.toString();
    }

    private static String getPhoneUrl(int i) {
        StringBuilder sb;
        String str = "/adv";
        if (10 != i) {
            if (23 != i) {
                if (24 == i) {
                    sb = new StringBuilder();
                } else if (8 == i || 7 == i) {
                    sb = new StringBuilder();
                } else if (25 == i) {
                    sb = new StringBuilder();
                } else if (1433218285 != i) {
                    return "";
                } else {
                    sb = new StringBuilder();
                    sb.append(getProtocol());
                    sb.append(getUrlDomain());
                    str = BANNER_AD_PATH;
                }
                sb.append(getProtocol());
                sb.append(getUrlDomain());
                sb.append("/adv/m");
                return sb.toString();
            }
            sb = new StringBuilder();
            sb.append(getProtocol());
            sb.append(getNewUrlDomain());
            str = "/sc";
            sb.append(str);
            return sb.toString();
        }
        sb = new StringBuilder();
        sb.append(getProtocol());
        sb.append(getUrlDomain());
        sb.append(str);
        return sb.toString();
    }

    private static String getProtocol() {
        return AdSdkManager.getInstance().getConfig().isUseHttps() ? "https://" : "http://";
    }

    public static String getUrl(int i) {
        return AdSdkManager.getInstance().getConfig().getDeviceType() == 1 ? getOttUrl(i) : getPhoneUrl(i);
    }

    private static String getUrlDomain() {
        return AdSdkManager.getInstance().getConfig().isDebugMode() ? TEST_YOUKU_AD_DOMAIN : AdSdkManager.getInstance().getConfig().getDeviceType() == 1 ? TextUtils.equals(AdSdkManager.getInstance().getConfig().getLicense(), BaseAdRequestBuilder.LICENSE_WASU) ? OTT_OFFICIAL_WASU_AD_DOMAIN : OTT_OFFICIAL_CIBN_AD_DOMAIN : OFFICIAL_YOUKU_AD_DOMAIN;
    }
}
