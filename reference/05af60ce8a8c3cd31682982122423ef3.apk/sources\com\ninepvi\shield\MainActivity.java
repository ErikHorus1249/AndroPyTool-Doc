package com.ninepvi.shield;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MainActivity extends Activity {
    public static String a = "tmp.xml";
    public static int b = 0;
    public static int c = 0;
    public static ResolveInfo g;
    public static List h = null;
    public static String i = "";
    public ProgressDialog d;
    public List e = null;
    public List f = null;
    public String j;
    public List k;
    public List l;
    public List m;
    public List n;
    public String o;
    public String p;
    public l q;
    public Handler r;
    /* access modifiers changed from: private */
    public LinearLayout s;
    /* access modifiers changed from: private */
    public LinearLayout t;
    /* access modifiers changed from: private */
    public LinearLayout u;
    /* access modifiers changed from: private */
    public LinearLayout v;
    /* access modifiers changed from: private */
    public Intent w;
    /* access modifiers changed from: private */
    public String x;

    public MainActivity() {
        String str = "";
        String str2 = "";
        this.j = str;
        this.m = null;
        this.n = null;
        String str3 = "";
        this.o = str;
        this.x = "/";
        this.r = new bi(this);
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        String str2 = "<br>";
        this.p = str;
        List b2 = b(str);
        StringBuffer stringBuffer = new StringBuffer();
        String str3 = "<br>";
        stringBuffer.append("<font color='#7ADD00'>文件名称</font> " + this.o + str2);
        String str4 = "<br>";
        stringBuffer.append("<font color='#7ADD00'>文件路径  </font>" + str + str2);
        String str5 = "<br>";
        stringBuffer.append(str2);
        if (!(b2 == null || h == null)) {
            for (i iVar : h) {
                if (b2.indexOf(iVar.a()) != -1) {
                    String str6 = "<br>";
                    stringBuffer.append("<font color='#7ADD00'>权限名称 </font> " + iVar.a() + str2);
                    StringBuilder append = new StringBuilder().append("<font color='#7ADD00'>权限描述  </font>").append(iVar.b());
                    String str7 = "<br>";
                    stringBuffer.append(append.append(str2).toString());
                    String str8 = "<br>";
                    stringBuffer.append(str2);
                }
            }
        }
        a(stringBuffer.toString());
        i = stringBuffer.toString();
        a(7);
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        this.p = str;
        this.x = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
        this.m = new ArrayList();
        this.n = new ArrayList();
        File file = new File(str);
        File[] listFiles = file.listFiles();
        if (this.x.indexOf(str) == -1) {
            this.m.add("Back to " + this.x);
            this.n.add(this.x);
            this.m.add("Back to ../");
            this.n.add(file.getParent());
        }
        for (File file2 : listFiles) {
            this.m.add(file2.getName());
            this.n.add(file2.getPath());
        }
        ListView listView = (ListView) findViewById(R.id.lv_content);
        listView.setAdapter(new ArrayAdapter(this, R.layout.file_row, this.m));
        listView.setOnItemClickListener(new aj(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f8, code lost:
        if (r1.indexOf(r12) != -1) goto L_0x00fa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0111  */
    public void g() {
        boolean z;
        String str = "android.permission.RECEIVE_SMS";
        String str2 = "android.permission.INTERNET";
        b = 0;
        c = 0;
        this.f = new ArrayList();
        List a2 = this.q.a();
        this.k = new ArrayList();
        this.l = new ArrayList();
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            c++;
            this.r.sendEmptyMessage(5);
            ResolveInfo resolveInfo = (ResolveInfo) this.e.get(i2);
            boolean z2 = !resolveInfo.activityInfo.packageName.trim().contains("com.android") && !resolveInfo.activityInfo.packageName.trim().contains(".shield");
            if (z2 && a2 != null && a2.size() > 0) {
                Iterator it = a2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((z) it.next()).b().equalsIgnoreCase(resolveInfo.activityInfo.packageName)) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    List b2 = b(resolveInfo.activityInfo.applicationInfo.sourceDir);
                    if (b2.indexOf("android.permission.SEND_SMS") == -1) {
                        String str3 = "android.permission.RECEIVE_SMS";
                        if (b2.indexOf(str) == -1) {
                            String str4 = "android.permission.INTERNET";
                            if (b2.indexOf(str2) == -1) {
                            }
                        }
                    }
                    b++;
                    this.f.add(resolveInfo);
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", resolveInfo.loadLabel(getPackageManager()).toString());
                    hashMap.put("packageName", resolveInfo.activityInfo.packageName);
                    hashMap.put("img", resolveInfo.loadIcon(getPackageManager()));
                    if (b2.indexOf("android.permission.SEND_SMS") == -1) {
                        String str5 = "android.permission.RECEIVE_SMS";
                    }
                    this.k.add(hashMap);
                    String str6 = "android.permission.INTERNET";
                    if (b2.indexOf(str2) != -1) {
                        this.l.add(hashMap);
                    }
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            z = z2;
            if (!z) {
            }
        }
        if (b == 0) {
            i = getString(R.string.s_info_prompt);
            this.r.sendEmptyMessage(102);
            return;
        }
        i = String.format(getString(R.string.s_info_warn), new Object[]{Integer.valueOf(b)});
        this.r.sendEmptyMessage(103);
    }

    /* access modifiers changed from: private */
    public void h() {
        String str = "packageName";
        String str2 = "name";
        String str3 = "img";
        if (this.e == null) {
            this.w = new Intent("android.intent.action.MAIN", null);
            this.w.addCategory("android.intent.category.LAUNCHER");
            this.e = getPackageManager().queryIntentActivities(this.w, 0);
        }
        Button button = (Button) findViewById(R.id.bt_content_top);
        button.setText("扫描已安装程序");
        button.setOnClickListener(new ag(this));
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : this.e) {
            HashMap hashMap = new HashMap();
            String str4 = "name";
            hashMap.put(str2, resolveInfo.loadLabel(getPackageManager()).toString());
            String str5 = "packageName";
            hashMap.put(str, resolveInfo.activityInfo.packageName);
            String str6 = "img";
            hashMap.put(str3, resolveInfo.loadIcon(getPackageManager()));
            arrayList.add(hashMap);
        }
        ListView listView = (ListView) findViewById(R.id.lv_content);
        String str7 = "name";
        String str8 = "packageName";
        String str9 = "img";
        listView.setAdapter(new av(this, arrayList, R.layout.list_content_main, new String[]{str2, str, str3}, new int[]{R.id.activityInfo_name, R.id.activityInfo_packageName, R.id.activityInfo_img}));
        listView.setOnItemClickListener(new ba(this));
        String str10 = "permission.xml";
        try {
            if (h == null || h.size() <= 0) {
                h = r.a(getResources().getAssets().open(str10));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        setTitle("共安装" + this.e.size() + "个程序");
    }

    private void i() {
        this.s = (LinearLayout) findViewById(R.id.lin_install);
        this.s.setOnClickListener(new az(this));
        this.s.setBackgroundResource(R.drawable.tab_install_app_sel);
        this.t = (LinearLayout) findViewById(R.id.lin_appoint);
        this.t.setOnClickListener(new bd(this));
        this.u = (LinearLayout) findViewById(R.id.lin_trust);
        this.u.setOnClickListener(new bc(this));
        this.v = (LinearLayout) findViewById(R.id.lin_more);
        this.v.setOnClickListener(new ax(this));
    }

    public String a() {
        return this.j;
    }

    public void a(int i2) {
        String str = "确定";
        switch (i2) {
            case 1:
                String str2 = "确定";
                new Builder(this).setIcon(R.drawable.alert_dialog_icon).setTitle(R.string.s_title_prompt).setMessage(i).setPositiveButton(str, new ao(this)).show();
                return;
            case 2:
                new Builder(this).setIcon(R.drawable.alert_dialog_icon).setTitle(R.string.s_title_warn).setMessage(i).setPositiveButton("查看详情", new aq(this)).setNegativeButton("取消", new ap(this)).show();
                return;
            case 3:
                f();
                TextView textView = new TextView(this);
                ScrollView scrollView = new ScrollView(this);
                textView.setText(Html.fromHtml(a()));
                Builder positiveButton = new Builder(this).setIcon(R.drawable.alert_dialog_icon).setTitle(R.string.s_title_permission).setNegativeButton("关闭", new ab(this)).setNeutralButton("信任", new as(this)).setPositiveButton("卸载", new ar(this));
                scrollView.addView(textView);
                positiveButton.setView(scrollView);
                positiveButton.show();
                return;
            case 4:
                ScrollView scrollView2 = new ScrollView(this);
                TextView textView2 = new TextView(this);
                textView2.setText(R.string.s_about);
                String str3 = "确定";
                Builder positiveButton2 = new Builder(this).setTitle("关于我们").setPositiveButton(str, new aa(this));
                textView2.setClickable(true);
                textView2.setFocusable(true);
                scrollView2.addView(textView2);
                positiveButton2.setView(scrollView2);
                positiveButton2.show();
                return;
            case 5:
                new Builder(this).setIcon(R.drawable.alert_dialog_icon).setTitle(R.string.s_title_prompt).setMessage("确认退出系统？").setPositiveButton("退出", new v(this)).setNegativeButton("取消", new x(this)).show();
                return;
            case 6:
                ScrollView scrollView3 = new ScrollView(this);
                TextView textView3 = new TextView(this);
                textView3.setText(R.string.s_help);
                String str4 = "确定";
                Builder positiveButton3 = new Builder(this).setTitle("帮助").setPositiveButton(str, new u(this));
                textView3.setClickable(true);
                textView3.setFocusable(true);
                scrollView3.addView(textView3);
                positiveButton3.setView(scrollView3);
                positiveButton3.show();
                return;
            case 7:
                TextView textView4 = new TextView(this);
                ScrollView scrollView4 = new ScrollView(this);
                textView4.setText(Html.fromHtml(a()));
                Builder positiveButton4 = new Builder(this).setIcon(R.drawable.alert_dialog_icon).setTitle(R.string.s_title_permission).setNegativeButton("关闭", new s(this)).setPositiveButton("删除", new t(this));
                scrollView4.addView(textView4);
                positiveButton4.setView(scrollView4);
                positiveButton4.show();
                return;
            default:
                return;
        }
    }

    public void a(Message message) {
        String str = "|";
        String str2 = "packageName";
        ArrayList charSequenceArrayList = message.getData().getCharSequenceArrayList("trustPackageNames");
        if (charSequenceArrayList != null && charSequenceArrayList.size() > 0) {
            Iterator it = charSequenceArrayList.iterator();
            while (it.hasNext()) {
                String obj = ((CharSequence) it.next()).toString();
                String str3 = "|";
                String substring = obj.substring(0, obj.indexOf(str));
                String str4 = "|";
                String substring2 = obj.substring(obj.indexOf(str) + 1);
                this.q.a(substring, substring2, "");
                if (this.f != null && this.f.size() > 0) {
                    Iterator it2 = this.f.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((ResolveInfo) it2.next()).activityInfo.applicationInfo.packageName.equals(substring2)) {
                                it2.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (this.k != null && this.k.size() > 0) {
                    Iterator it3 = this.k.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        String str5 = "packageName";
                        if (((Map) it3.next()).get(str2).toString().trim().equals(substring2)) {
                            it3.remove();
                            break;
                        }
                    }
                }
                if (this.l != null && this.l.size() > 0) {
                    Iterator it4 = this.l.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        String str6 = "packageName";
                        if (((Map) it4.next()).get(str2).toString().trim().equals(substring2)) {
                            it4.remove();
                            break;
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        this.j = str;
    }

    public List b(String str) {
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + a;
        b.a(str, str2);
        bb.a(str2);
        return bb.a;
    }

    public void b() {
        String str = "packageName";
        String str2 = "name";
        String str3 = "img";
        Button button = (Button) findViewById(R.id.bt_content_top);
        button.setText("信任已勾选程序");
        button.setOnClickListener(new al(this));
        this.s.setBackgroundResource(R.drawable.tab_install_app_nor);
        this.t.setBackgroundResource(R.drawable.tab_assign_app_nor);
        this.u.setBackgroundResource(R.drawable.tab_trust_app_nor);
        this.v.setBackgroundResource(R.drawable.tab_scan_result_sel);
        setTitle("扫描结果");
        if (this.f == null || this.f.size() <= 0) {
            i = "没有扫描结果数据";
            this.r.sendEmptyMessage(102);
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        String str4 = "name";
        hashMap.put(str2, Html.fromHtml("短信权限的警告程序(" + this.k.size() + ")"));
        String str5 = "packageName";
        hashMap.put(str, "");
        String str6 = "img";
        hashMap.put(str3, null);
        arrayList.add(hashMap);
        arrayList.addAll(this.k);
        HashMap hashMap2 = new HashMap();
        String str7 = "name";
        hashMap2.put(str2, Html.fromHtml("网络权限的警告程序(" + this.l.size() + ")"));
        String str8 = "packageName";
        hashMap2.put(str, "");
        String str9 = "img";
        hashMap2.put(str3, null);
        arrayList.add(hashMap2);
        arrayList.addAll(this.l);
        ListView listView = (ListView) findViewById(R.id.lv_content);
        String str10 = "name";
        String str11 = "packageName";
        String str12 = "img";
        listView.setAdapter(new av(this, arrayList, R.layout.list_content, new String[]{str2, str, str3}, new int[]{R.id.activityInfo_name, R.id.activityInfo_packageName, R.id.activityInfo_img}));
        listView.setOnItemClickListener(new an(this));
    }

    public void c() {
        ResolveInfo resolveInfo = g;
        if (this.q.c(resolveInfo.activityInfo.processName.trim())) {
            i = "信任程序中已经存在";
            this.r.sendEmptyMessage(102);
            return;
        }
        this.q.a(resolveInfo.loadLabel(getPackageManager()).toString().trim(), resolveInfo.activityInfo.processName.trim(), resolveInfo.activityInfo.applicationInfo.sourceDir.trim());
        d();
    }

    public void c(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public void d() {
        Button button = (Button) findViewById(R.id.bt_content_top);
        button.setText("删除已勾选程序");
        button.setOnClickListener(new ai(this));
        List e2 = e();
        if (e2 == null || e2.size() <= 0) {
            i = "目前没有信任程序";
            this.r.sendEmptyMessage(102);
            return;
        }
        ListView listView = (ListView) findViewById(R.id.lv_content);
        listView.setAdapter(new av(this, e2, R.layout.list_content, new String[]{"name", "packageName", "img"}, new int[]{R.id.activityInfo_name, R.id.activityInfo_packageName, R.id.activityInfo_img}));
        listView.setOnItemClickListener(new ah(this));
        this.s.setBackgroundResource(R.drawable.tab_install_app_nor);
        this.t.setBackgroundResource(R.drawable.tab_assign_app_nor);
        this.u.setBackgroundResource(R.drawable.tab_trust_app_sel);
        this.v.setBackgroundResource(R.drawable.tab_scan_result_nor);
        setTitle("信任程序");
    }

    public List e() {
        ArrayList arrayList = new ArrayList();
        ArrayList<ResolveInfo> arrayList2 = new ArrayList<>();
        List a2 = this.q.a();
        if (this.e == null) {
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            this.e = getPackageManager().queryIntentActivities(intent, 0);
        }
        if (a2 != null && a2.size() > 0) {
            for (ResolveInfo resolveInfo : this.e) {
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

    public void f() {
        String str = "<br>";
        ResolveInfo resolveInfo = g;
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = "<br>";
        stringBuffer.append("<font color='#7ADD00'>名称</font> " + resolveInfo.loadLabel(getPackageManager()) + str);
        String str3 = "<br>";
        stringBuffer.append("<font color='#7ADD00'>程序包 </font>" + resolveInfo.activityInfo.packageName + str);
        String str4 = "<br>";
        stringBuffer.append("<font color='#7ADD00'>路径  </font>" + resolveInfo.activityInfo.applicationInfo.sourceDir + str);
        String str5 = "<br>";
        stringBuffer.append(str);
        List b2 = b(resolveInfo.activityInfo.applicationInfo.sourceDir);
        if (!(b2 == null || h == null)) {
            for (i iVar : h) {
                if (b2.indexOf(iVar.a()) != -1) {
                    String str6 = "<br>";
                    stringBuffer.append("<font color='#7ADD00'>权限名称 </font> " + iVar.a() + str);
                    StringBuilder append = new StringBuilder().append("<font color='#7ADD00'>权限描述  </font>").append(iVar.b());
                    String str7 = "<br>";
                    stringBuffer.append(append.append(str).toString());
                    String str8 = "<br>";
                    stringBuffer.append(str);
                }
            }
        }
        a(stringBuffer.toString());
        i = stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1) {
            new e(this, this.r, 1).start();
        } else {
            if (i2 == 2) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.main);
        i();
        new e(this, this.r, 1).start();
        for (Entry entry : getSharedPreferences("preferences_data", 0).getAll().entrySet()) {
            if (entry.getKey().toString().contains(ak.o)) {
                System.out.println("本地存储过滤信息：" + entry.getValue().toString());
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, "关于");
        menu.add(0, 2, 2, "帮助");
        menu.add(0, 3, 3, "退出");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                a(4);
                break;
            case 2:
                a(6);
                break;
            case 3:
                a(5);
                break;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.q.close();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.q = new l(this);
        super.onStart();
    }
}
