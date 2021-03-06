package be.swsb.effit.messaging.command

import be.swsb.effit.domain.command.Command
import be.swsb.effit.domain.command.CommandHandler
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommandExecutor(private val registeredHandlers: List<CommandHandler<*, *>>) {

    @Transactional
    @Suppress("UNCHECKED_CAST")
    fun <A> execute(command: Command<A>): A {
        val commandHandler = getCommandHandler(command) as CommandHandler<A, Command<A>>
        return commandHandler.handle(command)
    }

    private fun <R> getCommandHandler(command: Command<R>): CommandHandler<*,*> {
        return registeredHandlers.firstOrNull { it.getCommandType() == command.javaClass }
                ?: throw NoCommandHandlerException(command.asString())
    }
}
