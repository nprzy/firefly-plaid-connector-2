/**
 * Firefly III API v1.5.6
 *
 * This is the documentation of the Firefly III API. You can find accompanying documentation on the website of Firefly III itself (see below). Please report any bugs or issues. You may use the \"Authorize\" button to try the API below. This file was last generated on 2022-04-04T03:54:41+00:00
 *
 * The version of the OpenAPI document: 1.5.6
 * Contact: james@firefly-iii.org
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package net.djvk.fireflyPlaidConnector2.api.firefly.apis

import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.client.*
import io.ktor.client.engine.*
import net.djvk.fireflyPlaidConnector2.api.firefly.infrastructure.*
import net.djvk.fireflyPlaidConnector2.api.firefly.models.DataDestroyObject
import net.djvk.fireflyPlaidConnector2.api.firefly.models.ExportFileFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
open class DataApi(
    @Value("\${fireflyPlaidConnector2.firefly.url}")
    baseUrl: String = ApiClient.BASE_URL,
    httpClientEngine: HttpClientEngine? = null,
    httpClientConfig: ((HttpClientConfig<*>) -> Unit)? = null,
    jsonBlock: ObjectMapper.() -> Unit = ApiClient.JSON_DEFAULT,
) : ApiClient(baseUrl, httpClientEngine, httpClientConfig, jsonBlock) {

    /**
     * Bulk update transaction properties. For more information, see https://docs.firefly-iii.org/firefly-iii/api/specials
     * Allows you to update transactions in bulk.
     * @param query The JSON query.
     * @return void
     */
    open suspend fun bulkUpdateTransactions(query: kotlin.String): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query.apply { localVariableQuery["query"] = listOf("$query") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.POST,
            "/api/v1/data/bulk/transactions",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Endpoint to destroy user data
     * A call to this endpoint permanently destroys the requested data type. Use it with care and always with user permission. The demo user is incapable of using this endpoint.
     * @param objects The type of data that you wish to destroy. You can only use one at a time.
     * @return void
     */
    open suspend fun destroyData(objects: DataDestroyObject): HttpResponse<Unit> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        objects.apply { localVariableQuery["objects"] = listOf("$objects") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.DELETE,
            "/api/v1/data/destroy",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export account data from Firefly III
     * This endpoint allows you to export your accounts from Firefly III into a file. Currently supports CSV exports only.
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportAccounts(type: ExportFileFilter?): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/accounts",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export bills from Firefly III
     * This endpoint allows you to export your bills from Firefly III into a file. Currently supports CSV exports only.
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportBills(type: ExportFileFilter?): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/bills",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export budgets and budget amount data from Firefly III
     * This endpoint allows you to export your budgets and associated budget data from Firefly III into a file. Currently supports CSV exports only.
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportBudgets(type: ExportFileFilter?): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/budgets",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export category data from Firefly III
     * This endpoint allows you to export your categories from Firefly III into a file. Currently supports CSV exports only.
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportCategories(type: ExportFileFilter?): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/categories",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export piggy banks from Firefly III
     * This endpoint allows you to export your piggy banks from Firefly III into a file. Currently supports CSV exports only.
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportPiggies(type: ExportFileFilter?): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/piggy-banks",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export recurring transaction data from Firefly III
     * This endpoint allows you to export your recurring transactions from Firefly III into a file. Currently supports CSV exports only.
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportRecurring(type: ExportFileFilter?): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/recurring",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export rule groups and rule data from Firefly III
     * This endpoint allows you to export your rules and rule groups from Firefly III into a file. Currently supports CSV exports only.
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportRules(type: ExportFileFilter?): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/rules",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export tag data from Firefly III
     * This endpoint allows you to export your tags from Firefly III into a file. Currently supports CSV exports only.
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportTags(type: ExportFileFilter?): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/tags",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

    /**
     * Export transaction data from Firefly III
     * This endpoint allows you to export transactions from Firefly III into a file. Currently supports CSV exports only.
     * @param start A date formatted YYYY-MM-DD.
     * @param end A date formatted YYYY-MM-DD.
     * @param accounts Limit the export of transactions to these accounts only. Only asset accounts will be accepted. Other types will be silently dropped.  (optional)
     * @param type The file type the export file (CSV is currently the only option). (optional)
     * @return java.io.File
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun exportTransactions(
        start: java.time.LocalDate,
        end: java.time.LocalDate,
        accounts: kotlin.String?,
        type: ExportFileFilter?
    ): HttpResponse<java.io.File> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        start.apply { localVariableQuery["start"] = listOf("$start") }
        end.apply { localVariableQuery["end"] = listOf("$end") }
        accounts?.apply { localVariableQuery["accounts"] = listOf("$accounts") }
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/data/export/transactions",
            query = localVariableQuery,
            headers = localVariableHeaders
        )

        return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
        ).wrap()
    }

}