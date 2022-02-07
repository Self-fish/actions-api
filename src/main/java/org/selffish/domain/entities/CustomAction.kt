package org.selffish.domain.entities


data class CustomAction(val action: ActionType, val step: Step)

enum class ActionType {
    CLEAN_AQUARIUM,
    LIGHT_CONTROL
}

enum class Step {
    COVER_UP,
    COVER_DOWN,
    LIGHTS_ON,
    LIGHTS_OFF,
    FILLING_BOMB_ON,
    FILLING_BOMB_OFF
}

