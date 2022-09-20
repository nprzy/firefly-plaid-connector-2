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
import net.djvk.fireflyPlaidConnector2.api.firefly.models.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
open class AutocompleteApi(
    @Value("\${fireflyPlaidConnector2.firefly.url}")
    baseUrl: String = ApiClient.BASE_URL,
    httpClientEngine: HttpClientEngine? = null,
    httpClientConfig: ((HttpClientConfig<*>) -> Unit)? = null,
    jsonBlock: ObjectMapper.() -> Unit = ApiClient.JSON_DEFAULT,
) : ApiClient(baseUrl, httpClientEngine, httpClientConfig, jsonBlock) {

    /**
     * Returns all accounts of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query for accounts. (optional)
     * @param limit The number of items returned. (optional)
     * @param date If the account is an asset account or a liability, the autocomplete will also return the balance of the account on this date. (optional)
     * @param type Optional filter on the account type(s) used in the autocomplete. (optional)
     * @return kotlin.collections.List<AutocompleteAccount>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getAccountsAC(
        query: kotlin.String?,
        limit: kotlin.Int?,
        date: kotlin.String?,
        type: AccountTypeFilter?
    ): HttpResponse<kotlin.collections.List<AutocompleteAccount>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }
        date?.apply { localVariableQuery["date"] = listOf("$date") }
        type?.apply { localVariableQuery["type"] = listOf("$type") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/accounts",
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
     * Returns all bills of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query for bills. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteBill>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getBillsAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteBill>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/bills",
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
     * Returns all budgets of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned (optional)
     * @return kotlin.collections.List<AutocompleteBudget>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getBudgetsAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteBudget>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/budgets",
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
     * Returns all categories of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteCategory>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getCategoriesAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteCategory>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/categories",
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
     * Returns all currencies of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteCurrency>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getCurrenciesAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteCurrency>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/currencies",
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
     * Returns all currencies of the user returned in a basic auto-complete array. This endpoint is DEPRECATED and I suggest you DO NOT use it.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteCurrencyCode>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getCurrenciesCodeAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteCurrencyCode>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/currencies-with-code",
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
     * Returns all object groups of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteObjectGroup>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getObjectGroupsAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteObjectGroup>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/object-groups",
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
     * Returns all piggy banks of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompletePiggy>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getPiggiesAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompletePiggy>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/piggy-banks",
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
     * Returns all piggy banks of the user returned in a basic auto-complete array complemented with balance information.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompletePiggyBalance>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getPiggiesBalanceAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompletePiggyBalance>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/piggy-banks-with-balance",
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
     * Returns all recurring transactions of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteRecurrence>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getRecurringAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteRecurrence>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/recurring",
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
     * Returns all rule groups of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteRuleGroup>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getRuleGroupsAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteRuleGroup>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/rule-groups",
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
     * Returns all rules of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteRule>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getRulesAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteRule>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/rules",
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
     * Returns all tags of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteTag>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getTagAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteTag>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/tags",
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
     * Returns all transaction types returned in a basic auto-complete array. English only.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteTransactionType>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getTransactionTypesAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteTransactionType>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/transaction-types",
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
     * Returns all transaction descriptions of the user returned in a basic auto-complete array.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteTransaction>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getTransactionsAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteTransaction>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/transactions",
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
     * Returns all transactions, complemented with their ID, of the user returned in a basic auto-complete array. This endpoint is DEPRECATED and I suggest you DO NOT use it.
     *
     * @param query The autocomplete search query. (optional)
     * @param limit The number of items returned. (optional)
     * @return kotlin.collections.List<AutocompleteTransactionID>
     */
    @Suppress("UNCHECKED_CAST")
    open suspend fun getTransactionsIDAC(
        query: kotlin.String?,
        limit: kotlin.Int?
    ): HttpResponse<kotlin.collections.List<AutocompleteTransactionID>> {

        val localVariableAuthNames = listOf<String>("firefly_iii_auth")

        val localVariableBody =
            io.ktor.client.utils.EmptyContent

        val localVariableQuery = mutableMapOf<String, List<String>>()
        query?.apply { localVariableQuery["query"] = listOf("$query") }
        limit?.apply { localVariableQuery["limit"] = listOf("$limit") }

        val localVariableHeaders = mutableMapOf<String, String>()

        val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/api/v1/autocomplete/transactions-with-id",
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
