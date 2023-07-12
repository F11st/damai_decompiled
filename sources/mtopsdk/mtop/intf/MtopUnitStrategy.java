package mtopsdk.mtop.intf;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface MtopUnitStrategy {
    public static final String GUIDE_DAILY_DOMAIN = "guide-acs.waptest.taobao.com";
    public static final String GUIDE_ONLINE_DOMAIN = "guide-acs.m.taobao.com";
    public static final String GUIDE_PRE_DOMAIN = "guide-acs.wapa.taobao.com";
    public static final String TRADE_DAILY_DOMAIN = "trade-acs.waptest.taobao.com";
    public static final String TRADE_ONLINE_DOMAIN = "trade-acs.m.taobao.com";
    public static final String TRADE_PRE_DOMAIN = "trade-acs.wapa.taobao.com";
    public static final String UNIT_GUIDE = "UNIT_GUIDE";
    public static final String UNIT_TRADE = "UNIT_TRADE";

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface Definition {
    }
}
