package com.indri.musictrivia.scopes

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by Indri on 02/09/2017.
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class RepositoryScope
