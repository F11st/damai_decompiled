package com.taobao.android.dinamicx;

import android.text.TextUtils;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.e */
/* loaded from: classes12.dex */
public class C6368e {
    public static final int BINDINGX_BINDINGX_CALL_BACK_CRASH = 121005;
    public static final int BINDINGX_INIT_CRASH = 121001;
    public static final int BINDINGX_POST_DETTACH_FROM_WINDOW_CRASH = 121003;
    public static final int BINDINGX_POST_MSG_CRASH = 121002;
    public static final int BINDINGX_ROOTVIEW_DISAPPEAR_CRASH = 121004;
    public static final int DXERROR_DETAIL_FAST_TEXT_CALCULATE_CRASH = 80005;
    public static final int DXERROR_DETAIL_ON_LAYOUT_ERROR = 80007;
    public static final int DXERROR_DETAIL_ON_MEASURE_ERROR = 80006;
    public static final int DXERROR_DETAIL_ON_RENDER_ERROR = 90002;
    public static final int DXERROR_ENGINERENDER_INVALID_PARAMS = 30016;
    public static final int DXERROR_ENGINERENDER_TEMPLATE_NULL = 30015;
    public static final int DXERROR_ENGINE_CREATE_VIEW_IN_GLOBAL_CENTER = 30009;
    public static final int DXERROR_ENGINE_CREATE_VIEW_IN_GLOBAL_CENTER_MAP = 30010;
    public static final int DXERROR_ENGINE_DESTROY_EXCEPTION = 30007;
    public static final int DXERROR_ENGINE_INIT_EXCEPTION_TIMER_ERROR = 30013;
    public static final int DXERROR_GENERIC_EXCEPTION = 10000;
    public static final int DXERROR_GET_ORIGIN_TREE_FAIL = 40002;
    public static final int DXERROR_GET_ORIGIN_TREE_FAIL_ASYNC = 40006;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EMPTY = 70001;
    public static final int DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_COUNT_ERROR = 70012;
    public static final int DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_ERROR = 70011;
    public static final int DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_POSITION_ERROR = 70013;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_EXPR_LOADER_COUNT_ERROR = 70030;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_EXPR_LOADER_POSITION_ERROR = 70029;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_ATOMICEVENT = 70032;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_COUNT_ERROR = 70026;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_EVENTCHIAN = 70031;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_STRING_LOADER_COUNT_ERROR = 70028;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_STRING_LOADER_POSITION_ERROR = 70027;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_COMMON_ERROR = 70025;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_COUNT_ERROR = 70009;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_ERROR = 70008;
    public static final int DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_POSITION_ERROR = 70010;
    public static final int DXERROR_PIPELINE_BINARY_FILE_STRING_LOADER_POSITION_ERROR = 70004;
    public static final int DXERROR_PIPELINE_BINARY_FILE_TAG_ERROR = 70003;
    public static final int DXERROR_PIPELINE_BINARY_FILE_UI_LOADER_POSITION_ERROR = 70014;
    public static final int DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_COUNT_ERROR = 70006;
    public static final int DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_ERROR = 70005;
    public static final int DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_POSITION_ERROR = 70007;
    public static final int DXERROR_PIPELINE_BINARY_MAJOR_VERSION_ERROR = 70002;
    public static final int DXERROR_PIPELINE_CATCH = 40003;
    public static final int DXERROR_PIPELINE_CREATE_EVENT_CHAIN_ERROR = 70033;
    public static final int DXERROR_PIPELINE_CREATE_LOAD_DX_EXPR_SCRIPT = 70034;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_ERROR = 70017;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_EVENT_ERROR = 70023;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_EXPR_ERROR = 70022;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_LIST_ERROR = 70019;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_MAP_ERROR = 70020;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_ONSETATTR_ERROR = 70021;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_STRING_ERROR = 70018;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_NODE_WIDGET_NOT_FOUND = 70024;
    public static final int DXERROR_PIPELINE_CREATE_WT_CREATE_ROOT_ERROR = 70016;
    public static final int DXERROR_PIPELINE_CREATE_WT_READ_ERROR = 70015;
    public static final int DXERROR_PIPELINE_DETAIL_FLATTEN_CATCH = 80004;
    public static final int DXERROR_PIPELINE_DETAIL_LAYOUT_CATCH = 80003;
    public static final int DXERROR_PIPELINE_DETAIL_PERFORM_MEASURE_CATCH = 80002;
    public static final int DXERROR_PIPELINE_DETAIL_PERFORM_MEASURE_WT_IS_NULL_OR_NOT_LAYOUT = 80001;
    public static final int DXERROR_PIPELINE_DETAIL_RENDER_CATCH = 90001;
    public static final int DXERROR_PIPELINE_EVENT_CHAIN_BINARY_FILE_EXPR_LOADER_COMMON_ERROR = 70035;
    public static final int DXERROR_PIPELINE_EXCEPTION_RUNTIMECONTEXT_NULL = 40001;
    public static final int DXERROR_PIPELINE_GET_CACHE_ERROR = 40005;
    public static final int DXERROR_PIPELINE_PARSE_WT_COLOR_EXCEPTION = 71007;
    public static final int DXERROR_PIPELINE_PARSE_WT_DOUBLE_EXCEPTION = 71006;
    public static final int DXERROR_PIPELINE_PARSE_WT_ERROR = 40004;
    public static final int DXERROR_PIPELINE_PARSE_WT_EXCEPTION = 71001;
    public static final int DXERROR_PIPELINE_PARSE_WT_EXPR_EVALUEATE_EXCEPTION = 71002;
    public static final int DXERROR_PIPELINE_PARSE_WT_EXPR_SET_VALUE = 71003;
    public static final int DXERROR_PIPELINE_PARSE_WT_INT_EXCEPTION = 71004;
    public static final int DXERROR_PIPELINE_PARSE_WT_LIST_EXCEPTION = 71008;
    public static final int DXERROR_PIPELINE_PARSE_WT_LONG_EXCEPTION = 71005;
    public static final int DXERROR_PIPELINE_PARSE_WT_MAP_EXCEPTION = 71009;
    public static final int DXERROR_REGISTER_NOTIFICATION_CRASH = 30012;
    public static final int DXERROR_RENDER_DOWNGRADE = 90004;
    public static final int DXERROR_RENDER_DXNativeAutoLoopRecyclerView_UNRESGISTER_ERROR = 90006;
    public static final int DXERROR_RENDER_FLATTEN = 90003;
    public static final int DXERROR_RENDER_PAGE_INDICATOR_CRASH_ERROR = 90005;
    public static final int DXERROR_ROUTER_CREATE_VIEW_EXCEPTION = 20005;
    public static final int DXERROR_ROUTER_CREATE_VIEW_EXCEPTION_TEMPLATE_NULL = 20012;
    public static final int DXERROR_ROUTER_CREATE_VIEW_EXCEPTION_V2_FAIL = 20013;
    public static final int DXERROR_ROUTER_DESTROY_EXCEPTION = 20009;
    public static final int DXERROR_ROUTER_DOWNLOAD_TEMPLATE_EXCEPTION = 20008;
    public static final int DXERROR_ROUTER_FETCH_TEMPLATE_EXCEPTION = 20007;
    public static final int DXERROR_ROUTER_RENDER_VIEW_EXCEPTION = 20006;
    public static final int DXERROR_ROUTER_RENDER_VIEW_EXCEPTION_CATCH = 200014;
    public static final int DXERROR_ROUTER_TRASFORM_TEMPLATE_TOV2_EXCEPTION = 20010;
    public static final int DXERROR_ROUTER_TRASFORM_TEMPLATE_TOV3_EXCEPTION = 20011;
    public static final int DXERROR_UNREGISTER_NOTIFICATION_CRASH = 30017;
    public static final int DXERROR_WIDGETNODE_PARSE_WT_EXCEPTION = 710010;
    public static final int DXError_EngineDownloadException = 30005;
    public static final int DXError_EngineFetchException = 30006;
    public static final int DXError_EngineGenericException = 30000;
    public static final int DXError_EngineInitContextNUll = 30011;
    public static final int DXError_EngineInitEnvException = 30001;
    public static final int DXError_EngineInitException = 30002;
    public static final int DXError_EngineRenderException = 30004;
    public static final int DXError_EngineRenderException_NULL = 30008;
    public static final int DXError_EngineSizeException = 30003;
    public static final int DXError_PipelineGenericException = 40000;
    public static final int DXError_SDKInitException = 30018;
    public static final int DXSCRIPT_CALLBACK_ERROR = 124005;
    public static final int DXSCRIPT_CALL_DATA_EVENT_EXCEPTION = 124002;
    public static final int DXSCRIPT_DATAPARSER_NOTFOUND = 124003;
    public static final int DXSCRIPT_DATAPARSER_NOTFOUND_2 = 124008;
    public static final int DXSCRIPT_EVENT_NOTFOUND = 124004;
    public static final int DXSCRIPT_EVENT_NOTFOUND_2 = 124007;
    public static final int DXSCRIPT_FUNCTION_NOTFOUND = 124001;
    public static final int DXSCRIPT_INIT_ERROR = 124006;
    public static final int DXSCRIPT_SCRIPT_NODE_ERROR = 124009;
    public static final int DX_ADD_VIEW_ERROR = 400013;
    public static final int DX_DB_CLOSE_ERROR = 60010;
    public static final int DX_DB_DELETE_ALL_ERROR = 60012;
    public static final int DX_DB_DELETE_ERROR = 60013;
    public static final int DX_DB_NULL = 60016;
    public static final int DX_DB_OPEN_ERROR = 60011;
    public static final int DX_DB_QUERY_ERROR = 60015;
    public static final int DX_DB_STORE_ERROR = 60014;
    public static final int DX_ERROR_BIZ_CODE = 150000;
    public static final int DX_ERROR_CODE_AST_EVENT_EXECUTE_EXCEPTION = 100004;
    public static final int DX_ERROR_CODE_AST_EVENT_HANDLER_NOT_FOUND = 100003;
    public static final int DX_ERROR_CODE_CONTROL_EVENT_CENTER_EXCEPTION_CRASH = 111001;
    public static final int DX_ERROR_CODE_METHOD_NODE_EXECUTE_EXCEPTION = 100002;
    public static final int DX_ERROR_CODE_PARSE_NOT_FOUND = 100001;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_230003 = 230003;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_230004 = 230004;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_230005 = 230005;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_230006 = 230006;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_230007 = 230007;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_231001 = 231001;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_231002 = 231002;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_231003 = 231003;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BEFORE_DATA = 230001;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BIND = 200006;
    public static final int DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BINDHOLDER = 230002;
    public static final int DX_ERROR_CODE_SIGNAL_EXCEPTION_CRASH = 110001;
    public static final int DX_ERROR_CODE_SIGNAL_EXCEPTION_CRASH_2 = 110002;
    public static final int DX_ERROR_CODE_SLIDER_LAYOUT_APPEAR_SCROLL_TO_FAILED = 200005;
    public static final int DX_ERROR_CODE_SLIDER_LAYOUT_IDLE_SCROLL_TO_FAILED = 200004;
    public static final int DX_ERROR_CODE_SLIDER_LAYOUT_ITEM_COUNT_0 = 200000;
    public static final int DX_ERROR_CODE_SLIDER_LAYOUT_RECYCLER_VIEW_ERROR = 200002;
    public static final int DX_ERROR_CODE_SLIDER_LAYOUT_RECYCLER_VIEW_NULL = 200001;
    public static final int DX_ERROR_CODE_SLIDER_LAYOUT_RENDER_SCROLL_TO_FAILED = 200003;
    public static final int DX_GET_PACKAGEINFO_NULL = 400011;
    public static final int DX_LOAD_WT_NULL = 400012;
    public static final int DX_NATIVE_CRASH_10 = 210010;
    public static final int DX_NATIVE_CRASH_11 = 210011;
    public static final int DX_NATIVE_CRASH_12 = 210012;
    public static final int DX_NATIVE_CRASH_13 = 210013;
    public static final int DX_NATIVE_CRASH_14 = 210014;
    public static final int DX_NATIVE_CRASH_3 = 210003;
    public static final int DX_NATIVE_CRASH_4 = 210004;
    public static final int DX_NATIVE_CRASH_5 = 210005;
    public static final int DX_NATIVE_CRASH_6 = 210006;
    public static final int DX_NATIVE_CRASH_7 = 210007;
    public static final int DX_NATIVE_CRASH_8 = 210008;
    public static final int DX_NATIVE_CRASH_9 = 210009;
    public static final int DX_NATIVE_ONMEASURE_CRASH = 210001;
    public static final int DX_NATIVE_ONMEASURE_CRASH_2 = 210002;
    public static final int DX_RECYCLER_PREFETCH_CRASH = 233002;
    public static final int DX_SIMPLE_PIPELINE_CRASH = 400010;
    public static final int DX_SIMPLE_PREFETCH_LISTENER_CRASH = 233001;
    public static final int DX_TEMPLATE_DOWNLOAD_EMPTY_ERROR = 60000;
    public static final int DX_TEMPLATE_DOWNLOAD_ERROR_60023 = 60023;
    public static final int DX_TEMPLATE_DOWNLOAD_ERROR_60024 = 60024;
    public static final int DX_TEMPLATE_IO_READ_ERROR = 60020;
    public static final int DX_TEMPLATE_IO_WRITE_ERROR = 60021;
    public static final int DX_TEMPLATE_LOAD_ERROR = 60022;
    public static final int DX_TEMPLATE_UNZIP_ERROR = 60001;
    public static final int DX_TEMPLATE_UNZIP_REQUIRED_PARAMS_MISSING_ERROR = 60002;
    public static final int DX_TEXTVIEW_FONT_MEASURE_ERROR = 220001;
    public static final int DX_VIDEO_CONTROL_INIT_CRASH = 2320001;
    public static final int ENGINE_POST_MSG_CRASH = 30014;
    public static final int EVENTCHAIN_CONTEXT_SIZE = 123003;
    public static final int EVENTCHAIN_EXECUTE_CRASH = 123002;
    public static final int EVENTCHAIN_INIT_CRASH = 123001;
    public static final int EVENT_DXEXPRNODE_CAST_ERROR = 122000;
    public static final int GET_EXPAND_TREE_CRASH = 40007;
    public static final int ONEVENT_CRASH = 40009;
    public static final int RESET_ANIMATION_CRASH = 40008;
    public static final int V2_PRE_RENDER_CRASH = 120002;
    public static final int V2_PRE_RENDER_FAIL = 120001;
    public static final int V3_ASYNC_RENDER_INIT_CRASH = 120004;
    public static final int V3_PRE_RENDER_CRASH = 120003;
    public String a;
    public DXTemplateItem b;
    public List<C6369a> c;
    private String d;

    public C6368e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
        } else {
            this.a = "NULL";
        }
        this.c = new ArrayList();
        this.d = "" + System.nanoTime();
    }

    public String a() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String toString() {
        return "DXError{biztype='" + this.a + "', dxTemplateItem=" + this.b + ", dxErrorInfoList=" + this.c + '}';
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.e$a */
    /* loaded from: classes12.dex */
    public static class C6369a {
        public long a = System.currentTimeMillis();
        public String b;
        public String c;
        public int d;
        public String e;
        public Map<String, String> f;

        public C6369a(String str, String str2, int i) {
            this.c = str;
            this.b = str2;
            this.d = i;
        }

        public String toString() {
            return "DXErrorInfo{timeStamp=" + this.a + ", serviceId='" + this.b + "', featureType='" + this.c + "', code=" + this.d + ", reason='" + this.e + '}';
        }

        public C6369a(String str, String str2, int i, String str3) {
            this.c = str;
            this.b = str2;
            this.d = i;
            this.e = str3;
        }
    }
}
