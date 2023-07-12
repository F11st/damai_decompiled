package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.tencent.open.SocialConstants;
import com.youku.live.dago.utils.ColorUtil;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftCategoryBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftThemeConfig;
import com.youku.live.dago.widgetlib.interactive.gift.manager.GiftDataManager;
import com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow;
import com.youku.live.dago.widgetlib.interactive.utils.GiftUTUtils;
import com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol;
import com.youku.live.dago.widgetlib.wedome.framework.YKLAdapterFactory;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.constants.DagoDataCenterConstants;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jn1;
import tb.mj2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLGiftBoardComponent extends ProxyWXComponent<View> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoGiftBoardComponent";
    private static final String TEST_GIFT_LIST = "[{\"id\":0,\"name\":\"测试\",\"list\":[{\"id\":7980,\"name\":\"星耀七周年\",\"icon\":\"https://image.laifeng.com/image/757439C94EDB4218BD2C591CD6EAA21E\",\"coins\":300000,\"desc\":\"星耀七周年\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"GRAFFITI\\\":true}\",\"gid\":7980,\"url\":\"https://image.laifeng.com/file/C785F5B7105441B2B3E6D82073C9304F\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":157046449,\"name\":\"测试新娘webp\",\"icon\":\"https://image.laifeng.com/image/17B1AD6930BE4DE68E59DA4C7E3E38A3\",\"coins\":1,\"desc\":\"测试新娘webp\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"GRAFFITI\\\":true}\",\"gid\":157046449,\"url\":\"https://image.laifeng.com/file/96157165ACE64E70AC1B8FB43C820FFB\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":157046448,\"name\":\"测试地球\",\"icon\":\"https://image.laifeng.com/image/B3994CEFA0CB4013917CC9C9CDC0F471\",\"coins\":1,\"desc\":\"测试地球测试地球\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"GRAFFITI\\\":true}\",\"gid\":157046448,\"url\":\"https://image.laifeng.com/file/25F9832F58854552B5951853D20CBA2B\",\"type\":\"svga\",\"iszip\":\"1\",\"size\":{\"width\":750,\"height\":750},\"moreselect\":[],\"groupId\":0},{\"id\":157046447,\"name\":\"测试svga海鸥\",\"icon\":\"https://image.laifeng.com/image/999F2EFD0F504C0E82C2BA18438AAAF4\",\"coins\":1,\"desc\":\"测试svga海鸥\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"GRAFFITI\\\":true}\",\"gid\":157046447,\"url\":\"https://image.laifeng.com/file/271924D0BFB64B91A7B96553F6581DDC\",\"type\":\"svga\",\"iszip\":\"1\",\"size\":{\"width\":750,\"height\":750},\"moreselect\":[],\"groupId\":0},{\"id\":157046446,\"name\":\"测试城堡mp4\",\"icon\":\"https://image.laifeng.com/image/34135BF5014A4134BBFD9FCC3D0D0F88\",\"coins\":1,\"desc\":\"测试城堡mp4测试城堡mp4\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"GRAFFITI\\\":true}\",\"gid\":157046446,\"url\":\"https://image.laifeng.com/file/A43F1952831441D0970CDA2C5F367B65\",\"type\":\"mp4gift\",\"iszip\":\"0\",\"moreselect\":[],\"groupId\":0},{\"id\":87764674,\"name\":\"小鸡测试\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/87764674_gift_120_120_20190829165545.png\",\"coins\":1,\"desc\":\"小鸡测试天使\",\"label\":\"\",\"giftTagMap\":\"{\\\"LUCKY\\\":true,\\\"GRAFFITI\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":6789000,\"name\":\"一生测试\",\"icon\":\"https://image.laifeng.com/image/DD1BB25495FB47998E274E66AF489BD0\",\"coins\":1,\"desc\":\"一生测试\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":6789000,\"url\":\"https://image.laifeng.com/file/A9DE1E270D91445C8843BDDF282F4DC5\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0}]},{\"id\":0,\"name\":\"热门\",\"list\":[{\"id\":7946,\"name\":\"么么哒\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7946_gift_120_120_20200228232611.png\",\"coins\":100,\"desc\":\"甜甜腻腻~\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":7947,\"name\":\"鼠年吉祥\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7947_gift_120_120_20200228231814.png\",\"coins\":200,\"desc\":\"鼠年吉祥\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":7945,\"name\":\"幸运锦鲤\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7945_gift_120_120_20200228231703.png\",\"coins\":1000,\"desc\":\"主播可得300星豆\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB1FFhPCYH1gK0jSZFwXXc7aXXa-52-28.png\",\"giftTagMap\":\"{\\\"ORDER_LUCKY\\\":true,\\\"WEEK_STAR\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":7953,\"name\":\"麦克风\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7953_gift_120_120_20200116150634.png\",\"coins\":300,\"desc\":\"麦克风\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":924,\"name\":\"幸运钻石\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/924_gift_120_120_20200115113756.png\",\"coins\":500,\"desc\":\"主播可得150星豆\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB1FFhPCYH1gK0jSZFwXXc7aXXa-52-28.png\",\"giftTagMap\":\"{\\\"ORDER_LUCKY\\\":true,\\\"WEEK_STAR\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":7954,\"name\":\"魔法口红\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7954_gift_120_120_20200118091837.png\",\"coins\":500,\"desc\":\"魔法口红\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":7950,\"name\":\"棒棒糖\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7950_gift_120_120_20200115113030.png\",\"coins\":5500,\"desc\":\"送你一份甜蜜\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":21,\"name\":\"情人戒指\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/21_gift_120_120_20200115160645.png\",\"coins\":100,\"desc\":\"打造专属于你们的爱\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":923,\"name\":\"幸运花束\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/923_gift_120_120_20190627151427.png\",\"coins\":100,\"desc\":\"播客可得30星豆\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB1FFhPCYH1gK0jSZFwXXc7aXXa-52-28.png\",\"giftTagMap\":\"{\\\"ORDER_LUCKY\\\":true,\\\"WEEK_STAR\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":143830537,\"name\":\"幸运天使\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/143830537_gift_120_120_20190802201536.png\",\"coins\":100,\"desc\":\"播客可得30星豆\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB1FFhPCYH1gK0jSZFwXXc7aXXa-52-28.png\",\"giftTagMap\":\"{\\\"ORDER_LUCKY\\\":true,\\\"WEEK_STAR\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":7948,\"name\":\"生日蛋糕\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7948_gift_120_120_20200115113453.png\",\"coins\":6600,\"desc\":\"生日蛋糕\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":7949,\"name\":\"甜甜圈\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7949_gift_120_120_20200115113925.png\",\"coins\":8800,\"desc\":\"和你甜蜜在一起\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":922,\"name\":\"幸运萝卜\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/922_gift_120_120_20190627162915.png\",\"coins\":200,\"desc\":\"播客可得60星豆\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB1FFhPCYH1gK0jSZFwXXc7aXXa-52-28.png\",\"giftTagMap\":\"{\\\"ORDER_LUCKY\\\":true,\\\"WEEK_STAR\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":5,\"name\":\"啤酒\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/5_gift_120_120_20190627163232.png\",\"coins\":100,\"desc\":\"连送2组188，触发1星特效\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":851,\"name\":\"我爱你\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/851_gift_120_120_20190627161131.png\",\"coins\":100,\"desc\":\"爱在我心\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":7910,\"name\":\"幸运魔方\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7910_gift_120_120_20191204215800.png\",\"coins\":200,\"desc\":\"播客可得60星豆\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB1FFhPCYH1gK0jSZFwXXc7aXXa-52-28.png\",\"giftTagMap\":\"{\\\"ORDER_LUCKY\\\":true,\\\"WEEK_STAR\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":801,\"name\":\"小太阳\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/801_gift_120_120_20170414150703.png\",\"coins\":1000,\"desc\":\"一部分星币累计到小金库，可用于发红包，播客可得500星豆\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"JINKU\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":67,\"name\":\"四叶草\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/67_gift_120_120_20190710175735.png\",\"coins\":100,\"desc\":\"播客可得30星豆\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB1FFhPCYH1gK0jSZFwXXc7aXXa-52-28.png\",\"giftTagMap\":\"{\\\"ORDER_LUCKY\\\":true,\\\"WEEK_STAR\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":63,\"name\":\"心愿纸鹤\",\"icon\":\"http://static.youku.com/ddshow/img/lfgift/origami_120_120.png\",\"coins\":45,\"desc\":\"来疯会员专属礼物\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB16GVLCVP7gK0jSZFjXXc5aXXa-52-28.png\",\"giftTagMap\":\"{\\\"VIP\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0},{\"id\":672,\"name\":\"鼓掌\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/672_gift_120_120_20170918101556.png\",\"coins\":100,\"desc\":\"为爱鼓掌\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"NEW_USER\\\":true}\",\"moreselect\":[{\"num\":1,\"name\":\"一心一意\"},{\"num\":10,\"name\":\"十全十美\"},{\"num\":66,\"name\":\"六六大顺\"},{\"num\":99,\"name\":\"天长地久\"},{\"num\":188,\"name\":\"要抱抱\"},{\"num\":520,\"name\":\"我爱你\"},{\"num\":1314,\"name\":\"一生一世\"},{\"num\":3344,\"name\":\"生生世世\"}],\"groupId\":0}]},{\"id\":0,\"name\":\"豪华\",\"list\":[{\"id\":7938,\"name\":\"多喝热水\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7938_gift_120_120_20200228232257.png\",\"coins\":10000,\"desc\":\"终极关怀\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB14ipLC7P2gK0jSZPxXXacQpXa-52-28.png\",\"giftTagMap\":\"{\\\"WEEK_STAR\\\":true}\",\"gid\":7938,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7938_webp_20200228232257.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":7944,\"name\":\"情书\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7944_gift_120_120_20200228231450.png\",\"coins\":10000,\"desc\":\"触动灵魂\",\"label\":\"\",\"tagIcon\":\"https://gw.alicdn.com/tfs/TB14ipLC7P2gK0jSZPxXXacQpXa-52-28.png\",\"giftTagMap\":\"{\\\"WEEK_STAR\\\":true}\",\"gid\":7944,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7944_webp_20200228231450.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":7941,\"name\":\"浪漫满屋\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7941_gift_120_120_20200228231025.png\",\"coins\":20000,\"desc\":\"浪漫满屋\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":7941,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7941_webp_20200228231025.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":7939,\"name\":\"一见倾心\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7939_gift_120_120_20200228230149.png\",\"coins\":20000,\"desc\":\"一见倾心，一心向往\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":7939,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7939_webp_20200228230149.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":7943,\"name\":\"玫瑰花盒\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7943_gift_120_120_20200228231246.png\",\"coins\":20000,\"desc\":\"永生花\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":7943,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7943_webp_20200228231246.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":7942,\"name\":\"飞机环游\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7942_gift_120_120_20200117143623.png\",\"coins\":100000,\"desc\":\"价值10w星币\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":7942,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7942_webp_20200117143623.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":7940,\"name\":\"水晶球\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7940_gift_120_120_20200228230628.png\",\"coins\":500000,\"desc\":\"许下你的心愿,我帮你实现\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":7940,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7940_webp_20200228230628.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":7952,\"name\":\"环游世界\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7952_gift_120_120_20200228232116.png\",\"coins\":1000000,\"desc\":\"陪你看世界\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":7952,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7952_webp_20200228232116.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":7951,\"name\":\"鼠你最旺\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/7951_gift_120_120_20200228232027.png\",\"coins\":2000000,\"desc\":\"新的一年旺旺旺！\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":7951,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/7951_webp_20200228232027.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":3704,\"name\":\"3704\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/3704_gift_120_120_20191231102801.png\",\"coins\":100000,\"desc\":\"18年最佳女主播定制礼物\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":3704,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/3704_webp_20191231102801.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":88,\"name\":\"水晶之恋\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/88_gift_120_120_20170815102152.png\",\"coins\":50000,\"desc\":\"\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":88,\"url\":\"https://image.laifeng.com/file/F9EFC62FB6E1491CA493F1E205F05F3A\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":157046454,\"name\":\"新测试礼物\",\"icon\":\"https://image.laifeng.com/image/34135BF5014A4134BBFD9FCC3D0D0F88\",\"coins\":1,\"desc\":\"新测试礼物\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":157046454,\"url\":\"https://image.laifeng.com/file/A43F1952831441D0970CDA2C5F367B65\",\"type\":\"mp4gift\",\"iszip\":\"0\",\"moreselect\":[],\"groupId\":0},{\"id\":143998980,\"name\":\"天使降临\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/143998980_gift_120_120_20190802201402.png\",\"coins\":20000000,\"desc\":\"主播得600万星豆\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"GOD\\\":true}\",\"gid\":143998980,\"url\":\"http://static.youku.com/ddshow/res/gift/frame/143998980_webp_20190802201402.zip\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":89,\"name\":\"紫色依恋\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/89_gift_120_120_20170828100722.png\",\"coins\":1000000,\"desc\":\"\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":89,\"url\":\"\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":840,\"name\":\"骰子\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/840_gift_120_120_20170110102109.png\",\"coins\":10000,\"desc\":\"骰子\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{\\\"DICE\\\":true}\",\"gid\":840,\"url\":\"https://image.laifeng.com/file/B919A90C21AF42AC8D3A808BD7E13AC7\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":87,\"name\":\"飞屋环游\",\"icon\":\"http://static.youku.com/ddshow/img/lfgift/lmfw1_120_120.png\",\"coins\":20000,\"desc\":\"\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":87,\"url\":\"https://image.laifeng.com/file/DE78EA4102814061AC6ED323117B9C11\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":51,\"name\":\"甜蜜骑行\",\"icon\":\"http://static.youku.com/ddshow/img/lfgift/tmqx1_120_120.png\",\"coins\":150000,\"desc\":\"\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":51,\"url\":\"https://image.laifeng.com/file/C2AC871528074FE7A9FADACC681DCD94\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":812,\"name\":\"水晶鞋\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/812_gift_120_120_20160719193114.png\",\"coins\":20000,\"desc\":\"水晶鞋\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":812,\"url\":\"https://image.laifeng.com/file/3E5F5433296C40F48B452F2827E4D948\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":49,\"name\":\"为你心动\",\"icon\":\"http://static.youku.com/ddshow/res/gift/lfgift/49_gift_120_120_20170815102119.png\",\"coins\":300000,\"desc\":\"\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":49,\"url\":\"https://image.laifeng.com/file/595676623630416F83C08C27D4E8F3D6\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":31,\"name\":\"女神驾到\",\"icon\":\"http://static.youku.com/ddshow/img/lfgift/nvsheng1_120_120.png\",\"coins\":500000,\"desc\":\"\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":31,\"url\":\"https://image.laifeng.com/file/A639EBF22FC84A89AD2A727058E9D943\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":16,\"name\":\"私人飞机\",\"icon\":\"http://static.youku.com/ddshow/img/lfgift/plain1_120_120.png\",\"coins\":100000,\"desc\":\"\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":16,\"url\":\"https://image.laifeng.com/file/A06A8C9AC668406BA16403A2FC226207\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0},{\"id\":14,\"name\":\"花园别墅\",\"icon\":\"http://static.youku.com/ddshow/img/lfgift/villa1_120_120.png\",\"coins\":80000,\"desc\":\"\",\"label\":\"\",\"tagIcon\":\"\",\"giftTagMap\":\"{}\",\"gid\":14,\"url\":\"https://image.laifeng.com/file/B072C7F499DF4E2BBDAA79B8EB5283ED\",\"type\":\"webp\",\"iszip\":\"1\",\"moreselect\":[],\"groupId\":0}]}]";
    private String coins;
    private String countdownTime;
    private boolean firstRecharge;
    private boolean hasMultipleTargets;
    private boolean hasPack;
    private boolean hasPackTip;
    private boolean hasStarGift;
    private boolean isYouKu;
    private boolean mIsInitialized;
    private YKLGiftBoardProtocol mYKLGiftBoardProtocol;
    private String mode;
    private JSCallback morePropBtnClickCallback;
    private String multipleText;
    private JSCallback propCountdownCallback;
    private String roomId;
    private String rowNum;
    private int selectedNum;
    private String seletedGid;
    private String seletedPid;
    private String seletedTid;
    private boolean showPack;
    private boolean showTargetDetails;
    private Map<String, Object> spm;
    private String starCoins;
    private GiftTheme theme;
    private String uCoins;
    private boolean useCache;

    public YKLGiftBoardComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
        this.mYKLGiftBoardProtocol = null;
        this.mode = "0";
        this.rowNum = "2";
        this.coins = "0";
        this.roomId = "0";
        this.seletedGid = null;
        this.seletedPid = null;
        this.seletedTid = null;
        this.countdownTime = "10";
        this.selectedNum = 1;
        this.hasPack = false;
        this.showPack = false;
        this.hasPackTip = false;
        this.hasStarGift = false;
        this.showTargetDetails = false;
        this.firstRecharge = false;
        this.hasMultipleTargets = true;
        this.isYouKu = false;
        this.starCoins = "0";
        this.uCoins = "0";
        this.theme = null;
        this.useCache = false;
        this.mIsInitialized = false;
    }

    private List<GiftCategoryBean> cast2GiftList(Object obj) {
        GiftInfoBean.GiftTag[] values;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-849063675")) {
            return (List) ipChange.ipc$dispatch("-849063675", new Object[]{this, obj});
        }
        if (obj != null && (obj instanceof String)) {
            ArrayList arrayList = new ArrayList();
            JSONArray parseArray = JSON.parseArray(String.valueOf(obj));
            if (parseArray != null) {
                for (int i = 0; i < parseArray.size(); i++) {
                    JSONObject jSONObject = parseArray.getJSONObject(i);
                    if (jSONObject != null) {
                        GiftCategoryBean giftCategoryBean = new GiftCategoryBean();
                        giftCategoryBean.name = jSONObject.getString("name");
                        giftCategoryBean.groupId = jSONObject.getString("id");
                        JSONArray jSONArray = jSONObject.getJSONArray("list");
                        if (jSONArray != null) {
                            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                if (jSONObject2 != null) {
                                    GiftInfoBean giftInfoBean = new GiftInfoBean();
                                    giftInfoBean.id = jSONObject2.getString("id");
                                    giftInfoBean.name = jSONObject2.getString("name");
                                    giftInfoBean.icon = jSONObject2.getString(RemoteMessageConst.Notification.ICON);
                                    giftInfoBean.coins = jSONObject2.getString("coins");
                                    giftInfoBean.label = jSONObject2.getString("label");
                                    giftInfoBean.desc = jSONObject2.getString(SocialConstants.PARAM_APP_DESC);
                                    giftInfoBean.tagIcon = jSONObject2.getString("tagIcon");
                                    if (jSONObject2.containsKey("btn")) {
                                        giftInfoBean.btn = jSONObject2.getString("btn");
                                    }
                                    if (jSONObject2.containsKey("multiSend")) {
                                        giftInfoBean.multiSend = jSONObject2.getBooleanValue("multiSend");
                                    }
                                    if (jSONObject2.containsKey("continuousSend")) {
                                        giftInfoBean.continuousSend = jSONObject2.getBooleanValue("continuousSend");
                                    }
                                    JSONObject parseObject = JSON.parseObject(jSONObject2.getString("giftTagMap"));
                                    if (parseObject != null) {
                                        for (GiftInfoBean.GiftTag giftTag : GiftInfoBean.GiftTag.values()) {
                                            String name = giftTag.name();
                                            if (parseObject.containsKey(name) && parseObject.getBoolean(name).booleanValue()) {
                                                giftInfoBean.addGiftTag(giftTag);
                                            }
                                        }
                                    }
                                    JSONArray jSONArray2 = jSONObject2.getJSONArray("moreselect");
                                    if (jSONArray2 != null && jSONArray2.size() > 0) {
                                        ArrayList arrayList2 = new ArrayList();
                                        for (int i3 = 0; i3 < jSONArray2.size(); i3++) {
                                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                                            if (jSONObject3 != null) {
                                                GiftNumBean giftNumBean = new GiftNumBean();
                                                giftNumBean.num = jSONObject3.getInteger(GiftNumBean.KEY_NUM).intValue();
                                                giftNumBean.name = jSONObject3.getString("name");
                                                arrayList2.add(0, giftNumBean);
                                            }
                                        }
                                        giftInfoBean.numList = arrayList2;
                                    } else {
                                        giftInfoBean.numList = null;
                                    }
                                    giftCategoryBean.giftInfos.add(giftInfoBean);
                                }
                            }
                        }
                        arrayList.add(giftCategoryBean);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    private List<GiftTargetInfoBean> cast2TargetList(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295589850")) {
            return (List) ipChange.ipc$dispatch("-295589850", new Object[]{this, obj});
        }
        if (obj != null && (obj instanceof String)) {
            ArrayList arrayList = new ArrayList();
            JSONArray parseArray = JSON.parseArray(String.valueOf(obj));
            if (parseArray != null) {
                for (int i = 0; i < parseArray.size(); i++) {
                    JSONObject jSONObject = parseArray.getJSONObject(i);
                    if (jSONObject != null) {
                        GiftTargetInfoBean giftTargetInfoBean = new GiftTargetInfoBean();
                        giftTargetInfoBean.icon = jSONObject.getString("anchorIcon");
                        giftTargetInfoBean.name = jSONObject.getString("anchorName");
                        giftTargetInfoBean.id = jSONObject.getString("anchorId");
                        giftTargetInfoBean.desc = jSONObject.getString("anchorDesc");
                        arrayList.add(giftTargetInfoBean);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeCallback(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506122341")) {
            ipChange.ipc$dispatch("-506122341", new Object[]{this, map});
        } else {
            fireEvent("closecallback", map);
        }
    }

    private GiftPropBean fetchPropJson(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504716290")) {
            return (GiftPropBean) ipChange.ipc$dispatch("-1504716290", new Object[]{this, jSONObject});
        }
        GiftPropBean giftPropBean = new GiftPropBean();
        giftPropBean.id = jSONObject.containsKey("id") ? jSONObject.getString("id") : null;
        giftPropBean.name = jSONObject.containsKey("name") ? jSONObject.getString("name") : null;
        giftPropBean.desc = jSONObject.getString(SocialConstants.PARAM_APP_DESC);
        giftPropBean.icon = jSONObject.getString(RemoteMessageConst.Notification.ICON);
        giftPropBean.btn = jSONObject.getString("btn");
        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "type id = " + jSONObject.getString(SocialConstants.PARAM_TYPE_ID));
        giftPropBean.typeId = jSONObject.getString(SocialConstants.PARAM_TYPE_ID);
        giftPropBean.num = ParseUtils.parse2Int(jSONObject.getString(GiftNumBean.KEY_NUM));
        jSONObject.getJSONObject("data");
        giftPropBean.rgb = jSONObject.getString("rgb");
        giftPropBean.expire = jSONObject.getString("expire");
        String string = jSONObject.getString("alpha");
        giftPropBean.alpha = string;
        giftPropBean.taskMarkBg = giftPropBean.getColor(string, giftPropBean.rgb, -1);
        giftPropBean.propType = jSONObject.containsKey("propType") ? jSONObject.getInteger("propType").intValue() : -1;
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null && !TextUtils.isEmpty(jSONObject2.getString("time"))) {
            giftPropBean.time = ParseUtils.parse2Long(jSONObject2.getString("time"));
        }
        return giftPropBean;
    }

    private GiftTheme fetchThemeData(String str) {
        JSONObject parseObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389797360")) {
            return (GiftTheme) ipChange.ipc$dispatch("389797360", new Object[]{this, str});
        }
        if (JSON.parseObject(str) != null) {
            GiftTheme giftTheme = new GiftTheme();
            String str2 = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + parseObject.getString("main_0");
            String str3 = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + parseObject.getString("main_0");
            String str4 = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + parseObject.getString("main_1");
            giftTheme.themeColor = ColorUtil.parseColor(str2, 0);
            giftTheme.themeTextColor = ColorUtil.parseColor(str3, 0);
            giftTheme.btnGiantStartColor = ColorUtil.parseColor(str4, 0);
            giftTheme.btnGiantEndColor = ColorUtil.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + parseObject.getString("main_2"), 0);
            int i = giftTheme.themeColor;
            giftTheme.btnGiantProgressBgColor = i;
            if (i != 0) {
                giftTheme.btnGiantProgressBgColor = ColorUtil.getColorWithAlpha(0.8f, i);
            }
            return giftTheme;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateTargetInfo(List<GiftTargetInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294821536")) {
            return (String) ipChange.ipc$dispatch("-1294821536", new Object[]{this, list});
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (GiftTargetInfoBean giftTargetInfoBean : list) {
            if (giftTargetInfoBean != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("anchorId", giftTargetInfoBean.id);
                hashMap.put("anchorIcon", giftTargetInfoBean.icon);
                hashMap.put("anchorName", giftTargetInfoBean.name);
                arrayList.add(new JSONObject(hashMap).toString());
            }
        }
        return new JSONArray(arrayList).toJSONString();
    }

    private YKLGiftBoardProtocol getAdapter(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1525987565") ? (YKLGiftBoardProtocol) ipChange.ipc$dispatch("1525987565", new Object[]{this, context}) : (YKLGiftBoardProtocol) YKLAdapterFactory.getInstance().createInterface(YKLGiftBoardComponent.class, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> getArgs(GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1994871935")) {
            return (Map) ipChange.ipc$dispatch("1994871935", new Object[]{this, giftPropBean});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", giftPropBean.id);
        hashMap.put("name", giftPropBean.name);
        hashMap.put(SocialConstants.PARAM_APP_DESC, giftPropBean.desc);
        hashMap.put(RemoteMessageConst.Notification.ICON, giftPropBean.icon);
        hashMap.put("rgb", giftPropBean.rgb);
        hashMap.put("alpha", giftPropBean.alpha);
        hashMap.put("propType", Integer.valueOf(giftPropBean.propType));
        return hashMap;
    }

    private void initAttrs() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "52643957")) {
            ipChange.ipc$dispatch("52643957", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            Object data = widgetEngineInstance.getData(DagoDataCenterConstants.DAGO_LIVE_ID);
            if ((data instanceof String) && data != null) {
                this.roomId = (String) data;
            }
        }
        if (getBasicComponentData() != null && getBasicComponentData().getAttrs() != null) {
            this.mode = (String) getBasicComponentData().getAttrs().get("mode");
            this.rowNum = (String) getBasicComponentData().getAttrs().get("line");
            this.hasStarGift = "1".equals((String) getBasicComponentData().getAttrs().get("starGift"));
            this.showTargetDetails = "1".equals((String) getBasicComponentData().getAttrs().get("showDetails"));
            if (getBasicComponentData().getAttrs().get("dgid") != null) {
                this.seletedGid = String.valueOf(getBasicComponentData().getAttrs().get("dgid"));
            }
            if (getBasicComponentData().getAttrs().get("duid") != null) {
                this.seletedTid = String.valueOf(getBasicComponentData().getAttrs().get("duid"));
            }
            if (getBasicComponentData().getAttrs().get("dpid") != null) {
                this.seletedPid = String.valueOf(getBasicComponentData().getAttrs().get("dpid"));
            }
            GiftDataManager.getInstance().setUsingLaifengCoin("1".equals((String) getBasicComponentData().getAttrs().get("unit")));
            this.hasPack = "1".equals((String) getBasicComponentData().getAttrs().get("ispack"));
            this.showPack = "1".equals((String) getBasicComponentData().getAttrs().get("showpack"));
            this.hasPackTip = "1".equals((String) getBasicComponentData().getAttrs().get("ispacktip"));
            this.hasMultipleTargets = ("true".equals((String) getBasicComponentData().getAttrs().get("multipleTargets")) || getBasicComponentData().getAttrs().get("multipleTargets") == null) ? true : true;
            if (getBasicComponentData().getAttrs().get("multipleText") != null) {
                this.multipleText = String.valueOf(getBasicComponentData().getAttrs().get("multipleText"));
            }
            this.isYouKu = "true".equals((String) getBasicComponentData().getAttrs().get("isYouku"));
            if (getBasicComponentData().getAttrs().get("starcoins") != null) {
                this.starCoins = String.valueOf(getBasicComponentData().getAttrs().get("starcoins"));
            }
            if (getBasicComponentData().getAttrs().get("ucoins") != null) {
                this.uCoins = String.valueOf(getBasicComponentData().getAttrs().get("ucoins"));
            }
            ((ILog) Dsl.getService(ILog.class)).i("liulei-giftboard", "UPDATE THEME start");
            String str = (String) getBasicComponentData().getAttrs().get("theme");
            if (!TextUtils.isEmpty(str)) {
                this.theme = fetchThemeData(str);
            }
            if (this.theme == null) {
                this.theme = GiftThemeConfig.giftTheme;
            }
            ((ILog) Dsl.getService(ILog.class)).i("liulei-giftboard", "UPDATE THEME end");
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setRowNum(this.rowNum);
            this.mYKLGiftBoardProtocol.setRoomId(this.roomId);
            this.mYKLGiftBoardProtocol.setStarGift(this.hasStarGift);
            this.mYKLGiftBoardProtocol.setHasPackTip(this.hasPackTip);
            this.mYKLGiftBoardProtocol.setHasPack(this.hasPack);
            this.mYKLGiftBoardProtocol.setShowPack(this.showPack);
            ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "mYKLGiftBoardProtocol.setSelectGid mseletedGid " + this.seletedGid);
            this.mYKLGiftBoardProtocol.setSelectGid(this.seletedGid);
            this.mYKLGiftBoardProtocol.setSelectPid(this.seletedPid);
            this.mYKLGiftBoardProtocol.setSelectTid(this.seletedTid);
            this.mYKLGiftBoardProtocol.setShowTargetDetails(this.showTargetDetails);
            this.mYKLGiftBoardProtocol.setLandscape("1".equals(this.mode));
            this.mYKLGiftBoardProtocol.setMultipleText(this.multipleText);
            this.mYKLGiftBoardProtocol.openMultiSendMode(this.hasMultipleTargets);
            this.mYKLGiftBoardProtocol.switchVirtualCoinsExchange(this.isYouKu, this.uCoins, this.starCoins);
            this.mYKLGiftBoardProtocol.updateTheme(this.theme);
            this.mYKLGiftBoardProtocol.setCallback(new IGiftBoardCallback() { // from class: com.youku.live.dago.widgetlib.component.YKLGiftBoardComponent.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void clickLink(String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1535522718")) {
                        ipChange2.ipc$dispatch("-1535522718", new Object[]{this, str2});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void close(Map<String, Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1069139901")) {
                        ipChange2.ipc$dispatch("-1069139901", new Object[]{this, map});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "close(Map<String, Object> params)");
                    YKLGiftBoardComponent.this.closeCallback(map);
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void morePropBtnClick() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "814642764")) {
                        ipChange2.ipc$dispatch("814642764", new Object[]{this});
                    } else if (YKLGiftBoardComponent.this.morePropBtnClickCallback != null) {
                        YKLGiftBoardComponent.this.morePropBtnClickCallback.invokeAndKeepAlive(null);
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void onDoMission(GiftPropBean giftPropBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-589255954")) {
                        ipChange2.ipc$dispatch("-589255954", new Object[]{this, giftPropBean});
                    } else if (giftPropBean == null) {
                    } else {
                        YKLGiftBoardComponent yKLGiftBoardComponent = YKLGiftBoardComponent.this;
                        yKLGiftBoardComponent.packTipCallback(yKLGiftBoardComponent.getArgs(giftPropBean));
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void onGestureBoardAppear() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1384007519")) {
                        ipChange2.ipc$dispatch("1384007519", new Object[]{this});
                    } else {
                        WeexHelper.getWidgetEngineInstance(YKLGiftBoardComponent.this).lockPageable("GIFT_BOARD_COMPONENT");
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void onGestureBoardDisappear() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2104585971")) {
                        ipChange2.ipc$dispatch("2104585971", new Object[]{this});
                    } else {
                        WeexHelper.getWidgetEngineInstance(YKLGiftBoardComponent.this).unlockPageable("GIFT_BOARD_COMPONENT");
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void onRecharge() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1866746198")) {
                        ipChange2.ipc$dispatch("-1866746198", new Object[]{this});
                    } else {
                        YKLGiftBoardComponent.this.rechargeCallback();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void onSendGestureGift(int i, int i2, List<GestureGiftWindow.Coord> list, long j, List<GiftTargetInfoBean> list2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1019474980")) {
                        ipChange2.ipc$dispatch("-1019474980", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), list, Long.valueOf(j), list2});
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(YKLGiftBoardComponent.this.generateTargetInfo(list2))) {
                        hashMap.put("targetInfo", YKLGiftBoardComponent.this.generateTargetInfo(list2));
                    } else {
                        hashMap.put("targetInfo", "");
                    }
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append(jn1.MUL);
                    sb.append(i2);
                    jSONObject2.put("canvas", (Object) sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        GestureGiftWindow.Coord coord = list.get(i3);
                        if (i3 != 0) {
                            sb2.append("|");
                        }
                        sb2.append(coord.x);
                        sb2.append(",");
                        sb2.append(coord.y);
                        sb2.append(",");
                        sb2.append(coord.giftInfoBean.id);
                    }
                    jSONObject2.put("points", (Object) sb2.toString());
                    jSONObject2.put(Constants.Name.INTERVAL, (Object) Long.valueOf(j));
                    jSONObject.put("data", (Object) jSONObject2);
                    hashMap.put("giftData", jSONObject.toString());
                    hashMap.put("type", "graffiti");
                    ((ILog) Dsl.getService(ILog.class)).d("GRAFFITI", "gesture send:" + hashMap.get("giftData"));
                    YKLGiftBoardComponent.this.sendGiftCallback(hashMap);
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void onSendGift(long j, GiftInfoBean giftInfoBean, List<GiftTargetInfoBean> list) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1052301543")) {
                        ipChange2.ipc$dispatch("1052301543", new Object[]{this, Long.valueOf(j), giftInfoBean, list});
                    } else if (j == 0 || giftInfoBean == null) {
                    } else {
                        HashMap hashMap = new HashMap();
                        String generateTargetInfo = YKLGiftBoardComponent.this.generateTargetInfo(list);
                        if (!TextUtils.isEmpty(generateTargetInfo)) {
                            hashMap.put("targetInfo", generateTargetInfo);
                        } else {
                            hashMap.put("targetInfo", "");
                        }
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("giftId", (Object) giftInfoBean.id);
                        jSONObject2.put(GiftNumBean.KEY_NUM, (Object) (j + ""));
                        jSONObject.put("data", (Object) jSONObject2);
                        hashMap.put("giftData", jSONObject.toString());
                        hashMap.put("type", "normal");
                        YKLGiftBoardComponent.this.sendGiftCallback(hashMap);
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void onSendProp(long j, GiftPropBean giftPropBean, List<GiftTargetInfoBean> list) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1558120581")) {
                        ipChange2.ipc$dispatch("1558120581", new Object[]{this, Long.valueOf(j), giftPropBean, list});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "onSendProp");
                    if (giftPropBean != null) {
                        Map args = YKLGiftBoardComponent.this.getArgs(giftPropBean);
                        args.put(GiftNumBean.KEY_NUM, j + "");
                        String generateTargetInfo = YKLGiftBoardComponent.this.generateTargetInfo(list);
                        if (!TextUtils.isEmpty(generateTargetInfo)) {
                            args.put("targetInfo", generateTargetInfo);
                        }
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "sendPropCallback");
                        YKLGiftBoardComponent.this.sendPropCallback(args);
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "giftPropBean == null");
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void openExchangeBroad() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "294367333")) {
                        ipChange2.ipc$dispatch("294367333", new Object[]{this});
                    } else {
                        YKLGiftBoardComponent.this.openExchangeBroadCallBack();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void openUserCard(String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-54874027")) {
                        ipChange2.ipc$dispatch("-54874027", new Object[]{this, str2});
                        return;
                    }
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("id", str2);
                    YKLGiftBoardComponent.this.openUserCardCallback(hashMap);
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void refresh(boolean z2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-126483275")) {
                        ipChange2.ipc$dispatch("-126483275", new Object[]{this, Boolean.valueOf(z2)});
                    } else if (z2) {
                        YKLGiftBoardComponent.this.packTabCallback();
                    } else {
                        YKLGiftBoardComponent.this.retryCallback();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
                public void switchToProp(boolean z2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1794210134")) {
                        ipChange2.ipc$dispatch("1794210134", new Object[]{this, Boolean.valueOf(z2)});
                    } else if (z2) {
                        YKLGiftBoardComponent.this.packTabCallback();
                    }
                }
            });
        }
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734687920")) {
            ipChange.ipc$dispatch("-734687920", new Object[]{this});
        } else if (this.mIsInitialized) {
        } else {
            this.mIsInitialized = true;
            IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            if (widgetEngineInstance != null) {
                IProps options = widgetEngineInstance.getOptions();
                if (options != null) {
                    String string = options.getString("pagename", "");
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-UT", "page name = " + string);
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    GiftUTUtils.PAGENAME = string;
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i("liulei-UT", "OPTION is null ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openExchangeBroadCallBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640096403")) {
            ipChange.ipc$dispatch("-1640096403", new Object[]{this});
        } else {
            getInstance().fireGlobalEventCallback("exchangecallback", new HashMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUserCardCallback(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885352084")) {
            ipChange.ipc$dispatch("-1885352084", new Object[]{this, map});
        } else {
            fireEvent("anchordetailsclick", map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void packTabCallback() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1512756966")) {
            ipChange.ipc$dispatch("1512756966", new Object[]{this});
        } else {
            fireEvent("packtabcallback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void packTipCallback(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1181008229")) {
            ipChange.ipc$dispatch("1181008229", new Object[]{this, map});
        } else {
            fireEvent("packtipcallback", map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rechargeCallback() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145532937")) {
            ipChange.ipc$dispatch("-2145532937", new Object[]{this});
        } else {
            fireEvent("rechargecallback");
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59899293")) {
            ipChange.ipc$dispatch("-59899293", new Object[]{this});
        } else {
            WeexHelper.getWidgetEngineInstance(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryCallback() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830596602")) {
            ipChange.ipc$dispatch("1830596602", new Object[]{this});
        } else {
            fireEvent("retrycallback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGiftCallback(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1131981215")) {
            ipChange.ipc$dispatch("1131981215", new Object[]{this, map});
        } else {
            fireEvent("sendgiftcallback", map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPropCallback(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1332656658")) {
            ipChange.ipc$dispatch("1332656658", new Object[]{this, map});
        } else {
            fireEvent("packsendcallback", map);
        }
    }

    @JSMethod
    public void addGoods(JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-643333951")) {
            ipChange.ipc$dispatch("-643333951", new Object[]{this, jSONObject, Integer.valueOf(i)});
        } else if (jSONObject == null || this.mYKLGiftBoardProtocol == null) {
        } else {
            this.mYKLGiftBoardProtocol.addPropItem(i, fetchPropJson(jSONObject));
        }
    }

    @JSMethod
    public void changeToGiftTab(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2073113782")) {
            ipChange.ipc$dispatch("2073113782", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.changeToGiftTab(i);
        }
    }

    @JSMethod
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269956911")) {
            ipChange.ipc$dispatch("269956911", new Object[]{this});
            return;
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.close();
        }
    }

    @JSMethod
    public void deleteGoods(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885231834")) {
            ipChange.ipc$dispatch("-1885231834", new Object[]{this, str});
            return;
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.deletePropItem(str);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IEngineInstance widgetEngineInstance;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1010219373")) {
            ipChange.ipc$dispatch("1010219373", new Object[]{this});
            return;
        }
        releaseWithNothing();
        super.destroy();
        if (this.mYKLGiftBoardProtocol != null) {
            if (this.useCache && (widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this)) != null) {
                widgetEngineInstance.recycleView(YKLGiftBoardProtocol.class.getName(), this.mYKLGiftBoardProtocol);
            }
            this.mYKLGiftBoardProtocol = null;
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IEngineInstance widgetEngineInstance;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135054685")) {
            return (View) ipChange.ipc$dispatch("1135054685", new Object[]{this, context});
        }
        if (this.useCache && (widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this)) != null) {
            Object pollRecycleView = widgetEngineInstance.pollRecycleView(YKLGiftBoardProtocol.class.getName());
            if (pollRecycleView instanceof YKLGiftBoardProtocol) {
                this.mYKLGiftBoardProtocol = (YKLGiftBoardProtocol) pollRecycleView;
            }
        }
        if (this.mYKLGiftBoardProtocol == null) {
            this.mYKLGiftBoardProtocol = getAdapter(context);
        }
        ((ILog) Dsl.getService(ILog.class)).w("liulei-giftboard", "initComponentHostView");
        initWithNothing();
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            return yKLGiftBoardProtocol.getView();
        }
        return null;
    }

    @JSMethod
    public void initPack(JSONArray jSONArray, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135823294")) {
            ipChange.ipc$dispatch("-135823294", new Object[]{this, jSONArray, jSCallback, jSCallback2});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "initPack");
        GiftDataManager.getInstance().getGiftPropList().clear();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    GiftDataManager.getInstance().getGiftPropList().add(fetchPropJson(jSONObject));
                }
            }
            if (jSCallback != null) {
                this.propCountdownCallback = jSCallback;
            }
        }
        this.mYKLGiftBoardProtocol.notifyPropDataChange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2081752851")) {
            ipChange.ipc$dispatch("2081752851", new Object[]{this, view});
            return;
        }
        super.onHostViewInitialized(view);
        ((ILog) Dsl.getService(ILog.class)).w("liulei-giftboard", "onHostViewInitialized");
        initAttrs();
    }

    @JSMethod
    public void open() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372776441")) {
            ipChange.ipc$dispatch("372776441", new Object[]{this});
            return;
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.open();
        }
    }

    @WXComponentProp(name = "coinurl")
    public void setCoinIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1395654907")) {
            ipChange.ipc$dispatch("-1395654907", new Object[]{this, str});
            return;
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setCoinIcon(str);
        }
    }

    @WXComponentProp(name = "coins")
    public void setCoins(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-190075955")) {
            ipChange.ipc$dispatch("-190075955", new Object[]{this, str});
            return;
        }
        this.coins = str;
        if (this.mYKLGiftBoardProtocol == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mYKLGiftBoardProtocol.setCoins(str);
    }

    @WXComponentProp(name = "continuetime")
    public void setComboIntervalTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1009906513")) {
            ipChange.ipc$dispatch("-1009906513", new Object[]{this, str});
            return;
        }
        this.countdownTime = str;
        if (this.mYKLGiftBoardProtocol == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mYKLGiftBoardProtocol.setCountdownTime(str);
    }

    @WXComponentProp(name = "firstrecharge")
    public void setFirstCharge(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1427532683")) {
            ipChange.ipc$dispatch("1427532683", new Object[]{this, str});
            return;
        }
        boolean equals = "1".equals(str);
        this.firstRecharge = equals;
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setFirstRecharge(equals);
        }
    }

    @WXComponentProp(name = "giftlist")
    public void setGiftList(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091913133")) {
            ipChange.ipc$dispatch("-2091913133", new Object[]{this, obj});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-gift", "refresh GIFT DATA");
        if (ConfigManager.q.equals(mj2.a("debug.laifeng.gift.test_gift_list")) && (obj == null || obj.equals("[]"))) {
            obj = TEST_GIFT_LIST;
        }
        if (obj != null) {
            List<GiftCategoryBean> cast2GiftList = cast2GiftList(obj);
            if (GiftDataManager.getInstance().getGiftCategoryList() != null) {
                GiftDataManager.getInstance().getGiftCategoryList().clear();
            }
            if (cast2GiftList != null && cast2GiftList.size() > 0 && GiftDataManager.getInstance().getGiftCategoryList() != null) {
                GiftDataManager.getInstance().getGiftCategoryList().addAll(cast2GiftList);
            }
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.notifyGiftDataChange();
        }
    }

    @WXComponentProp(name = "giftTrackStyle")
    public void setGiftStackStyle(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525022951")) {
            ipChange.ipc$dispatch("-525022951", new Object[]{this, map});
            return;
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setGiftTrackXY(map);
        }
    }

    @WXComponentProp(name = "ispack")
    public void setHasPack(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939924636")) {
            ipChange.ipc$dispatch("939924636", new Object[]{this, str});
            return;
        }
        boolean equals = "1".equals(str);
        this.hasPack = equals;
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setHasPack(equals);
        }
    }

    @WXComponentProp(name = "starGift")
    public void setHasStarGift(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383302989")) {
            ipChange.ipc$dispatch("-1383302989", new Object[]{this, str});
            return;
        }
        boolean equals = "1".equals(str);
        this.hasStarGift = equals;
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setStarGift(equals);
        }
    }

    @WXComponentProp(name = "packtabname")
    public void setPackTabName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1859514760")) {
            ipChange.ipc$dispatch("1859514760", new Object[]{this, str});
            return;
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setPackTabName(str);
        }
    }

    @WXComponentProp(name = "ispacktip")
    public void setPackTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599998477")) {
            ipChange.ipc$dispatch("599998477", new Object[]{this, str});
            return;
        }
        boolean equals = "1".equals(str);
        this.hasPackTip = equals;
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setHasPackTip(equals);
        }
    }

    @WXComponentProp(name = "line")
    public void setRowNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920929885")) {
            ipChange.ipc$dispatch("-1920929885", new Object[]{this, str});
            return;
        }
        this.rowNum = str;
        if (this.mYKLGiftBoardProtocol == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mYKLGiftBoardProtocol.setRowNum(this.rowNum);
    }

    @WXComponentProp(name = "mode")
    public void setScreenMode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919162528")) {
            ipChange.ipc$dispatch("919162528", new Object[]{this, str});
            return;
        }
        this.mode = str;
        if (this.mYKLGiftBoardProtocol == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mYKLGiftBoardProtocol.setLandscape("1".equals(str));
    }

    @WXComponentProp(name = "dgid")
    public void setSeletedGid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135645707")) {
            ipChange.ipc$dispatch("-135645707", new Object[]{this, str});
            return;
        }
        this.seletedGid = str;
        if (this.mYKLGiftBoardProtocol == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mYKLGiftBoardProtocol.setSelectGid(this.seletedGid);
    }

    @WXComponentProp(name = "dnum")
    public void setSeletedNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "284941489")) {
            ipChange.ipc$dispatch("284941489", new Object[]{this, str});
            return;
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setSelectNum(ParseUtils.parse2Int(str));
        }
    }

    @WXComponentProp(name = "dpid")
    public void setSeletedPid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738706484")) {
            ipChange.ipc$dispatch("-738706484", new Object[]{this, str});
            return;
        }
        this.seletedPid = str;
        if (this.mYKLGiftBoardProtocol == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mYKLGiftBoardProtocol.setSelectPid(this.seletedPid);
    }

    @WXComponentProp(name = "duid")
    public void setSeletedTid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006733496")) {
            ipChange.ipc$dispatch("-1006733496", new Object[]{this, str});
            return;
        }
        this.seletedTid = str;
        if (this.mYKLGiftBoardProtocol == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mYKLGiftBoardProtocol.setSelectTid(this.seletedTid);
    }

    @WXComponentProp(name = "showpack")
    public void setShowPack(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408499079")) {
            ipChange.ipc$dispatch("-1408499079", new Object[]{this, str});
            return;
        }
        boolean equals = "1".equals(str);
        this.showPack = equals;
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.setShowPack(equals);
        }
    }

    @WXComponentProp(name = "spm")
    public void setSpm(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2047232368")) {
            ipChange.ipc$dispatch("-2047232368", new Object[]{this, map});
            return;
        }
        GiftDataManager.getInstance().setSpm(null);
        GiftDataManager.getInstance().setSpm(map);
    }

    @WXComponentProp(name = "anchorlist")
    public void setTargetList(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206531310")) {
            ipChange.ipc$dispatch("-1206531310", new Object[]{this, obj});
            return;
        }
        if (obj != null) {
            List<GiftTargetInfoBean> cast2TargetList = cast2TargetList(obj);
            if (GiftDataManager.getInstance().getGiftTargetList() != null) {
                GiftDataManager.getInstance().getGiftTargetList().clear();
            }
            if (cast2TargetList != null && cast2TargetList.size() > 0 && GiftDataManager.getInstance().getGiftTargetList() != null) {
                GiftDataManager.getInstance().getGiftTargetList().addAll(cast2TargetList);
            }
        }
        YKLGiftBoardProtocol yKLGiftBoardProtocol = this.mYKLGiftBoardProtocol;
        if (yKLGiftBoardProtocol != null) {
            yKLGiftBoardProtocol.notifyTargetChange();
        }
    }

    @JSMethod
    public void updateGoods(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730149706")) {
            ipChange.ipc$dispatch("-1730149706", new Object[]{this, jSONObject});
        } else if (jSONObject == null || this.mYKLGiftBoardProtocol == null) {
        } else {
            this.mYKLGiftBoardProtocol.updatePropItem(fetchPropJson(jSONObject));
        }
    }

    private YKLGiftBoardProtocol getAdapter(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-693087177") ? (YKLGiftBoardProtocol) ipChange.ipc$dispatch("-693087177", new Object[]{this, context, str}) : (YKLGiftBoardProtocol) YKLAdapterFactory.getInstance().createInterface(YKLGiftBoardComponent.class, context, str, false);
    }

    public YKLGiftBoardComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mYKLGiftBoardProtocol = null;
        this.mode = "0";
        this.rowNum = "2";
        this.coins = "0";
        this.roomId = "0";
        this.seletedGid = null;
        this.seletedPid = null;
        this.seletedTid = null;
        this.countdownTime = "10";
        this.selectedNum = 1;
        this.hasPack = false;
        this.showPack = false;
        this.hasPackTip = false;
        this.hasStarGift = false;
        this.showTargetDetails = false;
        this.firstRecharge = false;
        this.hasMultipleTargets = true;
        this.isYouKu = false;
        this.starCoins = "0";
        this.uCoins = "0";
        this.theme = null;
        this.useCache = false;
        this.mIsInitialized = false;
    }

    public YKLGiftBoardComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mYKLGiftBoardProtocol = null;
        this.mode = "0";
        this.rowNum = "2";
        this.coins = "0";
        this.roomId = "0";
        this.seletedGid = null;
        this.seletedPid = null;
        this.seletedTid = null;
        this.countdownTime = "10";
        this.selectedNum = 1;
        this.hasPack = false;
        this.showPack = false;
        this.hasPackTip = false;
        this.hasStarGift = false;
        this.showTargetDetails = false;
        this.firstRecharge = false;
        this.hasMultipleTargets = true;
        this.isYouKu = false;
        this.starCoins = "0";
        this.uCoins = "0";
        this.theme = null;
        this.useCache = false;
        this.mIsInitialized = false;
    }

    public YKLGiftBoardComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
        this.mYKLGiftBoardProtocol = null;
        this.mode = "0";
        this.rowNum = "2";
        this.coins = "0";
        this.roomId = "0";
        this.seletedGid = null;
        this.seletedPid = null;
        this.seletedTid = null;
        this.countdownTime = "10";
        this.selectedNum = 1;
        this.hasPack = false;
        this.showPack = false;
        this.hasPackTip = false;
        this.hasStarGift = false;
        this.showTargetDetails = false;
        this.firstRecharge = false;
        this.hasMultipleTargets = true;
        this.isYouKu = false;
        this.starCoins = "0";
        this.uCoins = "0";
        this.theme = null;
        this.useCache = false;
        this.mIsInitialized = false;
    }
}
