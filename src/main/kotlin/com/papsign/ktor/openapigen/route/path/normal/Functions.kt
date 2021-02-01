package com.papsign.ktor.openapigen.route.path.normal

import com.papsign.ktor.openapigen.modules.RouteOpenAPIModule
import com.papsign.ktor.openapigen.route.method
import com.papsign.ktor.openapigen.route.preHandle
import com.papsign.ktor.openapigen.route.response.OpenAPIPipelineResponseContext
import io.ktor.http.*
import io.ktor.util.pipeline.ContextDsl
import kotlin.reflect.full.starProjectedType
import kotlin.reflect.typeOf

/**
 * Builds a route to match `GET` requests generating OpenAPI documentation.
 * Get parameters will have the type [TParams] and response type will have [TResponse].
 * Any of the template types can be specified as [Unit] if they are not used.
 *
 * @param modules to add OpenAPI details. See [com.papsign.ktor.openapigen.route.info], [com.papsign.ktor.openapigen.route.status], [com.papsign.ktor.openapigen.route.tags] or any other implementation of module
 * @param example an example of [TResponse] to add to OpenAPI specification
 * @param body a block that received the request parameters builds the response
 * @return the new created route
 */
@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any> NormalOpenAPIRoute.get(
    statusCode: HttpStatusCode? = null,
    vararg modules: RouteOpenAPIModule,
    example: TResponse? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams) -> Unit
) = route(HttpMethod.Get, modules, statusCode, example, body)

/**
 * Builds a route to match `POST` requests generating OpenAPI documentation.
 * Route parameters will have the type [TParams] and response type will have [TResponse].
 * The body of the request will be parsed into a [TRequest] instance.
 * Any of the template types can be specified as [Unit] if they are not used.
 *
 * @param modules to add OpenAPI details. See [com.papsign.ktor.openapigen.route.info], [com.papsign.ktor.openapigen.route.status], [com.papsign.ktor.openapigen.route.tags] or any other implementation of module
 * @param exampleResponse optional example of [TResponse] to add to OpenAPI specification
 * @param exampleRequest optional example of [TRequest] to add to OpenAPI specification
 * @param body a block that received the request parameters builds the response
 * @return the new created route
 */
@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any> NormalOpenAPIRoute.post(
    statusCode: HttpStatusCode? = null,
    vararg modules: RouteOpenAPIModule,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams, TRequest) -> Unit
) = route(HttpMethod.Post, modules, statusCode, exampleResponse, exampleRequest, body)

/**
 * Builds a route to match `PUT` requests generating OpenAPI documentation.
 * Route parameters will have the type [TParams] and response type will have [TResponse].
 * The body of the request will be parsed into a [TRequest] instance.
 * Any of the template types can be specified as [Unit] if they are not used.
 *
 * @param modules to add OpenAPI details. See [com.papsign.ktor.openapigen.route.info], [com.papsign.ktor.openapigen.route.status], [com.papsign.ktor.openapigen.route.tags] or any other implementation of module
 * @param exampleResponse optional example of [TResponse] to add to OpenAPI specification
 * @param exampleRequest optional example of [TRequest] to add to OpenAPI specification
 * @param body a block that received the request parameters builds the response
 * @return the new created route
 */
@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any> NormalOpenAPIRoute.put(
    statusCode: HttpStatusCode? = null,
    vararg modules: RouteOpenAPIModule,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams, TRequest) -> Unit
) = route(HttpMethod.Put, modules, statusCode, exampleResponse, exampleRequest, body)

/**
 * Builds a route to match `PATCH` requests generating OpenAPI documentation.
 * Route parameters will have the type [TParams] and response type will have [TResponse].
 * The body of the request will be parsed into a [TRequest] instance.
 * Any of the template types can be specified as [Unit] if they are not used.
 *
 * @param modules to add OpenAPI details. See [com.papsign.ktor.openapigen.route.info], [com.papsign.ktor.openapigen.route.status], [com.papsign.ktor.openapigen.route.tags] or any other implementation of module
 * @param exampleResponse optional example of [TResponse] to add to OpenAPI specification
 * @param exampleRequest optional example of [TRequest] to add to OpenAPI specification
 * @param body a block that received the request parameters builds the response
 * @return the new created route
 */
@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any> NormalOpenAPIRoute.patch(
    statusCode: HttpStatusCode? = null,
    vararg modules: RouteOpenAPIModule,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams, TRequest) -> Unit
) = route(HttpMethod.Patch, modules, statusCode, exampleResponse, exampleRequest, body)

