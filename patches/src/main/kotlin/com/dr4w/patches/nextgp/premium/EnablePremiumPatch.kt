package com.dr4w.patches.nextgp.premium

import app.morphe.patcher.extensions.InstructionExtensions.replaceInstructions
import app.morphe.patcher.patch.bytecodePatch
import com.dr4w.patches.nextgp.shared.Constants.COMPATIBILITY_NEXTGP

@Suppress("unused")
val enablePremiumPatch = bytecodePatch(
    name = "Enable Premium",
    description = "Forces premium state to always be active.",
    default = true
) {
    compatibleWith(COMPATIBILITY_NEXTGP)

    execute {
        PremiumUpdateFingerprint.method.replaceInstructions(
            0,
            """
                const/4 v0, 0x1
                invoke-virtual {p0, v0}, Lcom/jscti/commons/ui/premium/PremiumState;->update(Z)V
                return-void
            """
        )
    }
}