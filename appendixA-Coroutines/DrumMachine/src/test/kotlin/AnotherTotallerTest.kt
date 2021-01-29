import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.*
import io.kotlintest.specs.StringSpec

class AnotherTotallerTest : StringSpec( {
    "should be able to add 3 and 4 - and it mustn't go wrong" {
        val totaller = Totaller()

        totaller.add(3) shouldBe 3
        totaller.add(4) shouldBe 7
        totaller.total shouldBe 7
    }

    "should be able to add lots of different numbers" {
        val table = table(
            headers("x", "y", "expectedTotal"),
            row(1, 2, 3),
            row(19, 47, 66),
            row(11, 21, 32)
        )
        forAll(
            table
        ) {
            x, y, expectedTotal ->
            val totaller = Totaller(x)
            totaller.add(y) shouldBe expectedTotal
        }
    }
} )