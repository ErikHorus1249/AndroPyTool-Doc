package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import com.ninepvi.shield.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: av reason: default package */
public class av extends SimpleAdapter {
    private Map a = new HashMap();
    private int[] b;
    private String[] c;
    private ViewBinder d;
    private List e;
    private int f;
    private LayoutInflater g;

    public av(Context context, List list, int i, String[] strArr, int[] iArr) {
        super(context, list, i, strArr, iArr);
        this.e = list;
        this.f = i;
        this.c = strArr;
        this.b = iArr;
        this.g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        View view2 = (View) this.a.get(Integer.valueOf(i));
        if (view2 == null) {
            view2 = this.g.inflate(i2, null);
            int[] iArr = this.b;
            int length = iArr.length;
            View[] viewArr = new View[length];
            for (int i3 = 0; i3 < length; i3++) {
                viewArr[i3] = view2.findViewById(iArr[i3]);
            }
            view2.setTag(viewArr);
            a(i, view2);
            this.a.put(Integer.valueOf(i), view2);
        }
        return view2;
    }

    private void a(int i, View view) {
        Map map = (Map) this.e.get(i);
        if (map != null) {
            ViewBinder viewBinder = this.d;
            View[] viewArr = (View[]) view.getTag();
            String[] strArr = this.c;
            int length = this.b.length;
            for (int i2 = 0; i2 < length; i2++) {
                View view2 = viewArr[i2];
                if (view2 != null) {
                    Object obj = map.get(strArr[i2]);
                    String obj2 = obj == null ? "" : obj.toString();
                    if (viewBinder != null ? viewBinder.setViewValue(view2, obj, obj2) : false) {
                        continue;
                    } else if (view2 instanceof CheckBox) {
                        ((CheckBox) view2).setText(obj.toString());
                    } else if (view2 instanceof Checkable) {
                        if (obj instanceof Boolean) {
                            ((Checkable) view2).setChecked(((Boolean) obj).booleanValue());
                        } else {
                            throw new IllegalStateException(view2.getClass().getName() + " should be bound to a Boolean, not a " + obj.getClass());
                        }
                    } else if (view2 instanceof TextView) {
                        setViewText((TextView) view2, obj2);
                    } else if (view2 instanceof CheckBox) {
                        continue;
                    } else if (view2 instanceof ImageView) {
                        if (obj instanceof Integer) {
                            setViewImage((ImageView) view2, ((Integer) obj).intValue());
                        }
                        if (obj instanceof Drawable) {
                            a((ImageView) view2, (Drawable) obj);
                        } else if (obj2 == null || obj == null) {
                            view.findViewById(R.id.cb_cancel_trust).setVisibility(4);
                            TextView textView = (TextView) view.findViewById(R.id.activityInfo_name);
                            textView.setTextColor(-65536);
                            textView.setTextSize(18.0f);
                            view.setClickable(false);
                            view.setFocusable(false);
                            view.setFocusableInTouchMode(false);
                        } else {
                            setViewImage((ImageView) view2, obj2);
                        }
                    } else {
                        throw new IllegalStateException(view2.getClass().getName() + " is not a " + " view that can be bounds by this SimpleAdapter");
                    }
                }
            }
        }
    }

    public void a(ImageView imageView, Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        imageView.setImageBitmap(createBitmap);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, this.f);
    }

    public void setViewImage(ImageView imageView, int i) {
        imageView.setImageResource(i);
    }
}
