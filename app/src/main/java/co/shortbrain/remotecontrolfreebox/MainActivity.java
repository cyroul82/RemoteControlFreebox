package co.shortbrain.remotecontrolfreebox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String HOME = "home";
    private static final String MUTE = "mute";
    private static final String VOLUME_UP = "vol_inc";
    private static final String VOLUME_DOWN = "vol_dec";
    private static final String CHANNEL_UP = "prgm_inc";
    private static final String CHANNEL_DOWN = "prgm_dec";
    private static final String OK = "ok";
    private static final String YELLOW = "yellow";
    private static final String POWER = "power";
    private static final String NUMBER_1 = "1";
    private static final String NUMBER_2 = "2";
    private static final String NUMBER_3 = "3";
    private static final String NUMBER_4 = "4";
    private static final String NUMBER_5 = "5";
    private static final String NUMBER_6 = "6";
    private static final String NUMBER_7 = "7";
    private static final String NUMBER_8 = "8";
    private static final String NUMBER_9 = "9";
    private static final String NUMBER_0 = "0";
    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    private static final String RED = "red";
    private static final String BLUE = "blue";
    private static final String GREEN = "green";
    private static final String RECORD = "rec";
    private static final String BACKWARD = "bwd";
    private static final String FORWARD = "fwd";
    private static final String PLAYNPAUSE = "play";
    final String CODE_PARAM = "code";
    final String KEY_PARAM = "key";
    final String LONG_PRESS_PARAM = "long";
    private final String FREE_BASE_URL = "http://hd1.freebox.fr/pub/remote_control?";
    @BindView(R.id.imageViewVolInc)
    ImageView imageViewVolInc;
    @BindView(R.id.imageViewVolDec)
    ImageView imageViewVolDec;
    @BindView(R.id.imageViewMute)
    ImageView imageViewMute;
    @BindView(R.id.imageViewBlue)
    ImageView imageViewBlue;
    @BindView(R.id.imageViewRed)
    ImageView imageViewRed;
    @BindView(R.id.imageViewGreen)
    ImageView imageViewGreen;
    @BindView(R.id.imageViewYellow)
    ImageView imageViewYellow;
    @BindView(R.id.imageViewPrgmDec)
    ImageView imageViewPrgmDec;
    @BindView(R.id.imageViewPrgmUp)
    ImageView imageViewPrgmUp;
    @BindView(R.id.imageViewUp)
    ImageView imageViewUp;
    @BindView(R.id.imageViewDown)
    ImageView imageViewDown;
    @BindView(R.id.imageViewLeft)
    ImageView imageViewLeft;
    @BindView(R.id.imageViewRight)
    ImageView imageViewRight;
    @BindView(R.id.imageViewOk)
    ImageView imageViewOk;
    @BindView(R.id.imageViewOne)
    ImageView imageViewOne;
    @BindView(R.id.imageViewTwo)
    ImageView imageViewTwo;
    @BindView(R.id.imageViewThree)
    ImageView imageViewThree;
    @BindView(R.id.imageViewFour)
    ImageView imageViewFour;
    @BindView(R.id.imageViewFive)
    ImageView imageViewFive;
    @BindView(R.id.imageViewSix)
    ImageView imageViewSix;
    @BindView(R.id.imageViewSeven)
    ImageView imageViewSeven;
    @BindView(R.id.imageViewEight)
    ImageView imageViewEight;
    @BindView(R.id.imageViewNine)
    ImageView imageViewNine;
    @BindView(R.id.imageViewZero)
    ImageView imageViewZero;
    @BindView(R.id.imageViewHome)
    ImageView imageViewHome;
    @BindView(R.id.imageViewPower)
    ImageView imageViewPower;
    @BindView(R.id.imageViewReward)
    ImageView imageViewReward;
    @BindView(R.id.imageViewForward)
    ImageView imageViewForward;
    @BindView(R.id.imageViewPlay)
    ImageView imageViewPlay;
    @BindView(R.id.imageViewPause)
    ImageView imageViewPause;
    @BindView(R.id.imageViewRecord)
    ImageView imageViewRecord;
    private FirebaseAnalytics mFirebaseAnalytics;
    //"http://hd1.freebox.fr/pub/remote_control?code=67277440&key="
    private OkHttpClient client = new OkHttpClient();
    private String mCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.free_remote);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        ButterKnife.bind(this);
        imageViewVolInc.setOnClickListener(this);
        imageViewVolInc.setOnLongClickListener(this);
        imageViewVolDec.setOnClickListener(this);
        imageViewVolDec.setOnLongClickListener(this);
        imageViewPrgmDec.setOnClickListener(this);
        imageViewPrgmDec.setOnLongClickListener(this);
        imageViewPrgmUp.setOnClickListener(this);
        imageViewPrgmUp.setOnLongClickListener(this);
        imageViewMute.setOnClickListener(this);
        imageViewBlue.setOnClickListener(this);
        imageViewRed.setOnClickListener(this);
        imageViewGreen.setOnClickListener(this);
        imageViewYellow.setOnClickListener(this);
        imageViewDown.setOnClickListener(this);
        imageViewDown.setOnLongClickListener(this);
        imageViewUp.setOnClickListener(this);
        imageViewUp.setOnLongClickListener(this);
        imageViewRight.setOnClickListener(this);
        imageViewRight.setOnLongClickListener(this);
        imageViewLeft.setOnClickListener(this);
        imageViewLeft.setOnLongClickListener(this);
        imageViewNine.setOnClickListener(this);
        imageViewEight.setOnClickListener(this);
        imageViewSeven.setOnClickListener(this);
        imageViewSix.setOnClickListener(this);
        imageViewFive.setOnClickListener(this);
        imageViewFour.setOnClickListener(this);
        imageViewThree.setOnClickListener(this);
        imageViewTwo.setOnClickListener(this);
        imageViewOne.setOnClickListener(this);
        imageViewZero.setOnClickListener(this);
        imageViewOk.setOnClickListener(this);
        imageViewHome.setOnClickListener(this);
        imageViewReward.setOnClickListener(this);
        imageViewReward.setOnLongClickListener(this);
        imageViewForward.setOnClickListener(this);
        imageViewForward.setOnLongClickListener(this);
        imageViewPause.setOnClickListener(this);
        imageViewPlay.setOnClickListener(this);
        imageViewRecord.setOnClickListener(this);
        imageViewPower.setOnClickListener(this);

        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false);


        Bundle bundle = new Bundle();
        bundle.putString("app_open", "app_open");

        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle);

        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);


    }

    private boolean isCodeSetUp() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String code = sharedPrefs.getString(SettingsActivity.KEY_CODE_REMOTE, null);
        if (code.equals(getString(R.string.pref_default_code_remote)) || code == null) {
            Toast.makeText(this, "Please enter you remote code in the settings !", Toast.LENGTH_LONG).show();
            return false;
        } else {
            mCode = code;
            return true;
        }
    }

    private void codeNotValid() {

    }

    @Override
    public void onClick(View v) {
        if (isCodeSetUp()) {
            int id = v.getId();
            String key;
            switch (id) {
                case R.id.imageViewVolInc:
                    key = VOLUME_UP;
                    break;
                case R.id.imageViewVolDec:
                    key = VOLUME_DOWN;
                    break;
                case R.id.imageViewPrgmDec:
                    key = CHANNEL_DOWN;
                    break;
                case R.id.imageViewPrgmUp:
                    key = CHANNEL_UP;
                    break;
                case R.id.imageViewHome:
                    key = HOME;
                    break;
                case R.id.imageViewRed:
                    key = RED;
                    break;
                case R.id.imageViewYellow:
                    key = YELLOW;
                    break;
                case R.id.imageViewZero:
                    key = NUMBER_0;
                    break;
                case R.id.imageViewOne:
                    key = NUMBER_1;
                    break;
                case R.id.imageViewTwo:
                    key = NUMBER_2;
                    break;
                case R.id.imageViewThree:
                    key = NUMBER_3;
                    break;
                case R.id.imageViewFour:
                    key = NUMBER_4;
                    break;
                case R.id.imageViewFive:
                    key = NUMBER_5;
                    break;
                case R.id.imageViewSix:
                    key = NUMBER_6;
                    break;
                case R.id.imageViewSeven:
                    key = NUMBER_7;
                    break;
                case R.id.imageViewEight:
                    key = NUMBER_8;
                    break;
                case R.id.imageViewNine:
                    key = NUMBER_9;
                    break;
                case R.id.imageViewUp:
                    key = UP;
                    break;
                case R.id.imageViewDown:
                    key = DOWN;
                    break;
                case R.id.imageViewLeft:
                    key = LEFT;
                    break;
                case R.id.imageViewRight:
                    key = RIGHT;
                    break;
                case R.id.imageViewPower:
                    key = POWER;
                    break;
                case R.id.imageViewOk:
                    key = OK;
                    break;
                case R.id.imageViewMute:
                    key = MUTE;
                    break;
                case R.id.imageViewBlue:
                    key = BLUE;
                    break;
                case R.id.imageViewGreen:
                    key = GREEN;
                    break;
                case R.id.imageViewForward:
                    key = FORWARD;
                    break;
                case R.id.imageViewReward:
                    key = BACKWARD;
                    break;
                case R.id.imageViewRecord:
                    key = RECORD;
                    break;
                case R.id.imageViewPause:
                    key = PLAYNPAUSE;
                    break;
                case R.id.imageViewPlay:
                    key = PLAYNPAUSE;
                    break;
                default:
                    key = null;
                    break;
            }
            if (key != null) {

                Uri builtUri = Uri.parse(FREE_BASE_URL)
                        .buildUpon()
                        .appendQueryParameter(CODE_PARAM, mCode)
                        .appendQueryParameter(KEY_PARAM, key)
                        //.appendQueryParameter(UNITS_PARAM, "metric")
                        .build();

                OkHttpHandler handler = new OkHttpHandler();
                handler.execute(builtUri.toString());

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);

                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onLongClick(View v) {
        if (isCodeSetUp()) {
            int id = v.getId();
            String key;
            switch (id) {
                case R.id.imageViewVolInc:
                    key = VOLUME_UP;
                    break;
                case R.id.imageViewVolDec:
                    key = VOLUME_DOWN;
                    break;
                case R.id.imageViewPrgmDec:
                    key = CHANNEL_DOWN;
                    break;
                case R.id.imageViewPrgmUp:
                    key = CHANNEL_UP;
                    break;
                case R.id.imageViewUp:
                    key = UP;
                    break;
                case R.id.imageViewDown:
                    key = DOWN;
                    break;
                case R.id.imageViewLeft:
                    key = LEFT;
                    break;
                case R.id.imageViewRight:
                    key = RIGHT;
                    break;

                case R.id.imageViewForward:
                    key = FORWARD;
                    break;
                case R.id.imageViewReward:
                    key = BACKWARD;
                    break;

                default:
                    key = null;
                    break;
            }
            if (key != null) {
                Uri builtUri = Uri.parse(FREE_BASE_URL)
                        .buildUpon()
                        .appendQueryParameter(CODE_PARAM, mCode)
                        .appendQueryParameter(KEY_PARAM, key)
                        .appendQueryParameter(LONG_PRESS_PARAM, "true")
                        .build();

                OkHttpHandler handler = new OkHttpHandler();
                handler.execute(builtUri.toString());
            }

        }
        return true;
    }


    private class OkHttpHandler extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            Request request = new Request.Builder()
                    .url(params[0])
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException io) {
                Log.d(LOG_TAG, "IOException OkHttpHandler : " + io.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!s.equals("")) {
                Toast.makeText(getApplicationContext(), getString(R.string.error_code), Toast.LENGTH_LONG).show();
            }

        }
    }


}