/**
 * Builds a route to match `DELETE` requests generating OpenAPI documentation.
 * Route parameters will have the type [TParams] and response type will have [TResponse].
 * Any of the template types can be specified as [Unit] if they are not used.
 *
 * @param modules to add OpenAPI details. See [com.papsign.ktor.openapigen.route.info], [com.papsign.ktor.openapigen.route.status], [com.papsign.ktor.openapigen.route.tags] or any other implementation of module
 * @param example optional example of [TResponse] to add to OpenAPI specification
 * @param body a block that received the request parameters builds the response
 * @return the new created route
 */
@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any> NormalOpenAPIRoute.delete(
    statusCode: HttpStatusCode? = null,
    vararg modules: RouteOpenAPIModule,
    example: TResponse? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams) -> Unit
) = route(HttpMethod.Delete, modules, statusCode, example, body)

/**
 * Builds a route to match `HEAD` requests generating OpenAPI documentation.
 * Route parameters will have the type [TParams] and response type will have [TResponse].
 * Any of the template types can be specified as [Unit] if they are not used.
 *
 * @param modules to add OpenAPI details. See [com.papsign.ktor.openapigen.route.info], [com.papsign.ktor.openapigen.route.status], [com.papsign.ktor.openapigen.route.tags] or any other implementation of module
 * @param example optional example of [TResponse] to add to OpenAPI specification
 * @param body a block that received the request parameters builds the response
 * @return the new created route
 */
@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any> NormalOpenAPIRoute.head(
    statusCode: HttpStatusCode? = null,
    vararg modules: RouteOpenAPIModule,
    example: TResponse? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams) -> Unit
) = route(HttpMethod.Head, modules, statusCode, example, body)

/**
 * Builds a route to match requests with the specified [method] generating OpenAPI documentation.
 * Route parameters will have the type [TParams] and response type will have [TResponse].
 * The body of the request will be parsed into a [TRequest] instance.
 * Any of the template types can be specified as [Unit] if they are not used.
 *
 * @param method the HTTP method that matches this route
 * @param modules to add OpenAPI details. See [com.papsign.ktor.openapigen.route.info], [com.papsign.ktor.openapigen.route.status], [com.papsign.ktor.openapigen.route.tags] or any other implementation of module
 * @param exampleResponse optional example of [TResponse] to add to OpenAPI specification
 * @param exampleRequest optional example of [TRequest] to add to OpenAPI specification
 * @param body a block that received the request parameters builds the response
 * @return the new created route
 */
@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any> NormalOpenAPIRoute.route(
    method: HttpMethod,
    modules: Array<out RouteOpenAPIModule>,
    statusCode: HttpStatusCode?,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams, TRequest) -> Unit
) {
    method(method).apply { modules.forEach { provider.registerModule(it, it::class.starProjectedType) } }
        .handle(statusCode, exampleResponse, exampleRequest, body)
}

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any> NormalOpenAPIRoute.route(
    method: HttpMethod,
    modules: Array<out RouteOpenAPIModule>,
    statusCode: HttpStatusCode?,
    exampleResponse: TResponse? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams) -> Unit
) {
    method(method).apply { modules.forEach { provider.registerModule(it, it::class.starProjectedType) } }
        .handle(statusCode, exampleResponse, body)
}

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any, reified TRequest : Any> NormalOpenAPIRoute.handle(
    statusCode: HttpStatusCode?,
    exampleResponse: TResponse? = null,
    exampleRequest: TRequest? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams, TRequest) -> Unit
) {
    preHandle<TParams, TResponse, TRequest, NormalOpenAPIRoute>(statusCode, exampleResponse, exampleRequest) {
        handle(typeOf<TParams>(), typeOf<TResponse>(), typeOf<TRequest>(), statusCode, body)
    }
}

@ContextDsl
inline fun <reified TParams : Any, reified TResponse : Any> NormalOpenAPIRoute.handle(
    statusCode: HttpStatusCode?,
    exampleResponse: TResponse? = null,
    noinline body: suspend OpenAPIPipelineResponseContext<TResponse>.(TParams) -> Unit
) {
    preHandle<TParams, TResponse, Unit, NormalOpenAPIRoute>(statusCode, exampleResponse, Unit) {
        handle(typeOf<TParams>(), typeOf<TResponse>(), statusCode, body)
    }
}
