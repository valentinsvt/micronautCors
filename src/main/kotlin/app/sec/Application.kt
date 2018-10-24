package app.sec

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("app.sec")
                .mainClass(Application.javaClass)
                .start()
    }
}