package cl.uchile.dcc
package test

import gwent.model.cards.effects.uniteffect.{NullEffectUnit, RefuerzoMoral, VinculoEstrecho}
import gwent.model.cards.effects.weathereffect.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable}

class EffectTest extends munit.FunSuite {

  test("every single effect is equal to himself"){
    assert(NullEffectUnit.equals(NullEffectUnit))
    assert(RefuerzoMoral.equals(RefuerzoMoral))
    assert(VinculoEstrecho.equals(VinculoEstrecho))

    assert(ClimaDespejado.equals(ClimaDespejado))
    assert(EscarchaMordiente.equals(EscarchaMordiente))
    assert(LluviaTorrencial.equals(LluviaTorrencial))
    assert(NieblaImpenetrable.equals(NieblaImpenetrable))
  }

  test("comparing two effect that are not equal"){
    assertEquals(NullEffectUnit.equals(RefuerzoMoral), false)
  }
}
