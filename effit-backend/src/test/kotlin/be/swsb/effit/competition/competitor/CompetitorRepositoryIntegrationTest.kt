package be.swsb.effit.competition.competitor

import be.swsb.effit.challenge.Challenge
import be.swsb.effit.competition.Competitor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
@AutoConfigureTestEntityManager
class CompetitorRepositoryIntegrationTest {

    @Autowired
    lateinit var competitorRepository : CompetitorRepository
    @Autowired
    lateinit var testEntityManager: TestEntityManager

    @Test
    fun `A Competitor can be persisted and retrieved`() {
        val snarf = Competitor(name = "Snarf")

        competitorRepository.save(snarf)
        testEntityManager.flush()
        testEntityManager.clear()

        assertThat(testEntityManager.find(Competitor::class.java, snarf.id)).isEqualTo(snarf)
    }

    @Test
    fun `A Competitor can have completed Challenges`() {
        val challenge = Challenge(name = "whinge", points = 4, description = "whatevs")
        testEntityManager.persistAndFlush(challenge)
        val anotherChallenge = Challenge(name = "whinge", points = 4, description = "different challenge")
        testEntityManager.persistAndFlush(anotherChallenge)

        val snarf = Competitor(name = "Snarf")
        competitorRepository.save(snarf)
        testEntityManager.flush()
        testEntityManager.clear()

        snarf.completeChallenge(challenge)
        competitorRepository.save(snarf)
        testEntityManager.flush()
        testEntityManager.clear()

        val fetchedSnarf = testEntityManager.find(Competitor::class.java, snarf.id)
        assertThat(fetchedSnarf.completedChallenges)
                .containsExactly(challenge)
                .doesNotContain(anotherChallenge)
    }
}