# SharedPreferencesManager

SharedPreferences manager


## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	        implementation 'com.github.lucaslima777:SharedPreferencesManager:1.3.3'
	}
```

## Usage

<b>Saving Values</b>

* Boolean:

```java
SharedPreferencesManager.Boolean preferencesBoolean = new SharedPreferencesManager(this, Boolean).new Boolean();
preferencesBoolean.save();

```

* Int:

```java
SharedPreferencesManager.Int preferencesInt = new SharedPreferencesManager(
                            context, 							//Context
                            100, 							//Value
                            ElementType.INT, 						//Type
                            new OnSavePreferences() { 					//Callback

                                @Override
                                public void onComplete(String msg) {			//Success
                                    Log.i(TAG, msg);
                                }

                                @Override
                                public void onError(Exception error) {			//Error
                                    Log.e(TAG, "onError: " + error.getMessage());
                                }
                            }).new Int();
                    preferencesInt.save();						//Save

```



# Developed By

* Lucas Lima 
 * :email: e-mail: lucaslimatorre@gmail.com
 


 





# License

    Copyright 2018 Lucas Lima

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
