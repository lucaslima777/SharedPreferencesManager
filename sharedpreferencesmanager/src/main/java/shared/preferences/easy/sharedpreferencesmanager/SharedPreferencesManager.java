package shared.preferences.easy.sharedpreferencesmanager;

/**
 * Copyright 2018 Lucas Lima
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import shared.preferences.easy.sharedpreferencesmanager.Callback.Callback;
import shared.preferences.easy.sharedpreferencesmanager.Callback.OnSavePreferences;

import static shared.preferences.easy.sharedpreferencesmanager.Constant.SHARED_PREFERENCES_BOOLEAN;
import static shared.preferences.easy.sharedpreferencesmanager.Constant.SHARED_PREFERENCES_FLOAT;
import static shared.preferences.easy.sharedpreferencesmanager.Constant.SHARED_PREFERENCES_INT;
import static shared.preferences.easy.sharedpreferencesmanager.Constant.SHARED_PREFERENCES_LONG;
import static shared.preferences.easy.sharedpreferencesmanager.Constant.SHARED_PREFERENCES_STRING;

/**
 * TODO CLASS FOR SHAREDPREFERENCES MANAGEMENT
 *
 * @author lucaslima
 * @version 1.3.6
 * @since 21 Fev 2019
 */
public class SharedPreferencesManager {

    private Context context;
    private boolean resultBoolean = true;
    private int resultInt = 0;
    private float resultFloat = 0f;
    private long resultLong = 0L;
    private java.lang.String resultString;
    private Callback callback;

    /**
     * TODO BASE CLASS CONSTRUCTOR
     *
     * @param context
     */
    SharedPreferencesManager(@NonNull Context context) {
        this.context = context;
    }

    /**
     * TODO BASE BOOLEAN CONSTRUCTOR
     *
     * @param context
     * @param Boolean
     */
    SharedPreferencesManager(@NonNull Context context, boolean Boolean) {
        this.context = context;
        this.resultBoolean = Boolean;
    }

    /**
     * TODO BASE CONSTRUCTOR
     *
     * @param context
     * @param result
     * @param type
     * @param callback
     */
    SharedPreferencesManager(@NonNull Context context, java.lang.String result, Type type, Callback callback) {
        this.context = context;
        switch (type) {
            case INT:
                try {
                    this.resultInt = Integer.parseInt(result);
                    ((OnSavePreferences) callback).onComplete("Success save Int");
                } catch (NumberFormatException e) {
                    ((OnSavePreferences) callback).onError(e);
                }
                break;
            case FLOAT:
                try {
                    this.resultFloat = java.lang.Float.parseFloat(result);
                    ((OnSavePreferences) callback).onComplete("Success save Float");
                } catch (NumberFormatException e) {
                    ((OnSavePreferences) callback).onError(e);
                }
                break;
            case LONG:
                try {
                    this.resultLong = java.lang.Long.parseLong(result);
                    ((OnSavePreferences) callback).onComplete("Success save Long");
                } catch (NumberFormatException e) {
                    ((OnSavePreferences) callback).onError(e);
                }
                break;
            case STRING:
                try {
                    this.resultString = result;
                    ((OnSavePreferences) callback).onComplete("Success save String");
                } catch (Exception e) {
                    ((OnSavePreferences) callback).onError(e);
                }
                break;
        }

        this.callback = callback;
    }

    /**
     * TODO CLASS FOR MANAGER BOOLEAN DATA
     */
    class Boolean {
        private java.lang.String msg = Boolean.class.getSimpleName();
        private SharedPreferences settingsBoolean;
        private SharedPreferences.Editor editorBoolean;

