package com.example.gumtree

import com.example.gumtree.di.components.GumtreeAppComponent
import com.example.gumtree.di.modules.network.GumtreeModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        GumtreeModuleForTest::class]
)
interface GumtreeUnitTestComponent : AndroidInjector<GumtreeApp> {
    //fun inject(serviceDaggerTest: GumtreeUnitTest)
    @Component.Builder
    interface Builder {
        fun appModuleForTest(gumtreeModuleForTest: GumtreeModuleForTest): Builder

        @BindsInstance
        fun create(app: GumtreeApp): Builder

        fun build(): GumtreeUnitTestComponent
    }
}