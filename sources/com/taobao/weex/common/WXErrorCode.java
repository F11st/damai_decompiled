package com.taobao.weex.common;

import cn.damai.launcher.utils.SplashXFlushHelper;
import com.taobao.weex.ui.module.WXDomModule;
import tb.fw0;
import tb.gz0;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum WX_ERR_LOAD_SO uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class WXErrorCode {
    private static final /* synthetic */ WXErrorCode[] $VALUES;
    public static final WXErrorCode WHITE_SCREEN_REBOOT_EXCEED_LIMIT;
    public static final WXErrorCode WHITE_SCREEN_RESPONSE_TIMEOUT;
    public static final WXErrorCode WX_DEGRAD_EAGLE_RENDER_ERROR;
    public static final WXErrorCode WX_DEGRAD_ERR;
    public static final WXErrorCode WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR;
    public static final WXErrorCode WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED;
    public static final WXErrorCode WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED_JS;
    public static final WXErrorCode WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED;
    public static final WXErrorCode WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED;
    public static final WXErrorCode WX_DEGRAD_ERR_OTHER_CAUSE_DEGRADTOH5;
    public static final WXErrorCode WX_ERROR_DOM_CREATEFINISH;
    public static final WXErrorCode WX_ERROR_DOM_REFRESHFINISH;
    public static final WXErrorCode WX_ERROR_WHITE_SCREEN;
    public static final WXErrorCode WX_ERR_BAD_SO;
    public static final WXErrorCode WX_ERR_COPY_FROM_APK;
    public static final WXErrorCode WX_ERR_DOM_ADDELEMENT;
    public static final WXErrorCode WX_ERR_DOM_ADDEVENT;
    public static final WXErrorCode WX_ERR_DOM_CREATEBODY;
    public static final WXErrorCode WX_ERR_DOM_MOVEELEMENT;
    public static final WXErrorCode WX_ERR_DOM_REMOVEELEMENT;
    public static final WXErrorCode WX_ERR_DOM_REMOVEEVENT;
    public static final WXErrorCode WX_ERR_DOM_SCROLLTO;
    public static final WXErrorCode WX_ERR_DOM_UPDATEATTRS;
    public static final WXErrorCode WX_ERR_DOM_UPDATESTYLE;
    public static final WXErrorCode WX_ERR_FIRST_DOM_ACTION_EXCEPTION;
    public static final WXErrorCode WX_ERR_HASH_MAP_TMP;
    public static final WXErrorCode WX_ERR_INVOKE_NATIVE;
    public static final WXErrorCode WX_ERR_JSBUNDLE_DOWNLOAD;
    public static final WXErrorCode WX_ERR_JSBUNDLE_EMPTY;
    public static final WXErrorCode WX_ERR_JSC_CRASH;
    public static final WXErrorCode WX_ERR_JSDOWNLOAD_END;
    public static final WXErrorCode WX_ERR_JSDOWNLOAD_START;
    public static final WXErrorCode WX_ERR_JSFUNC_PARAM;
    public static final WXErrorCode WX_ERR_JSON_OBJECT;
    public static final WXErrorCode WX_ERR_JS_EXECUTE;
    public static final WXErrorCode WX_ERR_JS_FRAMEWORK;
    public static final WXErrorCode WX_ERR_JS_REINIT_FRAMEWORK;
    public static final WXErrorCode WX_ERR_LOAD_JSLIB;
    public static final WXErrorCode WX_ERR_LOAD_SO;
    public static final WXErrorCode WX_ERR_RELOAD_PAGE;
    public static final WXErrorCode WX_ERR_RELOAD_PAGE_EXCEED_LIMIT;
    public static final WXErrorCode WX_ERR_SINGLE_PROCESS_DLOPEN_FILE_NOT_EXIST;
    public static final WXErrorCode WX_ERR_SINGLE_PROCESS_DLOPEN_FLAIED;
    public static final WXErrorCode WX_ERR_SINGLE_PROCESS_DLSYM_FAILED;
    public static final WXErrorCode WX_ERR_SINGLE_PROCESS_JS_FRAMEWORK;
    public static final WXErrorCode WX_ERR_TEST;
    public static final WXErrorCode WX_JS_FRAMEWORK_INIT_FAILED;
    public static final WXErrorCode WX_JS_FRAMEWORK_INIT_FAILED_FIND_ICU_TIMEOUT;
    public static final WXErrorCode WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL;
    public static final WXErrorCode WX_JS_FRAMEWORK_INIT_MULPROCESS_FAILED;
    public static final WXErrorCode WX_JS_FRAMEWORK_INIT_SINGLE_PROCESS_SUCCESS;
    public static final WXErrorCode WX_JS_FRAMEWORK_INIT_SUCCESS;
    public static final WXErrorCode WX_JS_FRAMEWORK_REINIT_MULPROCESS_FAILED;
    public static final WXErrorCode WX_JS_FRAMEWORK_REINIT_SUCCESS;
    public static final WXErrorCode WX_KEY_EXCEPTION_HERON;
    public static final WXErrorCode WX_KEY_EXCEPTION_HERON_RENDER;
    public static final WXErrorCode WX_KEY_EXCEPTION_INVOKE_BRIDGE;
    public static final WXErrorCode WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE;
    public static final WXErrorCode WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT;
    public static final WXErrorCode WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED;
    public static final WXErrorCode WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES;
    public static final WXErrorCode WX_KEY_EXCEPTION_JS_DOWNLOAD;
    public static final WXErrorCode WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED;
    public static final WXErrorCode WX_KEY_EXCEPTION_NO_BUNDLE_TYPE;
    public static final WXErrorCode WX_KEY_EXCEPTION_SDK_INIT;
    public static final WXErrorCode WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT;
    public static final WXErrorCode WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED;
    public static final WXErrorCode WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT;
    public static final WXErrorCode WX_KEY_EXCEPTION_WXBRIDGE;
    public static final WXErrorCode WX_KEY_EXCEPTION_WXBRIDGE_EXCEPTION;
    public static final WXErrorCode WX_RENDER_ERR_BRIDGE_ARG_NULL;
    public static final WXErrorCode WX_RENDER_ERR_CALL_NATIVE_MODULE;
    public static final WXErrorCode WX_RENDER_ERR_COMPONENT_ATTR_KEY;
    public static final WXErrorCode WX_RENDER_ERR_COMPONENT_NOT_REGISTER;
    public static final WXErrorCode WX_RENDER_ERR_CONTAINER_TYPE;
    public static final WXErrorCode WX_RENDER_ERR_INSTANCE_ID_NULL;
    public static final WXErrorCode WX_RENDER_ERR_JS_CREATE_INSTANCE;
    public static final WXErrorCode WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT;
    public static final WXErrorCode WX_RENDER_ERR_LAYER_OVERFLOW;
    public static final WXErrorCode WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT;
    public static final WXErrorCode WX_RENDER_ERR_NATIVE_RUNTIME;
    public static final WXErrorCode WX_RENDER_ERR_NULL_KEY;
    public static final WXErrorCode WX_RENDER_ERR_TEXTURE_SETBACKGROUND;
    public static final WXErrorCode WX_RENDER_ERR_TRANSITION;
    public static final WXErrorCode WX_RENDER_WAR_GPU_LIMIT_LAYOUT;
    public static final WXErrorCode WX_SUCCESS;
    private String appendMsg = "";
    private String args;
    private String errorCode;
    private String errorMsg;
    private ErrorGroup mErrorGroup;
    private ErrorType mErrorType;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ErrorGroup {
        JS,
        NATIVE
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ErrorType {
        JS_ERROR,
        NATIVE_ERROR,
        RENDER_ERROR,
        DEGRAD_ERROR,
        DOWN_LOAD_ERROR
    }

    static {
        ErrorType errorType = ErrorType.NATIVE_ERROR;
        ErrorGroup errorGroup = ErrorGroup.NATIVE;
        WXErrorCode wXErrorCode = new WXErrorCode("WX_ERR_LOAD_SO", 0, fw0.LOGIN_ALIPAY_FAILED_CODE, "load so error", errorType, errorGroup);
        WX_ERR_LOAD_SO = wXErrorCode;
        WXErrorCode wXErrorCode2 = new WXErrorCode("WX_ERR_LOAD_JSLIB", 1, fw0.LOGIN_TAOBAO_FAILED_CODE, "unzip JSLib error!", errorType, errorGroup);
        WX_ERR_LOAD_JSLIB = wXErrorCode2;
        WXErrorCode wXErrorCode3 = new WXErrorCode("WX_ERR_BAD_SO", 2, fw0.LOGIN_WEIBO_FAILED_CODE, "so size error, to reload apk so", errorType, errorGroup);
        WX_ERR_BAD_SO = wXErrorCode3;
        WXErrorCode wXErrorCode4 = new WXErrorCode("WX_ERR_COPY_FROM_APK", 3, fw0.LOGIN_YOUKU_FAILED_CODE, "system load so error，copy from APK also error!", errorType, errorGroup);
        WX_ERR_COPY_FROM_APK = wXErrorCode4;
        WXErrorCode wXErrorCode5 = new WXErrorCode("WX_ERR_JSFUNC_PARAM", 4, "-2009", "JS params error!", errorType, errorGroup);
        WX_ERR_JSFUNC_PARAM = wXErrorCode5;
        WXErrorCode wXErrorCode6 = new WXErrorCode("WX_ERR_JSON_OBJECT", 5, "-2008", "transform JSON->OBJ  error!", errorType, errorGroup);
        WX_ERR_JSON_OBJECT = wXErrorCode6;
        WXErrorCode wXErrorCode7 = new WXErrorCode("WX_ERR_INVOKE_NATIVE", 6, "-2012", "Native-> Call ->JS  error!", errorType, errorGroup);
        WX_ERR_INVOKE_NATIVE = wXErrorCode7;
        ErrorType errorType2 = ErrorType.JS_ERROR;
        ErrorGroup errorGroup2 = ErrorGroup.JS;
        WXErrorCode wXErrorCode8 = new WXErrorCode("WX_ERR_JS_EXECUTE", 7, "-2013", "JavaScript execute error!", errorType2, errorGroup2);
        WX_ERR_JS_EXECUTE = wXErrorCode8;
        WXErrorCode wXErrorCode9 = new WXErrorCode("WX_SUCCESS", 8, "0", "successful", errorType, errorGroup);
        WX_SUCCESS = wXErrorCode9;
        WXErrorCode wXErrorCode10 = new WXErrorCode("WX_ERR_DOM_CREATEBODY", 9, "-2100", "createBody error", errorType, errorGroup);
        WX_ERR_DOM_CREATEBODY = wXErrorCode10;
        WXErrorCode wXErrorCode11 = new WXErrorCode("WX_ERR_DOM_UPDATEATTRS", 10, "-2101", "updateAttrs error", errorType, errorGroup);
        WX_ERR_DOM_UPDATEATTRS = wXErrorCode11;
        WXErrorCode wXErrorCode12 = new WXErrorCode("WX_ERR_DOM_UPDATESTYLE", 11, "-2102", "updateStyle error", errorType, errorGroup);
        WX_ERR_DOM_UPDATESTYLE = wXErrorCode12;
        WXErrorCode wXErrorCode13 = new WXErrorCode("WX_ERR_DOM_ADDELEMENT", 12, "-2103", "addElement error", errorType, errorGroup);
        WX_ERR_DOM_ADDELEMENT = wXErrorCode13;
        WXErrorCode wXErrorCode14 = new WXErrorCode("WX_ERR_DOM_REMOVEELEMENT", 13, "-2104", "removeElement error", errorType, errorGroup);
        WX_ERR_DOM_REMOVEELEMENT = wXErrorCode14;
        WXErrorCode wXErrorCode15 = new WXErrorCode("WX_ERR_DOM_MOVEELEMENT", 14, "-2105", "moveElement error", errorType, errorGroup);
        WX_ERR_DOM_MOVEELEMENT = wXErrorCode15;
        WXErrorCode wXErrorCode16 = new WXErrorCode("WX_ERR_DOM_ADDEVENT", 15, "-2106", "addEvent error", errorType, errorGroup);
        WX_ERR_DOM_ADDEVENT = wXErrorCode16;
        WXErrorCode wXErrorCode17 = new WXErrorCode("WX_ERR_DOM_REMOVEEVENT", 16, "-2107", "removeEvent error", errorType, errorGroup);
        WX_ERR_DOM_REMOVEEVENT = wXErrorCode17;
        WXErrorCode wXErrorCode18 = new WXErrorCode("WX_ERROR_DOM_CREATEFINISH", 17, "-2108", "createFinish error", errorType, errorGroup);
        WX_ERROR_DOM_CREATEFINISH = wXErrorCode18;
        WXErrorCode wXErrorCode19 = new WXErrorCode("WX_ERROR_DOM_REFRESHFINISH", 18, "-2109", "refreshFinish error", errorType, errorGroup);
        WX_ERROR_DOM_REFRESHFINISH = wXErrorCode19;
        WXErrorCode wXErrorCode20 = new WXErrorCode("WX_ERR_DOM_SCROLLTO", 19, "-2110", WXDomModule.SCROLL_TO_ELEMENT, errorType, errorGroup);
        WX_ERR_DOM_SCROLLTO = wXErrorCode20;
        WXErrorCode wXErrorCode21 = new WXErrorCode("WX_ERR_RELOAD_PAGE", 20, "-2111", "reloadPage", errorType, errorGroup);
        WX_ERR_RELOAD_PAGE = wXErrorCode21;
        WXErrorCode wXErrorCode22 = new WXErrorCode("WX_ERR_RELOAD_PAGE_EXCEED_LIMIT", 21, "-2114", "RELOAD_PAGE_EXCEED_LIMIT", errorType, errorGroup);
        WX_ERR_RELOAD_PAGE_EXCEED_LIMIT = wXErrorCode22;
        ErrorType errorType3 = ErrorType.RENDER_ERROR;
        WXErrorCode wXErrorCode23 = new WXErrorCode("WX_ERROR_WHITE_SCREEN", 22, "-2116", "WHITE_SCREEN", errorType3, errorGroup2);
        WX_ERROR_WHITE_SCREEN = wXErrorCode23;
        WXErrorCode wXErrorCode24 = new WXErrorCode("WHITE_SCREEN_RESPONSE_TIMEOUT", 23, "-2117", "WHITE_SCREEN_RESPONSE_TIMEOUT", errorType3, errorGroup2);
        WHITE_SCREEN_RESPONSE_TIMEOUT = wXErrorCode24;
        WXErrorCode wXErrorCode25 = new WXErrorCode("WHITE_SCREEN_REBOOT_EXCEED_LIMIT", 24, "-2118", "WHITE_SCREEN_REBOOT_EXCEED_LIMIT", errorType3, errorGroup2);
        WHITE_SCREEN_REBOOT_EXCEED_LIMIT = wXErrorCode25;
        WXErrorCode wXErrorCode26 = new WXErrorCode("WX_ERR_JSC_CRASH", 25, "-2112", "weexjscCrash", errorType, errorGroup);
        WX_ERR_JSC_CRASH = wXErrorCode26;
        WXErrorCode wXErrorCode27 = new WXErrorCode("WX_ERR_FIRST_DOM_ACTION_EXCEPTION", 26, "-2113", "dom action is invalid ", errorType, errorGroup);
        WX_ERR_FIRST_DOM_ACTION_EXCEPTION = wXErrorCode27;
        WXErrorCode wXErrorCode28 = new WXErrorCode("WX_ERR_JSDOWNLOAD_START", 27, "-2201", "js bundle download start", errorType, errorGroup);
        WX_ERR_JSDOWNLOAD_START = wXErrorCode28;
        WXErrorCode wXErrorCode29 = new WXErrorCode("WX_ERR_JSBUNDLE_DOWNLOAD", 28, "-2299", "js bundle download err", errorType, errorGroup);
        WX_ERR_JSBUNDLE_DOWNLOAD = wXErrorCode29;
        WXErrorCode wXErrorCode30 = new WXErrorCode("WX_ERR_JSBUNDLE_EMPTY", 29, "-2203", "js bundle empty", errorType, errorGroup);
        WX_ERR_JSBUNDLE_EMPTY = wXErrorCode30;
        WXErrorCode wXErrorCode31 = new WXErrorCode("WX_ERR_JSDOWNLOAD_END", 30, "-2299", "js bundle download end", errorType, errorGroup);
        WX_ERR_JSDOWNLOAD_END = wXErrorCode31;
        WXErrorCode wXErrorCode32 = new WXErrorCode("WX_JS_FRAMEWORK_INIT_SUCCESS", 31, "-1000", "js framework success", errorType, errorGroup);
        WX_JS_FRAMEWORK_INIT_SUCCESS = wXErrorCode32;
        WXErrorCode wXErrorCode33 = new WXErrorCode("WX_JS_FRAMEWORK_REINIT_SUCCESS", 32, "-1001", "js framework reinit success", errorType, errorGroup);
        WX_JS_FRAMEWORK_REINIT_SUCCESS = wXErrorCode33;
        WXErrorCode wXErrorCode34 = new WXErrorCode("WX_ERR_JS_FRAMEWORK", 33, "-1002", "js framework error", errorType, errorGroup);
        WX_ERR_JS_FRAMEWORK = wXErrorCode34;
        WXErrorCode wXErrorCode35 = new WXErrorCode("WX_ERR_JS_REINIT_FRAMEWORK", 34, "-1003", "js reinit framework error", errorType, errorGroup);
        WX_ERR_JS_REINIT_FRAMEWORK = wXErrorCode35;
        WXErrorCode wXErrorCode36 = new WXErrorCode("WX_ERR_SINGLE_PROCESS_DLOPEN_FILE_NOT_EXIST", 35, "-1004", "so file does not exist", errorType, errorGroup);
        WX_ERR_SINGLE_PROCESS_DLOPEN_FILE_NOT_EXIST = wXErrorCode36;
        WXErrorCode wXErrorCode37 = new WXErrorCode("WX_ERR_SINGLE_PROCESS_DLOPEN_FLAIED", 36, gz0.HOMEPAGE_CHANNEL_FEED_FAIL_CODE, "dlopen so file failed", errorType, errorGroup);
        WX_ERR_SINGLE_PROCESS_DLOPEN_FLAIED = wXErrorCode37;
        WXErrorCode wXErrorCode38 = new WXErrorCode("WX_ERR_SINGLE_PROCESS_DLSYM_FAILED", 37, "-1006", "find function from so file failed", errorType, errorGroup);
        WX_ERR_SINGLE_PROCESS_DLSYM_FAILED = wXErrorCode38;
        WXErrorCode wXErrorCode39 = new WXErrorCode("WX_ERR_SINGLE_PROCESS_JS_FRAMEWORK", 38, "-1007", "js framework  init singleProcess failed", errorType, errorGroup);
        WX_ERR_SINGLE_PROCESS_JS_FRAMEWORK = wXErrorCode39;
        WXErrorCode wXErrorCode40 = new WXErrorCode("WX_JS_FRAMEWORK_INIT_MULPROCESS_FAILED", 39, "-1008", "js framework init multiProcess failed", errorType, errorGroup);
        WX_JS_FRAMEWORK_INIT_MULPROCESS_FAILED = wXErrorCode40;
        WXErrorCode wXErrorCode41 = new WXErrorCode("WX_JS_FRAMEWORK_REINIT_MULPROCESS_FAILED", 40, "-1009", "js framework reinit multiProcess failed", errorType, errorGroup);
        WX_JS_FRAMEWORK_REINIT_MULPROCESS_FAILED = wXErrorCode41;
        WXErrorCode wXErrorCode42 = new WXErrorCode("WX_JS_FRAMEWORK_INIT_FAILED", 41, SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE0, "js framework init failed", errorType, errorGroup);
        WX_JS_FRAMEWORK_INIT_FAILED = wXErrorCode42;
        WXErrorCode wXErrorCode43 = new WXErrorCode("WX_JS_FRAMEWORK_INIT_SINGLE_PROCESS_SUCCESS", 42, "-1011", "js framework init success in single process", errorType, errorGroup);
        WX_JS_FRAMEWORK_INIT_SINGLE_PROCESS_SUCCESS = wXErrorCode43;
        WXErrorCode wXErrorCode44 = new WXErrorCode("WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL", 43, SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE2, "js framework init failed due to params null", errorType, errorGroup);
        WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL = wXErrorCode44;
        WXErrorCode wXErrorCode45 = new WXErrorCode("WX_JS_FRAMEWORK_INIT_FAILED_FIND_ICU_TIMEOUT", 44, SplashXFlushHelper.SPLASH_GUIDE_RETRY_TIME_CODE3, "find icu failed", errorType, errorGroup);
        WX_JS_FRAMEWORK_INIT_FAILED_FIND_ICU_TIMEOUT = wXErrorCode45;
        WXErrorCode wXErrorCode46 = new WXErrorCode("WX_KEY_EXCEPTION_SDK_INIT", 45, "-9000", "[WX_KEY_EXCEPTION_SDK_INIT]", errorType, errorGroup);
        WX_KEY_EXCEPTION_SDK_INIT = wXErrorCode46;
        WXErrorCode wXErrorCode47 = new WXErrorCode("WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT", 46, "-9001", "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpu is x86", errorType, errorGroup);
        WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT = wXErrorCode47;
        WXErrorCode wXErrorCode48 = new WXErrorCode("WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT", 47, "-9002", "[WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT] for device isTabletDevice", errorType, errorGroup);
        WX_KEY_EXCEPTION_SDK_INIT_TABLE_NOT_SUPPORT = wXErrorCode48;
        WXErrorCode wXErrorCode49 = new WXErrorCode("WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED", 48, "-9003", "[WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED] for jsfm init failed|detail error is:", errorType, errorGroup);
        WX_KEY_EXCEPTION_SDK_INIT_JSFM_INIT_FAILED = wXErrorCode49;
        WXErrorCode wXErrorCode50 = new WXErrorCode("WX_KEY_EXCEPTION_INVOKE_BRIDGE", 49, "-9100", "[WX_KEY_EXCEPTION_INVOKE_BRIDGE]", errorType, errorGroup);
        WX_KEY_EXCEPTION_INVOKE_BRIDGE = wXErrorCode50;
        WXErrorCode wXErrorCode51 = new WXErrorCode("WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED", 50, "-9101", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED] details", errorType, errorGroup);
        WX_KEY_EXCEPTION_INVOKE_REGISTER_CONTENT_FAILED = wXErrorCode51;
        WXErrorCode wXErrorCode52 = new WXErrorCode("WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE", 51, "-9102", "[WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE] details", errorType, errorGroup);
        WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE = wXErrorCode52;
        WXErrorCode wXErrorCode53 = new WXErrorCode("WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES", 52, "-9103", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES] details", errorType, errorGroup);
        WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES = wXErrorCode53;
        WXErrorCode wXErrorCode54 = new WXErrorCode("WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT", 53, "-9104", "[WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT] details", errorType, errorGroup);
        WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT = wXErrorCode54;
        ErrorType errorType4 = ErrorType.DOWN_LOAD_ERROR;
        WXErrorCode wXErrorCode55 = new WXErrorCode("WX_KEY_EXCEPTION_JS_DOWNLOAD", 54, "-9200", "[WX_KEY_EXCEPTION_JS_DOWNLOAD]|", errorType4, errorGroup);
        WX_KEY_EXCEPTION_JS_DOWNLOAD = wXErrorCode55;
        WXErrorCode wXErrorCode56 = new WXErrorCode("WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED", 55, "-9201", "[WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED] | details", errorType4, errorGroup);
        WX_KEY_EXCEPTION_JS_DOWNLOAD_FAILED = wXErrorCode56;
        WXErrorCode wXErrorCode57 = new WXErrorCode("WX_KEY_EXCEPTION_WXBRIDGE", 56, "-9400", "[js excute runtime error] detail js stack -> ", errorType2, errorGroup2);
        WX_KEY_EXCEPTION_WXBRIDGE = wXErrorCode57;
        WXErrorCode wXErrorCode58 = new WXErrorCode("WX_KEY_EXCEPTION_WXBRIDGE_EXCEPTION", 57, "-9401", "[js excute runtime error] detail js stack -> ", errorType2, errorGroup2);
        WX_KEY_EXCEPTION_WXBRIDGE_EXCEPTION = wXErrorCode58;
        WXErrorCode wXErrorCode59 = new WXErrorCode("WX_RENDER_ERR_JS_CREATE_INSTANCE", 58, "-9600", "white screen cause create instance failed,check js stack ->", errorType3, errorGroup2);
        WX_RENDER_ERR_JS_CREATE_INSTANCE = wXErrorCode59;
        WXErrorCode wXErrorCode60 = new WXErrorCode("WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT", 59, "-9700", "white screen cause create instanceContext failed,check js stack ->", errorType3, errorGroup2);
        WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT = wXErrorCode60;
        WXErrorCode wXErrorCode61 = new WXErrorCode("WX_RENDER_ERR_LAYER_OVERFLOW", 60, "-9602", "WX_RENDER_ERR_LAYER_OVERFLOW", errorType, errorGroup);
        WX_RENDER_ERR_LAYER_OVERFLOW = wXErrorCode61;
        WXErrorCode wXErrorCode62 = new WXErrorCode("WX_RENDER_ERR_NULL_KEY", 61, "-9603", "WX_RENDER_ERR_NULL_KEY", errorType, errorGroup);
        WX_RENDER_ERR_NULL_KEY = wXErrorCode62;
        WXErrorCode wXErrorCode63 = new WXErrorCode("WX_RENDER_ERR_NATIVE_RUNTIME", 62, "-9604", "WX_RENDER_ERR for js error", errorType3, errorGroup);
        WX_RENDER_ERR_NATIVE_RUNTIME = wXErrorCode63;
        WXErrorCode wXErrorCode64 = new WXErrorCode("WX_RENDER_ERR_COMPONENT_NOT_REGISTER", 63, "-9605", "WX_RENDER_ERR_COMPONENT_NOT_REGISTER", errorType, errorGroup);
        WX_RENDER_ERR_COMPONENT_NOT_REGISTER = wXErrorCode64;
        WXErrorCode wXErrorCode65 = new WXErrorCode("WX_RENDER_ERR_COMPONENT_ATTR_KEY", 64, "-9606", "The key passed to Component.updateAttr() is not string", errorType, errorGroup2);
        WX_RENDER_ERR_COMPONENT_ATTR_KEY = wXErrorCode65;
        WXErrorCode wXErrorCode66 = new WXErrorCode("WX_RENDER_ERR_BRIDGE_ARG_NULL", 65, "-9610", "WX_RENDER_ERR_BRIDGE_ARG_NULL", errorType, errorGroup);
        WX_RENDER_ERR_BRIDGE_ARG_NULL = wXErrorCode66;
        WXErrorCode wXErrorCode67 = new WXErrorCode("WX_RENDER_ERR_CONTAINER_TYPE", 66, "-9611", "WX_RENDER_ERR_CONTAINER_TYPE", errorType2, errorGroup2);
        WX_RENDER_ERR_CONTAINER_TYPE = wXErrorCode67;
        WXErrorCode wXErrorCode68 = new WXErrorCode("WX_RENDER_ERR_TRANSITION", 67, "-9616", "WX_RENDER_ERR_TRANSITION", errorType2, errorGroup2);
        WX_RENDER_ERR_TRANSITION = wXErrorCode68;
        WXErrorCode wXErrorCode69 = new WXErrorCode("WX_RENDER_ERR_INSTANCE_ID_NULL", 68, "-9618", "WX_RENDER_ERR_INSTANCE_ID_NULL", errorType, errorGroup);
        WX_RENDER_ERR_INSTANCE_ID_NULL = wXErrorCode69;
        WXErrorCode wXErrorCode70 = new WXErrorCode("WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT", 69, "-9619", "WX_RENDER_ERR_LIST_INVALID_COLUMNJ_CONUNT", errorType2, errorGroup2);
        WX_RENDER_ERR_LIST_INVALID_COLUMN_COUNT = wXErrorCode70;
        WXErrorCode wXErrorCode71 = new WXErrorCode("WX_RENDER_ERR_TEXTURE_SETBACKGROUND", 70, "-9620", "WX_RENDER_ERR_TEXTURE_SETBACKGROUND", errorType, errorGroup);
        WX_RENDER_ERR_TEXTURE_SETBACKGROUND = wXErrorCode71;
        WXErrorCode wXErrorCode72 = new WXErrorCode("WX_RENDER_WAR_GPU_LIMIT_LAYOUT", 71, "-9621", "WX_RENDER_WAR_GPU_LIMIT_LAYOUT", errorType2, errorGroup2);
        WX_RENDER_WAR_GPU_LIMIT_LAYOUT = wXErrorCode72;
        WXErrorCode wXErrorCode73 = new WXErrorCode("WX_RENDER_ERR_CALL_NATIVE_MODULE", 72, "-9622", "WX_CALL_NATIVE_MODULE_ERROR", errorType, errorGroup);
        WX_RENDER_ERR_CALL_NATIVE_MODULE = wXErrorCode73;
        WXErrorCode wXErrorCode74 = new WXErrorCode("WX_KEY_EXCEPTION_HERON", 73, "Heron_-9900", "Error of Heron engine: ", errorType, errorGroup);
        WX_KEY_EXCEPTION_HERON = wXErrorCode74;
        WXErrorCode wXErrorCode75 = new WXErrorCode("WX_KEY_EXCEPTION_HERON_RENDER", 74, "Heron_-9901", "Render error of Heron engine: ", errorType3, errorGroup);
        WX_KEY_EXCEPTION_HERON_RENDER = wXErrorCode75;
        WXErrorCode wXErrorCode76 = new WXErrorCode("WX_KEY_EXCEPTION_NO_BUNDLE_TYPE", 75, "-9801", "Fatal Error : No bundle type in js bundle head, cause white screen or memory leak!!", errorType2, errorGroup2);
        WX_KEY_EXCEPTION_NO_BUNDLE_TYPE = wXErrorCode76;
        ErrorType errorType5 = ErrorType.DEGRAD_ERROR;
        WXErrorCode wXErrorCode77 = new WXErrorCode("WX_DEGRAD_ERR", 76, "-1000", "degradeToH5|Weex DegradPassivity ->", errorType5, errorGroup2);
        WX_DEGRAD_ERR = wXErrorCode77;
        WXErrorCode wXErrorCode78 = new WXErrorCode("WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED", 77, "-1001", "degradeToH5|createInstance fail|wx_create_instance_error", errorType5, errorGroup);
        WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED = wXErrorCode78;
        WXErrorCode wXErrorCode79 = new WXErrorCode("WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED", 78, "-1002", "|wx_network_error|js bundle download failed", errorType4, errorGroup);
        WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED = wXErrorCode79;
        WXErrorCode wXErrorCode80 = new WXErrorCode("WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED", 79, "-1003", "degradeToH5|wx_network_error|js bundle content-length check failed", errorType5, errorGroup);
        WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED = wXErrorCode80;
        WXErrorCode wXErrorCode81 = new WXErrorCode("WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR", 80, "-1004", "degradeToH5|wx_user_intercept_error |Content-Type is not application/javascript, Weex render template must be javascript, please check your request!", errorType5, errorGroup);
        WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR = wXErrorCode81;
        WXErrorCode wXErrorCode82 = new WXErrorCode("WX_DEGRAD_ERR_OTHER_CAUSE_DEGRADTOH5", 81, gz0.HOMEPAGE_CHANNEL_FEED_FAIL_CODE, "degradeToH5|for other reason|", errorType5, errorGroup);
        WX_DEGRAD_ERR_OTHER_CAUSE_DEGRADTOH5 = wXErrorCode82;
        WXErrorCode wXErrorCode83 = new WXErrorCode("WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED_JS", 82, "-1006", "degradeToH5|createInstance fail|wx_create_instance_error", errorType5, errorGroup2);
        WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED_JS = wXErrorCode83;
        WXErrorCode wXErrorCode84 = new WXErrorCode("WX_DEGRAD_EAGLE_RENDER_ERROR", 83, "Eagle_-1007", "degradeToH5|eagleRenderErr", errorType5, errorGroup);
        WX_DEGRAD_EAGLE_RENDER_ERROR = wXErrorCode84;
        WXErrorCode wXErrorCode85 = new WXErrorCode("WX_ERR_HASH_MAP_TMP", 84, "-10010", "WX_ERR_HASH_MAP_TMP", errorType, errorGroup);
        WX_ERR_HASH_MAP_TMP = wXErrorCode85;
        WXErrorCode wXErrorCode86 = new WXErrorCode("WX_ERR_TEST", 85, "test", "test", errorType, errorGroup);
        WX_ERR_TEST = wXErrorCode86;
        $VALUES = new WXErrorCode[]{wXErrorCode, wXErrorCode2, wXErrorCode3, wXErrorCode4, wXErrorCode5, wXErrorCode6, wXErrorCode7, wXErrorCode8, wXErrorCode9, wXErrorCode10, wXErrorCode11, wXErrorCode12, wXErrorCode13, wXErrorCode14, wXErrorCode15, wXErrorCode16, wXErrorCode17, wXErrorCode18, wXErrorCode19, wXErrorCode20, wXErrorCode21, wXErrorCode22, wXErrorCode23, wXErrorCode24, wXErrorCode25, wXErrorCode26, wXErrorCode27, wXErrorCode28, wXErrorCode29, wXErrorCode30, wXErrorCode31, wXErrorCode32, wXErrorCode33, wXErrorCode34, wXErrorCode35, wXErrorCode36, wXErrorCode37, wXErrorCode38, wXErrorCode39, wXErrorCode40, wXErrorCode41, wXErrorCode42, wXErrorCode43, wXErrorCode44, wXErrorCode45, wXErrorCode46, wXErrorCode47, wXErrorCode48, wXErrorCode49, wXErrorCode50, wXErrorCode51, wXErrorCode52, wXErrorCode53, wXErrorCode54, wXErrorCode55, wXErrorCode56, wXErrorCode57, wXErrorCode58, wXErrorCode59, wXErrorCode60, wXErrorCode61, wXErrorCode62, wXErrorCode63, wXErrorCode64, wXErrorCode65, wXErrorCode66, wXErrorCode67, wXErrorCode68, wXErrorCode69, wXErrorCode70, wXErrorCode71, wXErrorCode72, wXErrorCode73, wXErrorCode74, wXErrorCode75, wXErrorCode76, wXErrorCode77, wXErrorCode78, wXErrorCode79, wXErrorCode80, wXErrorCode81, wXErrorCode82, wXErrorCode83, wXErrorCode84, wXErrorCode85, wXErrorCode86};
    }

    private WXErrorCode(String str, int i, String str2, String str3, ErrorType errorType, ErrorGroup errorGroup) {
        this.errorCode = str2;
        this.errorMsg = str3;
        this.mErrorType = errorType;
        this.mErrorGroup = errorGroup;
    }

    public static WXErrorCode valueOf(String str) {
        return (WXErrorCode) Enum.valueOf(WXErrorCode.class, str);
    }

    public static WXErrorCode[] values() {
        return (WXErrorCode[]) $VALUES.clone();
    }

    public void appendErrMsg(String str) {
        this.appendMsg = str;
    }

    public String getArgs() {
        return this.args;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public ErrorGroup getErrorGroup() {
        return this.mErrorGroup;
    }

    public String getErrorMsg() {
        return this.errorMsg + this.appendMsg;
    }

    public ErrorType getErrorType() {
        return this.mErrorType;
    }

    public void setArgs(String str) {
        this.args = str;
    }
}
