package cl.uchile.dcc
package test

import gwent.model.cards.effects.uniteffect.{NullEffectUnit, RefuerzoMoral, VinculoEstrecho}
import gwent.model.cards.effects.weathereffect.{ClimaDespejadoEffect, EscarchaMordienteEffect, LluviaTorrencialEffect, NieblaImpenetrableEffect}

class EffectTest extends munit.FunSuite {

  test("every single effect is equal to himself"){
    assert(NullEffectUnit.equals(NullEffectUnit))
    assert(RefuerzoMoral.equals(RefuerzoMoral))
    assert(VinculoEstrecho.equals(VinculoEstrecho))
    assert(ClimaDespejadoEffect.equals(ClimaDespejadoEffect))
    assert(EscarchaMordienteEffect.equals(EscarchaMordienteEffect))
    assert(LluviaTorrencialEffect.equals(LluviaTorrencialEffect))
    assert(NieblaImpenetrableEffect.equals(NieblaImpenetrableEffect))
  }

  test("to string of every effect"){
    NullEffectUnit.toString
    RefuerzoMoral.toString
    VinculoEstrecho.toString
    ClimaDespejadoEffect.toString()
    EscarchaMordienteEffect.toString()
    LluviaTorrencialEffect.toString()
    NieblaImpenetrableEffect.toString()
  }

  test("comparing two weather effects that are not equal") {
    assertEquals(EscarchaMordienteEffect.equals(LluviaTorrencialEffect), false)
  }

  test("comparing two effect that are not equal") {
    assertEquals(NullEffectUnit.equals(NieblaImpenetrableEffect), false)
  }
  test("comparing two unit effect  that are not equal"){
    assertEquals(NullEffectUnit.equals(RefuerzoMoral), false)
  }

  test("hashCoding"){
    NullEffectUnit.hashCode()
    ClimaDespejadoEffect.hashCode()
   }
  
  test("apply all effects"){
    ClimaDespejadoEffect.applyEffect()
    EscarchaMordienteEffect.applyEffect()
    LluviaTorrencialEffect.applyEffect()
    NieblaImpenetrableEffect.applyEffect()
    NullEffectUnit.applyEffect()
    RefuerzoMoral.applyEffect()
    VinculoEstrecho.applyEffect()
  }

}
