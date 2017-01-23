package co.shortbrain.remotecontrolfreebox;


import android.os.Bundle;
import android.preference.PreferenceActivity;


public class SettingsActivity extends PreferenceActivity {

    public final static String KEY_CODE_REMOTE = "code_remote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
    }

}
