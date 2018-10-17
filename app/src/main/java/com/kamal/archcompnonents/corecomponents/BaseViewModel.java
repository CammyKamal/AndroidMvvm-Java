package com.kamal.archcompnonents.corecomponents;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

/**
 * Created by Kamal Vaid
 * Base View Model to be inherited by Child View Models.
 */

public class BaseViewModel extends AndroidViewModel {

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

}
