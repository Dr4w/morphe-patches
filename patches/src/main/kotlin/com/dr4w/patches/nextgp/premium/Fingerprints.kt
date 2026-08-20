package com.dr4w.patches.nextgp.premium

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.fieldAccess
import app.morphe.patcher.opcode
import com.android.tools.smali.dexlib2.Opcode

object PremiumUpdateFingerprint : Fingerprint(
    definingClass = "Lcom/jscti/commons/ui/premium/PremiumState;",
    name = "update",
    returnType = "V",
    parameters = listOf("Z"),
    filters = listOf(
        fieldAccess(
            opcode = Opcode.SGET_OBJECT,
            definingClass = "Lcom/jscti/commons/ui/premium/PremiumState;",
            name = "_isPremiumFlow"
        ),
        opcode(Opcode.IF_NEZ),
        opcode(Opcode.RETURN_VOID)
    )
)