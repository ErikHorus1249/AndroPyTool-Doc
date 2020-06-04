package com.ninepvi.shield;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TrustAppActivity extends Activity {
    public l a;
    Handler b = new be(this);
    private List c;

    public List a() {
        ArrayList arrayList = new ArrayList();
        ArrayList<ResolveInfo> arrayList2 = new ArrayList<>();
        List a2 = this.a.a();
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(intent, 0);
        if (a2 != null && a2.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                Iterator it = a2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((z) it.next()).b().trim().equalsIgnoreCase(resolveInfo.activityInfo.applicationInfo.packageName.trim())) {
                            arrayList2.add(resolveInfo);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (ResolveInfo resolveInfo2 : arrayList2) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", resolveInfo2.loadLabel(getPackageManager()).toString());
                hashMap.put("packageName", resolveInfo2.activityInfo.packageName);
                hashMap.put("img", resolveInfo2.loadIcon(getPackageManager()));
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        ListView listView = new ListView(this);
        this.a = new l(this);
        this.c = a();
        if (this.c == null || this.c.size() <= 0) {
            this.b.sendEmptyMessage(1);
        }
        listView.setAdapter(new SimpleAdapter(this, this.c, R.layout.list_content, new String[]{"name", "packageName", "img"}, new int[]{R.id.activityInfo_name, R.id.activityInfo_packageName, R.id.activityInfo_img}));
        addContentView(listView, new LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.a.close();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }
}
