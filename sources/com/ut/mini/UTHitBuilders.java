package com.ut.mini;

import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTConstants;
import java.util.HashMap;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.fd1;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTHitBuilders {
    private static final String TAG = "UTHitBuilders";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UTCustomHitBuilder extends UTHitBuilder {
        public UTCustomHitBuilder(String str) {
            if (!yh2.f(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "19999");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
            super.setProperty(RestConstants.LogContentKeys.PRIORITY, "4");
        }

        @Override // com.ut.mini.UTHitBuilders.UTHitBuilder
        public Map<String, String> build() {
            Map<String, String> build = super.build();
            if (build != null) {
                LogField logField = LogField.PAGE;
                String str = build.get(logField.toString());
                LogField logField2 = LogField.ARG1;
                String str2 = build.get(logField2.toString());
                if (str2 != null) {
                    build.remove(logField2.toString());
                    build.remove(logField.toString());
                    Map<String, String> c = fd1.c(build);
                    c.put(logField2.toString(), str2);
                    c.put(logField.toString(), str);
                    return c;
                }
                return build;
            }
            return build;
        }

        public UTCustomHitBuilder setDurationOnEvent(long j) {
            if (j < 0) {
                j = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + j);
            return this;
        }

        public UTCustomHitBuilder setEventPage(String str) {
            if (!yh2.f(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UTHitBuilder {
        public static final String FIELD_ARG1 = "_field_arg1";
        public static final String FIELD_ARG2 = "_field_arg2";
        public static final String FIELD_ARG3 = "_field_arg3";
        public static final String FIELD_ARGS = "_field_args";
        public static final String FIELD_EVENT_ID = "_field_event_id";
        public static final String FIELD_PAGE = "_field_page";
        private Map<String, String> mHitMap;

        public UTHitBuilder() {
            HashMap hashMap = new HashMap(64);
            this.mHitMap = hashMap;
            if (hashMap.containsKey(FIELD_PAGE)) {
                return;
            }
            this.mHitMap.put(FIELD_PAGE, BizTime.UT);
        }

        private static boolean _checkIlleagleProperty(Map<String, String> map) {
            if (map != null) {
                map.remove(null);
                map.remove("");
                if (map.containsKey(LogField.PAGE.toString())) {
                    Logger.i("checkIlleagleProperty", "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.EVENTID.toString())) {
                    Logger.i("checkIlleagleProperty", "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG1.toString())) {
                    Logger.i("checkIlleagleProperty", "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG2.toString())) {
                    Logger.i("checkIlleagleProperty", "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG3.toString())) {
                    Logger.i("checkIlleagleProperty", "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                }
            }
            return true;
        }

        private static void _dropAllIllegalFields(Map<String, String> map) {
            if (map != null) {
                map.remove(LogField.PAGE.toString());
                map.remove(LogField.EVENTID.toString());
                map.remove(LogField.ARG1.toString());
                map.remove(LogField.ARG2.toString());
                map.remove(LogField.ARG3.toString());
                map.remove(LogField.ARGS.toString());
            }
        }

        private static void _translateFieldsName(Map<String, String> map) {
            if (map != null) {
                String remove = map.remove(FIELD_PAGE);
                if (remove != null) {
                    map.put(LogField.PAGE.toString(), remove);
                }
                String remove2 = map.remove(FIELD_ARG1);
                if (remove2 != null) {
                    map.put(LogField.ARG1.toString(), remove2);
                }
                String remove3 = map.remove(FIELD_ARG2);
                if (remove3 != null) {
                    map.put(LogField.ARG2.toString(), remove3);
                }
                String remove4 = map.remove(FIELD_ARG3);
                if (remove4 != null) {
                    map.put(LogField.ARG3.toString(), remove4);
                }
                String remove5 = map.remove(FIELD_ARGS);
                if (remove5 != null) {
                    map.put(LogField.ARGS.toString(), remove5);
                }
                String remove6 = map.remove(FIELD_EVENT_ID);
                if (remove6 != null) {
                    map.put(LogField.EVENTID.toString(), remove6);
                }
            }
        }

        public Map<String, String> build() {
            Map<String, String> map = this.mHitMap;
            map.put(UTConstants.PrivateLogFields.FLAG_BUILD_MAP_BY_UT, BQCCameraParam.VALUE_YES);
            if (_checkIlleagleProperty(map)) {
                _dropAllIllegalFields(map);
                _translateFieldsName(map);
                if (map.containsKey(LogField.EVENTID.toString())) {
                    return map;
                }
                return null;
            }
            return null;
        }

        public String getProperty(String str) {
            if (str == null || !this.mHitMap.containsKey(str)) {
                return null;
            }
            return this.mHitMap.get(str);
        }

        public UTHitBuilder setProperties(Map<String, String> map) {
            if (map != null) {
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key instanceof String) {
                            if (value instanceof String) {
                                setProperty(key, value);
                            } else {
                                Logger.i(UTHitBuilders.TAG, "setProperties key", key, "value", value);
                            }
                        } else {
                            Logger.i(UTHitBuilders.TAG, "setProperties key", key, "value", value);
                        }
                    }
                } catch (Exception e) {
                    Logger.h(UTHitBuilders.TAG, e, new Object[0]);
                }
            }
            return this;
        }

        public UTHitBuilder setProperty(String str, String str2) {
            if (!yh2.f(str) && str2 != null) {
                this.mHitMap.put(str, str2);
            } else {
                Logger.i(UTHitBuilders.TAG, "setProperties key", str, "value", str2);
            }
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UTPageHitBuilder extends UTHitBuilder {
        public UTPageHitBuilder(String str) {
            if (!yh2.f(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2001");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        public UTPageHitBuilder setDurationOnPage(long j) {
            if (j < 0) {
                j = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + j);
            return this;
        }

        public UTPageHitBuilder setReferPage(String str) {
            if (!yh2.f(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UTControlHitBuilder extends UTHitBuilder {
        public UTControlHitBuilder(String str) {
            if (yh2.f(str)) {
                if (!AnalyticsMgr.r) {
                    Logger.i("Control name can not be empty.", new Object[0]);
                    return;
                }
                throw new IllegalArgumentException("Control name can not be empty.");
            }
            String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
            if (yh2.f(currentPageName)) {
                if (!AnalyticsMgr.r) {
                    Logger.i("Please call in at PageAppear and PageDisAppear.", new Object[0]);
                    return;
                }
                throw new IllegalArgumentException("Please call in at PageAppear and PageDisAppear.");
            }
            super.setProperty(UTHitBuilder.FIELD_PAGE, currentPageName);
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
            super.setProperty(UTHitBuilder.FIELD_ARG1, currentPageName + JSMethod.NOT_SET + str);
        }

        public UTControlHitBuilder(String str, String str2) {
            if (yh2.f(str2)) {
                if (!AnalyticsMgr.r) {
                    Logger.i("Control name can not be empty.", new Object[0]);
                    return;
                }
                throw new IllegalArgumentException("Control name can not be empty.");
            } else if (yh2.f(str)) {
                if (!AnalyticsMgr.r) {
                    Logger.i("Page name can not be empty.", new Object[0]);
                    return;
                }
                throw new IllegalArgumentException("Page name can not be empty.");
            } else {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
                super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
                super.setProperty(UTHitBuilder.FIELD_ARG1, str + JSMethod.NOT_SET + str2);
            }
        }
    }
}
