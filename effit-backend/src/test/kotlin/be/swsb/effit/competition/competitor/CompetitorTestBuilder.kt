package be.swsb.effit.competition.competitor

import be.swsb.effit.challenge.Challenge
import org.assertj.core.internal.bytebuddy.utility.RandomString
import java.util.*

fun Competitor.Companion.defaultCompetitorForTest(
        id: UUID = UUID.randomUUID(),
        name: String = RandomString.make(),
        completedChallenges: List<Challenge> = emptyList()
) : Competitor {
    val competitor = Competitor(id = id, name = name)
    completedChallenges.forEach { competitor.completeChallenge(it) }
    return competitor
}