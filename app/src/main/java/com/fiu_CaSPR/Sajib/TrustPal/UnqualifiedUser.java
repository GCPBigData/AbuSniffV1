package com.fiu_CaSPR.Sajib.TrustPal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.hathy.trustpal.R;

public class UnqualifiedUser extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unqualified_user);


        /*Button nextbutton = (Button) findViewById(R.id.Exit);

        nextbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RemoveCookiesThread thread = new RemoveCookiesThread(null);
                thread.start();
                Log.i("restart", "about to restart..");
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });*/
    }
    class RemoveCookiesThread extends Thread {
        private final ValueCallback<Boolean> mCallback;

        public RemoveCookiesThread(ValueCallback<Boolean> callback) {
            mCallback = callback;
        }

        public void run() {
            Looper.prepare();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                CookieManager.getInstance().removeAllCookies(mCallback);
            } else {
                CookieManager.getInstance().removeAllCookie();
            }

            Looper.loop();
        }
    }
}
