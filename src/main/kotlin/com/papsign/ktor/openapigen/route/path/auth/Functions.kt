package com.papsign.ktor.openapigen.route.path.auth

import com.papsign.ktor.openapigen.modules.RouteOpenAPIModule
import com.papsign.ktor.openapigen.route.method
import com.papsign.ktor.openapigen.route.preHandle
import com.papsign.ktor.openapigen.route.response.OpenAPIPipelineAuthContext
import io.ktor.http.*
import io.ktor.util.pipeline.ContextDsl
import kotlin.reflect.full.starProjectedType
import kotlin.reflect.typeOf

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.get(
    vararg modules: RouteOpenAPIModule,
    example: TResponse? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams) -> Unit
) = route(HttpMethod.Get, modules, example, body)

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.post(
    vararg modules: RouteOpenAPIModule,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams, TRequest) -> Unit
) = route(HttpMethod.Post, modules, exampleResponse, exampleRequest, body)

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.put(
    vararg modules: RouteOpenAPIModule,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams, TRequest) -> Unit
) = route(HttpMethod.Put, modules, exampleResponse, exampleRequest, body)

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.patch(
    vararg modules: RouteOpenAPIModule,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams, TRequest) -> Unit
) = route(HttpMethod.Patch, modules, exampleResponse, exampleRequest, body)

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.delete(
    vararg modules: RouteOpenAPIModule,
    example: TResponse? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams) -> Unit
) = route(HttpMethod.Delete, modules, example, body)

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.head(
    vararg modules: RouteOpenAPIModule,
    example: TResponse? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams) -> Unit
) = route(HttpMethod.Head, modules, example, body)

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.route(
    method: HttpMethod,
    modules: Array<out RouteOpenAPIModule>,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams, TRequest) -> Unit
) {
    method(method).apply { modules.forEach { provider.registerModule(it, it::class.starProjectedType) } }
        .handle(exampleResponse, exampleRequest, body)
}

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.route(
    method: HttpMethod,
    modules: Array<out RouteOpenAPIModule>,
    exampleResponse: TResponse? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams) -> Unit
) {
    method(method).apply { modules.forEach { provider.registerModule(it, it::class.starProjectedType) } }
        .handle(exampleResponse, body)
}

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.handle(
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams, TRequest) -> Unit
) {
    preHandle<TParams, TResponse, TRequest, OpenAPIAuthenticatedRoute<TAuth>>(HttpStatusCode.OK, exampleResponse, exampleRequest) {
        handle(typeOf<TParams>(), typeOf<TResponse>(), typeOf<TRequest>(), body)
    }
}

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, TAuth> OpenAPIAuthenticatedRoute<TAuth>.handle(
    exampleResponse: TResponse? = null,
    noinline body: suspend OpenAPIPipelineAuthContext<TAuth, TResponse>.(TParams) -> Unit
) {
    preHandle<TParams, TResponse, Unit, OpenAPIAuthenticatedRoute<TAuth>>(HttpStatusCode.OK, exampleResponse, Unit) {
        handle(typeOf<TParams>(), typeOf<TResponse>(), body)
    }
}

suspend fun <TAuth> OpenAPIPipelineAuthContext<TAuth, *>.principal() = authProvider.getAuth(pipeline)
