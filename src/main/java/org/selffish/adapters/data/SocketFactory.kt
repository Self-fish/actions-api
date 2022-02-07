package org.selffish.adapters.data

import org.selffish.domain.entities.ActionType
import org.springframework.stereotype.Service
import java.net.Socket

@Service
class SocketFactory {

    companion object {
        const val CLEANING_PORT = 2000
        const val LIGHTS_PORT = 2001
        const val HOST = "localhost"
    }

    private val cleaningSocket : Socket = Socket(HOST, CLEANING_PORT)
    private val lightsSocket: Socket = Socket(HOST, LIGHTS_PORT)

    fun getSocket(type: ActionType): Socket? {
        return when (type) {
            ActionType.CLEAN_AQUARIUM -> {
                cleaningSocket
            }
            ActionType.LIGHT_CONTROL -> {
                lightsSocket
            }
        }
    }

}