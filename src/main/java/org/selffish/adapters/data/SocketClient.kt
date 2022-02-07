package org.selffish.adapters.data

import org.selffish.domain.entities.ActionType
import org.springframework.stereotype.Service
import java.io.DataOutputStream
import java.lang.Exception

@Service
class SocketClient(private val factory: SocketFactory) {


    fun sendMessage(message: String, type: ActionType) {
        val clientOutput = DataOutputStream(factory.getSocket(type)?.getOutputStream())
        try {
            clientOutput.writeUTF(message)
        } catch (e: Exception) {
            println(e.message)
            factory.getSocket(type)?.close()
        }

    }

}