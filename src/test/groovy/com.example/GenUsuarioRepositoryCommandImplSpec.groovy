package com.example

import io.micronaut.context.ApplicationContext
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

class GenUsuarioRepositoryCommandImplSpec extends Specification {

    @AutoCleanup
    @Shared
    ApplicationContext applicationContext = ApplicationContext.run()

    @Subject
    @Shared
    GenUsuarioRepositoryCommandImpl repository = applicationContext.getBean(GenUsuarioRepositoryCommandImpl)

    void "update with type converter"() {
        expect:
        repository.count() == 0

        when:
        GenUsuario user = new GenUsuario()
        user.tipo = GenUsuarioTipo.DEVELOPER
        user.id = 1L

        repository.save(user)

        then:
        repository.count() == old(repository.count()) + 1

        when:
        user.tipo = GenUsuarioTipo.ADMINISTRATIVO
        repository.update(user)

        then:
        repository.count() == old(repository.count())

        and:
        repository.findAll().toList().every { it -> it.tipo == GenUsuarioTipo.ADMINISTRATIVO }

        when:
        repository.update(1L, GenUsuarioTipo.LIMITADO)

        then:
        repository.count() == old(repository.count())

        and:
        repository.findAll().toList().every { it -> it.tipo == GenUsuarioTipo.LIMITADO }

        cleanup:
        repository.deleteAll()
    }
}
