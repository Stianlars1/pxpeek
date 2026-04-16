package dev.stianl.pxpeek

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

enum class HintPlacement {
    INLINE,
    END_OF_LINE,
}

@Service(Service.Level.APP)
@State(name = "PxPeekSettings", storages = [Storage("pxpeek.xml")])
class PxPeekSettings : PersistentStateComponent<PxPeekSettings.State> {
    data class State(
        var placement: HintPlacement = HintPlacement.END_OF_LINE,
        var showPercent: Boolean = false,
    )

    private var state = State()

    override fun getState(): State = state
    override fun loadState(state: State) { this.state = state }

    var placement: HintPlacement
        get() = state.placement
        set(value) { state.placement = value }

    var showPercent: Boolean
        get() = state.showPercent
        set(value) { state.showPercent = value }

    companion object {
        fun getInstance(): PxPeekSettings =
            ApplicationManager.getApplication().getService(PxPeekSettings::class.java)
    }
}
