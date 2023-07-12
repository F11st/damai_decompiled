package tb;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.quic.Http3ConnectionDetector;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anetwork.channel.config.IRemoteConfig;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.http.NetworkSdkSetting;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import java.util.ArrayList;
import org.json.JSONArray;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class nn1 implements IRemoteConfig {
    private static boolean a = true;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    class a implements OrangeConfigListenerV1 {
        a() {
        }

        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            nn1.this.onConfigUpdate(str);
        }
    }

    private void a(String str) {
        try {
            String config = getConfig(str, "amdc_control_mode", null);
            String config2 = getConfig(str, "amdc_control_list", null);
            if (!TextUtils.isEmpty(config) && !TextUtils.isEmpty(config2)) {
                int intValue = Integer.valueOf(config).intValue();
                JSONArray jSONArray = new JSONArray(config2);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                AmdcRuntimeInfo.h(intValue, arrayList);
            }
        } catch (Exception e) {
            ALog.d("awcn.OrangeConfigImpl", "[updateAmdcConfig]", null, e, new Object[0]);
        }
        try {
            String config3 = getConfig(str, "amdc_update_mode_enable_switch", null);
            if (TextUtils.isEmpty(config3)) {
                return;
            }
            AmdcRuntimeInfo.j(Boolean.parseBoolean(config3));
        } catch (Exception unused) {
        }
    }

    private void b(String str) {
        try {
            g62.a().d(Boolean.valueOf(getConfig(str, "network_empty_scheme_https_switch", "true")).booleanValue());
        } catch (Exception unused) {
        }
        try {
            rj1.l0(Boolean.valueOf(getConfig(str, "network_spdy_enable_switch", "true")).booleanValue());
        } catch (Exception unused2) {
        }
        try {
            rj1.V(Boolean.valueOf(getConfig(str, "network_http_cache_switch", "true")).booleanValue());
        } catch (Exception unused3) {
        }
        try {
            String config = getConfig(str, "network_http_cache_flag", null);
            if (config != null) {
                rj1.Q(Long.valueOf(config).longValue());
            }
        } catch (Exception unused4) {
        }
        try {
            t9.k0(Boolean.valueOf(getConfig(str, "network_https_sni_enable_switch", "true")).booleanValue());
        } catch (Exception unused5) {
        }
        try {
            String config2 = getConfig(str, "network_accs_session_bg_switch", null);
            if (!TextUtils.isEmpty(config2)) {
                t9.V(Boolean.valueOf(config2).booleanValue());
            }
        } catch (Exception unused6) {
        }
        try {
            rj1.i0(Integer.valueOf(getConfig(str, "network_request_statistic_sample_rate", "10000")).intValue());
        } catch (Exception unused7) {
        }
        try {
            String config3 = getConfig(str, "network_request_forbidden_bg", null);
            if (!TextUtils.isEmpty(config3)) {
                rj1.O(Boolean.valueOf(config3).booleanValue());
            }
        } catch (Exception unused8) {
        }
        try {
            rj1.o0(getConfig(str, "network_url_white_list_bg", null));
        } catch (Exception unused9) {
        }
        try {
            String config4 = getConfig(str, "network_biz_white_list_bg", null);
            if (!TextUtils.isEmpty(config4)) {
                rj1.n0(config4);
            }
        } catch (Exception unused10) {
        }
        try {
            String config5 = getConfig(str, "network_amdc_preset_hosts", null);
            if (!TextUtils.isEmpty(config5)) {
                rj1.M(config5);
            }
        } catch (Exception unused11) {
        }
        try {
            t9.e0(Boolean.valueOf(getConfig(str, "network_horse_race_switch", "true")).booleanValue());
        } catch (Exception unused12) {
        }
        try {
            t9.D0(Boolean.valueOf(getConfig(str, "tnet_enable_header_cache", "true")).booleanValue());
        } catch (Exception unused13) {
        }
        try {
            String config6 = getConfig(str, "network_http3_enable_switch", null);
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
            if (!TextUtils.isEmpty(config6)) {
                boolean booleanValue = Boolean.valueOf(config6).booleanValue();
                edit.putBoolean(t9.HTTP3_ENABLE, booleanValue);
                edit.apply();
                t9.g0(booleanValue);
            } else {
                edit.remove(t9.HTTP3_ENABLE);
                edit.apply();
            }
        } catch (Exception unused14) {
        }
        try {
            rj1.j0(Boolean.valueOf(getConfig(str, "network_response_buffer_switch", "true")).booleanValue());
        } catch (Exception unused15) {
        }
        try {
            String config7 = getConfig(str, "network_get_session_async_switch", null);
            if (!TextUtils.isEmpty(config7)) {
                boolean booleanValue2 = Boolean.valueOf(config7).booleanValue();
                SharedPreferences.Editor edit2 = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
                edit2.putBoolean(rj1.SESSION_ASYNC_OPTIMIZE, booleanValue2);
                edit2.apply();
            }
        } catch (Exception unused16) {
        }
        try {
            String config8 = getConfig(str, "network_bg_forbid_request_threshold", null);
            if (!TextUtils.isEmpty(config8)) {
                int intValue = Integer.valueOf(config8).intValue();
                if (intValue < 0) {
                    intValue = 0;
                }
                rj1.N(intValue);
            }
        } catch (Exception unused17) {
        }
        try {
            String config9 = getConfig(str, "network_normal_thread_pool_executor_size", null);
            if (!TextUtils.isEmpty(config9)) {
                ThreadPoolExecutorFactory.b(Integer.valueOf(config9).intValue());
            }
        } catch (Exception unused18) {
        }
        try {
            String config10 = getConfig(str, "network_idle_session_close_switch", null);
            if (!TextUtils.isEmpty(config10)) {
                t9.l0(Boolean.valueOf(config10).booleanValue());
            }
        } catch (Exception unused19) {
        }
        try {
            String config11 = getConfig(str, "network_monitor_requests", null);
            if (!TextUtils.isEmpty(config11)) {
                rj1.Y(config11);
            }
        } catch (Exception unused20) {
        }
        try {
            String config12 = getConfig(str, "network_biz_monitor_requests", null);
            if (!TextUtils.isEmpty(config12)) {
                rj1.X(config12);
            }
        } catch (Exception unused21) {
        }
        try {
            String config13 = getConfig(str, "network_session_preset_hosts", null);
            if (!TextUtils.isEmpty(config13)) {
                t9.R(config13);
            }
        } catch (Exception unused22) {
        }
        try {
            String config14 = getConfig(str, "network_ipv6_blacklist_switch", null);
            if (!TextUtils.isEmpty(config14)) {
                t9.n0(Boolean.valueOf(config14).booleanValue());
            }
        } catch (Exception unused23) {
        }
        try {
            String config15 = getConfig(str, "network_ipv6_blacklist_ttl", null);
            if (!TextUtils.isEmpty(config15)) {
                t9.o0(Long.valueOf(config15).longValue());
            }
        } catch (Exception unused24) {
        }
        try {
            String config16 = getConfig(str, "network_url_degrade_list", null);
            if (!TextUtils.isEmpty(config16)) {
                rj1.T(config16);
            }
        } catch (Exception unused25) {
        }
        try {
            String config17 = getConfig(str, "network_delay_retry_request_no_network", null);
            if (!TextUtils.isEmpty(config17)) {
                rj1.h0(Boolean.valueOf(config17).booleanValue());
            }
        } catch (Exception unused26) {
        }
        try {
            String config18 = getConfig(str, "network_bind_service_optimize", null);
            if (!TextUtils.isEmpty(config18)) {
                boolean booleanValue3 = Boolean.valueOf(config18).booleanValue();
                SharedPreferences.Editor edit3 = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
                edit3.putBoolean(rj1.SERVICE_OPTIMIZE, booleanValue3);
                edit3.apply();
            }
        } catch (Exception unused27) {
        }
        try {
            String config19 = getConfig(str, "network_forbid_next_launch_optimize", null);
            if (!TextUtils.isEmpty(config19)) {
                boolean booleanValue4 = Boolean.valueOf(config19).booleanValue();
                SharedPreferences.Editor edit4 = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
                edit4.putBoolean(t9.NEXT_LAUNCH_FORBID, booleanValue4);
                edit4.apply();
            }
        } catch (Exception unused28) {
        }
        try {
            String config20 = getConfig(str, "network_detect_enable_switch", null);
            if (!TextUtils.isEmpty(config20)) {
                t9.y0(Boolean.valueOf(config20).booleanValue());
            }
        } catch (Exception unused29) {
        }
        try {
            String config21 = getConfig(str, "network_ipv6_global_enable_swtich", null);
            if (!TextUtils.isEmpty(config21)) {
                t9.q0(Boolean.valueOf(config21).booleanValue());
            }
        } catch (Exception unused30) {
        }
        try {
            String config22 = getConfig(str, "network_xquic_cong_control", null);
            if (!TextUtils.isEmpty(config22)) {
                t9.E0(Integer.valueOf(config22).intValue());
            }
        } catch (Exception unused31) {
        }
        try {
            String config23 = getConfig(str, "network_http3_detect_valid_time", null);
            if (!TextUtils.isEmpty(config23)) {
                Http3ConnectionDetector.n(Long.valueOf(config23).longValue());
            }
        } catch (Exception unused32) {
        }
        try {
            String config24 = getConfig(str, "network_cookie_monitor", null);
            if (!TextUtils.isEmpty(config24)) {
                CookieManager.m(config24);
            }
        } catch (Exception unused33) {
        }
        try {
            String config25 = getConfig(str, "network_cookie_header_redundant_fix", null);
            if (!TextUtils.isEmpty(config25)) {
                t9.a0(Boolean.valueOf(config25).booleanValue());
            }
        } catch (Exception unused34) {
        }
        try {
            String config26 = getConfig(str, "network_channel_local_instance_enable_switch", null);
            if (!TextUtils.isEmpty(config26)) {
                rj1.R(Boolean.valueOf(config26).booleanValue());
            }
        } catch (Exception unused35) {
        }
        try {
            String config27 = getConfig(str, "network_widget_local_instance_enable_switch", null);
            if (!TextUtils.isEmpty(config27)) {
                rj1.m0(Boolean.valueOf(config27).booleanValue());
            }
        } catch (Exception unused36) {
        }
        try {
            String config28 = getConfig(str, "network_allow_spdy_when_bind_service_failed", null);
            if (!TextUtils.isEmpty(config28)) {
                rj1.L(Boolean.valueOf(config28).booleanValue());
            }
        } catch (Exception unused37) {
        }
        try {
            String config29 = getConfig(str, "network_send_connect_info_by_service", null);
            if (!TextUtils.isEmpty(config29)) {
                t9.z0(Boolean.valueOf(config29).booleanValue());
            }
        } catch (Exception unused38) {
        }
        try {
            String config30 = getConfig(str, "network_http_dns_notify_white_list", null);
            if (!TextUtils.isEmpty(config30)) {
                t9.j0(config30);
            }
        } catch (Exception unused39) {
        }
        try {
            String config31 = getConfig(str, "network_long_request_monitor_enable_switch", null);
            if (!TextUtils.isEmpty(config31)) {
                rj1.W(Boolean.valueOf(config31).booleanValue());
            }
        } catch (Exception unused40) {
        }
        try {
            String config32 = getConfig(str, "network_ipv6_rate_optimize_enable_switch", null);
            SharedPreferences.Editor edit5 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            if (!TextUtils.isEmpty(config32)) {
                boolean booleanValue5 = Boolean.valueOf(config32).booleanValue();
                t9.s0(booleanValue5);
                edit5.putBoolean(t9.IPV6_RATE_OPTIMIZE_EANBLE, booleanValue5);
            } else {
                edit5.remove(t9.IPV6_RATE_OPTIMIZE_EANBLE);
            }
            edit5.apply();
        } catch (Exception unused41) {
        }
        try {
            String config33 = getConfig(str, "network_allow_add_ab_header_in_mtop", null);
            if (!TextUtils.isEmpty(config33)) {
                rj1.J(Boolean.valueOf(config33).booleanValue());
            }
        } catch (Exception unused42) {
        }
        try {
            String config34 = getConfig(str, "network_ipv6_only_enable_switch", null);
            if (!TextUtils.isEmpty(config34)) {
                t9.r0(Boolean.valueOf(config34).booleanValue());
            }
        } catch (Exception unused43) {
        }
        try {
            String config35 = getConfig(str, "network_allow_convert_ipv4_to_ipv6_enable_switch", null);
            if (!TextUtils.isEmpty(config35)) {
                t9.u0(Boolean.valueOf(config35).booleanValue());
            }
        } catch (Exception unused44) {
        }
        try {
            String config36 = getConfig(str, "network_strategy_new_unique_id_enable_switch", null);
            if (!TextUtils.isEmpty(config36)) {
                t9.A0(Boolean.valueOf(config36).booleanValue());
            }
        } catch (Exception unused45) {
        }
        try {
            SharedPreferences.Editor edit6 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            String config37 = getConfig(str, "network_multi_path_trigger_time", null);
            if (!TextUtils.isEmpty(config37)) {
                long longValue = Long.valueOf(config37).longValue();
                rj1.b0(longValue);
                edit6.putLong(rj1.MULTI_PATH_TRIGGER_TIME, longValue).apply();
            } else {
                edit6.remove(rj1.MULTI_PATH_TRIGGER_TIME).apply();
            }
        } catch (Exception unused46) {
        }
        try {
            SharedPreferences.Editor edit7 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            String config38 = getConfig(str, "network_multi_path_biz_white_list", null);
            if (!TextUtils.isEmpty(config38)) {
                rj1.c0(config38);
                edit7.putString(rj1.MULTI_PATH_WHITE_BIZ, config38).apply();
            } else {
                edit7.remove(rj1.MULTI_PATH_WHITE_BIZ).apply();
            }
        } catch (Exception unused47) {
        }
        try {
            SharedPreferences.Editor edit8 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            String config39 = getConfig(str, "network_multi_path_url_white_list", null);
            if (!TextUtils.isEmpty(config39)) {
                rj1.d0(config39);
                edit8.putString(rj1.MULTI_PATH_WHITE_URL, config39).apply();
            } else {
                edit8.remove(rj1.MULTI_PATH_WHITE_URL).apply();
            }
        } catch (Exception unused48) {
        }
        try {
            SharedPreferences.Editor edit9 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            String config40 = getConfig(str, "network_multi_path_ab_white_list", null);
            if (!TextUtils.isEmpty(config40)) {
                rj1.a0(config40);
                edit9.putString(rj1.MULTI_PATH_WHITE_AB, config40).apply();
            } else {
                edit9.remove(rj1.MULTI_PATH_WHITE_AB).apply();
            }
        } catch (Exception unused49) {
        }
        try {
            SharedPreferences.Editor edit10 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            String config41 = getConfig(str, "network_multi_path_monitor_enable_switch", null);
            if (!TextUtils.isEmpty(config41)) {
                boolean booleanValue6 = Boolean.valueOf(config41).booleanValue();
                t9.x0(booleanValue6);
                edit10.putBoolean(t9.MULTI_PATH_MONITOR_KEY, booleanValue6).apply();
            } else {
                edit10.remove(t9.MULTI_PATH_MONITOR_KEY).apply();
            }
        } catch (Exception unused50) {
        }
        try {
            SharedPreferences.Editor edit11 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            String config42 = getConfig(str, "network_multi_path_harmony_white_list", null);
            if (!TextUtils.isEmpty(config42)) {
                t9.d0(config42);
                edit11.putString(t9.MULTI_PATH_HARMONY_WHITE_LIST, config42).apply();
            } else {
                edit11.remove(t9.MULTI_PATH_HARMONY_WHITE_LIST).apply();
            }
        } catch (Exception unused51) {
        }
        try {
            String config43 = getConfig(str, "network_http3_black_list_switch", null);
            SharedPreferences.Editor edit12 = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
            if (!TextUtils.isEmpty(config43)) {
                t9.f0(config43);
                edit12.putString(t9.HTTP3_BLACK_LIST_KEY, config43);
                edit12.apply();
            } else {
                edit12.remove(t9.HTTP3_BLACK_LIST_KEY);
                edit12.apply();
            }
        } catch (Exception unused52) {
        }
        try {
            String config44 = getConfig(str, "network_diagnosis_enable", null);
            if (!TextUtils.isEmpty(config44)) {
                rj1.e0(Boolean.valueOf(config44).booleanValue());
            }
        } catch (Exception unused53) {
        }
        try {
            String config45 = getConfig(str, "network_exception_detect_url", null);
            if (!TextUtils.isEmpty(config45)) {
                t9.c0(config45);
            }
        } catch (Exception unused54) {
        }
        try {
            String config46 = getConfig(str, "network_http_detect_white_list", null);
            if (!TextUtils.isEmpty(config46)) {
                t9.i0(config46);
            }
        } catch (Exception unused55) {
        }
        try {
            String config47 = getConfig(str, "network_detect_center_enable_switch", null);
            SharedPreferences.Editor edit13 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            if (!TextUtils.isEmpty(config47)) {
                boolean booleanValue7 = Boolean.valueOf(config47).booleanValue();
                edit13.putBoolean(t9.DETECT_CENTER_ENABLE, booleanValue7);
                t9.b0(booleanValue7);
            } else {
                edit13.remove(t9.DETECT_CENTER_ENABLE);
            }
            edit13.apply();
        } catch (Exception unused56) {
        }
        try {
            String config48 = getConfig(str, "network_amdc_version_degraded_switch", null);
            SharedPreferences.Editor edit14 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            if (!TextUtils.isEmpty(config48)) {
                boolean booleanValue8 = Boolean.valueOf(config48).booleanValue();
                t9.T(booleanValue8);
                edit14.putBoolean(t9.AMDC_VERSION_DEGRADED_KEY, booleanValue8);
            } else {
                edit14.remove(t9.AMDC_VERSION_DEGRADED_KEY);
            }
            edit14.apply();
        } catch (Exception unused57) {
        }
        try {
            String config49 = getConfig(str, "network_complex_connect_enable_switch", null);
            if (!TextUtils.isEmpty(config49)) {
                t9.Y(Boolean.valueOf(config49).booleanValue());
            }
        } catch (Exception unused58) {
        }
        try {
            String config50 = getConfig(str, "network_complex_connect_white_list", null);
            if (!TextUtils.isEmpty(config50)) {
                t9.Z(config50);
            }
        } catch (Exception unused59) {
        }
        try {
            String config51 = getConfig(str, "network_delay_complex_connect", null);
            if (!TextUtils.isEmpty(config51)) {
                t9.X(Long.valueOf(config51).longValue());
            }
        } catch (Exception unused60) {
        }
        try {
            String config52 = getConfig(str, "network_fast_degrade_white_list", null);
            if (!TextUtils.isEmpty(config52)) {
                rj1.K(config52);
            }
        } catch (Exception unused61) {
        }
        try {
            String config53 = getConfig(str, "network_ipv6_detect_enable_switch", null);
            SharedPreferences.Editor edit15 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            if (!TextUtils.isEmpty(config53)) {
                boolean booleanValue9 = Boolean.valueOf(config53).booleanValue();
                t9.p0(booleanValue9);
                edit15.putBoolean(t9.IPV6_DETECT_KEY, booleanValue9);
            } else {
                edit15.remove(t9.IPV6_DETECT_KEY);
            }
            edit15.apply();
        } catch (Exception unused62) {
        }
        try {
            String config54 = getConfig(str, "network_ip_sort_enable_switch", null);
            if (!TextUtils.isEmpty(config54)) {
                t9.m0(Boolean.valueOf(config54).booleanValue());
            }
        } catch (Exception unused63) {
        }
        try {
            String config55 = getConfig(str, "network_mtu_detect_enable_switch", null);
            if (!TextUtils.isEmpty(config55)) {
                t9.w0(Boolean.valueOf(config55).booleanValue());
            }
        } catch (Exception unused64) {
        }
        try {
            String config56 = getConfig(str, "network_ipv6_rectification_enable_switch", null);
            SharedPreferences.Editor edit16 = PreferenceManager.getDefaultSharedPreferences(hu0.c()).edit();
            if (!TextUtils.isEmpty(config56)) {
                boolean booleanValue10 = Boolean.valueOf(config56).booleanValue();
                t9.t0(booleanValue10);
                edit16.putBoolean(t9.IPV6_RECTIFICATION_KEY, booleanValue10);
            } else {
                edit16.remove(t9.IPV6_RECTIFICATION_KEY);
            }
            edit16.apply();
        } catch (Exception unused65) {
        }
    }

    @Override // anetwork.channel.config.IRemoteConfig
    public String getConfig(String... strArr) {
        if (!a) {
            ALog.k("awcn.OrangeConfigImpl", "no orange sdk", null, new Object[0]);
            return null;
        }
        try {
            return OrangeConfig.getInstance().getConfig(strArr[0], strArr[1], strArr[2]);
        } catch (Exception e) {
            ALog.d("awcn.OrangeConfigImpl", "get config failed!", null, e, new Object[0]);
            return null;
        }
    }

    @Override // anetwork.channel.config.IRemoteConfig
    public void onConfigUpdate(String str) {
        ALog.f("awcn.OrangeConfigImpl", "onConfigUpdate", null, "namespace", str);
        if ("networkSdk".equals(str)) {
            b(str);
        } else if ("amdc".equals(str)) {
            a(str);
        }
    }

    @Override // anetwork.channel.config.IRemoteConfig
    public void register() {
        if (!a) {
            ALog.k("awcn.OrangeConfigImpl", "no orange sdk", null, new Object[0]);
            return;
        }
        try {
            OrangeConfig.getInstance().registerListener(new String[]{"networkSdk", "amdc"}, new a());
            getConfig("networkSdk", "network_empty_scheme_https_switch", "true");
            getConfig("amdc", "amdc_control_mode", null);
        } catch (Exception e) {
            ALog.d("awcn.OrangeConfigImpl", "register fail", null, e, new Object[0]);
        }
    }

    @Override // anetwork.channel.config.IRemoteConfig
    public void unRegister() {
        if (!a) {
            ALog.k("awcn.OrangeConfigImpl", "no orange sdk", null, new Object[0]);
        } else {
            OrangeConfig.getInstance().unregisterListener(new String[]{"networkSdk"});
        }
    }
}