        void save() {
            try {
                settingsBoolean = context.getSharedPreferences(SHARED_PREFERENCES_BOOLEAN, Context.MODE_PRIVATE);
                editorBoolean = settingsBoolean.edit();
                editorBoolean.putBoolean(SHARED_PREFERENCES_BOOLEAN, resultBoolean);
                editorBoolean.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

        boolean restore() {
            try {
                settingsBoolean = context.getSharedPreferences(SHARED_PREFERENCES_BOOLEAN, Context.MODE_PRIVATE);
                resultBoolean = settingsBoolean.getBoolean(SHARED_PREFERENCES_BOOLEAN, resultBoolean);
                return resultBoolean;
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return resultBoolean;
        }

        boolean occupy() {
            try {
                try {
                    if (settingsBoolean.getAll().isEmpty()) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return true;
        }

        void clear() {
            try {
                editorBoolean = settingsBoolean.edit();
                editorBoolean.clear();
                editorBoolean.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

    }

    /**
     * TODO CLASS FOR MANAGER INT DATA
     */
    class Int {
        private java.lang.String msg = Int.class.getSimpleName();
        private SharedPreferences settingsInt;
        private SharedPreferences.Editor editorInt;

        void save() {
            try {
                settingsInt = context.getSharedPreferences(SHARED_PREFERENCES_INT, Context.MODE_PRIVATE);
                editorInt = settingsInt.edit();
                editorInt.putInt(SHARED_PREFERENCES_INT, resultInt);
                editorInt.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

        int restore() {
            try {
                settingsInt = context.getSharedPreferences(SHARED_PREFERENCES_INT, Context.MODE_PRIVATE);
                resultInt = settingsInt.getInt(SHARED_PREFERENCES_INT, resultInt);
                return resultInt;
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return resultInt;
        }

        boolean occupy() {
            try {
                try {
                    if (settingsInt.getAll().isEmpty()) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return true;
        }

        void clear() {
            try {
                editorInt = settingsInt.edit();
                editorInt.clear();
                editorInt.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

    }

    /**
     * TODO CLASS FOR MANAGER FLOAT DATA
     */
    class Float {
        private SharedPreferences settingsFloat;
        private SharedPreferences.Editor editorFloat;


        void save() {
            try {
                settingsFloat = context.getSharedPreferences(SHARED_PREFERENCES_FLOAT, Context.MODE_PRIVATE);
                editorFloat = settingsFloat.edit();
                editorFloat.putFloat(SHARED_PREFERENCES_FLOAT, resultFloat);
                editorFloat.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

        float restore() {
            try {
                settingsFloat = context.getSharedPreferences(SHARED_PREFERENCES_FLOAT, Context.MODE_PRIVATE);
                resultFloat = settingsFloat.getFloat(SHARED_PREFERENCES_FLOAT, resultFloat);
                return resultFloat;
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return resultFloat;
        }

        boolean occupy() {
            try {
                try {
                    if (settingsFloat.getAll().isEmpty()) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return true;
        }

        void clear() {
            try {
                editorFloat = settingsFloat.edit();
                editorFloat.clear();
                editorFloat.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

    }

    /**
     * TODO CLASS FOR MANAGER LONG DATA
     */
    class Long {
        private SharedPreferences settingsLong;
        private SharedPreferences.Editor editorLong;


        void save() {
            try {
                settingsLong = context.getSharedPreferences(SHARED_PREFERENCES_LONG, Context.MODE_PRIVATE);
                editorLong = settingsLong.edit();
                editorLong.putLong(SHARED_PREFERENCES_LONG, resultLong);
                editorLong.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

        long restore() {
            try {
                settingsLong = context.getSharedPreferences(SHARED_PREFERENCES_LONG, Context.MODE_PRIVATE);
                resultLong = settingsLong.getLong(SHARED_PREFERENCES_LONG, resultLong);
                return resultLong;
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return resultLong;
        }

        boolean occupy() {
            try {
                try {
                    if (settingsLong.getAll().isEmpty()) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return true;
        }

        void clear() {
            try {
                editorLong = settingsLong.edit();
                editorLong.clear();
                editorLong.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

    }

    /**
     * TODO CLASS FOR MANAGER STRING DATA
     */
    class String {
        private SharedPreferences settingsString;
        private SharedPreferences.Editor editorString;


        void save() {
            try {
                settingsString = context.getSharedPreferences(SHARED_PREFERENCES_STRING, Context.MODE_PRIVATE);
                editorString = settingsString.edit();
                editorString.putString(SHARED_PREFERENCES_STRING, resultString);
                editorString.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

        java.lang.String restore() {
            try {
                settingsString = context.getSharedPreferences(SHARED_PREFERENCES_STRING, Context.MODE_PRIVATE);
                resultString = settingsString.getString(SHARED_PREFERENCES_STRING, resultString);
                return resultString;
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return resultString;
        }

        boolean occupy() {
            try {
                try {
                    if (settingsString.getAll().isEmpty()) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
            return true;
        }

        void clear() {
            try {
                editorString = settingsString.edit();
                editorString.clear();
                editorString.apply();
            } catch (Exception e) {
                ((OnSavePreferences) callback).onError(e);
            }
        }

    }
}