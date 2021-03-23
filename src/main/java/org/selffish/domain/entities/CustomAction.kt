package org.selffish.domain.entities


data class CustomAction(val action: ActionType, val step: Step)

enum class ActionType {
    CLEAN_AQUARIUM,
    LIGHT_CONTROL
}

enum class Step {
    EMPTY_AQUARIUM,
    FILL_AQUARIUM,
    TURN_OFF_LIGHT
}

