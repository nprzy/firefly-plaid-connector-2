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
 * Information about the last webhook fired for the Item.
 *
 * @param sentAt [ISO 8601](https://wikipedia.org/wiki/ISO_8601) timestamp of when the webhook was fired.
 * @param codeSent The last webhook code sent.
 */

data class ItemStatusLastWebhook(

    /* [ISO 8601](https://wikipedia.org/wiki/ISO_8601) timestamp of when the webhook was fired.  */
    @field:JsonProperty("sent_at")
    val sentAt: java.time.OffsetDateTime? = null,

    /* The last webhook code sent. */
    @field:JsonProperty("code_sent")
    val codeSent: kotlin.String? = null

) : kotlin.collections.HashMap<String, kotlin.Any>()
