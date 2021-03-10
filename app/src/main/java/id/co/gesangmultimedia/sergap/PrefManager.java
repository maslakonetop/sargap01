package id.co.gesangmultimedia.sergap;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private final Context _context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "sergap";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        SharedPreferences pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        SharedPreferences pref = null;
        assert pref != null;
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
