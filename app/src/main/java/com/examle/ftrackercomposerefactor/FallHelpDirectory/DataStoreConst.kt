package com.examle.ftrackercomposerefactor.FallHelpDirectory

import androidx.datastore.preferences.preferencesKey

class DataStoreConst {
    object IsOnboardingPassed{
        val Is_On_Ps = preferencesKey<Boolean>("is_it_ps")
    }

}