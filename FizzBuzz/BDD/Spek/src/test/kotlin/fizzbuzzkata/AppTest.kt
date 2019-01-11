/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package fizzbuzzkata

import kotlin.test.Test
import kotlin.test.assertNotNull
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

object AppTest: Spek ({
	group( "Top-Level Specs" ) {
		describe ("StringFor Input") {
			it("Given any input, when we ask whether it is Fizz or Buzz, then return Input as String") {
				val input = 1
				val expected = "1"

				val actual = FizzBuzz.stringFor(input)

				assertEquals(expected, actual)
			}

			context("when input is integer less than 1") {
				val input = 0
				it("throw IntegerLessThanOneException") {
					assertThrows<IntegerLessThanOneException> { FizzBuzz.stringFor(input) }
				}
			}
		}
	}
})
