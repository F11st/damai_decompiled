package com.ali.user.open.oauth;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.oauth.alipay3.AlipayOauthServiceProviderImpl;
import com.ali.user.open.oauth.damai.DamaiOauthServiceProviderImpl;
import com.ali.user.open.oauth.eleme.ElemeOauthServiceProviderImpl;
import com.ali.user.open.oauth.icbu.IcbuOauthServiceProviderImpl;
import com.ali.user.open.oauth.jiuyou.JiuyouOauthServiceProviderImpl;
import com.ali.user.open.oauth.qq.QQOauthServiceProviderImpl;
import com.ali.user.open.oauth.taobao.TaobaoOauthServiceProviderImpl;
import com.ali.user.open.oauth.wechat.WechatOauthServiceProviderImpl;
import com.ali.user.open.oauth.weibo.WeiboOauthServiceProviderImpl;
import com.ali.user.open.oauth.xianyu.XianyuOauthServiceProviderImpl;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.service.impl.SessionManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OauthServiceProviderFactory {
    private static volatile OauthServiceProviderFactory instance;
    private Map<String, OauthServiceProvider> mServiceProviderMap;

    private OauthServiceProviderFactory() {
        HashMap hashMap = new HashMap();
        this.mServiceProviderMap = hashMap;
        if (hashMap.isEmpty()) {
            HashMap hashMap2 = new HashMap();
            this.mServiceProviderMap = hashMap2;
            hashMap2.put("alipay", new AlipayOauthServiceProviderImpl());
            this.mServiceProviderMap.put("taobao", new TaobaoOauthServiceProviderImpl());
            this.mServiceProviderMap.put(Site.ELEME, new ElemeOauthServiceProviderImpl());
            this.mServiceProviderMap.put(Site.ICBU, new IcbuOauthServiceProviderImpl());
            this.mServiceProviderMap.put("damai", new DamaiOauthServiceProviderImpl());
            this.mServiceProviderMap.put(Site.WEIBO, new WeiboOauthServiceProviderImpl());
            this.mServiceProviderMap.put("wechat", new WechatOauthServiceProviderImpl());
            this.mServiceProviderMap.put(Site.QQ, new QQOauthServiceProviderImpl());
            this.mServiceProviderMap.put("jiuyou", new JiuyouOauthServiceProviderImpl());
            this.mServiceProviderMap.put(Site.XIANYU, new XianyuOauthServiceProviderImpl());
        }
    }

    public static OauthServiceProviderFactory getInstance() {
        if (instance == null) {
            synchronized (OauthServiceProviderFactory.class) {
                if (instance == null) {
                    instance = new OauthServiceProviderFactory();
                }
            }
        }
        return instance;
    }

    public void cleanUp() {
        this.mServiceProviderMap.clear();
    }

    public OauthServiceProvider getOauthServiceProvider(String str) {
        OauthServiceProvider oauthServiceProvider = this.mServiceProviderMap.get(str);
        return oauthServiceProvider != null ? oauthServiceProvider : new DefaultOauthServiceProviderImpl();
    }

    public List<String> logoutAll(Context context) {
        ArrayList arrayList = new ArrayList();
        Set<String> allSessionSites = SessionManager.INSTANCE.getAllSessionSites();
        for (String str : this.mServiceProviderMap.keySet()) {
            if (this.mServiceProviderMap.get(str) != null && !TextUtils.equals(str, AliMemberSDK.getMasterSite())) {
                if (allSessionSites != null) {
                    allSessionSites.remove(str);
                }
                this.mServiceProviderMap.get(str).logout(context, str);
                arrayList.add(str);
            }
        }
        if (allSessionSites != null) {
            for (String str2 : allSessionSites) {
                try {
                    if (!TextUtils.equals(str2, AliMemberSDK.getMasterSite())) {
                        arrayList.add(str2);
                        ((SessionService) AliMemberSDK.getService(SessionService.class)).logout(str2);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public OauthServiceProvider putOauthServiceProvider(String str, OauthServiceProvider oauthServiceProvider) {
        return this.mServiceProviderMap.put(str, oauthServiceProvider);
    }
}
