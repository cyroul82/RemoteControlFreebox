package co.shortbrain.remotecontrolfreebox;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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
    private String URL_FREE = "http://hd1.freebox.fr/pub/remote_control?code=67277440&key=";
    private OkHttpClient client = new OkHttpClient();


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
        imageViewRight.setOnLongClickListener(this);
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

        Bundle bundle = new Bundle();
        bundle.putString("app_open", "app_open");

        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle);

        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String u;
        switch (id) {
            case R.id.imageViewVolInc:
                u = URL_FREE + VOLUME_UP;
                break;
            case R.id.imageViewVolDec:
                u = URL_FREE + VOLUME_DOWN;
                break;
            case R.id.imageViewPrgmDec:
                u = URL_FREE + CHANNEL_DOWN;
                break;
            case R.id.imageViewPrgmUp:
                u = URL_FREE + CHANNEL_UP;
                break;
            case R.id.imageViewHome:
                u = URL_FREE + HOME;
                break;
            case R.id.imageViewRed:
                u = URL_FREE + RED;
                break;
            case R.id.imageViewYellow:
                u = URL_FREE + YELLOW;
                break;
            case R.id.imageViewZero:
                u = URL_FREE + NUMBER_0;
                break;
            case R.id.imageViewOne:
                u = URL_FREE + NUMBER_1;
                break;
            case R.id.imageViewTwo:
                u = URL_FREE + NUMBER_2;
                break;
            case R.id.imageViewThree:
                u = URL_FREE + NUMBER_3;
                break;
            case R.id.imageViewFour:
                u = URL_FREE + NUMBER_4;
                break;
            case R.id.imageViewFive:
                u = URL_FREE + NUMBER_5;
                break;
            case R.id.imageViewSix:
                u = URL_FREE + NUMBER_6;
                break;
            case R.id.imageViewSeven:
                u = URL_FREE + NUMBER_7;
                break;
            case R.id.imageViewEight:
                u = URL_FREE + NUMBER_8;
                break;
            case R.id.imageViewNine:
                u = URL_FREE + NUMBER_9;
                break;
            case R.id.imageViewUp:
                u = URL_FREE + UP;
                break;
            case R.id.imageViewDown:
                u = URL_FREE + DOWN;
                break;
            case R.id.imageViewLeft:
                u = URL_FREE + LEFT;
                break;
            case R.id.imageViewRight:
                u = URL_FREE + RIGHT;
                break;
            case R.id.imageViewPower:
                u = URL_FREE + POWER;
                break;
            case R.id.imageViewOk:
                u = URL_FREE + OK;
                break;
            case R.id.imageViewMute:
                u = URL_FREE + MUTE;
                break;
            case R.id.imageViewBlue:
                u = URL_FREE + BLUE;
                break;
            case R.id.imageViewGreen:
                u = URL_FREE + GREEN;
                break;
            case R.id.imageViewForward:
                u = URL_FREE + FORWARD;
                break;
            case R.id.imageViewReward:
                u = URL_FREE + BACKWARD;
                break;
            case R.id.imageViewRecord:
                u = URL_FREE + RECORD;
                break;
            case R.id.imageViewPause:
                u = URL_FREE + PLAYNPAUSE;
                break;
            case R.id.imageViewPlay:
                u = URL_FREE + PLAYNPAUSE;
                break;
            default:
                u = null;
        }
        if (u != null) {
            new OkHttpHandler().execute(u);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onLongClick(View v) {
        int id = v.getId();
        String u;
        switch (id) {
            case R.id.imageViewVolInc:
                u = URL_FREE + VOLUME_UP + "&long=true";
                break;
            case R.id.imageViewVolDec:
                u = URL_FREE + VOLUME_DOWN + "&long=true";
                break;
            case R.id.imageViewPrgmDec:
                u = URL_FREE + CHANNEL_DOWN + "&long=true";
                break;
            case R.id.imageViewPrgmUp:
                u = URL_FREE + CHANNEL_UP + "&long=true";
                break;
            case R.id.imageViewUp:
                u = URL_FREE + UP + "&long=true";
                break;
            case R.id.imageViewDown:
                u = URL_FREE + DOWN + "&long=true";
                break;
            case R.id.imageViewLeft:
                u = URL_FREE + LEFT + "&long=true";
                break;
            case R.id.imageViewRight:
                u = URL_FREE + RIGHT + "&long=true";
                break;

            case R.id.imageViewForward:
                u = URL_FREE + FORWARD + "&long=true";
                break;
            case R.id.imageViewReward:
                u = URL_FREE + BACKWARD + "&long=true";
                break;

            default:
                u = null;
        }
        if (u != null) {
            new OkHttpHandler().execute(u);
        }
        return true;
    }


    private class OkHttpHandler extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {

            try {
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.connect();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Request request = new Request.Builder()
                    .url(params[0])
                    .build();

            try {
                Response response = client.newCall(request).execute();
                response.close();
            } catch (IOException io) {
                Log.e(LOG_TAG, "Run executed in Volume Down " + io.getMessage());
            }
            return null;
        }
    }


}
