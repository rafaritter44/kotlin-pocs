package org.example.guitarfactory

import org.example.guitarfactory.domain.Guitar
import org.example.guitarfactory.domain.GuitarModel
import org.example.guitarfactory.domain.GuitarOS
import org.example.guitarfactory.domain.GuitarSpecs
import kotlin.test.Test

class InventoryTest {
    @Test fun inventoryWorks() {
        val guitar1 = Guitar(
            model = GuitarModel.STRATOCASTER,
            specs = GuitarSpecs(numberOfStrings = 4, "White"),
            os = GuitarOS.Smart("1.2.0"),
        )
        val guitar2 = Guitar(
            model = GuitarModel.LES_PAUL,
            specs = GuitarSpecs(numberOfStrings = 6, "Black"),
            os = GuitarOS.Digital,
        )
        Inventory.add(guitar1)
        Inventory.add(guitar2)
        println(Inventory.all)

        Inventory.remove(guitar1)
        println(Inventory.all)

        println(Inventory.get(guitar1.id))
        println(Inventory.get(guitar2.id))
    }
}