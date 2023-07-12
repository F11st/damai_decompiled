package android.taobao.windvane.config;

import android.net.Uri;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.runtimepermission.PermissionChecker;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVUrlMatchUtils {
    private static final String ACTION_CODE = "urlMatchFailed";
    private static final int ALARM_EVENT_ID = 65501;
    private static final String DEFAULT_API_GROUPS = "{\n\"Group_All\":[\"*\"],\n\"Group_None\":[]\n}";
    private static final String DEFAULT_URL_PATTERNS = "{\"//*.taobao.com\":\"1\",\"//*.tmall.com\":\"1\",\"//*.juhuasuan.com\":\"1\",\"//*.xiami.com\":\"1\",\"//*.amap.com\":\"1\",\"//*.taobaocdn.com\":\"1\",\"//*.alipay.com\":\"1\",\"//*.etao.com\":\"1\",\"//*.alibaba.com\":\"1\",\"//*.aliyun.com\":\"1\",\"//*.alimama.com\":\"1\",\"//*.weibo.com\":\"1\",\"//*.tanx.com\":\"1\",\"//*.laiwang.com\":\"1\",\"//*.alicdn.com\":\"1\",\"//*.mmstat.com\":\"1\",\"//*.yunos.com\":\"1\",\"//*.alibaba-inc.com\":\"1\",\"//*.alitrip.com\":\"1\",\"//*.aliloan.com\":\"1\",\"//*.kanbox.com\":\"1\",\"//*.wirlesshare.com\":\"1\",\"//*.dingtalk.com\":\"1\",\"//*.alimei.com\":\"1\",\"//*.cnzz.com\":\"1\",\"//*.kuaidadi.com\":\"1\",\"//*.autonavi.com\":\"1\",\"//*.m.yintai.com\":\"1\",\"//*.polyinno.com\":\"1\",\"//*.spdyidea.com\":\"1\",\"//*.h5util.com\":\"1\",\"//*.h5tool.com\":\"1\",\"//*.5945i.com\":\"1\",\"//*.miaostreet.com\":\"1\",\"//*.1688.com\":\"1\",\"//*.tb.cn\":\"1\",\"//*.tbcdn.cn\":\"1\",\"//*.weibo.cn\":\"1\",\"//*.mashort.cn\":\"1\",\"//*.uc.cn\":\"1\",\"//*.fastidea.me\":\"1\",\"//*.fastidea.cc\":\"1\",\"//*.juzone.me\":\"1\",\"//*.juzone.cc\":\"1\",\"//*.lwurl.to\":\"1\",\"//*.taobao.net\":\"1\",\"//*.yao.95095.com\":\"1\",\"//*.tmall.hk\":\"1\",\"//*.ahd.so\":\"1\",\"//*.atb.so\":\"1\",\"//*.mshare.cc\":\"1\",\"//*.juhs.me\":\"1\",\"//*.xianyu.mobi\":\"1\",\"//*.cainiao-inc.com\":\"1\",\"//*.cainiao.com\":\"1\",\"//*.taohua.com\":\"1\",\"//*.m.jiaoyimao.com\":\"1\",\"//*.mashangfangxin.com\":\"1\",\"//*.cainiao-inc.com\":\"1\",\"//*.im.alisoft.com\":\"1\",\"//*.100x100w.com\":\"1\",\"//*.koubei.com\":\"1\",\"//*.alibabausercontent.com\":\"1\",\"//*.hemaos.com\":\"1\",\"//*.jishi.rantu.com\":\"1\",\"//*.cdn.rantu.com\":\"1\",\"//*.ishuqi.com\":\"1\",\"//*.jishi.aligames.com\":\"1\",\"//*.aligames.com\":\"1\",\"//*.mp.dfkhgj.com\":\"1\",\"//*.mp.iuynfg.com\":\"1\",\"//*.mp.edcdfg.com\":\"1\",\"//*.mp.asczwa.com\":\"1\",\"//*.duanqu.com\":\"1\",\"//*.y.xevddy.com\":\"1\",\"//*.l.xevddy.com\":\"1\",\"//*.portalpro.hemaos.com\":\"1\",\"//*.liangxinyao.com\":\"1\",\"//*.taopiaopiao.com\":\"1\",\"//*.fliggy.com\":\"1\",\"//*.m.edcdfg.com\":\"1\",\"//*.feizhu.com\":\"1\",\"//*.youku.com\":\"1\",\"//*.mybank.cn\":\"1\",\"//*.alios.cn\":\"1\",\"//*.alihealth.cn\":\"1\",\"//*.xixi.fullspeed.cn\":\"1\",\"//*.image.9game.cn\":\"1\",\"//*.damai.cn\":\"1\",\"//*.feizhu.cn\":\"1\",\"//*.alpay.net\":\"1\",\"//*.cnzz.net\":\"1\",\"//*.fliggy.net\":\"1\",\"//*.feizhu.net\":\"1\",\"//*.tmall.net\":\"1\",\"//*.tdd.la\":\"1\",\"//*.tdd.la\":\"1\",\"//*.alipay.hk\":\"1\",\"//*.fliggy.hk\":\"1\",\"//*.ynuf.aliapp.org\":\"1\",\"//*.doctoryou.ai\":\"1\",\"//*.ele.me\":\"1\",\"//*.alipay.net\":\"1\",\"//*.wegame-web-daily.uc.test\":\"1\",\"//*.m.10010.com/queen/alitrip/alipay.html\":\"1\",\"//*.5317wan.com\":\"2\",\"//*.guahao.com\":\"2\",\"//*.wap.wandafilm.com\":\"2\",\"//*.wrating.com\":\"2\",\"//*.alipayobjects.com\":\"2\",\"//*.jmt.wxcsgd.com\":\"2\",\"//*.mpay.cx580.com\":\"2\",\"//*.mt.locojoy.com\":\"2\",\"//*.cpa1.locojoy.com\":\"2\",\"//*.miiee.com\":\"2\",\"//*.imaijia.com\":\"2\",\"//*.h5.edaijia.cn\":\"2\",\"//*.beta.library.sh.cn\":\"2\",\"//*.web.chelaile.net.cn\":\"2\",\"//*.app3.shmzj.gov.cn\":\"2\",\"//*.bsfw.qingdao.gov.cn\":\"2\",\"//*.www.hzpolice.gov.cn\":\"2\",\"//*.www.sxgajj.gov.cn\":\"2\",\"//*.service.zjzwfw.gov.cn\":\"2\",\"//*.people.com.cn\":\"2\",\"//*.hbjg.premier-tech.cn\":\"2\",\"//*.aliplay.net\":\"2\",\"//*.ali.hk515.net\":\"2\",\"//*.tmall.pp.cc\":\"2\"}";
    private static final String DEFAULT_URL_RULES = "{\"1\":{\"open\":\"allow\",\"api\":\"Group_All\",\"allowaccess\":\"false\"},\n\"2\":{\"open\":\"allow\",\"api\":\"Group_None\",\"allowaccess\":\"true\"},\n\"6\":{\"open\":\"forbidden\",\"api\":\"Group_None\",\"allowaccess\":\"false\"}\n}";
    private static final int FLAG_GRAVITY = -1;
    private static final int HOST_GRAVITY = 1000;
    private static final String MODULE_NAME = "WindVane";
    private static final int PATH_GRAVITY = 10;
    private static final String TAG = "URLMATCHER";
    private Map<String, JSONArray> apiGroupMap;
    private TireNode domainRoot;
    private boolean isLoadAppMonitor;
    private Map<String, Map<String, String>> urlRulesMap;
    private static final int[] DEFAULT_PORT = {80, 443};
    private static final String[] DEFAULT_SCHEME = {"http", "https", "taobao"};
    private static volatile WVUrlMatchUtils urlMatcher = null;
    private IUrlPermissionCheck mIUrlPermissionCheck = null;
    private IJsApiPermissionCheck mIJsApiPermissionCheck = null;
    private boolean customSetted = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class TireNode {
        public Map<String, TireNode> nodeMap;
        private String subField;
        private String group = null;
        private String scheme = null;
        private int port = -1;

        public TireNode(String str, Map<String, TireNode> map) {
            this.subField = str;
            this.nodeMap = map;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            this.nodeMap.clear();
        }

        public String getGroup() {
            return this.group;
        }

        public int getPort() {
            return this.port;
        }

        public String getScheme() {
            return this.scheme;
        }

        public void setGroup(String str) {
            this.group = str;
        }

        public void setPort(int i) {
            this.port = i;
        }

        public void setScheme(String str) {
            this.scheme = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class UrlParseRes {
        public String scheme = null;
        public String[] subHosts = null;
        public String[] subPaths = null;
        public int port = -1;

        UrlParseRes() {
        }
    }

    private WVUrlMatchUtils() {
        this.isLoadAppMonitor = false;
        try {
            this.isLoadAppMonitor = true;
        } catch (Exception e) {
            this.isLoadAppMonitor = false;
            TaoLog.e(TAG, "");
            e.printStackTrace();
        }
    }

    private int computeGravitySum(ArrayList<String> arrayList) {
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).equals(jn1.MUL) || arrayList.get(i2).equals(jn1.PLUS)) {
                i--;
            } else {
                if (arrayList.get(i2).equals("/")) {
                    z = true;
                }
                i = z ? i + 10 : i + 1000;
            }
        }
        return i;
    }

    public static WVUrlMatchUtils getInstance() {
        if (urlMatcher == null) {
            synchronized (WVUrlMatchUtils.class) {
                if (urlMatcher == null) {
                    urlMatcher = new WVUrlMatchUtils();
                    urlMatcher.urlMatcherConfig(DEFAULT_URL_PATTERNS, DEFAULT_URL_RULES, DEFAULT_API_GROUPS, false);
                }
            }
        }
        return urlMatcher;
    }

    private boolean insertToTrieTree(TireNode tireNode, UrlParseRes urlParseRes, String str) {
        String[] strArr;
        if (urlParseRes != null && (strArr = urlParseRes.subHosts) != null && strArr.length != 0) {
            for (String str2 : strArr) {
                String lowerCase = str2.toLowerCase();
                if (tireNode.nodeMap.containsKey(lowerCase)) {
                    tireNode = tireNode.nodeMap.get(lowerCase);
                } else {
                    TireNode tireNode2 = new TireNode(lowerCase, new HashMap());
                    tireNode.nodeMap.put(lowerCase, tireNode2);
                    tireNode = tireNode2;
                }
            }
            for (String str3 : urlParseRes.subPaths) {
                String lowerCase2 = str3.toLowerCase();
                if (tireNode.nodeMap.containsKey(lowerCase2)) {
                    tireNode = tireNode.nodeMap.get(lowerCase2);
                } else {
                    TireNode tireNode3 = new TireNode(lowerCase2, new HashMap());
                    tireNode.nodeMap.put(lowerCase2, tireNode3);
                    tireNode = tireNode3;
                }
            }
            tireNode.setGroup(str);
            tireNode.setScheme(urlParseRes.scheme);
            tireNode.setPort(urlParseRes.port);
            return true;
        }
        TaoLog.d(TAG, "insertToTrieTree: 插入节点有误，请检查配置！");
        return false;
    }

    private UrlParseRes parseUrl(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            TaoLog.d(TAG, "dropUrl: 输入的URL为空!!");
            return null;
        }
        UrlParseRes urlParseRes = new UrlParseRes();
        if (str.length() > 2 && str.substring(0, 2).equals(WVUtils.URL_SEPARATOR)) {
            str = new StringBuffer(DEFAULT_SCHEME[0] + ":" + str).toString();
        }
        try {
            uri = Uri.parse(str);
        } catch (Throwable th) {
            TaoLog.d(TAG, "parseUrl: 解析URL出现错误");
            th.printStackTrace();
            if (this.isLoadAppMonitor) {
                AppMonitor.Alarm.commitFail("WindVane", "urlMatchFailed", str, "6", "解析URL出现错误");
            }
            uri = null;
        }
        urlParseRes.scheme = uri.getScheme();
        if (!TextUtils.isEmpty(uri.getHost()) && uri.getPath() != null) {
            urlParseRes.subHosts = reverseStrArray(uri.getHost().split("\\."));
            String[] split = uri.getPath().split("/");
            urlParseRes.subPaths = split;
            if (split.length > 0 && TextUtils.equals("", split[0])) {
                urlParseRes.subPaths[0] = "/";
            }
            if (urlParseRes.subPaths.length == 0) {
                urlParseRes.subPaths = new String[]{"/"};
            }
            urlParseRes.port = uri.getPort() == -1 ? DEFAULT_PORT[0] : uri.getPort();
            return urlParseRes;
        }
        TaoLog.d(TAG, "parseUrl: 输入的URL不符合规范");
        if (this.isLoadAppMonitor) {
            AppMonitor.Alarm.commitFail("WindVane", "urlMatchFailed", str, "7", "解析URL出现错误");
        }
        return null;
    }

    public static String[] reverseStrArray(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            int i = 0;
            for (int length = strArr.length - 1; i < length; length--) {
                String str = strArr[i];
                strArr[i] = strArr[length];
                strArr[length] = str;
                i++;
            }
            return strArr;
        }
        TaoLog.d(TAG, "reverseStrArray:输入参数为空");
        return null;
    }

    private String reverseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            TaoLog.d(TAG, "reverseUrl: 输入的URL为空");
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                StringBuffer stringBuffer = new StringBuffer(str.substring(0, i));
                stringBuffer.reverse().append(str.substring(i));
                return stringBuffer.toString();
            }
        }
        return new StringBuffer(str).reverse().toString();
    }

    private void travelTree(UrlParseRes urlParseRes, boolean z, TireNode tireNode, ArrayList<String> arrayList, int i, Map<ArrayList<String>, String> map) {
        boolean z2;
        boolean z3;
        int length;
        boolean z4;
        int length2;
        int i2;
        int i3 = i;
        if (urlParseRes == null || tireNode == null) {
            return;
        }
        if (tireNode.subField != null && z) {
            if (i3 == urlParseRes.subPaths.length) {
                if (tireNode.group != null && checkSchemeAndPort(urlParseRes, tireNode)) {
                    map.put(new ArrayList<>(arrayList), tireNode.group);
                }
                Map<String, TireNode> map2 = tireNode.nodeMap;
                if (map2 == null || !map2.containsKey(jn1.MUL) || tireNode.nodeMap.get(jn1.MUL).group == null || !checkSchemeAndPort(urlParseRes, tireNode.nodeMap.get(jn1.MUL))) {
                    return;
                }
                arrayList.add(jn1.MUL);
                map.put(new ArrayList<>(arrayList), tireNode.nodeMap.get(jn1.MUL).group);
                arrayList.remove(jn1.MUL);
                return;
            } else if (TextUtils.equals(tireNode.subField, "/") && tireNode.group != null && checkSchemeAndPort(urlParseRes, tireNode)) {
                map.put(new ArrayList<>(arrayList), tireNode.group);
            }
        }
        String lowerCase = (z ? urlParseRes.subPaths[i3] : urlParseRes.subHosts[i3]).toLowerCase();
        if (tireNode.nodeMap.containsKey(lowerCase)) {
            int i4 = i3 + 1;
            arrayList.add(lowerCase);
            if (z || i4 != urlParseRes.subHosts.length) {
                z2 = z;
                i2 = i4;
            } else {
                z2 = true;
                i2 = 0;
            }
            travelTree(urlParseRes, z2, tireNode.nodeMap.get(lowerCase), arrayList, i2, map);
            int i5 = i2 - 1;
            if (i5 < 0) {
                i3 = urlParseRes.subHosts.length - 1;
                z2 = false;
            } else {
                i3 = i5;
            }
            arrayList.remove(lowerCase);
        } else {
            z2 = z;
        }
        int i6 = i3;
        if (tireNode.nodeMap.containsKey(jn1.PLUS)) {
            if (z2) {
                z4 = z2;
                length2 = urlParseRes.subPaths.length;
            } else {
                length2 = 0;
                z4 = true;
            }
            arrayList.add(jn1.PLUS);
            travelTree(urlParseRes, z4, tireNode.nodeMap.get(jn1.PLUS), arrayList, length2, map);
            arrayList.remove(jn1.PLUS);
            if (length2 == 0) {
                z4 = false;
            }
            z3 = z4;
        } else {
            z3 = z2;
        }
        if (tireNode.nodeMap.containsKey(jn1.MUL)) {
            if (z3 && i6 == 0 && TextUtils.equals(lowerCase, "/")) {
                arrayList.add(jn1.MUL);
                travelTree(urlParseRes, z3, tireNode.nodeMap.get(jn1.MUL), arrayList, i6, map);
                arrayList.remove(jn1.MUL);
                return;
            }
            if (z3) {
                length = urlParseRes.subPaths.length;
            } else {
                z3 = true;
                length = 0;
            }
            arrayList.add(jn1.MUL);
            travelTree(urlParseRes, z3, tireNode.nodeMap.get(jn1.MUL), arrayList, length, map);
            arrayList.remove(jn1.MUL);
        }
    }

    public boolean checkJsApiPermission(String str, String str2, String str3) {
        String string;
        IJsApiPermissionCheck iJsApiPermissionCheck = this.mIJsApiPermissionCheck;
        if (iJsApiPermissionCheck != null) {
            return iJsApiPermissionCheck.checkJsApiPermission(str, str2, str3);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Map<String, JSONArray> map = this.apiGroupMap;
            if (map != null && !map.isEmpty()) {
                String urlPermissionInfo = getUrlPermissionInfo(str, "api");
                if (TextUtils.isEmpty(urlPermissionInfo)) {
                    TaoLog.d(TAG, "checkApiPermission: 未能正确获取api权限组");
                    return false;
                }
                JSONArray jSONArray = this.apiGroupMap.get(urlPermissionInfo);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            string = jSONArray.getString(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (jn1.MUL.equals(string)) {
                            return true;
                        }
                        int indexOf = string.indexOf(46);
                        if (indexOf > 0 && string.substring(0, indexOf).equals(str2)) {
                            int i2 = indexOf + 1;
                            if (jn1.MUL.equals(string.substring(i2)) || str3.equals(string.substring(i2))) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            TaoLog.e(TAG, "checkApiPermission: apiGroup配置不应为空!");
            return false;
        }
        TaoLog.e(TAG, "checkApiPermission: 输入参数为空!");
        return false;
    }

    boolean checkSchemeAndPort(UrlParseRes urlParseRes, TireNode tireNode) {
        boolean z;
        boolean z2;
        if (urlParseRes == null || tireNode == null) {
            return false;
        }
        String scheme = tireNode.getScheme();
        String[] strArr = DEFAULT_SCHEME;
        if (TextUtils.equals(scheme, strArr[0])) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = false;
                    break;
                } else if (TextUtils.equals(strArr[i], urlParseRes.scheme)) {
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z2) {
                return false;
            }
        } else if (!TextUtils.equals(urlParseRes.scheme, tireNode.getScheme())) {
            return false;
        }
        int port = tireNode.getPort();
        int[] iArr = DEFAULT_PORT;
        if (port == iArr[0]) {
            int length2 = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = false;
                    break;
                } else if (iArr[i2] == urlParseRes.port) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                return false;
            }
        } else if (urlParseRes.port != tireNode.getPort()) {
            return false;
        }
        return true;
    }

    public String getUrlPermissionInfo(String str, String str2) {
        IUrlPermissionCheck iUrlPermissionCheck = this.mIUrlPermissionCheck;
        if (iUrlPermissionCheck != null) {
            return iUrlPermissionCheck.getUrlPermissionInfo(str, str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            TireNode tireNode = this.domainRoot;
            if (tireNode != null && !tireNode.nodeMap.isEmpty()) {
                Map<String, Map<String, String>> map = this.urlRulesMap;
                if (map != null && !map.isEmpty()) {
                    if (TextUtils.equals(str2, "open") && (str.startsWith("javascript:") || str.startsWith("about:"))) {
                        return PermissionChecker.PERMISSION_ALLOW;
                    }
                    try {
                        String searchUrlForGroup = searchUrlForGroup(str);
                        if (TextUtils.isEmpty(searchUrlForGroup)) {
                            TaoLog.d(TAG, "getUrlPermissionInfo: 该url未在配置内，禁止访问!");
                            return null;
                        }
                        Map<String, String> map2 = this.urlRulesMap.get(searchUrlForGroup);
                        if (map2 != null && !map2.isEmpty()) {
                            String str3 = map2.get(str2);
                            if (TextUtils.isEmpty(str3)) {
                                TaoLog.e(TAG, "getUrlPermissionInfo: 未在权限组:" + searchUrlForGroup + " 中找到权限:" + str2 + "的配置");
                                return null;
                            }
                            return str3;
                        }
                        TaoLog.e(TAG, "getUrlPermissionInfo: 未能找到权限组:" + searchUrlForGroup + " 的配置,请检查配置!");
                        return null;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (TextUtils.equals(str2, "open")) {
                            TaoLog.e(TAG, "获取open权限时，出现匹配错误，已允许该URL打开，url:" + str);
                            if (this.isLoadAppMonitor) {
                                AppMonitor.Alarm.commitFail("WindVane", "urlMatchFailed", str, "4", "获取open权限时，出现匹配错误，已允许该URL打开");
                            }
                            return PermissionChecker.PERMISSION_ALLOW;
                        }
                        TaoLog.e(TAG, "获取" + str2 + "权限时出现错误，url:" + str);
                        if (this.isLoadAppMonitor) {
                            AppMonitor.Alarm.commitFail("WindVane", "urlMatchFailed", str, "5", "获取" + str2 + "权限时，出现匹配错误");
                        }
                        return null;
                    }
                }
                TaoLog.e(TAG, "getUrlPermissionInfo: urlRules配置不应为空!");
                return null;
            }
            TaoLog.e(TAG, "getUrlPermissionInfo: URL配置不应为空!");
            return null;
        }
        TaoLog.d(TAG, "getUrlPermissionInfo: 输入参数为空!");
        return null;
    }

    public boolean isAllowAllOpen(String str) {
        return "allowAll".equalsIgnoreCase(getInstance().getUrlPermissionInfo(str, "open"));
    }

    public boolean isAllowOpen(String str) {
        return PermissionChecker.PERMISSION_ALLOW.equalsIgnoreCase(getInstance().getUrlPermissionInfo(str, "open"));
    }

    public boolean isBrowserOpen(String str) {
        String urlPermissionInfo = getInstance().getUrlPermissionInfo(str, "open");
        return (PermissionChecker.PERMISSION_ALLOW.equalsIgnoreCase(urlPermissionInfo) || "allowAll".equalsIgnoreCase(urlPermissionInfo) || "forbidden".equalsIgnoreCase(urlPermissionInfo)) ? false : true;
    }

    public boolean isForbiddenOpen(String str) {
        return "forbidden".equalsIgnoreCase(getInstance().getUrlPermissionInfo(str, "open"));
    }

    public void resetConfig() {
        urlMatcher.urlMatcherConfig(DEFAULT_URL_PATTERNS, DEFAULT_URL_RULES, DEFAULT_API_GROUPS, true);
    }

    public String searchUrl(String str) {
        Map<String, TireNode> map;
        int i;
        if (TextUtils.isEmpty(str)) {
            TaoLog.e(TAG, "searchUrl: 输入的URL不应为空！");
            return null;
        }
        TireNode tireNode = this.domainRoot;
        if (tireNode != null && (map = tireNode.nodeMap) != null && !map.isEmpty()) {
            UrlParseRes parseUrl = parseUrl(str);
            TireNode tireNode2 = this.domainRoot;
            int i2 = 0;
            while (true) {
                String[] strArr = parseUrl.subHosts;
                if (i2 < strArr.length) {
                    TireNode tireNode3 = tireNode2.nodeMap.get(strArr[i2]);
                    if (tireNode3 == null) {
                        if (tireNode2.nodeMap.containsKey(jn1.MUL)) {
                            tireNode2 = tireNode2.nodeMap.get(jn1.MUL);
                            i2 = parseUrl.subHosts.length;
                        } else if (!tireNode2.nodeMap.containsKey(jn1.PLUS)) {
                            break;
                        } else {
                            tireNode2 = tireNode2.nodeMap.get(jn1.PLUS);
                            i2 = parseUrl.subHosts.length;
                        }
                    } else {
                        i2++;
                        tireNode2 = tireNode3;
                    }
                } else {
                    break;
                }
            }
            if (i2 < parseUrl.subHosts.length) {
                return null;
            }
            if (!tireNode2.nodeMap.containsKey("/") && tireNode2.nodeMap.containsKey(jn1.MUL)) {
                tireNode2 = tireNode2.nodeMap.get(jn1.MUL);
            }
            int i3 = 0;
            while (true) {
                String[] strArr2 = parseUrl.subPaths;
                if (i3 < strArr2.length) {
                    TireNode tireNode4 = tireNode2.nodeMap.get(strArr2[i3]);
                    if (tireNode4 == null) {
                        if (tireNode2.nodeMap.containsKey(jn1.MUL)) {
                            tireNode2 = tireNode2.nodeMap.get(jn1.MUL);
                            i3 = parseUrl.subPaths.length;
                        } else if (!tireNode2.nodeMap.containsKey(jn1.PLUS)) {
                            if (!tireNode2.subField.equals("/") || tireNode2.group == null) {
                                break;
                            }
                            i3 = parseUrl.subPaths.length;
                        } else {
                            tireNode2 = tireNode2.nodeMap.get(jn1.PLUS);
                            i3 = parseUrl.subPaths.length;
                        }
                    } else {
                        i3++;
                        tireNode2 = tireNode4;
                    }
                } else {
                    break;
                }
            }
            if (i3 < parseUrl.subPaths.length) {
                return null;
            }
            if (tireNode2.group == null && tireNode2.nodeMap.containsKey(jn1.MUL)) {
                tireNode2 = tireNode2.nodeMap.get(jn1.MUL);
            }
            String scheme = tireNode2.getScheme();
            String[] strArr3 = DEFAULT_SCHEME;
            if (TextUtils.equals(scheme, strArr3[0])) {
                if (!TextUtils.equals(parseUrl.scheme, strArr3[0]) && !TextUtils.equals(parseUrl.scheme, strArr3[1])) {
                    return null;
                }
            } else if (!TextUtils.equals(parseUrl.scheme, tireNode2.getScheme())) {
                return null;
            }
            int port = tireNode2.getPort();
            int[] iArr = DEFAULT_PORT;
            if (port != iArr[0] || (((i = parseUrl.port) == iArr[0] || i == iArr[1]) && i == tireNode2.getPort())) {
                return tireNode2.group;
            }
            return null;
        }
        TaoLog.e(TAG, "searchUrl: URL配置不应为空！");
        return null;
    }

    public String searchUrlForGroup(String str) {
        Map<String, TireNode> map;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            TaoLog.e(TAG, "searchUrlForGroup: 输入的URL不应为空！");
            return null;
        }
        TireNode tireNode = this.domainRoot;
        if (tireNode != null && (map = tireNode.nodeMap) != null && !map.isEmpty()) {
            UrlParseRes parseUrl = parseUrl(str);
            if (parseUrl == null) {
                TaoLog.e(TAG, "searchUrlForGroup: URL解析失败，URL配置错误，请检查是否输入为js！");
                return null;
            }
            TireNode tireNode2 = this.domainRoot;
            ArrayList<String> arrayList = new ArrayList<>();
            HashMap hashMap = new HashMap();
            travelTree(parseUrl, false, tireNode2, arrayList, 0, hashMap);
            int i = -1;
            for (Map.Entry<ArrayList<String>, String> entry : hashMap.entrySet()) {
                int computeGravitySum = computeGravitySum(entry.getKey());
                if (computeGravitySum > i) {
                    str2 = entry.getValue();
                    i = computeGravitySum;
                }
            }
            return str2;
        }
        TaoLog.e(TAG, "searchUrlForGroup: URL配置不应为空！");
        return null;
    }

    public void setApiGroup(String str) {
        if (TextUtils.isEmpty(str)) {
            TaoLog.e(TAG, "setApiGroup: 输入参数为空");
            return;
        }
        try {
            this.apiGroupMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.apiGroupMap.put(next, optJSONArray);
                }
                TaoLog.d(TAG, "setApiGroup: 未能正确获取api组:" + next + ",请检查配置");
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "setApiGroupMap: 发生异常! " + e);
            e.printStackTrace();
            if (this.isLoadAppMonitor) {
                AppMonitor.Alarm.commitFail("WindVane", "urlMatchFailed", null, "3", "配置错误");
            }
        }
    }

    public void setJsApiPermissionCheck(IJsApiPermissionCheck iJsApiPermissionCheck) {
        this.mIJsApiPermissionCheck = iJsApiPermissionCheck;
    }

    public void setUrlPatterns(String str) {
        if (TextUtils.isEmpty(str)) {
            TaoLog.e(TAG, "setUrlPatterns: 输入配置为空");
            return;
        }
        try {
            this.domainRoot = new TireNode("", new HashMap());
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next, "");
                if (TextUtils.isEmpty(optString)) {
                    TaoLog.d(TAG, "setUrlPatterns: 未能正确获取URL:" + next + "的权限组，请检查配置");
                } else {
                    if (!insertToTrieTree(this.domainRoot, parseUrl(next), optString)) {
                        TaoLog.e(TAG, "setUrlPatterns: URL insert error! url is:" + next);
                    }
                }
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "setUrlPatterns: catch a exception!");
            e.printStackTrace();
            if (this.isLoadAppMonitor) {
                AppMonitor.Alarm.commitFail("WindVane", "urlMatchFailed", null, "1", "配置错误");
            }
        }
    }

    public void setUrlPermissionCheck(IUrlPermissionCheck iUrlPermissionCheck) {
        this.mIUrlPermissionCheck = iUrlPermissionCheck;
    }

    public void setUrlRulesMap(String str) {
        if (TextUtils.isEmpty(str)) {
            TaoLog.e(TAG, "setUrlRulesMap: 输入参数为空!");
            return;
        }
        try {
            this.urlRulesMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next, "");
                if (TextUtils.isEmpty(optString)) {
                    TaoLog.d(TAG, "setUrlRulesMap: 未能正确获取权限组:" + next + "的权限,请检查配置");
                } else {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String optString2 = jSONObject2.optString(next2);
                        if (TextUtils.isEmpty(optString2)) {
                            TaoLog.d(TAG, "setUrlRulesMap: 未能正确获取权限:" + next2 + "的值,请检查配置");
                        } else {
                            hashMap.put(next2, optString2);
                        }
                    }
                    this.urlRulesMap.put(next, hashMap);
                }
            }
        } catch (Exception e) {
            TaoLog.d(TAG, "setUrlRulesMap: 配置发生异常!");
            e.printStackTrace();
            AppMonitor.Alarm.commitFail("WindVane", "urlMatchFailed", null, "2", "配置错误");
        }
    }

    public void urlMatcherConfig(String str, String str2, String str3, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (z) {
                this.customSetted = true;
            } else if (this.customSetted) {
                return;
            }
            setUrlPatterns(str);
            setUrlRulesMap(str2);
            setApiGroup(str3);
            return;
        }
        TaoLog.e(TAG, "urlMatcherConfig: 输入参数为空!");
    }

    public void urlMatcherConfig(String str, String str2, String str3) {
        urlMatcherConfig(str, str2, str3, true);
    }
}
