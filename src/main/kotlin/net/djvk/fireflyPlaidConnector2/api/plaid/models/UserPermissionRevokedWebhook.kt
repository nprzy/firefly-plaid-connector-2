/**
 * The Plaid API
 *
 * The Plaid REST API. Please see https://plaid.com/docs/api for more details.
 *
 * The version of the OpenAPI document: 2020-09-14_1.164.8
 *
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

package net.djvk.fireflyPlaidConnector2.api.plaid.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * The `USER_PERMISSION_REVOKED` webhook is fired when an end user has used either the [my.plaid.com portal](https://my.plaid.com) or the financial institution’s consent portal to revoke the permission that they previously granted to access an Item. Once access to an Item has been revoked, it cannot be restored. If the user subsequently returns to your application, a new Item must be created for the user.
 *
 * @param webhookType `ITEM`
 * @param webhookCode `USER_PERMISSION_REVOKED`
 * @param itemId The `item_id` of the Item associated with this webhook, warning, or error
 * @param error
 */

data class UserPermissionRevokedWebhook(

    /* `ITEM` */
    @field:JsonProperty("webhook_type")
    val webhookType: kotlin.String,

    /* `USER_PERMISSION_REVOKED` */
    @field:JsonProperty("webhook_code")
    val webhookCode: kotlin.String,

    /* The `item_id` of the Item associated with this webhook, warning, or error */
    @field:JsonProperty("item_id")
    val itemId: kotlin.String,

    @field:JsonProperty("error")
    val error: PlaidError? = null

) : kotlin.collections.HashMap<String, kotlin.Any>()
