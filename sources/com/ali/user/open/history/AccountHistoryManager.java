package com.ali.user.open.history;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.service.StorageService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AccountHistoryManager {
    private static final String HISTORY_LOGIN_ACCOUNTS = "tb_history_acounts";
    private static volatile AccountHistoryManager singleton;

    private AccountHistoryManager() {
    }

    public static AccountHistoryManager getInstance() {
        if (singleton == null) {
            synchronized (AccountHistoryManager.class) {
                if (singleton == null) {
                    singleton = new AccountHistoryManager();
                }
            }
        }
        return singleton;
    }

    private List<HistoryAccount> parseObject(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                HistoryAccount historyAccount = new HistoryAccount();
                historyAccount.userId = jSONObject.optString("userId");
                historyAccount.tokenKey = jSONObject.optString("tokenKey");
                historyAccount.mobile = jSONObject.optString("mobile");
                historyAccount.nick = jSONObject.optString("nick");
                historyAccount.email = jSONObject.optString("email");
                historyAccount.t = jSONObject.optString("t");
                arrayList.add(historyAccount);
            }
        }
        return arrayList;
    }

    private String toJSONString(List<HistoryAccount> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (HistoryAccount historyAccount : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userId", historyAccount.userId);
                jSONObject.put("tokenKey", historyAccount.tokenKey);
                jSONObject.put("nick", historyAccount.nick);
                jSONObject.put("email", historyAccount.email);
                jSONObject.put("mobile", historyAccount.mobile);
                jSONObject.put("t", String.valueOf(System.currentTimeMillis()));
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
        return jSONArray.toString();
    }

    public void clearHistoryAccount() {
        ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue(HISTORY_LOGIN_ACCOUNTS);
    }

    public HistoryAccount findHistoryAccount(String str) {
        try {
            List<HistoryAccount> historyAccounts = getHistoryAccounts();
            if (historyAccounts != null) {
                for (HistoryAccount historyAccount : historyAccounts) {
                    String str2 = historyAccount.userId;
                    if (str2 != null && str2.equals(str)) {
                        return historyAccount;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public List<HistoryAccount> getHistoryAccounts() {
        String dDpExValue = ((StorageService) AliMemberSDK.getService(StorageService.class)).getDDpExValue(HISTORY_LOGIN_ACCOUNTS);
        if (TextUtils.isEmpty(dDpExValue)) {
            return new ArrayList();
        }
        try {
            return parseObject(dDpExValue);
        } catch (JSONException unused) {
            ArrayList arrayList = new ArrayList();
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue(HISTORY_LOGIN_ACCOUNTS);
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ali.user.open.history.HistoryAccount matchHistoryAccount(java.lang.String r4) {
        /*
            r3 = this;
            java.util.List r0 = r3.getHistoryAccounts()
            if (r0 == 0) goto L2f
            java.util.Iterator r0 = r0.iterator()
        La:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2f
            java.lang.Object r1 = r0.next()
            com.ali.user.open.history.HistoryAccount r1 = (com.ali.user.open.history.HistoryAccount) r1
            java.lang.String r2 = r1.nick
            boolean r2 = android.text.TextUtils.equals(r4, r2)
            if (r2 != 0) goto L2e
            java.lang.String r2 = r1.email
            boolean r2 = android.text.TextUtils.equals(r4, r2)
            if (r2 != 0) goto L2e
            java.lang.String r2 = r1.mobile
            boolean r2 = android.text.TextUtils.equals(r4, r2)
            if (r2 == 0) goto La
        L2e:
            return r1
        L2f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.open.history.AccountHistoryManager.matchHistoryAccount(java.lang.String):com.ali.user.open.history.HistoryAccount");
    }

    public void putLoginHistory(HistoryAccount historyAccount, String str) {
        if (!ConfigManager.getInstance().isSaveHistoryWithSalt() || ((StorageService) AliMemberSDK.getService(StorageService.class)).saveSafeToken(historyAccount.tokenKey, str)) {
            List<HistoryAccount> historyAccounts = getHistoryAccounts();
            if (historyAccounts != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(historyAccount);
                for (HistoryAccount historyAccount2 : historyAccounts) {
                    if (arrayList.size() >= ConfigManager.getInstance().getMaxHistoryAccount()) {
                        break;
                    } else if (TextUtils.isEmpty(historyAccount2.userId) || !historyAccount2.userId.equals(historyAccount.userId)) {
                        arrayList.add(historyAccount2);
                    }
                }
                ((StorageService) AliMemberSDK.getService(StorageService.class)).putDDpExValue(HISTORY_LOGIN_ACCOUNTS, toJSONString(arrayList));
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(historyAccount);
            ((StorageService) AliMemberSDK.getService(StorageService.class)).putDDpExValue(HISTORY_LOGIN_ACCOUNTS, toJSONString(arrayList2));
        }
    }

    public void removeHistoryAccount(HistoryAccount historyAccount) {
        ArrayList arrayList;
        String dDpExValue;
        if (historyAccount == null) {
            return;
        }
        try {
            ((StorageService) AliMemberSDK.getService(StorageService.class)).removeSafeToken(historyAccount.tokenKey);
            try {
                dDpExValue = ((StorageService) AliMemberSDK.getService(StorageService.class)).getDDpExValue(HISTORY_LOGIN_ACCOUNTS);
            } catch (Exception unused) {
            }
            try {
                if (TextUtils.isEmpty(dDpExValue)) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = parseObject(dDpExValue);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                arrayList = new ArrayList();
                ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue(HISTORY_LOGIN_ACCOUNTS);
            }
            if (arrayList != null) {
                ArrayList arrayList2 = new ArrayList();
                for (HistoryAccount historyAccount2 : arrayList) {
                    if (!historyAccount2.userId.equals(historyAccount.userId)) {
                        arrayList2.add(historyAccount2);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                if (arrayList.isEmpty()) {
                    ((StorageService) AliMemberSDK.getService(StorageService.class)).removeDDpExValue(HISTORY_LOGIN_ACCOUNTS);
                } else {
                    ((StorageService) AliMemberSDK.getService(StorageService.class)).putDDpExValue(HISTORY_LOGIN_ACCOUNTS, toJSONString(arrayList));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
