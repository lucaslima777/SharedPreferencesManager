package shared.preferences.easy.sharedpreferencesmanager.Callback;

public interface OnSavePreferences extends Callback {
    public void onComplete(String msg);

    public void onError(Exception error);
}
