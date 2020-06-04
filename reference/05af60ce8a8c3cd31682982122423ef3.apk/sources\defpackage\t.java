package defpackage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListView;
import com.ninepvi.shield.MainActivity;
import com.ninepvi.shield.R;
import java.io.File;

/* renamed from: t reason: default package */
public class t implements OnClickListener {
    final /* synthetic */ MainActivity a;

    public t(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        File file = new File(this.a.p);
        System.out.println("MainActivity.this.filePath:" + this.a.p);
        file.delete();
        ((ListView) this.a.findViewById(R.id.lv_content)).setAdapter(null);
        new e(this.a, this.a.r, 2).start();
    }
}
