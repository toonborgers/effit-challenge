package be.swsb.effit.challenge

import org.assertj.core.api.Assertions

class ChallengeTest {

    fun `should fail with negative points`() {
        Assertions.assertThatThrownBy {
            Challenge(name = "Playboy", points = -7, description = "ride down a slope with exposed torso")
        }.isInstanceOf(IllegalStateException::class.java)
        .hasMessage("Cannot create a Challenge with negative points")
    }

    fun `should fail with 0 points`() {
        Assertions.assertThatThrownBy {
            Challenge(name = "Playboy", points = 0, description = "ride down a slope with exposed torso")
        }.isInstanceOf(IllegalStateException::class.java)
                .hasMessage("Cannot create a Challenge with 0 points")
    }
}