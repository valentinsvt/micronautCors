package app.sec

import io.micronaut.http.HttpRequest
import io.micronaut.http.filter.ServerFilterChain
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import org.reactivestreams.Publisher
import io.micronaut.http.filter.HttpServerFilter
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers


@Filter("/pokemons")
class TraceFilter() : HttpServerFilter {
    override fun doFilter(request: HttpRequest<*>, chain: ServerFilterChain): Publisher<MutableHttpResponse<*>> {
        val logger = { print("------------- new request received--------------") }
        return Flowable.fromCallable(logger)
                .subscribeOn(Schedulers.io())
                .switchMap { chain.proceed(request) }
                .doOnNext { res->
                    res.headers.add("Access-Control-Allow-Origin", "http://localhost")
                    res.headers.add("Access-Control-Allow-Headers", "Authorization")
                }
    }
}