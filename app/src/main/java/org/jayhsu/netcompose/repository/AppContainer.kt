package org.jayhsu.netcompose.repository

interface AppContainer {
    val fakeRepository: FakeRepository
}

class AppContainerImpl : AppContainer {
    override val fakeRepository: FakeRepository by lazy { FakeRepository() }
}