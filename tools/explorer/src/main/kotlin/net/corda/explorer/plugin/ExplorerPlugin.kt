package net.corda.explorer.plugin

import net.corda.core.contracts.Amount
import net.corda.core.identity.Party
import net.corda.core.node.CordaPluginRegistry
import net.corda.core.serialization.OpaqueBytes
import net.corda.flows.IssuerFlow
import java.util.function.Function

class ExplorerPlugin : CordaPluginRegistry() {
    // A list of flow that are required for this cordapp
    override val requiredFlows: Map<String, Set<String>> = mapOf(IssuerFlow.IssuanceRequester::class.java.name to setOf(Amount::class.java.name, Party::class.java.name, OpaqueBytes::class.java.name, Party::class.java.name))
    override val servicePlugins = listOf(Function(IssuerFlow.Issuer::Service))
}
