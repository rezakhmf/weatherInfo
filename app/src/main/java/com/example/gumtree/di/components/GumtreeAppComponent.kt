package com.example.gumtree.di.components

import com.example.gumtree.GumtreeApp
import com.example.gumtree.di.modules.network.GumtreeModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, GumtreeModule::class])
interface GumtreeAppComponent : AndroidInjector<GumtreeApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: GumtreeApp): Builder

        fun build(): GumtreeAppComponent
    }
    //abstract class Factory: AndroidInjector.Factory<GumtreeApp>
}