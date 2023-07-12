package com.ali.user.open.ucc;

import com.ali.user.open.core.Site;
import com.ali.user.open.ucc.alipay3.AlipayUccServiceProviderImpl;
import com.ali.user.open.ucc.eleme.ElemeUccServiceProviderImpl;
import com.ali.user.open.ucc.icbu.IcbuUccServiceProviderImpl;
import com.ali.user.open.ucc.jiuyou.JiuYouUccServiceProviderImpl;
import com.ali.user.open.ucc.netease.NeteaseUccServiceProviderImpl;
import com.ali.user.open.ucc.qq.QQUccServiceProviderImpl;
import com.ali.user.open.ucc.taobao.TaobaoUccServiceProviderImpl;
import com.ali.user.open.ucc.wechat.WechatUccServiceProviderImpl;
import com.ali.user.open.ucc.weibo.WeiboUccServiceProviderImpl;
import com.ali.user.open.ucc.xianyu.XianyuUccServiceProviderImpl;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccServiceProviderFactory {
    private static volatile UccServiceProviderFactory instance;
    private Map<String, UccServiceProvider> mUccServiceProviderMap;

    private UccServiceProviderFactory() {
        HashMap hashMap = new HashMap();
        this.mUccServiceProviderMap = hashMap;
        if (hashMap.isEmpty()) {
            HashMap hashMap2 = new HashMap();
            this.mUccServiceProviderMap = hashMap2;
            hashMap2.put("alipay", new AlipayUccServiceProviderImpl());
            this.mUccServiceProviderMap.put("taobao", new TaobaoUccServiceProviderImpl());
            this.mUccServiceProviderMap.put(Site.ELEME, new ElemeUccServiceProviderImpl());
            this.mUccServiceProviderMap.put(Site.ICBU, new IcbuUccServiceProviderImpl());
            this.mUccServiceProviderMap.put(Site.WEIBO, new WeiboUccServiceProviderImpl());
            this.mUccServiceProviderMap.put("wechat", new WechatUccServiceProviderImpl());
            this.mUccServiceProviderMap.put(Site.QQ, new QQUccServiceProviderImpl());
            this.mUccServiceProviderMap.put(Site.NETEASE, new NeteaseUccServiceProviderImpl());
            this.mUccServiceProviderMap.put("jiuyou", new JiuYouUccServiceProviderImpl());
            this.mUccServiceProviderMap.put(Site.XIANYU, new XianyuUccServiceProviderImpl());
        }
    }

    public static UccServiceProviderFactory getInstance() {
        if (instance == null) {
            synchronized (UccServiceProviderFactory.class) {
                if (instance == null) {
                    instance = new UccServiceProviderFactory();
                }
            }
        }
        return instance;
    }

    public void cleanUp() {
        this.mUccServiceProviderMap.clear();
    }

    public UccServiceProvider getUccServiceProvider(String str) {
        UccServiceProvider uccServiceProvider = this.mUccServiceProviderMap.get(str);
        return uccServiceProvider != null ? uccServiceProvider : new DefaultUccServiceProviderImpl();
    }
}
